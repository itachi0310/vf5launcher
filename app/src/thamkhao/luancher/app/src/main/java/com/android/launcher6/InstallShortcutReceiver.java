package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class InstallShortcutReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f85a = new Object();
    private static boolean b = false;

    private static mp a(Context context, Intent intent, Intent intent2) {
        if (intent2.getAction() == null) {
            intent2.setAction("android.intent.action.VIEW");
        } else if (intent2.getAction().equals("android.intent.action.MAIN") && intent2.getCategories() != null && intent2.getCategories().contains("android.intent.category.LAUNCHER")) {
            intent2.addFlags(270532608);
        }
        return ip.a().e().a(context, intent, (Bitmap) null);
    }

    private static ArrayList a(SharedPreferences sharedPreferences) {
        synchronized (f85a) {
            try {
                Set<String> stringSet = sharedPreferences.getStringSet("apps_to_install", null);
                if (stringSet == null) {
                    return new ArrayList();
                }
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            JSONObject jSONObject = (JSONObject) new JSONTokener(it.next()).nextValue();
                            Intent uri = Intent.parseUri(jSONObject.getString("intent.data"), 0);
                            Intent uri2 = Intent.parseUri(jSONObject.getString("intent.launch"), 0);
                            String string = jSONObject.getString("name");
                            String strOptString = jSONObject.optString("icon");
                            String strOptString2 = jSONObject.optString("iconResource");
                            String strOptString3 = jSONObject.optString("iconResourcePackage");
                            if (strOptString != null && !strOptString.isEmpty()) {
                                byte[] bArrDecode = Base64.decode(strOptString, 0);
                                uri.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                            } else if (strOptString2 != null && !strOptString2.isEmpty()) {
                                Intent.ShortcutIconResource shortcutIconResource = new Intent.ShortcutIconResource();
                                shortcutIconResource.resourceName = strOptString2;
                                shortcutIconResource.packageName = strOptString3;
                                uri.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcutIconResource);
                            }
                            uri.putExtra("android.intent.extra.shortcut.INTENT", uri2);
                            arrayList.add(new dz(uri, string, uri2));
                        } catch (JSONException e) {
                            Log.d("InstallShortcutReceiver", "Exception reading shortcut to add: " + e);
                        }
                    } catch (URISyntaxException e2) {
                        Log.d("InstallShortcutReceiver", "Exception reading shortcut to add: " + e2);
                    }
                }
                sharedPreferences.edit().putStringSet("apps_to_install", new HashSet()).commit();
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void a() {
        b = true;
    }

    static void a(Context context) {
        b = false;
        b(context);
    }

    private static void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, String str2) {
        Set<String> stringSet = sharedPreferences.getStringSet(str, null);
        HashSet hashSet = stringSet == null ? new HashSet(0) : new HashSet(stringSet);
        hashSet.add(str2);
        editor.putStringSet(str, hashSet);
    }

    private static void a(SharedPreferences sharedPreferences, dz dzVar) {
        synchronized (f85a) {
            try {
                JSONStringer jSONStringerValue = new JSONStringer().object().key("intent.data").value(dzVar.f191a.toUri(0)).key("intent.launch").value(dzVar.b.toUri(0)).key("name").value(dzVar.c);
                if (dzVar.d != null) {
                    byte[] bArrA = ec.a(dzVar.d);
                    jSONStringerValue = jSONStringerValue.key("icon").value(Base64.encodeToString(bArrA, 0, bArrA.length, 0));
                }
                if (dzVar.e != null) {
                    jSONStringerValue = jSONStringerValue.key("iconResource").value(dzVar.e.resourceName).key("iconResourcePackage").value(dzVar.e.packageName);
                }
                JSONStringer jSONStringerEndObject = jSONStringerValue.endObject();
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                a(sharedPreferences, editorEdit, "apps_to_install", jSONStringerEndObject.toString());
                editorEdit.commit();
            } catch (JSONException e) {
                Log.d("InstallShortcutReceiver", "Exception when adding shortcut: " + e);
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences, ArrayList arrayList) {
        synchronized (f85a) {
            Set<String> stringSet = sharedPreferences.getStringSet("apps_to_install", null);
            if (stringSet != null) {
                HashSet hashSet = new HashSet(stringSet);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    try {
                        Intent uri = Intent.parseUri(((JSONObject) new JSONTokener((String) it.next()).nextValue()).getString("intent.launch"), 0);
                        String packageName = uri.getPackage();
                        if (packageName == null) {
                            packageName = uri.getComponent().getPackageName();
                        }
                        if (arrayList.contains(packageName)) {
                            it.remove();
                        }
                    } catch (URISyntaxException e) {
                        Log.d("InstallShortcutReceiver", "Exception reading shortcut to remove: " + e);
                    } catch (JSONException e2) {
                        Log.d("InstallShortcutReceiver", "Exception reading shortcut to remove: " + e2);
                    }
                }
                sharedPreferences.edit().putStringSet("apps_to_install", new HashSet(hashSet)).commit();
            }
        }
    }

    static void b(Context context) {
        ArrayList<dz> arrayListA = a(context.getSharedPreferences(ip.h(), 0));
        if (arrayListA.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (dz dzVar : arrayListA) {
            if (!iv.a(context, dzVar.c, dzVar.b)) {
                arrayList.add(a(context, dzVar.f191a, dzVar.b));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ip.a().e().a(context, arrayList, (ArrayList) null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        String string;
        if ("com.android.launcher.action.INSTALL_SHORTCUT".equals(intent.getAction()) && (intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
            String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
            if (stringExtra == null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    string = packageManager.getActivityInfo(intent2.getComponent(), 0).loadLabel(packageManager).toString();
                } catch (PackageManager.NameNotFoundException e) {
                    return;
                }
            } else {
                string = stringExtra;
            }
            Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
            Intent.ShortcutIconResource shortcutIconResource = (Intent.ShortcutIconResource) intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            ip.a(context.getApplicationContext());
            boolean z = ip.a().i() == null;
            dz dzVar = new dz(intent, string, intent2);
            dzVar.d = bitmap;
            dzVar.e = shortcutIconResource;
            a(context.getSharedPreferences(ip.h(), 0), dzVar);
            if (b || z) {
                return;
            }
            b(context);
        }
    }
}
