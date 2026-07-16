package com.syu.carinfo.wc.jianghuai;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WcJianghuaiIEV6ETireAct extends BaseActivity {
    AlertDialog dialog;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.jianghuai.WcJianghuaiIEV6ETireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 95:
                    WcJianghuaiIEV6ETireAct.this.updaterTempFL();
                    break;
                case 96:
                    WcJianghuaiIEV6ETireAct.this.updaterTempFR();
                    break;
                case 97:
                    WcJianghuaiIEV6ETireAct.this.updaterTempRL();
                    break;
                case 98:
                    WcJianghuaiIEV6ETireAct.this.updaterTempRR();
                    break;
                case 99:
                    WcJianghuaiIEV6ETireAct.this.mUpdaterTireFL();
                    break;
                case 100:
                    WcJianghuaiIEV6ETireAct.this.mUpdaterTireFR();
                    break;
                case 101:
                    WcJianghuaiIEV6ETireAct.this.mUpdaterTireRL();
                    break;
                case 102:
                    WcJianghuaiIEV6ETireAct.this.mUpdaterTireRR();
                    break;
                case 103:
                case 104:
                case 105:
                case 106:
                    WcJianghuaiIEV6ETireAct.this.updateTireWarns(DataCanbus.DATA[updateCode] & 255);
                    break;
                case 107:
                    WcJianghuaiIEV6ETireAct.this.updateTireState(DataCanbus.DATA[updateCode]);
                    break;
            }
        }
    };
    private int[] resIdTireState = {R.string.str_wc_rfs2_1, R.string.str_wc_rfs2_2, R.string.str_wc_rfs2_3};
    private int[] resIdTireWarn = {R.string.str_wc_rfs2_4, R.string.str_wc_rfs2_5, R.string.str_wc_rfs2_6, R.string.str_wc_rfs2_7, R.string.str_wc_rfs2_8, R.string.str_wc_rfs2_9, R.string.str_wc_rfs2_10, R.string.str_wc_rfs2_11};
    private int[] resIdTirePosition = {R.string.str_wc_rfs2_12, R.string.str_wc_rfs2_13, R.string.str_wc_rfs2_14, R.string.str_wc_rfs2_15};
    private int[] resIdTire_Update = {103, 104, 105, 106};
    ArrayList<String> strArrayWarn = new ArrayList<>();

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (TheApp.getConfiguration() == 1) {
            setContentView(R.layout.layout_xbs_tule_tire);
        } else {
            setContentView(R.layout.layout_oudi_zt_t600_tire);
        }
        if (this.dialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setAdapter(new ArrayAdapter(this, R.layout.simple_textview_item, this.strArrayWarn), null);
            this.dialog = builder.create();
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFL() {
        int value = DataCanbus.DATA[95];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire1_temp)).setText(String.format("%d ℃", Integer.valueOf(value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempFR() {
        int value = DataCanbus.DATA[96];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire2_temp)).setText(String.format("%d ℃", Integer.valueOf(value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRL() {
        int value = DataCanbus.DATA[97];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire3_temp)).setText(String.format("%d ℃", Integer.valueOf(value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTempRR() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText("--");
        } else {
            ((TextView) findViewById(R.id.oudi_changan_tire4_temp)).setText(String.format("%d ℃", Integer.valueOf(value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[101];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[102];
        if (value == 255) {
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findViewById(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findViewById(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(value / 10.0f)) + "bar");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireState(int i) {
        if (((TextView) findViewById(R.id.oudi_changan_tire_title)) != null) {
            ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText("");
            for (int j = 0; j < this.resIdTireState.length; j++) {
                int d = (i >> (2 - j)) & 1;
                if (d != 0) {
                    ((TextView) findViewById(R.id.oudi_changan_tire_title)).setText(this.resIdTireState[j]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTireWarns(int i) {
        this.strArrayWarn.clear();
        int index = 0;
        for (int n = 0; n < this.resIdTire_Update.length; n++) {
            int data = DataCanbus.DATA[this.resIdTire_Update[n]] & 255;
            for (int j = 7; j >= 0; j--) {
                int pos = (data >> j) & 1;
                String str = getString(this.resIdTireWarn[7 - j], new Object[]{getString(this.resIdTirePosition[n])});
                if (pos == 1) {
                    if (!this.strArrayWarn.contains(str)) {
                        index++;
                        this.strArrayWarn.add(String.valueOf(index) + " . " + str);
                    }
                } else {
                    this.strArrayWarn.remove(str);
                }
            }
        }
        showWarnDlg();
    }

    @SuppressLint({"NewApi"})
    private void showWarnDlg() {
        if (this.strArrayWarn.size() != 0) {
            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
            WindowManager.LayoutParams attributes = this.dialog.getWindow().getAttributes();
            attributes.height = 400;
            attributes.width = 600;
            this.dialog.getWindow().setAttributes(attributes);
            this.dialog.show();
            return;
        }
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
    }
}
