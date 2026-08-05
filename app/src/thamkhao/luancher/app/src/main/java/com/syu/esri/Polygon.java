package com.syu.esri;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/esri/Polygon.class */
public class Polygon {
    private int mRecordNum;
    private double mMinX;
    private double mMinY;
    private double mMaxX;
    private double mMaxY;
    private double[][] mPoints;

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

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00eb A[SYNTHETIC] */
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
