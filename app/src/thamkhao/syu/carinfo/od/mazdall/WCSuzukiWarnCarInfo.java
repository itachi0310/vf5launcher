package com.syu.carinfo.od.mazdall;

import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WCSuzukiWarnCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.od.mazdall.WCSuzukiWarnCarInfo.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 154:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view1).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn1_p : R.drawable.ic_suzuki_warn1_n);
                    break;
                case 155:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view2).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn2_p : R.drawable.ic_suzuki_warn2_n);
                    break;
                case 156:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view3).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn3_p : R.drawable.ic_suzuki_warn3_n);
                    break;
                case 157:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view4).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn4_p : R.drawable.ic_suzuki_warn4_n);
                    break;
                case 158:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view5).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn5_p : R.drawable.ic_suzuki_warn5_n);
                    break;
                case 159:
                    WCSuzukiWarnCarInfo.this.findViewById(R.id.layout_view6).setBackgroundResource(value == 1 ? R.drawable.ic_suzuki_warn6_p : R.drawable.ic_suzuki_warn6_n);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc_suzuki_warn_carinfo);
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
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
    }
}
