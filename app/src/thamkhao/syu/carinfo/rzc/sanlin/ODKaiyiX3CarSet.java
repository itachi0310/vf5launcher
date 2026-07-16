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
public class ODKaiyiX3CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODKaiyiX3CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 95:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 96:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 97:
                    if (((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 2:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_three_times);
                                break;
                            case 2:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_five_times);
                                break;
                            case 3:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_seven_times);
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text3)).setText("1");
                                break;
                            case 2:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text3)).setText("2");
                                break;
                            case 3:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text3)).setText("3");
                                break;
                        }
                    }
                    break;
                case 100:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 101:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 102:
                    ODKaiyiX3CarSet.this.setCheck((CheckedTextView) ODKaiyiX3CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 103:
                    if (((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_comfort);
                                break;
                            case 1:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_eco);
                                break;
                            case 2:
                                ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text4)).setText(R.string.str_driving_sport);
                                break;
                        }
                    }
                    break;
                case 104:
                    if (((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val > 4000) {
                            ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text5)).setText("--.--");
                        } else {
                            ((TextView) ODKaiyiX3CarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(val / 10) + "." + (val % 10) + " L/100Km");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_kaiyix3_settings);
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
                int value = DataCanbus.DATA[97] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[97] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[98] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[98] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[99];
                if (value5 > 1) {
                    value5--;
                }
                setCarInfo(6, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[99];
                if (value6 < 3) {
                    value6++;
                }
                setCarInfo(6, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[103] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(10, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[103] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(10, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value9 = DataCanbus.DATA[94];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(1, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value10 = DataCanbus.DATA[95];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(2, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value11 = DataCanbus.DATA[96];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(3, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value12 = DataCanbus.DATA[100];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(7, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value13 = DataCanbus.DATA[101];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(8, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value14 = DataCanbus.DATA[102];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(9, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }
}
