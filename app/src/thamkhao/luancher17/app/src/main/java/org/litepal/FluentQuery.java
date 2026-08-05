package org.litepal;

import android.os.Handler;
import java.util.List;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.QueryHandler;
import org.litepal.crud.async.AverageExecutor;
import org.litepal.crud.async.CountExecutor;
import org.litepal.crud.async.FindExecutor;
import org.litepal.crud.async.FindMultiExecutor;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public class FluentQuery {
    String[] mColumns;
    String[] mConditions;
    String mLimit;
    String mOffset;
    String mOrderBy;

    FluentQuery() {
    }

    public FluentQuery select(String... columns) {
        this.mColumns = columns;
        return this;
    }

    public FluentQuery where(String... conditions) {
        this.mConditions = conditions;
        return this;
    }

    public FluentQuery order(String column) {
        this.mOrderBy = column;
        return this;
    }

    public FluentQuery limit(int value) {
        this.mLimit = String.valueOf(value);
        return this;
    }

    public FluentQuery offset(int value) {
        this.mOffset = String.valueOf(value);
        return this;
    }

    public <T> List<T> find(Class<T> modelClass) {
        return find(modelClass, false);
    }

    public <T> FindMultiExecutor findAsync(Class<T> modelClass) {
        return findAsync(modelClass, false);
    }

    public <T> List<T> find(Class<T> modelClass, boolean isEager) {
        String limit;
        List<T> listOnFind;
        synchronized (LitePalSupport.class) {
            QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            if (this.mOffset == null) {
                limit = this.mLimit;
            } else {
                if (this.mLimit == null) {
                    this.mLimit = "0";
                }
                limit = String.valueOf(this.mOffset) + "," + this.mLimit;
            }
            listOnFind = queryHandler.onFind(modelClass, this.mColumns, this.mConditions, this.mOrderBy, limit, isEager);
        }
        return listOnFind;
    }

    public <T> FindMultiExecutor findAsync(final Class<T> modelClass, final boolean isEager) {
        final FindMultiExecutor executor = new FindMultiExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final List listFind = FluentQuery.this.find(modelClass, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindMultiExecutor findMultiExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                findMultiExecutor.getListener().onFinish(listFind);
                            }
                        });
                    }
                }
            }
        };
        executor.submit(runnable);
        return executor;
    }

    public <T> T findFirst(Class<T> cls) {
        return (T) findFirst(cls, false);
    }

    public <T> FindExecutor findFirstAsync(Class<T> modelClass) {
        return findFirstAsync(modelClass, false);
    }

    public <T> T findFirst(Class<T> modelClass, boolean isEager) {
        synchronized (LitePalSupport.class) {
            List<T> list = find(modelClass, isEager);
            if (list.size() <= 0) {
                return null;
            }
            return list.get(0);
        }
    }

    public <T> FindExecutor findFirstAsync(final Class<T> modelClass, final boolean isEager) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object objFindFirst = FluentQuery.this.findFirst(modelClass, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.2.1
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

    public <T> T findLast(Class<T> cls) {
        return (T) findLast(cls, false);
    }

    public <T> FindExecutor findLastAsync(Class<T> modelClass) {
        return findLastAsync(modelClass, false);
    }

    public <T> T findLast(Class<T> modelClass, boolean isEager) {
        synchronized (LitePalSupport.class) {
            List<T> list = find(modelClass, isEager);
            int size = list.size();
            if (size <= 0) {
                return null;
            }
            return list.get(size - 1);
        }
    }

    public <T> FindExecutor findLastAsync(final Class<T> modelClass, final boolean isEager) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object objFindLast = FluentQuery.this.findLast(modelClass, isEager);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.3.1
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

    public int count(Class<?> modelClass) {
        return count(BaseUtility.changeCase(modelClass.getSimpleName()));
    }

    public CountExecutor countAsync(Class<?> modelClass) {
        return countAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())));
    }

    public int count(String tableName) {
        int iOnCount;
        synchronized (LitePalSupport.class) {
            QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            iOnCount = queryHandler.onCount(tableName, this.mConditions);
        }
        return iOnCount;
    }

    public CountExecutor countAsync(final String tableName) {
        final CountExecutor executor = new CountExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int count = FluentQuery.this.count(tableName);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final CountExecutor countExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.4.1
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

    public double average(Class<?> modelClass, String column) {
        return average(BaseUtility.changeCase(modelClass.getSimpleName()), column);
    }

    public AverageExecutor averageAsync(Class<?> modelClass, String column) {
        return averageAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), column);
    }

    public double average(String tableName, String column) {
        double dOnAverage;
        synchronized (LitePalSupport.class) {
            QueryHandler queryHandler = new QueryHandler(Connector.getDatabase());
            dOnAverage = queryHandler.onAverage(tableName, column, this.mConditions);
        }
        return dOnAverage;
    }

    public AverageExecutor averageAsync(final String tableName, final String column) {
        final AverageExecutor executor = new AverageExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final double average = FluentQuery.this.average(tableName, column);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final AverageExecutor averageExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.5.1
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

    public <T> T max(Class<?> cls, String str, Class<T> cls2) {
        return (T) max(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor maxAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return maxAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    public <T> T max(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onMax(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor maxAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object objMax = FluentQuery.this.max(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.6.1
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

    public <T> T min(Class<?> cls, String str, Class<T> cls2) {
        return (T) min(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor minAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return minAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    public <T> T min(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onMin(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor minAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object objMin = FluentQuery.this.min(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.7.1
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

    public <T> T sum(Class<?> cls, String str, Class<T> cls2) {
        return (T) sum(BaseUtility.changeCase(cls.getSimpleName()), str, cls2);
    }

    public <T> FindExecutor sumAsync(Class<?> modelClass, String columnName, Class<T> columnType) {
        return sumAsync(BaseUtility.changeCase(DBUtility.getTableNameByClassName(modelClass.getName())), columnName, columnType);
    }

    public <T> T sum(String str, String str2, Class<T> cls) {
        T t;
        synchronized (LitePalSupport.class) {
            t = (T) new QueryHandler(Connector.getDatabase()).onSum(str, str2, this.mConditions, cls);
        }
        return t;
    }

    public <T> FindExecutor sumAsync(final String tableName, final String columnName, final Class<T> columnType) {
        final FindExecutor executor = new FindExecutor();
        Runnable runnable = new Runnable() { // from class: org.litepal.FluentQuery.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final Object objSum = FluentQuery.this.sum(tableName, columnName, (Class<Object>) columnType);
                    if (executor.getListener() != null) {
                        Handler handler = LitePal.getHandler();
                        final FindExecutor findExecutor = executor;
                        handler.post(new Runnable() { // from class: org.litepal.FluentQuery.8.1
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
}
