package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.LitePal;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public class UpdateHandler extends DataHandler {
    public UpdateHandler(SQLiteDatabase db) {
        this.mDatabase = db;
    }

    int onUpdate(LitePalSupport baseObj, long id) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        List<Field> supportedFields = getSupportedFields(baseObj.getClassName());
        List<Field> supportedGenericFields = getSupportedGenericFields(baseObj.getClassName());
        updateGenericTables(baseObj, supportedGenericFields, id);
        ContentValues values = new ContentValues();
        putFieldsValue(baseObj, supportedFields, values);
        putFieldsToDefaultValue(baseObj, values, id);
        if (values.size() > 0) {
            return this.mDatabase.update(baseObj.getTableName(), values, "id = " + id, null);
        }
        return 0;
    }

    public int onUpdate(Class<?> modelClass, long id, ContentValues values) {
        if (values.size() <= 0) {
            return 0;
        }
        convertContentValues(values);
        return this.mDatabase.update(getTableName(modelClass), values, "id = " + id, null);
    }

    int onUpdateAll(LitePalSupport baseObj, String... conditions) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        BaseUtility.checkConditionsCorrect(conditions);
        if (conditions != null && conditions.length > 0) {
            conditions[0] = DBUtility.convertWhereClauseToColumnName(conditions[0]);
        }
        List<Field> supportedFields = getSupportedFields(baseObj.getClassName());
        List<Field> supportedGenericFields = getSupportedGenericFields(baseObj.getClassName());
        long[] ids = null;
        if (!supportedGenericFields.isEmpty()) {
            List<LitePalSupport> list = LitePal.select("id").where(conditions).find(baseObj.getClass());
            if (list.size() > 0) {
                ids = new long[list.size()];
                for (int i = 0; i < ids.length; i++) {
                    LitePalSupport dataSupport = list.get(i);
                    ids[i] = dataSupport.getBaseObjId();
                }
                updateGenericTables(baseObj, supportedGenericFields, ids);
            }
        }
        ContentValues values = new ContentValues();
        putFieldsValue(baseObj, supportedFields, values);
        putFieldsToDefaultValue(baseObj, values, ids);
        return doUpdateAllAction(baseObj.getTableName(), values, conditions);
    }

    public int onUpdateAll(String tableName, ContentValues values, String... conditions) {
        BaseUtility.checkConditionsCorrect(conditions);
        if (conditions != null && conditions.length > 0) {
            conditions[0] = DBUtility.convertWhereClauseToColumnName(conditions[0]);
        }
        convertContentValues(values);
        return doUpdateAllAction(tableName, values, conditions);
    }

    private int doUpdateAllAction(String tableName, ContentValues values, String... conditions) {
        BaseUtility.checkConditionsCorrect(conditions);
        if (values.size() > 0) {
            return this.mDatabase.update(tableName, values, getWhereClause(conditions), getWhereArgs(conditions));
        }
        return 0;
    }

    private void putFieldsToDefaultValue(LitePalSupport baseObj, ContentValues values, long... ids) {
        String fieldName = null;
        try {
            LitePalSupport emptyModel = getEmptyModel(baseObj);
            Class<?> emptyModelClass = emptyModel.getClass();
            for (String name : baseObj.getFieldsToSetToDefault()) {
                if (!isIdColumn(name)) {
                    fieldName = name;
                    Field field = emptyModelClass.getDeclaredField(fieldName);
                    if (isCollection(field.getType())) {
                        if (ids != null && ids.length > 0) {
                            String genericTypeName = getGenericTypeName(field);
                            if (BaseUtility.isGenericTypeSupported(genericTypeName)) {
                                String tableName = DBUtility.getGenericTableName(baseObj.getClassName(), field.getName());
                                String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(baseObj.getClassName());
                                StringBuilder whereClause = new StringBuilder();
                                boolean needOr = false;
                                for (long id : ids) {
                                    if (needOr) {
                                        whereClause.append(" or ");
                                    }
                                    whereClause.append(genericValueIdColumnName).append(" = ").append(id);
                                    needOr = true;
                                }
                                this.mDatabase.delete(tableName, whereClause.toString(), null);
                            }
                        }
                    } else {
                        putContentValuesForUpdate(emptyModel, field, values);
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            throw new LitePalSupportException(LitePalSupportException.noSuchFieldExceptioin(baseObj.getClassName(), fieldName), e);
        } catch (Exception e2) {
            throw new LitePalSupportException(e2.getMessage(), e2);
        }
    }

    private int doUpdateAssociations(LitePalSupport baseObj, long id, ContentValues values) {
        analyzeAssociations(baseObj);
        updateSelfTableForeignKey(baseObj, values);
        int rowsAffected = 0 + updateAssociatedTableForeignKey(baseObj, id);
        return rowsAffected;
    }

    private void analyzeAssociations(LitePalSupport baseObj) {
        try {
            Collection<AssociationsInfo> associationInfos = getAssociationInfo(baseObj.getClassName());
            analyzeAssociatedModels(baseObj, associationInfos);
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private void updateSelfTableForeignKey(LitePalSupport baseObj, ContentValues values) {
        Map<String, Long> associatedModelMap = baseObj.getAssociatedModelsMapWithoutFK();
        for (String associatedTable : associatedModelMap.keySet()) {
            String fkName = getForeignKeyColumnName(associatedTable);
            values.put(fkName, associatedModelMap.get(associatedTable));
        }
    }

    private int updateAssociatedTableForeignKey(LitePalSupport baseObj, long id) {
        Map<String, Set<Long>> associatedModelMap = baseObj.getAssociatedModelsMapWithFK();
        ContentValues values = new ContentValues();
        for (String associatedTable : associatedModelMap.keySet()) {
            values.clear();
            String fkName = getForeignKeyColumnName(baseObj.getTableName());
            values.put(fkName, Long.valueOf(id));
            Set<Long> ids = associatedModelMap.get(associatedTable);
            if (ids != null && !ids.isEmpty()) {
                return this.mDatabase.update(associatedTable, values, getWhereOfIdsWithOr(ids), null);
            }
        }
        return 0;
    }

    private void updateGenericTables(LitePalSupport baseObj, List<Field> supportedGenericFields, long... ids) throws IllegalAccessException, InvocationTargetException {
        if (ids != null && ids.length > 0) {
            for (Field field : supportedGenericFields) {
                Encrypt annotation = (Encrypt) field.getAnnotation(Encrypt.class);
                String algorithm = null;
                String genericTypeName = getGenericTypeName(field);
                if (annotation != null && "java.lang.String".equals(genericTypeName)) {
                    algorithm = annotation.algorithm();
                }
                field.setAccessible(true);
                Collection<?> collection = (Collection) field.get(baseObj);
                if (collection != null && !collection.isEmpty()) {
                    String tableName = DBUtility.getGenericTableName(baseObj.getClassName(), field.getName());
                    String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(baseObj.getClassName());
                    for (long id : ids) {
                        this.mDatabase.delete(tableName, String.valueOf(genericValueIdColumnName) + " = ?", new String[]{String.valueOf(id)});
                        for (Object object : collection) {
                            ContentValues values = new ContentValues();
                            values.put(genericValueIdColumnName, Long.valueOf(id));
                            Object object2 = encryptValue(algorithm, object);
                            if (baseObj.getClassName().equals(genericTypeName)) {
                                LitePalSupport dataSupport = (LitePalSupport) object2;
                                if (dataSupport != null) {
                                    long baseObjId = dataSupport.getBaseObjId();
                                    if (baseObjId > 0) {
                                        values.put(DBUtility.getM2MSelfRefColumnName(field), Long.valueOf(baseObjId));
                                    }
                                }
                            } else {
                                Object[] parameters = {DBUtility.convertToValidColumnName(BaseUtility.changeCase(field.getName())), object2};
                                Class[] parameterTypes = {String.class, getGenericTypeClass(field)};
                                DynamicExecutor.send(values, "put", parameters, values.getClass(), parameterTypes);
                            }
                            this.mDatabase.insert(tableName, null, values);
                        }
                    }
                }
            }
        }
    }

    private void convertContentValues(ContentValues values) {
        if (Build.VERSION.SDK_INT >= 11) {
            Map<String, Object> valuesToConvert = new HashMap<>();
            for (String key : values.keySet()) {
                if (DBUtility.isFieldNameConflictWithSQLiteKeywords(key)) {
                    valuesToConvert.put(key, values.get(key));
                }
            }
            for (String key2 : valuesToConvert.keySet()) {
                String convertedKey = DBUtility.convertToValidColumnName(key2);
                Object object = values.get(key2);
                values.remove(key2);
                if (object == null) {
                    values.putNull(convertedKey);
                } else {
                    String className = object.getClass().getName();
                    if ("java.lang.Byte".equals(className)) {
                        values.put(convertedKey, (Byte) object);
                    } else if ("[B".equals(className)) {
                        values.put(convertedKey, (byte[]) object);
                    } else if ("java.lang.Boolean".equals(className)) {
                        values.put(convertedKey, (Boolean) object);
                    } else if ("java.lang.String".equals(className)) {
                        values.put(convertedKey, (String) object);
                    } else if ("java.lang.Float".equals(className)) {
                        values.put(convertedKey, (Float) object);
                    } else if ("java.lang.Long".equals(className)) {
                        values.put(convertedKey, (Long) object);
                    } else if ("java.lang.Integer".equals(className)) {
                        values.put(convertedKey, (Integer) object);
                    } else if ("java.lang.Short".equals(className)) {
                        values.put(convertedKey, (Short) object);
                    } else if ("java.lang.Double".equals(className)) {
                        values.put(convertedKey, (Double) object);
                    }
                }
            }
        }
    }
}
