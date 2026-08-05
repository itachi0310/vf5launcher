package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/util/AtomicFile.class */
public class AtomicFile {
    private final File mBaseName;
    private final File mBackupName;

    public AtomicFile(File baseName) {
        this.mBaseName = baseName;
        this.mBackupName = new File(baseName.getPath() + ".bak");
    }

    public File getBaseFile() {
        return this.mBaseName;
    }

    public void delete() {
        this.mBaseName.delete();
        this.mBackupName.delete();
    }

    public FileOutputStream startWrite() throws IOException {
        FileOutputStream str;
        if (this.mBaseName.exists()) {
            if (!this.mBackupName.exists()) {
                if (!this.mBaseName.renameTo(this.mBackupName)) {
                    Log.w("AtomicFile", "Couldn't rename file " + this.mBaseName + " to backup file " + this.mBackupName);
                }
            } else {
                this.mBaseName.delete();
            }
        }
        try {
            str = new FileOutputStream(this.mBaseName);
        } catch (FileNotFoundException e) {
            File parent = this.mBaseName.getParentFile();
            if (!parent.mkdirs()) {
                throw new IOException("Couldn't create directory " + this.mBaseName);
            }
            try {
                str = new FileOutputStream(this.mBaseName);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.mBaseName);
            }
        }
        return str;
    }

    public void finishWrite(FileOutputStream str) {
        if (str != null) {
            sync(str);
            try {
                str.close();
                this.mBackupName.delete();
            } catch (IOException e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public void failWrite(FileOutputStream str) {
        if (str != null) {
            sync(str);
            try {
                str.close();
                this.mBaseName.delete();
                this.mBackupName.renameTo(this.mBaseName);
            } catch (IOException e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.mBackupName.exists()) {
            this.mBaseName.delete();
            this.mBackupName.renameTo(this.mBaseName);
        }
        return new FileInputStream(this.mBaseName);
    }

    public byte[] readFully() throws IOException {
        FileInputStream stream = openRead();
        try {
            int pos = 0;
            byte[] data = new byte[stream.available()];
            while (true) {
                int amt = stream.read(data, pos, data.length - pos);
                if (amt <= 0) {
                    byte[] bArr = data;
                    stream.close();
                    return bArr;
                }
                pos += amt;
                int avail = stream.available();
                if (avail > data.length - pos) {
                    byte[] newData = new byte[pos + avail];
                    System.arraycopy(data, 0, newData, 0, pos);
                    data = newData;
                }
            }
        } catch (Throwable th) {
            stream.close();
            throw th;
        }
    }

    static boolean sync(FileOutputStream stream) {
        if (stream != null) {
            try {
                stream.getFD().sync();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}
