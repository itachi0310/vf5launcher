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
public class ODQiruiXiaomayiCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODQiruiXiaomayiCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 95:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 96:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 97:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 98:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 99:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 100:
                    switch (value) {
                        case 0:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("1小时");
                            break;
                        case 2:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("1.5小时");
                            break;
                        case 3:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("2小时");
                            break;
                        case 4:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("2.5小时");
                            break;
                        case 5:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("3小时");
                            break;
                        case 6:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("3.5小时");
                            break;
                        case 7:
                            ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text4)).setText("4小时");
                            break;
                    }
                    break;
                case 101:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 102:
                    ((TextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kWh/100km");
                    break;
                case 103:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 104:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 105:
                    ODQiruiXiaomayiCarInfo.this.setCheck((CheckedTextView) ODQiruiXiaomayiCarInfo.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_xiaomayi_carinfo);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{68, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 1) {
                    value = 7;
                }
                setCarInfo(146, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 7) {
                    value2 = 1;
                }
                setCarInfo(146, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                setCarInfo(151, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                setCarInfo(151, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value5 = DataCanbus.DATA[94];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(145, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value6 = DataCanbus.DATA[95];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(147, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value7 = DataCanbus.DATA[96];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(148, value7);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value8 = DataCanbus.DATA[97];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(149, value8);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value9 = DataCanbus.DATA[98];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(150, value9);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value10 = DataCanbus.DATA[103];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(152, value10);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value11 = DataCanbus.DATA[104];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(153, value11);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value12 = DataCanbus.DATA[105];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(154, value12);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }
}
