package com.syu.carinfo.xbs.gs3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class GS3CarAccessoryAct extends BaseActivity implements View.OnClickListener {
    CheckedTextView mAutoLockCheck;
    CheckedTextView mAutoRearCheck;
    CheckedTextView mFrontYuGuaFixCheck;
    Button mGuangXiaoQiNext;
    Button mGuangXiaoQiPre;
    TextView mGuangXiaoQiTV;
    Button mLanguageNext;
    Button mLanguagePre;
    TextView mLanguageTV;
    CheckedTextView mRearYuGuaCheck;
    CheckedTextView mRomoteFrontWindCheck;
    CheckedTextView mRomoteUnlockCheck;
    TextView mRomoteUnlockTV;
    CheckedTextView mSpeedLockCheck;
    CheckedTextView mUnlockVolCheck;
    private View view_AutoRear;
    private View view_Language;
    private View view_UnlockVol;
    private View view_guangxiaoqi;
    private View view_mirrorview;
    int mRomoteUnlockInt = -1;
    int mSpeedLockInt = -1;
    int mAutoLockInt = -1;
    int mRomoteFrontWindInt = -1;
    int mFrontYuGuaFixInt = -1;
    int mRearYuGuaInt = -1;
    int mLanguage = 0;
    int mGuangXiaoQi = 0;
    int mUnlockVol = 0;
    int mAutoRear = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.gs3.GS3CarAccessoryAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 107:
                    GS3CarAccessoryAct.this.updaterRomoteUnlock();
                    break;
                case 108:
                    GS3CarAccessoryAct.this.updaterSpeedLock();
                    break;
                case 109:
                    GS3CarAccessoryAct.this.updaterAutoUnlock();
                    break;
                case 110:
                    GS3CarAccessoryAct.this.updaterFrontWind();
                    break;
                case 111:
                    GS3CarAccessoryAct.this.updaterFrontYuGua();
                    break;
                case 112:
                    GS3CarAccessoryAct.this.updaterRearYuGua();
                    break;
                case 113:
                    GS3CarAccessoryAct.this.updaterLanguage();
                    break;
                case 114:
                    GS3CarAccessoryAct.this.updaterGuangXiaoQi();
                    break;
                case 119:
                    GS3CarAccessoryAct.this.updaterUnlockVol();
                    break;
                case 120:
                    GS3CarAccessoryAct.this.updaterAutoRear();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_289_wc_gs4_car_accessory);
        setUI();
    }

    private void setUI() {
        DataCanbus.PROXY.cmd(3, new int[]{6}, null, null);
        this.view_Language = findViewById(R.id.xbs_165_language_view);
        this.view_guangxiaoqi = findViewById(R.id.xbs_165_guangxiaoqi_view);
        this.view_AutoRear = findViewById(R.id.xbs_165_auto_rear_view);
        this.view_UnlockVol = findViewById(R.id.xbs_165_unlock_vol_view);
        this.view_mirrorview = findViewById(R.id.wc_ga6_auto_fold_outside_mirrors_view);
        setViewVisible(this.view_mirrorview, false);
        if (DataCanbus.DATA[1000] == 196773 || DataCanbus.DATA[1000] == 131237) {
            setViewVisible(this.view_AutoRear, true);
            setViewVisible(this.view_guangxiaoqi, true);
            setViewVisible(this.view_UnlockVol, true);
            setViewVisible(this.view_Language, true);
        }
        this.mRomoteUnlockTV = (TextView) findViewById(R.id.wc_gs4_romote_unlock_TV);
        this.mRomoteUnlockCheck = (CheckedTextView) findViewById(R.id.wc_gs4_romote_unlock_check);
        this.mSpeedLockCheck = (CheckedTextView) findViewById(R.id.wc_gs4_car_speed_lock_check);
        this.mAutoLockCheck = (CheckedTextView) findViewById(R.id.wc_gs4_auto_unlock_check);
        this.mRomoteFrontWindCheck = (CheckedTextView) findViewById(R.id.wc_gs4_romote_front_rear_window_check);
        this.mFrontYuGuaFixCheck = (CheckedTextView) findViewById(R.id.wc_gs4_front_yugua_weihu_check);
        this.mRearYuGuaCheck = (CheckedTextView) findViewById(R.id.wc_gs4_rear_yugua_check);
        this.mAutoRearCheck = (CheckedTextView) findViewById(R.id.xbs_165_auto_rear_check);
        this.mUnlockVolCheck = (CheckedTextView) findViewById(R.id.xbs_165_unlock_vol_check);
        this.mLanguagePre = (Button) findViewById(R.id.xbs_gs3_language_pre);
        this.mLanguageNext = (Button) findViewById(R.id.xbs_gs3_language_next);
        this.mLanguageTV = (TextView) findViewById(R.id.xbs_gs3_language_TV);
        this.mGuangXiaoQiPre = (Button) findViewById(R.id.xbs_gs3_guangxiaoqi_pre);
        this.mGuangXiaoQiNext = (Button) findViewById(R.id.xbs_gs3_guangxiaoqi_next);
        this.mGuangXiaoQiTV = (TextView) findViewById(R.id.xbs_gs3_guangxiaoqi_TV);
        setSelfClick(this.mRomoteUnlockCheck, this);
        setSelfClick(this.mSpeedLockCheck, this);
        setSelfClick(this.mAutoLockCheck, this);
        setSelfClick(this.mRomoteFrontWindCheck, this);
        setSelfClick(this.mFrontYuGuaFixCheck, this);
        setSelfClick(this.mRearYuGuaCheck, this);
        setSelfClick(this.mLanguagePre, this);
        setSelfClick(this.mLanguageNext, this);
        setSelfClick(this.mGuangXiaoQiPre, this);
        setSelfClick(this.mGuangXiaoQiNext, this);
        setSelfClick(this.mAutoRearCheck, this);
        setSelfClick(this.mUnlockVolCheck, this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.wc_gs4_romote_unlock_check /* 2131429074 */:
                RemoteModuleProxy remoteModuleProxy = DataCanbus.PROXY;
                int[] iArr = new int[2];
                iArr[0] = 12;
                iArr[1] = this.mRomoteUnlockInt == 0 ? 1 : 0;
                remoteModuleProxy.cmd(2, iArr, null, null);
                break;
            case R.id.wc_gs4_car_speed_lock_check /* 2131429076 */:
                RemoteModuleProxy remoteModuleProxy2 = DataCanbus.PROXY;
                int[] iArr2 = new int[2];
                iArr2[0] = 11;
                iArr2[1] = this.mSpeedLockInt == 0 ? 1 : 0;
                remoteModuleProxy2.cmd(2, iArr2, null, null);
                break;
            case R.id.wc_gs4_auto_unlock_check /* 2131429077 */:
                RemoteModuleProxy remoteModuleProxy3 = DataCanbus.PROXY;
                int[] iArr3 = new int[2];
                iArr3[0] = 10;
                iArr3[1] = this.mAutoLockInt == 0 ? 1 : 0;
                remoteModuleProxy3.cmd(2, iArr3, null, null);
                break;
            case R.id.wc_gs4_romote_front_rear_window_check /* 2131429078 */:
                RemoteModuleProxy remoteModuleProxy4 = DataCanbus.PROXY;
                int[] iArr4 = new int[2];
                iArr4[0] = 14;
                iArr4[1] = this.mRomoteFrontWindInt == 0 ? 1 : 0;
                remoteModuleProxy4.cmd(2, iArr4, null, null);
                break;
            case R.id.wc_gs4_front_yugua_weihu_check /* 2131429079 */:
                RemoteModuleProxy remoteModuleProxy5 = DataCanbus.PROXY;
                int[] iArr5 = new int[2];
                iArr5[0] = 17;
                iArr5[1] = this.mFrontYuGuaFixInt == 0 ? 1 : 0;
                remoteModuleProxy5.cmd(2, iArr5, null, null);
                break;
            case R.id.wc_gs4_rear_yugua_check /* 2131429080 */:
                RemoteModuleProxy remoteModuleProxy6 = DataCanbus.PROXY;
                int[] iArr6 = new int[2];
                iArr6[0] = 16;
                iArr6[1] = this.mRearYuGuaInt == 0 ? 1 : 0;
                remoteModuleProxy6.cmd(2, iArr6, null, null);
                break;
            case R.id.xbs_165_auto_rear_check /* 2131429121 */:
                RemoteModuleProxy remoteModuleProxy7 = DataCanbus.PROXY;
                int[] iArr7 = new int[2];
                iArr7[0] = 26;
                iArr7[1] = this.mAutoRear == 0 ? 1 : 0;
                remoteModuleProxy7.cmd(2, iArr7, null, null);
                break;
            case R.id.xbs_165_unlock_vol_view /* 2131429122 */:
                RemoteModuleProxy remoteModuleProxy8 = DataCanbus.PROXY;
                int[] iArr8 = new int[2];
                iArr8[0] = 25;
                iArr8[1] = this.mUnlockVol == 0 ? 1 : 0;
                remoteModuleProxy8.cmd(2, iArr8, null, null);
                break;
            case R.id.xbs_gs3_language_pre /* 2131429125 */:
            case R.id.xbs_gs3_language_next /* 2131429127 */:
                RemoteModuleProxy remoteModuleProxy9 = DataCanbus.PROXY;
                int[] iArr9 = new int[2];
                iArr9[0] = 27;
                iArr9[1] = this.mLanguage == 0 ? 1 : 0;
                remoteModuleProxy9.cmd(2, iArr9, null, null);
                break;
            case R.id.xbs_gs3_guangxiaoqi_pre /* 2131429129 */:
            case R.id.xbs_gs3_guangxiaoqi_next /* 2131429131 */:
                RemoteModuleProxy remoteModuleProxy10 = DataCanbus.PROXY;
                int[] iArr10 = new int[2];
                iArr10[0] = 28;
                iArr10[1] = this.mGuangXiaoQi == 0 ? 1 : 0;
                remoteModuleProxy10.cmd(2, iArr10, null, null);
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRomoteUnlock() {
        this.mRomoteUnlockInt = DataCanbus.DATA[107];
        this.mRomoteUnlockCheck.setChecked(this.mRomoteUnlockInt != 0);
        if (this.mRomoteUnlockInt == 0) {
            this.mRomoteUnlockTV.setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else if (this.mRomoteUnlockInt == 1) {
            this.mRomoteUnlockTV.setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSpeedLock() {
        this.mSpeedLockInt = DataCanbus.DATA[108];
        this.mSpeedLockCheck.setChecked(this.mSpeedLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoUnlock() {
        this.mAutoLockInt = DataCanbus.DATA[109];
        this.mAutoLockCheck.setChecked(this.mAutoLockInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterUnlockVol() {
        this.mUnlockVol = DataCanbus.DATA[119];
        this.mUnlockVolCheck.setChecked(this.mUnlockVol != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterAutoRear() {
        this.mAutoRear = DataCanbus.DATA[120];
        this.mAutoRearCheck.setChecked(this.mAutoRear != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontWind() {
        this.mRomoteFrontWindInt = DataCanbus.DATA[110];
        this.mRomoteFrontWindCheck.setChecked(this.mRomoteFrontWindInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFrontYuGua() {
        this.mFrontYuGuaFixInt = DataCanbus.DATA[111];
        this.mFrontYuGuaFixCheck.setChecked(this.mFrontYuGuaFixInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRearYuGua() {
        this.mRearYuGuaInt = DataCanbus.DATA[112];
        this.mRearYuGuaCheck.setChecked(this.mRearYuGuaInt != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLanguage() {
        this.mLanguage = DataCanbus.DATA[113];
        if (this.mLanguage == 0) {
            this.mLanguageTV.setText(R.string.jeep_language_set1);
        } else if (this.mLanguage == 1) {
            this.mLanguageTV.setText(R.string.jeep_language_set0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterGuangXiaoQi() {
        this.mGuangXiaoQi = DataCanbus.DATA[114];
        if (this.mGuangXiaoQi == 0) {
            this.mGuangXiaoQiTV.setText(R.string.str_165_guagnxiaoqi0);
        } else if (this.mGuangXiaoQi == 1) {
            this.mGuangXiaoQiTV.setText(R.string.str_165_guagnxiaoqi1);
        }
    }
}
