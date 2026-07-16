package com.syu.carinfo.dongjian.wc2.ds5;

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
public class DS5CarTimeSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dongjian.wc2.ds5.DS5CarTimeSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    DS5CarTimeSetAct.this.updaterYear();
                    break;
                case 133:
                    DS5CarTimeSetAct.this.updaterMonth();
                    break;
                case 134:
                    DS5CarTimeSetAct.this.updaterDay();
                    break;
                case 135:
                    DS5CarTimeSetAct.this.updaterHour();
                    break;
                case 136:
                    DS5CarTimeSetAct.this.updaterMinute();
                    break;
                case 137:
                    DS5CarTimeSetAct.this.updatertimeFromat();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_302_dongjian_wc2_ds5_time_format);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    public void setUI() {
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_hour_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_hour_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_minutes_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_minutes_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_day_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_day_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_month_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_month_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_year_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_year_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterHour() {
        int hourValue = DataCanbus.DATA[135];
        if (hourValue < 0) {
            hourValue = 0;
        } else if (hourValue > 23) {
            hourValue = 23;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_hour_tv)).setText(new StringBuilder().append(hourValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMinute() {
        int minuteValue = DataCanbus.DATA[136];
        if (minuteValue < 0) {
            minuteValue = 0;
        } else if (minuteValue > 59) {
            minuteValue = 59;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_minutes_tv)).setText(new StringBuilder().append(minuteValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDay() {
        int dayValue = DataCanbus.DATA[134];
        if (dayValue < 1) {
            dayValue = 1;
        } else if (dayValue > 31) {
            dayValue = 31;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_day_tv)).setText(new StringBuilder().append(dayValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMonth() {
        int monthValue = DataCanbus.DATA[133];
        if (monthValue < 1) {
            monthValue = 1;
        } else if (monthValue > 12) {
            monthValue = 12;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_month_tv)).setText(new StringBuilder().append(monthValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterYear() {
        int yearValue = DataCanbus.DATA[132];
        if (yearValue < 0) {
            yearValue = 0;
        } else if (yearValue > 99) {
            yearValue = 99;
        }
        if (yearValue >= 0 && yearValue < 10) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_year_tv)).setText("200" + yearValue);
        } else {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_year_tv)).setText("20" + yearValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatertimeFromat() {
        int TimeFormatValue = DataCanbus.DATA[137];
        if (TimeFormatValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_1);
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_0);
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setChecked(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_time_hour_pre /* 2131429253 */:
                int value1 = DataCanbus.DATA[135] - 1;
                if (value1 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], DataCanbus.DATA[134], value1, DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_hour_next /* 2131429255 */:
                int value2 = DataCanbus.DATA[135] + 1;
                if (value2 < 12) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], DataCanbus.DATA[134], value2, DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_minutes_pre /* 2131429256 */:
                int value3 = DataCanbus.DATA[136] - 1;
                if (value3 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], DataCanbus.DATA[134], DataCanbus.DATA[135], value3, DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_minutes_next /* 2131429258 */:
                int value4 = DataCanbus.DATA[136] + 1;
                if (value4 < 59) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], DataCanbus.DATA[134], DataCanbus.DATA[135], value4, DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_day_pre /* 2131429259 */:
                int value5 = DataCanbus.DATA[134] - 1;
                if (value5 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], value5, DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_day_next /* 2131429261 */:
                int value6 = DataCanbus.DATA[134] + 1;
                if (value6 < 31) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], value6, DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_month_pre /* 2131429262 */:
                int value7 = DataCanbus.DATA[133] - 1;
                if (value7 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], value7, DataCanbus.DATA[134], DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_month_next /* 2131429264 */:
                int value8 = DataCanbus.DATA[133] + 1;
                if (value8 < 12) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], value8, DataCanbus.DATA[134], DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_year_pre /* 2131429265 */:
                int value9 = DataCanbus.DATA[132] - 1;
                if (value9 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(value9, DataCanbus.DATA[133], DataCanbus.DATA[134], DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_year_next /* 2131429267 */:
                int value10 = DataCanbus.DATA[132] + 1;
                if (value10 < 99) {
                    DS5Func.C_TIME_FORMAT_SET(value10, DataCanbus.DATA[133], DataCanbus.DATA[134], DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137]);
                }
                break;
            case R.id.dongjian_wc2_ds5_time_format_check /* 2131429268 */:
                DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[132], DataCanbus.DATA[133], DataCanbus.DATA[134], DataCanbus.DATA[135], DataCanbus.DATA[136], DataCanbus.DATA[137] == 0 ? 1 : 0);
                break;
        }
    }
}
