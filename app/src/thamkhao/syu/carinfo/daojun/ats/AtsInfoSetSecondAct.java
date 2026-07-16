package com.syu.carinfo.daojun.ats;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class AtsInfoSetSecondAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.daojun.ats.AtsInfoSetSecondAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    AtsInfoSetSecondAct.this.updaternearCarUnlock();
                    break;
                case 117:
                    AtsInfoSetSecondAct.this.updaterForgotKey();
                    break;
                case 118:
                    AtsInfoSetSecondAct.this.updaterDriverStyle();
                    break;
                case 119:
                    AtsInfoSetSecondAct.this.updaterRelockDoor();
                    break;
                case 123:
                    AtsInfoSetSecondAct.this.updaterhandTraffic();
                    break;
                case 124:
                    AtsInfoSetSecondAct.this.updateradaptiveForwardLight();
                    break;
                case 125:
                    AtsInfoSetSecondAct.this.updaterMirrorAutoFold();
                    break;
                case 126:
                    AtsInfoSetSecondAct.this.updaterReverTiltMirror();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_daojun_ats_info_second_set);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value1 = DataCanbus.DATA[116];
                AtsFunc.CAR_COMM_CONTROL(12, value1 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value2 = DataCanbus.DATA[117];
                AtsFunc.CAR_COMM_CONTROL(13, value2 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value3 = DataCanbus.DATA[118];
                AtsFunc.CAR_COMM_CONTROL(14, value3 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                AtsFunc.CAR_COMM_CONTROL(15, DataCanbus.DATA[119] != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext5 /* 2131427552 */:
                int value7 = DataCanbus.DATA[123];
                AtsFunc.CAR_COMM_CONTROL(16, value7 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427553 */:
                int value8 = DataCanbus.DATA[124];
                AtsFunc.CAR_COMM_CONTROL(17, value8 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427554 */:
                int value9 = DataCanbus.DATA[125];
                AtsFunc.CAR_COMM_CONTROL(18, value9 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427555 */:
                int value10 = DataCanbus.DATA[126];
                AtsFunc.CAR_COMM_CONTROL(19, value10 != 0 ? 0 : 1);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaternearCarUnlock() {
        int switchOn = DataCanbus.DATA[116];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_all_door);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext1)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text1)).setText(R.string.klc_remote_Smart_Near_car_unlocked_only_driver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterForgotKey() {
        int switchOn = DataCanbus.DATA[117];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDriverStyle() {
        int switchOn = DataCanbus.DATA[118];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRelockDoor() {
        int reLockOpenDoorvalue = DataCanbus.DATA[119];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(reLockOpenDoorvalue != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterhandTraffic() {
        int switchOn = DataCanbus.DATA[123];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_yinglang_car_set_Second_str2);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text2)).setText(R.string.xp_yinglang_car_set_Second_str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateradaptiveForwardLight() {
        int switchOn = DataCanbus.DATA[124];
        if (switchOn == 0) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(false);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str5);
        } else if (switchOn == 1) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(true);
            ((TextView) findViewById(R.id.tv_text3)).setText(R.string.xp_yinglang_car_set_Second_str6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMirrorAutoFold() {
        int switchOn = DataCanbus.DATA[125];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(switchOn != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterReverTiltMirror() {
        int switchOn = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(switchOn != 0);
    }
}
