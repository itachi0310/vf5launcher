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
public class ODZhonghuaV6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODZhonghuaV6CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.rzc_others_language_setting_1);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.rzc_others_language_setting_0);
                                break;
                        }
                    }
                    break;
                case 95:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 96:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 97:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 98:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    break;
                case 99:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value >= 4) {
                            ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value - 4)).toString());
                        } else if (value < 4) {
                            ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text2)).setText("-" + (4 - value));
                        }
                    }
                    break;
                case 100:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 101:
                    if (((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                                break;
                            case 1:
                                ((TextView) ODZhonghuaV6CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                                break;
                        }
                    }
                    break;
                case 102:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 103:
                    ODZhonghuaV6CarSet.this.setCheck((CheckedTextView) ODZhonghuaV6CarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_zhonghua_v6_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
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
                int value = DataCanbus.DATA[98];
                if (value > 0) {
                    value--;
                }
                setCarInfo(10, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[98];
                if (value2 < 15) {
                    value2++;
                }
                setCarInfo(10, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[99];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(11, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[99];
                if (value4 < 9) {
                    value4++;
                }
                setCarInfo(11, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
            case R.id.btn_plus3 /* 2131427463 */:
                int value5 = DataCanbus.DATA[101];
                if (value5 == 0) {
                    value5 = 1;
                } else if (value5 == 1) {
                    value5 = 0;
                }
                setCarInfo(13, value5);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[94];
                if (value6 == 0) {
                    value6 = 1;
                } else if (value6 == 1) {
                    value6 = 0;
                }
                setCarInfo(0, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value7 = DataCanbus.DATA[95];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(1, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value8 = DataCanbus.DATA[96];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(2, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value9 = DataCanbus.DATA[97];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(3, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value10 = DataCanbus.DATA[100];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(12, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value11 = DataCanbus.DATA[102];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(14, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value12 = DataCanbus.DATA[103];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(15, value12);
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
