package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0001_WC1_DaZhong;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: classes.dex */
public class DasAutoWcAct extends BaseActivity {
    public Callback_0001_WC1_DaZhong mCallback = null;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.DasAutoWcAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    DasAutoWcAct.this.updaterDoor();
                    DasAutoWcAct.this.updaterDoorBack();
                    break;
                case 94:
                    DasAutoWcAct.this.updaterTrip();
                    break;
                case 95:
                    DasAutoWcAct.this.updaterLastOilWarning();
                    break;
                case 96:
                    DasAutoWcAct.this.updaterBatteryVolWarning();
                    break;
                case 97:
                    DasAutoWcAct.this.updaterSafetyBelt();
                    break;
                case 98:
                    DasAutoWcAct.this.updaterCleanLiquid();
                    break;
                case 99:
                    DasAutoWcAct.this.updaterLastOil();
                    break;
                case 100:
                    DasAutoWcAct.this.updaterBatteryVol();
                    break;
                case 101:
                    DasAutoWcAct.this.updaterDrivingMileage();
                    break;
                case 106:
                    DasAutoWcAct.this.updaterWater();
                    break;
                case 107:
                    DasAutoWcAct.this.updaterEngine();
                    break;
                case 108:
                    DasAutoWcAct.this.updaterCurrentVelocity();
                    break;
                case 109:
                    DasAutoWcAct.this.updaterEngineSpeed();
                    break;
                case 114:
                    DasAutoWcAct.this.updaterOutTemp();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dasauto_wc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.dasauto_btn_setting_wc).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoWcAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DasAutoWcAct.this.startActivity(new Intent(TheApp.getInstance(), (Class<?>) DasAutoSettingAct.class));
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0001_WC1_DaZhong)) {
            finish();
        } else {
            this.mCallback = (Callback_0001_WC1_DaZhong) callback;
            addNotify();
        }
        if (TheApp.getScreenWidth() != 800) {
            DoorHelper.disableDoorWindowLocal(true);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEngineSpeed() {
        int value = DataCanbus.DATA[109];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCurrentVelocity() {
        int value = DataCanbus.DATA[108];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDrivingMileage() {
        int value = DataCanbus.DATA[101];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value / 10.0f) + " Mil");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_mileage_wc)).setText("--.-- Mil");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSafetyBelt() {
        int value = DataCanbus.DATA[97];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCleanLiquid() {
        int value = DataCanbus.DATA[98];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBatteryVol() {
        int value = DataCanbus.DATA[100];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrip() {
        int value = DataCanbus.DATA[94];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBatteryVolWarning() {
        int value = DataCanbus.DATA[96];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEngine() {
        int value = DataCanbus.DATA[107];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[114];
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)) != null) {
            int mValue = (value * 5) - 400;
            if (mValue > 500) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText("--.-- °C");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText(String.valueOf(mValue * 0.1f) + " °C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLastOil() {
        int value = DataCanbus.DATA[99];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText(String.valueOf(value) + " L");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText("--.-- L");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWater() {
        int value = DataCanbus.DATA[106];
        if (value == 255) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText("--.--");
        } else if (value == 0) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(R.string.normal);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(String.valueOf(value) + " °C");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLastOilWarning() {
        int value = DataCanbus.DATA[95];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_wc)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_wc)).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoorBack() {
        int value = DataCanbus.DATA[47];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc_icon)).setVisibility(8);
        }
    }
}
