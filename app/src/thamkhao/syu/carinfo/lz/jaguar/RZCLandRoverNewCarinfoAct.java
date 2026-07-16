package com.syu.carinfo.lz.jaguar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: classes.dex */
public class RZCLandRoverNewCarinfoAct extends BaseActivity implements View.OnClickListener {
    public static boolean mIsFront = false;
    int bkNum = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverNewCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 139:
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image4)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_hdc));
                            break;
                    }
                    break;
                case 140:
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_low));
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image2)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_high));
                            break;
                    }
                    break;
                case 149:
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0_p));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3));
                    ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4));
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image5)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode0));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Special program off");
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image6)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode1_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Grass gravel snow");
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image7)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode2_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Mud-ruts");
                            break;
                        case 3:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image8)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode3_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Sand");
                            break;
                        case 4:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image9)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_mode4_p));
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text1)).setText("Rock crawl");
                            break;
                    }
                    break;
                case 150:
                    switch (value) {
                        case 0:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Standard");
                            break;
                        case 1:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Off road");
                            break;
                        case 2:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text2)).setText("Access");
                            break;
                    }
                    break;
                case 151:
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_p));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_1));
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_2));
                            break;
                        case 3:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_3));
                            break;
                        case 4:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_4));
                            break;
                        case 5:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_5));
                            break;
                        case 6:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_6));
                            break;
                        case 7:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_r));
                            break;
                        case 8:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_d));
                            break;
                        case 9:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_m));
                            break;
                        case 10:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_s));
                            break;
                        case 11:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image1)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_gear_n));
                            break;
                    }
                    break;
                case 152:
                    RZCLandRoverNewCarinfoAct.this.updateTire1Distance();
                    RZCLandRoverNewCarinfoAct.this.updateGanFDistance();
                    break;
                case 153:
                    RZCLandRoverNewCarinfoAct.this.updateTire2Distance();
                    RZCLandRoverNewCarinfoAct.this.updateGanFDistance();
                    break;
                case 154:
                    RZCLandRoverNewCarinfoAct.this.updateTire3Distance();
                    RZCLandRoverNewCarinfoAct.this.updateGanRDistance();
                    break;
                case 155:
                    RZCLandRoverNewCarinfoAct.this.updateTire4Distance();
                    RZCLandRoverNewCarinfoAct.this.updateGanRDistance();
                    break;
                case 158:
                    switch (value) {
                        case 0:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text3)).setText("");
                            break;
                        case 1:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text3)).setText("ESP OFF");
                            break;
                    }
                    break;
                case 159:
                    switch (value) {
                        case 0:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText("");
                            break;
                        case 1:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text4)).setText("ASL");
                            break;
                    }
                    break;
                case 160:
                    switch (value) {
                        case 0:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText("");
                            break;
                        case 1:
                            ((TextView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.tv_text5)).setText("ATPC");
                            break;
                    }
                    break;
                case 163:
                    int lev = DataCanbus.DATA[163];
                    switch (lev) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                            break;
                        case 3:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image3)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                            break;
                    }
                    break;
                case 164:
                    int lev2 = DataCanbus.DATA[164];
                    switch (lev2) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_g0));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r1));
                            break;
                        case 2:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r2));
                            break;
                        case 3:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image16)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_lock_r3));
                            break;
                    }
                    break;
                case 165:
                    switch (value) {
                        case 0:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image17)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_null));
                            break;
                        case 1:
                            ((ImageView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.id_image17)).setImageDrawable(RZCLandRoverNewCarinfoAct.this.getResources().getDrawable(R.drawable.ic_jaguar_autopark));
                            break;
                    }
                    break;
                case 303:
                    int flag = 0;
                    if ((65536 & value) != 0) {
                        flag = 1;
                    }
                    int value2 = ((value & 65535) * 30) / Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_D51_D2_B10;
                    if (flag == 1) {
                        value2 = 0 - value2;
                    }
                    ((InfoJaguarLeftView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.infoView_speed)).setSpeed(value2);
                    ((InfoJaguarLeftView) RZCLandRoverNewCarinfoAct.this.findViewById(R.id.infoView_enginespeed)).setSpeed(value2);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_td_landrover_44info);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_plus1 /* 2131427457 */:
                this.bkNum = 1;
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                findViewById(R.id.id_image10).setVisibility(8);
                findViewById(R.id.id_image11).setVisibility(8);
                findViewById(R.id.id_image12).setVisibility(8);
                findViewById(R.id.id_image13).setVisibility(8);
                findViewById(R.id.id_image14).setVisibility(8);
                findViewById(R.id.id_image15).setVisibility(8);
                findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_jaguar_drivemode_p);
                findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_jaguar_sup);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        mIsFront = true;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        mIsFront = false;
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{87, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
    }

    private void updateTireDistance_delay() {
        HandlerUI.getInstance().postDelayed(new Runnable() { // from class: com.syu.carinfo.lz.jaguar.RZCLandRoverNewCarinfoAct.2
            @Override // java.lang.Runnable
            public void run() {
                RZCLandRoverNewCarinfoAct.this.updateTire1Distance();
                RZCLandRoverNewCarinfoAct.this.updateTire2Distance();
                RZCLandRoverNewCarinfoAct.this.updateGanFDistance();
                RZCLandRoverNewCarinfoAct.this.updateTire3Distance();
                RZCLandRoverNewCarinfoAct.this.updateTire4Distance();
                RZCLandRoverNewCarinfoAct.this.updateGanRDistance();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire1Distance() {
        int value = DataCanbus.DATA[152];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image10);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1133, (((value - 7) * 20) / 13) + 133, 1227, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1133, (((value - 20) * 24) / 10) + 153, 1227, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lf_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire2Distance() {
        int value = DataCanbus.DATA[153];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image12);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1469, (((value - 7) * 20) / 13) + 133, 1563, (((value - 7) * 20) / 13) + 133 + 180);
            } else {
                mIvIconTire1.layout(1469, (((value - 20) * 24) / 10) + 153, 1563, (((value - 20) * 24) / 10) + 153 + 180);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rf_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire3Distance() {
        int value = DataCanbus.DATA[154];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image13);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1038, (((value - 7) * 22) / 13) + 184, 1160, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1038, (((value - 20) * 24) / 10) + 204, 1160, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_lr_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTire4Distance() {
        int value = DataCanbus.DATA[155];
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image15);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1539, (((value - 7) * 22) / 13) + 184, 1661, (((value - 7) * 22) / 13) + 184 + 213);
            } else {
                mIvIconTire1.layout(1539, (((value - 20) * 24) / 10) + 204, 1661, (((value - 20) * 24) / 10) + 204 + 213);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_rr_tire));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGanFDistance() {
        int value1 = DataCanbus.DATA[152];
        int value2 = DataCanbus.DATA[153];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image11);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1242, (((value - 7) * 20) / 13) + 215, 1459, (((value - 7) * 20) / 13) + 215 + 14);
            } else {
                mIvIconTire1.layout(1242, (((value - 20) * 24) / 10) + 235, 1459, (((value - 20) * 24) / 10) + 235 + 14);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_f_gan));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGanRDistance() {
        int value1 = DataCanbus.DATA[154];
        int value2 = DataCanbus.DATA[155];
        int value = (value1 + value2) / 2;
        if (value < 7) {
            value = 7;
        }
        if (value > 30) {
            value = 30;
        }
        ImageView mIvIconTire1 = (ImageView) findViewById(R.id.id_image14);
        if (mIvIconTire1 != null) {
            if (value <= 20) {
                mIvIconTire1.layout(1170, (((value - 7) * 22) / 13) + 283, 1514, (((value - 7) * 22) / 13) + 283 + 24);
            } else {
                mIvIconTire1.layout(1170, (((value - 20) * 24) / 10) + 303, 1514, (((value - 20) * 24) / 10) + 303 + 24);
            }
            mIvIconTire1.setImageDrawable(getResources().getDrawable(R.drawable.ic_jaguar_r_gan));
        }
    }
}
