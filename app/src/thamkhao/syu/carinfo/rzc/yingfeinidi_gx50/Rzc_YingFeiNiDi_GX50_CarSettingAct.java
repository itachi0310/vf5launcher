package com.syu.carinfo.rzc.yingfeinidi_gx50;

import android.content.Intent;
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
public class Rzc_YingFeiNiDi_GX50_CarSettingAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.yingfeinidi_gx50.Rzc_YingFeiNiDi_GX50_CarSettingAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLighUnlockt();
                    break;
                case 96:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightSensor();
                    break;
                case 97:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateAutoLightTime();
                    break;
                case 98:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateSelectUnlock();
                    break;
                case 99:
                    Rzc_YingFeiNiDi_GX50_CarSettingAct.this.updateKeyUnlock();
                    break;
                case 113:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    break;
                case 114:
                    ((TextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 115:
                    ((TextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    break;
                case 116:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    break;
                case 117:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    break;
                case 118:
                    ((CheckedTextView) Rzc_YingFeiNiDi_GX50_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_yingfeinidi_gx50_carsetting);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
        int id = arg0.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[96] - 1;
                if (value < 1) {
                    value = 4;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[96] + 1;
                if (value2 > 4) {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{2, value2}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[97] - 1;
                if (value3 < 0) {
                    value3 = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value3}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[97] + 1;
                if (value4 > 7) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{3, value4}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                DataCanbus.PROXY.cmd(1, new int[]{7, 2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                DataCanbus.PROXY.cmd(1, new int[]{7, 1}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                DataCanbus.PROXY.cmd(1, new int[]{8, 2}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                DataCanbus.PROXY.cmd(1, new int[]{8, 1}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value5 = DataCanbus.DATA[95];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 1;
                iArr[1] = value5 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(1, iArr, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value6 = DataCanbus.DATA[98];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 4;
                iArr2[1] = value6 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(1, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value7 = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 5;
                iArr3[1] = value7 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(1, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, Rzc_Infiniti_CarinfoAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, Rzc_Infiniti_CarTireAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                try {
                    Intent intent3 = new Intent();
                    intent3.setClass(this, Rzc_Infeiniti_EQSetAct.class);
                    startActivity(intent3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value8 = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 6;
                iArr4[1] = value8 == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(1, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value9 = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 11;
                iArr5[1] = value9 == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(1, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int value10 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 10;
                iArr6[1] = value10 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(1, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int value11 = DataCanbus.DATA[118];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 9;
                iArr7[1] = value11 == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(1, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                try {
                    Intent intent4 = new Intent();
                    intent4.setClass(this, Rzc_Infeiniti_360ViewSetAct.class);
                    startActivity(intent4);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyUnlock() {
        int value = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectUnlock() {
        int value = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    protected void updateAutoLightTime() {
        int value = DataCanbus.DATA[97];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_12);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_11);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_1);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_2);
                break;
            case 5:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_3);
                break;
            case 6:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_4);
                break;
            case 7:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_ruiteng_string_time_5);
                break;
        }
    }

    protected void updateAutoLightSensor() {
        int value = DataCanbus.DATA[96];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr1);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr2);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr3);
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_372_volumestr4);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLighUnlockt() {
        int value = DataCanbus.DATA[95];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }
}
