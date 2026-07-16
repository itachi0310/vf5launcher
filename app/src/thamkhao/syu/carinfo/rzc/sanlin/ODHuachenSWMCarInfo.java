package com.syu.carinfo.rzc.sanlin;

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
public class ODHuachenSWMCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODHuachenSWMCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 95:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 96:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 97:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(val) + "km/h");
                    }
                    break;
                case 98:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(val) + "rpm");
                    }
                    break;
                case 99:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(val) + "km");
                    }
                    break;
                case 100:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 101:
                    ODHuachenSWMCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMCarInfo.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 102:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 103:
                    if (((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("45S");
                                break;
                            case 4:
                                ((TextView) ODHuachenSWMCarInfo.this.findViewById(R.id.tv_text5)).setText("60S");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_huachen_swm_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[102] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(11, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[102] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value5 = DataCanbus.DATA[94];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(6, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value6 = DataCanbus.DATA[95];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(7, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value7 = DataCanbus.DATA[96];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(8, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value8 = DataCanbus.DATA[100];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(9, value8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value9 = DataCanbus.DATA[101];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(10, value9);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }
}
