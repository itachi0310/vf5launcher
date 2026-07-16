package com.syu.carinfo.byd.hcy.fragment;

import android.widget.TextView;
import com.syu.canbus.BaseFragment;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class XBSBydSongTireAct extends BaseFragment {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.byd.hcy.fragment.XBSBydSongTireAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 121:
                    XBSBydSongTireAct.this.mUpdaterTireFL();
                    break;
                case 122:
                    XBSBydSongTireAct.this.mUpdaterTireFR();
                    break;
                case 123:
                    XBSBydSongTireAct.this.mUpdaterTireRL();
                    break;
                case 124:
                    XBSBydSongTireAct.this.mUpdaterTireRR();
                    break;
                case 125:
                    XBSBydSongTireAct.this.updaterFLWalm();
                    break;
                case 126:
                    XBSBydSongTireAct.this.updaterFRWalm();
                    break;
                case 127:
                    XBSBydSongTireAct.this.updaterRLWalm();
                    break;
                case 128:
                    XBSBydSongTireAct.this.updaterRRWalm();
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
        return R.layout.layout_oudi_zt_t600_tire;
    }

    @Override // com.syu.canbus.BaseFragment
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseFragment
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFL() {
        int value = DataCanbus.DATA[121];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire1)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire1)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireFR() {
        int value = DataCanbus.DATA[122];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire2)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire2)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRL() {
        int value = DataCanbus.DATA[123];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire3)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire3)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTireRR() {
        int value = DataCanbus.DATA[124];
        if (value == 65535) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText("--.--");
        } else if (((TextView) findView(R.id.oudi_changan_tire4)) != null) {
            ((TextView) findView(R.id.oudi_changan_tire4)).setText(String.valueOf(value) + "Kpa");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFLWalm() {
        int system = DataCanbus.DATA[125];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire1_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterFRWalm() {
        int system = DataCanbus.DATA[126];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire2_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRLWalm() {
        int system = DataCanbus.DATA[127];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire3_warn)).setText(R.string.tireflnormal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterRRWalm() {
        int system = DataCanbus.DATA[128];
        if (system == 1) {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflalarm);
        } else {
            ((TextView) findView(R.id.oudi_changan_tire4_warn)).setText(R.string.tireflnormal);
        }
    }
}
