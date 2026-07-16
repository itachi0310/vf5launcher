package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class KlcCrashSetAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcCrashSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 15:
                    KlcCrashSetAct.this.updateBoCheHelpSystemSet();
                    break;
                case 16:
                    KlcCrashSetAct.this.updateCeMangWarnSystemset();
                    break;
                case 17:
                    KlcCrashSetAct.this.updateFangzhuangWarnType();
                    break;
                case 18:
                    KlcCrashSetAct.this.updateBoCheSystemSetTuoKa();
                    break;
                case 19:
                    KlcCrashSetAct.this.update24GhzRadarSet();
                    break;
                case 66:
                    KlcCrashSetAct.this.updateAutoFangzhuang();
                    break;
                case 67:
                    KlcCrashSetAct.this.updateCarNotify();
                    break;
                case 111:
                    KlcCrashSetAct.this.updateCarSettingAssist();
                    break;
                case 112:
                    KlcCrashSetAct.this.updateCarCruiseControl();
                    break;
                case 149:
                    if (enable == 0) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                    } else if (enable == 1) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                        if (switchOn == 0) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                        } else if (switchOn == 1) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                        } else if (switchOn == 2) {
                            ((TextView) KlcCrashSetAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
                        }
                    }
                    break;
                case 150:
                    if (enable == 0) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view11).setVisibility(8);
                    } else if (enable == 1) {
                        KlcCrashSetAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                        ((CheckedTextView) KlcCrashSetAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_crash_set);
        setUI();
    }

    private void setUI() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valParkTrailerPre = DataCanbus.DATA[18] & 255;
                if (valParkTrailerPre == 0) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                } else if (valParkTrailerPre == 1) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                } else if (valParkTrailerPre == 2) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int valParkTrailerNext = DataCanbus.DATA[18] & 255;
                if (valParkTrailerNext == 0) {
                    KlcFunc.C_CAR_CRASH(3, 1);
                } else if (valParkTrailerNext == 1) {
                    KlcFunc.C_CAR_CRASH(3, 2);
                } else if (valParkTrailerNext == 2) {
                    KlcFunc.C_CAR_CRASH(3, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int valuepre = DataCanbus.DATA[66] & 255;
                if (valuepre == 0) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                } else if (valuepre == 1) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                } else if (valuepre == 2) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int valueNext = DataCanbus.DATA[66] & 255;
                if (valueNext == 0) {
                    KlcFunc.C_CAR_CRASH(6, 1);
                } else if (valueNext == 1) {
                    KlcFunc.C_CAR_CRASH(6, 2);
                } else if (valueNext == 2) {
                    KlcFunc.C_CAR_CRASH(6, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int valuepre2 = DataCanbus.DATA[149] & 255;
                if (valuepre2 == 0) {
                    KlcFunc.C_CAR_CRASH(10, 2);
                } else if (valuepre2 == 1) {
                    KlcFunc.C_CAR_CRASH(10, 0);
                } else if (valuepre2 == 2) {
                    KlcFunc.C_CAR_CRASH(10, 1);
                }
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int valueNext2 = DataCanbus.DATA[149] & 255;
                if (valueNext2 == 0) {
                    KlcFunc.C_CAR_CRASH(10, 1);
                } else if (valueNext2 == 1) {
                    KlcFunc.C_CAR_CRASH(10, 2);
                } else if (valueNext2 == 2) {
                    KlcFunc.C_CAR_CRASH(10, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int valPark = DataCanbus.DATA[15] & 255;
                KlcFunc.C_CAR_CRASH(1, valPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int valBlind = DataCanbus.DATA[16] & 255;
                KlcFunc.C_CAR_CRASH(2, valBlind == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int valRader = DataCanbus.DATA[19] & 255;
                KlcFunc.C_CAR_CRASH(5, valRader == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int valAlertType = DataCanbus.DATA[17] & 255;
                KlcFunc.C_CAR_CRASH(4, valAlertType == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value = DataCanbus.DATA[67] & 255;
                KlcFunc.C_CAR_CRASH(7, value == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value1 = DataCanbus.DATA[112] & 255;
                KlcFunc.C_CAR_CRASH(9, value1 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value12 = DataCanbus.DATA[111] & 255;
                KlcFunc.C_CAR_CRASH(8, value12 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value13 = DataCanbus.DATA[150] & 255;
                KlcFunc.C_CAR_CRASH(11, value13 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        findViewById(R.id.layout_view6).setVisibility(0);
        findViewById(R.id.layout_view7).setVisibility(0);
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBoCheHelpSystemSet() {
        int val = DataCanbus.DATA[15];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (DataCanbus.DATA[1000] == 254) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
            return;
        }
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBoCheSystemSetTuoKa() {
        int val = DataCanbus.DATA[18];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_ON);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Trailer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCeMangWarnSystemset() {
        int val = DataCanbus.DATA[16];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFangzhuangWarnType() {
        int val = DataCanbus.DATA[17];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Collision_Alert_Type_Chime_alarm);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text3)).setText(R.string.klc_Collision_Alert_Type_Seat_alarm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update24GhzRadarSet() {
        int val = DataCanbus.DATA[19];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoFangzhuang() {
        int val = DataCanbus.DATA[66];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.off);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.wc_weilang_auto_fangzhuang_warn_and_zhidong);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarNotify() {
        int val = DataCanbus.DATA[67];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarCruiseControl() {
        int val = DataCanbus.DATA[112];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view8).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarSettingAssist() {
        int val = DataCanbus.DATA[111];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view9).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_stand_parking);
            } else if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_incre_parking);
            }
        }
    }
}
