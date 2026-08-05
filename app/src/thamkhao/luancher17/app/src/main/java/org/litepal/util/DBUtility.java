package org.litepal.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;

/* JADX INFO: loaded from: classes.dex */
public class DBUtility {
    private static final String KEYWORDS_COLUMN_SUFFIX = "_lpcolumn";
    private static final String REG_COLLECTION = "\\s+(not\\s+)?(in)\\s*\\(";
    private static final String REG_FUZZY = "\\s+(not\\s+)?(like|between)\\s+";
    private static final String REG_OPERATOR = "\\s*(=|!=|<>|<|>)";
    private static final String SQLITE_KEYWORDS = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";
    private static final String TAG = "DBUtility";

    private DBUtility() {
    }

    public static String getTableNameByClassName(String className) {
        if (TextUtils.isEmpty(className) || '.' == className.charAt(className.length() - 1)) {
            return null;
        }
        return className.substring(className.lastIndexOf(".") + 1);
    }

    public static List<String> getTableNameListByClassNameList(List<String> classNames) {
        List<String> tableNames = new ArrayList<>();
        if (classNames != null && !classNames.isEmpty()) {
            for (String className : classNames) {
                tableNames.add(getTableNameByClassName(className));
            }
        }
        return tableNames;
    }

    public static String getTableNameByForeignColumn(String foreignColumnName) {
        if (TextUtils.isEmpty(foreignColumnName) || !foreignColumnName.toLowerCase(Locale.US).endsWith("_id")) {
            return null;
        }
        return foreignColumnName.substring(0, foreignColumnName.length() - "_id".length());
    }

    public static String getIntermediateTableName(String tableName, String associatedTableName) {
        if (!TextUtils.isEmpty(tableName) && !TextUtils.isEmpty(associatedTableName)) {
            if (tableName.toLowerCase(Locale.US).compareTo(associatedTableName.toLowerCase(Locale.US)) <= 0) {
                return String.valueOf(tableName) + "_" + associatedTableName;
            }
            return String.valueOf(associatedTableName) + "_" + tableName;
        }
        return null;
    }

    public static String getGenericTableName(String className, String fieldName) {
        String tableName = getTableNameByClassName(className);
        return BaseUtility.changeCase(String.valueOf(tableName) + "_" + fieldName);
    }

    public static String getGenericValueIdColumnName(String className) {
        return BaseUtility.changeCase(String.valueOf(getTableNameByClassName(className)) + "_id");
    }

    public static String getM2MSelfRefColumnName(Field field) {
        return BaseUtility.changeCase(String.valueOf(field.getName()) + "_id");
    }

