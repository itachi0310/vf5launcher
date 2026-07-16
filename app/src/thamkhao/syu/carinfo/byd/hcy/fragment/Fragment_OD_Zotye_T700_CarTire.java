package com.syu.carinfo.byd.hcy.fragment;

import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class Fragment_OD_Zotye_T700_CarTire extends BaseFragment implements View.OnClickListener {
    int[] ids = {94, 95, 96, 97, 98, 99, 100, 101, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121};
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.Fragment_OD_Zotye_T700_CarTire.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 94:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFL();
                    break;
                case 95:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireFR();
                    break;
                case 96:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRL();
                    break;
                case 97:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTireRR();
                    break;
                case 98:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFL();
                    break;
                case 99:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempFR();
                    break;
                case 100:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRL();
                    break;
                case 101:
                    Fragment_OD_Zotye_T700_CarTire.this.mUpdaterTempRR();
                    break;
                case 110:
                case 111:
                case 112:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFLWalm();
                    break;
                case 113:
                case 114:
                case 115:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterFRWalm();
                    break;
                case 116:
                case 117:
                case 118:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRLWalm();
                    break;
                case 119:
                case 120:
                case 121:
                    Fragment_OD_Zotye_T700_CarTire.this.updaterRRWalm();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseFragment
    public void initView() {
    }

    @Override // com.syu.canbus.BaseFragment
    public void initListener() {
    }

    @Override // com.syu.canbus.BaseFragment
    public int getViewLayout() {
        return TheApp.getConfiguration() == 1 ? R.layout.layout_xbs_tule_tire : R.layout.layout_oudi_zt_t600_tire;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.PROXY.cmd(2, new int[]{56, 0}, null, null);
        DataCanbus.PROXY.cmd(2, new int[]{57, 0}, null, null);
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(this.mNotifyCanbus, 1);
        }
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        for (int i : this.ids) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.mNotifyCanbus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[110];
        int value = DataCanbus.DATA[111];
        int value1 = DataCanbus.DATA[112];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[113];
        int value = DataCanbus.DATA[114];
        int value1 = DataCanbus.DATA[115];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[116];
        int value = DataCanbus.DATA[117];
        int value1 = DataCanbus.DATA[118];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[119];
        int value = DataCanbus.DATA[120];
        int value1 = DataCanbus.DATA[121];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.zt_t600_car_system_band);
            return;
        }
        if (value == 0 && value1 == 0) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        } else if (value1 == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str01);
        } else if (value == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.xp_yinglang_tire_str02);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFL() {
        int value = DataCanbus.DATA[98];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire1_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempFR() {
        int value = DataCanbus.DATA[99];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire2_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRL() {
        int value = DataCanbus.DATA[100];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire3_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTempRR() {
        int value = DataCanbus.DATA[101];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4_temp)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire4_temp)).setText(String.valueOf(value - 40) + "℃");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[94];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[95];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[96];
        if (value == 255) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[97];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4)) != null) {
            DecimalFormat df = new DecimalFormat("#.#");
            ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(df.format(((int) ((value * 1.373f) * 100.0f)) / 100.0f)) + "kPa");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
