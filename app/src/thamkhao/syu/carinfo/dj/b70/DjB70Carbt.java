package com.syu.carinfo.dj.b70;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.Callback_0271_DJ_BENGTENG14B70;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.main.DataMain;

/* JADX INFO: loaded from: classes.dex */
public class DjB70Carbt extends Activity {
    StringBuffer buffer;
    public TextView connect_state;
    int[] showints;
    public static boolean mIsFront = false;
    public static boolean isChannle = true;
    boolean IsIntentOn = false;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.b70.DjB70Carbt.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 94:
                    DjB70Carbt.this.updateCarbtState();
                    break;
                case 95:
                    DjB70Carbt.this.updateBtConnectState();
                    break;
                case 96:
                    DjB70Carbt.this.updateBtNumber();
                    break;
            }
        }
    };
    int OnStarState = -1;
    boolean IsChange = false;
    int connectstate = -1;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_djb70_carbt);
        init();
        setUI();
    }

    private void init() {
        if (getIntent().getStringExtra("carbt") != null && getIntent().getStringExtra("carbt").equals("on")) {
            this.IsIntentOn = true;
        } else {
            this.IsIntentOn = false;
        }
        this.buffer = new StringBuffer();
        this.connect_state = (TextView) findViewById(R.id.btconnect);
    }

    private void setUI() {
    }

    public void onExtraClik(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.callanswer /* 2131428647 */:
                if (this.connectstate == 1 && ((TextView) findViewById(R.id.showInputTv)).getText().toString() != null) {
                    String callnum = ((TextView) findViewById(R.id.showInputTv)).getText().toString();
                    char[] vals = callnum.toCharArray();
                    this.showints = new int[vals.length + 1];
                    if (this.OnStarState == 1) {
                        this.showints[0] = 2;
                    } else {
                        this.showints[0] = 1;
                    }
                    for (int i = 0; i < vals.length; i++) {
                        this.showints[i + 1] = vals[i];
                    }
                    DataCanbus.PROXY.cmd(2, this.showints, null, null);
                    break;
                }
                break;
            case R.id.callhang /* 2131428648 */:
                if (this.connectstate == 1 && ((TextView) findViewById(R.id.showInputTv)).getText().toString() != null) {
                    String callnum2 = ((TextView) findViewById(R.id.showInputTv)).getText().toString();
                    char[] vals2 = callnum2.toCharArray();
                    this.showints = new int[vals2.length + 1];
                    this.showints[0] = 3;
                    for (int i2 = 0; i2 < vals2.length; i2++) {
                        this.showints[i2 + 1] = vals2[i2];
                    }
                    DataCanbus.PROXY.cmd(2, this.showints, null, null);
                    break;
                }
                break;
            case R.id.onStarDelete /* 2131430906 */:
                if (this.buffer != null && this.buffer.length() > 0) {
                    this.buffer.deleteCharAt(this.buffer.length() - 1);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                    break;
                }
                break;
            case R.id.btn1 /* 2131430907 */:
                if (this.buffer != null) {
                    this.buffer.append(1);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn2 /* 2131430908 */:
                if (this.buffer != null) {
                    this.buffer.append(2);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn3 /* 2131430909 */:
                if (this.buffer != null) {
                    this.buffer.append(3);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn11 /* 2131430910 */:
                if (this.buffer != null) {
                    this.buffer.append('*');
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn4 /* 2131430911 */:
                if (this.buffer != null) {
                    this.buffer.append(4);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn5 /* 2131430912 */:
                if (this.buffer != null) {
                    this.buffer.append(5);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn6 /* 2131430913 */:
                if (this.buffer != null) {
                    this.buffer.append(6);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn0 /* 2131430914 */:
                if (this.buffer != null) {
                    this.buffer.append(0);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn7 /* 2131430915 */:
                if (this.buffer != null) {
                    this.buffer.append(7);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn8 /* 2131430916 */:
                if (this.buffer != null) {
                    this.buffer.append(8);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn9 /* 2131430917 */:
                if (this.buffer != null) {
                    this.buffer.append(9);
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.btn10 /* 2131430918 */:
                if (this.buffer != null) {
                    this.buffer.append('#');
                    ((TextView) findViewById(R.id.showInputTv)).setText(this.buffer.toString());
                }
                break;
            case R.id.Canclebt /* 2131430920 */:
                DataCanbus.PROXY.cmd(3, new int[]{112, 1}, null, null);
                DataCanbus.PROXY.cmd(3, new int[]{112, 0}, null, null);
                break;
            case R.id.muteBt /* 2131430921 */:
                DataCanbus.PROXY.cmd(3, new int[]{113, 1}, null, null);
                DataCanbus.PROXY.cmd(3, new int[]{113, 0}, null, null);
                break;
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        mIsFront = true;
        if (!this.IsIntentOn) {
            DataMain.PROXY.cmd(0, new int[]{12}, null, null);
            DataMain.PROXY.getI(0, 0);
        }
        addUpdater();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        removeUpdater();
        mIsFront = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            DataMain.PROXY.cmd(0, new int[1], null, null);
            moveTaskToBack(true);
        } else if (keyCode != 3 || this.OnStarState != 0) {
        }
        return true;
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtNumber() {
        String str = Callback_0271_DJ_BENGTENG14B70.btNumber;
        if (str != null) {
            if (this.buffer != null && this.buffer.length() > 0) {
                this.buffer.delete(0, this.buffer.length());
            }
            ((TextView) findViewById(R.id.showInputTv)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCarbtState() {
        this.OnStarState = DataCanbus.DATA[94];
        if (this.OnStarState == 0 && this.IsChange && this.IsIntentOn) {
            DataMain.PROXY.cmd(0, new int[1], null, null);
            moveTaskToBack(true);
            this.IsChange = false;
        }
        if (this.OnStarState == 0) {
            this.IsChange = false;
        } else if (this.OnStarState != 0) {
            this.IsChange = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBtConnectState() {
        this.connectstate = DataCanbus.DATA[95];
        if (this.connectstate == 0) {
            this.connect_state.setText(String.format("BT:" + getString(R.string.str_sync_bt_unconnected), new Object[0]));
        } else if (this.connectstate == 1) {
            this.connect_state.setText(String.format("BT:" + getString(R.string.str_sync_bt_connected), new Object[0]));
        }
    }
}
