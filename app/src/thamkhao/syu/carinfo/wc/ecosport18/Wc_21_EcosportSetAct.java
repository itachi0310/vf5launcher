package com.syu.carinfo.wc.ecosport18;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class Wc_21_EcosportSetAct extends BaseActivity {
    private View.OnClickListener mClick = new View.OnClickListener() { // from class: com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            int iLanguage;
            int iTempUnitValue;
            int iDisUnitValue;
            switch (v.getId()) {
                case R.id.btn_minus1 /* 2131427455 */:
                case R.id.btn_plus1 /* 2131427457 */:
                    int iDisUnitValue2 = DataCanbus.DATA[96];
                    if (iDisUnitValue2 == 1) {
                        iDisUnitValue = 0;
                    } else {
                        iDisUnitValue = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(1, iDisUnitValue);
                    break;
                case R.id.btn_minus2 /* 2131427458 */:
                case R.id.btn_plus2 /* 2131427460 */:
                    int iTempUnitValue2 = DataCanbus.DATA[97];
                    if (iTempUnitValue2 == 1) {
                        iTempUnitValue = 0;
                    } else {
                        iTempUnitValue = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(4, iTempUnitValue);
                    break;
                case R.id.btn_minus3 /* 2131427461 */:
                case R.id.btn_plus3 /* 2131427463 */:
                    int iLanguage2 = DataCanbus.DATA[98];
                    if (iLanguage2 == 1) {
                        iLanguage = 0;
                    } else {
                        iLanguage = 1;
                    }
                    Wc_21_EcosportSetAct.this.sendCMD(5, iLanguage);
                    break;
                case R.id.btn_minus4 /* 2131427464 */:
                    int value = DataCanbus.DATA[107] - 1;
                    if (value < 0) {
                        value = 7;
                    }
                    DataCanbus.PROXY.cmd(17, new int[]{3, value}, null, null);
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    int value2 = DataCanbus.DATA[107] + 1;
                    if (value2 > 7) {
                        value2 = 0;
                    }
                    DataCanbus.PROXY.cmd(17, new int[]{3, value2}, null, null);
                    break;
            }
        }
    };
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ecosport18.Wc_21_EcosportSetAct.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                case 100:
                    Wc_21_EcosportSetAct.this.updateCurSpeed();
                    break;
                case 95:
                case 99:
                    Wc_21_EcosportSetAct.this.updateEngineSpeed();
                    break;
                case 96:
                    Wc_21_EcosportSetAct.this.updateDisUnit();
                    break;
                case 97:
                    Wc_21_EcosportSetAct.this.updateTempUnit();
                    break;
                case 98:
                    Wc_21_EcosportSetAct.this.updateLanguage();
                    break;
                case 101:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 102:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value * 0.1f) + " km");
                    }
                    break;
                case 107:
                    if (((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.color_ice_blue);
                                break;
                            case 2:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.color_orange_str);
                                break;
                            case 3:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_2);
                                break;
                            case 4:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_3);
                                break;
                            case 5:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_4);
                                break;
                            case 6:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_5);
                                break;
                            case 7:
                                ((TextView) Wc_21_EcosportSetAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_403_ambient_6);
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
        setContentView(R.layout.layout_021_wc_ecosport18);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 524309) {
            findViewById(R.id.layout_view7).setVisibility(0);
            findViewById(R.id.layout_view8).setVisibility(0);
        } else {
            findViewById(R.id.layout_view7).setVisibility(8);
            findViewById(R.id.layout_view8).setVisibility(8);
        }
        if (DataCanbus.DATA[1000] == 524309 || DataCanbus.DATA[1000] == 458773) {
            findViewById(R.id.layout_view6).setVisibility(0);
        } else {
            findViewById(R.id.layout_view6).setVisibility(8);
        }
        setonClick((Button) findViewById(R.id.btn_minus1));
        setonClick((Button) findViewById(R.id.btn_plus1));
        setonClick((Button) findViewById(R.id.btn_minus2));
        setonClick((Button) findViewById(R.id.btn_plus2));
        setonClick((Button) findViewById(R.id.btn_minus3));
        setonClick((Button) findViewById(R.id.btn_plus3));
        setonClick((Button) findViewById(R.id.btn_minus4));
        setonClick((Button) findViewById(R.id.btn_plus4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCMD(int cmd, int val) {
        DataCanbus.PROXY.cmd(16, new int[]{cmd, val}, null, null);
    }

    private void setonClick(View v) {
        if (v != null) {
            v.setOnClickListener(this.mClick);
        }
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurSpeed() {
        int curspeedenable = DataCanbus.DATA[100];
        int curspeed = DataCanbus.DATA[94];
        if (findViewById(R.id.layout_view5) != null) {
            if (curspeedenable == 0) {
                findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            findViewById(R.id.layout_view5).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text5)) != null) {
                if (curspeed == 65535) {
                    ((TextView) findViewById(R.id.tv_text5)).setText("---");
                } else {
                    ((TextView) findViewById(R.id.tv_text5)).setText(String.valueOf(String.format("%d", Integer.valueOf(curspeed))) + " Km/h");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEngineSpeed() {
        int enginespeed = DataCanbus.DATA[95];
        int enginespeedenable = DataCanbus.DATA[99];
        if (findViewById(R.id.layout_view4) != null) {
            if (enginespeedenable == 0) {
                findViewById(R.id.layout_view4).setVisibility(8);
                return;
            }
            findViewById(R.id.layout_view4).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text4)) != null) {
                if (enginespeed == 65535) {
                    ((TextView) findViewById(R.id.tv_text4)).setText("---");
                } else {
                    ((TextView) findViewById(R.id.tv_text4)).setText(String.valueOf(String.format("%d", Integer.valueOf(enginespeed))) + " R/min");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisUnit() {
        int disunit = DataCanbus.DATA[96];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            if (disunit == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_1);
            } else {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_jianianhua_show__metric_unit_0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit() {
        int tempunit = DataCanbus.DATA[97];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            if (tempunit == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_15ruijie_temp_unit_f_set);
            } else {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_15ruijie_temp_unit_c_set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguage() {
        int language = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            if (language == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set0);
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_language_set1);
            }
        }
    }
}
