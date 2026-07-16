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
public class RZCLandRoverMilePage7Acti extends BaseActivity implements View.OnTouchListener {
    int mile_unit = 0;
    int speed_unit = 0;
    int fuel_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverMilePage7Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 103:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)) != null) {
                        if (value >= 0 && value <= 100) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value) + "%");
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text9)).setText("----");
                        }
                    }
                    break;
                case 114:
                    RZCLandRoverMilePage7Acti.this.fuel_unit = value;
                    break;
                case 166:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.mile_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text6)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mile");
                                break;
                        }
                    }
                    break;
                case 167:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.speed_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " km/h");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + " mph");
                                break;
                        }
                    }
                    break;
                case 168:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)) != null) {
                        switch (RZCLandRoverMilePage7Acti.this.fuel_unit) {
                            case 0:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpg");
                                break;
                            case 1:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mpl");
                                break;
                            case 2:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/l");
                                break;
                            case 3:
                                ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text8)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " l/100km");
                                break;
                        }
                    }
                    break;
                case 169:
                case 170:
                case 171:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 4194302) {
                            int hour = DataCanbus.DATA[169];
                            int min = DataCanbus.DATA[170];
                            int sec = DataCanbus.DATA[171];
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1)).setText(String.valueOf(hour) + " : " + (min / 10) + (min % 10) + " : " + (sec / 10) + (sec % 10));
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text1)).setText("00 : 00 : 00");
                        }
                    }
                    break;
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                    int year = DataCanbus.DATA[172] + 2011;
                    int month = DataCanbus.DATA[173];
                    int day = DataCanbus.DATA[174];
                    int hour2 = DataCanbus.DATA[175];
                    int min2 = DataCanbus.DATA[176];
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text2)).setText(String.valueOf(month) + "/" + day + "/" + year + ", " + hour2 + ":" + min2);
                    }
                    break;
                case 177:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text3)).setText("---");
                        }
                    }
                    break;
                case 178:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text4)).setText("---");
                        }
                    }
                    break;
                case 179:
                    if (((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5)) != null) {
                        if (value >= 10 && value <= 50) {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5)).setText(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10)));
                        } else {
                            ((TextView) RZCLandRoverMilePage7Acti.this.findViewById(R.id.tv_text5)).setText("---");
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
                data0 = 3;
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
        DataCanbus.PROXY.cmd(2, new int[]{86, 3}, null, null);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[177].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
    }
}
