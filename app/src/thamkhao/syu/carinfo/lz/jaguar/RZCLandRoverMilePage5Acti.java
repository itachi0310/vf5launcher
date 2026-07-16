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
public class RZCLandRoverMilePage5Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage5Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 105:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text9)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text9)).setText("----");
                        }
                    }
                    break;
                case 114:
                    RZCLandRoverMilePage5Acti.this.fuel_unit = value;
                    break;
                case 194:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)) != null) {
                        switch (RZCLandRoverMilePage5Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                break;
                        }
                    }
                    break;
                case 195:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)) != null) {
                        switch (RZCLandRoverMilePage5Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                                break;
                        }
                    }
                    break;
                case 196:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)) != null) {
                        switch (RZCLandRoverMilePage5Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 197:
                case 198:
                case 199:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = DataCanbus.DATA[197];
                            int min = DataCanbus.DATA[198];
                            int sec = DataCanbus.DATA[199];
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                        } else {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                        }
                    }
                    break;
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                    int year = DataCanbus.DATA[200] + 2011;
                    int month = DataCanbus.DATA[201];
                    int day = DataCanbus.DATA[202];
                    int hour2 = DataCanbus.DATA[203];
                    int min2 = DataCanbus.DATA[204];
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(month) + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                    }
                    break;
                case 205:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text3)).setText("---");
                        }
                    }
                    break;
                case 206:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text4)).setText("---");
                        }
                    }
                    break;
                case 207:
                    if (((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage5Acti.this.findViewById(R.id.tv_text5)).setText("---");
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
                data0 = 5;
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
        DataCanbus.PROXY.cmd(2, new int[]{86, 5}, null, null);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[205].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[206].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[207].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[204].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[205].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[206].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[207].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[203].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[204].removeNotify(this.mNotifyCanbus);
    }
}
