package com.syu.carinfo.xp.ziyouguang;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class PAJeepDynoEngineAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.PAJeepDynoEngineAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 339:
                    if (((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)) != null) {
                        int gear = value & 15;
                        switch (gear) {
                            case 0:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("---");
                                break;
                            case 1:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("P");
                                break;
                            case 2:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("R");
                                break;
                            case 3:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("N");
                                break;
                            case 4:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D");
                                break;
                            case 5:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D1");
                                break;
                            case 6:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D2");
                                break;
                            case 7:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D3");
                                break;
                            case 8:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D4");
                                break;
                            case 9:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D5");
                                break;
                            case 10:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D6");
                                break;
                            case 11:
                                ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text12)).setText("D7");
                                break;
                        }
                    }
                    break;
                case 340:
                    if (((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text10)) != null) {
                        int speed = value & 16383;
                        if (((value >> 14) & 3) == 1) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(speed)).toString());
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text11)).setText("mph");
                        } else {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder(String.valueOf(speed)).toString());
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text11)).setText("km/h");
                        }
                    }
                    break;
                case 341:
                    if (((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text3)) != null) {
                        int unit = (value >> 14) & 3;
                        int temp = value & 16383;
                        if (unit == 1) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text2)).setText("Kpa");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text14)).setText("Kpa");
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(temp);
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        } else if (unit == 2) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text2)).setText("Bar");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text14)).setText("Bar");
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(temp);
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        } else {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text2)).setText("PSI");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text3)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text13)).setText(String.valueOf(temp / 10) + "." + (temp % 10));
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text14)).setText("PSI");
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).setProgress(temp);
                            ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar1)).invalidate();
                        }
                    }
                    break;
                case 342:
                    if (((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text6)) != null) {
                        int temp2 = value & 16383;
                        if (((value >> 14) & 3) == 1) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text5)).setText("Nm");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text16)).setText("Nm");
                        } else {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text5)).setText("lb-ft");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text16)).setText("lb-ft");
                        }
                        ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(temp2)).toString());
                        ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(temp2)).toString());
                        ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar2)).setProgress(temp2);
                        ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar2)).invalidate();
                    }
                    break;
                case 343:
                    if (((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text9)) != null) {
                        int temp3 = value & 16383;
                        int unit2 = (value >> 14) & 3;
                        if (unit2 == 1) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text8)).setText("hp(UK)");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text18)).setText("hp(UK)");
                        } else if (unit2 == 2) {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text8)).setText("KW");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text18)).setText("KW");
                        } else {
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text8)).setText("hp(US)");
                            ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text18)).setText("hp(US)");
                        }
                        ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text9)).setText(new StringBuilder(String.valueOf(temp3)).toString());
                        ((TextView) PAJeepDynoEngineAct.this.findViewById(R.id.tv_text17)).setText(new StringBuilder(String.valueOf(temp3)).toString());
                        ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar3)).setProgress(temp3);
                        ((ProgressBar) PAJeepDynoEngineAct.this.findViewById(R.id.pa_jeep_seekbar3)).invalidate();
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0374_pa_jeep_dyno_engine);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(4, new int[]{90}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[339].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[340].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[341].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[342].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[343].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[339].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[340].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[341].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[342].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[343].removeNotify(this.mNotifyCanbus);
    }
}
