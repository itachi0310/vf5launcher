package com.syu.carinfo.rzc.zhongtai;

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
public class RzcChanganSetFunc extends BaseActivity {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 159:
                    RzcChanganSetFunc.this.updateAmbientlightLev(value);
                    break;
                case 160:
                    RzcChanganSetFunc.this.mUpdaterAmbientlightOn(value);
                    break;
                case 161:
                    RzcChanganSetFunc.this.mUpdaterSeatPleaseOn(value);
                    break;
                case 162:
                    RzcChanganSetFunc.this.updateHomelightLev(value);
                    break;
                case 163:
                    RzcChanganSetFunc.this.updateHomelightOnoff(value);
                    break;
                case 164:
                    RzcChanganSetFunc.this.updateRoadAwayOnoff(value);
                    break;
                case 165:
                    RzcChanganSetFunc.this.updaterLightHeight(value);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rzc_zhongtai_setfunc);
        if (DataCanbus.sCanbusId == 2294199 || DataCanbus.sCanbusId == 2359735) {
            findViewById(R.id.changan_road_away_onoff).setVisibility(0);
        } else {
            findViewById(R.id.changan_road_away_onoff).setVisibility(8);
        }
        if (DataCanbus.sCanbusId == 7537079) {
            findViewById(R.id.changan_height_light_lev).setVisibility(0);
        } else {
            findViewById(R.id.changan_height_light_lev).setVisibility(8);
        }
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] - 1;
                if (value < 1) {
                    value = 7;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_ambient_light_lev_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[159] + 1;
                if (value > 7) {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(1, new int[]{149, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_home_light_lev_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[162];
                int value1 = DataCanbus.DATA[163];
                int value2 = value - 1;
                if (value2 < 1) {
                    value2 = 14;
                }
                if (value1 == 1) {
                    value2 |= 128;
                } else if (value1 == 0) {
                    value2 &= 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, value2}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_home_light_lev_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[162];
                int value1 = DataCanbus.DATA[163];
                int value2 = value + 1;
                if (value2 > 14) {
                    value2 = 1;
                }
                if (value1 == 1) {
                    value2 |= 128;
                } else if (value1 == 0) {
                    value2 &= 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, value2}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_height_light_lev_minus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[165] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.changan_btn_height_light_lev_plus)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value = DataCanbus.DATA[165] + 1;
                if (value > 3) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{152, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_home_light_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[163];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                int value1 = DataCanbus.DATA[162];
                if (value == 1) {
                    value1 |= 128;
                } else if (value == 0) {
                    value1 &= 127;
                }
                DataCanbus.PROXY.cmd(1, new int[]{150, value1}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[160];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{148, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_road_away_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[164];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{151, value}, null, null);
            }
        });
        ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.zhongtai.RzcChanganSetFunc.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[161];
                if (value2 == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(1, new int[]{147, value}, null, null);
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{65, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLightHeight(int value) {
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.tv_changan_height_light)).setText(R.string.xp_accord9_auto_light_0lowest);
                break;
            case 1:
                ((TextView) findViewById(R.id.tv_changan_height_light)).setText(R.string.xp_accord9_auto_light_1lower);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_changan_height_light)).setText(R.string.xp_accord9_auto_light_3higher);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_changan_height_light)).setText(R.string.xp_accord9_auto_light_4highest);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRoadAwayOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_road_away_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_road_away_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomelightOnoff(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_home_light_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_home_light_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHomelightLev(int value) {
        ((TextView) findViewById(R.id.tv_changan_home_light)).setText(String.format("%d s", Integer.valueOf(value * 20)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAmbientlightLev(int value) {
        ((TextView) findViewById(R.id.tv_changan_ambient_light)).setText(String.format("%d", Integer.valueOf(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAmbientlightOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_ambient_light_onoff)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatPleaseOn(int value) {
        if (((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_changan_set_please_onoff)).setChecked(value == 1);
        }
    }
}
