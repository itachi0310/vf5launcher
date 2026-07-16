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
public class klcAirMessageAct extends Activity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.klc.klcAirMessageAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            switch (updateCode) {
                case 0:
                    updateAutoWindMode();
                    break;
                case 1:
                    updateAIrModeSet();
                    break;
                case 2:
                    updateQualitySensor1();
                    break;
                case 3:
                    updateAirQualitySensor2();
                    break;
                case 4:
                    updateAutoZoomTempSet();
                    break;
                case 5:
                    updateAutoSeatTongfengSet();
                    break;
                case 6:
                    updateAutoHeatSeat();
                    break;
                case 7:
                    updateRemoteStartSeatAutoTongfeng();
                    break;
                case 8:
                    updateRemoteStartSeatAutoHot();
                    break;
                case 10:
                    updateRearZoomTempSet();
                    break;
                case 11:
                    updateAutoFrontFogOn();
                    break;
                case 12:
                    updateAutoRearFogOn();
                    break;
                case 14:
                    updateRemoteStartAir();
                    break;
                case 68:
                    updateRemoteStartSeatAutoHeat1();
                    break;
                case 148:
                    if (enable == 0) {
                        klcAirMessageAct.this.findViewById(R.id.layout_view1).setVisibility(8);
                    } else if (enable == 1) {
                        klcAirMessageAct.this.findViewById(R.id.layout_view1).setVisibility(0);
                        if (switchOn == 1) {
                            ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(true);
                        } else {
                            ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext1)).setChecked(false);
                        }
                    }
                    break;
            }
        }

        private void updateRemoteStartSeatAutoHeat1() {
            int val = DataCanbus.DATA[68];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view15).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view15).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_driver_and_customer);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text5)).setText(R.string.wc_weilang_driver);
                }
            }
        }

        private void updateAirQualitySensor2() {
            int val = DataCanbus.DATA[3];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view14).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view14).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext2)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                }
            }
        }

        private void updateRemoteStartAir() {
            int val = DataCanbus.DATA[14];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view13).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view13).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoRearFogOn() {
            int val = DataCanbus.DATA[12];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view12).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view12).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext4)).setChecked(switchOn != 0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_Manual);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text7)).setText(R.string.klc_air_auto);
                }
            }
        }

        private void updateAutoFrontFogOn() {
            int val = DataCanbus.DATA[11];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view11).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view11).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext5)).setChecked(switchOn != 0);
            }
        }

        private void updateRearZoomTempSet() {
            int val = DataCanbus.DATA[10];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view10).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view10).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_Like_last);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateRemoteStartSeatAutoHot() {
            int val = DataCanbus.DATA[8];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view9).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view9).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext6)).setChecked(switchOn != 0);
            }
        }

        private void updateRemoteStartSeatAutoTongfeng() {
            int val = DataCanbus.DATA[7];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view8).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view8).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoHeatSeat() {
            int val = DataCanbus.DATA[6];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view7).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view7).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext9)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoSeatTongfengSet() {
            int val = DataCanbus.DATA[5];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view6).setVisibility(8);
            } else if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view6).setVisibility(0);
                ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(switchOn != 0);
            }
        }

        private void updateAutoZoomTempSet() {
            int val = DataCanbus.DATA[4];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view5).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view5).setVisibility(0);
                if (DataCanbus.DATA[1000] == 308) {
                    if (switchOn == 0) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_danqu);
                        return;
                    } else if (switchOn == 1) {
                        ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.wc_weilang_shuangqu);
                        return;
                    } else {
                        if (switchOn == 2) {
                            ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
                            return;
                        }
                        return;
                    }
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_form_Set);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_Auto_zone_climate_controlUni_Subdivision_Set);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_last_Set);
                }
            }
        }

        private void updateQualitySensor1() {
            int val = DataCanbus.DATA[2];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view4).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view4).setVisibility(0);
                if (switchOn == 2) {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(false);
                } else {
                    ((CheckedTextView) klcAirMessageAct.this.findViewById(R.id.ctv_checkedtext8)).setChecked(true);
                }
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_Low_sensitivity);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.klc_air_high_sensitivity);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                }
            }
        }

        private void updateAIrModeSet() {
            int val = DataCanbus.DATA[1];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view3).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view3).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_Off);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_Parking_with_trailer_ON);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_last_set);
                }
            }
        }

        private void updateAutoWindMode() {
            int val = DataCanbus.DATA[0];
            int enable = (val >> 8) & 255;
            int switchOn = val & 255;
            if (enable == 0) {
                klcAirMessageAct.this.findViewById(R.id.layout_view2).setVisibility(8);
                return;
            }
            if (enable == 1) {
                klcAirMessageAct.this.findViewById(R.id.layout_view2).setVisibility(0);
                if (switchOn == 0) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                } else if (switchOn == 1) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                } else if (switchOn == 2) {
                    ((TextView) klcAirMessageAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                }
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_klc_air_message_set);
        setUI();
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int valAutoVolPre = DataCanbus.DATA[0] & 255;
                if (valAutoVolPre == 0) {
                    KlcFunc.C_CAR_AIR(1, 2);
                } else if (valAutoVolPre == 1) {
                    KlcFunc.C_CAR_AIR(1, 0);
                } else if (valAutoVolPre == 2) {
                    KlcFunc.C_CAR_AIR(1, 1);
                }
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int valAutoVolNext = DataCanbus.DATA[0] & 255;
                if (valAutoVolNext == 0) {
                    KlcFunc.C_CAR_AIR(1, 1);
                } else if (valAutoVolNext == 1) {
                    KlcFunc.C_CAR_AIR(1, 2);
                } else if (valAutoVolNext == 2) {
                    KlcFunc.C_CAR_AIR(1, 0);
                }
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int valAirConPre = DataCanbus.DATA[1] & 255;
                if (valAirConPre == 0) {
                    KlcFunc.C_CAR_AIR(2, 2);
                } else if (valAirConPre == 1) {
                    KlcFunc.C_CAR_AIR(2, 0);
                } else if (valAirConPre == 2) {
                    KlcFunc.C_CAR_AIR(2, 1);
                }
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int valAirConNext = DataCanbus.DATA[1] & 255;
                if (valAirConNext == 0) {
                    KlcFunc.C_CAR_AIR(2, 1);
                } else if (valAirConNext == 1) {
                    KlcFunc.C_CAR_AIR(2, 2);
                } else if (valAirConNext == 2) {
                    KlcFunc.C_CAR_AIR(2, 0);
                }
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int valAutoZonePre = DataCanbus.DATA[4] & 255;
                if (valAutoZonePre == 0) {
                    KlcFunc.C_CAR_AIR(4, 2);
                } else if (valAutoZonePre == 1) {
                    KlcFunc.C_CAR_AIR(4, 0);
                } else if (valAutoZonePre == 2) {
                    KlcFunc.C_CAR_AIR(4, 1);
                }
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int valAutoZoneNext = DataCanbus.DATA[4] & 255;
                if (valAutoZoneNext == 0) {
                    KlcFunc.C_CAR_AIR(4, 1);
                } else if (valAutoZoneNext == 1) {
                    KlcFunc.C_CAR_AIR(4, 2);
                } else if (valAutoZoneNext == 2) {
                    KlcFunc.C_CAR_AIR(4, 0);
                }
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int valSeatTempPre = DataCanbus.DATA[10] & 255;
                if (valSeatTempPre == 0) {
                    KlcFunc.C_CAR_AIR(9, 2);
                } else if (valSeatTempPre == 1) {
                    KlcFunc.C_CAR_AIR(9, 0);
                } else if (valSeatTempPre == 2) {
                    KlcFunc.C_CAR_AIR(9, 1);
                }
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int valSeatTempNext = DataCanbus.DATA[10] & 255;
                if (valSeatTempNext == 0) {
                    KlcFunc.C_CAR_AIR(9, 1);
                } else if (valSeatTempNext == 1) {
                    KlcFunc.C_CAR_AIR(9, 2);
                } else if (valSeatTempNext == 2) {
                    KlcFunc.C_CAR_AIR(9, 0);
                }
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value = DataCanbus.DATA[68] & 255;
                if (value == 0) {
                    KlcFunc.C_CAR_AIR(14, 2);
                } else if (value == 1) {
                    KlcFunc.C_CAR_AIR(14, 0);
                } else if (value == 2) {
                    KlcFunc.C_CAR_AIR(14, 1);
                }
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int valueNext = DataCanbus.DATA[68] & 255;
                if (valueNext == 0) {
                    KlcFunc.C_CAR_AIR(14, 1);
                } else if (valueNext == 1) {
                    KlcFunc.C_CAR_AIR(14, 2);
                } else if (valueNext == 2) {
                    KlcFunc.C_CAR_AIR(14, 0);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                KlcFunc.C_CAR_AIR(15, (DataCanbus.DATA[148] & 255) == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int valQulaity2 = DataCanbus.DATA[3] & 255;
                if (valQulaity2 == 0) {
                    KlcFunc.C_CAR_AIR(13, 1);
                } else if (valQulaity2 == 1) {
                    KlcFunc.C_CAR_AIR(13, 2);
                } else {
                    KlcFunc.C_CAR_AIR(13, 0);
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int valRemoteStart = DataCanbus.DATA[14] & 255;
                KlcFunc.C_CAR_AIR(12, valRemoteStart == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int valRearWindowDefog = DataCanbus.DATA[12] & 255;
                KlcFunc.C_CAR_AIR(11, valRearWindowDefog == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int valAutFrontDefog = DataCanbus.DATA[11] & 255;
                KlcFunc.C_CAR_AIR(10, valAutFrontDefog == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int valRemoteSeatHeat = DataCanbus.DATA[8] & 255;
                KlcFunc.C_CAR_AIR(8, valRemoteSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int valRemoteSeatven = DataCanbus.DATA[7] & 255;
                KlcFunc.C_CAR_AIR(7, valRemoteSeatven == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int valQuality1 = DataCanbus.DATA[2] & 255;
                if (valQuality1 == 0) {
                    KlcFunc.C_CAR_AIR(3, 1);
                } else if (valQuality1 == 1) {
                    KlcFunc.C_CAR_AIR(3, 2);
                } else {
                    KlcFunc.C_CAR_AIR(3, 0);
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int valSeatHeat = DataCanbus.DATA[6] & 255;
                KlcFunc.C_CAR_AIR(6, valSeatHeat == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int valseat = DataCanbus.DATA[5] & 255;
                KlcFunc.C_CAR_AIR(5, valseat == 0 ? 1 : 0);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }
}
