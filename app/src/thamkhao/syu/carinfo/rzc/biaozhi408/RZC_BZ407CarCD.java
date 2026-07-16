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
public class RZC_BZ407CarCD extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static RZC_BZ407CarCD mInit;
    int rpt = 0;
    int INT = 0;
    int rand = 0;
    int value = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.biaozhi408.RZC_BZ407CarCD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 206:
                case 213:
                    if (3 == DataCanbus.DATA[206]) {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("Disc Box: " + DataCanbus.DATA[213]);
                    } else {
                        ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text1)).setText("");
                    }
                    break;
                case 214:
                case 215:
                    int track = DataCanbus.DATA[214];
                    int Totaltrack = DataCanbus.DATA[215];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text2)).setText("Trcak: " + track + "/" + Totaltrack);
                    break;
                case 216:
                case 217:
                    int min = DataCanbus.DATA[216];
                    int sec = DataCanbus.DATA[217];
                    ((TextView) RZC_BZ407CarCD.this.findViewById(R.id.tv_text3)).setText(String.valueOf(min / 10) + (min % 10) + ":" + (sec / 10) + (sec % 10));
                    break;
                case 218:
                    RZC_BZ407CarCD.this.UpdataRepeat();
                    break;
                case 219:
                    RZC_BZ407CarCD.this.UpdataScan();
                    break;
                case 220:
                    RZC_BZ407CarCD.this.UpdataRandom();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0281_lz_psa_407_carcd);
        mInit = this;
        findViewById(R.id.tv_text4).setOnTouchListener(this);
        findViewById(R.id.tv_text5).setOnTouchListener(this);
        findViewById(R.id.tv_text6).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_text4 /* 2131427465 */:
                if (this.rpt == 1) {
                    this.rpt = 0;
                } else {
                    this.rpt = 1;
                }
                break;
            case R.id.tv_text5 /* 2131427468 */:
                if (this.INT == 1) {
                    this.INT = 0;
                } else {
                    this.INT = 1;
                }
                break;
            case R.id.tv_text6 /* 2131427471 */:
                if (this.rand == 1) {
                    this.rand = 0;
                } else {
                    this.rand = 1;
                }
                break;
        }
        this.value = ((this.rpt << 2) & 4) | ((this.INT << 1) & 2) | (this.rand & 1);
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
        FuncMain.setChannel(13);
        addNotify();
        if (DataCanbus.DATA[206] != 2 && DataCanbus.DATA[206] != 3) {
            sendCmd(2, this.value);
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
        DataCanbus.NOTIFY_EVENTS[214].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[215].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[216].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[217].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[213].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[218].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[219].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[220].addNotify(this.notifyCanbus, 1);
        this.rpt = DataCanbus.DATA[218];
        this.INT = DataCanbus.DATA[219];
        this.rand = DataCanbus.DATA[220];
        this.value = ((this.rpt << 2) & 4) | ((this.INT << 1) & 2) | (this.rand & 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[214].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[215].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[216].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[217].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[213].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[218].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[219].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[220].removeNotify(this.notifyCanbus);
    }

    public void UpdataRandom() {
        int value = DataCanbus.DATA[220];
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
        int value = DataCanbus.DATA[219];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText("INT: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text5)).setText("INT: On");
                break;
        }
    }

    public void UpdataRepeat() {
        int value = DataCanbus.DATA[218];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: Off");
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text4)).setText("Repeat: On");
                break;
        }
    }
}
