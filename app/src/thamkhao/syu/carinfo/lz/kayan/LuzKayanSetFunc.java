package com.syu.carinfo.lz.kayan;

import android.os.Bundle;
import android.util.Log;
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
import com.syu.module.canbus.Callback_0439_LZ_Kayan;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.module.main.DataMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LuzKayanSetFunc extends BaseActivity {
    private PopupWindow mLauStyle;
    public ArrayList<String> mLauStylelist;
    public ListView mLauStylelv;
    private View mPopShowView;
    int[] send_lang;
    int language_set = 255;
    private IUiNotify sNotify = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 174:
                    Log.v("zed", "174  rev==alll 11111111111 ints[0]== " + ints[0] + "  ints[1]== " + ints[1] + "  ints[2]== " + ints[2]);
                    if (ints.length >= 2) {
                        switch (ints[1]) {
                            case -2:
                                Callback_0439_LZ_Kayan.modevalue = ints[2];
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    LuzKayanSetFunc.this.updateInterlightOfftime(value);
                    break;
                case 51:
                    LuzKayanSetFunc.this.updateInterlight(value);
                    break;
                case 52:
                    LuzKayanSetFunc.this.updateDayTimeLight(value);
                    break;
                case 53:
                    LuzKayanSetFunc.this.updateWiperSensorType(value);
                    break;
                case 54:
                    LuzKayanSetFunc.this.updateWiperRearType(value);
                    break;
                case 55:
                    LuzKayanSetFunc.this.updateReversingOptions(value);
                    break;
                case 56:
                    LuzKayanSetFunc.this.updateDoorUnlockType(value);
                    break;
                case 57:
                    LuzKayanSetFunc.this.updateDoorlockType(value);
                    break;
                case 58:
                    LuzKayanSetFunc.this.updateComfortEntry(value);
                    break;
                case 59:
                    LuzKayanSetFunc.this.updateAirPanel(value);
                    break;
                case 60:
                    LuzKayanSetFunc.this.updateAirAutoCirc(value);
                    break;
                case 61:
                    LuzKayanSetFunc.this.updateAirStyleType(value);
                    break;
                case 62:
                    LuzKayanSetFunc.this.updateOutlightOfftime(value);
                    break;
                case 64:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type1");
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text1)).setText("Type2");
                            break;
                    }
                    break;
                case 65:
                    LuzKayanSetFunc.this.updateLauguageSet();
                    break;
                case 67:
                    switch (value) {
                        case 0:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_Manual);
                            break;
                        case 1:
                            ((TextView) LuzKayanSetFunc.this.findViewById(R.id.tv_text2)).setText(R.string.klc_air_auto);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_luz_kayan_setfunc);
        if (readFile("/sys/fytver/fyt_bin_version").contains("Ls18") || readFile("/sys/fytver/fyt_bin_version").contains("Lt18")) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_LUZ_KAYAN_MACAN_CD_HP_LOW /* 1900998 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD /* 6291895 */:
            case FinalCanbus.CAR_439_LUZ_KAYAN_MACAN_CD_HP /* 6422967 */:
                findViewById(R.id.layout_view2).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
        init();
        ((Button) findViewById(R.id.luz_kayan_intlight_offtime_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[50] - 1;
                if (value < 0) {
                    value = 30;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intlight_offtime_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[50] + 1;
                if (value > 30) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intamblight_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[51] - 1;
                if (value < 0) {
                    value = 10;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_intamblightplus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[51] + 1;
                if (value > 10) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[52];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{0, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_outlight_offtime_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[62] - 1;
                if (value < 1) {
                    value = 12;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_outlight_offtime_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[62] + 1;
                if (value > 12) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_wiper_rainauto_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[53] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_wiper_rainauto_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[53] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_rear_wiper_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[54] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_rear_wiper_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[54] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{5, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.14
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[55];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{6, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_unlock_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_unlock_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[56] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{7, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_lock_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.17
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_door_lock_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.18
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[57] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{8, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.19
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[64] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.20
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[64] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{18, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.21
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[67] - 1;
                if (value < 0) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.22
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[67] + 1;
                if (value > 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{248, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[58];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{10, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.24
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[59];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{9, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.25
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[60];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{11, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_air_conditioning_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.26
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[61] - 1;
                if (value < 0) {
                    value = 2;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.luz_kayan_air_conditioning_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.27
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[61] + 1;
                if (value > 2) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{17, value}, null, null);
            }
        });
    }

    String readFile(String path) {
        String strInfo = "";
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    sb.append(String.valueOf(str) + "\n");
                } else {
                    br.close();
                    strInfo = sb.toString();
                    return strInfo;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return strInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLauStyle() {
        LayoutInflater inflater = (LayoutInflater) getSystemService("layout_inflater");
        View layout = inflater.inflate(R.layout.layout_lauguage2, (ViewGroup) null);
        this.mLauStyle = new PopupWindow(layout, 548, 408);
        this.mLauStyle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bk_models_pop));
        this.mLauStyle.setFocusable(true);
        this.mLauStyle.setTouchable(true);
        this.mLauStyle.setOutsideTouchable(true);
        this.mLauStylelv = (ListView) layout.findViewById(R.id.lauguageListview);
        this.mLauStylelv.setAdapter((ListAdapter) new ArrayAdapter(this, R.layout.sound_effect_item, this.mLauStylelist));
        this.mLauStylelv.setItemsCanFocus(false);
        this.mLauStylelv.setChoiceMode(1);
        this.mLauStylelv.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.28
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                LuzKayanSetFunc.this.language_set = position;
                if (LuzKayanSetFunc.this.language_set >= 0 && LuzKayanSetFunc.this.language_set <= LuzKayanSetFunc.this.mLauStylelist.size() && LuzKayanSetFunc.this.send_lang != null) {
                    LuzKayanSetFunc.this.setCarInfo(250, LuzKayanSetFunc.this.language_set);
                    switch (LuzKayanSetFunc.this.language_set) {
                        case 0:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 9, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[66] != 2) {
                                LuzKayanSetFunc.this.setCarInfo(254, 2);
                            }
                            break;
                        case 1:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 19, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[66] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                            }
                            break;
                        case 2:
                            DataMain.PROXY.cmd(36, new int[]{11, 1, 44, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 2, 10, 0, 0}, null, null);
                            DataMain.PROXY.cmd(36, new int[]{11, 3, 0, 0, 0}, null, null);
                            if (Callback_0439_LZ_Kayan.modevalue != -1) {
                                DataMain.PROXY.cmd(36, new int[]{11, -2, -1, 0, 0}, null, null);
                            }
                            if (DataCanbus.DATA[66] != 1) {
                                LuzKayanSetFunc.this.setCarInfo(254, 1);
                            }
                            break;
                    }
                }
                LuzKayanSetFunc.this.mLauStyle.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLauguageSet() {
        int value = DataCanbus.DATA[65];
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

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        this.mPopShowView = getWindow().getDecorView();
        this.mLauStylelist = new ArrayList<>();
        this.mLauStylelist.add("Audi 2017 A4L 1024x480 T100");
        this.mLauStylelist.add("Audi 2017 A4L 400x240 T100");
        this.mLauStylelist.add("Audi 2017 A4L 800x480 T100");
        this.send_lang = new int[]{0, 1, 2};
        if (this.send_lang.length != this.mLauStylelist.size()) {
            throw new IllegalArgumentException("Language list length is not equal to lang cmd length");
        }
        setSelfClick((CheckedTextView) findViewById(R.id.all_func_btn_lauguage_set), new View.OnClickListener() { // from class: com.syu.carinfo.lz.kayan.LuzKayanSetFunc.29
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (LuzKayanSetFunc.this.mLauStyle == null) {
                    LuzKayanSetFunc.this.initLauStyle();
                }
                if (LuzKayanSetFunc.this.mLauStyle != null && LuzKayanSetFunc.this.mPopShowView != null) {
                    LuzKayanSetFunc.this.mLauStyle.showAtLocation(LuzKayanSetFunc.this.mPopShowView, 17, 0, 0);
                    LuzKayanSetFunc.this.updateLauguageSet();
                }
            }
        });
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataMain.NOTIFY_EVENTS[174].addNotify(this.sNotify);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirStyleType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_0);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.str_mode_normal);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_air_conditioning)).setText(R.string.mateng_air_con_profile_2);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirAutoCirc(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_auto_circ_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAirPanel(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_air_vent_panel_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComfortEntry(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_comfort_entry_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorlockType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_door_lock)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.str_ignition_on_lock);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_lock)).setText(R.string.jeep_runautolock);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_door_unlock)).setText(R.string.xp_psa_all_string_door_open_0);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReversingOptions(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_reversing_options_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperRearType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_rear_wiper)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWiperSensorType(int value) {
        if (((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_auto);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_luz_kayan_wiper_rainauto)).setText(R.string.klc_air_Manual);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_outlight_offtime)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_outlight_offtime)).setText(String.valueOf(value2) + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDayTimeLight(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_luz_kayan_daytimelight_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlight(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_intamblight)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intamblight)).setText(String.valueOf(value2) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterlightOfftime(int value) {
        int value2 = value * 10;
        if (((TextView) findViewById(R.id.tv_luz_kayan_intlight_offtime)) != null) {
            ((TextView) findViewById(R.id.tv_luz_kayan_intlight_offtime)).setText(String.valueOf(value2) + "s");
        }
    }
}
