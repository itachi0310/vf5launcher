package com.syu.carinfo.wc.ruijie15;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

/* JADX INFO: loaded from: classes.dex */
public class LZBinliTianyueSeatControlAct extends Activity implements View.OnTouchListener {
    public static boolean mIsFront = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruijie15.LZBinliTianyueSeatControlAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int i = R.drawable.ic_xts_auto_n;
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 24:
                    View viewFindViewById = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_auto_left);
                    if (value != 0) {
                        i = R.drawable.ic_xts_auto_p;
                    }
                    viewFindViewById.setBackgroundResource(i);
                    break;
                case 25:
                    View viewFindViewById2 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_auto_right);
                    if (value != 0) {
                        i = R.drawable.ic_xts_auto_p;
                    }
                    viewFindViewById2.setBackgroundResource(i);
                    break;
                case 27:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_left).setBackgroundResource(R.drawable.ic_xts_seathot_left_level3);
                            break;
                    }
                    break;
                case 28:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seathot_right).setBackgroundResource(R.drawable.ic_xts_seathot_right_level3);
                            break;
                    }
                    break;
                case 34:
                    View viewFindViewById3 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatcold_auto_left);
                    if (value != 0) {
                        i = R.drawable.ic_xts_auto_p;
                    }
                    viewFindViewById3.setBackgroundResource(i);
                    break;
                case 35:
                    View viewFindViewById4 = LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatcold_auto_right);
                    if (value != 0) {
                        i = R.drawable.ic_xts_auto_p;
                    }
                    viewFindViewById4.setBackgroundResource(i);
                    break;
                case 36:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_left).setBackgroundResource(R.drawable.ic_xts_seatwin_left_level3);
                            break;
                    }
                    break;
                case 37:
                    switch (value) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seatwin_right).setBackgroundResource(R.drawable.ic_xts_seatwin_right_level3);
                            break;
                    }
                    break;
                case 38:
                case 39:
                    int waist = DataCanbus.DATA[38];
                    int bottom = DataCanbus.DATA[39];
                    int data = ((waist << 1) & 2) | (bottom & 1);
                    switch (data) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotleft).setBackgroundResource(R.drawable.ic_seathot_left_3);
                            break;
                    }
                    break;
                case 40:
                case 41:
                    int waist2 = DataCanbus.DATA[40];
                    int bottom2 = DataCanbus.DATA[41];
                    int data2 = ((waist2 << 1) & 2) | (bottom2 & 1);
                    switch (data2) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_hotright).setBackgroundResource(R.drawable.ic_seathot_right_3);
                            break;
                    }
                    break;
                case 42:
                case 43:
                    int waist3 = DataCanbus.DATA[42];
                    int bottom3 = DataCanbus.DATA[43];
                    int data3 = ((waist3 << 1) & 2) | (bottom3 & 1);
                    switch (data3) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldleft).setBackgroundResource(R.drawable.ic_seatcold_left_3);
                            break;
                    }
                    break;
                case 44:
                case 45:
                    int waist4 = DataCanbus.DATA[44];
                    int bottom4 = DataCanbus.DATA[45];
                    int data4 = ((waist4 << 1) & 2) | (bottom4 & 1);
                    switch (data4) {
                        case 0:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_0);
                            break;
                        case 1:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_1);
                            break;
                        case 2:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_2);
                            break;
                        case 3:
                            LZBinliTianyueSeatControlAct.this.findViewById(R.id.air_xts_seat_coldright).setBackgroundResource(R.drawable.ic_seatcold_right_3);
                            break;
                    }
                    break;
            }
        }
    };

    private void sendCmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_binli_tianyue_airseat_control);
        init();
    }

    private void init() {
        findViewById(R.id.air_xts_seat_hotleft).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_auto_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_hotright).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seathot_auto_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_coldleft).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatcold_auto_left).setOnTouchListener(this);
        findViewById(R.id.air_xts_seat_coldright).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatwin_right).setOnTouchListener(this);
        findViewById(R.id.air_xts_seatcold_auto_right).setOnTouchListener(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        DataCanbus.PROXY.cmd(1, new int[]{3}, null, null);
        addUpdater();
        AirHelper.disableAirWindowLocal(true);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        mIsFront = false;
        AirHelper.disableAirWindowLocal(false);
        removeUpdater();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        int data0 = 0;
        switch (id) {
            case R.id.air_xts_seathot_left /* 2131427433 */:
                data0 = 27;
                break;
            case R.id.air_xts_seathot_right /* 2131427435 */:
                data0 = 28;
                break;
            case R.id.air_xts_seatwin_left /* 2131427452 */:
                data0 = 29;
                break;
            case R.id.air_xts_seatwin_right /* 2131427454 */:
                data0 = 30;
                break;
            case R.id.air_xts_seat_coldleft /* 2131428638 */:
                data0 = 37;
                break;
            case R.id.air_xts_seatcold_auto_left /* 2131428639 */:
                data0 = 39;
                break;
            case R.id.air_xts_seat_coldright /* 2131428640 */:
                data0 = 40;
                break;
            case R.id.air_xts_seatcold_auto_right /* 2131428641 */:
                data0 = 42;
                break;
            case R.id.air_xts_seat_hotleft /* 2131428642 */:
                data0 = 31;
                break;
            case R.id.air_xts_seathot_auto_left /* 2131428643 */:
                data0 = 33;
                break;
            case R.id.air_xts_seat_hotright /* 2131428644 */:
                data0 = 34;
                break;
            case R.id.air_xts_seathot_auto_right /* 2131428645 */:
                data0 = 36;
                break;
        }
        if (event.getAction() == 0) {
            sendCmd(20, data0);
            return false;
        }
        return false;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[25].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[25].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
    }
}
