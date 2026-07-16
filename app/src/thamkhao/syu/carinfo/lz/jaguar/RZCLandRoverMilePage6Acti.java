package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZCLandRoverMilePage6Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage6Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text9)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text9)).setText("----");
                        }
                    }
                    break;
                case 114:
                    RZCLandRoverMilePage6Acti.this.fuel_unit = value;
                    break;
                case 180:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)) != null) {
                        switch (RZCLandRoverMilePage6Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                break;
                        }
                    }
                    break;
                case 181:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)) != null) {
                        switch (RZCLandRoverMilePage6Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)) != null) {
                        switch (RZCLandRoverMilePage6Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 183:
                case 184:
                case 185:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = DataCanbus.DATA[183];
                            int min = DataCanbus.DATA[184];
                            int sec = DataCanbus.DATA[185];
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                        } else {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                        }
                    }
                    break;
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                    int year = DataCanbus.DATA[186] + 2011;
                    int month = DataCanbus.DATA[187];
                    int day = DataCanbus.DATA[188];
                    int hour2 = DataCanbus.DATA[189];
                    int min2 = DataCanbus.DATA[190];
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(month) + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                    }
                    break;
                case 191:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text3)).setText("---");
                        }
                    }
                    break;
                case 192:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text4)).setText("---");
                        }
                    }
                    break;
                case 193:
                    if (((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage6Acti.this.findViewById(R.id.tv_text5)).setText("---");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_mile_page2);
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.btn_plus1 /* 2131427457 */:
                data0 = 4;
                break;
        }
        if (event.getAction() == 0) {
            DataCanbus.PROXY.cmd(1, new int[]{1, data0}, null, null);
        }
        return false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{83, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{84, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{86, 4}, null, null);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[183].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[184].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[185].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[191].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[192].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[186].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[187].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[188].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[183].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[184].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[185].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[191].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[192].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[186].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[187].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[188].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.mNotifyCanbus);
    }
}
