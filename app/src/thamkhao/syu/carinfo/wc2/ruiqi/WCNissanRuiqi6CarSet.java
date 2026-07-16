package com.syu.carinfo.wc2.ruiqi;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WCNissanRuiqi6CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ruiqi.WCNissanRuiqi6CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 113:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 114:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 115:
                    ((CheckedTextView) WCNissanRuiqi6CarSet.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_nissan_ruiqi_settings);
        setListener();
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427530 */:
                int value = DataCanbus.DATA[112];
                if (value == 0) {
                    value = 1;
                } else if (value == 1) {
                    value = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{1, value}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427546 */:
                int value2 = DataCanbus.DATA[113];
                if (value2 == 0) {
                    value2 = 1;
                } else if (value2 == 1) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{2, value2}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427547 */:
                int value3 = DataCanbus.DATA[114];
                if (value3 == 0) {
                    value3 = 1;
                } else if (value3 == 1) {
                    value3 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{3, value3}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427549 */:
                int value4 = DataCanbus.DATA[115];
                if (value4 == 0) {
                    value4 = 1;
                } else if (value4 == 1) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(0, new int[]{4, value4}, null, null);
                break;
        }
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
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }
}
