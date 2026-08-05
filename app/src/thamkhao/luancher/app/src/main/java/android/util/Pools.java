package android.util;

/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    public interface Pool {
        Object acquire();

        boolean release(Object obj);
    }

    public class SimplePool implements Pool {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i];
        }

        private boolean isInPool(Object obj) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == obj) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.util.Pools.Pool
        public Object acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i = this.mPoolSize - 1;
            Object obj = this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize--;
            return obj;
        }

        @Override // android.util.Pools.Pool
        public boolean release(Object obj) {
            if (isInPool(obj)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.mPoolSize >= this.mPool.length) {
                return false;
            }
            this.mPool[this.mPoolSize] = obj;
            this.mPoolSize++;
            return true;
        }
    }

    public class SynchronizedPool extends SimplePool {
        private final Object mLock;

        public SynchronizedPool(int i) {
            super(i);
            this.mLock = new Object();
        }

        @Override // android.util.Pools.SimplePool, android.util.Pools.Pool
        public Object acquire() {
            Object objAcquire;
            synchronized (this.mLock) {
                objAcquire = super.acquire();
            }
            return objAcquire;
        }

        @Override // android.util.Pools.SimplePool, android.util.Pools.Pool
        public boolean release(Object obj) {
            boolean zRelease;
            synchronized (this.mLock) {
                zRelease = super.release(obj);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
