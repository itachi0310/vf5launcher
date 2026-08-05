package com.syu.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.syu.log.LogPreview;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/NetworkState.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class NetworkState extends BroadcastReceiver {
    private static final int DELAY = 15000;
    private static final String URL_ = "http://www.json.org";
    static NetworkState instance;
    boolean isNetworkAvailable;
    List<OnNetworkStateChangeLisenter> lisenters;
    Context mContext;
    Handler mHandler;
    int space = DELAY;
    Runnable checkNetwork = new Runnable() { // from class: com.syu.weather.NetworkState.1
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            NetworkState.this.ping();
            if (NetworkState.this.isNetworkConnected()) {
                if (NetworkState.this.mHandler != null) {
                    NetworkState.this.mHandler.removeCallbacks(NetworkState.this.checkNetwork);
                    NetworkState.this.mHandler.postDelayed(NetworkState.this.checkNetwork, NetworkState.this.space);
                } else {
                    NetworkState.this.mHandler.removeCallbacks(NetworkState.this.checkNetwork);
                }
            }
        }
    };
    HandlerThread workThread = new HandlerThread("ping network");

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/NetworkState$OnNetworkStateChangeLisenter.class
  classes.dex
 */
    public interface OnNetworkStateChangeLisenter {
        void onChanged(boolean z);
    }

    public static NetworkState getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkState(context);
        }
        return instance;
    }

    public NetworkState(Context context) {
        this.mContext = context.getApplicationContext();
        this.workThread.start();
        this.mHandler = new Handler(this.workThread.getLooper());
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this, filter);
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(1);
        boolean mobVaild = mobNetInfo != null && mobNetInfo.isConnected();
        boolean wifiVaild = wifiNetInfo != null && wifiNetInfo.isConnected();
        if (mobVaild || wifiVaild) {
            this.mHandler.removeCallbacks(this.checkNetwork);
            this.mHandler.post(this.checkNetwork);
        } else {
            this.isNetworkAvailable = false;
            this.mHandler.removeCallbacks(this.checkNetwork);
        }
    }

    public final boolean ping() throws Throwable {
        boolean baidu = ping("www.baidu.com");
        boolean vaild = 0 != 0 || baidu;
        if (!vaild) {
            boolean json = ping("www.json.org");
            vaild = vaild || json;
            if (!vaild) {
                boolean sina = ping("sina.cn");
                vaild = vaild || sina;
                if (!vaild) {
                    boolean google = ping("www.google.com");
                    vaild = vaild || google;
                }
            }
        }
        if (vaild != this.isNetworkAvailable) {
            this.isNetworkAvailable = vaild;
            if (this.lisenters != null && this.lisenters.size() > 0) {
                for (OnNetworkStateChangeLisenter lisenter : this.lisenters) {
                    lisenter.onChanged(vaild);
                }
            }
        }
        return this.isNetworkAvailable;
    }

    boolean ping(String www) throws Throwable {
        boolean success = false;
        InputStream input = null;
        BufferedReader in = null;
        try {
            try {
                Process p = Runtime.getRuntime().exec("ping -c 2 -W 10 " + www);
                input = p.getInputStream();
                BufferedReader in2 = new BufferedReader(new InputStreamReader(input));
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String content = in2.readLine();
                        if (content == null) {
                            break;
                        }
                        stringBuffer.append(content);
                    }
                    int status = p.waitFor();
                    success = status == 0;
                    if (status == 0) {
                    }
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (in2 != null) {
                        try {
                            in2.close();
                            in = in2;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            in = in2;
                        }
                    } else {
                        in = in2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    in = in2;
                    e.printStackTrace();
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (InterruptedException e6) {
                    e = e6;
                    in = in2;
                    e.printStackTrace();
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    in = in2;
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            } catch (InterruptedException e12) {
                e = e12;
            }
            return success;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void checkNetUrl() {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet get = new HttpGet(URL_);
            get.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
            HttpResponse response = httpclient.execute(get);
            Header[] reqHeaders = get.getAllHeaders();
            for (int i = 0; i < reqHeaders.length; i++) {
                reqHeaders[i].getName();
                reqHeaders[i].getValue();
            }
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode == 200 || responseCode == 206 || responseCode == 404) {
                if (responseCode == 200) {
                    HttpEntity entity = response.getEntity();
                    EntityUtils.toString(entity, "utf-8");
                }
                this.isNetworkAvailable = true;
            } else {
                this.isNetworkAvailable = false;
            }
        } catch (Exception e) {
            this.isNetworkAvailable = false;
        }
        LogPreview.show("isNetworkAvailable =============== " + this.isNetworkAvailable);
    }

    public void registerReceiver() {
        if (isNetworkConnected()) {
            this.mHandler.post(this.checkNetwork);
        }
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.mContext.registerReceiver(this, filter);
    }

    public void unregisterReceiver() {
        this.mContext.unregisterReceiver(this);
    }

    boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo wifiNetInfo = connectivityManager.getNetworkInfo(1);
        return (mobNetInfo != null && mobNetInfo.isConnected()) || (wifiNetInfo != null && wifiNetInfo.isConnected());
    }

    public boolean isNetworkAvailable() {
        return this.isNetworkAvailable;
    }

    public void stop() {
        this.mContext.unregisterReceiver(this);
        if (this.workThread != null && this.workThread.isAlive()) {
            this.workThread.getLooper().quit();
        }
    }

    public void registerLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.lisenters == null) {
            this.lisenters = new ArrayList();
        }
        if (lisenter != null && !this.lisenters.contains(lisenter)) {
            this.lisenters.add(lisenter);
            lisenter.onChanged(this.isNetworkAvailable);
        }
    }

    public void unRegisterLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.lisenters != null && lisenter != null && this.lisenters.contains(lisenter)) {
            this.lisenters.remove(lisenter);
        }
    }
}
