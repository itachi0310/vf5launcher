package com.syu.carinfo.rzc.klc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZCKlcEVCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.klc.RZCKlcEVCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 129:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text1)).setText(R.string.str_have);
                    }
                    break;
                case 130:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text2)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text2)).setText(R.string.str_have);
                    }
                    break;
                case 131:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text3)).setText(R.string.str_have);
                    }
                    break;
                case 132:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text4)).setText(R.string.str_have);
                    }
                    break;
                case 133:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text5)).setText(R.string.str_have);
                    }
                    break;
                case 134:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text6)).setText(R.string.str_have);
                    }
                    break;
                case 135:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text7)).setText(R.string.str_have);
                    }
                    break;
                case 136:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.str_have);
                    }
                    break;
                case 137:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.str_have);
                    }
                    break;
                case 138:
                    if (value == 0) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.crv_source_null);
                    } else if (value == 1) {
                        ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text10)).setText(R.string.str_have);
                    }
                    break;
                case 139:
                    ((TextView) RZCKlcEVCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0061_rzc_gm_ev_carinfo);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        v.getId();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
    }
}
