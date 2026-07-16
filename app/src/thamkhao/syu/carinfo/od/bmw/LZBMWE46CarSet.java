package com.syu.carinfo.od.bmw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
public class LZBMWE46CarSet extends BaseActivity implements View.OnClickListener {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 13:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
                    }
                    break;
                case 14:
                    LZBMWE46CarSet.this.setCheck((CheckedTextView) LZBMWE46CarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 15:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value == 1) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text2)).setText("℉");
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text2)).setText("℃");
                        }
                    }
                    break;
                case 16:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text3)).setText("mpg");
                        } else if (value == 2) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text3)).setText("km/l");
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text3)).setText("l/100km");
                        }
                    }
                    break;
                case 17:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value == 1) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text4)).setText("mil");
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text4)).setText("km");
                        }
                    }
                    break;
                case 18:
                    LZBMWE46CarSet.this.setCheck((CheckedTextView) LZBMWE46CarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 19:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value == 1) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text5)).setText("12h");
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text5)).setText("24h");
                        }
                    }
                    break;
                case 20:
                    LZBMWE46CarSet.this.setCheck((CheckedTextView) LZBMWE46CarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 21:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km");
                    }
                    break;
                case 24:
                    LZBMWE46CarSet.this.updateLauguageSet();
                    break;
                case 26:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 6) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text7)).setText("+" + (value - 6));
                        } else if (value > 6) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text7)).setText("-" + (6 - value));
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 27:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 6) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text8)).setText("+" + (value - 6));
                        } else if (value > 6) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text8)).setText("-" + (6 - value));
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
                case 28:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text9)) != null) {
                        if (value > 10) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text9)).setText("R" + (value - 10));
                        } else if (value > 10) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text9)).setText("F" + (10 - value));
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text9)).setText("0");
                        }
                    }
                    break;
                case 29:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text10)) != null) {
                        if (value > 10) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text10)).setText("R" + (value - 10));
                        } else if (value > 10) {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text10)).setText("L" + (10 - value));
                        } else {
                            ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text10)).setText("0");
                        }
                    }
                    break;
                case 30:
                    if (((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("CONCERT HALL");
                                break;
                            case 1:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("JAZZ CLUB");
                                break;
                            case 2:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("CATHEDRAL");
                                break;
                            case 3:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("MEMO1");
                                break;
                            case 4:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("MEMO2");
                                break;
                            case 5:
                                ((TextView) LZBMWE46CarSet.this.findViewById(R.id.tv_text11)).setText("MEMO3");
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
        setContentView(R.layout.layout_0453_lz_bmw_e46_settings);
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
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LZBMWE46CarSet.this.language_set = position;
                if (LZBMWE46CarSet.this.language_set >= 0 && LZBMWE46CarSet.this.language_set <= LZBMWE46CarSet.this.mLauStylelist.size() && LZBMWE46CarSet.this.send_lang != null) {
                    DataCanbus.PROXY.cmd(0, new int[]{7, LZBMWE46CarSet.this.send_lang[LZBMWE46CarSet.this.language_set], 0}, null, null);
                }
                LZBMWE46CarSet.this.mLauStyle.dismiss();
            }
        });
    }

    public void updateLauguageSet() {
        int value = DataCanbus.DATA[24];
        int i = 0;
        while (i < this.mLauStylelist.size() && value != this.send_lang[i]) {
            i++;
        }
        if (i < this.mLauStylelist.size()) {
            if (((TextView) findViewById(R.id.lauguage_set_curr)) != null) {
                ((TextView) findViewById(R.id.lauguage_set_curr)).setText(this.mLauStylelist.get(i));
            }
            if (this.mLauStylelv != null) {
                this.mLauStylelv.setItemChecked(i, true);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_US));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_1_UK));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_4));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_5));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_3));
        this.mLauStylelist.add(getResources().getString(R.string.wc_psa_all_lauguage_set_value_8));
        this.send_lang = new int[]{0, 1, 2, 3, 4, 5};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LZBMWE46CarSet.this.mLauStyle == null) {
                    LZBMWE46CarSet.this.initLauStyle();
                }
                if (LZBMWE46CarSet.this.mLauStyle != null && LZBMWE46CarSet.this.mPopShowView != null) {
                    LZBMWE46CarSet.this.mLauStyle.showAtLocation(LZBMWE46CarSet.this.mPopShowView, 17, 0, 0);
                    LZBMWE46CarSet.this.updateLauguageSet();
                }
            }
        });
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.btn_minus1).setOnClickListener(this);
        findViewById(R.id.btn_plus1).setOnClickListener(this);
        findViewById(R.id.btn_minus2).setOnClickListener(this);
        findViewById(R.id.btn_plus2).setOnClickListener(this);
        findViewById(R.id.btn_minus3).setOnClickListener(this);
        findViewById(R.id.btn_plus3).setOnClickListener(this);
        findViewById(R.id.btn_minus4).setOnClickListener(this);
        findViewById(R.id.btn_plus4).setOnClickListener(this);
        findViewById(R.id.btn_minus5).setOnClickListener(this);
        findViewById(R.id.btn_plus5).setOnClickListener(this);
        findViewById(R.id.btn_minus6).setOnClickListener(this);
        findViewById(R.id.btn_plus6).setOnClickListener(this);
        findViewById(R.id.btn_minus7).setOnClickListener(this);
        findViewById(R.id.btn_plus7).setOnClickListener(this);
        findViewById(R.id.btn_minus8).setOnClickListener(this);
        findViewById(R.id.btn_plus8).setOnClickListener(this);
        findViewById(R.id.btn_minus9).setOnClickListener(this);
        findViewById(R.id.btn_plus9).setOnClickListener(this);
        findViewById(R.id.btn_minus10).setOnClickListener(this);
        findViewById(R.id.btn_plus10).setOnClickListener(this);
        findViewById(R.id.btn_minus11).setOnClickListener(this);
        findViewById(R.id.btn_plus11).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[20];
                if (value > 6) {
                    value--;
                }
                setCarInfo(1, (value >> 8) & 255, value & 255);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[13];
                if (value2 < 299) {
                    value2++;
                }
                setCarInfo(1, (value2 >> 8) & 255, value2 & 255);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[15] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(2, value3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[15] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(2, value4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[16] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(3, value5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[16] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(3, value6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[17] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(4, value7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[17] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(4, value8, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[19] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarTime(2, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[19] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarTime(2, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[21];
                if (value11 > 0) {
                    value11--;
                }
                setCarInfo(8, (value11 >> 8) & 255, value11 & 255);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[21];
                if (value12 < 9999) {
                    value12++;
                }
                setCarInfo(8, (value12 >> 8) & 255, value12 & 255);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[26];
                if (value13 > 0) {
                    value13--;
                }
                setCarInfo1(1, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[26];
                if (value14 < 12) {
                    value14++;
                }
                setCarInfo1(1, value14);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value15 = DataCanbus.DATA[27];
                if (value15 > 0) {
                    value15--;
                }
                setCarInfo1(2, value15);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value16 = DataCanbus.DATA[27];
                if (value16 < 12) {
                    value16++;
                }
                setCarInfo1(2, value16);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value17 = DataCanbus.DATA[28];
                if (value17 > 0) {
                    value17--;
                }
                setCarInfo1(3, value17);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value18 = DataCanbus.DATA[28];
                if (value18 < 20) {
                    value18++;
                }
                setCarInfo1(3, value18);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value19 = DataCanbus.DATA[29];
                if (value19 > 0) {
                    value19--;
                }
                setCarInfo1(4, value19);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value20 = DataCanbus.DATA[29];
                if (value20 < 20) {
                    value20++;
                }
                setCarInfo1(4, value20);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value21 = DataCanbus.DATA[30] - 1;
                if (value21 < 0) {
                    value21 = 5;
                }
                setCarInfo1(5, value21);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value22 = DataCanbus.DATA[30] + 1;
                if (value22 > 5) {
                    value22 = 0;
                }
                setCarInfo1(5, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value23 = DataCanbus.DATA[14];
                if (value23 == 1) {
                    value23 = 0;
                } else if (value23 == 0) {
                    value23 = 1;
                }
                setCarInfo(0, value23, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value24 = DataCanbus.DATA[18];
                if (value24 == 1) {
                    value24 = 0;
                } else if (value24 == 0) {
                    value24 = 1;
                }
                setCarInfo(5, value24, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value25 = DataCanbus.DATA[20];
                if (value25 == 1) {
                    value25 = 0;
                } else if (value25 == 0) {
                    value25 = 1;
                }
                setCarInfo(6, value25, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                dialog(11);
                break;
        }
    }

    protected void dialog(final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(R.string.factory_data_reset) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(0, new int[]{i, 0, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.od.bmw.LZBMWE46CarSet.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3}, null, null);
    }

    public void setCarTime(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    public void setCarInfo1(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[21].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[26].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[21].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }
}
