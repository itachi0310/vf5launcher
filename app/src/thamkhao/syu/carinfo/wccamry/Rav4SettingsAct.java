package com.syu.carinfo.wccamry;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Rav4SettingsAct extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    Rav4SettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 99:
                    Rav4SettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 100:
                    Rav4SettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 101:
                    Rav4SettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 102:
                    Rav4SettingsAct.this.mUpdaterAutoAc();
                    break;
                case 103:
                    Rav4SettingsAct.this.mUpdaterValidVentilation();
                    break;
                case 104:
                    Rav4SettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 105:
                    Rav4SettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 106:
                    Rav4SettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 107:
                    Rav4SettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 108:
                    Rav4SettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 109:
                    Rav4SettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 110:
                    Rav4SettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 127:
                    Rav4SettingsAct.this.mUpdaterOuteriorLightOffTime();
                    break;
                case 166:
                    if (value > 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("+" + (value - 3));
                    } else if (value < 3) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("-" + (3 - value));
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text12)).setText("0");
                    }
                    break;
                case 167:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
                    }
                    break;
                case 168:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("+" + (value - 2));
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("-" + (2 - value));
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text6)).setText("0");
                    }
                    break;
                case 169:
                    if (value > 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("+" + (value - 2));
                    } else if (value < 2) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("-" + (2 - value));
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text7)).setText("0");
                    }
                    break;
                case 170:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_incline);
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_only_telescoping);
                            break;
                        case 3:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_incline_telescoping);
                            break;
                    }
                    break;
                case 171:
                    ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    break;
                case 178:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("Half");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text10)).setText("All");
                            break;
                    }
                    break;
                case 179:
                    switch (value) {
                        case 0:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Stop");
                            break;
                        case 2:
                            ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text11)).setText("Start");
                            break;
                    }
                    break;
                case 180:
                    if (((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)) != null) {
                        ((CheckedTextView) Rav4SettingsAct.this.findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
                    }
                    break;
                case 181:
                    if (value == 0) {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als1);
                    } else {
                        ((TextView) Rav4SettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_244_als2);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rav4_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Rav4SettingsAct.this.language_set = position;
                if (Rav4SettingsAct.this.language_set >= 0 && Rav4SettingsAct.this.language_set <= Rav4SettingsAct.this.mLauStylelist.size() && Rav4SettingsAct.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(32, new int[]{1, Rav4SettingsAct.this.send_lang[Rav4SettingsAct.this.language_set]}, null, null);
                }
                Rav4SettingsAct.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        if (this.language_set >= 0 && this.language_set < this.mLauStylelist.size() && this.mLauStylelv != null) {
            this.mLauStylelv.setItemChecked(this.language_set, true);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_2));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_3));
        this.mLauStylelist.add("Thai");
        this.mLauStylelist.add("Viet");
        this.mLauStylelist.add("Indonesia");
        this.mLauStylelist.add("Malaysia");
        this.send_lang = new int[]{1, 2, 3, 5, 7, 9, 15, 19, 30, 42, 43};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (Rav4SettingsAct.this.mLauStyle == null) {
                    Rav4SettingsAct.this.initLauStyle();
                }
                if (Rav4SettingsAct.this.mLauStyle != null && Rav4SettingsAct.this.mPopShowView != null) {
                    Rav4SettingsAct.this.mLauStyle.showAtLocation(Rav4SettingsAct.this.mPopShowView, 17, 0, 0);
                    Rav4SettingsAct.this.updateLauguageSet();
                }
            }
        });
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios /* 2359590 */:
            case FinalCanbus.CAR_WC2_TOYOTA_22Vios_H /* 2425126 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios /* 2490662 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Vios_H /* 2556198 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla /* 2621734 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Corolla_H /* 2687270 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova /* 3408166 */:
            case FinalCanbus.CAR_WC2_TOYOTA_23Innova_H /* 3473702 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR /* 4587814 */:
            case FinalCanbus.CAR_WC2_TOYOTA_17CHR_H /* 4653350 */:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.layout_view3).setVisibility(8);
                findViewById(R.id.layout_view4).setVisibility(8);
                findViewById(R.id.layout_view5).setVisibility(8);
                findViewById(R.id.layout_view6).setVisibility(8);
                findViewById(R.id.layout_view7).setVisibility(8);
                findViewById(R.id.layout_view8).setVisibility(8);
                findViewById(R.id.layout_view9).setVisibility(8);
                findViewById(R.id.layout_view10).setVisibility(8);
                findViewById(R.id.layout_view11).setVisibility(8);
                findViewById(R.id.layout_view12).setVisibility(8);
                findViewById(R.id.layout_view13).setVisibility(8);
                findViewById(R.id.layout_view14).setVisibility(8);
                findViewById(R.id.layout_view15).setVisibility(8);
                findViewById(R.id.layout_view16).setVisibility(8);
                findViewById(R.id.layout_view17).setVisibility(8);
                findViewById(R.id.layout_view18).setVisibility(8);
                findViewById(R.id.layout_view19).setVisibility(8);
                findViewById(R.id.layout_view20).setVisibility(8);
                findViewById(R.id.layout_view21).setVisibility(8);
                findViewById(R.id.layout_view22).setVisibility(8);
                findViewById(R.id.layout_view23).setVisibility(8);
                findViewById(R.id.layout_text_view1).setVisibility(8);
                findViewById(R.id.layout_text_view2).setVisibility(8);
                findViewById(R.id.layout_text_view3).setVisibility(8);
                findViewById(R.id.layout_text_view4).setVisibility(8);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(0);
                findViewById(R.id.layout_view3).setVisibility(0);
                findViewById(R.id.layout_view4).setVisibility(0);
                findViewById(R.id.layout_view5).setVisibility(0);
                findViewById(R.id.layout_view6).setVisibility(0);
                findViewById(R.id.layout_view7).setVisibility(0);
                findViewById(R.id.layout_view8).setVisibility(0);
                findViewById(R.id.layout_view9).setVisibility(0);
                findViewById(R.id.layout_view10).setVisibility(0);
                findViewById(R.id.layout_view11).setVisibility(0);
                findViewById(R.id.layout_view12).setVisibility(0);
                findViewById(R.id.layout_view13).setVisibility(0);
                findViewById(R.id.layout_view14).setVisibility(0);
                findViewById(R.id.layout_view15).setVisibility(0);
                findViewById(R.id.layout_view16).setVisibility(0);
                findViewById(R.id.layout_view17).setVisibility(0);
                findViewById(R.id.layout_view18).setVisibility(0);
                findViewById(R.id.layout_view19).setVisibility(0);
                findViewById(R.id.layout_view20).setVisibility(0);
                findViewById(R.id.layout_view21).setVisibility(0);
                findViewById(R.id.layout_view22).setVisibility(0);
                findViewById(R.id.layout_view23).setVisibility(0);
                findViewById(R.id.layout_text_view1).setVisibility(0);
                findViewById(R.id.layout_text_view2).setVisibility(0);
                findViewById(R.id.layout_text_view3).setVisibility(0);
                findViewById(R.id.layout_text_view4).setVisibility(0);
                break;
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[99] == 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(0, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[109] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[101] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[100] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[104] == 0) {
                    DataCanbus.PROXY.cmd(8, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(8, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[110] == 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(6, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(7, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[102] == 0) {
                    DataCanbus.PROXY.cmd(9, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(9, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[103] == 0) {
                    DataCanbus.PROXY.cmd(10, new int[]{1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(10, new int[1], null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[167] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 11, 0}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DataCanbus.DATA[180] == 0) {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(29, new int[]{1, 17, 0}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(Rav4SettingsAct.this, Wc09LexusESEQActi.class);
                    Rav4SettingsAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 > 0 && value2 - 1 > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[105];
                if (value2 < 4 && (value = value2 + 1) > -1 && value < 5) {
                    DataCanbus.PROXY.cmd(11, new int[]{value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[98] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(12, new int[]{value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[127] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{3, 3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[181] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 19, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[168];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[168];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 12, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[169];
                if (value < 4) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 13, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.30
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.31
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[170];
                if (value < 3) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 15, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.32
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.33
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[171];
                if (value < 7) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{2, 5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.34
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[178];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.35
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[178];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 16, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.36
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[179];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.37
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[179];
                if (value < 2) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.38
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[166];
                if (value > 0) {
                    value--;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus11)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wccamry.Rav4SettingsAct.39
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[166];
                if (value < 6) {
                    value++;
                }
                DataCanbus.PROXY.cmd(29, new int[]{1, 14, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOuteriorLightOffTime() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.tv_text4)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text4)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.tv_text3)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text3)).setText(ConstWcToyota.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[99];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[109];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_all);
        } else {
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.lock_set_unlock_intelligent_door_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[101];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[100];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[104];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoAc() {
        int value = DataCanbus.DATA[102];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValidVentilation() {
        int value = DataCanbus.DATA[103];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.tv_text2)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text2)).setBackgroundResource(Rav4Data.mSensDrawableId[value]);
        }
    }
}
