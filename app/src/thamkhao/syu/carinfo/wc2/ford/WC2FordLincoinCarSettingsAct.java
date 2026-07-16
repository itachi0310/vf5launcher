package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WC2FordLincoinCarSettingsAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 37:
                    WC2FordLincoinCarSettingsAct.this.updateTempUnit(val);
                    break;
                case 100:
                    WC2FordLincoinCarSettingsAct.this.updateLanguage(val);
                    break;
                case 101:
                    WC2FordLincoinCarSettingsAct.this.updateMeasure(val);
                    break;
                case 102:
                    WC2FordLincoinCarSettingsAct.this.updateAmbientLight(val);
                    break;
                case 103:
                    WC2FordLincoinCarSettingsAct.this.updaterCameraDelay(val);
                    break;
                case 104:
                    WC2FordLincoinCarSettingsAct.this.updaterradarDisplay(val);
                    break;
                case 155:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(val != 0);
                    break;
                case 156:
                    ((CheckedTextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(val != 0);
                    break;
                case 157:
                    ((TextView) WC2FordLincoinCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_ford_lincoin_car_settings_act);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick(findViewById(R.id.btn_minus1), this);
        setSelfClick(findViewById(R.id.btn_plus1), this);
        setSelfClick(findViewById(R.id.btn_minus2), this);
        setSelfClick(findViewById(R.id.btn_plus2), this);
        setSelfClick(findViewById(R.id.btn_minus3), this);
        setSelfClick(findViewById(R.id.btn_plus3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick(findViewById(R.id.ctv_checkedtext6), this);
        if (DataCanbus.DATA[1000] == 4981179) {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int data0 = 0;
        int data1 = 0;
        int data2 = 0;
        int data3 = 0;
        int data4 = 0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                data0 = 2;
                data1 = 154;
                data2 = 1;
                data3 = DataCanbus.DATA[100] - 1;
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 2;
                data1 = 154;
                data2 = 1;
                data3 = DataCanbus.DATA[100] + 1;
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[102] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                data0 = 4;
                data1 = 111;
                data2 = 3;
                data3 = DataCanbus.DATA[102] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[157] - 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                data0 = 4;
                data1 = 111;
                data2 = 2;
                data3 = DataCanbus.DATA[157] + 1;
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                        data4 = 37;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
                        data4 = 38;
                        break;
                    case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
                        data4 = 39;
                        break;
                    default:
                        data4 = 41;
                        break;
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                data0 = 2;
                data1 = 242;
                data2 = 6;
                data3 = DataCanbus.DATA[103] != 1 ? 1 : 0;
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int data02 = DataCanbus.DATA[104] == 1 ? 0 : 1;
                DataCanbus.PROXY.cmd(4, new int[]{data02}, null, null);
                return;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                data0 = 2;
                data1 = 108;
                data2 = 5;
                data3 = DataCanbus.DATA[101] != 1 ? 1 : 0;
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                data0 = 2;
                data1 = 109;
                data2 = 4;
                data3 = DataCanbus.DATA[37] != 1 ? 1 : 0;
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                data0 = 2;
                data1 = 242;
                data2 = 11;
                data3 = DataCanbus.DATA[155] != 1 ? 1 : 0;
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                data0 = 2;
                data1 = 242;
                data2 = 10;
                data3 = DataCanbus.DATA[156] != 1 ? 1 : 0;
                break;
        }
        sendCmd(data0, data1, data2, data3, data4, 0);
    }

    private void sendCmd(int data0, int data1, int data2, int data3, int data4, int data5) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1, data2, data3, data4, data5}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempUnit(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_c_set);
        } else {
            ((TextView) findViewById(R.id.tv_text4)).setText(R.string.wc_15ruijie_temp_unit_f_set);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmbientLight(int value) {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ /* 4981179 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC /* 5046715 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_H /* 5112251 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKC_V /* 5177787 */:
            case FinalCanbus.CAR_443_WC2_Ford_Lincoln_MKZ_V /* 5571003 */:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_white_str);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_amber);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_blue_green_str);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_background_green);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_lavender_str);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
                break;
            default:
                switch (value) {
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_ice_blue);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.color_orange_str);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_2);
                        break;
                    case 4:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_3);
                        break;
                    case 5:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_4);
                        break;
                    case 6:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_5);
                        break;
                    case 7:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_403_ambient_6);
                        break;
                    default:
                        ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMeasure(int value) {
        if (value == 1) {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set1);
        } else {
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.jeep_format_set0);
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguage(int value) {
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_0);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.rzc_others_language_setting_1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.wc_psa_all_lauguage_set_value_20);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCameraDelay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterradarDisplay(int value) {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }
}
