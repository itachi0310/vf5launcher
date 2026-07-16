package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class ODJMCEV3CarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.bnr.guanzhi.ODJMCEV3CarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 123:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 124:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value - 40) + " ℃");
                    break;
                case 125:
                case 126:
                    int msb = DataCanbus.DATA[125];
                    int lsb = DataCanbus.DATA[126];
                    int value2 = ((msb << 8) & 65280) | (lsb & 255);
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value2 / 1000) + "." + ((value2 % 1000) / 100) + ((value2 % 100) / 10) + (value2 % 10) + " V");
                    break;
                case 127:
                case 128:
                    int msb2 = DataCanbus.DATA[127];
                    int lsb2 = DataCanbus.DATA[128];
                    int value3 = ((msb2 << 8) & 65280) | (lsb2 & 255);
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value3 / 1000) + "." + ((value3 % 1000) / 100) + ((value3 % 100) / 10) + (value3 % 10) + " V");
                    break;
                case 129:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 130:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 131:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 132:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value - 50) + " ℃");
                    break;
                case 133:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 134:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 135:
                    ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
                case 136:
                    switch (value) {
                        case 1:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("放电中");
                            break;
                        case 2:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("快充中");
                            break;
                        case 3:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("慢充中");
                            break;
                        default:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text12)).setText("----");
                            break;
                    }
                    break;
                case 137:
                    switch (value) {
                        case 1:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("停车充电");
                            break;
                        case 2:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("行驶充电");
                            break;
                        case 3:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("未充电");
                            break;
                        case 4:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("充电完成");
                            break;
                        default:
                            ((TextView) ODJMCEV3CarInfo.this.findViewById(R.id.tv_text13)).setText("----");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jmc_ev3_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{39, 1}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{39, 2}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{39, 3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
    }
}
