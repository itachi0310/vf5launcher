package com.syu.carinfo.luz.binli;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class BinliCarInfo extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.luz.binli.BinliCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 114:
                    if (DataCanbus.DATA[119] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_tianlaigongjue_drive_enable)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 115:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " Rpm");
                    break;
                case 116:
                    if (DataCanbus.DATA[119] == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 117:
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 120:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else if (((DataCanbus.DATA[123] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 121:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else if (((DataCanbus.DATA[123] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[123] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[123] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 122:
                    if (((DataCanbus.DATA[123] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " MPH");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " Km/H");
                    }
                    break;
                case 124:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText("----");
                    } else if (((DataCanbus.DATA[128] >> 7) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Mil");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " Km");
                    }
                    break;
                case 125:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText("----");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 126:
                    if (value == 65535) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText("----");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 0) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                    } else if (((DataCanbus.DATA[128] >> 5) & 3) == 2) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10) + " MPG");
                    }
                    break;
                case 127:
                    if (((DataCanbus.DATA[128] >> 4) & 1) == 1) {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " MPH");
                    } else {
                        ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " Km/H");
                    }
                    break;
                case 129:
                    int h = (value >> 8) & 255;
                    int m = value & 255;
                    ((TextView) BinliCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(h) + " H" + m + " M");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_binli_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
    }
}
