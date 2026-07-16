package com.syu.carinfo.rzc.ruifengs3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: classes.dex */
public class JhJiayueA5SetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5SetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 107:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("90");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text2)).setText("120s");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("15s");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 3:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("45");
                                break;
                            case 4:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 109:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("15km/h");
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text4)).setText("40km/h");
                                break;
                        }
                    }
                    break;
                case 110:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 111:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 112:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 113:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 114:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_golf_comfort);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.driver_system_sports);
                                break;
                        }
                    }
                    break;
                case 115:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 116:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 117:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 118:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 119:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 120:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_395_static_state);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_breathe);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_music_rhythm);
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 122:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(val + 1).toString());
                    }
                    break;
                case 123:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 125:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.str_driving_comfort);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text11)).setText(R.string.str_dynamic);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text12)).setText(R.string.str_driving_eco);
                                break;
                        }
                    }
                    break;
                case 127:
                    JhJiayueA5SetFunc.this.setCheck((CheckedTextView) JhJiayueA5SetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 128:
                    if (((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.wc_golf_normal);
                                break;
                            case 1:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.mateng_air_con_profile_0);
                                break;
                            case 2:
                                ((TextView) JhJiayueA5SetFunc.this.findViewById(R.id.tv_text13)).setText(R.string.mateng_air_con_profile_2);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_jianghuai_jiayuea5_setfunc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Jianghuai_SEHOL_E50A /* 2490822 */:
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(8);
                findViewById(R.id.layout_view20).setVisibility(8);
                findViewById(R.id.layout_view21).setVisibility(8);
                findViewById(R.id.layout_view22).setVisibility(8);
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[106] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[106] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[107] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[107] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[108] - 1;
                if (value5 < 0) {
                    value5 = 4;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[108] + 1;
                if (value6 > 4) {
                    value6 = 0;
                }
                setCarInfo(3, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[109] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[109] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(4, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[112];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(7, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[112];
                if (value10 < 10) {
                    value10++;
                }
                setCarInfo(7, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[114] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[114] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[119];
                if (value13 > 0) {
                    value13--;
                }
                setCarLight(2, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[119];
                if (value14 < 10) {
                    value14++;
                }
                setCarLight(2, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[120] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarLight(3, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[120] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarLight(3, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[121];
                if (value17 > 0) {
                    value17--;
                }
                setCarLight(4, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[121];
                if (value18 < 63) {
                    value18++;
                }
                setCarLight(4, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[122] - 1;
                if (value19 < 0) {
                    value19 = 9;
                }
                setCarLight(5, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[122] + 1;
                if (value20 > 9) {
                    value20 = 0;
                }
                setCarLight(5, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[125] - 1;
                if (value21 < 0) {
                    value21 = 2;
                }
                setCarInfo(13, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[125] + 1;
                if (value22 > 2) {
                    value22 = 0;
                }
                setCarInfo(13, value22);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value23 = DataCanbus.DATA[126] - 1;
                if (value23 < 0) {
                    value23 = 1;
                }
                setCarInfo(14, value23);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value24 = DataCanbus.DATA[126] + 1;
                if (value24 > 1) {
                    value24 = 0;
                }
                setCarInfo(14, value24);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                if (DataCanbus.DATA[126] == 0) {
                    dialog(R.string.all_settings, 31);
                } else {
                    int value25 = DataCanbus.DATA[128] - 1;
                    if (value25 < 0) {
                        value25 = 2;
                    }
                    setCarInfo(16, value25);
                }
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                if (DataCanbus.DATA[126] == 0) {
                    dialog(R.string.all_settings, 31);
                } else {
                    int value26 = DataCanbus.DATA[128] + 1;
                    if (value26 > 2) {
                        value26 = 0;
                    }
                    setCarInfo(16, value26);
                }
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value27 = DataCanbus.DATA[110];
                if (value27 == 1) {
                    value27 = 0;
                } else if (value27 == 0) {
                    value27 = 1;
                }
                setCarInfo(5, value27);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value28 = DataCanbus.DATA[111];
                if (value28 == 1) {
                    value28 = 0;
                } else if (value28 == 0) {
                    value28 = 1;
                }
                setCarInfo(6, value28);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value29 = DataCanbus.DATA[113];
                if (value29 == 1) {
                    value29 = 0;
                } else if (value29 == 0) {
                    value29 = 1;
                }
                setCarInfo(8, value29);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value30 = DataCanbus.DATA[115];
                if (value30 == 1) {
                    value30 = 0;
                } else if (value30 == 0) {
                    value30 = 1;
                }
                setCarInfo(10, value30);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value31 = DataCanbus.DATA[116];
                if (value31 == 1) {
                    value31 = 0;
                } else if (value31 == 0) {
                    value31 = 1;
                }
                setCarInfo(11, value31);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value32 = DataCanbus.DATA[117];
                if (value32 == 1) {
                    value32 = 0;
                } else if (value32 == 0) {
                    value32 = 1;
                }
                setCarInfo(12, value32);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value33 = DataCanbus.DATA[118];
                if (value33 == 1) {
                    value33 = 0;
                } else if (value33 == 0) {
                    value33 = 1;
                }
                setCarLight(1, value33);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value34 = DataCanbus.DATA[123];
                if (value34 == 1) {
                    value34 = 0;
                } else if (value34 == 0) {
                    value34 = 1;
                }
                setCarLight(6, value34);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int value35 = DataCanbus.DATA[127];
                if (value35 == 1) {
                    value35 = 0;
                } else if (value35 == 0) {
                    value35 = 1;
                }
                setCarInfo(15, value35);
                break;
        }
    }

    protected void dialog(int stringId, int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("当前驾驶模式非经济模式,不能设置!");
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5SetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.ruifengs3.JhJiayueA5SetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    public void setCarLight(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{64, 0}, null, null);
        if (DataCanbus.DATA[1000] != 2490822) {
            DataCanbus.PROXY.cmd(3, new int[]{66, 0}, null, null);
        }
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
    }
}
