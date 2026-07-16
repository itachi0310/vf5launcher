package com.syu.carinfo.rzc.andra;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class LzNissan05CimaCarInfo extends BaseActivity implements View.OnClickListener {
    int unit = 0;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.andra.LzNissan05CimaCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                    break;
                case 96:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " mph");
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + " km/h");
                    }
                    break;
                case 97:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 99:
                    if (LzNissan05CimaCarInfo.this.unit == 1) {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) LzNissan05CimaCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 101:
                    LzNissan05CimaCarInfo.this.unit = value;
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_lz_nissan_05cima_carinfo);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{53, 0}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{55, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }
}
