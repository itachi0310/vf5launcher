package com.syu.carinfo.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class FordCarInfo2 extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarInfo2.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 138:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    break;
                case 139:
                    if (value > 999) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText("-- km");
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 140:
                    int value2 = (value * 2) + 1;
                    if (value2 > 300) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText("---- L/100km");
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + " L/100km");
                    }
                    break;
                case 141:
                    int temp = value / 2;
                    if (temp > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText("-- L");
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text3)).setText(String.format("%d L", Integer.valueOf(temp)));
                    }
                    break;
                case 239:
                    if (value == 255) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText("-- km/h");
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value) + " km/h");
                    }
                    break;
                case 240:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 2) + " km");
                    break;
                case 241:
                    if (value > 100) {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText("-- ");
                    } else {
                        ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 242:
                    ((TextView) FordCarInfo2.this.findViewById(R.id.tv_text7)).setText(String.valueOf((((value * 470) / 755) + 30) / 10.0f) + " V");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_carinfo2);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{66, 0}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{105, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
    }
}
