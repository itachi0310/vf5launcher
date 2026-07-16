package com.syu.carinfo.rzc.xima;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZC_Guanzhi_CarinfoAct extends BaseActivity implements View.OnClickListener {
    int mileunit = 0;
    int oilunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.RZC_Guanzhi_CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    RZC_Guanzhi_CarinfoAct.this.mileunit = value;
                    break;
                case 111:
                    RZC_Guanzhi_CarinfoAct.this.oilunit = value;
                    break;
                case 117:
                    if (RZC_Guanzhi_CarinfoAct.this.mileunit == 1) {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 118:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                    break;
                case 119:
                    switch (RZC_Guanzhi_CarinfoAct.this.oilunit) {
                        case 0:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                            break;
                        case 1:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 2:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                            break;
                    }
                    break;
                case 120:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 121:
                    ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                    break;
                case 122:
                    if (RZC_Guanzhi_CarinfoAct.this.mileunit == 1) {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " miles");
                    } else {
                        ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km");
                    }
                    break;
                case 123:
                    switch (RZC_Guanzhi_CarinfoAct.this.oilunit) {
                        case 0:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " L/100km");
                            break;
                        case 1:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " mpg");
                            break;
                        case 2:
                            ((TextView) RZC_Guanzhi_CarinfoAct.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/L");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0454_rzc_guanzhi_carinfo);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }
}
