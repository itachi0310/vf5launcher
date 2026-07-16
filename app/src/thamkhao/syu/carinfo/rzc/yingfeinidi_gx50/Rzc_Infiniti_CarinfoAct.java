package com.syu.carinfo.rzc.yingfeinidi_gx50;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class Rzc_Infiniti_CarinfoAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.Rzc_Infiniti_CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                case 103:
                    int unit = DataCanbus.DATA[100];
                    int value = DataCanbus.DATA[103];
                    switch (unit) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " miles");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " km");
                            break;
                    }
                    break;
                case 101:
                case 102:
                    int unit2 = DataCanbus.DATA[101];
                    int value2 = DataCanbus.DATA[102];
                    switch (unit2) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + " miles");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value2) + " km");
                            break;
                    }
                    break;
                case 104:
                case 106:
                    int unit3 = DataCanbus.DATA[104];
                    int value3 = DataCanbus.DATA[106];
                    switch (unit3) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " l/100km");
                            break;
                        case 2:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " km/l");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " mpg");
                            break;
                    }
                    break;
                case 105:
                case 107:
                    int unit4 = DataCanbus.DATA[105];
                    int value4 = DataCanbus.DATA[107];
                    switch (unit4) {
                        case 1:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " l/100km");
                            break;
                        case 2:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " km/l");
                            break;
                        default:
                            ((TextView) Rzc_Infiniti_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value4 / 10) + "." + (value4 % 10) + " mpg");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_infiniti_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{39, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{41, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
    }
}
