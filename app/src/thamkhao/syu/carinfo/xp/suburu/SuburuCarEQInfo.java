package com.syu.carinfo.xp.suburu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class SuburuCarEQInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.suburu.SuburuCarEQInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 108:
                    SuburuCarEQInfo.this.updateText1();
                    SuburuCarEQInfo.this.updateText2();
                    SuburuCarEQInfo.this.updateText3();
                    SuburuCarEQInfo.this.updateText4();
                    SuburuCarEQInfo.this.updateText5();
                    SuburuCarEQInfo.this.updateText6();
                    break;
                case 109:
                    SuburuCarEQInfo.this.updateText1();
                    break;
                case 110:
                    SuburuCarEQInfo.this.updateText2();
                    break;
                case 111:
                    SuburuCarEQInfo.this.updateText3();
                    break;
                case 112:
                    SuburuCarEQInfo.this.updateText4();
                    break;
                case 113:
                    SuburuCarEQInfo.this.updateText5();
                    break;
                case 114:
                    SuburuCarEQInfo.this.updateText6();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xp_suburu_eq_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value = DataCanbus.DATA[109];
                    if (value > 0) {
                        value--;
                    }
                    setCarInfo(2, value);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value2 = DataCanbus.DATA[109];
                    if (value2 < 63) {
                        value2++;
                    }
                    setCarInfo(2, value2);
                }
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value3 = DataCanbus.DATA[110];
                    if (value3 > 1) {
                        value3--;
                    }
                    setCarInfo(3, value3);
                }
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value4 = DataCanbus.DATA[110];
                    if (value4 < 19) {
                        value4++;
                    }
                    setCarInfo(3, value4);
                }
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value5 = DataCanbus.DATA[111];
                    if (value5 > 1) {
                        value5--;
                    }
                    setCarInfo(4, value5);
                }
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value6 = DataCanbus.DATA[111];
                    if (value6 < 19) {
                        value6++;
                    }
                    setCarInfo(4, value6);
                }
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value7 = DataCanbus.DATA[112];
                    if (value7 > 1) {
                        value7--;
                    }
                    setCarInfo(5, value7);
                }
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value8 = DataCanbus.DATA[112];
                    if (value8 < 19) {
                        value8++;
                    }
                    setCarInfo(5, value8);
                }
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value9 = DataCanbus.DATA[113];
                    if (value9 > 1) {
                        value9--;
                    }
                    setCarInfo(7, value9);
                }
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value10 = DataCanbus.DATA[113];
                    if (value10 < 19) {
                        value10++;
                    }
                    setCarInfo(7, value10);
                }
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value11 = DataCanbus.DATA[114];
                    if (value11 > 1) {
                        value11--;
                    }
                    setCarInfo(6, value11);
                }
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                if (DataCanbus.DATA[108] != 0) {
                    int value12 = DataCanbus.DATA[114];
                    if (value12 < 19) {
                        value12++;
                    }
                    setCarInfo(6, value12);
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText6() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text6)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text6)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text6)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text6)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText5() {
        int value = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text5)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text5)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text5)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text5)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText4() {
        int value = DataCanbus.DATA[112];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text4)).setText("+" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text4)).setText("-" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text4)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text4)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText3() {
        int value = DataCanbus.DATA[111];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text3)).setText("R" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text3)).setText("L" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text3)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text3)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText2() {
        int value = DataCanbus.DATA[110];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                if (value > 10) {
                    ((TextView) findViewById(R.id.tv_text2)).setText("R" + (value - 10));
                    return;
                } else {
                    if (value < 10) {
                        ((TextView) findViewById(R.id.tv_text2)).setText("F" + (10 - value));
                        return;
                    }
                    ((TextView) findViewById(R.id.tv_text2)).setText("0");
                    return;
                }
            }
            ((TextView) findViewById(R.id.tv_text2)).setText("----");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText1() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (DataCanbus.DATA[108] == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText("----");
            }
        }
    }
}
