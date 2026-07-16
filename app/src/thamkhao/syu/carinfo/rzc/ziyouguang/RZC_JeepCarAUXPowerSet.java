package com.syu.carinfo.rzc.ziyouguang;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZC_JeepCarAUXPowerSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ziyouguang.RZC_JeepCarAUXPowerSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 152:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext7), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text7)).setText("Battery");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext7), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text7)).setText("Ignition");
                    }
                    break;
                case 153:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext4), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text4)).setText("Battery");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext4), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text4)).setText("Ignition");
                    }
                    break;
                case 154:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext1), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text1)).setText("Battery");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext1), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text1)).setText("Ignition");
                    }
                    break;
                case 155:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext11), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text11)).setText("Momentary");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext11), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text11)).setText("Latching");
                    }
                    break;
                case 156:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext8), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text8)).setText("Momentary");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext8), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text8)).setText("Latching");
                    }
                    break;
                case 157:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext5), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text5)).setText("Momentary");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext5), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text5)).setText("Latching");
                    }
                    break;
                case 158:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext2), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text2)).setText("Momentary");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext2), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text2)).setText("Latching");
                    }
                    break;
                case 159:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext12), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text12)).setText("Yes");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext12), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text12)).setText("Not");
                    }
                    break;
                case 160:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext9), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text9)).setText("Yes");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext9), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text9)).setText("Not");
                    }
                    break;
                case 161:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext6), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text6)).setText("Yes");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext6), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text6)).setText("Not");
                    }
                    break;
                case 162:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext3), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text3)).setText("Yes");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext3), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text3)).setText("Not");
                    }
                    break;
                case 163:
                    if (value == 1) {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext10), true);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text10)).setText("Battery");
                    } else {
                        RZC_JeepCarAUXPowerSet.this.setCheck((CheckedTextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.ctv_checkedtext10), false);
                        ((TextView) RZC_JeepCarAUXPowerSet.this.findViewById(R.id.tv_text10)).setText("Ignition");
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0373_rzc_jeep_auxpower_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                if (DataCanbus.DATA[154] == 1) {
                    setCarInfo(193, 2);
                } else {
                    setCarInfo(193, 3);
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                if (DataCanbus.DATA[158] == 1) {
                    setCarInfo(193, 0);
                } else {
                    setCarInfo(193, 1);
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                if (DataCanbus.DATA[162] == 1) {
                    setCarInfo(193, 5);
                } else {
                    setCarInfo(193, 4);
                }
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                if (DataCanbus.DATA[153] == 1) {
                    setCarInfo(194, 2);
                } else {
                    setCarInfo(194, 3);
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                if (DataCanbus.DATA[157] == 1) {
                    setCarInfo(194, 0);
                } else {
                    setCarInfo(194, 1);
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                if (DataCanbus.DATA[161] == 1) {
                    setCarInfo(194, 5);
                } else {
                    setCarInfo(194, 4);
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                if (DataCanbus.DATA[152] == 1) {
                    setCarInfo(195, 2);
                } else {
                    setCarInfo(195, 3);
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                if (DataCanbus.DATA[156] == 1) {
                    setCarInfo(195, 0);
                } else {
                    setCarInfo(195, 1);
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427556 */:
                if (DataCanbus.DATA[160] == 1) {
                    setCarInfo(195, 5);
                } else {
                    setCarInfo(195, 4);
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427557 */:
                if (DataCanbus.DATA[163] == 1) {
                    setCarInfo(196, 2);
                } else {
                    setCarInfo(196, 3);
                }
                break;
            case R.id.ctv_checkedtext11 /* 2131427558 */:
                if (DataCanbus.DATA[155] == 1) {
                    setCarInfo(196, 0);
                } else {
                    setCarInfo(196, 1);
                }
                break;
            case R.id.ctv_checkedtext12 /* 2131427559 */:
                if (DataCanbus.DATA[159] == 1) {
                    setCarInfo(196, 5);
                } else {
                    setCarInfo(196, 4);
                }
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(9, new int[]{97}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
    }
}
