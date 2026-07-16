package com.syu.carinfo.rzc.keleijia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class KeLeiJiaRadarSetting extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaRadarSetting.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 141:
                    if (((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)) != null) {
                        if (value == 1) {
                            ((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)).setText(R.string.str_388_sound_beep);
                        } else {
                            ((TextView) KeLeiJiaRadarSetting.this.findViewById(R.id.tv_text1)).setText(R.string.str_boyue_str13);
                        }
                    }
                    break;
                case 142:
                    ((CheckedTextView) KeLeiJiaRadarSetting.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_keleijia_radar_setting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaRadarSetting.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141] - 1;
                if (value < 0) {
                    value = 1;
                }
                int onoff = DataCanbus.DATA[142];
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaRadarSetting.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[141] + 1;
                if (value > 1) {
                    value = 0;
                }
                int onoff = DataCanbus.DATA[142];
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.keleijia.KeLeiJiaRadarSetting.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int onoff;
                int value = DataCanbus.DATA[141];
                int onoff2 = DataCanbus.DATA[142];
                if (onoff2 == 1) {
                    onoff = 0;
                } else {
                    onoff = 1;
                }
                DataCanbus.PROXY.cmd(2, new int[]{value, onoff}, null, null);
            }
        });
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }
}
