package com.syu.carinfo.wc.gs4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GS4HelpSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.gs4.GS4HelpSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    GS4HelpSetAct.this.updaterSpeed();
                    break;
                case 103:
                    GS4HelpSetAct.this.updaterWarnSound();
                    break;
                case 104:
                    GS4HelpSetAct.this.updaterAwayTime();
                    break;
                case 105:
                    GS4HelpSetAct.this.updaterStartTime();
                    break;
                case 106:
                    GS4HelpSetAct.this.updaterTurnMode();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_help_set);
        setUI();
    }

    private void setUI() {
        ((Button) findViewById(R.id.wc_gs4_warn_of_speed_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_warn_of_speed_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_sound_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_sound_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_away_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_away_time_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_start_time_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_start_time_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.wc_gs4_driver_help_turn_mode_next)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_warn_of_speed_pre /* 2131429059 */:
                int value = (DataCanbus.DATA[102] / 10) - 1;
                if (value >= 0 && value <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_warn_of_speed_next /* 2131429061 */:
                int value2 = (DataCanbus.DATA[102] / 10) + 1;
                if (value2 >= 0 && value2 <= 20) {
                    DataCanbus.PROXY.cmd(2, new int[]{7, value2}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_driver_help_sound_pre /* 2131429062 */:
                int value3 = DataCanbus.DATA[103];
                if (value3 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 2}, null, null);
                } else if (value3 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 0}, null, null);
                } else if (value3 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
                }
                break;
            case R.id.wc_gs4_driver_help_sound_next /* 2131429064 */:
                int value4 = DataCanbus.DATA[103];
                if (value4 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 1}, null, null);
                } else if (value4 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 2}, null, null);
                } else if (value4 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{8, 0}, null, null);
                }
                break;
            case R.id.wc_gs4_driver_help_away_time_pre /* 2131429065 */:
                int value5 = DataCanbus.DATA[104] - 1;
                if (value5 >= 0 && value5 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, value5}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_driver_help_away_time_next /* 2131429067 */:
                int value6 = DataCanbus.DATA[104] + 1;
                if (value6 >= 0 && value6 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{9, value6}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_driver_help_start_time_pre /* 2131429068 */:
                int value7 = DataCanbus.DATA[105] - 1;
                if (value7 >= 0 && value7 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{10, value7}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_driver_help_start_time_next /* 2131429070 */:
                int value8 = DataCanbus.DATA[105] + 1;
                if (value8 >= 0 && value8 <= 30) {
                    DataCanbus.PROXY.cmd(2, new int[]{10, value8}, null, null);
                    break;
                }
                break;
            case R.id.wc_gs4_driver_help_turn_mode_pre /* 2131429071 */:
                int value9 = DataCanbus.DATA[106];
                if (value9 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                } else if (value9 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 0}, null, null);
                } else if (value9 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                }
                break;
            case R.id.wc_gs4_driver_help_turn_mode_next /* 2131429073 */:
                int value10 = DataCanbus.DATA[106];
                if (value10 == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 1}, null, null);
                } else if (value10 == 1) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                } else if (value10 == 2) {
                    DataCanbus.PROXY.cmd(2, new int[]{11, 2}, null, null);
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeed() {
        int mSpeedInt = DataCanbus.DATA[102];
        if (mSpeedInt > 200) {
            mSpeedInt = 200;
        } else if (mSpeedInt < 0) {
            mSpeedInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_warn_of_speed_TV)).setText(mSpeedInt + "Km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWarnSound() {
        int mWarnSoundInt = DataCanbus.DATA[103];
        if (mWarnSoundInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_low);
        } else if (mWarnSoundInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_middle);
        } else if (mWarnSoundInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_sound_TV)).setText(R.string.klc_air_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAwayTime() {
        int mDriverAwayTimeInt = DataCanbus.DATA[104];
        if (mDriverAwayTimeInt > 30) {
            mDriverAwayTimeInt = 30;
        } else if (mDriverAwayTimeInt < 0) {
            mDriverAwayTimeInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_driver_help_away_time_TV)).setText(new StringBuilder().append(mDriverAwayTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterStartTime() {
        int mDriverStartTimeInt = DataCanbus.DATA[105];
        if (mDriverStartTimeInt > 30) {
            mDriverStartTimeInt = 30;
        } else if (mDriverStartTimeInt < 0) {
            mDriverStartTimeInt = 0;
        }
        ((TextView) findViewById(R.id.wc_gs4_driver_help_start_time_TV)).setText(new StringBuilder().append(mDriverStartTimeInt).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTurnMode() {
        int mTurnModeInt = DataCanbus.DATA[106];
        if (mTurnModeInt == 0) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.driver_system_sports);
        } else if (mTurnModeInt == 1) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.driver_system_standard);
        } else if (mTurnModeInt == 2) {
            ((TextView) findViewById(R.id.wc_gs4_driver_help_turn_mode_TV)).setText(R.string.wc_gs4_driver_help_turn_mode_comfort);
        }
    }
}
