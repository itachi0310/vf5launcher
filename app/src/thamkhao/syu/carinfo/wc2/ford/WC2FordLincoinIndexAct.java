package com.syu.carinfo.wc2.ford;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class WC2FordLincoinIndexAct extends BaseActivity {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0443_wc2_ford_lincoin_index_act);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.id_amp_info).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinAmpInfoAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_car_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarSettingsAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_cd_control).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCdAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_car_radio).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinCarRadioAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        findViewById(R.id.id_factory_settings).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinIndexAct.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(WC2FordLincoinIndexAct.this, WC2FordLincoinFactoryPwdAct.class);
                WC2FordLincoinIndexAct.this.startActivity(intent);
            }
        });
        if (DataCanbus.DATA[1000] == 4981179 || DataCanbus.DATA[1000] == 5571003) {
            findViewById(R.id.rl_cd_control).setVisibility(8);
            return;
        }
        if (DataCanbus.DATA[1000] == 5177787 || DataCanbus.DATA[1000] == 6685115 || DataCanbus.DATA[1000] == 15401403 || DataCanbus.DATA[1000] == 15729083 || DataCanbus.DATA[1000] == 15794619 || DataCanbus.DATA[1000] == 15860155 || DataCanbus.DATA[1000] == 15991227 || DataCanbus.DATA[1000] == 15925691 || DataCanbus.DATA[1000] == 16056763 || DataCanbus.DATA[1000] == 16122299 || DataCanbus.DATA[1000] == 16187835 || DataCanbus.DATA[1000] == 16253371 || DataCanbus.DATA[1000] == 16318907 || DataCanbus.DATA[1000] == 16384443) {
            findViewById(R.id.rl_cd_control).setVisibility(8);
            findViewById(R.id.rl_car_radio).setVisibility(8);
        }
    }
}
