package com.syu.carinfo.camry.luz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class ToyotaLexusEQActi_Luz extends BaseActivity implements View.OnClickListener {
    private SeekBar.OnSeekBarChangeListener mseekbarClick = new SeekBar.OnSeekBarChangeListener() { // from class: com.syu.carinfo.camry.luz.ToyotaLexusEQActi_Luz.1
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar v) {
            switch (v.getId()) {
                case R.id.bnr_crow_amp_carvol_seekview /* 2131428125 */:
                    ToyotaLexusEQActi_Luz.this.setCarInfo(7, v.getProgress());
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
            switch (arg0.getId()) {
                case R.id.bnr_crow_amp_carvol_seekview /* 2131428125 */:
                    ToyotaLexusEQActi_Luz.this.setCarInfo(7, arg0.getProgress());
                    break;
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar arg0) {
        }
    };
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry.luz.ToyotaLexusEQActi_Luz.2
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 124:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text1)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text1)).setText("F" + (7 - value));
                        } else {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 125:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text2)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text2)).setText("L" + (7 - value));
                        } else {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 126:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text3)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text3)).setText("-" + (7 - value));
                        } else {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 127:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text5)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text5)).setText("-" + (7 - value));
                        } else {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 128:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text4)).setText("+" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text4)).setText("-" + (7 - value));
                        } else {
                            ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 129:
                    ToyotaLexusEQActi_Luz.this.setCheck((CheckedTextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.ctv_checkedtext1), value == 8);
                    break;
                case 130:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 131:
                    ToyotaLexusEQActi_Luz.this.setCheck((CheckedTextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 132:
                    if (((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.bnr_crow_amp_carvol_text)) != null) {
                        ((TextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.bnr_crow_amp_carvol_text)).setText(new StringBuilder(String.valueOf(value)).toString());
                    }
                    if (((SeekBar) ToyotaLexusEQActi_Luz.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)) != null) {
                        ((SeekBar) ToyotaLexusEQActi_Luz.this.findViewById(R.id.bnr_crow_amp_carvol_seekview)).setProgress(value);
                    }
                    break;
                case 144:
                    ToyotaLexusEQActi_Luz.this.setCheck((CheckedTextView) ToyotaLexusEQActi_Luz.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_toyota_lexus_eq_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
        seekbaronClick((SeekBar) findViewById(R.id.bnr_crow_amp_carvol_seekview));
    }

    private void seekbaronClick(SeekBar v) {
        if (v != null) {
            v.setOnSeekBarChangeListener(this.mseekbarClick);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value2 = DataCanbus.DATA[124];
                if (value2 > 0) {
                    value2--;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value3 = DataCanbus.DATA[124];
                if (value3 < 14) {
                    value3++;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value4 = DataCanbus.DATA[125];
                if (value4 > 0) {
                    value4--;
                }
                setCarInfo(2, value4);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value5 = DataCanbus.DATA[125];
                if (value5 < 14) {
                    value5++;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value6 = DataCanbus.DATA[126];
                if (value6 > 2) {
                    value6--;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value7 = DataCanbus.DATA[126];
                if (value7 < 12) {
                    value7++;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value8 = DataCanbus.DATA[128];
                if (value8 > 2) {
                    value8--;
                }
                setCarInfo(6, value8);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value9 = DataCanbus.DATA[128];
                if (value9 < 12) {
                    value9++;
                }
                setCarInfo(6, value9);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value10 = DataCanbus.DATA[127];
                if (value10 > 2) {
                    value10--;
                }
                setCarInfo(5, value10);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value11 = DataCanbus.DATA[127];
                if (value11 < 12) {
                    value11++;
                }
                setCarInfo(5, value11);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(10, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(10, 1);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[132];
                if (value12 > 0) {
                    value12--;
                }
                setCarInfo(7, value12);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[132];
                if (value13 < 127) {
                    value13++;
                }
                setCarInfo(7, value13);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                if (DataCanbus.DATA[129] == 8) {
                    value = 1;
                } else {
                    value = 8;
                }
                setCarInfo(3, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value14 = DataCanbus.DATA[131];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(9, value14);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                setCarInfo(96, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value15 = DataCanbus.DATA[144];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(97, value15);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(44, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(43, new int[]{49, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
    }
}
