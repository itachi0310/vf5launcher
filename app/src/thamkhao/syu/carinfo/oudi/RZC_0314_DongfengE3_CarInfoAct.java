package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class RZC_0314_DongfengE3_CarInfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengE3_CarInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 121:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 122:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 123:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 124:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text4)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 125:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text5)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 126:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text6)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 127:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text7)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 128:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 129:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text9)).setText(R.string.str_gs4_common);
                    }
                    break;
                case 130:
                    if (value == 1) {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setTextColor(-65536);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setText(R.string.setting_313_tv51str);
                    } else {
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setTextColor(-16777216);
                        ((TextView) RZC_0314_DongfengE3_CarInfoAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_gs4_common);
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0314_dongfenge3_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(3, new int[]{66}, null, null);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
    }
}
