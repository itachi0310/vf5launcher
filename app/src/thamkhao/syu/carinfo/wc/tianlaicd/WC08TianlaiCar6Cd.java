package com.syu.carinfo.wc.tianlaicd;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0443_WC2_08_12Tianlai;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WC08TianlaiCar6Cd extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static WC08TianlaiCar6Cd mInit;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 116:
                    WC08TianlaiCar6Cd.this.updateDiscNum(value);
                    break;
                case 117:
                case 138:
                    WC08TianlaiCar6Cd.this.mUpdaterCdText();
                    break;
                case 118:
                case 124:
                    WC08TianlaiCar6Cd.this.mUpdateCd6State();
                    break;
                case 119:
                case 125:
                    WC08TianlaiCar6Cd.this.mUpdateCd5State();
                    break;
                case 120:
                case 126:
                    WC08TianlaiCar6Cd.this.mUpdateCd4State();
                    break;
                case 121:
                case 127:
                    WC08TianlaiCar6Cd.this.mUpdateCd3State();
                    break;
                case 122:
                case 128:
                    WC08TianlaiCar6Cd.this.mUpdateCd2State();
                    break;
                case 123:
                case 129:
                    WC08TianlaiCar6Cd.this.mUpdateCd1State();
                    break;
                case 130:
                    ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_track)).setText("Track:" + ((value >> 4) & 15) + ((value >> 0) & 15));
                    break;
                case 131:
                case 132:
                    int m = DataCanbus.DATA[131];
                    int s = DataCanbus.DATA[132];
                    ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_time)).setText(String.valueOf(m) + " : " + s);
                    break;
                case 133:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text1)).setText("Scan: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text1)).setText("Scan....");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text1)).setText("Disc Scan");
                            break;
                    }
                    break;
                case 134:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_repeat)).setText("Repeat: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_repeat)).setText("Track Repeat");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_repeat)).setText("Disc Repeat");
                            break;
                        case 3:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.huiteng_cd_repeat)).setText("All Disc Repeat");
                            break;
                    }
                    break;
                case 135:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text2)).setText("Random: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text2)).setText("Random: on");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text2)).setText("Disc Random");
                            break;
                        case 3:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text2)).setText("All Disc Random");
                            break;
                    }
                    break;
                case 136:
                    switch (value) {
                        case 0:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text3)).setText("Floder: off");
                            break;
                        case 1:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text3)).setText("Floder: RPT");
                            break;
                        case 2:
                            ((TextView) WC08TianlaiCar6Cd.this.findViewById(R.id.tv_text3)).setText("Floder: RDM");
                            break;
                    }
                    break;
                case 137:
                    WC08TianlaiCar6Cd.this.mUpdaterCdState(value);
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_08tianlai_car6cd);
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdText() {
        int value = DataCanbus.DATA[117];
        if (value == 1) {
            ((TextView) findViewById(R.id.cd_title)).setText(Callback_0443_WC2_08_12Tianlai.CDText);
        } else {
            ((TextView) findViewById(R.id.cd_title)).setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCdState(int value) {
        int num = DataCanbus.DATA[116];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.cd_state)).setText("Reading Disc " + num);
                break;
            case 2:
                ((TextView) findViewById(R.id.cd_state)).setText("Play");
                break;
            case 6:
                ((TextView) findViewById(R.id.cd_state)).setText("Stop");
                break;
            case 12:
                ((TextView) findViewById(R.id.cd_state)).setText("Eject");
                break;
            case 17:
                ((TextView) findViewById(R.id.cd_state)).setText("Loading Disc " + num);
                break;
            case 18:
                ((TextView) findViewById(R.id.cd_state)).setText("Insert Disc");
                break;
            case 19:
                ((TextView) findViewById(R.id.cd_state)).setText("Wait");
                break;
            case 20:
                ((TextView) findViewById(R.id.cd_state)).setText("Busy");
                break;
            case 21:
                ((TextView) findViewById(R.id.cd_state)).setText("Select disc to load");
                break;
            case 22:
                ((TextView) findViewById(R.id.cd_state)).setText("Select disc to eject");
                break;
            case 23:
                ((TextView) findViewById(R.id.cd_state)).setText("Disc Error");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd1State() {
        int value = DataCanbus.DATA[123];
        int type = DataCanbus.DATA[129];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd1)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd1)).setText("Ram Disk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd2State() {
        int value = DataCanbus.DATA[122];
        int type = DataCanbus.DATA[128];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd2)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd2)).setText("Ram Disk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd3State() {
        int value = DataCanbus.DATA[121];
        int type = DataCanbus.DATA[127];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd3)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd3)).setText("Ram Disk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd4State() {
        int value = DataCanbus.DATA[120];
        int type = DataCanbus.DATA[126];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd4)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd4)).setText("Ram Disk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd5State() {
        int value = DataCanbus.DATA[119];
        int type = DataCanbus.DATA[125];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd5)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd5)).setText("Ram Disk");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateCd6State() {
        int value = DataCanbus.DATA[118];
        int type = DataCanbus.DATA[124];
        if (value == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd6)).setText(R.string.jeep_playstate1);
        } else if (type == 0) {
            ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("CD");
        } else if (type == 1) {
            ((TextView) findViewById(R.id.dj_lexus_cd6)).setText("Ram Disk");
        }
    }

    public void updateDiscNum(int value) {
        ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-1);
        ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-1);
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.dj_lexus_cd1)).setTextColor(-65536);
                break;
            case 2:
                ((TextView) findViewById(R.id.dj_lexus_cd2)).setTextColor(-65536);
                break;
            case 3:
                ((TextView) findViewById(R.id.dj_lexus_cd3)).setTextColor(-65536);
                break;
            case 4:
                ((TextView) findViewById(R.id.dj_lexus_cd4)).setTextColor(-65536);
                break;
            case 5:
                ((TextView) findViewById(R.id.dj_lexus_cd5)).setTextColor(-65536);
                break;
            case 6:
                ((TextView) findViewById(R.id.dj_lexus_cd6)).setTextColor(-65536);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        FuncMain.setChannel(13);
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
