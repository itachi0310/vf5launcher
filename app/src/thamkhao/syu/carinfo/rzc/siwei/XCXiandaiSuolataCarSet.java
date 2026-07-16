package com.syu.carinfo.rzc.siwei;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class XCXiandaiSuolataCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.siwei.XCXiandaiSuolataCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 94:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                    }
                    break;
                case 95:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        if (val == 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text2)).setText("0");
                        } else if (val < 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text2)).setText("L" + (10 - val));
                        } else if (val > 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text2)).setText("R" + (val - 10));
                        }
                    }
                    break;
                case 96:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (val == 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text3)).setText("0");
                        } else if (val < 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text3)).setText("F" + (10 - val));
                        } else if (val > 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text3)).setText("R" + (val - 10));
                        }
                    }
                    break;
                case 97:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        if (val < 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text4)).setText("-" + (10 - val));
                        } else if (val >= 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val - 10).toString());
                        }
                    }
                    break;
                case 98:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        if (val < 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text5)).setText("-" + (10 - val));
                        } else if (val >= 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val - 10).toString());
                        }
                    }
                    break;
                case 99:
                    if (((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        if (val < 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text6)).setText("-" + (10 - val));
                        } else if (val >= 10) {
                            ((TextView) XCXiandaiSuolataCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val - 10).toString());
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_xc_xiandaisuolata_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int vol = DataCanbus.DATA[94];
                int bal = DataCanbus.DATA[95];
                int fad = DataCanbus.DATA[96];
                int bass = DataCanbus.DATA[97];
                int mid = DataCanbus.DATA[98];
                int treb = DataCanbus.DATA[99];
                if (vol > 0) {
                    vol--;
                }
                setCarInfo(vol, bal, fad, bass, mid, treb, 0);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int vol2 = DataCanbus.DATA[94];
                int bal2 = DataCanbus.DATA[95];
                int fad2 = DataCanbus.DATA[96];
                int bass2 = DataCanbus.DATA[97];
                int mid2 = DataCanbus.DATA[98];
                int treb2 = DataCanbus.DATA[99];
                if (vol2 < 38) {
                    vol2++;
                }
                setCarInfo(vol2, bal2, fad2, bass2, mid2, treb2, 0);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int vol3 = DataCanbus.DATA[94];
                int bal3 = DataCanbus.DATA[95];
                int fad3 = DataCanbus.DATA[96];
                int bass3 = DataCanbus.DATA[97];
                int mid3 = DataCanbus.DATA[98];
                int treb3 = DataCanbus.DATA[99];
                if (bal3 > 0) {
                    bal3--;
                }
                setCarInfo(vol3, bal3, fad3, bass3, mid3, treb3, 0);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int vol4 = DataCanbus.DATA[94];
                int bal4 = DataCanbus.DATA[95];
                int fad4 = DataCanbus.DATA[96];
                int bass4 = DataCanbus.DATA[97];
                int mid4 = DataCanbus.DATA[98];
                int treb4 = DataCanbus.DATA[99];
                if (bal4 < 19) {
                    bal4++;
                }
                setCarInfo(vol4, bal4, fad4, bass4, mid4, treb4, 0);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int vol5 = DataCanbus.DATA[94];
                int bal5 = DataCanbus.DATA[95];
                int fad5 = DataCanbus.DATA[96];
                int bass5 = DataCanbus.DATA[97];
                int mid5 = DataCanbus.DATA[98];
                int treb5 = DataCanbus.DATA[99];
                if (fad5 > 0) {
                    fad5--;
                }
                setCarInfo(vol5, bal5, fad5, bass5, mid5, treb5, 0);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int vol6 = DataCanbus.DATA[94];
                int bal6 = DataCanbus.DATA[95];
                int fad6 = DataCanbus.DATA[96];
                int bass6 = DataCanbus.DATA[97];
                int mid6 = DataCanbus.DATA[98];
                int treb6 = DataCanbus.DATA[99];
                if (fad6 < 19) {
                    fad6++;
                }
                setCarInfo(vol6, bal6, fad6, bass6, mid6, treb6, 0);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int vol7 = DataCanbus.DATA[94];
                int bal7 = DataCanbus.DATA[95];
                int fad7 = DataCanbus.DATA[96];
                int bass7 = DataCanbus.DATA[97];
                int mid7 = DataCanbus.DATA[98];
                int treb7 = DataCanbus.DATA[99];
                if (bass7 > 0) {
                    bass7--;
                }
                setCarInfo(vol7, bal7, fad7, bass7, mid7, treb7, 0);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int vol8 = DataCanbus.DATA[94];
                int bal8 = DataCanbus.DATA[95];
                int fad8 = DataCanbus.DATA[96];
                int bass8 = DataCanbus.DATA[97];
                int mid8 = DataCanbus.DATA[98];
                int treb8 = DataCanbus.DATA[99];
                if (bass8 < 19) {
                    bass8++;
                }
                setCarInfo(vol8, bal8, fad8, bass8, mid8, treb8, 0);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int vol9 = DataCanbus.DATA[94];
                int bal9 = DataCanbus.DATA[95];
                int fad9 = DataCanbus.DATA[96];
                int bass9 = DataCanbus.DATA[97];
                int mid9 = DataCanbus.DATA[98];
                int treb9 = DataCanbus.DATA[99];
                if (mid9 > 0) {
                    mid9--;
                }
                setCarInfo(vol9, bal9, fad9, bass9, mid9, treb9, 0);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int vol10 = DataCanbus.DATA[94];
                int bal10 = DataCanbus.DATA[95];
                int fad10 = DataCanbus.DATA[96];
                int bass10 = DataCanbus.DATA[97];
                int mid10 = DataCanbus.DATA[98];
                int treb10 = DataCanbus.DATA[99];
                if (mid10 < 19) {
                    mid10++;
                }
                setCarInfo(vol10, bal10, fad10, bass10, mid10, treb10, 0);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int vol11 = DataCanbus.DATA[94];
                int bal11 = DataCanbus.DATA[95];
                int fad11 = DataCanbus.DATA[96];
                int bass11 = DataCanbus.DATA[97];
                int mid11 = DataCanbus.DATA[98];
                int treb11 = DataCanbus.DATA[99];
                if (treb11 > 0) {
                    treb11--;
                }
                setCarInfo(vol11, bal11, fad11, bass11, mid11, treb11, 0);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int vol12 = DataCanbus.DATA[94];
                int bal12 = DataCanbus.DATA[95];
                int fad12 = DataCanbus.DATA[96];
                int bass12 = DataCanbus.DATA[97];
                int mid12 = DataCanbus.DATA[98];
                int treb12 = DataCanbus.DATA[99];
                if (treb12 < 19) {
                    treb12++;
                }
                setCarInfo(vol12, bal12, fad12, bass12, mid12, treb12, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3, int value4, int value5, int value6) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1, value2, value3, value4, value5, value6}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
