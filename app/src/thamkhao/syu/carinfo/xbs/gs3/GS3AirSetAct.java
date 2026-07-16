package com.syu.carinfo.xbs.gs3;

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
public class GS3AirSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3AirSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 94:
                    GS3AirSetAct.this.updaterAutoCompressor();
                    break;
                case 95:
                    GS3AirSetAct.this.updaterAutoCycleState();
                    break;
                case 96:
                    GS3AirSetAct.this.updaterComfort();
                    break;
                case 97:
                    GS3AirSetAct.this.updaterAnionMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_air_set);
        setUI();
    }

    private void setUI() {
        DataCanbus.PROXY.cmd(3, new int[]{8}, null, null);
        setViewVisible(findViewById(R.id.wc_chga6_negativeioc_modeengineer_L), true);
        setSelfClick((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check), this);
        setSelfClick((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check), this);
        setSelfClick((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_pre), this);
        setSelfClick((Button) findViewById(R.id.wc_gs4_air_set_comfort_curve_next), this);
        setSelfClick((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_air_set_auto_compressor_check /* 2131429051 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 3;
                iArr[1] = DataCanbus.DATA[94] == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_auto_cycle_state_check /* 2131429052 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 2;
                iArr2[1] = DataCanbus.DATA[95] == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_air_set_comfort_curve_pre /* 2131429054 */:
                if (DataCanbus.DATA[96] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                } else if (DataCanbus.DATA[96] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 0}, null, null);
                } else if (DataCanbus.DATA[96] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                }
                break;
            case R.id.wc_gs4_air_set_comfort_curve_next /* 2131429056 */:
                if (DataCanbus.DATA[96] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 1}, null, null);
                } else if (DataCanbus.DATA[96] == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 2}, null, null);
                } else if (DataCanbus.DATA[96] == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{1, 0}, null, null);
                }
                break;
            case R.id.wc_chga6_negativeioc_modeengineer /* 2131429115 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 21;
                iArr3[1] = DataCanbus.DATA[97] == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCompressor() {
        int mAutoCompre = DataCanbus.DATA[94];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_compressor_check)).setChecked(mAutoCompre == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAnionMode() {
        int mAnionMode = DataCanbus.DATA[97];
        ((CheckedTextView) findViewById(R.id.wc_chga6_negativeioc_modeengineer)).setChecked(mAnionMode != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoCycleState() {
        int mAutoCycle = DataCanbus.DATA[95];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_auto_cycle_state_check)).setChecked(mAutoCycle == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterComfort() {
        int mAirComfort = DataCanbus.DATA[96];
        if (mAirComfort == 0) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_slow);
        } else if (mAirComfort == 1) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_nomol);
        } else if (mAirComfort == 2) {
            ((TextView) findViewById(R.id.wc_gs4_air_set_comfort_curve_TV)).setText(R.string.wc_gs4_air_set_comfort_fast);
        }
    }
}
