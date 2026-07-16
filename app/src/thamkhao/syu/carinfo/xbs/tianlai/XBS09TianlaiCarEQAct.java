package com.syu.carinfo.xbs.tianlai;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class XBS09TianlaiCarEQAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarEQAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (DataCanbus.DATA[1000] == 458942) {
                switch (updateCode) {
                    case 134:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                        break;
                    case 135:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                        break;
                    case 136:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                        break;
                    case 137:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                        break;
                    case 139:
                        XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                        break;
                }
            }
            switch (updateCode) {
                case 134:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBas();
                    break;
                case 135:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQTreb();
                    break;
                case 136:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQFad();
                    break;
                case 137:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQBal();
                    break;
                case 139:
                    XBS09TianlaiCarEQAct.this.mUpdaterEQVol();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            String platform = SystemProperties.get("ro.fyt.platform", "");
            if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform)) {
                setContentView(R.layout.layout_xbs_09tianlai_caraudio_9853);
            } else {
                setContentView(R.layout.layout_xbs_09tianlai_caraudio);
            }
        } else {
            setContentView(R.layout.layout_xbs_09tianlai_caraudio);
        }
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        if (DataCanbus.DATA[1000] == 458942) {
            DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
            return;
        }
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQVol() {
        int value = DataCanbus.DATA[139];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[139];
        }
        ((TextView) findViewById(R.id.dj_lexus_audio_vol)).setText(new StringBuilder().append(value).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQBal() {
        int value = DataCanbus.DATA[137];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[137];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("R" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_ban)).setText("L" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQFad() {
        int value = DataCanbus.DATA[136];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[136];
        }
        if (value > 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("F" + (value - 7));
        } else if (value == 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("0");
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_fad)).setText("R" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQTreb() {
        int value = DataCanbus.DATA[135];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[135];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_treb)).setText("-" + (7 - value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEQBas() {
        int value = DataCanbus.DATA[134];
        if (DataCanbus.DATA[1000] == 458942) {
            value = DataCanbus.DATA[134];
        }
        if (value >= 7) {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText(new StringBuilder(String.valueOf(value - 7)).toString());
        } else {
            ((TextView) findViewById(R.id.dj_lexus_audio_bass)).setText("-" + (7 - value));
        }
    }
}
