package com.syu.carinfo.hc.rongwei950;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class Hc_Rongwei950_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hc.rongwei950.Hc_Rongwei950_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 100:
                    Hc_Rongwei950_CarSettingAct.this.updateLookForLight();
                    break;
                case 101:
                    Hc_Rongwei950_CarSettingAct.this.updateLockDelayLight();
                    break;
                case 102:
                    Hc_Rongwei950_CarSettingAct.this.updateAutolockOpendoor();
                    break;
                case 103:
                    Hc_Rongwei950_CarSettingAct.this.updateAutolockStart();
                    break;
                case 104:
                    Hc_Rongwei950_CarSettingAct.this.updateUnLockPark();
                    break;
                case 105:
                    Hc_Rongwei950_CarSettingAct.this.updateDelayLock();
                    break;
                case 106:
                    Hc_Rongwei950_CarSettingAct.this.updateRemoteUnlockLight();
                    break;
                case 107:
                    Hc_Rongwei950_CarSettingAct.this.updateRemoteLockCycle();
                    break;
                case 108:
                    Hc_Rongwei950_CarSettingAct.this.updateRemoteUnLock();
                    break;
                case 109:
                    Hc_Rongwei950_CarSettingAct.this.updateBackRearWiper();
                    break;
                case 110:
                    Hc_Rongwei950_CarSettingAct.this.updateRemoteLockAgain();
                    break;
                case 111:
                    Hc_Rongwei950_CarSettingAct.this.updateRemoteStart();
                    break;
                case 112:
                    Hc_Rongwei950_CarSettingAct.this.updateCenterConsoleLogo();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_hc_rongwei950_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[101];
                int value2 = value - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value2}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[101];
                int value4 = value3 + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{1, value4}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value5 = DataCanbus.DATA[104];
                int value6 = value5 - 1;
                if (value6 < 0) {
                    value6 = 2;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value6}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value7 = DataCanbus.DATA[104];
                int value8 = value7 + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{4, value8}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value9 = DataCanbus.DATA[107];
                int value10 = value9 - 1;
                if (value10 < 0) {
                    value10 = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value10}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value11 = DataCanbus.DATA[107];
                int value12 = value11 + 1;
                if (value12 > 3) {
                    value12 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{7, value12}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = DataCanbus.DATA[108];
                int value14 = value13 - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value14}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value15 = DataCanbus.DATA[108];
                int value16 = value15 + 1;
                if (value16 > 1) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{8, value16}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value17 = DataCanbus.DATA[100];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[1] = value17 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value18 = DataCanbus.DATA[102];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = value18 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value19 = DataCanbus.DATA[103];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 3;
                iArr3[1] = value19 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value20 = DataCanbus.DATA[105];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 5;
                iArr4[1] = value20 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value21 = DataCanbus.DATA[106];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 6;
                iArr5[1] = value21 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(1, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value22 = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 9;
                iArr6[1] = value22 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(1, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value23 = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 10;
                iArr7[1] = value23 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(1, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value24 = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 11;
                iArr8[1] = value24 == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(1, iArr8, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
    }

    protected void updateCenterConsoleLogo() {
        int value = DataCanbus.DATA[112];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.rzc_bz408_warning_10);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text5)).setText(R.string.str_can_control);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteStart() {
        int value = DataCanbus.DATA[111];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteLockAgain() {
        int value = DataCanbus.DATA[110];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackRearWiper() {
        int value = DataCanbus.DATA[109];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    protected void updateRemoteUnLock() {
        int value = DataCanbus.DATA[108];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
                break;
        }
    }

    protected void updateRemoteLockCycle() {
        int value = DataCanbus.DATA[107];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_remote_Remote_control_latch_speaker);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteUnlockLight() {
        int value = DataCanbus.DATA[106];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDelayLock() {
        int value = DataCanbus.DATA[105];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    protected void updateUnLockPark() {
        int value = DataCanbus.DATA[104];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_presskeyunlock_1);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutolockStart() {
        int value = DataCanbus.DATA[103];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutolockOpendoor() {
        int value = DataCanbus.DATA[102];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    protected void updateLockDelayLight() {
        int value = DataCanbus.DATA[101];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.off);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLookForLight() {
        int value = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
