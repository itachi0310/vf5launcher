package com.syu.back;

import android.graphics.Rect;
import android.util.Log;
import com.syu.ipc.data.FinalCanbus;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/back/TrackUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class TrackUtils {
    public static final int MAX_ANGLE = 35;
    public static final int MAX_DISTANCE = 3100;
    public static final float MAX_LINE_WIDTH = 5.0f;
    public static final float MIN_LINE_WIDTH = 2.5f;
    static final double UNIT_ANGLE = 0.017453292519943295d;
    static TrackUtils utils;
    float mmToPixScale;
    float mmToPixScaleh;
    float mmToPixScalev;
    float radiusOfScreen;
    Rect rectOfView;
    static int POINT_COUNT = 35;
    static int first = 8;
    static int middle = 20;
    int wheelBase = 2650;
    int axisLen = 1540;
    int taillightAxis = 800;
    double angleOfView = 0.8028514559173916d;
    double anglePlaceCamera = 0.8726646259971648d;
    int cameraHeight = 800;
    int screenWidth = FinalCanbus.CAR_RZC_XP1_14Prado_L;
    int screenHeight = FinalCanbus.CAR_FYT_XP1_14Prado_L;
    int screenWidthPix = 1024;
    int screenHeightPix = 600;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/back/TrackUtils$Point.class
  classes.dex
 */
    public static class Point {
        float x;
        float y;
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/back/TrackUtils$TRACK_TYPE.class
  classes.dex
 */
    public enum TRACK_TYPE {
        BENZ,
        RECT,
        RECT_DASH;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static TRACK_TYPE[] valuesCustom() {
            TRACK_TYPE[] track_typeArrValuesCustom = values();
            int length = track_typeArrValuesCustom.length;
            TRACK_TYPE[] track_typeArr = new TRACK_TYPE[length];
            System.arraycopy(track_typeArrValuesCustom, 0, track_typeArr, 0, length);
            return track_typeArr;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/back/TrackUtils$Crcle.class
  classes.dex
 */
    public static class Crcle {
        float cx;
        float cy;
        int radius;

        public Crcle() {
        }

        public Crcle(float cx, float cy, int radius) {
            this.cx = cx;
            this.cy = cy;
            this.radius = radius;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/back/TrackUtils$Cubic.class
  classes.dex
 */
    public class Cubic {
        float a;
        float b;
        float c;
        float d;

        public Cubic(float a, float b, float c, float d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public float eval(float u) {
            return (((((this.d * u) + this.c) * u) + this.b) * u) + this.a;
        }
    }

    public static TrackUtils getUtils() {
        return utils;
    }

    public static TrackUtils initialize() {
        if (utils == null) {
            utils = new TrackUtils();
            utils.calculateRectOfView();
        }
        return utils;
    }

    public static TrackUtils initialize(int wheel, int axis, int tailling, int angleofview, int angleofplace, int sw, int sh) {
        if (utils == null) {
            utils = new TrackUtils();
        }
        utils.setup(wheel, axis, tailling, angleofview, angleofplace, sw, sh);
        return utils;
    }

    void setup(int wheel, int axis, int tailling, int angleofview, int angleofplace, int sw, int sh) {
        this.wheelBase = wheel;
        this.axisLen = axis;
        this.taillightAxis = tailling;
        this.angleOfView = (((double) angleofview) * UNIT_ANGLE) / 2.0d;
        this.anglePlaceCamera = ((double) angleofplace) * UNIT_ANGLE;
        this.screenWidth = sw;
        this.screenHeight = sh;
        calculateRectOfView();
    }

    void setup(int swpix, int shpix) {
        this.screenWidthPix = swpix;
        this.screenHeightPix = shpix;
        this.mmToPixScalev = this.screenHeightPix / this.screenHeight;
        this.mmToPixScaleh = this.screenWidthPix / this.screenWidth;
        this.mmToPixScale = (float) (Math.sqrt(Math.pow(this.screenWidthPix, 2.0d) + Math.pow(this.screenHeightPix, 2.0d)) / Math.sqrt(Math.pow(this.screenWidth, 2.0d) + Math.pow(this.screenHeight, 2.0d)));
        Log.e("PP", "ps     cc ==>>  " + String.format("mmToPixScalev = %f,  mmToPixScaleh= %f, mmToPixScale = %f", Float.valueOf(this.mmToPixScalev), Float.valueOf(this.mmToPixScaleh), Float.valueOf(this.mmToPixScale)));
        this.radiusOfScreen = (float) ((Math.sqrt(Math.pow(this.screenWidth, 2.0d) + Math.pow(this.screenHeight, 2.0d)) / 2.0d) + 0.5d);
    }

    public Rect calculateRectOfView() {
        if (this.rectOfView == null) {
            this.rectOfView = new Rect();
        }
        int vw = (int) ((((Math.tan(this.angleOfView) * 2.0d) * ((double) this.cameraHeight)) / Math.cos(this.anglePlaceCamera)) + 0.5d);
        int minY = (int) ((((double) this.cameraHeight) / Math.tan(this.angleOfView + this.anglePlaceCamera)) + 0.5d);
        int maxY = (int) ((((double) this.cameraHeight) / Math.tan(this.anglePlaceCamera)) + 0.5d);
        Log.e("PP", "ps     cc ==>>  " + String.format("vw = %d,  max Y= %d, minY = %d", Integer.valueOf(vw), Integer.valueOf(maxY), Integer.valueOf(minY)));
        this.rectOfView.set((-vw) / 2, minY, vw / 2, maxY);
        return this.rectOfView;
    }

    public Crcle[] calculateCrcle(float angle) {
        Crcle c1 = new Crcle();
        Crcle c2 = new Crcle();
        double cot_a = 1.0d / Math.tan(angle);
        float f = -((float) (((double) this.wheelBase) * cot_a));
        c2.cx = f;
        c1.cx = f;
        float f2 = -this.taillightAxis;
        c2.cy = f2;
        c1.cy = f2;
        c1.radius = (int) ((Math.abs(c1.cx) - (this.axisLen / 2)) + 0.5f);
        c2.radius = (int) (Math.abs(c2.cx) + (this.axisLen / 2) + 0.5f);
        Crcle[] crcles = {c1, c2};
        return crcles;
    }

    public Point realToCameraPoint(Point point) {
        double arctg = Math.atan(this.cameraHeight / point.y);
        double angle1 = (this.angleOfView + this.anglePlaceCamera) - arctg;
        double angle2 = this.anglePlaceCamera - arctg;
        double angle3 = this.angleOfView;
        Point p = new Point();
        p.y = (int) (((Math.sin(angle1) / Math.cos(angle2)) * (((double) this.radiusOfScreen) / (2.0d * Math.sin(angle3)))) + 0.5d);
        p.x = (int) ((((double) point.x) / (((double) point.y) * Math.tan(angle3))) * ((double) (this.radiusOfScreen / 2.0f)));
        return p;
    }

    public Point[] realToCamera(Point[] points) {
        if (points == null || points.length <= 0) {
            return null;
        }
        Point[] mPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            mPoints[i] = realToCameraPoint(points[i]);
        }
        return mPoints;
    }

    public float[] realToCamera(float[] points) {
        int count = (points == null || points.length <= 0 || points.length % 2 != 0) ? 0 : points.length;
        float[] ps = new float[count];
        for (int i = 0; i < count / 2; i++) {
            float x = points[i * 2];
            float y = points[(i * 2) + 1];
            double arctg = Math.atan(this.cameraHeight / y);
            double angle1 = (this.angleOfView + this.anglePlaceCamera) - arctg;
            double angle2 = this.anglePlaceCamera - arctg;
            double angle3 = this.angleOfView;
            ps[(i * 2) + 1] = (int) (((Math.sin(angle1) / Math.cos(angle2)) * (((double) this.screenHeight) / (2.0d * Math.sin(angle3))) * ((double) this.mmToPixScalev)) + 0.5d);
            ps[i * 2] = (int) (((((double) x) / Math.abs(((double) y) * Math.tan(angle3))) * ((double) (this.screenWidth / 2)) * ((double) this.mmToPixScaleh)) + 0.5d);
        }
        return ps;
    }

    public float[] realToCameraForJ(float[] points) {
        int count = (points == null || points.length <= 0 || points.length % 2 != 0) ? 0 : points.length;
        float[] ps = new float[count];
        for (int i = 0; i < count / 2; i++) {
            float x = points[i * 2];
            float y = points[(i * 2) + 1];
            double arctg = Math.atan(this.cameraHeight / y);
            double angle1 = arctg - this.anglePlaceCamera;
            double angle2 = this.angleOfView;
            double y1 = (((double) this.cameraHeight) / Math.sin(arctg)) * Math.sin(angle1);
            double r = (((double) this.cameraHeight) / Math.sin(arctg)) * Math.cos(angle1) * Math.tan(angle2);
            ps[(i * 2) + 1] = (float) (((((double) this.radiusOfScreen) / r) * y1 * ((double) this.mmToPixScale)) + 0.5d);
            ps[i * 2] = (float) (((((double) this.radiusOfScreen) / r) * ((double) x) * ((double) this.mmToPixScale)) + 0.5d);
        }
        return ps;
    }

    public float getAngleOfArcLen(float len, Crcle c, double startAngle, int mode) {
        double angle = (((double) len) / (((((double) c.radius) * 3.141592653589793d) * 2.0d) / 360.0d)) * UNIT_ANGLE;
        int[] iArr = new int[2];
        return (float) ((((double) mode) * angle) + startAngle);
    }

    public float getAngleForY(Crcle c, float y) {
        return (float) Math.asin(y / c.radius);
    }

    public float[] getPointForAngle(Crcle c, double angle, boolean left) {
        float[] ps = new float[2];
        ps[0] = left ? (float) (((double) c.cx) + (((double) c.radius) * Math.cos(angle))) : (float) (((double) c.cx) - (((double) c.radius) * Math.cos(angle)));
        ps[1] = -((float) (((double) c.cy) + (((double) c.radius) * Math.sin(angle))));
        return ps;
    }

    public float[] getPointsOfArc(Crcle c, boolean left) {
        float angle = utils.getAngleOfArcLen(3100.0f / POINT_COUNT, c, 0.0d, 1);
        float[] dst = new float[POINT_COUNT * 2];
        for (int i = 0; i < POINT_COUNT; i++) {
            float[] ps1 = utils.realToCameraForJ(utils.getPointForAngle(c, 0.0f - (i * angle), left));
            dst[i * 2] = ps1[0];
            dst[(i * 2) + 1] = ps1[1];
        }
        return dst;
    }

    public float[] pointOfView(float startX, float endX, float startY, float endY) {
        float[] ps = new float[POINT_COUNT * 2];
        float dex = (endX - startX) / POINT_COUNT;
        float dey = (endY - startY) / POINT_COUNT;
        for (int i = 0; i < POINT_COUNT; i++) {
            ps[i * 2] = (i * dex) + startX + 0.5f;
            ps[(i * 2) + 1] = (i * dey) + startY + 0.5f;
        }
        return ps;
    }

    public Point mmToPixPoint(Point point) {
        Point p = new Point();
        p.y = (point.y * this.mmToPixScalev) + 0.5f;
        p.x = (point.x * this.mmToPixScaleh) + 0.5f;
        return p;
    }

    public Point[] mmToPix(Point[] points) {
        if (points == null || points.length <= 0) {
            return null;
        }
        Point[] mPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            mPoints[i] = mmToPixPoint(points[i]);
        }
        return mPoints;
    }

    public int getCameraOffPix() {
        return (int) ((this.rectOfView.bottom * this.mmToPixScalev) + 0.5f);
    }
}
