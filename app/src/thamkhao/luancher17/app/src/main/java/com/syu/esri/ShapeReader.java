package com.syu.esri;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/esri/ShapeReader.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class ShapeReader {
    public static final int SHAPE_TYPE_POINT = 1;
    public static final int SHAPE_TYPE_POLYGON = 5;
    public static final int SHAPE_TYPE_POLYLINE = 3;

    public static Object readReacod(byte[] data, int offset) {
        int offset2 = offset << 1;
        int recordType = littleInt(data, offset2 + 8);
        switch (recordType) {
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return null;
            case 5:
                return readPolygon(data, offset2);
        }
    }

    public static Polygon readPolygon(byte[] data, int offset) {
        int cnt;
        int recordNum = bigInt(data, offset);
        int offset2 = offset + 12;
        double minX = littleDouble(data, offset2);
        double minY = littleDouble(data, offset2 + 8);
        double maxX = littleDouble(data, offset2 + 16);
        double maxY = littleDouble(data, offset2 + 24);
        int partCnt = littleInt(data, offset2 + 32);
        int pointCnt = littleInt(data, offset2 + 36);
        int offset3 = offset2 + 40;
        int[] partIndices = new int[partCnt];
        for (int i = 0; i < partCnt; i++) {
            partIndices[i] = littleInt(data, (i * 4) + offset3);
        }
        int offset4 = offset3 + (partCnt * 4);
        double[][] points = new double[partCnt][];
        int i2 = 0;
        while (i2 < partCnt) {
            if (partCnt == 1) {
                cnt = pointCnt;
            } else {
                cnt = (i2 == partCnt + (-1) ? pointCnt : partIndices[i2 + 1]) - partIndices[i2];
            }
            points[i2] = new double[cnt << 1];
            for (int j = 0; j < cnt; j++) {
                points[i2][j << 1] = littleDouble(data, offset4);
                points[i2][(j << 1) + 1] = littleDouble(data, offset4 + 8);
                offset4 += 16;
            }
            i2++;
        }
        return new Polygon(recordNum, minX, minY, maxX, maxY, points);
    }

    public static ShapeIndex readShapeIndex(String path) throws Throwable {
        ShapeIndex shx = null;
        DataInputStream dis = null;
        try {
            try {
                DataInputStream dis2 = new DataInputStream(new FileInputStream(path));
                try {
                    shx = readShapeIndex(dis2);
                    if (dis2 != null) {
                        try {
                            dis2.close();
                            dis = dis2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            dis = dis2;
                        }
                    } else {
                        dis = dis2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dis = dis2;
                    e.printStackTrace();
                    if (dis != null) {
                        try {
                            dis.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    dis = dis2;
                    if (dis != null) {
                        try {
                            dis.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return shx;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ShapeIndex readShapeIndex(DataInputStream dis) throws IOException {
        int fileCode = dis.readInt();
        dis.skipBytes(20);
        int fileLength = dis.readInt();
        byte[] data = new byte[4];
        dis.read(data, 0, 4);
        int version = littleInt(data, 0);
        dis.read(data, 0, 4);
        int shapeType = littleInt(data, 0);
        byte[] d = new byte[8];
        dis.read(d, 0, 8);
        double minX = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double minY = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double maxX = littleDouble(d, 0);
        dis.read(d, 0, 8);
        double maxY = littleDouble(d, 0);
        dis.skip(32L);
        List<Integer> list = new ArrayList<>(1024);
        while (dis.available() > 0) {
            int offset = dis.readInt();
            int length = dis.readInt();
            list.add(Integer.valueOf(offset));
            list.add(Integer.valueOf(length));
        }
        int[] indices = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            indices[i] = list.get(i).intValue();
        }
        return new ShapeIndex(fileCode, fileLength, version, shapeType, minX, minY, maxX, maxY, indices);
    }

    public static int bigInt(byte[] data, int offset) {
        return (data[offset + 0] << 24) | ((data[offset + 1] & 255) << 16) | ((data[offset + 2] & 255) << 8) | (data[offset + 3] & 255);
    }

    public static int littleInt(byte[] data, int offset) {
        return (data[offset + 3] << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 1] & 255) << 8) | (data[offset + 0] & 255);
    }

    public static double littleDouble(byte[] data, int offset) {
        long lvalue = (((long) data[offset + 7]) << 56) | (((long) (data[offset + 6] & 255)) << 48) | (((long) (data[offset + 5] & 255)) << 40) | (((long) (data[offset + 4] & 255)) << 32) | (((long) (data[offset + 3] & 255)) << 24) | (((long) (data[offset + 2] & 255)) << 16) | (((long) (data[offset + 1] & 255)) << 8) | ((long) (data[offset + 0] & 255));
        return Double.longBitsToDouble(lvalue);
    }

    public static byte[] getFileData(String path) throws Throwable {
        byte[] data;
        byte[] data2 = null;
        InputStream is = null;
        try {
            try {
                InputStream is2 = new FileInputStream(path);
                try {
                    int size = is2.available();
                    if (size <= 0) {
                        if (is2 != null) {
                            try {
                                is2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        is = is2;
                        data = null;
                    } else {
                        data2 = new byte[size];
                        is2.read(data2);
                        if (is2 != null) {
                            try {
                                is2.close();
                                is = is2;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                is = is2;
                            }
                        } else {
                            is = is2;
                        }
                        data = data2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    is = is2;
                    e.printStackTrace();
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    is = is2;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
            return data;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
