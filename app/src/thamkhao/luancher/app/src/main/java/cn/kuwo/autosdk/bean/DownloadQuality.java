package cn.kuwo.autosdk.bean;

/* JADX INFO: loaded from: classes.dex */
public class DownloadQuality {

    public enum Quality {
        Q_AUTO,
        Q_LOW,
        Q_HIGH,
        Q_PERFECT,
        Q_LOSSLESS;

        public static Quality bitrate2Quality(int i) {
            if (i <= 48) {
                return Q_LOW;
            }
            if (i <= 128) {
                return Q_HIGH;
            }
            return i <= 320 ? Q_PERFECT : Q_LOSSLESS;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Quality[] valuesCustom() {
            Quality[] qualityArrValuesCustom = values();
            int length = qualityArrValuesCustom.length;
            Quality[] qualityArr = new Quality[length];
            System.arraycopy(qualityArrValuesCustom, 0, qualityArr, 0, length);
            return qualityArr;
        }
    }
}
