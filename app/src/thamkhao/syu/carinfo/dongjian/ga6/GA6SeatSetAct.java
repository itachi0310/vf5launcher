package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GA6SeatSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.ga6.GA6SeatSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 98:
                    GA6SeatSetAct.this.updaterSecDriverSeatHot();
                    break;
                case 101:
                    GA6SeatSetAct.this.updaterDriverSeatHot();
                    break;
                case 107:
                    GA6SeatSetAct.this.mUpdaterValue1();
                    break;
                case 108:
                    GA6SeatSetAct.this.mUpdaterValue2();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_257_dongjian_ga6_seat_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 3, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 4, DataCanbus.DATA[98] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 1, DataCanbus.DATA[107] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                GA6Func.C_CAR_CARINFO_CMD(2, 2, DataCanbus.DATA[108] != 0 ? 0 : 1);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int mValue1 = DataCanbus.DATA[107];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(mValue1 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int mValue2 = DataCanbus.DATA[108];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(mValue2 != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverSeatHot() {
        int mDriverSeat = DataCanbus.DATA[101];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(mDriverSeat != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSecDriverSeatHot() {
        int mSecDriverSeat = DataCanbus.DATA[98];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(mSecDriverSeat != 0);
    }
}
