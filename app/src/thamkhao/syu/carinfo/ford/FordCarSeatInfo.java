package com.syu.carinfo.ford;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class FordCarSeatInfo extends Activity implements View.OnTouchListener {
    public static boolean isFront = false;
    public static FordCarSeatInfo mInit;
    int pagenum = 0;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.ford.FordCarSeatInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 164:
                    if (FordCarSeatInfo.this.pagenum == 0) {
                        switch (value) {
                            case 0:
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                                break;
                            case 1:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                            case 2:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                        }
                    }
                    break;
                case 165:
                    if (FordCarSeatInfo.this.pagenum == 1) {
                        switch (value) {
                            case 0:
                                FordCarSeatInfo.this.findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                                break;
                            case 1:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(8);
                                break;
                            case 2:
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                                FordCarSeatInfo.this.findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                                ((Button) FordCarSeatInfo.this.findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                                FordCarSeatInfo.this.findViewById(R.id.layout_view2).setVisibility(0);
                                FordCarSeatInfo.this.findViewById(R.id.layout_view1).setVisibility(8);
                                break;
                        }
                    }
                    break;
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                    FordCarSeatInfo.this.mUpdateSeatValue();
                    break;
            }
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0334_rzc_ford_seatset);
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
        findViewById(R.id.btn_plus1).setOnTouchListener(this);
        findViewById(R.id.btn_plus2).setOnTouchListener(this);
        findViewById(R.id.btn_plus3).setOnTouchListener(this);
        findViewById(R.id.btn_plus4).setOnTouchListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            switch (v.getId()) {
                case R.id.btn_plus1 /* 2131427457 */:
                    this.pagenum = 0;
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                    mUpdateSeatValue();
                    break;
                case R.id.btn_plus2 /* 2131427460 */:
                    this.pagenum = 1;
                    findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
                    findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                    mUpdateSeatValue();
                    break;
                case R.id.btn_plus3 /* 2131427463 */:
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#ffffff"));
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 10, 1}, null, null);
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 11, 1}, null, null);
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                    }
                    break;
                case R.id.btn_plus4 /* 2131427466 */:
                    findViewById(R.id.btn_plus4).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
                    findViewById(R.id.btn_plus3).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
                    ((Button) findViewById(R.id.btn_plus4)).setTextColor(Color.parseColor("#666666"));
                    ((Button) findViewById(R.id.btn_plus3)).setTextColor(Color.parseColor("#ffffff"));
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 10, 2}, null, null);
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 11, 2}, null, null);
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_null);
                    }
                    break;
                case R.id.ford_seat_sub1 /* 2131427835 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 2}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 2}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub2 /* 2131427836 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 2}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 2}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub3 /* 2131427837 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 2}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 2}, null, null);
                    }
                    break;
                case R.id.ford_seat_add1 /* 2131427838 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 1}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist1);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_add2 /* 2131427839 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 1}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist2);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_add3 /* 2131427840 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 1}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_waist3);
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 1}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub_1 /* 2131427841 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int leftmassage_vaue1 = DataCanbus.DATA[169];
                        if (leftmassage_vaue1 > 0) {
                            leftmassage_vaue1--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 6, leftmassage_vaue1}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int rightmassage_vaue1 = DataCanbus.DATA[174];
                        if (rightmassage_vaue1 > 0) {
                            rightmassage_vaue1--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 8, rightmassage_vaue1}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub_2 /* 2131427842 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int leftmassage_vaue2 = DataCanbus.DATA[170];
                        if (leftmassage_vaue2 > 0) {
                            leftmassage_vaue2--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 7, leftmassage_vaue2}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int rightmassage_vaue2 = DataCanbus.DATA[175];
                        if (rightmassage_vaue2 > 0) {
                            rightmassage_vaue2--;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 9, rightmassage_vaue2}, null, null);
                    }
                    break;
                case R.id.ford_seat_add_1 /* 2131427843 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int leftmassage_vaue12 = DataCanbus.DATA[169];
                        if (leftmassage_vaue12 < 2) {
                            leftmassage_vaue12++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 6, leftmassage_vaue12}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage1);
                        int rightmassage_vaue12 = DataCanbus.DATA[174];
                        if (rightmassage_vaue12 < 2) {
                            rightmassage_vaue12++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 8, rightmassage_vaue12}, null, null);
                    }
                    break;
                case R.id.ford_seat_add_2 /* 2131427844 */:
                    if (this.pagenum == 0) {
                        findViewById(R.id.ford_seat_status).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int leftmassage_vaue22 = DataCanbus.DATA[170];
                        if (leftmassage_vaue22 < 2) {
                            leftmassage_vaue22++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 7, leftmassage_vaue22}, null, null);
                    } else if (this.pagenum == 1) {
                        findViewById(R.id.ford_seat_status1).setBackgroundResource(R.drawable.ic_seat_massage2);
                        int rightmassage_vaue22 = DataCanbus.DATA[175];
                        if (rightmassage_vaue22 < 2) {
                            rightmassage_vaue22++;
                        }
                        DataCanbus.PROXY.cmd(11, new int[]{167, 9, rightmassage_vaue22}, null, null);
                    }
                    break;
            }
        } else if (event.getAction() == 1) {
            switch (v.getId()) {
                case R.id.ford_seat_sub1 /* 2131427835 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 0}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub2 /* 2131427836 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 0}, null, null);
                    }
                    break;
                case R.id.ford_seat_sub3 /* 2131427837 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 0}, null, null);
                    }
                    break;
                case R.id.ford_seat_add1 /* 2131427838 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 0, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 3, 0}, null, null);
                    }
                    break;
                case R.id.ford_seat_add2 /* 2131427839 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 1, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 4, 0}, null, null);
                    }
                    break;
                case R.id.ford_seat_add3 /* 2131427840 */:
                    if (this.pagenum == 0) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 2, 0}, null, null);
                    } else if (this.pagenum == 1) {
                        DataCanbus.PROXY.cmd(11, new int[]{167, 5, 0}, null, null);
                    }
                    break;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{100, 0}, null, null);
        isFront = true;
        addNotify();
        if (this.pagenum == 0) {
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#ffffff"));
            return;
        }
        if (this.pagenum == 1) {
            findViewById(R.id.btn_plus2).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button_p);
            findViewById(R.id.btn_plus1).setBackgroundResource(R.drawable.ic_pa_jeep_menu_button);
            ((Button) findViewById(R.id.btn_plus2)).setTextColor(Color.parseColor("#666666"));
            ((Button) findViewById(R.id.btn_plus1)).setTextColor(Color.parseColor("#ffffff"));
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        isFront = false;
        removeNotify();
    }

    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.notifyCanbus, 1);
    }

    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdateSeatValue() {
        int left_vaue1 = DataCanbus.DATA[166];
        int left_vaue2 = DataCanbus.DATA[167];
        int left_vaue3 = DataCanbus.DATA[168];
        int leftmassage_vaue1 = DataCanbus.DATA[169];
        int leftmassage_vaue2 = DataCanbus.DATA[170];
        int right_vaue1 = DataCanbus.DATA[171];
        int right_vaue2 = DataCanbus.DATA[172];
        int right_vaue3 = DataCanbus.DATA[173];
        int rightmassage_vaue1 = DataCanbus.DATA[174];
        int rightmassage_vaue2 = DataCanbus.DATA[175];
        if (this.pagenum == 0) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(left_vaue1)).toString());
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(left_vaue2)).toString());
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(left_vaue3)).toString());
            switch (leftmassage_vaue1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                    break;
            }
            switch (leftmassage_vaue2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                    break;
            }
        }
        if (this.pagenum == 1) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(right_vaue1)).toString());
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(right_vaue2)).toString());
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder(String.valueOf(right_vaue3)).toString());
            switch (rightmassage_vaue1) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText(R.string.klc_air_high);
                    break;
            }
            switch (rightmassage_vaue2) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.off);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_low);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText(R.string.klc_air_high);
                    break;
            }
        }
    }
}
