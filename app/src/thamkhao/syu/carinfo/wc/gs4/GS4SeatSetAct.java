package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GS4SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    GS4SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 99:
                    GS4SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 100:
                    GS4SeatSetAct.this.updaterSeatWelcome();
                    break;
                case 101:
                    GS4SeatSetAct.this.updaterSmartKeyIdentification();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_289_wc_gs4_seat_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.wc_gs4_seat_set_drive_seat_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_the_pilot_drive_seat_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_ga6_seatwelcome_set)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.wc_ga6_smartkeyidentification_set)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_seat_set_drive_seat_check /* 2131429057 */:
                int mDriverSeat = DataCanbus.DATA[98];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 5;
                iArr[1] = mDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_air_set_the_pilot_drive_seat_check /* 2131429058 */:
                int mSecDriverSeat = DataCanbus.DATA[99];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 6;
                iArr2[1] = mSecDriverSeat == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_ga6_seatwelcome_set /* 2131429145 */:
                int mSeatwelcome = DataCanbus.DATA[100];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 23;
                iArr3[1] = mSeatwelcome == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.wc_ga6_smartkeyidentification_set /* 2131429147 */:
                int mSmartKeyIdentification = DataCanbus.DATA[101];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 24;
                iArr4[1] = mSmartKeyIdentification == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSmartKeyIdentification() {
        int mSmartKeyIdentification = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.wc_ga6_smartkeyidentification_set)).setChecked(mSmartKeyIdentification != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSeatWelcome() {
        int mSeatwelcome = DataCanbus.DATA[100];
        ((CheckedTextView) findViewById(R.id.wc_ga6_seatwelcome_set)).setChecked(mSeatwelcome != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.wc_gs4_seat_set_drive_seat_check)).setChecked(mDriverSeat != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[99];
        ((CheckedTextView) findViewById(R.id.wc_gs4_air_set_the_pilot_drive_seat_check)).setChecked(mSecDriverSeat != 0);
    }
}
