package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZCXiandaiAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.RZCXiandaiAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text1)).setText("0");
                        }
                    }
                    break;
                case 95:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        }
                    }
                    break;
                case 96:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value > 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("+" + (value - 10));
                        } else if (value < 10) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("-" + (10 - value));
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        }
                    }
                    break;
                case 97:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (value > 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("F" + (7 - value));
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text5)).setText("0");
                        }
                    }
                    break;
                case 98:
                    if (((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (value > 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("R" + (value - 7));
                        } else if (value < 7) {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("L" + (7 - value));
                        } else {
                            ((TextView) RZCXiandaiAmpCarSet.this.findViewById(R.id.tv_text4)).setText("0");
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0362_rzc_xiandai_amp_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int bass = DataCanbus.DATA[94];
                int mid = DataCanbus.DATA[95];
                int treb = DataCanbus.DATA[96];
                if (bass > 0) {
                    bass--;
                }
                setCarInfo(bass, mid, treb);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int bass2 = DataCanbus.DATA[94];
                int mid2 = DataCanbus.DATA[95];
                int treb2 = DataCanbus.DATA[96];
                if (bass2 < 20) {
                    bass2++;
                }
                setCarInfo(bass2, mid2, treb2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int bass3 = DataCanbus.DATA[94];
                int mid3 = DataCanbus.DATA[95];
                int treb3 = DataCanbus.DATA[96];
                if (mid3 > 0) {
                    mid3--;
                }
                setCarInfo(bass3, mid3, treb3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int bass4 = DataCanbus.DATA[94];
                int mid4 = DataCanbus.DATA[95];
                int treb4 = DataCanbus.DATA[96];
                if (mid4 < 20) {
                    mid4++;
                }
                setCarInfo(bass4, mid4, treb4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int bass5 = DataCanbus.DATA[94];
                int mid5 = DataCanbus.DATA[95];
                int treb5 = DataCanbus.DATA[96];
                if (treb5 > 0) {
                    treb5--;
                }
                setCarInfo(bass5, mid5, treb5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int bass6 = DataCanbus.DATA[94];
                int mid6 = DataCanbus.DATA[95];
                int treb6 = DataCanbus.DATA[96];
                if (treb6 < 20) {
                    treb6++;
                }
                setCarInfo(bass6, mid6, treb6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int bal = DataCanbus.DATA[98];
                int fad = DataCanbus.DATA[97];
                if (bal > 0) {
                    bal--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad, bal}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int bal2 = DataCanbus.DATA[98];
                int fad2 = DataCanbus.DATA[97];
                if (bal2 < 14) {
                    bal2++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad2, bal2}, null, null);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int bal3 = DataCanbus.DATA[98];
                int fad3 = DataCanbus.DATA[97];
                if (fad3 > 0) {
                    fad3--;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad3, bal3}, null, null);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int bal4 = DataCanbus.DATA[98];
                int fad4 = DataCanbus.DATA[97];
                if (fad4 < 14) {
                    fad4++;
                }
                DataCanbus.PROXY.cmd(3, new int[]{fad4, bal4}, null, null);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
    }
}
