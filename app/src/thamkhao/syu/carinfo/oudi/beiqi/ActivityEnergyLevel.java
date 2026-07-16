package com.syu.carinfo.oudi.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: classes.dex */
public class ActivityEnergyLevel extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.beiqi.ActivityEnergyLevel.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                    int value = DataCanbus.DATA[updateCode];
                    switch (updateCode) {
                        case 106:
                            ActivityEnergyLevel.this.updateCarState2();
                            break;
                        case 108:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                        case 109:
                            ActivityEnergyLevel.this.updateCarState2();
                            break;
                        case 111:
                            int hour = value / 60;
                            int min = value % 60;
                            ((TextView) ActivityEnergyLevel.this.findViewById(R.id.tv_text1)).setText(String.valueOf(ActivityEnergyLevel.this.getResources().getString(R.string.str_charging_remaining_time)) + ": " + hour + ActivityEnergyLevel.this.getResources().getString(R.string.time_hour) + min + ActivityEnergyLevel.this.getResources().getString(R.string.time_minute));
                            break;
                    }
                    break;
                case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                    switch (updateCode) {
                        case 98:
                            ActivityEnergyLevel.this.updateCarState(DataCanbus.DATA[updateCode]);
                            break;
                        case 99:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                    }
                    break;
                default:
                    switch (updateCode) {
                        case 96:
                            ActivityEnergyLevel.this.updateCarState(DataCanbus.DATA[updateCode]);
                            break;
                        case 97:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_227_energy_level);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergyLevel(int value) {
        int resId;
        if (((ImageView) findViewById(R.id.iv_energy_level)) != null) {
            if (value < 13) {
                resId = R.drawable.ic_227_battery_level_0;
            } else if (value < 38) {
                resId = R.drawable.ic_227_battery_level_1;
            } else if (value < 63) {
                resId = R.drawable.ic_227_battery_level_2;
            } else if (value < 88) {
                resId = R.drawable.ic_227_battery_level_3;
            } else if (value < 113) {
                resId = R.drawable.ic_227_battery_level_4;
            } else if (value < 138) {
                resId = R.drawable.ic_227_battery_level_5;
            } else if (value < 163) {
                resId = R.drawable.ic_227_battery_level_6;
            } else if (value < 188) {
                resId = R.drawable.ic_227_battery_level_7;
            } else if (value < 213) {
                resId = R.drawable.ic_227_battery_level_8;
            } else if (value < 238) {
                resId = R.drawable.ic_227_battery_level_9;
            } else {
                resId = R.drawable.ic_227_battery_level_10;
            }
            ((ImageView) findViewById(R.id.iv_energy_level)).setBackgroundResource(resId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarState(int value) {
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarState2() {
        int value = DataCanbus.DATA[106];
        int data = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(String.valueOf(getResources().getString(R.string.str_227_ec180_car_state_2)) + " Lv" + data);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(String.valueOf(getResources().getString(R.string.str_227_ec180_car_state_3)) + " Lv" + data);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("快充模式");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("放电模式");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
    }
}
