package com.syu.carinfo.wccamry;

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
public class Wc09LexusESEQActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Wc09LexusESEQActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    Wc09LexusESEQActi.this.setCheck((CheckedTextView) Wc09LexusESEQActi.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 123:
                    Wc09LexusESEQActi.this.setCheck((CheckedTextView) Wc09LexusESEQActi.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 152:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                        } else {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 153:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                        } else {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 154:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text3)).setText("+" + (value - 5));
                        } else if (value < 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text3)).setText("-" + (5 - value));
                        } else {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 155:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text5)).setText("+" + (value - 5));
                        } else if (value < 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text5)).setText("-" + (5 - value));
                        } else {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 156:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text4)).setText("+" + (value - 5));
                        } else if (value < 5) {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text4)).setText("-" + (5 - value));
                        } else {
                            ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 157:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 182:
                    if (((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Wc09LexusESEQActi.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0294_wc_lexus_eq_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[152];
                if (value > 0) {
                    value--;
                }
                setCarInfo(3, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[152];
                if (value2 < 14) {
                    value2++;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[153];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[153];
                if (value4 < 14) {
                    value4++;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[154];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[154];
                if (value6 < 10) {
                    value6++;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[156];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[156];
                if (value8 < 10) {
                    value8++;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[155];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[155];
                if (value10 < 10) {
                    value10++;
                }
                setCarInfo(6, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(1, 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[182] - 1;
                if (value11 < 1) {
                    value11 = 2;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value11, 0}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[182] + 1;
                if (value12 > 2) {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(31, new int[]{value12, 0}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value13 = DataCanbus.DATA[122];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(7, value13);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value14 = DataCanbus.DATA[123];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(8, value14);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(28, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }
}
