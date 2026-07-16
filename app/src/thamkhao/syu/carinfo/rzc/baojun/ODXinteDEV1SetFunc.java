package com.syu.carinfo.rzc.baojun;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class ODXinteDEV1SetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.ODXinteDEV1SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    switch (value) {
                        case 1:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text1)).setText("深度");
                            break;
                        default:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    break;
                case 95:
                    switch (value) {
                        case 1:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text2)).setText("1档 60km");
                            break;
                        case 2:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text2)).setText("2档 80km");
                            break;
                        default:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                            break;
                    }
                    break;
                case 96:
                    switch (value) {
                        case 1:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.driver_system_economics);
                            break;
                        default:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text3)).setText(R.string.wc_golf_normal);
                            break;
                    }
                    break;
                case 97:
                    switch (value) {
                        case 1:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        default:
                            ((TextView) ODXinteDEV1SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.mateng_air_con_profile_0);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0454_od_xinte_dev1);
        setupView();
    }

    private void setupView() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[94] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(0, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[94] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[95] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[95] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[96] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[96] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(2, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[97] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(3, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[97] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(3, value8);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }
}
