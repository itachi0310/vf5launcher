package com.syu.carinfo.rzc.fengshen_ax7;

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
public class RzcFengshenYixuanSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("15s");
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("30s");
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("45s");
                                break;
                            case 3:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text2)).setText("60s");
                                break;
                        }
                    }
                    break;
                case 104:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 105:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 106:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 109:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext7), val == 1);
                    break;
                case 110:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext8), val == 1);
                    break;
                case 112:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext9), val == 1);
                    break;
                case 115:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext10), val == 1);
                    break;
                case 116:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext11), val == 1);
                    break;
                case 117:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext12), val == 1);
                    break;
                case 118:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext13), val == 1);
                    break;
                case 119:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext14), val == 1);
                    break;
                case 120:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext15), val == 1);
                    break;
                case 121:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext16), val == 1);
                    break;
                case 124:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 132:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 133:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 134:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 135:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 139:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext17), val == 1);
                    break;
                case 140:
                    if (((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_lanewar);
                                break;
                            case 1:
                                ((TextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.str_wc_174008_str1);
                                break;
                        }
                    }
                    break;
                case 141:
                    RzcFengshenYixuanSetFunc.this.setCheck((CheckedTextView) RzcFengshenYixuanSetFunc.this.findViewById(R.id.ctv_checkedtext18), val == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_fengshen_yixuan_setfunc);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
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
                int value = DataCanbus.DATA[132] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(31, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[132] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(31, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[103] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(1, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[103] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(1, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[124];
                if (value5 > 1) {
                    value5--;
                }
                setCarInfo(23, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[124];
                if (value6 < 6) {
                    value6++;
                }
                setCarInfo(23, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[140] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(40, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[140] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(40, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value9 = DataCanbus.DATA[133];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(32, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value10 = DataCanbus.DATA[134];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(33, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value11 = DataCanbus.DATA[135];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(34, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value12 = DataCanbus.DATA[104];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(2, value12);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value13 = DataCanbus.DATA[105];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(3, value13);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value14 = DataCanbus.DATA[106];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(4, value14);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value15 = DataCanbus.DATA[109];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(7, value15);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value16 = DataCanbus.DATA[110];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(8, value16);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int value17 = DataCanbus.DATA[112];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(11, value17);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int value18 = DataCanbus.DATA[115];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(16, value18);
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                int value19 = DataCanbus.DATA[116];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(17, value19);
                break;
            case R.id.ctv_checkedtext12 /* 2131427559 */:
                int value20 = DataCanbus.DATA[117];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(18, value20);
                break;
            case R.id.ctv_checkedtext13 /* 2131427560 */:
                int value21 = DataCanbus.DATA[118];
                if (value21 == 0) {
                    value21 = 1;
                } else if (value21 == 1) {
                    value21 = 0;
                }
                setCarInfo(19, value21);
                break;
            case R.id.ctv_checkedtext14 /* 2131427561 */:
                int value22 = DataCanbus.DATA[119];
                if (value22 == 0) {
                    value22 = 1;
                } else if (value22 == 1) {
                    value22 = 0;
                }
                setCarInfo(20, value22);
                break;
            case R.id.ctv_checkedtext15 /* 2131427562 */:
                int value23 = DataCanbus.DATA[120];
                if (value23 == 0) {
                    value23 = 1;
                } else if (value23 == 1) {
                    value23 = 0;
                }
                setCarInfo(21, value23);
                break;
            case R.id.ctv_checkedtext16 /* 2131427563 */:
                int value24 = DataCanbus.DATA[121];
                if (value24 == 0) {
                    value24 = 1;
                } else if (value24 == 1) {
                    value24 = 0;
                }
                setCarInfo(22, value24);
                break;
            case R.id.ctv_checkedtext17 /* 2131427564 */:
                int value25 = DataCanbus.DATA[139];
                if (value25 == 0) {
                    value25 = 1;
                } else if (value25 == 1) {
                    value25 = 0;
                }
                setCarInfo(39, value25);
                break;
            case R.id.ctv_checkedtext18 /* 2131427663 */:
                int value26 = DataCanbus.DATA[141];
                if (value26 == 0) {
                    value26 = 1;
                } else if (value26 == 1) {
                    value26 = 0;
                }
                setCarInfo(41, value26);
                break;
            case R.id.ctv_checkedtext19 /* 2131427665 */:
                dialog(R.string.xp_accord9_deflation_warning_system, 12, 0);
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
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
    }

    protected void dialog(int stringId, final int cmd, final int cmdid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmdid;
                final int i2 = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(i, new int[]{i2, 0}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.fengshen_ax7.RzcFengshenYixuanSetFunc.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
