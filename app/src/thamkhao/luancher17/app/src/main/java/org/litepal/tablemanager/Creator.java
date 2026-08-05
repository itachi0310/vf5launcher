package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
class Creator extends AssociationCreator {
    public static final String TAG = "Creator";

    Creator() {
    }

    @Override // org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    protected void createOrUpgradeTable(SQLiteDatabase db, boolean force) {
        for (TableModel tableModel : getAllTableModels()) {
            createOrUpgradeTable(tableModel, db, force);
        }
    }

    protected void createOrUpgradeTable(TableModel tableModel, SQLiteDatabase db, boolean force) {
        execute(getCreateTableSQLs(tableModel, db, force), db);
        giveTableSchemaACopy(tableModel.getTableName(), 0, db);
    }

    protected List<String> getCreateTableSQLs(TableModel tableModel, SQLiteDatabase db, boolean force) {
        List<String> sqls = new ArrayList<>();
        if (force) {
            sqls.add(generateDropTableSQL(tableModel));
            sqls.add(generateCreateTableSQL(tableModel));
            return sqls;
        }
        if (DBUtility.isTableExists(tableModel.getTableName(), db)) {
            return null;
        }
        sqls.add(generateCreateTableSQL(tableModel));
        return sqls;
    }

    private String generateDropTableSQL(TableModel tableModel) {
        return generateDropTableSQL(tableModel.getTableName());
    }

    String generateCreateTableSQL(TableModel tableModel) {
        return generateCreateTableSQL(tableModel.getTableName(), tableModel.getColumnModels(), true);
    }
}
