package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.rzc.sanlin.RZCBMWPanelButtonSet;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZCBmwX3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.RZCBmwX3CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) RZCBmwX3CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                    }
                    break;
                case 115:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Not Supported");
                            break;
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text2)).setText("Supported");
                            break;
                    }
                    break;
                case 116:
                    switch (value) {
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 6.5");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 8.8");
                            break;
                        case 3:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("Screen 10.25");
                            break;
                        default:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text1)).setText("----");
                            break;
                    }
                    break;
                case 117:
                    switch (value) {
                        case 0:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Default");
                            break;
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Interactive");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text3)).setText("Independence");
                            break;
                    }
                    break;
                case 133:
                    switch (value) {
                        case 1:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Normal");
                            break;
                        case 2:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text4)).setText("Draw");
                            break;
                    }
                    break;
                case 134:
                    switch (value) {
                        case 6:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@30Hz");
                            break;
                        case 7:
                            ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text5)).setText("1280x720@25Hz");
                            break;
                    }
                    break;
                case 147:
                    if ((value & 128) != 0) {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text6)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 148:
                    if ((value & 128) != 0) {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text7)).setText("-" + (256 - value));
                    } else {
                        ((TextView) RZCBmwX3CarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0051_rzc_bmw_x3_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_BMW_320i_05_12 /* 3145779 */:
            case FinalCanbus.CAR_RZC_BMW_320i_05_12_H /* 3211315 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[116];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[116];
                if (value2 < 3) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[115];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 < 1) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[117];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[117];
                if (value6 < 2) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[133] - 1;
                if (value7 < 1) {
                    value7 = 2;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[133] + 1;
                if (value8 > 2) {
                    value8 = 1;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[134] - 1;
                if (value9 < 6) {
                    value9 = 7;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[134] + 1;
                if (value10 > 7) {
                    value10 = 6;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(7, 1);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(7, 2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(8, 1);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(8, 2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value11 = DataCanbus.DATA[114];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(0, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, RZCBMWPanelButtonSet.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(7, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }
}
