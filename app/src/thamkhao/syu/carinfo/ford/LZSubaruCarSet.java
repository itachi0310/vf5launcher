package com.syu.carinfo.ford;

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

/* JADX INFO: loaded from: classes.dex */
public class LZSubaruCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.LZSubaruCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text1)).setText("R" + (value - 9));
                        } else if (value < 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text1)).setText("F" + (9 - value));
                        } else if (value == 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 95:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (value - 9));
                        } else if (value < 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (9 - value));
                        } else if (value == 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 96:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 9));
                        } else if (value < 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (9 - value));
                        } else if (value == 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 97:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text5)).setText("+" + (value - 9));
                        } else if (value < 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (9 - value));
                        } else if (value == 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 98:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text4)).setText("+" + (value - 9));
                        } else if (value < 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (9 - value));
                        } else if (value == 9) {
                            ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 99:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 107:
                    LZSubaruCarSet.this.setCheck((CheckedTextView) LZSubaruCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 108:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)).setText("20S");
                                break;
                            case 1:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)).setText("30S");
                                break;
                            case 2:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)).setText("40S");
                                break;
                            case 3:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)).setText("50S");
                                break;
                            case 4:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text7)).setText("60S");
                                break;
                        }
                    }
                    break;
                case 109:
                    LZSubaruCarSet.this.setCheck((CheckedTextView) LZSubaruCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 110:
                    LZSubaruCarSet.this.setCheck((CheckedTextView) LZSubaruCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 111:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text8)).setText("0S");
                                break;
                            case 1:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text8)).setText("short");
                                break;
                            case 2:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text8)).setText("normal");
                                break;
                            case 3:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text8)).setText("long");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text9)).setText("15min on");
                                break;
                            case 1:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text9)).setText("cont on");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text10)).setText("15min on");
                                break;
                            case 1:
                                ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text10)).setText("cont on");
                                break;
                        }
                    }
                    break;
                case 135:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 136:
                    if (((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) LZSubaruCarSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_subaru_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(1, 0);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
            case R.id.btn_plus9 /* 2131427481 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
            case R.id.btn_plus10 /* 2131427484 */:
                setCarInfo(7, 0);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value = DataCanbus.DATA[135];
                setCarTemp(3, value - 1);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value2 = DataCanbus.DATA[135];
                setCarTemp(3, value2 + 1);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value3 = DataCanbus.DATA[136];
                setCarTemp(4, value3 - 1);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value4 = DataCanbus.DATA[136];
                setCarTemp(4, value4 + 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                setCarInfo(0, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                setCarInfo(2, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                setCarInfo(4, 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                dialog(R.string.all_settings, 3);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                dialog(R.string.all_settings, 8);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    public void setCarTemp(int value1, int value2) {
        DataCanbus.PROXY.cmd(3, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{49}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{56}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.LZSubaruCarSet.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.ford.LZSubaruCarSet.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LZSubaruCarSet.this.setCarInfo(i, 0);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.ford.LZSubaruCarSet.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
