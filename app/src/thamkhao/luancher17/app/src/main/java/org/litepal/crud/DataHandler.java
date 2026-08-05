package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.litepal.LitePal;
import org.litepal.LitePalBase;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.cipher.CipherUtil;

/* JADX INFO: loaded from: classes.dex */
abstract class DataHandler extends LitePalBase {
    public static final String TAG = "DataHandler";
    private List<AssociationsInfo> fkInCurrentModel;
    private List<AssociationsInfo> fkInOtherModel;
    SQLiteDatabase mDatabase;
    private LitePalSupport tempEmptyModel;

    DataHandler() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b0  */
    protected <T> List<T> query(Class<T> modelClass, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit, List<AssociationsInfo> foreignKeyAssociations) throws Throwable {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        try {
            List<Field> supportedFields = getSupportedFields(modelClass.getName());
            List<Field> supportedGenericFields = getSupportedGenericFields(modelClass.getName());
            String[] customizedColumns = DBUtility.convertSelectClauseToValidNames(getCustomizedColumns(columns, supportedGenericFields, foreignKeyAssociations));
            String tableName = getTableName(modelClass);
            cursor = this.mDatabase.query(tableName, customizedColumns, selection, selectionArgs, groupBy, having, orderBy, limit);
            try {
                try {
                    if (cursor.moveToFirst()) {
                        SparseArray<QueryInfoCache> queryInfoCacheSparseArray = new SparseArray<>();
                        Map<Field, GenericModel> genericModelMap = new HashMap<>();
                        do {
                            Object objCreateInstanceFromClass = createInstanceFromClass(modelClass);
                            giveBaseObjIdValue((LitePalSupport) objCreateInstanceFromClass, cursor.getLong(cursor.getColumnIndexOrThrow("id")));
                            setValueToModel(objCreateInstanceFromClass, supportedFields, foreignKeyAssociations, cursor, queryInfoCacheSparseArray);
                            setGenericValueToModel((LitePalSupport) objCreateInstanceFromClass, supportedGenericFields, genericModelMap);
                            if (foreignKeyAssociations != null) {
                                setAssociatedModel((LitePalSupport) objCreateInstanceFromClass);
                            }
                            arrayList.add(objCreateInstanceFromClass);
                        } while (cursor.moveToNext());
                        queryInfoCacheSparseArray.clear();
                        genericModelMap.clear();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                throw new LitePalSupportException(e.getMessage(), e);
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    protected <T> T mathQuery(String str, String[] strArr, String[] strArr2, Class<T> cls) {
        BaseUtility.checkConditionsCorrect(strArr2);
        Cursor cursorQuery = null;
        T t = (T) null;
        try {
            try {
                cursorQuery = this.mDatabase.query(str, strArr, getWhereClause(strArr2), getWhereArgs(strArr2), null, null, null);
                if (cursorQuery.moveToFirst()) {
                    t = (T) cursorQuery.getClass().getMethod(genGetColumnMethod((Class<?>) cls), Integer.TYPE).invoke(cursorQuery, 0);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return t;
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    protected void giveBaseObjIdValue(LitePalSupport baseObj, long id) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (id > 0) {
            DynamicExecutor.set(baseObj, "baseObjId", Long.valueOf(id), LitePalSupport.class);
        }
    }

    protected void putFieldsValue(LitePalSupport baseObj, List<Field> supportedFields, ContentValues values) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        for (Field field : supportedFields) {
            if (!isIdColumn(field.getName())) {
                putFieldsValueDependsOnSaveOrUpdate(baseObj, field, values);
            }
        }
    }

    protected void putContentValuesForSave(LitePalSupport baseObj, Field field, ContentValues values) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object fieldValue = DynamicExecutor.getField(baseObj, field.getName(), baseObj.getClass());
        if (fieldValue != null) {
            if ("java.util.Date".equals(field.getType().getName())) {
                Date date = (Date) fieldValue;
                fieldValue = Long.valueOf(date.getTime());
            }
            Encrypt annotation = (Encrypt) field.getAnnotation(Encrypt.class);
            if (annotation != null && "java.lang.String".equals(field.getType().getName())) {
                fieldValue = encryptValue(annotation.algorithm(), fieldValue);
            }
            Object[] parameters = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), fieldValue};
            DynamicExecutor.send(values, "put", parameters, values.getClass(), getParameterTypes(field, fieldValue, parameters));
        }
    }

    protected void putContentValuesForUpdate(LitePalSupport baseObj, Field field, ContentValues values) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object fieldValue = getFieldValue(baseObj, field);
        if ("java.util.Date".equals(field.getType().getName()) && fieldValue != null) {
            Date date = (Date) fieldValue;
            fieldValue = Long.valueOf(date.getTime());
        }
        Encrypt annotation = (Encrypt) field.getAnnotation(Encrypt.class);
        if (annotation != null && "java.lang.String".equals(field.getType().getName())) {
            fieldValue = encryptValue(annotation.algorithm(), fieldValue);
        }
        Object[] parameters = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), fieldValue};
        DynamicExecutor.send(values, "put", parameters, values.getClass(), getParameterTypes(field, fieldValue, parameters));
    }

    protected Object encryptValue(String algorithm, Object fieldValue) {
        if (algorithm != null && fieldValue != null) {
            if ("AES".equalsIgnoreCase(algorithm)) {
                return CipherUtil.aesEncrypt((String) fieldValue);
            }
            if ("MD5".equalsIgnoreCase(algorithm)) {
                return CipherUtil.md5Encrypt((String) fieldValue);
            }
            return fieldValue;
        }
        return fieldValue;
    }

    protected Object getFieldValue(LitePalSupport dataSupport, Field field) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (shouldGetOrSet(dataSupport, field)) {
            return DynamicExecutor.getField(dataSupport, field.getName(), dataSupport.getClass());
        }
        return null;
    }

