package com.syu.utils;

import android.R;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.syu.ipc.data.FinalCanbus;
import org.apache.http.HttpStatus;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/utils/W3DialogUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class W3DialogUtils {
    private static final int BTN_CANCEL = 2131234561;
    private static final int BTN_SURE = 2131234560;
    private static final int TEXTVIEW_MSG = 2131234563;
    private static final int TEXTVIEW_TITLE = 2131234562;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/utils/W3DialogUtils$CustomDialog.class
  classes.dex
 */
    public static class CustomDialog extends Dialog {
        View.OnClickListener clickListener;
        String msg;
        String negative;
        String positive;
        String title;

        public CustomDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
            this.title = null;
            this.msg = null;
            this.positive = null;
            this.negative = null;
            this.clickListener = new View.OnClickListener() { // from class: com.syu.utils.W3DialogUtils.CustomDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    switch (v.getId()) {
                        case W3DialogUtils.BTN_SURE /* 2131234560 */:
                            CustomDialog.this.dismiss();
                            CustomDialog.this.stratActivityByName();
                            break;
                        case W3DialogUtils.BTN_CANCEL /* 2131234561 */:
                            CustomDialog.this.dismiss();
                            break;
                    }
                }
            };
            init();
        }

        public CustomDialog(Context context, int theme) {
            super(context, theme);
            this.title = null;
            this.msg = null;
            this.positive = null;
            this.negative = null;
            this.clickListener = new View.OnClickListener() { // from class: com.syu.utils.W3DialogUtils.CustomDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    switch (v.getId()) {
                        case W3DialogUtils.BTN_SURE /* 2131234560 */:
                            CustomDialog.this.dismiss();
                            CustomDialog.this.stratActivityByName();
                            break;
                        case W3DialogUtils.BTN_CANCEL /* 2131234561 */:
                            CustomDialog.this.dismiss();
                            break;
                    }
                }
            };
            init();
        }

        public CustomDialog(Context context) {
            this(context, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        }

        void init() {
            requestWindowFeature(1);
            Window w = getWindow();
            w.setType(2007);
            w.setFlags(131072, 131072);
            w.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams params = w.getAttributes();
            params.width = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            params.height = FinalCanbus.CAR_XBS_XP1_2015CRV;
            getWindow().setGravity(17);
            getWindow().setAttributes(params);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Context context = getContext();
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(Color.parseColor("#e8e8e8"));
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            TextView title = new TextView(context);
            title.setTextColor(SupportMenu.CATEGORY_MASK);
            if (this.title != null) {
                title.setText(this.title);
            }
            title.setId(W3DialogUtils.TEXTVIEW_TITLE);
            title.setTextSize(30.0f);
            title.setGravity(17);
            title.setPadding(0, 15, 0, 0);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(title, lp);
            View view1 = new View(context);
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(-1, 15);
            linearLayout.addView(view1, lp2);
            TextView textView = new TextView(context);
            textView.setBackgroundColor(Color.parseColor("#a7a7a7"));
            textView.setWidth(300);
            textView.setHeight(1);
            linearLayout.addView(textView);
            TextView msg = new TextView(context);
            msg.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            if (this.msg != null) {
                msg.setText(this.msg);
            }
            msg.setId(W3DialogUtils.TEXTVIEW_MSG);
            msg.setTextSize(20.0f);
            msg.setHeight(FinalCanbus.CAR_FYTA_ChangChengFengJun6);
            msg.setWidth(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            msg.setPadding(30, 20, 30, 30);
            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(HttpStatus.SC_INTERNAL_SERVER_ERROR, -2);
            linearLayout.addView(msg, lp3);
            LinearLayout layout = new LinearLayout(getContext());
            layout.setPadding(0, 0, 0, 20);
            layout.setOrientation(0);
            layout.setGravity(17);
            StateListDrawable drawable = new StateListDrawable();
            drawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.parseColor("#8b8b8b")));
            drawable.addState(new int[0], new ColorDrawable(Color.parseColor("#a7a7a7")));
            Button button = new Button(getContext());
            if (this.positive != null) {
                button.setText(this.positive);
            }
            button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            button.setId(W3DialogUtils.BTN_SURE);
            button.setWidth(FinalCanbus.CAR_FYTA_BYDF3SuRui);
            button.setHeight(62);
            button.setTextSize(25.0f);
            button.setOnClickListener(this.clickListener);
            button.setBackground(drawable);
            layout.addView(button);
            View view = new View(getContext());
            LinearLayout.LayoutParams lp4 = new LinearLayout.LayoutParams(80, 50);
            layout.addView(view, lp4);
            LinearLayout.LayoutParams lp5 = new LinearLayout.LayoutParams(-1, -2);
            StateListDrawable drawable2 = new StateListDrawable();
            drawable2.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.parseColor("#8b8b8b")));
            drawable2.addState(new int[0], new ColorDrawable(Color.parseColor("#a7a7a7")));
            Button button2 = new Button(getContext());
            if (this.negative != null) {
                button2.setText(this.negative);
            }
            button2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            button2.setId(W3DialogUtils.BTN_CANCEL);
            button2.setBackground(drawable2);
            button2.setWidth(FinalCanbus.CAR_FYTA_BYDF3SuRui);
            button2.setHeight(62);
            button2.setTextSize(25.0f);
            button2.setOnClickListener(this.clickListener);
            layout.addView(button2);
            linearLayout.addView(layout, lp5);
            setContentView(linearLayout);
        }

        @Override // android.app.Dialog
        public void setTitle(CharSequence title) {
            TextView tv = (TextView) findViewById(W3DialogUtils.TEXTVIEW_TITLE);
            this.title = (String) title;
            if (tv != null) {
                tv.setText(title);
            }
        }

        @Override // android.app.Dialog
        public void setTitle(int titleId) {
            setTitle(getContext().getText(titleId));
        }

        public void setMsg(CharSequence msg) {
            this.msg = (String) msg;
            TextView tv = (TextView) findViewById(W3DialogUtils.TEXTVIEW_MSG);
            if (tv != null) {
                tv.setText(msg);
            }
        }

        public void setMsg(int msgId) {
            setMsg(getContext().getString(msgId));
        }

        public void setButton(String positive, String negative) {
            this.positive = positive;
            this.negative = negative;
            Button btn = (Button) findViewById(W3DialogUtils.BTN_SURE);
            if (btn != null) {
                btn.setText(positive);
            }
            Button btn2 = (Button) findViewById(W3DialogUtils.BTN_CANCEL);
            if (btn2 != null) {
                btn2.setText(negative);
            }
        }

        public void setButton(int positive, int negative) {
            setButton(getContext().getString(positive), getContext().getString(negative));
        }

        public void stratActivityByName() {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.syu.unicar", "com.syu.unicar.MainAct"));
            intent.putExtra("isFromLauncher", true);
            intent.setFlags(268435456);
            try {
                getContext().startActivity(intent);
            } catch (Exception e) {
            }
        }
    }
}
