package com.syu.esri;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/esri/Polygon.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class Polygon {
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private double[][] mPoints;
    private int mRecordNum;

    public Polygon(int recordNum, double minX, double minY, double maxX, double maxY, double[][] points) {
        this.mPoints = null;
        this.mRecordNum = recordNum;
        this.mMinX = minX;
        this.mMinY = minY;
        this.mMaxX = maxX;
        this.mMaxY = maxY;
        this.mPoints = points;
    }

    public boolean hit(double x, double y) {
        for (int i = 0; i < this.mPoints.length; i++) {
            if (hitPolygon(this.mPoints[i], x, y)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:51:0x002e A[SYNTHETIC] */
    private boolean hitPolygon(double[] points, double x, double y) {
        double leftX;
        double test1;
        double test2;
        int pointCnt = points.length >> 1;
        if (pointCnt <= 2) {
            return false;
        }
        int hits = 0;
        double lastX = points[(pointCnt << 1) - 2];
        double lastY = points[(pointCnt << 1) - 1];
        for (int i = 0; i < pointCnt; i++) {
            double curX = points[i << 1];
            double curY = points[(i << 1) + 1];
            if (curY != lastY) {
                if (curX < lastX) {
                    if (x < lastX) {
                        leftX = curX;
                        if (curY < lastY) {
                            if (y < curY && y < lastY) {
                                if (x < leftX) {
                                    hits++;
                                } else {
                                    test1 = x - curX;
                                    test2 = y - curY;
                                    if (test1 < (test2 / (lastY - curY)) * (lastX - curX)) {
                                        hits++;
                                    }
                                }
                            }
                        } else if (y < lastY && y < curY) {
                            if (x < leftX) {
                                hits++;
                            } else {
                                test1 = x - lastX;
                                test2 = y - lastY;
                                if (test1 < (test2 / (lastY - curY)) * (lastX - curX)) {
                                    hits++;
                                }
                            }
                        }
                    }
                } else if (x < curX) {
                    leftX = lastX;
                    if (curY < lastY) {
                        if (y < curY) {
                        }
                    } else if (y < lastY) {
                    }
                }
            }
            lastX = curX;
            lastY = curY;
        }
        return (hits & 1) != 0;
    }

    public boolean hitBound(double x, double y) {
        return x >= this.mMinX && x < this.mMaxX && y >= this.mMinY && y <= this.mMaxY;
    }

    public int getRecordNum() {
        return this.mRecordNum;
    }
}
