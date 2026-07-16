package com.syu.carinfo.xp.ylford;

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
public class YLFordCarSet extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 117:
                    YLFordCarSet.this.mTowsystem();
                    break;
                case 118:
                    YLFordCarSet.this.mInformation();
                    break;
                case 119:
                    YLFordCarSet.this.mWarning();
                    break;
                case 120:
                    YLFordCarSet.this.mBrightness();
                    break;
                case 121:
                    YLFordCarSet.this.mUnit();
                    break;
                case 122:
                    YLFordCarSet.this.mVoicemode();
                    break;
                case 123:
                    YLFordCarSet.this.mTurnlight();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_yl_carset);
        ((Button) findViewById(R.id.xp_ylford_brightness_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_brightness_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[120] & 255;
                if (value2 == 0) {
                    value = 17;
                } else {
                    value = 16;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_unit_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[121] & 255;
                if (value2 == 0) {
                    value = 15;
                } else {
                    value = 14;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[117] & 255;
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[118] & 255;
                if (value2 == 0) {
                    value = 6;
                } else {
                    value = 5;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value;
                int value2 = DataCanbus.DATA[119] & 255;
                if (value2 == 0) {
                    value = 8;
                } else {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_turnlight_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[123] & 255;
                if (value2 == 0) {
                    value = 4;
                } else {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 < 4) {
                    value = value2 + 10;
                } else {
                    value = 9;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
            }
        });
        ((Button) findViewById(R.id.xp_ylford_voice_mode_set_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.xp.ylford.YLFordCarSet.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[122] & 255;
                if (value2 > 0) {
                    value = value2 + 8;
                } else {
                    value = 13;
                }
                DataCanbus.PROXY.cmd(2, new int[]{163, value, 0, 0}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTowsystem() {
        int temp = DataCanbus.DATA[117] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_set_tow_system_switch)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mInformation() {
        int temp = DataCanbus.DATA[118] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_information_point_state)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mWarning() {
        int temp = DataCanbus.DATA[119] & 65535;
        if (((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)) != null) {
            ((CheckedTextView) findViewById(R.id.xp_ylford_warning_point_state)).setChecked(temp == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mVoicemode() {
        int temp = DataCanbus.DATA[122] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_onstar_close);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.xp_ylford_set_voice_mode3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.xp_ylford_voice_mode_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mBrightness() {
        int temp = DataCanbus.DATA[120] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_brightness_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_Manual);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_brightness_set_show)).setText(R.string.klc_air_auto);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mTurnlight() {
        int temp = DataCanbus.DATA[123] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_turnlight_set_show)).setText(R.string.wc_jianianhua_show_turnlights_point_1);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUnit() {
        int temp = DataCanbus.DATA[121] & 65535;
        if (((TextView) findViewById(R.id.xp_ylford_unit_set_show)) != null) {
            switch (temp) {
                case 0:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.xp_ylford_unit_set_show)).setText(R.string.wc_jianianhua_show__metric_unit_1);
                    break;
            }
        }
    }
}
