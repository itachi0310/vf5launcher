package com.syu.carinfo.psa_all;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class PSA4008CarSetActi extends BaseActivity implements View.OnClickListener {
    private int[] eventIds = {173, 174, 175, 176, 177, 178, 179, 180, 192, 181, 182, 183, 184, 185, 186, 187, 188, 189, 193, 194, 195, 204, 205, 206, 207, 208, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int i, int[] iArr, float[] fArr, String[] strArr) {
            switch (i) {
                case 173:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view1).setVisibility(DataCanbus.DATA[i] == 1 ? 0 : 8);
                    break;
                case 174:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view2).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 175:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view3).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 177:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view5).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 178:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view6).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 179:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view7).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 180:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view8).setVisibility(DataCanbus.DATA[i] == 1 ? 0 : 8);
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view9).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 181:
                    PSA4008CarSetActi.this.updateIncense2(i);
                    break;
                case 182:
                    PSA4008CarSetActi.this.updateLane(i);
                    break;
                case 183:
                    PSA4008CarSetActi.this.updateFatigue(i);
                    break;
                case 184:
                    PSA4008CarSetActi.this.updateSpeed(i);
                    break;
                case 185:
                case 206:
                    PSA4008CarSetActi.this.updateTheme(i);
                    break;
                case 186:
                    PSA4008CarSetActi.this.updateAmbient(i);
                    break;
                case 187:
                    PSA4008CarSetActi.this.updateDriver(i);
                    break;
                case 188:
                    PSA4008CarSetActi.this.updateIon(i);
                    break;
                case 189:
                    PSA4008CarSetActi.this.updateIncense(i);
                    break;
                case 192:
                    PSA4008CarSetActi.this.findViewById(R.id.layout_view11).setVisibility(DataCanbus.DATA[i] != 1 ? 8 : 0);
                    break;
                case 193:
                    PSA4008CarSetActi.this.updatePanelbright(i);
                    break;
                case 194:
                    PSA4008CarSetActi.this.updatePanelleft(i);
                    break;
                case 195:
                    PSA4008CarSetActi.this.updatePanelright(i);
                    break;
                case 204:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext10)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 205:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext11)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 207:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext12)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 208:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext13)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 240:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext14)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 241:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext15)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 242:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext16)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 243:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(DataCanbus.DATA[i]).toString());
                    }
                    break;
                case 244:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(DataCanbus.DATA[i]).toString());
                    }
                    break;
                case 245:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text11)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 246:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text13)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 247:
                    if (((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)) != null) {
                        switch (DataCanbus.DATA[i]) {
                            case 0:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                            case 2:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text14)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                        }
                    }
                    break;
                case 248:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext17)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 249:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext18)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
                case 250:
                    switch (DataCanbus.DATA[i]) {
                        case 0:
                            ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text15)).setText("14-28");
                            break;
                        case 1:
                            ((TextView) PSA4008CarSetActi.this.findViewById(R.id.tv_text15)).setText("16-30");
                            break;
                    }
                    break;
                case 251:
                    ((CheckedTextView) PSA4008CarSetActi.this.findViewById(R.id.ctv_checkedtext19)).setChecked(DataCanbus.DATA[i] != 0);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_psa_all_4008_carset);
        registerListener();
    }

    public void registerListener() {
        findViewById(R.id.ctv_checkedtext1).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext2).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext3).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext4).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext5).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext6).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext7).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext8).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext9).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext10).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext11).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext12).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext13).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext14).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext15).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext16).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext17).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext18).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext19).setOnClickListener(this);
        findViewById(R.id.ctv_checkedtext20).setOnClickListener(this);
        findViewById(R.id.layout_view10).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus9)).setOnClickListener(this);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        for (int i = 0; i < this.eventIds.length; i++) {
            DataCanbus.NOTIFY_EVENTS[this.eventIds[i]].removeNotify(this.mNotifyCanbus);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        int value5;
        int value6;
        int value7;
        int value8;
        int value9;
        int value10;
        int value11;
        int value12;
        int value13;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value14 = DataCanbus.DATA[193];
                DataCanbus.PROXY.cmd(101, new int[]{16, value14 > 0 ? value14 - 1 : 15}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value15 = DataCanbus.DATA[193];
                if (value15 < 15) {
                    value3 = value15 + 1;
                } else {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{16, value3}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value16 = DataCanbus.DATA[194];
                DataCanbus.PROXY.cmd(101, new int[]{17, value16 > 0 ? value16 - 1 : 7}, null, null);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value17 = DataCanbus.DATA[194];
                if (value17 < 7) {
                    value2 = value17 + 1;
                } else {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{17, value2}, null, null);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value18 = DataCanbus.DATA[195];
                DataCanbus.PROXY.cmd(101, new int[]{18, value18 > 0 ? value18 - 1 : 7}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value19 = DataCanbus.DATA[195];
                if (value19 < 7) {
                    value = value19 + 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{18, value}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value20 = DataCanbus.DATA[243] - 1;
                if (value20 < 1) {
                    value20 = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value20}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value21 = DataCanbus.DATA[243] + 1;
                if (value21 > 5) {
                    value21 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{29, value21}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value22 = DataCanbus.DATA[245] - 1;
                if (value22 < 0) {
                    value22 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value22}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value23 = DataCanbus.DATA[245] + 1;
                if (value23 > 3) {
                    value23 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{31, value23}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value24 = DataCanbus.DATA[244] - 1;
                if (value24 < 1) {
                    value24 = 5;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value24}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value25 = DataCanbus.DATA[244] + 1;
                if (value25 > 5) {
                    value25 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{30, value25}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value26 = DataCanbus.DATA[246] - 1;
                if (value26 < 0) {
                    value26 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value26}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value27 = DataCanbus.DATA[246] + 1;
                if (value27 > 3) {
                    value27 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{32, value27}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value28 = DataCanbus.DATA[247] - 1;
                if (value28 < 0) {
                    value28 = 3;
                }
                DataCanbus.PROXY.cmd(101, new int[]{33, value28}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value29 = DataCanbus.DATA[247] + 1;
                if (value29 > 3) {
                    value29 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{33, value29}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value30 = DataCanbus.DATA[250] - 1;
                if (value30 < 0) {
                    value30 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{36, value30}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value31 = DataCanbus.DATA[250] + 1;
                if (value31 > 1) {
                    value31 = 0;
                }
                DataCanbus.PROXY.cmd(101, new int[]{36, value31}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value32 = DataCanbus.DATA[182];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 6;
                iArr[1] = value32 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(101, iArr, null, null);
                break;
            case R.id.layout_view10 /* 2131427541 */:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.str_wc_174008_str21).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{15, 1}, null, null);
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{15, 0}, null, null);
                    }
                });
                builder.show();
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value33 = DataCanbus.DATA[183];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 7;
                iArr2[1] = value33 == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(101, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value34 = DataCanbus.DATA[184];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 8;
                iArr3[1] = value34 == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(101, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value35 = DataCanbus.DATA[185];
                if (DataCanbus.DATA[1000] == 1114364) {
                    int value36 = DataCanbus.DATA[206] + 1;
                    if (value36 > 2) {
                        value36 = 0;
                    }
                    RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                    int[] iArr4 = new int[2];
                    iArr4[0] = 19;
                    iArr4[1] = value36 == 0 ? 1 : 0;
                    remoteModuleProxy4.cmd(101, iArr4, null, null);
                } else {
                    RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                    int[] iArr5 = new int[2];
                    iArr5[0] = 9;
                    iArr5[1] = value35 == 0 ? 1 : 0;
                    remoteModuleProxy5.cmd(101, iArr5, null, null);
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                DataCanbus.PROXY.cmd(101, new int[]{10, (DataCanbus.DATA[186] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value37 = DataCanbus.DATA[187];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 11;
                iArr6[1] = value37 == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(101, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                DataCanbus.PROXY.cmd(101, new int[]{12, (DataCanbus.DATA[188] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                DataCanbus.PROXY.cmd(101, new int[]{13, (DataCanbus.DATA[189] + 1) % 3}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                DataCanbus.PROXY.cmd(101, new int[]{14, (DataCanbus.DATA[181] + 1) % 4}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                if (DataCanbus.DATA[204] == 1) {
                    value13 = 0;
                } else {
                    value13 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{20, value13}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                if (DataCanbus.DATA[205] == 1) {
                    value12 = 0;
                } else {
                    value12 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{21, value12}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427559 */:
                if (DataCanbus.DATA[207] == 1) {
                    value11 = 0;
                } else {
                    value11 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{22, value11}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427560 */:
                if (DataCanbus.DATA[208] == 1) {
                    value10 = 0;
                } else {
                    value10 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{23, value10}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427561 */:
                if (DataCanbus.DATA[240] == 1) {
                    value9 = 0;
                } else {
                    value9 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{25, value9}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427562 */:
                if (DataCanbus.DATA[241] == 1) {
                    value8 = 0;
                } else {
                    value8 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{26, value8}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427563 */:
                if (DataCanbus.DATA[242] == 1) {
                    value7 = 0;
                } else {
                    value7 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{27, value7}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427564 */:
                if (DataCanbus.DATA[248] == 1) {
                    value6 = 0;
                } else {
                    value6 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{34, value6}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427663 */:
                if (DataCanbus.DATA[249] == 1) {
                    value5 = 0;
                } else {
                    value5 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{35, value5}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427665 */:
                if (DataCanbus.DATA[251] == 1) {
                    value4 = 0;
                } else {
                    value4 = 1;
                }
                DataCanbus.PROXY.cmd(101, new int[]{37, value4}, null, null);
                break;
            case R.id.ctv_checkedtext20 /* 2131427667 */:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle(R.string.str_vehicle_inspection).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{28, 1}, null, null);
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.psa_all.PSA4008CarSetActi.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DataCanbus.PROXY.cmd(101, new int[]{28, 0}, null, null);
                    }
                });
                builder2.show();
                break;
        }
    }

    void sendCmd(int cmd, int para) {
    }

    protected void updateIncense(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str18, R.string.str_wc_174008_str19, R.string.str_wc_174008_str20};
        if (((TextView) findViewById(R.id.tv_text8)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text8)).setText(strId[i]);
        }
    }

    protected void updateIon(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.off, R.string.str_wc_174008_str16, R.string.str_wc_174008_str17};
        if (((TextView) findViewById(R.id.tv_text7)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text7)).setText(strId[i]);
        }
    }

    protected void updateDriver(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.driver_system_standard, R.string.driver_system_sports};
        if (((TextView) findViewById(R.id.tv_text6)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text6)).setText(strId[i]);
        }
    }

    protected void updateAmbient(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str13, R.string.str_wc_174008_str14, R.string.str_wc_174008_str15};
        if (((TextView) findViewById(R.id.tv_text5)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text5)).setText(strId[i]);
        }
    }

    protected void updateTheme(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.str_wc_174008_str11, R.string.str_wc_174008_str12};
        if (DataCanbus.DATA[1000] == 1114364) {
            switch (i) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_classic_red);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.color_darkskyblue_str);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.str_wc_174008_str12);
                    break;
            }
            return;
        }
        if (((TextView) findViewById(R.id.tv_text4)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text4)).setText(strId[i]);
        }
    }

    protected void updateSpeed(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(i != 0);
        }
    }

    protected void updateFatigue(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(i != 0);
        }
    }

    protected void updateLane(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(i != 0);
        }
    }

    protected void updatePanelbright(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(i).toString());
        }
    }

    protected void updatePanelleft(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.crv_source_null, R.string.wc_4008_pannel_str1, R.string.wc_4008_pannel_str2, R.string.wc_4008_pannel_str3, R.string.wc_4008_pannel_str4, R.string.wc_4008_pannel_str5, R.string.wc_4008_pannel_str6, R.string.wc_4008_pannel_str7};
        if (((TextView) findViewById(R.id.tv_text2)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text2)).setText(strId[i]);
        }
    }

    protected void updatePanelright(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.crv_source_null, R.string.wc_4008_pannel_str1, R.string.wc_4008_pannel_str2, R.string.wc_4008_pannel_str3, R.string.wc_4008_pannel_str4, R.string.wc_4008_pannel_str5, R.string.wc_4008_pannel_str6, R.string.wc_4008_pannel_str7};
        if (((TextView) findViewById(R.id.tv_text3)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text3)).setText(strId[i]);
        }
    }

    protected void updateIncense2(int updateCode) {
        int i = DataCanbus.DATA[updateCode];
        int[] strId = {R.string.off, R.string.klc_air_low, R.string.klc_air_middle, R.string.klc_air_high};
        if (((TextView) findViewById(R.id.tv_text9)) != null && i < strId.length) {
            ((TextView) findViewById(R.id.tv_text9)).setText(strId[i]);
        }
    }
}
