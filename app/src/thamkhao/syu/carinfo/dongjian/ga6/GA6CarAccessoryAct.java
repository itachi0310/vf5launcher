package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GA6CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6CarAccessoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    GA6CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 103:
                    GA6CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 104:
                    GA6CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 105:
                    GA6CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 106:
                    GA6CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 109:
                    GA6CarAccessoryAct.this.mUpdaterValue3();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_257_dongjian_ga6_car_accessory);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 1, DataCanbus.DATA[102] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 2, DataCanbus.DATA[103] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 3, DataCanbus.DATA[104] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 4, DataCanbus.DATA[105] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 6, DataCanbus.DATA[106] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                GA6Func.C_CAR_CARINFO_CMD(4, 5, DataCanbus.DATA[109] != 0 ? 0 : 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int mAutoFoldOutMirrors = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(mAutoFoldOutMirrors != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRomoteUnlock() {
        int mRomoteUnlockInt = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mRomoteUnlockInt != 0);
        if (mRomoteUnlockInt == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (mRomoteUnlockInt == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeedLock() {
        int mSpeedLockInt = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSpeedLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoUnlock() {
        int mAutoLockInt = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAutoLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWind() {
        int mRomoteFrontWindInt = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mRomoteFrontWindInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontYuGua() {
        int mFrontYuGuaFixInt = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(mFrontYuGuaFixInt != 0);
    }
}
