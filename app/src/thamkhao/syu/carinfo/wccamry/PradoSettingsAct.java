package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class PradoSettingsAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    PradoSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 99:
                    PradoSettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 100:
                    PradoSettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 101:
                    PradoSettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 102:
                    PradoSettingsAct.this.mUpdaterAutoAc();
                    break;
                case 103:
                    PradoSettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 104:
                    PradoSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 105:
                    PradoSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 106:
                    PradoSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 107:
                    PradoSettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 108:
                    PradoSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 109:
                    PradoSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 110:
                    PradoSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 115:
                    PradoSettingsAct.this.mUpdaterRadarSwitch();
                    break;
                case 116:
                    PradoSettingsAct.this.mUpdaterRadarAlarmVol();
                    break;
                case 118:
                    PradoSettingsAct.this.mUpdaterRadarfrontRange();
                    break;
                case 119:
                    PradoSettingsAct.this.mUpdaterRadarrearRange();
                    break;
                case 122:
                    PradoSettingsAct.this.mUpdaterDsplinkspeed();
                    break;
                case 123:
                    PradoSettingsAct.this.mUpdaterDspsurround();
                    break;
                case 127:
                    PradoSettingsAct.this.mUpdaterOutLightOffTime();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_18pardo_settings);
        init();
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
    public void init() {
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[99] == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[109] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[101] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[100] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[104] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[110] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[102] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[103] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_sens_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 > 0 && value2 - 1 > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_sens_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_interior_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_interior_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(12, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_out_lighting_off_time_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_out_lighting_off_time_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[127];
                if (value < 3) {
                    DataCanbus.PROXY.cmd(21, new int[]{value + 1}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[115] == 0) {
                    DataCanbus.PROXY.cmd(24, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(24, new int[1], null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_alarm_volume_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value > 1) {
                    DataCanbus.PROXY.cmd(25, new int[]{value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_alarm_volume_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[116];
                if (value < 5) {
                    DataCanbus.PROXY.cmd(25, new int[]{value + 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_front_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_front_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{1}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_rear_range_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{2}, null, null);
            }
        });
        ((Button) findViewById(R.id.rav4_btn_radar_rear_range)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DataCanbus.PROXY.cmd(26, new int[]{2}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[122] == 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(19, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.PradoSettingsAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[123] == 0) {
                    DataCanbus.PROXY.cmd(20, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(20, new int[1], null, null);
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            try {
                Intent intent = new Intent();
                intent.setClass(this, Rav4TripAct.class);
                startActivity(intent);
                finish();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDsplinkspeed() {
        int value = DataCanbus.DATA[122];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_vol_link_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDspsurround() {
        int value = DataCanbus.DATA[123];
        if (((CheckedTextView) findViewById(R.id.pardo_btn_surround)) != null) {
            ((CheckedTextView) findViewById(R.id.pardo_btn_surround)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[99];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_speed)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_intelligent_door)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.rav4_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.rav4_tv_lock_set_unlock_intelligent_door)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_driver_door_linkage)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[101];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autounlock_by_shift_to_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[100];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_autolock_by_shift_from_p)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_lock_unlock_emergency_flashers_response)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[104];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_remote_2_press_unlock)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_intelligent_lock_and_one_key_start)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_lock_set_unlock_operation_key_two_times)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[102];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_auto_ac_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[103];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_valid_ventilation_enabled)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.rav4_tv_interior_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_interior_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutLightOffTime() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.rav4_tv_out_lighting_off_time)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_out_lighting_off_time)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.rav4_tv_sens_cur)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.rav4_tv_sens_cur)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarSwitch() {
        int value = DataCanbus.DATA[115];
        if (((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)) != null) {
            ((CheckedTextView) findViewById(R.id.rav4_btn_radar_switch)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarAlarmVol() {
        int value = DataCanbus.DATA[116];
        if (((TextView) findViewById(R.id.rav4_tv_radar_alarm_volume)) != null && value >= 1 && value < 6) {
            ((TextView) findViewById(R.id.rav4_tv_radar_alarm_volume)).setBackgroundResource(ConstWcToyota.mSensDrawableId[value - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarfrontRange() {
        int mFrontRamge = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.rav4_tv_radar_front_range)) != null) {
            if (mFrontRamge == 1) {
                ((TextView) findViewById(R.id.rav4_tv_radar_front_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.rav4_tv_radar_front_range)).setText(R.string.radar_range_level2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRadarrearRange() {
        int mRearRamge = DataCanbus.DATA[119];
        if (((TextView) findViewById(R.id.rav4_tv_radar_rear_range)) != null) {
            if (mRearRamge == 1) {
                ((TextView) findViewById(R.id.rav4_tv_radar_rear_range)).setText(R.string.radar_range_level1);
            } else {
                ((TextView) findViewById(R.id.rav4_tv_radar_rear_range)).setText(R.string.radar_range_level2);
            }
        }
    }
}
