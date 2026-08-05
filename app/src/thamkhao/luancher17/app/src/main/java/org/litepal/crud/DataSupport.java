package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import java.util.Collection;
import java.util.List;
import org.litepal.LitePal;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DataSupport extends LitePalSupport {
    @Deprecated
    public static synchronized ClusterQuery select(String... columns) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        cQuery.mColumns = columns;
        return cQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery where(String... conditions) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        cQuery.mConditions = conditions;
        return cQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery order(String column) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        cQuery.mOrderBy = column;
        return cQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery limit(int value) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        cQuery.mLimit = String.valueOf(value);
        return cQuery;
    }

    @Deprecated
    public static synchronized ClusterQuery offset(int value) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        cQuery.mOffset = String.valueOf(value);
        return cQuery;
    }

    @Deprecated
    public static synchronized int count(Class<?> modelClass) {
        return count(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())));
    }

    @Deprecated
    public static CountExecutor countAsync(Class<?> modelClass) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())));
    }

    @Deprecated
    public static synchronized int count(String tableName) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        return cQuery.count(tableName);
    }

    @Deprecated
    public static CountExecutor countAsync(final String tableName) {
        final CountExecutor executor = new CountExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int count = DataSupport.count(tableName);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final CountExecutor countExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                countExecutor.getListener().onFinish(count);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized double average(Class<?> modelClass, String column) {
        return average(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), column);
    }

    @Deprecated
    public static AverageExecutor averageAsync(Class<?> modelClass, String column) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), column);
    }

    @Deprecated
    public static synchronized double average(String tableName, String column) {
        ClusterQuery cQuery;
        cQuery = new ClusterQuery();
        return cQuery.average(tableName, column);
    }

    @Deprecated
    public static AverageExecutor averageAsync(final String tableName, final String column) {
        final AverageExecutor executor = new AverageExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final double average = DataSupport.average(tableName, column);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final AverageExecutor averageExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                averageExecutor.getListener().onFinish(average);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static <T> FindExecutor maxAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    @Deprecated
    public static synchronized <T> T max(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().max(str, str2, cls);
    }

    @Deprecated
    public static <T> FindExecutor maxAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objMax = DataSupport.max(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objMax);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static <T> FindExecutor minAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    @Deprecated
    public static synchronized <T> T min(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().min(str, str2, cls);
    }

    @Deprecated
    public static <T> FindExecutor minAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objMin = DataSupport.min(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objMin);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName())), str, cls2);
    }

    @Deprecated
    public static <T> FindExecutor sumAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    @Deprecated
    public static synchronized <T> T sum(String str, String str2, Class<T> cls) {
        return (T) new ClusterQuery().sum(str, str2, cls);
    }

    @Deprecated
    public static <T> FindExecutor sumAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objSum = DataSupport.sum(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objSum);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T find(Class<T> cls, long j) {
        return (T) find(cls, j, false);
    }

    @Deprecated
    public static <T> FindExecutor findAsync(Class<T> modelClass, long id) {
        return findAsync(modelClass, id, false);
    }

    @Deprecated
    public static synchronized <T> T find(Class<T> cls, long j, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFind(cls, j, z);
    }

    @Deprecated
    public static <T> FindExecutor findAsync(final Class<T> modelClass, final long id, final boolean isEager) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objFind = DataSupport.find(modelClass, id, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objFind);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T findFirst(Class<T> cls) {
        return (T) findFirst(cls, false);
    }

    @Deprecated
    public static <T> FindExecutor findFirstAsync(Class<T> modelClass) {
        return findFirstAsync(modelClass, false);
    }

    @Deprecated
    public static synchronized <T> T findFirst(Class<T> cls, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFindFirst(cls, z);
    }

    @Deprecated
    public static <T> FindExecutor findFirstAsync(final Class<T> modelClass, final boolean isEager) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objFindFirst = DataSupport.findFirst(modelClass, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objFindFirst);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> T findLast(Class<T> cls) {
        return (T) findLast(cls, false);
    }

    @Deprecated
    public static <T> FindExecutor findLastAsync(Class<T> modelClass) {
        return findLastAsync(modelClass, false);
    }

    @Deprecated
    public static synchronized <T> T findLast(Class<T> cls, boolean z) {
        return (T) new QueryHandler(Connector.getDatabase()).onFindLast(cls, z);
    }

    @Deprecated
    public static <T> FindExecutor findLastAsync(final Class<T> modelClass, final boolean isEager) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final Object objFindLast = DataSupport.findLast(modelClass, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findExecutor.getListener().onFinish(objFindLast);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T> List<T> findAll(Class<T> modelClass, long... ids) {
        return findAll(modelClass, false, ids);
    }

    @Deprecated
    public static <T> FindMultiExecutor findAllAsync(Class<T> modelClass, long... ids) {
        return findAllAsync(modelClass, false, ids);
    }

    @Deprecated
    public static synchronized <T> List<T> findAll(Class<T> modelClass, boolean isEager, long... ids) {
        QueryHandler queryHandler;
        queryHandler = new QueryHandler(Connector.getDatabase());
        return queryHandler.onFindAll(modelClass, isEager, ids);
    }

    @Deprecated
    public static <T> FindMultiExecutor findAllAsync(final Class<T> modelClass, final boolean isEager, final long... ids) {
        final FindMultiExecutor executor = new FindMultiExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final List listFindAll = DataSupport.findAll(modelClass, isEager, ids);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindMultiExecutor findMultiExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findMultiExecutor.getListener().onFinish(listFindAll);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized Cursor findBySQL(String... sql) {
        String[] selectionArgs;
        Cursor cursorRawQuery = null;
        synchronized (DataSupport.class) {
            BaseUtility.checkConditionsCorrect(sql);
            if (sql != null && sql.length > 0) {
                if (sql.length == 1) {
                    selectionArgs = null;
                } else {
                    selectionArgs = new String[sql.length - 1];
                    System.arraycopy(sql, 1, selectionArgs, 0, sql.length - 1);
                }
                cursorRawQuery = Connector.getDatabase().rawQuery(sql[0], selectionArgs);
            }
        }
        return cursorRawQuery;
    }

    @Deprecated
    public static synchronized int delete(Class<?> modelClass, long id) {
        int rowsAffected;
        SQLiteDatabase db = Connector.getDatabase();
        db.beginTransaction();
        try {
            DeleteHandler deleteHandler = new DeleteHandler(db);
            rowsAffected = deleteHandler.onDelete(modelClass, id);
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
        return rowsAffected;
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAsync(final Class<?> modelClass, final long id) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.10
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.delete(modelClass, id);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized int deleteAll(Class<?> modelClass, String... conditions) {
        DeleteHandler deleteHandler;
        deleteHandler = new DeleteHandler(Connector.getDatabase());
        return deleteHandler.onDeleteAll(modelClass, conditions);
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAllAsync(final Class<?> modelClass, final String... conditions) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.deleteAll((Class<?>) modelClass, conditions);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized int deleteAll(String tableName, String... conditions) {
        DeleteHandler deleteHandler;
        deleteHandler = new DeleteHandler(Connector.getDatabase());
        return deleteHandler.onDeleteAll(tableName, conditions);
    }

    @Deprecated
    public static UpdateOrDeleteExecutor deleteAllAsync(final String tableName, final String... conditions) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.deleteAll(tableName, conditions);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized int update(Class<?> modelClass, ContentValues values, long id) {
        UpdateHandler updateHandler;
        updateHandler = new UpdateHandler(Connector.getDatabase());
        return updateHandler.onUpdate(modelClass, id, values);
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAsync(final Class<?> modelClass, final ContentValues values, final long id) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.update(modelClass, values, id);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized int updateAll(Class<?> modelClass, ContentValues values, String... conditions) {
        return updateAll(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), values, conditions);
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAllAsync(Class<?> modelClass, ContentValues values, String... conditions) {
        return updateAllAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), values, conditions);
    }

    @Deprecated
    public static synchronized int updateAll(String tableName, ContentValues values, String... conditions) {
        UpdateHandler updateHandler;
        updateHandler = new UpdateHandler(Connector.getDatabase());
        return updateHandler.onUpdateAll(tableName, values, conditions);
    }

    @Deprecated
    public static UpdateOrDeleteExecutor updateAllAsync(final String tableName, final ContentValues values, final String... conditions) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.updateAll(tableName, values, conditions);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.14.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static synchronized <T extends DataSupport> void saveAll(Collection<T> collection) {
        SQLiteDatabase db = Connector.getDatabase();
        db.beginTransaction();
        try {
            try {
                SaveHandler saveHandler = new SaveHandler(db);
                saveHandler.onSaveAll(collection);
                db.setTransactionSuccessful();
                db.endTransaction();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Deprecated
    public static <T extends DataSupport> SaveExecutor saveAllAsync(final Collection<T> collection) {
        final SaveExecutor executor = new SaveExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.15
            @Override // java.lang.Runnable
            public void run() {
                boolean success;
                synchronized (DataSupport.class) {
                    try {
                        DataSupport.saveAll(collection);
                        success = true;
                    } catch (Exception e) {
                        success = false;
                    }
                    final boolean result = success;
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final SaveExecutor saveExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(result);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Deprecated
    public static <T extends DataSupport> void markAsDeleted(Collection<T> collection) {
        for (T t : collection) {
            t.clearSavedState();
        }
    }

    @Deprecated
    public static <T> boolean isExist(Class<T> modelClass, String... conditions) {
        return conditions != null && where(conditions).count((Class<?>) modelClass) > 0;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int delete() {
        int rowsAffected;
        SQLiteDatabase db = Connector.getDatabase();
        db.beginTransaction();
        try {
            DeleteHandler deleteHandler = new DeleteHandler(db);
            rowsAffected = deleteHandler.onDelete(this);
            this.baseObjId = 0L;
            db.setTransactionSuccessful();
            db.endTransaction();
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
        return rowsAffected;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.this.delete();
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int update(long id) {
        int rowsAffected;
        try {
            UpdateHandler updateHandler = new UpdateHandler(Connector.getDatabase());
            rowsAffected = updateHandler.onUpdate(this, id);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage(), e);
        }
        return rowsAffected;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor updateAsync(final long id) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.this.update(id);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized int updateAll(String... conditions) {
        int rowsAffected;
        try {
            UpdateHandler updateHandler = new UpdateHandler(Connector.getDatabase());
            rowsAffected = updateHandler.onUpdateAll(this, conditions);
            getFieldsToSetToDefault().clear();
        } catch (Exception e) {
            throw new DataSupportException(e.getMessage(), e);
        }
        return rowsAffected;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public UpdateOrDeleteExecutor updateAllAsync(final String... conditions) {
        final UpdateOrDeleteExecutor executor = new UpdateOrDeleteExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.18
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final int rowsAffected = DataSupport.this.updateAll(conditions);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final UpdateOrDeleteExecutor updateOrDeleteExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(rowsAffected);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized boolean save() {
        boolean z;
        try {
            saveThrows();
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        return z;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public SaveExecutor saveAsync() {
        final SaveExecutor executor = new SaveExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.19
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final boolean success = DataSupport.this.save();
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final SaveExecutor saveExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(success);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized void saveThrows() {
        SQLiteDatabase db = Connector.getDatabase();
        db.beginTransaction();
        try {
            try {
                SaveHandler saveHandler = new SaveHandler(db);
                saveHandler.onSave(this);
                clearAssociatedData();
                db.setTransactionSuccessful();
                db.endTransaction();
            } catch (Exception e) {
                throw new DataSupportException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            db.endTransaction();
            throw th;
        }
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public synchronized boolean saveOrUpdate(String... conditions) {
        boolean zSave;
        if (conditions == null) {
            zSave = save();
        } else {
            List<DataSupport> list = where(conditions).find(getClass());
            if (list.isEmpty()) {
                zSave = save();
            } else {
                SQLiteDatabase db = Connector.getDatabase();
                db.beginTransaction();
                try {
                    try {
                        for (DataSupport dataSupport : list) {
                            this.baseObjId = dataSupport.getBaseObjId();
                            SaveHandler saveHandler = new SaveHandler(db);
                            saveHandler.onSave(this);
                            clearAssociatedData();
                        }
                        db.setTransactionSuccessful();
                        db.endTransaction();
                        zSave = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        db.endTransaction();
                        zSave = false;
                    }
                } catch (Throwable th) {
                    db.endTransaction();
                    throw th;
                }
            }
        }
        return zSave;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public SaveExecutor saveOrUpdateAsync(final String... conditions) {
        final SaveExecutor executor = new SaveExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.crud.DataSupport.20
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DataSupport.class) {
                    final boolean success = DataSupport.this.saveOrUpdate(conditions);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final SaveExecutor saveExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.crud.DataSupport.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(success);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void setToDefault(String fieldName) {
        getFieldsToSetToDefault().add(fieldName);
    }

    @Override // org.litepal.crud.LitePalSupport
    @Deprecated
    public void assignBaseObjId(int baseObjId) {
        this.baseObjId = baseObjId;
    }

    @Deprecated
    protected DataSupport() {
    }
}
