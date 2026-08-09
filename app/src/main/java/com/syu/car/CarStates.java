package com.syu.car;

import android.content.Context;
import com.syu.ipc.data.FinalCanbus;
import com.syu.remote.Callback;
import com.syu.remote.RemoteTools;
import java.util.ArrayList;
import java.util.List;

/**
 * Port of CarStates from launcher17.
 * Centralized repository for car and module states.
 */
public class CarStates {
    public static int mCanbusType;
    private static CarStates mCar;
    private final Context mContext;
    public RemoteTools mTools;
    
    public static int mAppID = 0;
    public static int mAccState = 0;
    public static int mExistCarRadio = 0;

    // Standard SYU module update codes
    final int[] MAIN_LOOK_CODE = {0, 28, 39, 50, 4, 101, 114, 115};
    final int[] CANBUS_LOOK_CODE = {1000, FinalCanbus.U_EXIST_CAR_RADIO, 114, 113, 115, 116, 109, 110};
    final int[] RADIO_LOOK_CODE = {0, 1, 2, 20, 23, 21};
    final int[] BT_LOOK_CODE = {0, 1, 2, 28, 26, 13, 9};
    final int[] SOUND_LOOK_CODE = {2, 3};

    public static CarStates getCar(Context context) {
        if (mCar == null) {
            mCar = new CarStates(context);
        }
        return mCar;
    }

    private CarStates(Context context) {
        this.mContext = context.getApplicationContext();
        this.mTools = new RemoteTools(this.mContext);
        
        setupMainModule(this.mTools);
        setupcanbusModule(this.mTools);
        setupRadioModule(this.mTools);
        setupBtModule(this.mTools);
        
        this.mTools.bind();
    }

    private void setupMainModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(0, this.MAIN_LOOK_CODE);
            tools.enableModule(4, this.SOUND_LOOK_CODE);
            tools.addRefreshLisenter(0, (updateCode, ints, flts, strs) -> {
                if (updateCode == 0) {
                    if (ints != null && ints.length > 0) mAppID = ints[0];
                } else if (updateCode == 50) {
                    if (ints != null && ints.length > 0) mAccState = ints[0];
                }
                
                // Pack updateCode into ints for the notifier
                int[] data = (ints != null) ? new int[ints.length + 1] : new int[1];
                data[0] = updateCode;
                if (ints != null) System.arraycopy(ints, 0, data, 1, ints.length);
                
                com.fyt.car.LauncherNotify.NOTIFY_MAINSTATE.set(data, null, flts, strs, null);
            }, this.MAIN_LOOK_CODE);
        }
    }

    private void setupcanbusModule(RemoteTools tools) {
        if (tools != null) {
            tools.enableModule(7, this.CANBUS_LOOK_CODE);
            tools.addRefreshLisenter(7, (updateCode, ints, flts, strs) -> {
                if (updateCode == 1000) {
                    if (ints != null && ints.length > 0) mCanbusType = ints[0];
                } else if (updateCode == FinalCanbus.U_EXIST_CAR_RADIO) {
                    if (ints != null && ints.length > 0) mExistCarRadio = ints[0];
                }
                
                // Pack updateCode into ints for the notifier
                int[] data = (ints != null) ? new int[ints.length + 1] : new int[1];
                data[0] = updateCode;
                if (ints != null) System.arraycopy(ints, 0, data, 1, ints.length);
                
                com.fyt.car.LauncherNotify.NOTIFIER_REGEN_DATA.set(data, null, flts, strs, null);
            }, this.CANBUS_LOOK_CODE);
        }
    }

    private void setupRadioModule(RemoteTools tools) {
        if (tools != null) tools.enableModule(1, this.RADIO_LOOK_CODE);
    }

    private void setupBtModule(RemoteTools tools) {
        if (tools != null) tools.enableModule(2, this.BT_LOOK_CODE);
    }

    public RemoteTools getTools() {
        return this.mTools;
    }
}
