package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WCLeepMotorCurrentCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCLeepMotorCurrentCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    if (value == 65535) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10) + "." + (value % 10) + " kWh/100km");
                    }
                    break;
                case 96:
                    if (value == 16777215) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km");
                    }
                    break;
                case 97:
                    int hour = (value >> 8) & 65535;
                    int min = value & 255;
                    if (value == 16777215) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(hour / 10) + "H" + min + "M");
                    }
                    break;
                case 98:
                    if (value == 255) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 99:
                    if (value == 255) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 100:
                    if (value == 255) {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                    } else {
                        ((TextView) WCLeepMotorCurrentCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_leepmotor_cur_carinfo);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
    }
}
