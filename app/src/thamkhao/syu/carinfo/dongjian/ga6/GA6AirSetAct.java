package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GA6AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 94:
                    GA6AirSetAct.this.updaterAutoCompressor();
                    break;
                case 95:
                    GA6AirSetAct.this.updaterAutoCycleState();
                    break;
                case 96:
                    GA6AirSetAct.this.updaterComfort();
                    break;
                case 97:
                    GA6AirSetAct.this.mUpdaterValue0();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_257_dongjian_ga6_air_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (DataCanbus.DATA[96] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                } else if (DataCanbus.DATA[96] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                } else if (DataCanbus.DATA[96] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[96] == 0) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 1);
                } else if (DataCanbus.DATA[96] == 1) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 2);
                } else if (DataCanbus.DATA[96] == 2) {
                    GA6Func.C_CAR_CARINFO_CMD(1, 4, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 1, DataCanbus.DATA[94] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 2, DataCanbus.DATA[95] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                GA6Func.C_CAR_CARINFO_CMD(1, 3, DataCanbus.DATA[97] == 0 ? 1 : 0);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int mAnionMode = DataCanbus.DATA[97];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mAnionMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[94];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mAutoCompre != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[95];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mAutoCycle != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[96];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
