package android.support.v4.media;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/IMediaBrowserServiceCallbacksAdapterApi21.class */
class IMediaBrowserServiceCallbacksAdapterApi21 {
    Object mCallbackObject;
    private Method mAsBinderMethod;
    private Method mOnConnectMethod;
    private Method mOnConnectFailedMethod;
    private Method mOnLoadChildrenMethod;

    IMediaBrowserServiceCallbacksAdapterApi21(Object callbackObject) {
        this.mCallbackObject = callbackObject;
        try {
            Class<?> cls = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            Class<?> cls2 = Class.forName("android.content.pm.ParceledListSlice");
            this.mAsBinderMethod = cls.getMethod("asBinder", new Class[0]);
            this.mOnConnectMethod = cls.getMethod("onConnect", String.class, MediaSession.Token.class, Bundle.class);
            this.mOnConnectFailedMethod = cls.getMethod("onConnectFailed", new Class[0]);
            this.mOnLoadChildrenMethod = cls.getMethod("onLoadChildren", String.class, cls2);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    IBinder asBinder() {
        IBinder result = null;
        try {
            result = (IBinder) this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    void onConnect(String root, Object session, Bundle extras) throws RemoteException {
        try {
            this.mOnConnectMethod.invoke(this.mCallbackObject, root, session, extras);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void onConnectFailed() throws RemoteException {
        try {
            this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void onLoadChildren(String mediaId, Object parceledListSliceObj) throws RemoteException {
        try {
            this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, mediaId, parceledListSliceObj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/media/IMediaBrowserServiceCallbacksAdapterApi21$Stub.class */
    static class Stub {
        static Method sAsInterfaceMethod;

        Stub() {
        }

        static {
            try {
                sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", IBinder.class);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        static Object asInterface(IBinder binder) {
            Object result = null;
            try {
                result = sAsInterfaceMethod.invoke(null, binder);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
