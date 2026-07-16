package com.syu.carinfo.haozheng.bmw;

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
public class BmwSystemSetAct extends BaseActivity implements View.OnClickListener {
    int TempUnitValue;
    int TimeFormatValue;
    int juliUnitvalue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwSystemSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 11:
                    BmwSystemSetAct.this.updaterjuliUnit();
                    break;
                case 12:
                    BmwSystemSetAct.this.updateroilUnit();
                    break;
                case 13:
                    BmwSystemSetAct.this.updatertempUnit();
                    break;
                case 14:
                    BmwSystemSetAct.this.updatertimeFromat();
                    break;
            }
        }
    };
    int oilUnitValue;

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haozheng_bmw_system_set);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.bogoo_bmw_juli_unit_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.bogoo_bmw_temp_unit_check)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.bogoo_bmw_time_format_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_oil_unit_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_oil_unit_next)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(3, new int[]{4, 0}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterjuliUnit() {
        this.juliUnitvalue = DataCanbus.DATA[11];
        if (this.juliUnitvalue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_juli_unit_tv)).setText("mls");
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_juli_unit_check)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.bogoo_bmw_juli_unit_tv)).setText("km");
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_juli_unit_check)).setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateroilUnit() {
        this.oilUnitValue = DataCanbus.DATA[12];
        if (this.oilUnitValue == 0) {
            ((TextView) findViewById(R.id.bogoo_bmw_oil_unit_tv)).setText("l/100km");
            return;
        }
        if (this.oilUnitValue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_oil_unit_tv)).setText("mpg(US)");
        } else if (this.oilUnitValue == 2) {
            ((TextView) findViewById(R.id.bogoo_bmw_oil_unit_tv)).setText("mpg(UK)");
        } else if (this.oilUnitValue == 3) {
            ((TextView) findViewById(R.id.bogoo_bmw_oil_unit_tv)).setText("km/l");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertempUnit() {
        this.TempUnitValue = DataCanbus.DATA[13];
        if (this.TempUnitValue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_temp_unit_tv)).setText(R.string.str_bogoo_bmw_temp_unit_1);
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_temp_unit_check)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.bogoo_bmw_temp_unit_tv)).setText(R.string.str_bogoo_bmw_temp_unit_0);
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_temp_unit_check)).setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertimeFromat() {
        this.TimeFormatValue = DataCanbus.DATA[14];
        if (this.TimeFormatValue == 1) {
            ((TextView) findViewById(R.id.bogoo_bmw_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_1);
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_time_format_check)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.bogoo_bmw_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_0);
            ((CheckedTextView) findViewById(R.id.bogoo_bmw_time_format_check)).setChecked(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogoo_bmw_juli_unit_check /* 2131431708 */:
                BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue != 0 ? 0 : 1, 0, this.oilUnitValue, this.TempUnitValue, this.TimeFormatValue);
                break;
            case R.id.bogoo_bmw_oil_unit_pre /* 2131431711 */:
                if (this.oilUnitValue == 0) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 3, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 1) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 0, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 2) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 1, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 3) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 2, this.TempUnitValue, this.TimeFormatValue);
                }
                break;
            case R.id.bogoo_bmw_oil_unit_next /* 2131431713 */:
                if (this.oilUnitValue == 0) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 1, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 1) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 2, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 2) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 3, this.TempUnitValue, this.TimeFormatValue);
                } else if (this.oilUnitValue == 3) {
                    BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, 0, this.TempUnitValue, this.TimeFormatValue);
                }
                break;
            case R.id.bogoo_bmw_temp_unit_check /* 2131431714 */:
                BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, this.oilUnitValue, this.TempUnitValue != 0 ? 0 : 1, this.TimeFormatValue);
                break;
            case R.id.bogoo_bmw_time_format_check /* 2131431717 */:
                BmwFunc.CAR_SYSTEM_SET(this.juliUnitvalue, 0, this.oilUnitValue, this.TempUnitValue, this.TimeFormatValue != 0 ? 0 : 1);
                break;
        }
    }
}
