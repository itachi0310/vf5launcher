package com.syu.carinfo.wc2.tata;

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
public class LZBMWMiniFenweiLightAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.tata.LZBMWMiniFenweiLightAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            if (DataCanbus.DATA[1000] == 1507781) {
                switch (updateCode) {
                    case 72:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                        break;
                    case 73:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                        break;
                    case 74:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 75:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                        break;
                    case 76:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                        break;
                    case 77:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                        break;
                    case 78:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                        break;
                    case 79:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                        break;
                    case 80:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                        break;
                    case 81:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                        break;
                    case 82:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                        break;
                    case 83:
                        LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                        break;
                    case 84:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 85:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    case 86:
                        ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                }
            }
            switch (updateCode) {
                case 35:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 36:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 37:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 38:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 39:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 40:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 41:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 42:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 43:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 44:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 45:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 46:
                    LZBMWMiniFenweiLightAct.this.setCheck((CheckedTextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 47:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 48:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 49:
                    ((TextView) LZBMWMiniFenweiLightAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_lz_oldmini_fwlight_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int d0_b7 = DataCanbus.DATA[35];
                int d0_b6 = DataCanbus.DATA[36];
                int d0_b30 = DataCanbus.DATA[37];
                int d1_b7 = DataCanbus.DATA[38];
                int d1_b6 = DataCanbus.DATA[39];
                int d1_b5 = DataCanbus.DATA[40];
                int d1_b4 = DataCanbus.DATA[41];
                int d1_b3 = DataCanbus.DATA[42];
                int d1_b2 = DataCanbus.DATA[43];
                int d1_b1 = DataCanbus.DATA[44];
                int d1_b0 = DataCanbus.DATA[45];
                int d2_b0 = DataCanbus.DATA[46];
                int d3_b70 = DataCanbus.DATA[47];
                int d4_b70 = DataCanbus.DATA[48];
                int d5_b70 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b7 = DataCanbus.DATA[72];
                    d0_b6 = DataCanbus.DATA[73];
                    d0_b30 = DataCanbus.DATA[74];
                    d1_b7 = DataCanbus.DATA[75];
                    d1_b6 = DataCanbus.DATA[76];
                    d1_b5 = DataCanbus.DATA[77];
                    d1_b4 = DataCanbus.DATA[78];
                    d1_b3 = DataCanbus.DATA[79];
                    d1_b2 = DataCanbus.DATA[80];
                    d1_b1 = DataCanbus.DATA[81];
                    d1_b0 = DataCanbus.DATA[82];
                    d2_b0 = DataCanbus.DATA[83];
                    d3_b70 = DataCanbus.DATA[84];
                    d4_b70 = DataCanbus.DATA[85];
                    d5_b70 = DataCanbus.DATA[86];
                }
                if (d0_b30 > 1) {
                    d0_b30--;
                }
                setCarInfo((d0_b30 & 15) | ((d0_b7 << 7) & 128) | ((d0_b6 << 6) & 64), (d1_b0 & 1) | ((d1_b7 << 7) & 128) | ((d1_b6 << 6) & 64) | ((d1_b5 << 5) & 32) | ((d1_b4 << 4) & 16) | ((d1_b3 << 3) & 8) | ((d1_b2 << 2) & 4) | ((d1_b1 << 1) & 2), d2_b0 & 1, d3_b70, d4_b70, d5_b70);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int d0_b72 = DataCanbus.DATA[35];
                int d0_b62 = DataCanbus.DATA[36];
                int d0_b302 = DataCanbus.DATA[37];
                int d1_b72 = DataCanbus.DATA[38];
                int d1_b62 = DataCanbus.DATA[39];
                int d1_b52 = DataCanbus.DATA[40];
                int d1_b42 = DataCanbus.DATA[41];
                int d1_b32 = DataCanbus.DATA[42];
                int d1_b22 = DataCanbus.DATA[43];
                int d1_b12 = DataCanbus.DATA[44];
                int d1_b02 = DataCanbus.DATA[45];
                int d2_b02 = DataCanbus.DATA[46];
                int d3_b702 = DataCanbus.DATA[47];
                int d4_b702 = DataCanbus.DATA[48];
                int d5_b702 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b72 = DataCanbus.DATA[72];
                    d0_b62 = DataCanbus.DATA[73];
                    d0_b302 = DataCanbus.DATA[74];
                    d1_b72 = DataCanbus.DATA[75];
                    d1_b62 = DataCanbus.DATA[76];
                    d1_b52 = DataCanbus.DATA[77];
                    d1_b42 = DataCanbus.DATA[78];
                    d1_b32 = DataCanbus.DATA[79];
                    d1_b22 = DataCanbus.DATA[80];
                    d1_b12 = DataCanbus.DATA[81];
                    d1_b02 = DataCanbus.DATA[82];
                    d2_b02 = DataCanbus.DATA[83];
                    d3_b702 = DataCanbus.DATA[84];
                    d4_b702 = DataCanbus.DATA[85];
                    d5_b702 = DataCanbus.DATA[86];
                }
                if (d0_b302 < 15) {
                    d0_b302++;
                }
                setCarInfo((d0_b302 & 15) | ((d0_b72 << 7) & 128) | ((d0_b62 << 6) & 64), (d1_b02 & 1) | ((d1_b72 << 7) & 128) | ((d1_b62 << 6) & 64) | ((d1_b52 << 5) & 32) | ((d1_b42 << 4) & 16) | ((d1_b32 << 3) & 8) | ((d1_b22 << 2) & 4) | ((d1_b12 << 1) & 2), d2_b02 & 1, d3_b702, d4_b702, d5_b702);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int d0_b73 = DataCanbus.DATA[35];
                int d0_b63 = DataCanbus.DATA[36];
                int d0_b303 = DataCanbus.DATA[37];
                int d1_b73 = DataCanbus.DATA[38];
                int d1_b63 = DataCanbus.DATA[39];
                int d1_b53 = DataCanbus.DATA[40];
                int d1_b43 = DataCanbus.DATA[41];
                int d1_b33 = DataCanbus.DATA[42];
                int d1_b23 = DataCanbus.DATA[43];
                int d1_b13 = DataCanbus.DATA[44];
                int d1_b03 = DataCanbus.DATA[45];
                int d2_b03 = DataCanbus.DATA[46];
                int d3_b703 = DataCanbus.DATA[47];
                int d4_b703 = DataCanbus.DATA[48];
                int d5_b703 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b73 = DataCanbus.DATA[72];
                    d0_b63 = DataCanbus.DATA[73];
                    d0_b303 = DataCanbus.DATA[74];
                    d1_b73 = DataCanbus.DATA[75];
                    d1_b63 = DataCanbus.DATA[76];
                    d1_b53 = DataCanbus.DATA[77];
                    d1_b43 = DataCanbus.DATA[78];
                    d1_b33 = DataCanbus.DATA[79];
                    d1_b23 = DataCanbus.DATA[80];
                    d1_b13 = DataCanbus.DATA[81];
                    d1_b03 = DataCanbus.DATA[82];
                    d2_b03 = DataCanbus.DATA[83];
                    d3_b703 = DataCanbus.DATA[84];
                    d4_b703 = DataCanbus.DATA[85];
                    d5_b703 = DataCanbus.DATA[86];
                }
                if (d3_b703 > 0) {
                    d3_b703--;
                }
                setCarInfo((d0_b303 & 15) | ((d0_b73 << 7) & 128) | ((d0_b63 << 6) & 64), (d1_b03 & 1) | ((d1_b73 << 7) & 128) | ((d1_b63 << 6) & 64) | ((d1_b53 << 5) & 32) | ((d1_b43 << 4) & 16) | ((d1_b33 << 3) & 8) | ((d1_b23 << 2) & 4) | ((d1_b13 << 1) & 2), d2_b03 & 1, d3_b703, d4_b703, d5_b703);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int d0_b74 = DataCanbus.DATA[35];
                int d0_b64 = DataCanbus.DATA[36];
                int d0_b304 = DataCanbus.DATA[37];
                int d1_b74 = DataCanbus.DATA[38];
                int d1_b64 = DataCanbus.DATA[39];
                int d1_b54 = DataCanbus.DATA[40];
                int d1_b44 = DataCanbus.DATA[41];
                int d1_b34 = DataCanbus.DATA[42];
                int d1_b24 = DataCanbus.DATA[43];
                int d1_b14 = DataCanbus.DATA[44];
                int d1_b04 = DataCanbus.DATA[45];
                int d2_b04 = DataCanbus.DATA[46];
                int d3_b704 = DataCanbus.DATA[47];
                int d4_b704 = DataCanbus.DATA[48];
                int d5_b704 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b74 = DataCanbus.DATA[72];
                    d0_b64 = DataCanbus.DATA[73];
                    d0_b304 = DataCanbus.DATA[74];
                    d1_b74 = DataCanbus.DATA[75];
                    d1_b64 = DataCanbus.DATA[76];
                    d1_b54 = DataCanbus.DATA[77];
                    d1_b44 = DataCanbus.DATA[78];
                    d1_b34 = DataCanbus.DATA[79];
                    d1_b24 = DataCanbus.DATA[80];
                    d1_b14 = DataCanbus.DATA[81];
                    d1_b04 = DataCanbus.DATA[82];
                    d2_b04 = DataCanbus.DATA[83];
                    d3_b704 = DataCanbus.DATA[84];
                    d4_b704 = DataCanbus.DATA[85];
                    d5_b704 = DataCanbus.DATA[86];
                }
                if (d3_b704 < 255) {
                    d3_b704++;
                }
                setCarInfo((d0_b304 & 15) | ((d0_b74 << 7) & 128) | ((d0_b64 << 6) & 64), (d1_b04 & 1) | ((d1_b74 << 7) & 128) | ((d1_b64 << 6) & 64) | ((d1_b54 << 5) & 32) | ((d1_b44 << 4) & 16) | ((d1_b34 << 3) & 8) | ((d1_b24 << 2) & 4) | ((d1_b14 << 1) & 2), d2_b04 & 1, d3_b704, d4_b704, d5_b704);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int d0_b75 = DataCanbus.DATA[35];
                int d0_b65 = DataCanbus.DATA[36];
                int d0_b305 = DataCanbus.DATA[37];
                int d1_b75 = DataCanbus.DATA[38];
                int d1_b65 = DataCanbus.DATA[39];
                int d1_b55 = DataCanbus.DATA[40];
                int d1_b45 = DataCanbus.DATA[41];
                int d1_b35 = DataCanbus.DATA[42];
                int d1_b25 = DataCanbus.DATA[43];
                int d1_b15 = DataCanbus.DATA[44];
                int d1_b05 = DataCanbus.DATA[45];
                int d2_b05 = DataCanbus.DATA[46];
                int d3_b705 = DataCanbus.DATA[47];
                int d4_b705 = DataCanbus.DATA[48];
                int d5_b705 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b75 = DataCanbus.DATA[72];
                    d0_b65 = DataCanbus.DATA[73];
                    d0_b305 = DataCanbus.DATA[74];
                    d1_b75 = DataCanbus.DATA[75];
                    d1_b65 = DataCanbus.DATA[76];
                    d1_b55 = DataCanbus.DATA[77];
                    d1_b45 = DataCanbus.DATA[78];
                    d1_b35 = DataCanbus.DATA[79];
                    d1_b25 = DataCanbus.DATA[80];
                    d1_b15 = DataCanbus.DATA[81];
                    d1_b05 = DataCanbus.DATA[82];
                    d2_b05 = DataCanbus.DATA[83];
                    d3_b705 = DataCanbus.DATA[84];
                    d4_b705 = DataCanbus.DATA[85];
                    d5_b705 = DataCanbus.DATA[86];
                }
                if (d4_b705 > 0) {
                    d4_b705--;
                }
                setCarInfo((d0_b305 & 15) | ((d0_b75 << 7) & 128) | ((d0_b65 << 6) & 64), (d1_b05 & 1) | ((d1_b75 << 7) & 128) | ((d1_b65 << 6) & 64) | ((d1_b55 << 5) & 32) | ((d1_b45 << 4) & 16) | ((d1_b35 << 3) & 8) | ((d1_b25 << 2) & 4) | ((d1_b15 << 1) & 2), d2_b05 & 1, d3_b705, d4_b705, d5_b705);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int d0_b76 = DataCanbus.DATA[35];
                int d0_b66 = DataCanbus.DATA[36];
                int d0_b306 = DataCanbus.DATA[37];
                int d1_b76 = DataCanbus.DATA[38];
                int d1_b66 = DataCanbus.DATA[39];
                int d1_b56 = DataCanbus.DATA[40];
                int d1_b46 = DataCanbus.DATA[41];
                int d1_b36 = DataCanbus.DATA[42];
                int d1_b26 = DataCanbus.DATA[43];
                int d1_b16 = DataCanbus.DATA[44];
                int d1_b06 = DataCanbus.DATA[45];
                int d2_b06 = DataCanbus.DATA[46];
                int d3_b706 = DataCanbus.DATA[47];
                int d4_b706 = DataCanbus.DATA[48];
                int d5_b706 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b76 = DataCanbus.DATA[72];
                    d0_b66 = DataCanbus.DATA[73];
                    d0_b306 = DataCanbus.DATA[74];
                    d1_b76 = DataCanbus.DATA[75];
                    d1_b66 = DataCanbus.DATA[76];
                    d1_b56 = DataCanbus.DATA[77];
                    d1_b46 = DataCanbus.DATA[78];
                    d1_b36 = DataCanbus.DATA[79];
                    d1_b26 = DataCanbus.DATA[80];
                    d1_b16 = DataCanbus.DATA[81];
                    d1_b06 = DataCanbus.DATA[82];
                    d2_b06 = DataCanbus.DATA[83];
                    d3_b706 = DataCanbus.DATA[84];
                    d4_b706 = DataCanbus.DATA[85];
                    d5_b706 = DataCanbus.DATA[86];
                }
                if (d4_b706 < 255) {
                    d4_b706++;
                }
                setCarInfo((d0_b306 & 15) | ((d0_b76 << 7) & 128) | ((d0_b66 << 6) & 64), (d1_b06 & 1) | ((d1_b76 << 7) & 128) | ((d1_b66 << 6) & 64) | ((d1_b56 << 5) & 32) | ((d1_b46 << 4) & 16) | ((d1_b36 << 3) & 8) | ((d1_b26 << 2) & 4) | ((d1_b16 << 1) & 2), d2_b06 & 1, d3_b706, d4_b706, d5_b706);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int d0_b77 = DataCanbus.DATA[35];
                int d0_b67 = DataCanbus.DATA[36];
                int d0_b307 = DataCanbus.DATA[37];
                int d1_b77 = DataCanbus.DATA[38];
                int d1_b67 = DataCanbus.DATA[39];
                int d1_b57 = DataCanbus.DATA[40];
                int d1_b47 = DataCanbus.DATA[41];
                int d1_b37 = DataCanbus.DATA[42];
                int d1_b27 = DataCanbus.DATA[43];
                int d1_b17 = DataCanbus.DATA[44];
                int d1_b07 = DataCanbus.DATA[45];
                int d2_b07 = DataCanbus.DATA[46];
                int d3_b707 = DataCanbus.DATA[47];
                int d4_b707 = DataCanbus.DATA[48];
                int d5_b707 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b77 = DataCanbus.DATA[72];
                    d0_b67 = DataCanbus.DATA[73];
                    d0_b307 = DataCanbus.DATA[74];
                    d1_b77 = DataCanbus.DATA[75];
                    d1_b67 = DataCanbus.DATA[76];
                    d1_b57 = DataCanbus.DATA[77];
                    d1_b47 = DataCanbus.DATA[78];
                    d1_b37 = DataCanbus.DATA[79];
                    d1_b27 = DataCanbus.DATA[80];
                    d1_b17 = DataCanbus.DATA[81];
                    d1_b07 = DataCanbus.DATA[82];
                    d2_b07 = DataCanbus.DATA[83];
                    d3_b707 = DataCanbus.DATA[84];
                    d4_b707 = DataCanbus.DATA[85];
                    d5_b707 = DataCanbus.DATA[86];
                }
                if (d5_b707 > 0) {
                    d5_b707--;
                }
                setCarInfo((d0_b307 & 15) | ((d0_b77 << 7) & 128) | ((d0_b67 << 6) & 64), (d1_b07 & 1) | ((d1_b77 << 7) & 128) | ((d1_b67 << 6) & 64) | ((d1_b57 << 5) & 32) | ((d1_b47 << 4) & 16) | ((d1_b37 << 3) & 8) | ((d1_b27 << 2) & 4) | ((d1_b17 << 1) & 2), d2_b07 & 1, d3_b707, d4_b707, d5_b707);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int d0_b78 = DataCanbus.DATA[35];
                int d0_b68 = DataCanbus.DATA[36];
                int d0_b308 = DataCanbus.DATA[37];
                int d1_b78 = DataCanbus.DATA[38];
                int d1_b68 = DataCanbus.DATA[39];
                int d1_b58 = DataCanbus.DATA[40];
                int d1_b48 = DataCanbus.DATA[41];
                int d1_b38 = DataCanbus.DATA[42];
                int d1_b28 = DataCanbus.DATA[43];
                int d1_b18 = DataCanbus.DATA[44];
                int d1_b08 = DataCanbus.DATA[45];
                int d2_b08 = DataCanbus.DATA[46];
                int d3_b708 = DataCanbus.DATA[47];
                int d4_b708 = DataCanbus.DATA[48];
                int d5_b708 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b78 = DataCanbus.DATA[72];
                    d0_b68 = DataCanbus.DATA[73];
                    d0_b308 = DataCanbus.DATA[74];
                    d1_b78 = DataCanbus.DATA[75];
                    d1_b68 = DataCanbus.DATA[76];
                    d1_b58 = DataCanbus.DATA[77];
                    d1_b48 = DataCanbus.DATA[78];
                    d1_b38 = DataCanbus.DATA[79];
                    d1_b28 = DataCanbus.DATA[80];
                    d1_b18 = DataCanbus.DATA[81];
                    d1_b08 = DataCanbus.DATA[82];
                    d2_b08 = DataCanbus.DATA[83];
                    d3_b708 = DataCanbus.DATA[84];
                    d4_b708 = DataCanbus.DATA[85];
                    d5_b708 = DataCanbus.DATA[86];
                }
                if (d5_b708 < 255) {
                    d5_b708++;
                }
                setCarInfo((d0_b308 & 15) | ((d0_b78 << 7) & 128) | ((d0_b68 << 6) & 64), (d1_b08 & 1) | ((d1_b78 << 7) & 128) | ((d1_b68 << 6) & 64) | ((d1_b58 << 5) & 32) | ((d1_b48 << 4) & 16) | ((d1_b38 << 3) & 8) | ((d1_b28 << 2) & 4) | ((d1_b18 << 1) & 2), d2_b08 & 1, d3_b708, d4_b708, d5_b708);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int d0_b79 = DataCanbus.DATA[35];
                int d0_b69 = DataCanbus.DATA[36];
                int d0_b309 = DataCanbus.DATA[37];
                int d1_b79 = DataCanbus.DATA[38];
                int d1_b69 = DataCanbus.DATA[39];
                int d1_b59 = DataCanbus.DATA[40];
                int d1_b49 = DataCanbus.DATA[41];
                int d1_b39 = DataCanbus.DATA[42];
                int d1_b29 = DataCanbus.DATA[43];
                int d1_b19 = DataCanbus.DATA[44];
                int d1_b09 = DataCanbus.DATA[45];
                int d2_b09 = DataCanbus.DATA[46];
                int d3_b709 = DataCanbus.DATA[47];
                int d4_b709 = DataCanbus.DATA[48];
                int d5_b709 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b79 = DataCanbus.DATA[72];
                    d0_b69 = DataCanbus.DATA[73];
                    d0_b309 = DataCanbus.DATA[74];
                    d1_b79 = DataCanbus.DATA[75];
                    d1_b69 = DataCanbus.DATA[76];
                    d1_b59 = DataCanbus.DATA[77];
                    d1_b49 = DataCanbus.DATA[78];
                    d1_b39 = DataCanbus.DATA[79];
                    d1_b29 = DataCanbus.DATA[80];
                    d1_b19 = DataCanbus.DATA[81];
                    d1_b09 = DataCanbus.DATA[82];
                    d2_b09 = DataCanbus.DATA[83];
                    d3_b709 = DataCanbus.DATA[84];
                    d4_b709 = DataCanbus.DATA[85];
                    d5_b709 = DataCanbus.DATA[86];
                }
                if (d0_b79 == 1) {
                    d0_b79 = 0;
                } else if (d0_b79 == 0) {
                    d0_b79 = 1;
                }
                setCarInfo((d0_b309 & 15) | ((d0_b79 << 7) & 128) | ((d0_b69 << 6) & 64), (d1_b09 & 1) | ((d1_b79 << 7) & 128) | ((d1_b69 << 6) & 64) | ((d1_b59 << 5) & 32) | ((d1_b49 << 4) & 16) | ((d1_b39 << 3) & 8) | ((d1_b29 << 2) & 4) | ((d1_b19 << 1) & 2), d2_b09 & 1, d3_b709, d4_b709, d5_b709);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int d0_b710 = DataCanbus.DATA[35];
                int d0_b610 = DataCanbus.DATA[36];
                int d0_b3010 = DataCanbus.DATA[37];
                int d1_b710 = DataCanbus.DATA[38];
                int d1_b610 = DataCanbus.DATA[39];
                int d1_b510 = DataCanbus.DATA[40];
                int d1_b410 = DataCanbus.DATA[41];
                int d1_b310 = DataCanbus.DATA[42];
                int d1_b210 = DataCanbus.DATA[43];
                int d1_b110 = DataCanbus.DATA[44];
                int d1_b010 = DataCanbus.DATA[45];
                int d2_b010 = DataCanbus.DATA[46];
                int d3_b7010 = DataCanbus.DATA[47];
                int d4_b7010 = DataCanbus.DATA[48];
                int d5_b7010 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b710 = DataCanbus.DATA[72];
                    d0_b610 = DataCanbus.DATA[73];
                    d0_b3010 = DataCanbus.DATA[74];
                    d1_b710 = DataCanbus.DATA[75];
                    d1_b610 = DataCanbus.DATA[76];
                    d1_b510 = DataCanbus.DATA[77];
                    d1_b410 = DataCanbus.DATA[78];
                    d1_b310 = DataCanbus.DATA[79];
                    d1_b210 = DataCanbus.DATA[80];
                    d1_b110 = DataCanbus.DATA[81];
                    d1_b010 = DataCanbus.DATA[82];
                    d2_b010 = DataCanbus.DATA[83];
                    d3_b7010 = DataCanbus.DATA[84];
                    d4_b7010 = DataCanbus.DATA[85];
                    d5_b7010 = DataCanbus.DATA[86];
                }
                if (d0_b610 == 1) {
                    d0_b610 = 0;
                } else if (d0_b610 == 0) {
                    d0_b610 = 1;
                }
                setCarInfo((d0_b3010 & 15) | ((d0_b710 << 7) & 128) | ((d0_b610 << 6) & 64), (d1_b010 & 1) | ((d1_b710 << 7) & 128) | ((d1_b610 << 6) & 64) | ((d1_b510 << 5) & 32) | ((d1_b410 << 4) & 16) | ((d1_b310 << 3) & 8) | ((d1_b210 << 2) & 4) | ((d1_b110 << 1) & 2), d2_b010 & 1, d3_b7010, d4_b7010, d5_b7010);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int d0_b711 = DataCanbus.DATA[35];
                int d0_b611 = DataCanbus.DATA[36];
                int d0_b3011 = DataCanbus.DATA[37];
                int d1_b711 = DataCanbus.DATA[38];
                int d1_b611 = DataCanbus.DATA[39];
                int d1_b511 = DataCanbus.DATA[40];
                int d1_b411 = DataCanbus.DATA[41];
                int d1_b311 = DataCanbus.DATA[42];
                int d1_b211 = DataCanbus.DATA[43];
                int d1_b111 = DataCanbus.DATA[44];
                int d1_b011 = DataCanbus.DATA[45];
                int d2_b011 = DataCanbus.DATA[46];
                int d3_b7011 = DataCanbus.DATA[47];
                int d4_b7011 = DataCanbus.DATA[48];
                int d5_b7011 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b711 = DataCanbus.DATA[72];
                    d0_b611 = DataCanbus.DATA[73];
                    d0_b3011 = DataCanbus.DATA[74];
                    d1_b711 = DataCanbus.DATA[75];
                    d1_b611 = DataCanbus.DATA[76];
                    d1_b511 = DataCanbus.DATA[77];
                    d1_b411 = DataCanbus.DATA[78];
                    d1_b311 = DataCanbus.DATA[79];
                    d1_b211 = DataCanbus.DATA[80];
                    d1_b111 = DataCanbus.DATA[81];
                    d1_b011 = DataCanbus.DATA[82];
                    d2_b011 = DataCanbus.DATA[83];
                    d3_b7011 = DataCanbus.DATA[84];
                    d4_b7011 = DataCanbus.DATA[85];
                    d5_b7011 = DataCanbus.DATA[86];
                }
                if (d1_b711 == 1) {
                    d1_b711 = 0;
                } else if (d1_b711 == 0) {
                    d1_b711 = 1;
                }
                setCarInfo((d0_b3011 & 15) | ((d0_b711 << 7) & 128) | ((d0_b611 << 6) & 64), (d1_b011 & 1) | ((d1_b711 << 7) & 128) | ((d1_b611 << 6) & 64) | ((d1_b511 << 5) & 32) | ((d1_b411 << 4) & 16) | ((d1_b311 << 3) & 8) | ((d1_b211 << 2) & 4) | ((d1_b111 << 1) & 2), d2_b011 & 1, d3_b7011, d4_b7011, d5_b7011);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int d0_b712 = DataCanbus.DATA[35];
                int d0_b612 = DataCanbus.DATA[36];
                int d0_b3012 = DataCanbus.DATA[37];
                int d1_b712 = DataCanbus.DATA[38];
                int d1_b612 = DataCanbus.DATA[39];
                int d1_b512 = DataCanbus.DATA[40];
                int d1_b412 = DataCanbus.DATA[41];
                int d1_b312 = DataCanbus.DATA[42];
                int d1_b212 = DataCanbus.DATA[43];
                int d1_b112 = DataCanbus.DATA[44];
                int d1_b012 = DataCanbus.DATA[45];
                int d2_b012 = DataCanbus.DATA[46];
                int d3_b7012 = DataCanbus.DATA[47];
                int d4_b7012 = DataCanbus.DATA[48];
                int d5_b7012 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b712 = DataCanbus.DATA[72];
                    d0_b612 = DataCanbus.DATA[73];
                    d0_b3012 = DataCanbus.DATA[74];
                    d1_b712 = DataCanbus.DATA[75];
                    d1_b612 = DataCanbus.DATA[76];
                    d1_b512 = DataCanbus.DATA[77];
                    d1_b412 = DataCanbus.DATA[78];
                    d1_b312 = DataCanbus.DATA[79];
                    d1_b212 = DataCanbus.DATA[80];
                    d1_b112 = DataCanbus.DATA[81];
                    d1_b012 = DataCanbus.DATA[82];
                    d2_b012 = DataCanbus.DATA[83];
                    d3_b7012 = DataCanbus.DATA[84];
                    d4_b7012 = DataCanbus.DATA[85];
                    d5_b7012 = DataCanbus.DATA[86];
                }
                if (d1_b612 == 1) {
                    d1_b612 = 0;
                } else if (d1_b612 == 0) {
                    d1_b612 = 1;
                }
                setCarInfo((d0_b3012 & 15) | ((d0_b712 << 7) & 128) | ((d0_b612 << 6) & 64), (d1_b012 & 1) | ((d1_b712 << 7) & 128) | ((d1_b612 << 6) & 64) | ((d1_b512 << 5) & 32) | ((d1_b412 << 4) & 16) | ((d1_b312 << 3) & 8) | ((d1_b212 << 2) & 4) | ((d1_b112 << 1) & 2), d2_b012 & 1, d3_b7012, d4_b7012, d5_b7012);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int d0_b713 = DataCanbus.DATA[35];
                int d0_b613 = DataCanbus.DATA[36];
                int d0_b3013 = DataCanbus.DATA[37];
                int d1_b713 = DataCanbus.DATA[38];
                int d1_b613 = DataCanbus.DATA[39];
                int d1_b513 = DataCanbus.DATA[40];
                int d1_b413 = DataCanbus.DATA[41];
                int d1_b313 = DataCanbus.DATA[42];
                int d1_b213 = DataCanbus.DATA[43];
                int d1_b113 = DataCanbus.DATA[44];
                int d1_b013 = DataCanbus.DATA[45];
                int d2_b013 = DataCanbus.DATA[46];
                int d3_b7013 = DataCanbus.DATA[47];
                int d4_b7013 = DataCanbus.DATA[48];
                int d5_b7013 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b713 = DataCanbus.DATA[72];
                    d0_b613 = DataCanbus.DATA[73];
                    d0_b3013 = DataCanbus.DATA[74];
                    d1_b713 = DataCanbus.DATA[75];
                    d1_b613 = DataCanbus.DATA[76];
                    d1_b513 = DataCanbus.DATA[77];
                    d1_b413 = DataCanbus.DATA[78];
                    d1_b313 = DataCanbus.DATA[79];
                    d1_b213 = DataCanbus.DATA[80];
                    d1_b113 = DataCanbus.DATA[81];
                    d1_b013 = DataCanbus.DATA[82];
                    d2_b013 = DataCanbus.DATA[83];
                    d3_b7013 = DataCanbus.DATA[84];
                    d4_b7013 = DataCanbus.DATA[85];
                    d5_b7013 = DataCanbus.DATA[86];
                }
                if (d1_b513 == 1) {
                    d1_b513 = 0;
                } else if (d1_b513 == 0) {
                    d1_b513 = 1;
                }
                setCarInfo((d0_b3013 & 15) | ((d0_b713 << 7) & 128) | ((d0_b613 << 6) & 64), (d1_b013 & 1) | ((d1_b713 << 7) & 128) | ((d1_b613 << 6) & 64) | ((d1_b513 << 5) & 32) | ((d1_b413 << 4) & 16) | ((d1_b313 << 3) & 8) | ((d1_b213 << 2) & 4) | ((d1_b113 << 1) & 2), d2_b013 & 1, d3_b7013, d4_b7013, d5_b7013);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int d0_b714 = DataCanbus.DATA[35];
                int d0_b614 = DataCanbus.DATA[36];
                int d0_b3014 = DataCanbus.DATA[37];
                int d1_b714 = DataCanbus.DATA[38];
                int d1_b614 = DataCanbus.DATA[39];
                int d1_b514 = DataCanbus.DATA[40];
                int d1_b414 = DataCanbus.DATA[41];
                int d1_b314 = DataCanbus.DATA[42];
                int d1_b214 = DataCanbus.DATA[43];
                int d1_b114 = DataCanbus.DATA[44];
                int d1_b014 = DataCanbus.DATA[45];
                int d2_b014 = DataCanbus.DATA[46];
                int d3_b7014 = DataCanbus.DATA[47];
                int d4_b7014 = DataCanbus.DATA[48];
                int d5_b7014 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b714 = DataCanbus.DATA[72];
                    d0_b614 = DataCanbus.DATA[73];
                    d0_b3014 = DataCanbus.DATA[74];
                    d1_b714 = DataCanbus.DATA[75];
                    d1_b614 = DataCanbus.DATA[76];
                    d1_b514 = DataCanbus.DATA[77];
                    d1_b414 = DataCanbus.DATA[78];
                    d1_b314 = DataCanbus.DATA[79];
                    d1_b214 = DataCanbus.DATA[80];
                    d1_b114 = DataCanbus.DATA[81];
                    d1_b014 = DataCanbus.DATA[82];
                    d2_b014 = DataCanbus.DATA[83];
                    d3_b7014 = DataCanbus.DATA[84];
                    d4_b7014 = DataCanbus.DATA[85];
                    d5_b7014 = DataCanbus.DATA[86];
                }
                if (d1_b414 == 1) {
                    d1_b414 = 0;
                } else if (d1_b414 == 0) {
                    d1_b414 = 1;
                }
                setCarInfo((d0_b3014 & 15) | ((d0_b714 << 7) & 128) | ((d0_b614 << 6) & 64), (d1_b014 & 1) | ((d1_b714 << 7) & 128) | ((d1_b614 << 6) & 64) | ((d1_b514 << 5) & 32) | ((d1_b414 << 4) & 16) | ((d1_b314 << 3) & 8) | ((d1_b214 << 2) & 4) | ((d1_b114 << 1) & 2), d2_b014 & 1, d3_b7014, d4_b7014, d5_b7014);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int d0_b715 = DataCanbus.DATA[35];
                int d0_b615 = DataCanbus.DATA[36];
                int d0_b3015 = DataCanbus.DATA[37];
                int d1_b715 = DataCanbus.DATA[38];
                int d1_b615 = DataCanbus.DATA[39];
                int d1_b515 = DataCanbus.DATA[40];
                int d1_b415 = DataCanbus.DATA[41];
                int d1_b315 = DataCanbus.DATA[42];
                int d1_b215 = DataCanbus.DATA[43];
                int d1_b115 = DataCanbus.DATA[44];
                int d1_b015 = DataCanbus.DATA[45];
                int d2_b015 = DataCanbus.DATA[46];
                int d3_b7015 = DataCanbus.DATA[47];
                int d4_b7015 = DataCanbus.DATA[48];
                int d5_b7015 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b715 = DataCanbus.DATA[72];
                    d0_b615 = DataCanbus.DATA[73];
                    d0_b3015 = DataCanbus.DATA[74];
                    d1_b715 = DataCanbus.DATA[75];
                    d1_b615 = DataCanbus.DATA[76];
                    d1_b515 = DataCanbus.DATA[77];
                    d1_b415 = DataCanbus.DATA[78];
                    d1_b315 = DataCanbus.DATA[79];
                    d1_b215 = DataCanbus.DATA[80];
                    d1_b115 = DataCanbus.DATA[81];
                    d1_b015 = DataCanbus.DATA[82];
                    d2_b015 = DataCanbus.DATA[83];
                    d3_b7015 = DataCanbus.DATA[84];
                    d4_b7015 = DataCanbus.DATA[85];
                    d5_b7015 = DataCanbus.DATA[86];
                }
                if (d1_b315 == 1) {
                    d1_b315 = 0;
                } else if (d1_b315 == 0) {
                    d1_b315 = 1;
                }
                setCarInfo((d0_b3015 & 15) | ((d0_b715 << 7) & 128) | ((d0_b615 << 6) & 64), (d1_b015 & 1) | ((d1_b715 << 7) & 128) | ((d1_b615 << 6) & 64) | ((d1_b515 << 5) & 32) | ((d1_b415 << 4) & 16) | ((d1_b315 << 3) & 8) | ((d1_b215 << 2) & 4) | ((d1_b115 << 1) & 2), d2_b015 & 1, d3_b7015, d4_b7015, d5_b7015);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int d0_b716 = DataCanbus.DATA[35];
                int d0_b616 = DataCanbus.DATA[36];
                int d0_b3016 = DataCanbus.DATA[37];
                int d1_b716 = DataCanbus.DATA[38];
                int d1_b616 = DataCanbus.DATA[39];
                int d1_b516 = DataCanbus.DATA[40];
                int d1_b416 = DataCanbus.DATA[41];
                int d1_b316 = DataCanbus.DATA[42];
                int d1_b216 = DataCanbus.DATA[43];
                int d1_b116 = DataCanbus.DATA[44];
                int d1_b016 = DataCanbus.DATA[45];
                int d2_b016 = DataCanbus.DATA[46];
                int d3_b7016 = DataCanbus.DATA[47];
                int d4_b7016 = DataCanbus.DATA[48];
                int d5_b7016 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b716 = DataCanbus.DATA[72];
                    d0_b616 = DataCanbus.DATA[73];
                    d0_b3016 = DataCanbus.DATA[74];
                    d1_b716 = DataCanbus.DATA[75];
                    d1_b616 = DataCanbus.DATA[76];
                    d1_b516 = DataCanbus.DATA[77];
                    d1_b416 = DataCanbus.DATA[78];
                    d1_b316 = DataCanbus.DATA[79];
                    d1_b216 = DataCanbus.DATA[80];
                    d1_b116 = DataCanbus.DATA[81];
                    d1_b016 = DataCanbus.DATA[82];
                    d2_b016 = DataCanbus.DATA[83];
                    d3_b7016 = DataCanbus.DATA[84];
                    d4_b7016 = DataCanbus.DATA[85];
                    d5_b7016 = DataCanbus.DATA[86];
                }
                if (d1_b216 == 1) {
                    d1_b216 = 0;
                } else if (d1_b216 == 0) {
                    d1_b216 = 1;
                }
                setCarInfo((d0_b3016 & 15) | ((d0_b716 << 7) & 128) | ((d0_b616 << 6) & 64), (d1_b016 & 1) | ((d1_b716 << 7) & 128) | ((d1_b616 << 6) & 64) | ((d1_b516 << 5) & 32) | ((d1_b416 << 4) & 16) | ((d1_b316 << 3) & 8) | ((d1_b216 << 2) & 4) | ((d1_b116 << 1) & 2), d2_b016 & 1, d3_b7016, d4_b7016, d5_b7016);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int d0_b717 = DataCanbus.DATA[35];
                int d0_b617 = DataCanbus.DATA[36];
                int d0_b3017 = DataCanbus.DATA[37];
                int d1_b717 = DataCanbus.DATA[38];
                int d1_b617 = DataCanbus.DATA[39];
                int d1_b517 = DataCanbus.DATA[40];
                int d1_b417 = DataCanbus.DATA[41];
                int d1_b317 = DataCanbus.DATA[42];
                int d1_b217 = DataCanbus.DATA[43];
                int d1_b117 = DataCanbus.DATA[44];
                int d1_b017 = DataCanbus.DATA[45];
                int d2_b017 = DataCanbus.DATA[46];
                int d3_b7017 = DataCanbus.DATA[47];
                int d4_b7017 = DataCanbus.DATA[48];
                int d5_b7017 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b717 = DataCanbus.DATA[72];
                    d0_b617 = DataCanbus.DATA[73];
                    d0_b3017 = DataCanbus.DATA[74];
                    d1_b717 = DataCanbus.DATA[75];
                    d1_b617 = DataCanbus.DATA[76];
                    d1_b517 = DataCanbus.DATA[77];
                    d1_b417 = DataCanbus.DATA[78];
                    d1_b317 = DataCanbus.DATA[79];
                    d1_b217 = DataCanbus.DATA[80];
                    d1_b117 = DataCanbus.DATA[81];
                    d1_b017 = DataCanbus.DATA[82];
                    d2_b017 = DataCanbus.DATA[83];
                    d3_b7017 = DataCanbus.DATA[84];
                    d4_b7017 = DataCanbus.DATA[85];
                    d5_b7017 = DataCanbus.DATA[86];
                }
                if (d1_b117 == 1) {
                    d1_b117 = 0;
                } else if (d1_b117 == 0) {
                    d1_b117 = 1;
                }
                setCarInfo((d0_b3017 & 15) | ((d0_b717 << 7) & 128) | ((d0_b617 << 6) & 64), (d1_b017 & 1) | ((d1_b717 << 7) & 128) | ((d1_b617 << 6) & 64) | ((d1_b517 << 5) & 32) | ((d1_b417 << 4) & 16) | ((d1_b317 << 3) & 8) | ((d1_b217 << 2) & 4) | ((d1_b117 << 1) & 2), d2_b017 & 1, d3_b7017, d4_b7017, d5_b7017);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int d0_b718 = DataCanbus.DATA[35];
                int d0_b618 = DataCanbus.DATA[36];
                int d0_b3018 = DataCanbus.DATA[37];
                int d1_b718 = DataCanbus.DATA[38];
                int d1_b618 = DataCanbus.DATA[39];
                int d1_b518 = DataCanbus.DATA[40];
                int d1_b418 = DataCanbus.DATA[41];
                int d1_b318 = DataCanbus.DATA[42];
                int d1_b218 = DataCanbus.DATA[43];
                int d1_b118 = DataCanbus.DATA[44];
                int d1_b018 = DataCanbus.DATA[45];
                int d2_b018 = DataCanbus.DATA[46];
                int d3_b7018 = DataCanbus.DATA[47];
                int d4_b7018 = DataCanbus.DATA[48];
                int d5_b7018 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b718 = DataCanbus.DATA[72];
                    d0_b618 = DataCanbus.DATA[73];
                    d0_b3018 = DataCanbus.DATA[74];
                    d1_b718 = DataCanbus.DATA[75];
                    d1_b618 = DataCanbus.DATA[76];
                    d1_b518 = DataCanbus.DATA[77];
                    d1_b418 = DataCanbus.DATA[78];
                    d1_b318 = DataCanbus.DATA[79];
                    d1_b218 = DataCanbus.DATA[80];
                    d1_b118 = DataCanbus.DATA[81];
                    d1_b018 = DataCanbus.DATA[82];
                    d2_b018 = DataCanbus.DATA[83];
                    d3_b7018 = DataCanbus.DATA[84];
                    d4_b7018 = DataCanbus.DATA[85];
                    d5_b7018 = DataCanbus.DATA[86];
                }
                if (d1_b018 == 1) {
                    d1_b018 = 0;
                } else if (d1_b018 == 0) {
                    d1_b018 = 1;
                }
                setCarInfo((d0_b3018 & 15) | ((d0_b718 << 7) & 128) | ((d0_b618 << 6) & 64), (d1_b018 & 1) | ((d1_b718 << 7) & 128) | ((d1_b618 << 6) & 64) | ((d1_b518 << 5) & 32) | ((d1_b418 << 4) & 16) | ((d1_b318 << 3) & 8) | ((d1_b218 << 2) & 4) | ((d1_b118 << 1) & 2), d2_b018 & 1, d3_b7018, d4_b7018, d5_b7018);
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                int d0_b719 = DataCanbus.DATA[35];
                int d0_b619 = DataCanbus.DATA[36];
                int d0_b3019 = DataCanbus.DATA[37];
                int d1_b719 = DataCanbus.DATA[38];
                int d1_b619 = DataCanbus.DATA[39];
                int d1_b519 = DataCanbus.DATA[40];
                int d1_b419 = DataCanbus.DATA[41];
                int d1_b319 = DataCanbus.DATA[42];
                int d1_b219 = DataCanbus.DATA[43];
                int d1_b119 = DataCanbus.DATA[44];
                int d1_b019 = DataCanbus.DATA[45];
                int d2_b019 = DataCanbus.DATA[46];
                int d3_b7019 = DataCanbus.DATA[47];
                int d4_b7019 = DataCanbus.DATA[48];
                int d5_b7019 = DataCanbus.DATA[49];
                if (DataCanbus.DATA[1000] == 1507781) {
                    d0_b719 = DataCanbus.DATA[72];
                    d0_b619 = DataCanbus.DATA[73];
                    d0_b3019 = DataCanbus.DATA[74];
                    d1_b719 = DataCanbus.DATA[75];
                    d1_b619 = DataCanbus.DATA[76];
                    d1_b519 = DataCanbus.DATA[77];
                    d1_b419 = DataCanbus.DATA[78];
                    d1_b319 = DataCanbus.DATA[79];
                    d1_b219 = DataCanbus.DATA[80];
                    d1_b119 = DataCanbus.DATA[81];
                    d1_b019 = DataCanbus.DATA[82];
                    d2_b019 = DataCanbus.DATA[83];
                    d3_b7019 = DataCanbus.DATA[84];
                    d4_b7019 = DataCanbus.DATA[85];
                    d5_b7019 = DataCanbus.DATA[86];
                }
                if (d2_b019 == 1) {
                    d2_b019 = 0;
                } else if (d2_b019 == 0) {
                    d2_b019 = 1;
                }
                setCarInfo((d0_b3019 & 15) | ((d0_b719 << 7) & 128) | ((d0_b619 << 6) & 64), (d1_b019 & 1) | ((d1_b719 << 7) & 128) | ((d1_b619 << 6) & 64) | ((d1_b519 << 5) & 32) | ((d1_b419 << 4) & 16) | ((d1_b319 << 3) & 8) | ((d1_b219 << 2) & 4) | ((d1_b119 << 1) & 2), d2_b019 & 1, d3_b7019, d4_b7019, d5_b7019);
                break;
        }
    }

    public void setCarInfo(int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2, value3, value4, value5, value6}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{25}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        if (DataCanbus.DATA[1000] == 1507781) {
            DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 1507781) {
            DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
    }
}
