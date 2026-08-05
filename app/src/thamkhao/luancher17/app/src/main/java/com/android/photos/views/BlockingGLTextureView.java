package com.android.photos.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.Log;
import android.view.TextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public class BlockingGLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private RenderThread mRenderThread;

    public BlockingGLTextureView(Context context) {
        super(context);
        setSurfaceTextureListener(this);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        if (this.mRenderThread != null) {
            throw new IllegalArgumentException("Renderer already set");
        }
        this.mRenderThread = new RenderThread(renderer);
    }

    public void render() {
        this.mRenderThread.render();
    }

    public void destroy() {
        if (this.mRenderThread != null) {
            this.mRenderThread.finish();
            this.mRenderThread = null;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.mRenderThread.setSurface(surface);
        this.mRenderThread.setSize(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        this.mRenderThread.setSize(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        if (this.mRenderThread != null) {
            this.mRenderThread.setSurface(null);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    protected void finalize() throws Throwable {
        try {
            destroy();
        } catch (Throwable th) {
        }
        super.finalize();
    }

    private static class EglHelper {
        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        private static final int EGL_OPENGL_ES2_BIT = 4;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;

        private EglHelper() {
        }

        /* synthetic */ EglHelper(EglHelper eglHelper) {
            this();
        }

        private EGLConfig chooseEglConfig() {
            int[] configsCount = new int[1];
            EGLConfig[] configs = new EGLConfig[1];
            int[] configSpec = getConfig();
            if (!this.mEgl.eglChooseConfig(this.mEglDisplay, configSpec, configs, 1, configsCount)) {
                throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.mEgl.eglGetError()));
            }
            if (configsCount[0] > 0) {
                return configs[0];
            }
            return null;
        }

        private static int[] getConfig() {
            return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
        }

        EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
            int[] attribList = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            return egl.eglCreateContext(eglDisplay, eglConfig, EGL10.EGL_NO_CONTEXT, attribList);
        }

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            int[] version = new int[2];
            if (!this.mEgl.eglInitialize(this.mEglDisplay, version)) {
                throw new RuntimeException("eglInitialize failed");
            }
            this.mEglConfig = chooseEglConfig();
            this.mEglContext = createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                this.mEglContext = null;
                throwEglException("createContext");
            }
            this.mEglSurface = null;
        }

        public boolean createSurface(SurfaceTexture surface) {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurfaceImp();
            if (surface != null) {
                this.mEglSurface = this.mEgl.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, surface, null);
            } else {
                this.mEglSurface = null;
            }
            if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                int error = this.mEgl.eglGetError();
                if (error != 12299) {
                    return false;
                }
                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                return false;
            }
            if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            }
            return true;
        }

        public GL10 createGL() {
            return (GL10) this.mEglContext.getGL();
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            if (this.mEglSurface != null && this.mEglSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                this.mEgl.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
                this.mEglSurface = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String function) {
            throwEglException(function, this.mEgl.eglGetError());
        }

        public static void throwEglException(String function, int error) {
            String message = formatEglError(function, error);
            throw new RuntimeException(message);
        }

        public static void logEglErrorAsWarning(String tag, String function, int error) {
            Log.w(tag, formatEglError(function, error));
        }

        public static String formatEglError(String function, int error) {
            return String.valueOf(function) + " failed: " + error;
        }
    }

    private static class RenderThread extends Thread {
        private static final int CHANGE_SURFACE = 2;
        private static final int FINISH = 4;
        private static final int INVALID = -1;
        private static final int RENDER = 1;
        private static final int RESIZE_SURFACE = 3;
        private EglHelper mEglHelper;
        private int mExecMsgId;
        private boolean mFinished;
        private GL10 mGL;
        private int mHeight;
        private Object mLock;
        private GLSurfaceView.Renderer mRenderer;
        private SurfaceTexture mSurface;
        private int mWidth;

        public RenderThread(GLSurfaceView.Renderer renderer) {
            super("RenderThread");
            this.mEglHelper = new EglHelper(null);
            this.mLock = new Object();
            this.mExecMsgId = -1;
            this.mFinished = false;
            this.mRenderer = renderer;
            start();
        }

        private void checkRenderer() {
            if (this.mRenderer == null) {
                throw new IllegalArgumentException("Renderer is null!");
            }
        }

        private void checkSurface() {
            if (this.mSurface == null) {
                throw new IllegalArgumentException("surface is null!");
            }
        }

        public void setSurface(SurfaceTexture surface) {
            if (surface != null) {
                checkRenderer();
            }
            this.mSurface = surface;
            exec(2);
        }

        public void setSize(int width, int height) {
            checkRenderer();
            checkSurface();
            this.mWidth = width;
            this.mHeight = height;
            exec(3);
        }

        public void render() {
            checkRenderer();
            if (this.mSurface != null) {
                exec(1);
                this.mSurface.updateTexImage();
            }
        }

        public void finish() {
            this.mSurface = null;
            exec(4);
            try {
                join();
            } catch (InterruptedException e) {
            }
        }

        private void exec(int msgid) {
            synchronized (this.mLock) {
                if (this.mExecMsgId != -1) {
                    throw new IllegalArgumentException("Message already set - multithreaded access?");
                }
                this.mExecMsgId = msgid;
                this.mLock.notify();
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                }
            }
        }

        private void handleMessageLocked(int what) {
            switch (what) {
                case 1:
                    this.mRenderer.onDrawFrame(this.mGL);
                    this.mEglHelper.swap();
                    break;
                case 2:
                    if (this.mEglHelper.createSurface(this.mSurface)) {
                        this.mGL = this.mEglHelper.createGL();
                        this.mRenderer.onSurfaceCreated(this.mGL, this.mEglHelper.mEglConfig);
                    }
                    break;
                case 3:
                    this.mRenderer.onSurfaceChanged(this.mGL, this.mWidth, this.mHeight);
                    break;
                case 4:
                    this.mEglHelper.destroySurface();
                    this.mEglHelper.finish();
                    this.mFinished = true;
                    break;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.mLock) {
                this.mEglHelper.start();
                while (!this.mFinished) {
                    while (this.mExecMsgId == -1) {
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    handleMessageLocked(this.mExecMsgId);
                    this.mExecMsgId = -1;
                    this.mLock.notify();
                }
                this.mExecMsgId = 4;
            }
        }
    }
}
