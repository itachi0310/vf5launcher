package org.litepal.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* JADX INFO: loaded from: classes.dex */
public class Many2ManyAnalyzer extends AssociationsAnalyzer {
    void analyze(LitePalSupport baseObj, AssociationsInfo associationInfo) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Collection<LitePalSupport> associatedModels = getAssociatedModels(baseObj, associationInfo);
        declareAssociations(baseObj, associationInfo);
        if (associatedModels != null) {
            for (LitePalSupport associatedModel : associatedModels) {
                Collection<LitePalSupport> tempCollection = getReverseAssociatedModels(associatedModel, associationInfo);
                Collection<LitePalSupport> reverseAssociatedModels = checkAssociatedModelCollection(tempCollection, associationInfo.getAssociateSelfFromOtherModel());
                addNewModelForAssociatedModel(reverseAssociatedModels, baseObj);
                setReverseAssociatedModels(associatedModel, associationInfo, reverseAssociatedModels);
                dealAssociatedModel(baseObj, associatedModel);
            }
        }
    }

    private void declareAssociations(LitePalSupport baseObj, AssociationsInfo associationInfo) {
        baseObj.addEmptyModelForJoinTable(getAssociatedTableName(associationInfo));
    }

    private void addNewModelForAssociatedModel(Collection<LitePalSupport> associatedModelCollection, LitePalSupport baseObj) {
        if (!associatedModelCollection.contains(baseObj)) {
            associatedModelCollection.add(baseObj);
        }
    }

    private void dealAssociatedModel(LitePalSupport baseObj, LitePalSupport associatedModel) {
        if (associatedModel.isSaved()) {
            baseObj.addAssociatedModelForJoinTable(associatedModel.getTableName(), associatedModel.getBaseObjId());
        }
    }

    private String getAssociatedTableName(AssociationsInfo associationInfo) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(associationInfo.getAssociatedClassName()));
    }

    @Deprecated
    private boolean isDataExists(LitePalSupport baseObj, LitePalSupport associatedModel) {
        boolean z = true;
        SQLiteDatabase db = Connector.getDatabase();
        Cursor cursor = null;
        try {
            try {
                cursor = db.query(getJoinTableName(baseObj, associatedModel), null, getSelection(baseObj, associatedModel), getSelectionArgs(baseObj, associatedModel), null, null, null);
                boolean exists = cursor.getCount() > 0;
                cursor.close();
                z = exists;
            } catch (Exception e) {
                e.printStackTrace();
                cursor.close();
            }
            return z;
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }

    private String getSelection(LitePalSupport baseObj, LitePalSupport associatedModel) {
        return getForeignKeyColumnName(baseObj.getTableName()) + " = ? and " + getForeignKeyColumnName(associatedModel.getTableName()) + " = ?";
    }

    private String[] getSelectionArgs(LitePalSupport baseObj, LitePalSupport associatedModel) {
        return new String[]{String.valueOf(baseObj.getBaseObjId()), String.valueOf(associatedModel.getBaseObjId())};
    }

    private String getJoinTableName(LitePalSupport baseObj, LitePalSupport associatedModel) {
        return getIntermediateTableName(baseObj, associatedModel.getTableName());
    }
}
