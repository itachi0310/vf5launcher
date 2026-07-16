package com.syu.carinfo.rzc.sanlin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class LZMaseratiCarInfo extends BaseActivity implements View.OnClickListener {
    int oil_unit = 0;
    int distance_unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 96:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " km/h");
                    break;
                case 97:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " mil");
                    }
                    break;
                case 98:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + " rpm");
                    break;
                case 99:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " km");
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + " mil");
                    }
                    break;
                case 100:
                case 101:
                    int hour = DataCanbus.DATA[100];
                    int min = DataCanbus.DATA[101];
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(hour) + "H" + min + "M");
                    break;
                case 102:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + " km/h");
                    break;
                case 103:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " km");
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value / 10.0f) + " mil");
                    }
                    break;
                case 104:
                    if (LZMaseratiCarInfo.this.oil_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " l/100km");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 1) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " mpg(uk)");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 2) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " km/l");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 3) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 10.0f) + " mpg(us)");
                    }
                    break;
                case 105:
                case 106:
                    int hour2 = DataCanbus.DATA[105];
                    int min2 = DataCanbus.DATA[106];
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(hour2) + "H" + min2 + "M");
                    break;
                case 107:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(value) + " km/h");
                    break;
                case 108:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " km");
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10.0f) + " mil");
                    }
                    break;
                case 109:
                    if (LZMaseratiCarInfo.this.oil_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " l/100km");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 1) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " mpg(uk)");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 2) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " km/l");
                    } else if (LZMaseratiCarInfo.this.oil_unit == 3) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10.0f) + " mpg(us)");
                    }
                    break;
                case 113:
                    LZMaseratiCarInfo.this.oil_unit = value;
                    break;
                case 121:
                    LZMaseratiCarInfo.this.distance_unit = value;
                    break;
                case 124:
                    if (LZMaseratiCarInfo.this.distance_unit == 0) {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " km");
                    } else {
                        ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(value) + " mil");
                    }
                    break;
                case 125:
                    ((TextView) LZMaseratiCarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(value) + " Day");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_lz_maserati_carinfo);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{53}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{55}, null, null);
        DataCanbus.PROXY.cmd(0, new int[]{57}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                dialog(R.string.jiede_trip_a, 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                dialog(R.string.str_trip_b, 1);
                break;
        }
    }

    protected void dialog(int stringId, final int cmd) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(String.valueOf(getResources().getString(R.string.confirm_reset)) + " " + getResources().getString(stringId) + " " + getResources().getString(R.string.data));
        builder.setTitle(getResources().getString(R.string.tips));
        builder.setPositiveButton(getResources().getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarInfo.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final int i = cmd;
                new Thread(new Runnable() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarInfo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DataCanbus.PROXY.cmd(1, new int[]{13, i}, null, null);
                    }
                }).start();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.syu.carinfo.rzc.sanlin.LZMaseratiCarInfo.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
    }
}
