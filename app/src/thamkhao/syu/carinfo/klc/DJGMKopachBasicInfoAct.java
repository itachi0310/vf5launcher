package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class DJGMKopachBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.DJGMKopachBasicInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 36:
                    DJGMKopachBasicInfoAct.this.updaterOutTemp();
                    break;
                case 40:
                    DJGMKopachBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 134:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km/h");
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text4)).setText("--. km/h");
                    }
                    break;
                case 135:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                    }
                    break;
                case 136:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " l/100km");
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text6)).setText("--.- l/100km");
                    }
                    break;
                case 137:
                    int hour = (value >> 8) & 255;
                    int min = value & 255;
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + ":" + min);
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text5)).setText("--:--");
                    }
                    break;
                case 138:
                    if (value > 0) {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                    } else {
                        ((TextView) DJGMKopachBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0025_dj_gm_kopach_basic_info);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(8, new int[]{104}, null, null);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[36];
        int flag = 0;
        if ((value & 128) != 0) {
            value = 256 - value;
            flag = 1;
        }
        if (SystemProperties.getInt("persist.fyt.temperature", 0) == 1) {
            if (flag == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(((value * 9) / 5) + 32) + "℉");
                return;
            } else {
                ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf((320 - (value * 18)) / 10) + "℉");
                return;
            }
        }
        if (flag == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "℃");
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText("-" + value + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[40];
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
