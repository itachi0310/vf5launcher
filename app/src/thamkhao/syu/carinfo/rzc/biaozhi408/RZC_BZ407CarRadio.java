package com.syu.carinfo.rzc.biaozhi408;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZC_BZ407CarRadio extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static RZC_BZ407CarRadio mInit;
    int rdtest = 0;
    int rds = 0;
    int ta = 0;
    int reg = 0;
    int value = 0;
    byte unit = 0;
    int band = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarRadio.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 207:
                    RZC_BZ407CarRadio.this.updateRadioBand();
                    break;
                case 208:
                    if (RZC_BZ407CarRadio.this.unit == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(new StringBuilder().append(value).toString());
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.dj_lexus_radio_freq)).setText(String.valueOf(value / 10) + "." + (value % 10));
                    }
                    break;
                case 209:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text1)).setText("RDTEST： ON");
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text1)).setText("RDTEST： OFF");
                    }
                    break;
                case 210:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text2)).setText("RDS： ON");
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text2)).setText("RDS： OFF");
                    }
                    break;
                case 211:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text3)).setText("TA： ON");
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text3)).setText("TA： OFF");
                    }
                    break;
                case 212:
                    if (value == 1) {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text5)).setText("REG： ON");
                    } else {
                        ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text5)).setText("REG： OFF");
                    }
                    break;
                case 221:
                    ((TextView) RZC_BZ407CarRadio.this.findViewById(R.id.tv_text4)).setText(Const_RZC4_PSA_ALL_DATA.RadioText);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0339_rzc_psa_407_carradio);
        mInit = this;
        findViewById(R.id.tv_text1).setOnTouchListener(this);
        findViewById(R.id.tv_text2).setOnTouchListener(this);
        findViewById(R.id.tv_text3).setOnTouchListener(this);
        findViewById(R.id.tv_text5).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_text1 /* 2131427456 */:
                if (this.rdtest == 1) {
                    this.rdtest = 0;
                } else {
                    this.rdtest = 1;
                }
                break;
            case R.id.tv_text2 /* 2131427459 */:
                if (this.rds == 1) {
                    this.rds = 0;
                } else {
                    this.rds = 1;
                }
                break;
            case R.id.tv_text3 /* 2131427462 */:
                if (this.ta == 1) {
                    this.ta = 0;
                } else {
                    this.ta = 1;
                }
                break;
            case R.id.tv_text5 /* 2131427468 */:
                if (this.reg == 1) {
                    this.reg = 0;
                } else {
                    this.reg = 1;
                }
                break;
        }
        this.value = ((this.rdtest << 3) & 8) | ((this.rds << 2) & 4) | ((this.ta << 1) & 2) | (this.reg & 1);
        if (event.getAction() == 0) {
            sendCmd(DataCanbus.DATA[206], this.value);
        }
        return false;
    }

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(90, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(11);
        addNotify();
        if (DataCanbus.DATA[206] != 1) {
            sendCmd(1, this.value);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[208].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[209].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[210].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[211].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[212].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[221].addNotify(this.notifyCanbus, 1);
        this.rdtest = DataCanbus.DATA[209];
        this.rds = DataCanbus.DATA[210];
        this.ta = DataCanbus.DATA[211];
        this.reg = DataCanbus.DATA[212];
        this.value = ((this.rdtest << 3) & 8) | ((this.rds << 2) & 4) | ((this.ta << 1) & 2) | (this.reg & 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[208].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[209].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[210].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[211].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[212].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[221].removeNotify(this.notifyCanbus);
    }

    public void updateRadioBand() {
        int value = DataCanbus.DATA[207];
        switch (value) {
            case 1:
            case 2:
            case 3:
                this.unit = (byte) 0;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("FM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Mhz");
                break;
            case 4:
                this.unit = (byte) 1;
                ((TextView) findViewById(R.id.dj_lexus_radio_band)).setText("AM");
                ((TextView) findViewById(R.id.dj_lexus_radio_unit)).setText("Khz");
                break;
        }
    }
}
