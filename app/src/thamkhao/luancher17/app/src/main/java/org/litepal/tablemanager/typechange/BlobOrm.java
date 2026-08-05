package org.litepal.tablemanager.typechange;

/* JADX INFO: loaded from: classes.dex */
public class BlobOrm extends OrmChange {
    @Override // org.litepal.tablemanager.typechange.OrmChange
    public String object2Relation(String fieldType) {
        if (fieldType == null || !fieldType.equals("[B")) {
            return null;
        }
        return "blob";
    }
}
