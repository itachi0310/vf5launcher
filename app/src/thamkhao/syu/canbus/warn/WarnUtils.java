package com.syu.canbus.warn;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.PopupWindow;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: classes.dex */
public class WarnUtils {
    static int LocationX = 0;
    static int LocationY = 0;
    private static final Runnable SHOW = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.1
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            TheApp.addRootView(window);
            if (TheApp.rootViewWindowToken() == null) {
                HandlerUI.getInstance().postDelayed(this, 1L);
            }
            if (!window.isShowing()) {
                switch (DataCanbus.DATA[1000]) {
                    case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                    case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                    case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                    case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 3, 0, 0);
                        break;
                    default:
                        window.showAtLocation(TheApp.getInstance().getRootView(), 17, WarnUtils.LocationX, WarnUtils.LocationY);
                        break;
                }
            }
        }
    };
    private static final Runnable WINDOW_HIDE = new Runnable() { // from class: com.syu.canbus.warn.WarnUtils.2
        @Override // java.lang.Runnable
        public void run() {
            PopupWindow window = WarnUtils.getWindow();
            if (window.isShowing()) {
                window.dismiss();
            }
        }
    };
    private static PopupWindow sPopupWindow;

    public static PopupWindow getWindow() {
        if (sPopupWindow == null) {
            Context context = TheApp.getInstance();
            PopupWindow window = new PopupWindow(context);
            window.setFocusable(true);
            window.setBackgroundDrawable(new ColorDrawable(0));
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_WC2_LandRover_Discovery3 /* 131483 */:
                case FinalCanbus.CAR_RZC_UAZ /* 3539346 */:
                case FinalCanbus.CAR_443_WC2_UAZ_Patriot /* 6947259 */:
                case FinalCanbus.CAR_452_TZY_UAZ_Patriot /* 11993540 */:
                    window.setWidth(-1);
                    window.setHeight(-2);
                    break;
                case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_Low /* 14811588 */:
                case FinalCanbus.CAR_452_Luz_Audi_A4L_H /* 14877124 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_Low /* 14942660 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q5_H /* 15008196 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_Low /* 15073732 */:
                case FinalCanbus.CAR_452_Luz_Audi_A6L_H /* 15139268 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_Low /* 15204804 */:
                case FinalCanbus.CAR_452_Luz_Audi_Q7_H /* 15270340 */:
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(230);
                    break;
                case FinalCanbus.CAR_WC2_07_AoDeSai /* 196774 */:
                case FinalCanbus.CAR_XP1_PsaAll_AutoPark /* 262425 */:
                case FinalCanbus.CAR_454_LZ_Ford_Explorer_H_Auto /* 1507782 */:
                case FinalCanbus.CAR_443_WC2_Ford_12Focus_Overseas /* 15139259 */:
                case FinalCanbus.CAR_453_OD_Modernin /* 16384453 */:
                    window.setWidth(TheApp.getScreenWidth());
                    window.setHeight(TheApp.getScreenHeight());
                    break;
                default:
                    window.setWidth(-2);
                    window.setHeight(-2);
                    break;
            }
            sPopupWindow = window;
        }
        return sPopupWindow;
    }

    public static void setLocation(int x, int y) {
        LocationX = x;
        LocationY = y;
    }

    public static void postDelayedSingle(Runnable runnable, int delay) {
        if (runnable != null) {
            HandlerUI.getInstance().removeCallbacks(runnable);
            HandlerUI.getInstance().postDelayed(runnable, delay);
        }
    }

    public static void postDimiss(int delay) {
        postDelayedSingle(WINDOW_HIDE, delay);
    }

    public static void showWindow() {
        HandlerUI.getInstance().post(SHOW);
    }
}
