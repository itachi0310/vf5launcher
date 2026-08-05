package cn.kuwo.autosdk;

import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f39a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f39a = "u\\d+_a\\d+";
        } else {
            f39a = "app_\\d+";
        }
    }

    public static List a() {
        ArrayList arrayList = new ArrayList();
        for (String str : a("toolbox ps -p -P -x -c")) {
            try {
                arrayList.add(new v(str, (v) null));
            } catch (Exception e) {
                Log.d("ProcessManager", "Failed parsing line " + str);
            }
        }
        return arrayList;
    }

    public static List a(String str) {
        Process process = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                Process processExec = Runtime.getRuntime().exec(str);
                InputStream inputStream = processExec.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            arrayList.add(line.trim());
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                bufferedReader.close();
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                processExec.waitFor();
                if (processExec != null) {
                    processExec.destroy();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                try {
                    process.getErrorStream().close();
                    process.getInputStream().close();
                    process.getOutputStream().close();
                } catch (IOException e6) {
                    e5.printStackTrace();
                }
                if (0 != 0) {
                    process.destroy();
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            if (0 != 0) {
                process.destroy();
            }
            throw th2;
        }
    }
}