    public static boolean isIntermediateTable(String tableName, SQLiteDatabase db) {
        if (!TextUtils.isEmpty(tableName) && tableName.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = db.query(Const.TableSchema.TABLE_NAME, null, null, null, null, null, null);
                    if (cursor.moveToFirst()) {
                        do {
                            String tableNameDB = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            if (tableName.equalsIgnoreCase(tableNameDB)) {
                                int tableType = cursor.getInt(cursor.getColumnIndexOrThrow(Const.TableSchema.COLUMN_TYPE));
                                if (tableType != 1) {
                                    break;
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return true;
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return false;
    }

    public static boolean isGenericTable(String tableName, SQLiteDatabase db) {
        if (!TextUtils.isEmpty(tableName) && tableName.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            Cursor cursor = null;
            try {
                try {
                    cursor = db.query(Const.TableSchema.TABLE_NAME, null, null, null, null, null, null);
                    if (cursor.moveToFirst()) {
                        do {
                            String tableNameDB = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            if (tableName.equalsIgnoreCase(tableNameDB)) {
                                int tableType = cursor.getInt(cursor.getColumnIndexOrThrow(Const.TableSchema.COLUMN_TYPE));
                                if (tableType != 2) {
                                    break;
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return true;
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return false;
    }

    public static boolean isTableExists(String tableName, SQLiteDatabase db) {
        try {
            boolean exist = BaseUtility.containsIgnoreCases(findAllTableNames(db), tableName);
            return exist;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isColumnExists(String columnName, String tableName, SQLiteDatabase db) {
        if (TextUtils.isEmpty(columnName) || TextUtils.isEmpty(tableName)) {
            return false;
        }
        boolean exist = false;
        Cursor cursor = null;
        try {
            try {
                String checkingColumnSQL = "pragma table_info(" + tableName + ")";
                cursor = db.rawQuery(checkingColumnSQL, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                        if (columnName.equalsIgnoreCase(name)) {
                            exist = true;
                            break;
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static List<String> findAllTableNames(SQLiteDatabase db) {
        List<String> tableNames = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                cursor = db.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
                if (cursor.moveToFirst()) {
                    do {
                        String tableName = cursor.getString(cursor.getColumnIndexOrThrow("tbl_name"));
                        if (!tableNames.contains(tableName)) {
                            tableNames.add(tableName);
                        }
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
                return tableNames;
            } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseGenerateException(e.getMessage());
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static TableModel findPragmaTableInfo(String tableName, SQLiteDatabase db) {
        String defaultValue;
        if (isTableExists(tableName, db)) {
            List<String> uniqueColumns = findUniqueColumns(tableName, db);
            TableModel tableModelDB = new TableModel();
            tableModelDB.setTableName(tableName);
            String checkingColumnSQL = "pragma table_info(" + tableName + ")";
            Cursor cursor = null;
            try {
                try {
                    cursor = db.rawQuery(checkingColumnSQL, null);
                    if (cursor.moveToFirst()) {
                        do {
                            ColumnModel columnModel = new ColumnModel();
                            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            String type = cursor.getString(cursor.getColumnIndexOrThrow(Const.TableSchema.COLUMN_TYPE));
                            boolean nullable = cursor.getInt(cursor.getColumnIndexOrThrow("notnull")) != 1;
                            boolean unique = uniqueColumns.contains(name);
                            String defaultValue2 = cursor.getString(cursor.getColumnIndexOrThrow("dflt_value"));
                            columnModel.setColumnName(name);
                            columnModel.setColumnType(type);
                            columnModel.setNullable(nullable);
                            columnModel.setUnique(unique);
                            if (defaultValue2 != null) {
                                defaultValue = defaultValue2.replace("'", "");
                            } else {
                                defaultValue = "";
                            }
                            columnModel.setDefaultValue(defaultValue);
                            tableModelDB.addColumnModel(columnModel);
                        } while (cursor.moveToNext());
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return tableModelDB;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new DatabaseGenerateException(e.getMessage());
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST_WHEN_EXECUTING + tableName);
    }

    public static List<String> findUniqueColumns(String tableName, SQLiteDatabase db) {
        List<String> columns = new ArrayList<>();
        Cursor cursor = null;
        Cursor innerCursor = null;
        try {
            try {
                cursor = db.rawQuery("pragma index_list(" + tableName + ")", null);
                if (cursor.moveToFirst()) {
                    do {
                        int unique = cursor.getInt(cursor.getColumnIndexOrThrow("unique"));
                        if (unique == 1) {
                            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            innerCursor = db.rawQuery("pragma index_info(" + name + ")", null);
                            if (innerCursor.moveToFirst()) {
                                String columnName = innerCursor.getString(innerCursor.getColumnIndexOrThrow("name"));
                                columns.add(columnName);
                            }
                        }
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (innerCursor != null) {
                    innerCursor.close();
                }
                return columns;
            } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseGenerateException(e.getMessage());
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (innerCursor != null) {
                innerCursor.close();
            }
            throw th;
        }
    }

    public static boolean isFieldNameConflictWithSQLiteKeywords(String fieldName) {
        if (!TextUtils.isEmpty(fieldName)) {
            String fieldNameWithComma = "," + fieldName.toLowerCase(Locale.US) + ",";
            if (SQLITE_KEYWORDS.contains(fieldNameWithComma)) {
                return true;
            }
        }
        return false;
    }

    public static String convertToValidColumnName(String columnName) {
        if (isFieldNameConflictWithSQLiteKeywords(columnName)) {
            return String.valueOf(columnName) + KEYWORDS_COLUMN_SUFFIX;
        }
        return columnName;
    }

    public static String convertWhereClauseToColumnName(String whereClause) {
        if (!TextUtils.isEmpty(whereClause)) {
            try {
                StringBuffer convertedWhereClause = new StringBuffer();
                Pattern p = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()");
                Matcher m = p.matcher(whereClause);
                while (m.find()) {
                    String matches = m.group();
                    String column = matches.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    String rest = matches.replace(column, "");
                    m.appendReplacement(convertedWhereClause, String.valueOf(convertToValidColumnName(column)) + rest);
                }
                m.appendTail(convertedWhereClause);
                whereClause = convertedWhereClause.toString();
                return whereClause;
            } catch (Exception e) {
                e.printStackTrace();
                return whereClause;
            }
        }
        return whereClause;
    }

    public static String[] convertSelectClauseToValidNames(String[] columns) {
        if (columns != null && columns.length > 0) {
            String[] convertedColumns = new String[columns.length];
            for (int i = 0; i < columns.length; i++) {
                convertedColumns[i] = convertToValidColumnName(columns[i]);
            }
            return convertedColumns;
        }
        return null;
    }

    public static String convertOrderByClauseToValidName(String orderBy) {
        if (!TextUtils.isEmpty(orderBy)) {
            String orderBy2 = orderBy.trim().toLowerCase(Locale.US);
            if (orderBy2.contains(",")) {
                String[] orderByItems = orderBy2.split(",");
                StringBuilder builder = new StringBuilder();
                boolean needComma = false;
                for (String orderByItem : orderByItems) {
                    if (needComma) {
                        builder.append(",");
                    }
                    builder.append(convertOrderByItem(orderByItem));
                    needComma = true;
                }
                return builder.toString();
            }
            return convertOrderByItem(orderBy2);
        }
        return null;
    }

    private static String convertOrderByItem(String orderByItem) {
        String column;
        String append;
        if (orderByItem.endsWith("asc")) {
            column = orderByItem.replace("asc", "").trim();
            append = " asc";
        } else if (orderByItem.endsWith("desc")) {
            column = orderByItem.replace("desc", "").trim();
            append = " desc";
        } else {
            column = orderByItem;
            append = "";
        }
        return String.valueOf(convertToValidColumnName(column)) + append;
    }
}