    protected void setFieldValue(LitePalSupport dataSupport, Field field, Object parameter) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (shouldGetOrSet(dataSupport, field)) {
            DynamicExecutor.setField(dataSupport, field.getName(), parameter, dataSupport.getClass());
        }
    }

    protected void analyzeAssociatedModels(LitePalSupport baseObj, Collection<AssociationsInfo> associationInfos) {
        try {
            for (AssociationsInfo associationInfo : associationInfos) {
                if (associationInfo.getAssociationType() == 2) {
                    new Many2OneAnalyzer().analyze(baseObj, associationInfo);
                } else if (associationInfo.getAssociationType() == 1) {
                    new One2OneAnalyzer().analyze(baseObj, associationInfo);
                } else if (associationInfo.getAssociationType() == 3) {
                    new Many2ManyAnalyzer().analyze(baseObj, associationInfo);
                }
            }
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    protected LitePalSupport getAssociatedModel(LitePalSupport baseObj, AssociationsInfo associationInfo) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (LitePalSupport) getFieldValue(baseObj, associationInfo.getAssociateOtherModelFromSelf());
    }

    protected Collection<LitePalSupport> getAssociatedModels(LitePalSupport baseObj, AssociationsInfo associationInfo) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (Collection) getFieldValue(baseObj, associationInfo.getAssociateOtherModelFromSelf());
    }

    protected LitePalSupport getEmptyModel(LitePalSupport baseObj) {
        if (this.tempEmptyModel != null) {
            return this.tempEmptyModel;
        }
        String className = null;
        try {
            className = baseObj.getClassName();
            Class<?> modelClass = Class.forName(className);
            this.tempEmptyModel = (LitePalSupport) modelClass.newInstance();
            return this.tempEmptyModel;
        } catch (ClassNotFoundException e) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + className);
        } catch (InstantiationException e2) {
            throw new LitePalSupportException(String.valueOf(className) + LitePalSupportException.INSTANTIATION_EXCEPTION, e2);
        } catch (Exception e3) {
            throw new LitePalSupportException(e3.getMessage(), e3);
        }
    }

    protected String getWhereClause(String... conditions) {
        if (isAffectAllLines(conditions) || conditions == null || conditions.length <= 0) {
            return null;
        }
        return conditions[0];
    }

    protected String[] getWhereArgs(String... conditions) {
        if (isAffectAllLines(conditions) || conditions == null || conditions.length <= 1) {
            return null;
        }
        String[] whereArgs = new String[conditions.length - 1];
        System.arraycopy(conditions, 1, whereArgs, 0, conditions.length - 1);
        return whereArgs;
    }

    protected boolean isAffectAllLines(Object... conditions) {
        return conditions != null && conditions.length == 0;
    }

    protected String getWhereOfIdsWithOr(Collection<Long> ids) {
        StringBuilder whereClause = new StringBuilder();
        boolean needOr = false;
        Iterator<Long> it = ids.iterator();
        while (it.hasNext()) {
            long id = it.next().longValue();
            if (needOr) {
                whereClause.append(" or ");
            }
            needOr = true;
            whereClause.append("id = ");
            whereClause.append(id);
        }
        return BaseUtility.changeCase(whereClause.toString());
    }

    protected String getWhereOfIdsWithOr(long... ids) {
        StringBuilder whereClause = new StringBuilder();
        boolean needOr = false;
        for (long id : ids) {
            if (needOr) {
                whereClause.append(" or ");
            }
            needOr = true;
            whereClause.append("id = ");
            whereClause.append(id);
        }
        return BaseUtility.changeCase(whereClause.toString());
    }

    protected boolean shouldGetOrSet(LitePalSupport dataSupport, Field field) {
        return (dataSupport == null || field == null) ? false : true;
    }

    protected String getIntermediateTableName(LitePalSupport baseObj, String associatedTableName) {
        return BaseUtility.changeCase(DBUtility.getIntermediateTableName(baseObj.getTableName(), associatedTableName));
    }

    protected String getTableName(Class<?> modelClass) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName()));
    }

    protected Object createInstanceFromClass(Class<?> modelClass) {
        try {
            Constructor<?> constructor = findBestSuitConstructor(modelClass);
            return constructor.newInstance(getConstructorParams(modelClass, constructor));
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    protected Constructor<?> findBestSuitConstructor(Class<?> modelClass) {
        Constructor<?>[] declaredConstructors = modelClass.getDeclaredConstructors();
        SparseArray<Constructor<?>> map = new SparseArray<>();
        int minKey = Integer.MAX_VALUE;
        for (Constructor<?> constructor : declaredConstructors) {
            int key = constructor.getParameterTypes().length;
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                if (parameterType == modelClass) {
                    key += 10000;
                } else if (parameterType.getName().startsWith("com.android") && parameterType.getName().endsWith("InstantReloadException")) {
                    key += 10000;
                }
            }
            if (map.get(key) == null) {
                map.put(key, constructor);
            }
            if (key < minKey) {
                minKey = key;
            }
        }
        Constructor<?> bestSuitConstructor = map.get(minKey);
        if (bestSuitConstructor != null) {
            bestSuitConstructor.setAccessible(true);
        }
        return bestSuitConstructor;
    }

    protected Object[] getConstructorParams(Class<?> modelClass, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] params = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            params[i] = getInitParamValue(modelClass, parameterTypes[i]);
        }
        return params;
    }

    protected void setValueToModel(Object modelInstance, List<Field> supportedFields, List<AssociationsInfo> foreignKeyAssociations, Cursor cursor, SparseArray<QueryInfoCache> sparseArray) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int cacheSize = sparseArray.size();
        if (cacheSize > 0) {
            for (int i = 0; i < cacheSize; i++) {
                int columnIndex = sparseArray.keyAt(i);
                QueryInfoCache cache = sparseArray.get(columnIndex);
                setToModelByReflection(modelInstance, cache.field, columnIndex, cache.getMethodName, cursor);
            }
        } else {
            for (Field field : supportedFields) {
                String getMethodName = genGetColumnMethod(field);
                String columnName = isIdColumn(field.getName()) ? "id" : DBUtility.convertToValidColumnName(field.getName());
                int columnIndex2 = cursor.getColumnIndex(BaseUtility.changeCase(columnName));
                if (columnIndex2 != -1) {
                    setToModelByReflection(modelInstance, field, columnIndex2, getMethodName, cursor);
                    QueryInfoCache cache2 = new QueryInfoCache();
                    cache2.getMethodName = getMethodName;
                    cache2.field = field;
                    sparseArray.put(columnIndex2, cache2);
                }
            }
        }
        if (foreignKeyAssociations != null) {
            for (AssociationsInfo associationInfo : foreignKeyAssociations) {
                String foreignKeyColumn = getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationInfo.getAssociatedClassName()));
                int columnIndex3 = cursor.getColumnIndex(foreignKeyColumn);
                if (columnIndex3 != -1) {
                    long associatedClassId = cursor.getLong(columnIndex3);
                    try {
                        LitePalSupport associatedObj = (LitePalSupport) LitePal.find(Class.forName(associationInfo.getAssociatedClassName()), associatedClassId);
                        if (associatedObj != null) {
                            setFieldValue((LitePalSupport) modelInstance, associationInfo.getAssociateOtherModelFromSelf(), associatedObj);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    protected void setGenericValueToModel(LitePalSupport baseObj, List<Field> supportedGenericFields, Map<Field, GenericModel> genericModelMap) throws Throwable {
        String tableName;
        String genericValueColumnName;
        String genericValueIdColumnName;
        String getMethodName;
        Cursor cursor;
        for (Field field : supportedGenericFields) {
            GenericModel genericModel = genericModelMap.get(field);
            if (genericModel == null) {
                String genericTypeName = getGenericTypeName(field);
                if (baseObj.getClassName().equals(genericTypeName)) {
                    genericValueColumnName = DBUtility.getM2MSelfRefColumnName(field);
                    getMethodName = "getLong";
                } else {
                    genericValueColumnName = DBUtility.convertToValidColumnName(field.getName());
                    getMethodName = genGetColumnMethod(field);
                }
                tableName = DBUtility.getGenericTableName(baseObj.getClassName(), field.getName());
                genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(baseObj.getClassName());
                GenericModel model = new GenericModel();
                model.setTableName(tableName);
                model.setValueColumnName(genericValueColumnName);
                model.setValueIdColumnName(genericValueIdColumnName);
                model.setGetMethodName(getMethodName);
                genericModelMap.put(field, model);
            } else {
                tableName = genericModel.getTableName();
                genericValueColumnName = genericModel.getValueColumnName();
                genericValueIdColumnName = genericModel.getValueIdColumnName();
                getMethodName = genericModel.getGetMethodName();
            }
            try {
                cursor = this.mDatabase.query(tableName, null, String.valueOf(genericValueIdColumnName) + " = ?", new String[]{String.valueOf(baseObj.getBaseObjId())}, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            int columnIndex = cursor.getColumnIndex(BaseUtility.changeCase(genericValueColumnName));
                            if (columnIndex != -1) {
                                setToModelByReflection(baseObj, field, columnIndex, getMethodName, cursor);
                            }
                        } while (cursor.moveToNext());
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
    }

    protected List<AssociationsInfo> getForeignKeyAssociations(String className, boolean isEager) {
        if (!isEager) {
            return null;
        }
        analyzeAssociations(className);
        return this.fkInCurrentModel;
    }

    protected Class<?>[] getParameterTypes(Field field, Object fieldValue, Object[] parameters) {
        if (isCharType(field)) {
            parameters[1] = String.valueOf(fieldValue);
            return new Class[]{String.class, String.class};
        }
        if (field.getType().isPrimitive()) {
            return new Class[]{String.class, getObjectType(field.getType())};
        }
        if ("java.util.Date".equals(field.getType().getName())) {
            return new Class[]{String.class, Long.class};
        }
        return new Class[]{String.class, field.getType()};
    }

    private Class<?> getObjectType(Class<?> primitiveType) {
        if (primitiveType != null && primitiveType.isPrimitive()) {
            String basicTypeName = primitiveType.getName();
            if ("int".equals(basicTypeName)) {
                return Integer.class;
            }
            if ("short".equals(basicTypeName)) {
                return Short.class;
            }
            if ("long".equals(basicTypeName)) {
                return Long.class;
            }
            if ("float".equals(basicTypeName)) {
                return Float.class;
            }
            if ("double".equals(basicTypeName)) {
                return Double.class;
            }
            if ("boolean".equals(basicTypeName)) {
                return Boolean.class;
            }
            if ("char".equals(basicTypeName)) {
                return Character.class;
            }
        }
        return null;
    }

    private Object getInitParamValue(Class<?> modelClass, Class<?> paramType) {
        String paramTypeName = paramType.getName();
        if ("boolean".equals(paramTypeName) || "java.lang.Boolean".equals(paramTypeName)) {
            return false;
        }
        if ("float".equals(paramTypeName) || "java.lang.Float".equals(paramTypeName)) {
            return Float.valueOf(0.0f);
        }
        if ("double".equals(paramTypeName) || "java.lang.Double".equals(paramTypeName)) {
            return Double.valueOf(0.0d);
        }
        if ("int".equals(paramTypeName) || "java.lang.Integer".equals(paramTypeName)) {
            return 0;
        }
        if ("long".equals(paramTypeName) || "java.lang.Long".equals(paramTypeName)) {
            return 0L;
        }
        if ("short".equals(paramTypeName) || "java.lang.Short".equals(paramTypeName)) {
            return 0;
        }
        if ("char".equals(paramTypeName) || "java.lang.Character".equals(paramTypeName)) {
            return ' ';
        }
        if ("[B".equals(paramTypeName) || "[Ljava.lang.Byte;".equals(paramTypeName)) {
            return new byte[0];
        }
        if ("java.lang.String".equals(paramTypeName)) {
            return "";
        }
        if (modelClass == paramType) {
            return null;
        }
        return createInstanceFromClass(paramType);
    }

    private boolean isCharType(Field field) {
        String type = field.getType().getName();
        return type.equals("char") || type.endsWith("Character");
    }

    private boolean isPrimitiveBooleanType(Field field) {
        Class<?> fieldType = field.getType();
        return "boolean".equals(fieldType.getName());
    }

    private void putFieldsValueDependsOnSaveOrUpdate(LitePalSupport baseObj, Field field, ContentValues values) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (isUpdating()) {
            if (!isFieldWithDefaultValue(baseObj, field)) {
                putContentValuesForUpdate(baseObj, field, values);
            }
        } else if (isSaving()) {
            putContentValuesForSave(baseObj, field, values);
        }
    }

    private boolean isUpdating() {
        return UpdateHandler.class.getName().equals(getClass().getName());
    }

    private boolean isSaving() {
        return SaveHandler.class.getName().equals(getClass().getName());
    }

    private boolean isFieldWithDefaultValue(LitePalSupport baseObj, Field field) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        LitePalSupport emptyModel = getEmptyModel(baseObj);
        Object realReturn = getFieldValue(baseObj, field);
        Object defaultReturn = getFieldValue(emptyModel, field);
        if (realReturn == null || defaultReturn == null) {
            return realReturn == defaultReturn;
        }
        String realFieldValue = realReturn.toString();
        String defaultFieldValue = defaultReturn.toString();
        return realFieldValue.equals(defaultFieldValue);
    }

    private String makeGetterMethodName(Field field) {
        String getterMethodPrefix;
        String fieldName = field.getName();
        if (isPrimitiveBooleanType(field)) {
            if (fieldName.matches("^is[A-Z]{1}.*$")) {
                fieldName = fieldName.substring(2);
            }
            getterMethodPrefix = "is";
        } else {
            getterMethodPrefix = "get";
        }
        if (fieldName.matches("^[a-z]{1}[A-Z]{1}.*")) {
            return String.valueOf(getterMethodPrefix) + fieldName;
        }
        return String.valueOf(getterMethodPrefix) + BaseUtility.capitalize(fieldName);
    }

    private String makeSetterMethodName(Field field) {
        if (isPrimitiveBooleanType(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            String setterMethodName = String.valueOf("set") + field.getName().substring(2);
            return setterMethodName;
        }
        if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            String setterMethodName2 = String.valueOf("set") + field.getName();
            return setterMethodName2;
        }
        String setterMethodName3 = String.valueOf("set") + BaseUtility.capitalize(field.getName());
        return setterMethodName3;
    }

    private String genGetColumnMethod(Field field) {
        Class<?> fieldType;
        if (isCollection(field.getType())) {
            fieldType = getGenericTypeClass(field);
        } else {
            fieldType = field.getType();
        }
        return genGetColumnMethod(fieldType);
    }

    private String genGetColumnMethod(Class<?> fieldType) {
        String typeName;
        if (fieldType.isPrimitive()) {
            typeName = BaseUtility.capitalize(fieldType.getName());
        } else {
            typeName = fieldType.getSimpleName();
        }
        String methodName = "get" + typeName;
        if ("getBoolean".equals(methodName)) {
            return "getInt";
        }
        if ("getChar".equals(methodName) || "getCharacter".equals(methodName)) {
            return "getString";
        }
        if ("getDate".equals(methodName)) {
            return "getLong";
        }
        if ("getInteger".equals(methodName)) {
            return "getInt";
        }
        if ("getbyte[]".equalsIgnoreCase(methodName)) {
            return "getBlob";
        }
        return methodName;
    }

    private String[] getCustomizedColumns(String[] columns, List<Field> supportedGenericFields, List<AssociationsInfo> foreignKeyAssociations) {
        if (columns != null && columns.length > 0) {
            boolean columnsContainsId = false;
            List<String> convertList = Arrays.asList(columns);
            List<String> columnList = new ArrayList<>(convertList);
            List<String> supportedGenericFieldNames = new ArrayList<>();
            List<Integer> columnToRemove = new ArrayList<>();
            List<String> genericColumnsForQuery = new ArrayList<>();
            List<Field> tempSupportedGenericFields = new ArrayList<>();
            Iterator<Field> it = supportedGenericFields.iterator();
            while (it.hasNext()) {
                supportedGenericFieldNames.add(it.next().getName());
            }
            for (int i = 0; i < columnList.size(); i++) {
                String columnName = columnList.get(i);
                if (BaseUtility.containsIgnoreCases(supportedGenericFieldNames, columnName)) {
                    columnToRemove.add(Integer.valueOf(i));
                } else if (isIdColumn(columnName)) {
                    columnsContainsId = true;
                    if ("_id".equalsIgnoreCase(columnName)) {
                        columnList.set(i, BaseUtility.changeCase("id"));
                    }
                }
            }
            for (int i2 = columnToRemove.size() - 1; i2 >= 0; i2--) {
                int index = columnToRemove.get(i2).intValue();
                String genericColumn = columnList.remove(index);
                genericColumnsForQuery.add(genericColumn);
            }
            for (Field supportedGenericField : supportedGenericFields) {
                String fieldName = supportedGenericField.getName();
                if (BaseUtility.containsIgnoreCases(genericColumnsForQuery, fieldName)) {
                    tempSupportedGenericFields.add(supportedGenericField);
                }
            }
            supportedGenericFields.clear();
            supportedGenericFields.addAll(tempSupportedGenericFields);
            if (foreignKeyAssociations != null && foreignKeyAssociations.size() > 0) {
                for (int i3 = 0; i3 < foreignKeyAssociations.size(); i3++) {
                    String associatedTable = DBUtility.getTableNameByClassName(foreignKeyAssociations.get(i3).getAssociatedClassName());
                    columnList.add(getForeignKeyColumnName(associatedTable));
                }
            }
            if (!columnsContainsId) {
                columnList.add(BaseUtility.changeCase("id"));
            }
            return (String[]) columnList.toArray(new String[columnList.size()]);
        }
        return null;
    }

    private void analyzeAssociations(String className) {
        Collection<AssociationsInfo> associationInfos = getAssociationInfo(className);
        if (this.fkInCurrentModel == null) {
            this.fkInCurrentModel = new ArrayList();
        } else {
            this.fkInCurrentModel.clear();
        }
        if (this.fkInOtherModel == null) {
            this.fkInOtherModel = new ArrayList();
        } else {
            this.fkInOtherModel.clear();
        }
        for (AssociationsInfo associationInfo : associationInfos) {
            if (associationInfo.getAssociationType() == 2 || associationInfo.getAssociationType() == 1) {
                if (associationInfo.getClassHoldsForeignKey().equals(className)) {
                    this.fkInCurrentModel.add(associationInfo);
                } else {
                    this.fkInOtherModel.add(associationInfo);
                }
            } else if (associationInfo.getAssociationType() == 3) {
                this.fkInOtherModel.add(associationInfo);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x01ae  */
    private void setAssociatedModel(LitePalSupport baseObj) throws Throwable {
        Cursor cursor;
        if (this.fkInOtherModel != null) {
            for (AssociationsInfo info : this.fkInOtherModel) {
                String associatedClassName = info.getAssociatedClassName();
                boolean isM2M = info.getAssociationType() == 3;
                try {
                    List<Field> supportedFields = getSupportedFields(associatedClassName);
                    List<Field> supportedGenericFields = getSupportedGenericFields(associatedClassName);
                    if (isM2M) {
                        String tableName = baseObj.getTableName();
                        String associatedTableName = DBUtility.getTableNameByClassName(associatedClassName);
                        String intermediateTableName = DBUtility.getIntermediateTableName(tableName, associatedTableName);
                        StringBuilder sql = new StringBuilder();
                        sql.append("select * from ").append(associatedTableName).append(" a inner join ").append(intermediateTableName).append(" b on a.id = b.").append(String.valueOf(associatedTableName) + "_id").append(" where b.").append(tableName).append("_id = ?");
                        cursor = LitePal.findBySQL(BaseUtility.changeCase(sql.toString()), String.valueOf(baseObj.getBaseObjId()));
                    } else {
                        String foreignKeyColumn = getForeignKeyColumnName(DBUtility.getTableNameByClassName(info.getSelfClassName()));
                        cursor = this.mDatabase.query(BaseUtility.changeCase(DBUtility.getTableNameByClassName(associatedClassName)), null, String.valueOf(foreignKeyColumn) + "=?", new String[]{String.valueOf(baseObj.getBaseObjId())}, null, null, null, null);
                    }
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    SparseArray<QueryInfoCache> queryInfoCacheSparseArray = new SparseArray<>();
                                    Map<Field, GenericModel> genericModelMap = new HashMap<>();
                                    do {
                                        LitePalSupport modelInstance = (LitePalSupport) createInstanceFromClass(Class.forName(associatedClassName));
                                        giveBaseObjIdValue(modelInstance, cursor.getLong(cursor.getColumnIndexOrThrow("id")));
                                        setValueToModel(modelInstance, supportedFields, null, cursor, queryInfoCacheSparseArray);
                                        setGenericValueToModel(modelInstance, supportedGenericFields, genericModelMap);
                                        if (info.getAssociationType() == 2 || isM2M) {
                                            Field field = info.getAssociateOtherModelFromSelf();
                                            Collection collection = (Collection) getFieldValue(baseObj, field);
                                            if (collection == null) {
                                                if (isList(field.getType())) {
                                                    collection = new ArrayList();
                                                } else {
                                                    collection = new HashSet();
                                                }
                                                DynamicExecutor.setField(baseObj, field.getName(), collection, baseObj.getClass());
                                            }
                                            collection.add(modelInstance);
                                        } else if (info.getAssociationType() == 1) {
                                            setFieldValue(baseObj, info.getAssociateOtherModelFromSelf(), modelInstance);
                                        }
                                    } while (cursor.moveToNext());
                                    queryInfoCacheSparseArray.clear();
                                    genericModelMap.clear();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Exception e) {
                            e = e;
                            throw new LitePalSupportException(e.getMessage(), e);
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    private void setToModelByReflection(Object modelInstance, Field field, int columnIndex, String getMethodName, Cursor cursor) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cursorClass = cursor.getClass();
        Method method = cursorClass.getMethod(getMethodName, Integer.TYPE);
        Object value = method.invoke(cursor, Integer.valueOf(columnIndex));
        if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
            if ("0".equals(String.valueOf(value))) {
                value = false;
            } else if ("1".equals(String.valueOf(value))) {
                value = true;
            }
        } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
            value = Character.valueOf(((String) value).charAt(0));
        } else if (field.getType() == Date.class) {
            long date = ((Long) value).longValue();
            value = date <= 0 ? null : new Date(date);
        }
        if (isCollection(field.getType())) {
            Collection<Object> collection = (Collection) DynamicExecutor.getField(modelInstance, field.getName(), modelInstance.getClass());
            if (collection == null) {
                if (isList(field.getType())) {
                    collection = new ArrayList<>();
                } else {
                    collection = new HashSet<>();
                }
                DynamicExecutor.setField(modelInstance, field.getName(), collection, modelInstance.getClass());
            }
            String genericTypeName = getGenericTypeName(field);
            if ("java.lang.String".equals(genericTypeName)) {
                Encrypt annotation = (Encrypt) field.getAnnotation(Encrypt.class);
                if (annotation != null) {
                    value = decryptValue(annotation.algorithm(), value);
                }
            } else if (modelInstance.getClass().getName().equals(genericTypeName) && ((value instanceof Long) || (value instanceof Integer))) {
                value = LitePal.find(modelInstance.getClass(), ((Long) value).longValue());
            }
            collection.add(value);
            return;
        }
        Encrypt annotation2 = (Encrypt) field.getAnnotation(Encrypt.class);
        if (annotation2 != null && "java.lang.String".equals(field.getType().getName())) {
            value = decryptValue(annotation2.algorithm(), value);
        }
        DynamicExecutor.setField(modelInstance, field.getName(), value, modelInstance.getClass());
    }

    protected Object decryptValue(String algorithm, Object fieldValue) {
        if (algorithm != null && fieldValue != null && "AES".equalsIgnoreCase(algorithm)) {
            return CipherUtil.aesDecrypt((String) fieldValue);
        }
        return fieldValue;
    }

    class QueryInfoCache {
        Field field;
        String getMethodName;

        QueryInfoCache() {
        }
    }
}
