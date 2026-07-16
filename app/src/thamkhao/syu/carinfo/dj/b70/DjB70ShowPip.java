package com.syu.carinfo.dj.b70;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.canbus.TheApp;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: classes.dex */
public class DjB70ShowPip {
    static StringBuffer buffer;
    static WindowManager manager;
    static TextView showNumTv;
    static View v = null;
    public static boolean IsShowPip = false;
    static int OnStarState = -1;
    private static IUiNotify updaterOnStarState = new IUiNotify() { // from class: com.syu.carinfo.dj.b70.DjB70ShowPip.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (updateCode == 51) {
                DjB70ShowPip.OnStarState = DataCanbus.DATA[51];
                if (DjB70ShowPip.OnStarState == 0) {
                    DjB70ShowPip.CancelWindow();
                }
            }
        }
    };
    static View.OnClickListener PipClick = new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70ShowPip.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v2) {
            int id = v2.getId();
            switch (id) {
                case R.id.pipbtn1 /* 2131431950 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(1);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn2 /* 2131431951 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(2);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn3 /* 2131431952 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(3);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn4 /* 2131431953 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(4);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn5 /* 2131431954 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(5);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn11 /* 2131431955 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append('*');
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn6 /* 2131431956 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(6);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn7 /* 2131431957 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(7);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn8 /* 2131431958 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(8);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn9 /* 2131431959 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(9);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn0 /* 2131431960 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append(0);
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
                case R.id.pipbtn10 /* 2131431961 */:
                    if (DjB70ShowPip.buffer != null) {
                        DjB70ShowPip.buffer.append('#');
                    }
                    DjB70ShowPip.showNumTv.setText(DjB70ShowPip.buffer.toString());
                    break;
            }
        }
    };

    public static void showWindow() {
        IsShowPip = true;
        DataCanbus.NOTIFY_EVENTS[51].addNotify(updaterOnStarState, 1);
        LayoutInflater inflater = (LayoutInflater) TheApp.getInstance().getApplicationContext().getSystemService("layout_inflater");
        v = inflater.inflate(R.layout.layout_klc_onstar_pip, (ViewGroup) null);
        buffer = new StringBuffer();
        showNumTv = (TextView) v.findViewById(R.id.showNumPip);
        v.findViewById(R.id.pipcallhang).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dj.b70.DjB70ShowPip.3
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                DjB70ShowPip.CancelWindow();
            }
        });
        v.findViewById(R.id.pipbtn0).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn1).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn2).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn3).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn4).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn5).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn6).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn7).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn8).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn9).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn10).setOnClickListener(PipClick);
        v.findViewById(R.id.pipbtn11).setOnClickListener(PipClick);
        v.findViewById(R.id.pipcallanswer).setOnClickListener(PipClick);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = 2007;
        params.flags = 40;
        params.format = 1;
        params.width = -1;
        params.height = -1;
        params.gravity = 51;
        manager = (WindowManager) TheApp.getInstance().getSystemService("window");
        manager.addView(v, params);
    }

    public static void CancelWindow() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(updaterOnStarState);
        if (manager != null) {
            manager.removeView(v);
            manager = null;
        }
        IsShowPip = false;
    }
}
