package com.syu.carinfo.wc.ruijie15;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WCYiboCarSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.WCYiboCarSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 104:
                    WCYiboCarSetAct.this.updaterTrationCtrl();
                    break;
                case 105:
                    WCYiboCarSetAct.this.updaterTurnLight();
                    break;
                case 106:
                    WCYiboCarSetAct.this.updaterMilieoLight();
                    break;
                case 107:
                    WCYiboCarSetAct.this.updaterMeasurUnit();
                    break;
                case 108:
                    WCYiboCarSetAct.this.updaterMessagePrompt();
                    break;
                case 109:
                    WCYiboCarSetAct.this.updaterWarnPrompt();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc2_yibo_car_set);
        setUI();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_yibo_turnlight_set_check /* 2131432979 */:
                int value = DataCanbus.DATA[105];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 3, value}, null, null);
                break;
            case R.id.wc_15ruijie_mile_unit_set_check /* 2131432981 */:
                int value2 = DataCanbus.DATA[107];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 5, value2}, null, null);
                break;
            case R.id.wc_yibo_milieulight_set_check /* 2131432983 */:
                int value3 = DataCanbus.DATA[106];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 4, value3}, null, null);
                break;
            case R.id.wc_yibo_message_prompt_set_check /* 2131432984 */:
                int value4 = DataCanbus.DATA[108];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 6, value4}, null, null);
                break;
            case R.id.wc_yibo_warn_prompt_set_check /* 2131432985 */:
                int value5 = DataCanbus.DATA[109];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{108, 7, value5}, null, null);
                break;
            case R.id.wc_yibo_traction_set_check /* 2131432986 */:
                int value6 = DataCanbus.DATA[104];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{138, 3, value6}, null, null);
                break;
        }
    }

    private void setUI() {
        findViewById(R.id.wc_yibo_turnlight_set_check).setOnClickListener(this);
        findViewById(R.id.wc_15ruijie_mile_unit_set_check).setOnClickListener(this);
        findViewById(R.id.wc_yibo_milieulight_set_check).setOnClickListener(this);
        findViewById(R.id.wc_yibo_message_prompt_set_check).setOnClickListener(this);
        findViewById(R.id.wc_yibo_warn_prompt_set_check).setOnClickListener(this);
        findViewById(R.id.wc_yibo_traction_set_check).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnPrompt() {
        int value = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.wc_yibo_warn_prompt_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMessagePrompt() {
        int value = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.wc_yibo_message_prompt_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMeasurUnit() {
        int value = DataCanbus.DATA[107];
        if (value == 1) {
            ((TextView) findViewById(R.id.wc_15ruijie_mile_unit_c_set_tv)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.wc_15ruijie_mile_unit_c_set_tv)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.wc_15ruijie_mile_unit_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMilieoLight() {
        int value = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.wc_yibo_milieulight_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrationCtrl() {
        int value = DataCanbus.DATA[104];
        ((CheckedTextView) findViewById(R.id.wc_yibo_traction_set_check)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnLight() {
        int value = DataCanbus.DATA[105];
        if (value == 1) {
            ((TextView) findViewById(R.id.wc_yibo_turnlight_set_tv)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
        } else {
            ((TextView) findViewById(R.id.wc_yibo_turnlight_set_tv)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
        }
        ((CheckedTextView) findViewById(R.id.wc_yibo_turnlight_set_check)).setChecked(value != 0);
    }
}
