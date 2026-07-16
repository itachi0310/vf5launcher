package com.syu.carinfo.camry2012.xp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class CamryLightActi_XP extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryLightActi_XP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    CamryLightActi_XP.this.mUpdaterValue0();
                    break;
                case 133:
                    CamryLightActi_XP.this.mUpdaterValue1();
                    break;
                case 134:
                    CamryLightActi_XP.this.mUpdaterValue2();
                    break;
                case 135:
                    CamryLightActi_XP.this.mUpdaterValue3();
                    break;
                case 136:
                    CamryLightActi_XP.this.mUpdaterValue4();
                    break;
                case 137:
                    CamryLightActi_XP.this.mUpdaterValue5();
                    break;
                case 138:
                    CamryLightActi_XP.this.mUpdaterValue6();
                    break;
                case 139:
                    CamryLightActi_XP.this.mUpdaterValue7();
                    break;
                case 140:
                    CamryLightActi_XP.this.mUpdaterValue8();
                    break;
                case 141:
                    CamryLightActi_XP.this.mUpdaterValue9();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_xp_camry_light);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
    }

    private void setBackground(TextView btn, int ResId) {
        if (btn != null) {
            btn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, getResources().getDrawable(ResId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue0() {
        int value = DataCanbus.DATA[132];
        setBackground((TextView) findViewById(R.id.camry_near_light), value == 0 ? R.drawable.wc_ruiteng_near_light_0 : R.drawable.wc_ruiteng_near_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue1() {
        int value = DataCanbus.DATA[133];
        setBackground((TextView) findViewById(R.id.camry_away_light), value == 0 ? R.drawable.wc_ruiteng_away_light_0 : R.drawable.wc_ruiteng_away_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[134];
        setBackground((TextView) findViewById(R.id.camry_width_light), value == 0 ? R.drawable.wc_ruiteng_width_light_0 : R.drawable.wc_ruiteng_width_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue3() {
        int value = DataCanbus.DATA[135];
        setBackground((TextView) findViewById(R.id.camry_back_car_light), value == 0 ? R.drawable.wc_ruiteng_back_car_light_0 : R.drawable.wc_ruiteng_back_car_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue4() {
        int value = DataCanbus.DATA[136];
        setBackground((TextView) findViewById(R.id.camry_brake_car_light), value == 0 ? R.drawable.wc_ruiteng_brake_car_light_0 : R.drawable.wc_ruiteng_brake_car_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue5() {
        int value = DataCanbus.DATA[137];
        setBackground((TextView) findViewById(R.id.camry_right_turn_light), value == 0 ? R.drawable.wc_ruiteng_right_turn_light_0 : R.drawable.wc_ruiteng_right_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue6() {
        int value = DataCanbus.DATA[138];
        setBackground((TextView) findViewById(R.id.camry_left_turn_light), value == 0 ? R.drawable.wc_ruiteng_left_turn_light_0 : R.drawable.wc_ruiteng_left_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue7() {
        int value = DataCanbus.DATA[139];
        setBackground((TextView) findViewById(R.id.camry_both_turn_light), value == 0 ? R.drawable.wc_ruiteng_both_turn_light_0 : R.drawable.wc_ruiteng_both_turn_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue8() {
        int value = DataCanbus.DATA[140];
        setBackground((TextView) findViewById(R.id.camry_rear_fog_light), value == 0 ? R.drawable.wc_ruiteng_front_fog_light_0 : R.drawable.wc_ruiteng_front_fog_light_1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue9() {
        int value = DataCanbus.DATA[141];
        setBackground((TextView) findViewById(R.id.camry_front_fog_light), value == 0 ? R.drawable.wc_ruiteng_rear_fog_light_0 : R.drawable.wc_ruiteng_rear_fog_light_1);
    }
}
