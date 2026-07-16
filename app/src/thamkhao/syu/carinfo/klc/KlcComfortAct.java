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
public class KlcComfortAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.KlcComfortAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 20:
                    KlcComfortAct.this.updateDriverSeatYiwei();
                    break;
                case 21:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuYiwei();
                    break;
                case 22:
                    KlcComfortAct.this.updateAutoMirrorQingxie();
                    break;
                case 23:
                    KlcComfortAct.this.updateAutoMirrorFold();
                    break;
                case 24:
                    KlcComfortAct.this.updateDriverPersonalSet();
                    break;
                case 25:
                    KlcComfortAct.this.updateAutoYushuaSheading();
                    break;
                case 26:
                    KlcComfortAct.this.updateZhuangxiangGuanzhuQingxie();
                    break;
                case 69:
                    KlcComfortAct.this.updateAutoYugua();
                    break;
                case 108:
                case 111:
                    KlcComfortAct.this.updatelaneassist();
                    break;
                case 151:
                    if (enable == 0) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                    } else if (enable == 1) {
                        KlcComfortAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                        ((CheckedTextView) KlcComfortAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_comfort_set);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valSteerColPre = DataCanbus.DATA[21] & 255;
                if (valSteerColPre == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                } else if (valSteerColPre == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                } else if (valSteerColPre == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                } else if (valSteerColPre == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int valSteerColNext = DataCanbus.DATA[21] & 255;
                if (valSteerColNext == 0) {
                    KlcFunc.C_CAR_COMFORT(3, 1);
                } else if (valSteerColNext == 1) {
                    KlcFunc.C_CAR_COMFORT(3, 2);
                } else if (valSteerColNext == 2) {
                    KlcFunc.C_CAR_COMFORT(3, 3);
                } else if (valSteerColNext == 3) {
                    KlcFunc.C_CAR_COMFORT(3, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int i = DataCanbus.DATA[111] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value2 = DataCanbus.DATA[111] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value2 = DataCanbus.DATA[108] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value2 = DataCanbus.DATA[111] & 255;
                } else {
                    value2 = DataCanbus.DATA[111] & 255;
                }
                KlcFunc.C_CAR_COMFORT(9, value2 == 0 ? 1 : 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int i2 = DataCanbus.DATA[111] & 255;
                if ((DataCanbus.DATA[1000] & 65535) == 36) {
                    value = DataCanbus.DATA[111] & 255;
                } else if (DataCanbus.DATA[1000] == 357) {
                    value = DataCanbus.DATA[108] & 255;
                } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
                    value = DataCanbus.DATA[111] & 255;
                } else {
                    value = DataCanbus.DATA[111] & 255;
                }
                KlcFunc.C_CAR_CRASH(8, value == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int valseatPark = DataCanbus.DATA[20] & 255;
                KlcFunc.C_CAR_COMFORT(1, valseatPark == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int valMirrAuto = DataCanbus.DATA[22] & 255;
                KlcFunc.C_CAR_COMFORT(2, valMirrAuto == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int valAutoFlod = DataCanbus.DATA[23] & 255;
                KlcFunc.C_CAR_COMFORT(4, valAutoFlod == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int valPrefre = DataCanbus.DATA[24] & 255;
                KlcFunc.C_CAR_COMFORT(5, valPrefre == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int valRever = DataCanbus.DATA[25] & 255;
                KlcFunc.C_CAR_COMFORT(6, valRever == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int valTitlTeer = DataCanbus.DATA[26] & 255;
                KlcFunc.C_CAR_COMFORT(7, valTitlTeer == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value3 = DataCanbus.DATA[69] & 255;
                KlcFunc.C_CAR_COMFORT(8, value3 == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value4 = DataCanbus.DATA[151] & 255;
                KlcFunc.C_CAR_COMFORT(9, value4 == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (DataCanbus.DATA[1000] == 308 || DataCanbus.DATA[1000] == 357) {
            findViewById(R.id.layout_view8).setVisibility(0);
        } else {
            findViewById(R.id.layout_view8).setVisibility(8);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        }
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
            return;
        }
        if (DataCanbus.DATA[1000] == 357) {
            DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDriverSeatYiwei() {
        int val = DataCanbus.DATA[20];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view1).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view1).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZhuangxiangGuanzhuYiwei() {
        int val = DataCanbus.DATA[21];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view2).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view2).setVisibility(0);
            if (switchOn == 0) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_Parking_with_trailer_Off);
                return;
            }
            if (switchOn == 1) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_contraction_str);
            } else if (switchOn == 2) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_upgrade_str);
            } else if (switchOn == 3) {
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_comfort_Steering_column_enhance_steering_column);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoMirrorQingxie() {
        int val = DataCanbus.DATA[22];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view3).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view3).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoMirrorFold() {
        int val = DataCanbus.DATA[23];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view4).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view4).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDriverPersonalSet() {
        int val = DataCanbus.DATA[24];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view5).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view5).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoYushuaSheading() {
        int val = DataCanbus.DATA[25];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view6).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view6).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZhuangxiangGuanzhuQingxie() {
        int val = DataCanbus.DATA[26];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view7).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view7).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoYugua() {
        int val = DataCanbus.DATA[69];
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view8).setVisibility(8);
        } else if (enable == 1) {
            findViewById(R.id.layout_view8).setVisibility(0);
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatelaneassist() {
        int val;
        if ((DataCanbus.DATA[1000] & 65535) == 36) {
            val = DataCanbus.DATA[111];
        } else if (DataCanbus.DATA[1000] == 357) {
            val = DataCanbus.DATA[108];
        } else if (DataCanbus.DATA[1000] == 196953 || DataCanbus.DATA[1000] == 328025 || DataCanbus.DATA[1000] == 590169 || DataCanbus.DATA[1000] == 262489) {
            val = DataCanbus.DATA[111];
        } else {
            val = DataCanbus.DATA[111];
        }
        int enable = (val >> 8) & 255;
        int switchOn = val & 255;
        if (enable == 0) {
            findViewById(R.id.layout_view9).setVisibility(8);
            return;
        }
        if (enable == 1) {
            findViewById(R.id.layout_view9).setVisibility(0);
            if (((TextView) findViewById(R.id.tv_text2)) != null) {
                if (switchOn == 0) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_stand_parking);
                } else if (switchOn == 1) {
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_incre_parking);
                }
            }
        }
    }
}
