package com.syu.carinfo.xp.ziyouguang;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.adapter.AdapterCarInfo;
import com.syu.canbus.R;
import com.syu.entity.CarInfo;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0374_XP1_ZiYouGuang;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Activity_374_AUXSettings extends Activity {
    AdapterCarInfo adapter;
    List<CarInfo> mList = new ArrayList();
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.xp.ziyouguang.Activity_374_AUXSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Activity_374_AUXSettings.this.adapter.setValue(updateCode, DataCanbus.DATA[updateCode]);
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        initValue();
        this.adapter = new AdapterCarInfo(this, this.mList);
        ((ListView) findViewById(R.id.list_carinfo)).setAdapter((ListAdapter) this.adapter);
        ((TextView) findViewById(R.id.tv_car_title)).setVisibility(0);
        ((TextView) findViewById(R.id.tv_car_title)).setText(R.string.str_aux_settings);
    }

    private void initValue() {
        CarInfo carInfo = new CarInfo(1, 307, R.string.str_aux1_type);
        carInfo.setCmd(0, Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B3);
        carInfo.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo);
        CarInfo carInfo2 = new CarInfo(1, 308, R.string.str_aux1_power_source);
        carInfo2.setCmd(0, Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B4);
        carInfo2.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo2);
        CarInfo carInfo3 = new CarInfo(0, 309, R.string.str_aux1_recalled_last_state);
        carInfo3.setCmd(0, Callback_0374_XP1_ZiYouGuang.U_CARRADIO_D12_D0_B5);
        this.mList.add(carInfo3);
        CarInfo carInfo4 = new CarInfo(1, 310, R.string.str_aux2_type);
        carInfo4.setCmd(0, 743);
        carInfo4.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo4);
        CarInfo carInfo5 = new CarInfo(1, 311, R.string.str_aux2_power_source);
        carInfo5.setCmd(0, 744);
        carInfo5.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo5);
        CarInfo carInfo6 = new CarInfo(0, 312, R.string.str_aux2_recalled_last_state);
        carInfo6.setCmd(0, 745);
        this.mList.add(carInfo6);
        CarInfo carInfo7 = new CarInfo(1, 313, R.string.str_aux3_type);
        carInfo7.setCmd(0, 999);
        carInfo7.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo7);
        CarInfo carInfo8 = new CarInfo(1, 314, R.string.str_aux3_power_source);
        carInfo8.setCmd(0, 1000);
        carInfo8.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo8);
        CarInfo carInfo9 = new CarInfo(0, 315, R.string.str_aux3_recalled_last_state);
        carInfo9.setCmd(0, FinalCanbus.U_AIR_WINDOW_ENABLE);
        this.mList.add(carInfo9);
        CarInfo carInfo10 = new CarInfo(1, 316, R.string.str_aux4_type);
        carInfo10.setCmd(0, 1255);
        carInfo10.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo10);
        CarInfo carInfo11 = new CarInfo(1, 317, R.string.str_aux4_power_source);
        carInfo11.setCmd(0, 1256);
        carInfo11.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo11);
        CarInfo carInfo12 = new CarInfo(0, Callback_0374_XP1_ZiYouGuang.U_CARSET_D40_DE0_D2_B6, R.string.str_aux4_recalled_last_state);
        carInfo12.setCmd(0, 1257);
        this.mList.add(carInfo12);
        CarInfo carInfo13 = new CarInfo(1, 385, R.string.str_aux5_type);
        carInfo13.setCmd(0, 1511);
        carInfo13.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo13);
        CarInfo carInfo14 = new CarInfo(1, 386, R.string.str_aux5_power_source);
        carInfo14.setCmd(0, 1512);
        carInfo14.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo14);
        CarInfo carInfo15 = new CarInfo(0, 387, R.string.str_aux5_recalled_last_state);
        carInfo15.setCmd(0, 1513);
        this.mList.add(carInfo15);
        CarInfo carInfo16 = new CarInfo(1, 388, R.string.str_aux6_type);
        carInfo16.setCmd(0, 1767);
        carInfo16.setDiplsys(new String[]{"Latching", "Momentary"});
        this.mList.add(carInfo16);
        CarInfo carInfo17 = new CarInfo(1, 389, R.string.str_aux6_power_source);
        carInfo17.setCmd(0, 1768);
        carInfo17.setDiplsys(new String[]{"Battery", "Ignition"});
        this.mList.add(carInfo17);
        CarInfo carInfo18 = new CarInfo(0, 390, R.string.str_aux6_recalled_last_state);
        carInfo18.setCmd(0, 1769);
        this.mList.add(carInfo18);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    private void addNotify() {
        DataCanbus.NOTIFY_EVENTS[307].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[308].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[309].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[310].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[312].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[313].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[314].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[316].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[317].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[318].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[385].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[386].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[387].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[388].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[389].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[390].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[307].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[308].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[309].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[310].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[312].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[313].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[314].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[316].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[317].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[318].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[385].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[386].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[387].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[388].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[389].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[390].removeNotify(this.mNotifyCanbus);
    }
}
