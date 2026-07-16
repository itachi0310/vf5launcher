package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class PAJeepPowerFlowAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepPowerFlowAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 237:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)).setText("-" + (65536 - value) + " KW");
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KW");
                        }
                    }
                    break;
                case 238:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)).setText("-" + (65536 - value) + " KW");
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " KW");
                        }
                    }
                    break;
                case 239:
                    if (((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)) != null) {
                        if ((value & 32768) != 0) {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)).setText("-" + (65536 - value) + " KW");
                        } else {
                            ((TextView) PAJeepPowerFlowAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " KW");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_power_flow);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(4, new int[]{83}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
    }
}
