package com.syu.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f545a;
    Context b;
    boolean d;
    b h;
    LocationManager i;
    Location j;
    String k;
    String l;
    boolean m;
    d n;
    public List p;
    boolean c = false;
    long e = 0;
    long f = 0;
    boolean g = true;
    int o = 3;
    GpsStatus.Listener q = new f(this);
    LocationListener r = new g(this);
    LocationListener s = new h(this);
    public n t = new n(this);

    e(Context context) {
        this.m = false;
        this.b = context.getApplicationContext();
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(this.b.getPackageName(), 0);
        String string = sharedPreferences.getString("city", "");
        this.k = string;
        this.l = string;
        this.m = sharedPreferences.getBoolean("inChina", this.m);
        this.i = (LocationManager) this.b.getSystemService(Headers.LOCATION);
        this.h = new b(this.b);
        this.h.a(new i(this));
        this.h.a(this.b);
    }

    public static e a(Context context) {
        if (f545a == null) {
            f545a = new e(context);
        }
        return f545a;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x006d A[Catch: IOException -> 0x00b2, TRY_LEAVE, TryCatch #4 {IOException -> 0x00b2, blocks: (B:11:0x0068, B:13:0x006d), top: B:57:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0079 A[Catch: IOException -> 0x007d, TRY_LEAVE, TryCatch #7 {IOException -> 0x007d, blocks: (B:17:0x0074, B:19:0x0079), top: B:61:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x009c A[Catch: IOException -> 0x00a0, TRY_LEAVE, TryCatch #5 {IOException -> 0x00a0, blocks: (B:28:0x0097, B:30:0x009c), top: B:59:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae A[Catch: IOException -> 0x00b4, TRY_LEAVE, TryCatch #3 {IOException -> 0x00b4, blocks: (B:37:0x00a9, B:39:0x00ae), top: B:55:0x00a9 }] */
    public static String a(String str) {
        BufferedReader bufferedReader;
        PrintWriter printWriter;
        Throwable th;
        String str2 = null;
        PrintWriter printWriter2 = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                uRLConnectionOpenConnection.setRequestProperty("accept", "*/*");
                uRLConnectionOpenConnection.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                uRLConnectionOpenConnection.setRequestProperty(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
                uRLConnectionOpenConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                uRLConnectionOpenConnection.setConnectTimeout(500000);
                uRLConnectionOpenConnection.setReadTimeout(500000);
                uRLConnectionOpenConnection.setDoOutput(true);
                uRLConnectionOpenConnection.setDoInput(true);
                try {
                    printWriter = new PrintWriter(uRLConnectionOpenConnection.getOutputStream());
                    try {
                        printWriter.print("");
                        printWriter.flush();
                        bufferedReader = new BufferedReader(new InputStreamReader(uRLConnectionOpenConnection.getInputStream(), HTTP.UTF_8));
                        str2 = "";
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                str2 = String.valueOf(str2) + line;
                            } catch (Exception e) {
                                if (printWriter != null) {
                                    try {
                                        printWriter.close();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    } catch (IOException e2) {
                                    }
                                } else if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (printWriter != null) {
                                    try {
                                        printWriter.close();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    } catch (IOException e3) {
                                        throw th;
                                    }
                                } else if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        }
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (IOException e4) {
                            }
                        } else if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Exception e5) {
                        bufferedReader = null;
                        str2 = "";
                    } catch (Throwable th3) {
                        bufferedReader = null;
                        th = th3;
                    }
                } catch (Exception e6) {
                    if (0 != 0) {
                        try {
                            printWriter2.close();
                            if (0 != 0) {
                                bufferedReader2.close();
                            }
                        } catch (IOException e7) {
                        }
                    } else if (0 != 0) {
                        bufferedReader2.close();
                    }
                }
            } catch (Exception e8) {
                bufferedReader = null;
                printWriter = null;
                str2 = "";
            }
            return str2;
        } catch (Throwable th4) {
            printWriter = null;
            th = th4;
            bufferedReader = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GpsStatus gpsStatus) {
        if (i != 4) {
            return;
        }
        int maxSatellites = gpsStatus.getMaxSatellites();
        Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext() || i3 > maxSatellites) {
                return;
            }
            it.next();
            i2 = i3 + 1;
        }
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        Log.d("hzq", "call updateLocation ** location = " + location);
        if (location == null) {
            return;
        }
        boolean zA = a(location);
        if (this.m != zA) {
            this.m = zA;
            this.b.getSharedPreferences(this.b.getPackageName(), 0).edit().putBoolean("inChina", this.m).commit();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.j == null || this.n == null || !this.n.f() || jElapsedRealtime - this.e > 120000) {
            this.j = location;
            new k(this, jElapsedRealtime).execute(this.j);
        }
    }

    public void a() {
        if (this.h == null || !this.h.b || this.c) {
            return;
        }
        this.f = 0L;
        this.e = 0L;
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        Location lastKnownLocation = this.i.getLastKnownLocation("gps");
        if (lastKnownLocation == null) {
            lastKnownLocation = this.i.getLastKnownLocation("network");
        }
        if (this.j == null) {
            if (lastKnownLocation != null) {
                b(lastKnownLocation);
                this.g = false;
            } else {
                new j(this).start();
            }
        }
        if (this.i.isProviderEnabled("gps")) {
            this.i.requestLocationUpdates("gps", 30000L, this.o, this.s);
        }
        if (this.i.isProviderEnabled("network")) {
            this.i.requestLocationUpdates("network", 30000L, this.o, this.r);
        }
        this.c = true;
    }

    public void a(m mVar) {
        if (mVar == null) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        if (this.p.contains(mVar)) {
            return;
        }
        mVar.a(this.n);
        this.p.add(mVar);
    }

    void a(Double d, Double d2, String str) {
        if (this.d || d == null || d2 == null) {
            return;
        }
        this.d = true;
        new l(this, d2, d).execute(str);
    }

    boolean a(Location location) {
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        return longitude >= 73.33d && longitude <= 135.05d && latitude >= 3.51d && latitude <= 53.33d;
    }

    protected boolean a(Location location, Location location2) {
        if (location2 == null) {
            return location != null;
        }
        long time = location.getTime() - location2.getTime();
        if (Math.abs(location.getLatitude() - location2.getLatitude()) >= 0.02d || Math.abs(location.getLongitude() - location2.getLongitude()) < 0.02d) {
        }
        boolean z = time > 900000;
        boolean z2 = time < -900000;
        boolean z3 = time > 60000;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean zA = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zA;
        }
        return true;
    }

    String b(String str) {
        String strA = a(str);
        Log.d("hzq", "call geoForNew ** entry = " + strA);
        if (strA == null || strA.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strA);
            if (!"1".equals(jSONObject.getString("status")) || !jSONObject.has("result")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            if (jSONObject2.has("city")) {
                return jSONObject2.getString("city");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    void b() {
        if (this.i != null) {
            try {
                this.i.removeUpdates(this.s);
            } catch (Exception e) {
            }
            try {
                this.i.removeUpdates(this.r);
            } catch (Exception e2) {
            }
        }
        this.c = false;
    }

    String c(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() > 2) {
            return (str.endsWith("市") || str.endsWith("州") || str.endsWith("县")) ? str.substring(0, str.length() - 1) : str;
        }
        return str;
    }
}
