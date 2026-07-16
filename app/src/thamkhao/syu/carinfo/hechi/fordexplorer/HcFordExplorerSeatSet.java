package com.syu.carinfo.hechi.fordexplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class HcFordExplorerSeatSet extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static HcFordExplorerSeatSet mInit;
    byte unit = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.hechi.fordexplorer.HcFordExplorerSeatSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            HcFordExplorerSeatSet.this.updateSeatState();
        }
    };
    int state = 0;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xc_ford_seatset);
        init();
    }

    public void init() {
        mInit = this;
        findViewById(R.id.ford_seat_sub1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add3).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_sub_2).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_1).setOnTouchListener(this);
        findViewById(R.id.ford_seat_add_2).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.ford_seat_sub1 /* 2131427835 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{1, 1}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{4, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub2 /* 2131427836 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{2, 1}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{5, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub3 /* 2131427837 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{3, 1}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{6, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_add1 /* 2131427838 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{1, 2}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{4, 2}, null, null);
                    }
                    break;
                case R.id.ford_seat_add2 /* 2131427839 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{2, 2}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{5, 2}, null, null);
                    }
                    break;
                case R.id.ford_seat_add3 /* 2131427840 */:
                    if (this.state == 4) {
                        DataCanbus.PROXY.cmd(7, new int[]{3, 1}, null, null);
                    } else if (this.state == 6) {
                        DataCanbus.PROXY.cmd(7, new int[]{6, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub_1 /* 2131427841 */:
                    if (this.state == 5) {
                        int value = DataCanbus.DATA[137] - 1;
                        if (value < 0) {
                            value = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{7, value}, null, null);
                    } else if (this.state == 7) {
                        int value2 = DataCanbus.DATA[140] - 1;
                        if (value2 < 0) {
                            value2 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{9, value2}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub_2 /* 2131427842 */:
                    if (this.state == 5) {
                        int value3 = DataCanbus.DATA[138] - 1;
                        if (value3 < 0) {
                            value3 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{8, value3}, null, null);
                    } else if (this.state == 7) {
                        int value4 = DataCanbus.DATA[141] - 1;
                        if (value4 < 0) {
                            value4 = 2;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{10, value4}, null, null);
                    }
                    break;
                case R.id.ford_seat_add_1 /* 2131427843 */:
                    if (this.state == 5) {
                        int value5 = DataCanbus.DATA[137] + 1;
                        if (value5 > 2) {
                            value5 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{7, value5}, null, null);
                    } else if (this.state == 7) {
                        int value6 = DataCanbus.DATA[140] + 1;
                        if (value6 > 2) {
                            value6 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{9, value6}, null, null);
                    }
                    break;
                case R.id.ford_seat_add_2 /* 2131427844 */:
                    if (this.state == 5) {
                        int value7 = DataCanbus.DATA[138] + 1;
                        if (value7 > 2) {
                            value7 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{8, value7}, null, null);
                    } else if (this.state == 7) {
                        int value8 = DataCanbus.DATA[141] + 1;
                        if (value8 > 2) {
                            value8 = 0;
                        }
                        DataCanbus.PROXY.cmd(7, new int[]{10, value8}, null, null);
                    }
                    break;
            }
        } else if (event.getAction() == 1) {
            v.getId();
        }
        return false;
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.notifyCanbus);
    }

    public void updateSeatState() {
        if (DataCanbus.DATA[142] != 0) {
            this.state = DataCanbus.DATA[142];
        }
        switch (this.state) {
            case 4:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("驾驶侧靠背");
                switch (DataCanbus.DATA[127]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[129]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[130]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[131]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        break;
                }
                break;
            case 5:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("驾驶侧按摩");
                switch (DataCanbus.DATA[136]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[137]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[138]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        break;
                }
                break;
            case 6:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                ((TextView) findViewById(R.id.tv_text1)).setText("乘客侧靠背");
                switch (DataCanbus.DATA[128]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[132]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[133]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        break;
                    case 3:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[134]).toString());
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        break;
                }
                break;
            case 7:
                findViewById(R.id.layout_view1).setVisibility(8);
                findViewById(R.id.layout_view2).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("乘客侧按摩");
                switch (DataCanbus.DATA[139]) {
                    case 0:
                        ((TextView) findViewById(R.id.tv_text2)).setText("");
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                        break;
                    case 1:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[140]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        break;
                    case 2:
                        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(DataCanbus.DATA[141]).toString());
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        break;
                }
                break;
            default:
                findViewById(R.id.layout_view1).setVisibility(0);
                findViewById(R.id.layout_view2).setVisibility(8);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        isFront = true;
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }
}
