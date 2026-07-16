package com.syu.carinfo.xp.psa_all;

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
public class LZPsaAllCarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static LZPsaAllCarCD mInit;
    int carid = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.psa_all.LZPsaAllCarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 184:
                case 194:
                    LZPsaAllCarCD.this.carid = DataCanbus.DATA[184];
                    if (3 == DataCanbus.DATA[184]) {
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[194]);
                        LZPsaAllCarCD.this.UpdataRepeat();
                        LZPsaAllCarCD.this.UpdataScan();
                        LZPsaAllCarCD.this.UpdataRandom();
                    } else {
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text1)).setText("Car CD");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text4)).setText("");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text5)).setText("");
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text6)).setText("");
                    }
                    break;
                case 190:
                case 191:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int track = DataCanbus.DATA[190];
                        int Totaltrack = DataCanbus.DATA[191];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                    }
                    break;
                case 192:
                case 193:
                    if (LZPsaAllCarCD.this.carid == 2) {
                        int min = DataCanbus.DATA[192];
                        int sec = DataCanbus.DATA[193];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    }
                    break;
                case 195:
                case 196:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int track2 = DataCanbus.DATA[195];
                        int Totaltrack2 = DataCanbus.DATA[196];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track2 + "/" + Totaltrack2);
                    }
                    break;
                case 197:
                case 198:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        int min2 = DataCanbus.DATA[197];
                        int sec2 = DataCanbus.DATA[198];
                        ((TextView) LZPsaAllCarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min2 / 10) + (min2 % 10) + ":" + (sec2 / 10) + (sec2 % 10));
                    }
                    break;
                case 199:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRepeat();
                    }
                    break;
                case 200:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataScan();
                    }
                    break;
                case 201:
                    if (LZPsaAllCarCD.this.carid == 3) {
                        LZPsaAllCarCD.this.UpdataRandom();
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[201];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text6)).setText("Random: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text6)).setText("Random: On");
                break;
        }
    }

    public void UpdataScan() {
        int value = DataCanbus.DATA[200];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText("Scan: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText("Scan: On");
                break;
        }
    }

    public void UpdataRepeat() {
        int value = DataCanbus.DATA[199];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: On");
                break;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
