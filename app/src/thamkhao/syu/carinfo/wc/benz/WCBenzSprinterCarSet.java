package com.syu.carinfo.wc.benz;

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
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WCBenzSprinterCarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.benz.WCBenzSprinterCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 96:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_4);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_7);
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.carema_type_6);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 97:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 98:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_normal);
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.str_keen);
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 99:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 100:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("120km/h");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("130km/h");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("140km/h");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("150km/h");
                                break;
                            case 5:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("160km/h");
                                break;
                            case 6:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("170km/h");
                                break;
                            case 7:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText("180km/h");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 101:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 102:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 103:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 104:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 105:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                            case 3:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("45s");
                                break;
                            case 4:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText("60s");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 106:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 107:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 108:
                    if (((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("mi");
                                break;
                            default:
                                ((TextView) WCBenzSprinterCarSet.this.findViewById(R.id.tv_text5)).setText("km");
                                break;
                        }
                    }
                    break;
                case 109:
                    WCBenzSprinterCarSet.this.setCheck((CheckedTextView) WCBenzSprinterCarSet.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_wc_sprinter_settings);
        init();
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.wc.benz.WCBenzSprinterCarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                WCBenzSprinterCarSet.this.language_set = position;
                if (WCBenzSprinterCarSet.this.language_set >= 0 && WCBenzSprinterCarSet.this.language_set <= WCBenzSprinterCarSet.this.mLauStylelist.size() && WCBenzSprinterCarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(1, new int[]{1, WCBenzSprinterCarSet.this.send_lang[WCBenzSprinterCarSet.this.language_set]}, null, null);
                }
                WCBenzSprinterCarSet.this.mLauStyle.dismiss();
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
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_37));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_7));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_9));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_9));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_26));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_12));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_13));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_15));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_16));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_22));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_31));
        this.mLauStylelist.add("Romana");
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_40));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_27));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_33));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_19));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_21));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_20));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_32));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_6));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_2));
        this.mLauStylelist.add(getResources().getString(R.string.rzc_others_language_setting_41));
        this.send_lang = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15, 16, 17, 18, 20, 22, 23, 24, 25, 26, 27, 28, 31, 32, 34};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.wc.benz.WCBenzSprinterCarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WCBenzSprinterCarSet.this.mLauStyle == null) {
                    WCBenzSprinterCarSet.this.initLauStyle();
                }
                if (WCBenzSprinterCarSet.this.mLauStyle != null && WCBenzSprinterCarSet.this.mPopShowView != null) {
                    WCBenzSprinterCarSet.this.mLauStyle.showAtLocation(WCBenzSprinterCarSet.this.mPopShowView, 17, 0, 0);
                    WCBenzSprinterCarSet.this.updateLauguageSet();
                }
            }
        });
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[96] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[96] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[98] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[98] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[100] - 1;
                if (value5 < 0) {
                    value5 = 7;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 7) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[105] - 1;
                if (value7 < 0) {
                    value7 = 4;
                }
                setCarInfo(34, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[105] + 1;
                if (value8 > 4) {
                    value8 = 0;
                }
                setCarInfo(34, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[108] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(50, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[108] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(50, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value11 = DataCanbus.DATA[95];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(1, value11);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value12 = DataCanbus.DATA[97];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(3, value12);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value13 = DataCanbus.DATA[99];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(5, value13);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value14 = DataCanbus.DATA[101];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(18, value14);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value15 = DataCanbus.DATA[102];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(19, value15);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value16 = DataCanbus.DATA[103];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(20, value16);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value17 = DataCanbus.DATA[104];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(33, value17);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value18 = DataCanbus.DATA[106];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(35, value18);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int value19 = DataCanbus.DATA[107];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(49, value19);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int value20 = DataCanbus.DATA[109];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(52, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
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

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
    }
}
