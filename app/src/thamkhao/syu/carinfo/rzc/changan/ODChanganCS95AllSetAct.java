package com.syu.carinfo.rzc.changan;

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
public class ODChanganCS95AllSetAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 94:
                    ODChanganCS95AllSetAct.this.uFoldRearMirror(DataCanbus.DATA[updateCode]);
                    break;
                case 95:
                    ODChanganCS95AllSetAct.this.mUpdaterDrivingMileage();
                    break;
                case 96:
                    ODChanganCS95AllSetAct.this.mUpdaterValue8();
                    break;
                case 97:
                    ODChanganCS95AllSetAct.this.uRemoteUnlock(DataCanbus.DATA[updateCode]);
                    break;
                case 98:
                    ODChanganCS95AllSetAct.this.uDriveLock(DataCanbus.DATA[updateCode]);
                    break;
                case 99:
                    ODChanganCS95AllSetAct.this.uAccOffLock(DataCanbus.DATA[updateCode]);
                    break;
                case 100:
                    ODChanganCS95AllSetAct.this.uLightFrontDelay(DataCanbus.DATA[updateCode]);
                    break;
                case 101:
                    ODChanganCS95AllSetAct.this.uLightOnKeyTurn(DataCanbus.DATA[updateCode]);
                    break;
                case 102:
                    ODChanganCS95AllSetAct.this.uBackRainAssist(DataCanbus.DATA[updateCode]);
                    break;
                case 103:
                    ODChanganCS95AllSetAct.this.uAutoAir(DataCanbus.DATA[updateCode]);
                    break;
                case 104:
                    ODChanganCS95AllSetAct.this.uOpenWindowToWind(DataCanbus.DATA[updateCode]);
                    break;
                case 105:
                    ((CheckedTextView) ODChanganCS95AllSetAct.this.findViewById(R.id.ctv_checkedtext10)).setChecked(DataCanbus.DATA[updateCode] == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_od_changan_cs95_setfunc);
        initview();
    }

    private void initview() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.2
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    int value = DataCanbus.DATA[96] & 255;
                    RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                    int[] iArr = new int[1];
                    iArr[0] = value != 0 ? 0 : 1;
                    remoteModuleProxy.cmd(0, iArr, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ODChanganCS95AllSetAct.this.ShoeRestoreCarSetDialog();
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[94];
                    if (i == 1) {
                        i = 0;
                    } else if (i == 0) {
                        i = 64;
                    }
                    DataCanbus.PROXY.cmd(3, new int[]{4, i}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[97];
                    DataCanbus.PROXY.cmd(1, new int[]{0, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[98];
                    DataCanbus.PROXY.cmd(1, new int[]{1, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[99];
                    DataCanbus.PROXY.cmd(1, new int[]{2, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus1)) != null) {
            ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.8
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ODChanganCS95AllSetAct.this.FrontLightDelayMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus1)) != null) {
            ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.9
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ODChanganCS95AllSetAct.this.FrontLightDelayMode(1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_minus2)) != null) {
            ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.10
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ODChanganCS95AllSetAct.this.OnekeyturnMode(-1);
                }
            });
        }
        if (((Button) findViewById(R.id.btn_plus2)) != null) {
            ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.11
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    ODChanganCS95AllSetAct.this.OnekeyturnMode(1);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.12
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[102];
                    DataCanbus.PROXY.cmd(1, new int[]{6, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.13
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[103];
                    DataCanbus.PROXY.cmd(1, new int[]{7, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.14
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[104];
                    DataCanbus.PROXY.cmd(1, new int[]{8, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.15
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i = DataCanbus.DATA[105];
                    DataCanbus.PROXY.cmd(1, new int[]{9, ODChanganCS95AllSetAct.this.getCheckedValue(i)}, null, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[96] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext1)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
        }
    }

    protected void OnekeyturnMode(int i) {
        int temp = DataCanbus.DATA[101];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 3) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{4, temp}, null, null);
    }

    protected void FrontLightDelayMode(int i) {
        int temp = DataCanbus.DATA[100];
        if (i < 0) {
            if (temp > 0) {
                temp--;
            }
        } else if (i > 0 && temp < 4) {
            temp++;
        }
        DataCanbus.PROXY.cmd(1, new int[]{3, temp}, null, null);
    }

    protected void ShoeRestoreCarSetDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        normalDialog.setTitle(R.string.str_gs4_setting0);
        normalDialog.setMessage(R.string.str_gs4_setting0);
        normalDialog.setPositiveButton(R.string.wc_psa_all_confirm, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                DataCanbus.PROXY.cmd(1, new int[]{255, 0}, null, null);
            }
        });
        normalDialog.setNegativeButton(R.string.wc_psa_all_cancel, new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.changan.ODChanganCS95AllSetAct.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(4, new int[]{102}, null, null);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedValue(int i) {
        return i == 1 ? 0 : 1;
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
    }

    protected void uLightOnKeyTurn(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text2)).setText("3 times");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text2)).setText("5 times");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text2)).setText("7 times");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text2)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uLightFrontDelay(int i) {
        switch (i) {
            case 1:
                ((TextView) findViewById(R.id.tv_text1)).setText("10s");
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setText("30s");
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setText("60s");
                break;
            case 4:
                ((TextView) findViewById(R.id.tv_text1)).setText("120s");
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setText(R.string.jeep_comfortsystems_0);
                break;
        }
    }

    protected void uOpenWindowToWind(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(i == 1);
        }
    }

    protected void uAutoAir(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(i == 1);
        }
    }

    protected void uAccOffLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(i == 1);
        }
    }

    protected void uDriveLock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(i == 1);
        }
    }

    protected void uRemoteUnlock(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(i == 1);
        }
    }

    protected void uBackRainAssist(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(i == 1);
        }
    }

    protected void uFoldRearMirror(int i) {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        if (((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)) != null) {
            int value = DataCanbus.DATA[95];
            String str = "0";
            if (value >= 0) {
                if (value > 8191) {
                    str = "--";
                } else {
                    str = new StringBuilder(String.valueOf(value)).toString();
                }
            }
            ((TextView) findViewById(R.id.rzc_xp_cs75_tv_mileage_last)).setText(String.valueOf(str) + " KM");
        }
    }
}
