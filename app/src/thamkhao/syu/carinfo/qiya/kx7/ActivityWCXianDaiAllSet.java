package com.syu.carinfo.qiya.kx7;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* JADX INFO: loaded from: classes.dex */
public class ActivityWCXianDaiAllSet extends Activity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.qiya.kx7.ActivityWCXianDaiAllSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 95:
                    ActivityWCXianDaiAllSet.this.updateTrackDisplay(value);
                    break;
                case 96:
                    ActivityWCXianDaiAllSet.this.updateRadarDisplay(value);
                    break;
                case 97:
                    ActivityWCXianDaiAllSet.this.updateFrontViewInit(value);
                    break;
                case 98:
                    ActivityWCXianDaiAllSet.this.updateRearViewInit(value);
                    break;
                case 101:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
                    }
                    break;
                case 102:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 103:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("L" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
                case 104:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("F" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 105:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text6)).setText("0");
                        }
                    }
                    break;
                case 106:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text7)).setText("0");
                        }
                    }
                    break;
                case 107:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)) != null) {
                        if (value > 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("+" + (value - 16));
                        } else if (value < 16) {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("-" + (16 - value));
                        } else {
                            ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text8)).setText("0");
                        }
                    }
                    break;
                case 108:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
                    }
                    break;
                case 109:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
                    }
                    break;
                case 110:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
                    }
                    break;
                case 111:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
                    }
                    break;
                case 112:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
                    }
                    break;
                case 113:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
                    }
                    break;
                case 114:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 115:
                    if (((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 116:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
                    }
                    break;
                case 117:
                    if (((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)) != null) {
                        ((CheckedTextView) ActivityWCXianDaiAllSet.this.findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
                    }
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_xiandai_all_set);
        setListener();
    }

    private void setListener() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda /* 3473851 */:
            case FinalCanbus.CAR_443_WC2_XianDai_All_19Shengda_H /* 3867067 */:
                findViewById(R.id.layout_view1).setVisibility(0);
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(8);
                break;
        }
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setOnClickListener(this);
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
        ((Button) findViewById(R.id.btn_minus10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus10)).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[97] - 1;
                if (value < 0) {
                    value = 0;
                }
                setCmd(4, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[97] + 1;
                if (value2 > 3) {
                    value2 = 3;
                }
                setCmd(4, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[98] - 1;
                if (value3 < 0) {
                    value3 = 0;
                }
                setCmd(5, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[98] + 1;
                if (value4 > 3) {
                    value4 = 3;
                }
                setCmd(5, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[102];
                if (value5 > 0) {
                    value5--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{1, value5}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                DataCanbus.PROXY.cmd(3, new int[]{1, DataCanbus.DATA[102] + 1}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value6 = DataCanbus.DATA[103];
                if (value6 > 6) {
                    value6--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value6}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value7 = DataCanbus.DATA[103];
                if (value7 < 26) {
                    value7++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{2, value7}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value8 = DataCanbus.DATA[104];
                if (value8 > 6) {
                    value8--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value8}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value9 = DataCanbus.DATA[104];
                if (value9 < 26) {
                    value9++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{3, value9}, null, null);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value10 = DataCanbus.DATA[105];
                if (value10 > 6) {
                    value10--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value10}, null, null);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value11 = DataCanbus.DATA[105];
                if (value11 < 26) {
                    value11++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{4, value11}, null, null);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value12 = DataCanbus.DATA[106];
                if (value12 > 6) {
                    value12--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value12}, null, null);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value13 = DataCanbus.DATA[106];
                if (value13 < 26) {
                    value13++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{5, value13}, null, null);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value14 = DataCanbus.DATA[107];
                if (value14 > 6) {
                    value14--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value14}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value15 = DataCanbus.DATA[107];
                if (value15 < 26) {
                    value15++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{6, value15}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value16 = DataCanbus.DATA[114];
                if (value16 > 0) {
                    value16--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value16, 255, 255}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value17 = DataCanbus.DATA[114];
                if (value17 < 10) {
                    value17++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{16, value17, 255, 255}, null, null);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value18 = DataCanbus.DATA[115];
                if (value18 > 0) {
                    value18--;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value18, 255, 255}, null, null);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value19 = DataCanbus.DATA[115];
                if (value19 < 72) {
                    value19++;
                }
                DataCanbus.PROXY.cmd(4, new int[]{17, value19, 255, 255}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                setCmd(3, DataCanbus.DATA[96] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                setCmd(2, DataCanbus.DATA[95] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                DataCanbus.PROXY.cmd(2, DataCanbus.DATA[101] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value20 = DataCanbus.DATA[108];
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 7;
                iArr[1] = value20 == 0 ? 1 : 0;
                remoteModuleProxy.cmd(3, iArr, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value21 = DataCanbus.DATA[109];
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[4];
                iArr2[0] = 1;
                iArr2[1] = value21 == 0 ? 1 : 0;
                iArr2[2] = 255;
                iArr2[3] = 255;
                remoteModuleProxy2.cmd(4, iArr2, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value22 = DataCanbus.DATA[110];
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[4];
                iArr3[0] = 2;
                iArr3[1] = value22 == 0 ? 1 : 0;
                iArr3[2] = 255;
                iArr3[3] = 255;
                remoteModuleProxy3.cmd(4, iArr3, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value23 = DataCanbus.DATA[111];
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[4];
                iArr4[0] = 3;
                iArr4[1] = value23 == 0 ? 1 : 0;
                iArr4[2] = 255;
                iArr4[3] = 255;
                remoteModuleProxy4.cmd(4, iArr4, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value24 = DataCanbus.DATA[112];
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[4];
                iArr5[0] = 4;
                iArr5[1] = value24 == 0 ? 1 : 0;
                iArr5[2] = 255;
                iArr5[3] = 255;
                remoteModuleProxy5.cmd(4, iArr5, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                int value25 = DataCanbus.DATA[113];
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[4];
                iArr6[0] = 5;
                iArr6[1] = value25 == 0 ? 1 : 0;
                iArr6[2] = 255;
                iArr6[3] = 255;
                remoteModuleProxy6.cmd(4, iArr6, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                int value26 = DataCanbus.DATA[116];
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[4];
                iArr7[0] = 6;
                iArr7[1] = value26 == 0 ? 1 : 0;
                iArr7[2] = 255;
                iArr7[3] = 255;
                remoteModuleProxy7.cmd(4, iArr7, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                int value27 = DataCanbus.DATA[117];
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[4];
                iArr8[0] = 7;
                iArr8[1] = value27 == 0 ? 1 : 0;
                iArr8[2] = 255;
                iArr8[3] = 255;
                remoteModuleProxy8.cmd(4, iArr8, null, null);
                break;
        }
    }

    private void setCmd(int type, int value) {
        DataCanbus.PROXY.cmd(1, type, value);
    }

    protected void updateTrackDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    protected void updateRadarDisplay(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
        }
    }

    protected void updateRearViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_rear_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }

    protected void updateFrontViewInit(int value) {
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_front_view_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_394_all_view);
                    break;
            }
        }
    }
}
