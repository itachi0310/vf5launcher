package com.syu.carinfo.zhtd.bmw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

/* JADX INFO: loaded from: classes.dex */
public class LZNewAllGMCSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        int i = ints[1];
                    }
                    break;
            }
        }
    };
    int mileunit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllGMCSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 95:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 96:
                    ((CheckedTextView) LZNewAllGMCSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 97:
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 98:
                case 99:
                    int w = DataCanbus.DATA[98];
                    int h = DataCanbus.DATA[99];
                    ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(w) + " X " + h);
                    break;
                case 100:
                    if (LZNewAllGMCSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 101:
                    if (LZNewAllGMCSetFunc.this.mileunit == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "mil");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 102:
                    if (value == 255) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    }
                    break;
                case 104:
                    LZNewAllGMCSetFunc.this.mileunit = value;
                    break;
                case 105:
                    if (value == 1) {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("8 inches");
                    } else {
                        ((TextView) LZNewAllGMCSetFunc.this.findViewById(R.id.tv_text4)).setText("7 inches");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_gmc_screen_setfunc);
        init();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus4 /* 2131427464 */:
                int value2 = DataCanbus.DATA[105] - 1;
                if (value2 < 0) {
                    value2 = 1;
                }
                setCarInfo(0, value2);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value3 = DataCanbus.DATA[105] + 1;
                if (value3 > 1) {
                    value3 = 0;
                }
                setCarInfo(0, value3);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value4 = DataCanbus.DATA[97] - 1;
                if (value4 < 0) {
                    value4 = 3;
                }
                setCarInfo(254, value4);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value5 = DataCanbus.DATA[97] + 1;
                if (value5 > 3) {
                    value5 = 0;
                }
                setCarInfo(254, value5);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value6 = DataCanbus.DATA[94];
                if (value6 > 0) {
                    value6--;
                }
                setCarInfo(253, value6);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value7 = DataCanbus.DATA[94];
                if (value7 < 36) {
                    value7++;
                }
                setCarInfo(253, value7);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value8 = DataCanbus.DATA[95];
                if (value8 > 0) {
                    value8--;
                }
                setCarInfo(252, value8);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value9 = DataCanbus.DATA[95];
                if (value9 < 36) {
                    value9++;
                }
                setCarInfo(252, value9);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                if (DataCanbus.DATA[96] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(247, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(7, new int[]{53, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
    }
}
