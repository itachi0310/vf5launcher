package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0439_XBS_09Tianlai;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class XBS09TianlaiCarRadioAct extends BaseActivity {
    public static XBS09TianlaiCarRadioAct mInstance;
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 96:
                        XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                        break;
                    case 97:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                        break;
                    case 98:
                        XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                        break;
                    case 99:
                        XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                        break;
                    case 100:
                        XBS09TianlaiCarRadioAct.this.updaterRadioText();
                        break;
                    case 101:
                        XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                        break;
                    case 103:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                        break;
                    case 104:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                        break;
                    case 105:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                        break;
                    case 106:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                        break;
                    case 107:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                        break;
                    case 108:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                        break;
                    case 109:
                        XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                        break;
                }
            }
            switch (updateCode) {
                case 96:
                    XBS09TianlaiCarRadioAct.this.updaterRadioRdsOnOff();
                    break;
                case 97:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSCANOnOff();
                    break;
                case 98:
                    XBS09TianlaiCarRadioAct.this.updaterRadioSTOnOff();
                    break;
                case 99:
                    XBS09TianlaiCarRadioAct.this.updaterRadioAUTOOnOff();
                    break;
                case 100:
                    XBS09TianlaiCarRadioAct.this.updaterRadioText();
                    break;
                case 101:
                    XBS09TianlaiCarRadioAct.this.updaterRadioBand();
                    break;
                case 103:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq();
                    break;
                case 104:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq1();
                    break;
                case 105:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq2();
                    break;
                case 106:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq3();
                    break;
                case 107:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq4();
                    break;
                case 108:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq5();
                    break;
                case 109:
                    XBS09TianlaiCarRadioAct.this.updaterRadioFreq6();
                    break;
            }
        }
    };
    int radioband = 1;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
                setContentView(R.layout.layout_xbs_09tianlai_carradio_9853);
            } else {
                setContentView(R.layout.layout_xbs_09tianlai_carradio);
            }
        } else {
            setContentView(R.layout.layout_xbs_09tianlai_carradio);
        }
        mInstance = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        addNotify();
        FuncMain.setChannel(13);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioText() {
        int value = DataCanbus.DATA[100];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[100];
        }
        if (value == 1) {
            ((TextView) findViewById(R.id.radio_text)).setText(Callback_0439_XBS_09Tianlai.CarRadioText);
        } else {
            ((TextView) findViewById(R.id.radio_text)).setText("--------");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq6() {
        int value;
        int value2 = DataCanbus.DATA[109];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[109];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq6)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq5() {
        int value;
        int value2 = DataCanbus.DATA[108];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[108];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq5)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq4() {
        int value;
        int value2 = DataCanbus.DATA[107];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[107];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq4)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq3() {
        int value;
        int value2 = DataCanbus.DATA[106];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[106];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq3)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq2() {
        int value;
        int value2 = DataCanbus.DATA[105];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[105];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq2)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq1() {
        int value;
        int value2 = DataCanbus.DATA[104];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[104];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value) + " Khz");
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq1)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100) + " mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioFreq() {
        int value;
        int value2 = DataCanbus.DATA[103];
        if (DataCanbus.DATA[1000] == 458942) {
            value2 = DataCanbus.DATA[103];
        }
        switch (this.radioband) {
            case 1:
            case 2:
                if (((value2 >> 15) & 1) == 1) {
                    value = (((value2 & 32767) - 1) * 10) + 530;
                } else {
                    value = ((value2 - 1) * 9) + 531;
                }
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder(String.valueOf(value)).toString());
                break;
            default:
                int value3 = ((value2 - 1) * 5) + 8750;
                ((TextView) findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value3 / 100) + "." + (value3 % 100));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioBand() {
        this.radioband = DataCanbus.DATA[101];
        if (DataCanbus.DATA[1000] == 458942) {
            this.radioband = DataCanbus.DATA[101];
        }
        switch (this.radioband) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Am2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm1");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm2");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("Fm3");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioAUTOOnOff() {
        int value = DataCanbus.DATA[99];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[99];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_auto)).setText("AUTO:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioSTOnOff() {
        int value = DataCanbus.DATA[98];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[98];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_st)).setText("ST:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioSCANOnOff() {
        int value = DataCanbus.DATA[97];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[97];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_scan)).setText("SCAN:Off");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRadioRdsOnOff() {
        int value = DataCanbus.DATA[96];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[96];
        }
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:On");
                break;
            default:
                ((TextView) findViewById(R.id.radio_rds)).setText("RDS:Off");
                break;
        }
    }
}
