package com.android.launcher17;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.syu.util.FytPackage;
import java.util.ArrayList;
import share.Config;

/* JADX INFO: loaded from: classes.dex */
public class RechargeDialogFragment extends DialogFragment implements AdapterView.OnItemClickListener {
    public static String RechargePackageName = null;
    public static final String SHARED_KEY = "defaultPackageName";
    public static final String SHARED_NAME = "RechargePackageName";
    public static boolean cannotChoose = false;
    ImageView currentAppIcon;
    TextView currentAppName;
    RechargeAdapter mAdapter;
    ArrayList<AppInfo> mData;
    ListView mListView;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(1);
        View view = inflater.inflate(R.layout.dialog_fragment_recharge, container);
        this.mData = AllAppsList.data;
        this.currentAppIcon = (ImageView) view.findViewById(R.id.current_app_icon);
        this.currentAppName = (TextView) view.findViewById(R.id.current_app_name);
        if (RechargePackageName != null) {
            for (int i = 0; i < this.mData.size(); i++) {
                if (this.mData.get(i).getPackageName().equals(RechargePackageName)) {
                    this.currentAppIcon.setImageBitmap(this.mData.get(i).iconBitmap);
                    this.currentAppName.setText(this.mData.get(i).title);
                    break;
                }
            }
        } else {
            this.currentAppIcon.setVisibility(8);
            this.currentAppName.setText("未设置");
        }
        this.mListView = (ListView) view.findViewById(R.id.listview);
        this.mAdapter = new RechargeAdapter(this.mData);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        return view;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
        String selectPackageName = this.mData.get(position).getPackageName();
        RechargePackageName = selectPackageName;
        SharedPreferences sPreferences = LauncherApplication.sApp.getSharedPreferences(SHARED_NAME, 0);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(SHARED_KEY, selectPackageName);
        editor.commit();
        dismiss();
    }

    class RechargeAdapter extends BaseAdapter {
        ArrayList<AppInfo> mData;

        public RechargeAdapter(ArrayList<AppInfo> data) {
            this.mData = data;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.mData != null) {
                return this.mData.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int arg0) {
            return this.mData.get(arg0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            AppInfo data = this.mData.get(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(LauncherApplication.sApp).inflate(R.layout.adapter_recharge, (ViewGroup) null);
                viewHolder = RechargeDialogFragment.this.new ViewHolder();
                viewHolder.appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
                viewHolder.appName = (TextView) convertView.findViewById(R.id.app_name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.appIcon.setImageBitmap(data.iconBitmap);
            viewHolder.appName.setText(data.title);
            return convertView;
        }
    }

    class ViewHolder {
        ImageView appIcon;
        TextView appName;

        ViewHolder() {
        }
    }

    public static void saveRecharge() {
        cannotChoose = false;
        SharedPreferences sPreferences = LauncherApplication.sApp.getSharedPreferences(SHARED_NAME, 0);
        SharedPreferences.Editor editor = sPreferences.edit();
        editor.putString(SHARED_KEY, "com.syu.unicar");
        editor.commit();
    }

    public static void cleanRecharge() {
        cannotChoose = true;
        SharedPreferences sPreferences = LauncherApplication.sApp.getSharedPreferences(SHARED_NAME, 0);
        String defaultPackageName = sPreferences.getString(SHARED_KEY, null);
        if (defaultPackageName != null && defaultPackageName.equals("com.syu.unicar")) {
            SharedPreferences.Editor editor = sPreferences.edit();
            editor.remove(SHARED_KEY);
            editor.commit();
        }
    }

    public static void openRecharge(Launcher launcher, View view) {
        if (launcher != null) {
            if (Config.CHIP_UIID == 5) {
                if (RechargePackageName != null && !RechargePackageName.equals("")) {
                    launcher.startActivitySafely(view, FytPackage.getIntent(launcher, RechargePackageName), "RechargeACTION");
                    return;
                } else {
                    new RechargeDialogFragment().show(launcher.getFragmentManager(), "RechargeDialogFragment");
                    return;
                }
            }
            launcher.startActivitySafely(view, FytPackage.getIntent(launcher, "com.syu.unicar"), "RechargeACTION");
        }
    }

    public static void editRecharge(Launcher launcher) {
        if (launcher != null && Config.CHIP_UIID == 5 && cannotChoose) {
            new RechargeDialogFragment().show(launcher.getFragmentManager(), "RechargeDialogFragment");
        }
    }
}
