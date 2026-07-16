package com.syu.carinfo.daojun.ats;

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
public class AtsInfoSetFirstAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.ats.AtsInfoSetFirstAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    AtsInfoSetFirstAct.this.updaterlightsParking();
                    break;
                case 104:
                    AtsInfoSetFirstAct.this.updaterLasuoHeadlightDelay();
                    break;
                case 105:
                    AtsInfoSetFirstAct.this.updaterdefeatDoorAutoLock();
                    break;
                case 106:
                    AtsInfoSetFirstAct.this.updaterdoorAutoLock();
                    break;
                case 107:
                    AtsInfoSetFirstAct.this.updaterparkCarAutoUnlock();
                    break;
                case 108:
                    AtsInfoSetFirstAct.this.updaterlaterLock();
                    break;
                case 109:
                    AtsInfoSetFirstAct.this.updaterremoteUnlockLight();
                    break;
                case 110:
                    AtsInfoSetFirstAct.this.updaterremoteLockDoor();
                    break;
                case 111:
                    AtsInfoSetFirstAct.this.updaterremoteUnlock();
                    break;
                case 114:
                    AtsInfoSetFirstAct.this.updaterreversWipersStart();
                    break;
                case 115:
                    AtsInfoSetFirstAct.this.updaterRemoteStartCar();
                    break;
                case 131:
                    AtsInfoSetFirstAct.this.updaterWarnVolumSet();
                    break;
                case 132:
                    AtsInfoSetFirstAct.this.updaterRemoteCarWindow();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_daojun_ats_info_first_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valLasuoDelayPre = DataCanbus.DATA[104] & 255;
                if (valLasuoDelayPre == 0) {
                    AtsFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayPre == 1) {
                    AtsFunc.CAR_COMM_CONTROL(1, 0);
                } else if (valLasuoDelayPre == 2) {
                    AtsFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayPre == 3) {
                    AtsFunc.CAR_COMM_CONTROL(1, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int valLasuoDelayNext = DataCanbus.DATA[104] & 255;
                if (valLasuoDelayNext == 0) {
                    AtsFunc.CAR_COMM_CONTROL(1, 1);
                } else if (valLasuoDelayNext == 1) {
                    AtsFunc.CAR_COMM_CONTROL(1, 2);
                } else if (valLasuoDelayNext == 2) {
                    AtsFunc.CAR_COMM_CONTROL(1, 3);
                } else if (valLasuoDelayNext == 3) {
                    AtsFunc.CAR_COMM_CONTROL(1, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value7 = DataCanbus.DATA[107];
                if (value7 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value7 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(4, 0);
                } else if (value7 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(4, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value8 = DataCanbus.DATA[107];
                if (value8 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(4, 1);
                } else if (value8 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(4, 2);
                } else if (value8 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(4, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[110];
                if (value9 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value9 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(7, 0);
                } else if (value9 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value9 == 3) {
                    AtsFunc.CAR_COMM_CONTROL(7, 2);
                }
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value10 = DataCanbus.DATA[110];
                if (value10 == 0) {
                    AtsFunc.CAR_COMM_CONTROL(7, 1);
                } else if (value10 == 1) {
                    AtsFunc.CAR_COMM_CONTROL(7, 2);
                } else if (value10 == 2) {
                    AtsFunc.CAR_COMM_CONTROL(7, 3);
                } else if (value10 == 3) {
                    AtsFunc.CAR_COMM_CONTROL(7, 0);
                }
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value11 = DataCanbus.DATA[131];
                if (value11 == 0) {
                    AtsFunc.CAR_WARNN_VOL(15);
                } else {
                    AtsFunc.CAR_WARNN_VOL(value11 - 1);
                }
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 15) {
                    AtsFunc.CAR_WARNN_VOL(0);
                } else {
                    AtsFunc.CAR_WARNN_VOL(value12 + 1);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int valLightPark = DataCanbus.DATA[103];
                AtsFunc.CAR_COMM_CONTROL(0, valLightPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value1 = DataCanbus.DATA[106];
                AtsFunc.CAR_COMM_CONTROL(3, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value2 = DataCanbus.DATA[105];
                AtsFunc.CAR_COMM_CONTROL(2, value2 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value3 = DataCanbus.DATA[108];
                AtsFunc.CAR_COMM_CONTROL(5, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value4 = DataCanbus.DATA[109];
                AtsFunc.CAR_COMM_CONTROL(6, value4 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value5 = DataCanbus.DATA[111];
                AtsFunc.CAR_COMM_CONTROL(8, value5 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value6 = DataCanbus.DATA[114];
                AtsFunc.CAR_COMM_CONTROL(9, value6 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                AtsFunc.CAR_COMM_CONTROL(11, DataCanbus.DATA[115] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                AtsFunc.CAR_COMM_CONTROL(119, DataCanbus.DATA[132] == 0 ? 1 : 0);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlightsParking() {
        int switchOn = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLasuoHeadlightDelay() {
        int switchOn = DataCanbus.DATA[104];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdefeatDoorAutoLock() {
        int switchOn = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterdoorAutoLock() {
        int switchOn = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterparkCarAutoUnlock() {
        int switchOn = DataCanbus.DATA[107];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
        } else if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterlaterLock() {
        int switchOn = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlockLight() {
        int switchOn = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteLockDoor() {
        int switchOn = DataCanbus.DATA[110];
        if (switchOn == 0) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
            return;
        }
        if (switchOn == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
        } else if (switchOn == 2) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
        } else if (switchOn == 3) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Parking_with_trailer_Off);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterremoteUnlock() {
        int switchOn = DataCanbus.DATA[111];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterreversWipersStart() {
        int switchOn = DataCanbus.DATA[114];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnVolumSet() {
        int switchOn = DataCanbus.DATA[131];
        ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(switchOn).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteStartCar() {
        int RemotecarStartValue = DataCanbus.DATA[115];
        if (RemotecarStartValue == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(false);
        } else if (RemotecarStartValue == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRemoteCarWindow() {
        int remounteCarWindowValue = DataCanbus.DATA[132];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(remounteCarWindowValue != 0);
    }
}
