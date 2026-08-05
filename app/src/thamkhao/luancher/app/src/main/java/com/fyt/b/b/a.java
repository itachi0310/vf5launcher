package com.fyt.b.b;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context context, String str, String str2) {
        Log.d("Tag", "copyFileFromAssets ");
        try {
            a(context.getAssets().open(str), str2);
        } catch (IOException e) {
            Log.d("Tag", "copyFileFromAssets IOException-" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void a(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
