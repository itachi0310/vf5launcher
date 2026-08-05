package imagecoverflow;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.Scroller;
import com.android.launcher17.Launcher;
import com.android.launcher17.R;
import com.syu.ipc.data.FinalCanbus;
import imagecoverflow.CoverFlowAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CoverFlowView<T extends CoverFlowAdapter> extends View {
    private static final float CARD_SCALE = 0.25f;
    protected static final int DEFAULT_VISIBLE_IMAGES = 3;
    private static final int DURATION = 200;
    private static final float FRICTION = 10.0f;
    private static final float MAX_SPEED = 6.0f;
    private static final float MOVE_SPEED_MULTIPLE = 1.0f;
    static final int NO_POSITION = -1;
    private static final int TOUCH_MINIMUM_MOVE = 5;
    private static final String VIEW_LOG_TAG = "CoverFlowView";
    private final int ALPHA_DATUM;
    protected final int CHILD_SPACING;
    protected final int INVALID_POSITION;
    private int STANDARD_ALPHA;
    private T mAdapter;
    private Runnable mAnimationRunnable;
    private int mChildHeight;
    private Matrix mChildTransformer;
    private int mChildTranslateY;
    protected int mCoverFlowCenter;
    private CoverFlowListener<T> mCoverFlowListener;
    private Rect mCoverFlowPadding;
    boolean mDataSetChanged;
    private DataSetObserver mDataSetObserver;
    private Paint mDrawChildPaint;
    private PaintFlagsDrawFilter mDrawFilter;
    private float mDuration;
    protected CoverFlowGravity mGravity;
    private Handler mHandler;
    private SparseArray<int[]> mImageRecorder;
    private int mItemCount;
    protected CoverFlowLayoutMode mLayoutMode;
    private TopImageLongClickListener mLongClickListener;
    private boolean mLongClickPosted;
    private CoverFlowView<T>.LongClickRunnable mLongClickRunnable;
    private boolean mLongClickTriggled;
    private float mOffset;
    private CoverFlowView<T>.RecycleBin mRecycler;
    private Matrix mReflectionTransformer;
    private int mReflectionTranslateY;
    Runnable mRunnableSetSelection;
    private Scroller mScroller;
    private float mStartOffset;
    private float mStartSpeed;
    private long mStartTime;
    private int mTopImageIndex;
    private boolean mTouchMoved;
    private RectF mTouchRect;
    private float mTouchStartPos;
    private float mTouchStartX;
    private float mTouchStartY;
    private VelocityTracker mVelocity;
    private int mVisibleChildCount;
    protected int mVisibleImages;
    private int mWidth;
    private int reflectGap;
    private float reflectHeightFraction;
    int temp;
    String temps;
    private ArrayList<Bitmap> topImageBkList;
    private boolean topImageClickEnable;
    private static float MOVE_POS_MULTIPLE = 20.0f;
    private static final int LONG_CLICK_DELAY = ViewConfiguration.getLongPressTimeout();
    public static int ActionState = 0;

    public enum CoverFlowGravity {
        TOP,
        BOTTOM,
        CENTER_VERTICAL;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static CoverFlowGravity[] valuesCustom() {
            CoverFlowGravity[] coverFlowGravityArrValuesCustom = values();
            int length = coverFlowGravityArrValuesCustom.length;
            CoverFlowGravity[] coverFlowGravityArr = new CoverFlowGravity[length];
            System.arraycopy(coverFlowGravityArrValuesCustom, 0, coverFlowGravityArr, 0, length);
            return coverFlowGravityArr;
        }
    }

    public enum CoverFlowLayoutMode {
        MATCH_PARENT,
        WRAP_CONTENT;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static CoverFlowLayoutMode[] valuesCustom() {
            CoverFlowLayoutMode[] coverFlowLayoutModeArrValuesCustom = values();
            int length = coverFlowLayoutModeArrValuesCustom.length;
            CoverFlowLayoutMode[] coverFlowLayoutModeArr = new CoverFlowLayoutMode[length];
            System.arraycopy(coverFlowLayoutModeArrValuesCustom, 0, coverFlowLayoutModeArr, 0, length);
            return coverFlowLayoutModeArr;
        }
    }

    public interface CoverFlowListener<V extends CoverFlowAdapter> {
        void imageOnTop(CoverFlowView<V> coverFlowView, int i, float f, float f2, float f3, float f4);

        void invalidationCompleted();

        void topImageClicked(CoverFlowView<V> coverFlowView, int i);
    }

    public interface TopImageLongClickListener {
        void onLongClick(int i);
    }

    public CoverFlowView(Context context) {
        super(context);
        this.INVALID_POSITION = -1;
        this.mVisibleImages = 3;
        this.CHILD_SPACING = -200;
        this.ALPHA_DATUM = 76;
        this.topImageClickEnable = true;
        this.mHandler = new Handler();
        this.mDataSetObserver = new DataSetObserver() { // from class: imagecoverflow.CoverFlowView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int nextItemCount = CoverFlowView.this.mAdapter.getCount();
                if (CoverFlowView.this.mTopImageIndex % CoverFlowView.this.mItemCount > nextItemCount - 1) {
                    CoverFlowView.this.mOffset = (nextItemCount - CoverFlowView.this.mVisibleImages) - 1;
                } else {
                    CoverFlowView.this.mOffset += CoverFlowView.this.mVisibleImages;
                    while (true) {
                        if (CoverFlowView.this.mOffset >= 0.0f && CoverFlowView.this.mOffset < CoverFlowView.this.mItemCount) {
                            break;
                        }
                        if (CoverFlowView.this.mOffset < 0.0f) {
                            CoverFlowView.this.mOffset += CoverFlowView.this.mItemCount;
                        } else if (CoverFlowView.this.mOffset >= CoverFlowView.this.mItemCount) {
                            CoverFlowView.this.mOffset -= CoverFlowView.this.mItemCount;
                        }
                    }
                    CoverFlowView.this.mOffset -= CoverFlowView.this.mVisibleImages;
                }
                CoverFlowView.this.mItemCount = nextItemCount;
                CoverFlowView.this.resetCoverFlow();
                CoverFlowView.this.requestLayout();
                CoverFlowView.this.invalidate();
                super.onChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
        this.mRunnableSetSelection = new Runnable() { // from class: imagecoverflow.CoverFlowView.2
            @Override // java.lang.Runnable
            public void run() {
                int index;
                if (!CoverFlowView.this.mTouchMoved && (index = CoverFlowView.this.temp) >= 0) {
                    CoverFlowView.this.setSelection(index);
                }
            }
        };
        init();
    }

    public CoverFlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.INVALID_POSITION = -1;
        this.mVisibleImages = 3;
        this.CHILD_SPACING = -200;
        this.ALPHA_DATUM = 76;
        this.topImageClickEnable = true;
        this.mHandler = new Handler();
        this.mDataSetObserver = new DataSetObserver() { // from class: imagecoverflow.CoverFlowView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int nextItemCount = CoverFlowView.this.mAdapter.getCount();
                if (CoverFlowView.this.mTopImageIndex % CoverFlowView.this.mItemCount > nextItemCount - 1) {
                    CoverFlowView.this.mOffset = (nextItemCount - CoverFlowView.this.mVisibleImages) - 1;
                } else {
                    CoverFlowView.this.mOffset += CoverFlowView.this.mVisibleImages;
                    while (true) {
                        if (CoverFlowView.this.mOffset >= 0.0f && CoverFlowView.this.mOffset < CoverFlowView.this.mItemCount) {
                            break;
                        }
                        if (CoverFlowView.this.mOffset < 0.0f) {
                            CoverFlowView.this.mOffset += CoverFlowView.this.mItemCount;
                        } else if (CoverFlowView.this.mOffset >= CoverFlowView.this.mItemCount) {
                            CoverFlowView.this.mOffset -= CoverFlowView.this.mItemCount;
                        }
                    }
                    CoverFlowView.this.mOffset -= CoverFlowView.this.mVisibleImages;
                }
                CoverFlowView.this.mItemCount = nextItemCount;
                CoverFlowView.this.resetCoverFlow();
                CoverFlowView.this.requestLayout();
                CoverFlowView.this.invalidate();
                super.onChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
        this.mRunnableSetSelection = new Runnable() { // from class: imagecoverflow.CoverFlowView.2
            @Override // java.lang.Runnable
            public void run() {
                int index;
                if (!CoverFlowView.this.mTouchMoved && (index = CoverFlowView.this.temp) >= 0) {
                    CoverFlowView.this.setSelection(index);
                }
            }
        };
        initAttributes(context, attrs);
        init();
    }

    public CoverFlowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.INVALID_POSITION = -1;
        this.mVisibleImages = 3;
        this.CHILD_SPACING = -200;
        this.ALPHA_DATUM = 76;
        this.topImageClickEnable = true;
        this.mHandler = new Handler();
        this.mDataSetObserver = new DataSetObserver() { // from class: imagecoverflow.CoverFlowView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int nextItemCount = CoverFlowView.this.mAdapter.getCount();
                if (CoverFlowView.this.mTopImageIndex % CoverFlowView.this.mItemCount > nextItemCount - 1) {
                    CoverFlowView.this.mOffset = (nextItemCount - CoverFlowView.this.mVisibleImages) - 1;
                } else {
                    CoverFlowView.this.mOffset += CoverFlowView.this.mVisibleImages;
                    while (true) {
                        if (CoverFlowView.this.mOffset >= 0.0f && CoverFlowView.this.mOffset < CoverFlowView.this.mItemCount) {
                            break;
                        }
                        if (CoverFlowView.this.mOffset < 0.0f) {
                            CoverFlowView.this.mOffset += CoverFlowView.this.mItemCount;
                        } else if (CoverFlowView.this.mOffset >= CoverFlowView.this.mItemCount) {
                            CoverFlowView.this.mOffset -= CoverFlowView.this.mItemCount;
                        }
                    }
                    CoverFlowView.this.mOffset -= CoverFlowView.this.mVisibleImages;
                }
                CoverFlowView.this.mItemCount = nextItemCount;
                CoverFlowView.this.resetCoverFlow();
                CoverFlowView.this.requestLayout();
                CoverFlowView.this.invalidate();
                super.onChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
            }
        };
        this.mRunnableSetSelection = new Runnable() { // from class: imagecoverflow.CoverFlowView.2
            @Override // java.lang.Runnable
            public void run() {
                int index;
                if (!CoverFlowView.this.mTouchMoved && (index = CoverFlowView.this.temp) >= 0) {
                    CoverFlowView.this.setSelection(index);
                }
            }
        };
        initAttributes(context, attrs);
        init();
    }

    private void initAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageCoverFlowView);
        int totalVisibleChildren = a.getInt(0, 3);
        setVisibleImage(totalVisibleChildren);
        this.reflectHeightFraction = a.getFraction(1, 100, 0, 0.0f);
        if (this.reflectHeightFraction > 100.0f) {
            this.reflectHeightFraction = 100.0f;
        }
        this.reflectHeightFraction /= 100.0f;
        this.reflectGap = a.getDimensionPixelSize(2, 0);
        this.mGravity = CoverFlowGravity.valuesCustom()[a.getInt(4, CoverFlowGravity.CENTER_VERTICAL.ordinal())];
        this.mLayoutMode = CoverFlowLayoutMode.valuesCustom()[a.getInt(5, CoverFlowLayoutMode.WRAP_CONTENT.ordinal())];
        a.recycle();
    }

    private void init() {
        setWillNotDraw(false);
        setClickable(true);
        this.mChildTransformer = new Matrix();
        this.mReflectionTransformer = new Matrix();
        this.mTouchRect = new RectF();
        this.mImageRecorder = new SparseArray<>();
        this.mDrawChildPaint = new Paint();
        this.mDrawChildPaint.setAntiAlias(true);
        this.mDrawChildPaint.setFlags(1);
        this.mCoverFlowPadding = new Rect();
        this.mDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mScroller = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
    }

    public void setAdapter(T adapter) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mAdapter = adapter;
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mItemCount = this.mAdapter.getCount();
            if (this.mRecycler != null) {
                this.mRecycler.clear();
            } else {
                this.mRecycler = new RecycleBin();
            }
        }
        this.mOffset = 0.0f;
        resetCoverFlow();
        requestLayout();
    }

    public T getAdapter() {
        return this.mAdapter;
    }

    public void setCoverFlowListener(CoverFlowListener<T> l) {
        this.mCoverFlowListener = l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCoverFlow() {
        if (this.mItemCount < 3) {
            throw new IllegalArgumentException("total count in adapter must larger than 3!");
        }
        int totalVisible = (this.mVisibleImages * 2) + 1;
        if (this.mItemCount < totalVisible) {
            this.mVisibleImages = (this.mItemCount - 1) / 2;
        }
        this.mChildHeight = 0;
        this.STANDARD_ALPHA = FinalCanbus.CAR_WC1_BMW_MINI / this.mVisibleImages;
        if (this.mGravity == null) {
            this.mGravity = CoverFlowGravity.CENTER_VERTICAL;
        }
        if (this.mLayoutMode == null) {
            this.mLayoutMode = CoverFlowLayoutMode.WRAP_CONTENT;
        }
        this.mImageRecorder.clear();
        this.mTopImageIndex = -1;
        this.mDataSetChanged = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Bitmap child;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mAdapter != null && this.mDataSetChanged) {
            this.mCoverFlowPadding.left = getPaddingLeft();
            this.mCoverFlowPadding.right = getPaddingRight();
            this.mCoverFlowPadding.top = getPaddingTop();
            this.mCoverFlowPadding.bottom = getPaddingBottom();
            int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
            int availableHeight = (heightSize - this.mCoverFlowPadding.top) - this.mCoverFlowPadding.bottom;
            int maxChildTotalHeight = 0;
            int visibleCount = (this.mVisibleImages << 1) + 1;
            int mid = (int) Math.floor(((double) this.mOffset) + 0.5d);
            int leftChild = visibleCount >> 1;
            int startPos = getActuallyPosition(mid - leftChild);
            for (int i = startPos; i < visibleCount + startPos; i++) {
                if (i == 10) {
                    child = this.mAdapter.getImage(0);
                } else if (i == 11) {
                    child = this.mAdapter.getImage(1);
                } else {
                    child = this.mAdapter.getImage(i);
                }
                int childHeight = child.getHeight();
                int childTotalHeight = (int) (childHeight + (childHeight * this.reflectHeightFraction) + this.reflectGap);
                if (maxChildTotalHeight < childTotalHeight) {
                    maxChildTotalHeight = childTotalHeight;
                }
            }
            if (heightMode == 1073741824 || heightMode == Integer.MIN_VALUE) {
                if (availableHeight < maxChildTotalHeight || this.mLayoutMode == CoverFlowLayoutMode.MATCH_PARENT) {
                    this.mChildHeight = availableHeight;
                } else if (this.mLayoutMode == CoverFlowLayoutMode.WRAP_CONTENT) {
                    this.mChildHeight = maxChildTotalHeight;
                    if (heightMode == Integer.MIN_VALUE) {
                        heightSize = this.mChildHeight + this.mCoverFlowPadding.top + this.mCoverFlowPadding.bottom;
                    }
                }
            } else if (this.mLayoutMode == CoverFlowLayoutMode.MATCH_PARENT) {
                this.mChildHeight = availableHeight;
            } else if (this.mLayoutMode == CoverFlowLayoutMode.WRAP_CONTENT) {
                this.mChildHeight = maxChildTotalHeight;
                heightSize = this.mChildHeight + this.mCoverFlowPadding.top + this.mCoverFlowPadding.bottom;
            }
            if (this.mGravity == CoverFlowGravity.CENTER_VERTICAL) {
                this.mChildTranslateY = (heightSize >> 1) - (this.mChildHeight >> 1);
            } else if (this.mGravity == CoverFlowGravity.TOP) {
                this.mChildTranslateY = this.mCoverFlowPadding.top;
            } else if (this.mGravity == CoverFlowGravity.BOTTOM) {
                this.mChildTranslateY = (heightSize - this.mCoverFlowPadding.bottom) - this.mChildHeight;
            }
            this.mReflectionTranslateY = (int) ((this.mChildTranslateY + this.mChildHeight) - (this.mChildHeight * this.reflectHeightFraction));
            setMeasuredDimension(widthSize, heightSize);
            this.mVisibleChildCount = visibleCount;
            this.mWidth = widthSize;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mAdapter == null) {
            super.onDraw(canvas);
            return;
        }
        canvas.setDrawFilter(this.mDrawFilter);
        float offset = this.mOffset;
        int mid = (int) Math.floor(((double) offset) + 0.5d);
        int rightChild = this.mVisibleChildCount % 2 == 0 ? (this.mVisibleChildCount >> 1) - 1 : this.mVisibleChildCount >> 1;
        int leftChild = this.mVisibleChildCount >> 1;
        int startPos = mid - leftChild;
        for (int i = startPos; i < mid; i++) {
            drawChild(canvas, mid, i, i - offset);
        }
        int endPos = mid + rightChild;
        for (int i2 = endPos; i2 >= mid; i2--) {
            drawChild(canvas, mid, i2, i2 - offset);
        }
        if (offset - ((int) offset) == 0.0f) {
            imageOnTop(getActuallyPosition((int) offset));
        }
        super.onDraw(canvas);
        this.mCoverFlowListener.invalidationCompleted();
    }

    protected final void drawChild(Canvas canvas, int mid, int position, float offset) {
        int actuallyPosition = getActuallyPosition(position);
        Bitmap child = this.mAdapter.getImage(actuallyPosition);
        Bitmap reflection = obtainReflection(child);
        int[] wAndh = this.mImageRecorder.get(actuallyPosition);
        if (wAndh == null) {
            this.mImageRecorder.put(actuallyPosition, new int[]{child.getWidth(), child.getHeight()});
        } else {
            wAndh[0] = child.getWidth();
            wAndh[1] = child.getHeight();
        }
        if (child != null && !child.isRecycled() && canvas != null) {
            makeChildTransformer(child, mid, position, offset);
            canvas.drawBitmap(child, this.mChildTransformer, this.mDrawChildPaint);
            if (reflection != null) {
                canvas.drawBitmap(reflection, this.mReflectionTransformer, this.mDrawChildPaint);
            }
        }
    }

    private void makeChildTransformer(Bitmap child, int mid, int position, float offset) {
        this.mChildTransformer.reset();
        this.mReflectionTransformer.reset();
        float scale = MOVE_SPEED_MULTIPLE;
        if (position == mid) {
            scale = 1.3f;
        }
        int childTotalHeight = (int) (child.getHeight() + (child.getHeight() * this.reflectHeightFraction) + this.reflectGap);
        int childWidth = (int) (child.getWidth() * scale);
        int centerChildWidth = (int) (child.getWidth() * scale);
        int leftSpace = ((this.mWidth >> 1) - this.mCoverFlowPadding.left) - (centerChildWidth >> 1);
        int rightSpace = ((this.mWidth >> 1) - this.mCoverFlowPadding.right) - (centerChildWidth >> 1);
        float translateX = offset <= 0.0f ? ((leftSpace / this.mVisibleImages) * (this.mVisibleImages + offset)) + this.mCoverFlowPadding.left : ((this.mWidth - ((rightSpace / this.mVisibleImages) * (this.mVisibleImages - offset))) - childWidth) - this.mCoverFlowPadding.right;
        this.mChildTransformer.preTranslate(0.0f, -(childTotalHeight >> 1));
        this.mChildTransformer.postScale(scale, scale);
        float adjustedChildTranslateY = scale != MOVE_SPEED_MULTIPLE ? (this.mChildHeight - childTotalHeight) >> 1 : 0.0f;
        this.mChildTransformer.postTranslate(translateX, this.mChildTranslateY + adjustedChildTranslateY);
        getCustomTransformMatrix(this.mChildTransformer, this.mDrawChildPaint, child, position, offset);
        this.mChildTransformer.postTranslate(0.0f, childTotalHeight >> 1);
        this.mReflectionTransformer.preTranslate(0.0f, -(childTotalHeight >> 1));
        this.mReflectionTransformer.postTranslate(translateX, (this.mReflectionTranslateY * scale) + adjustedChildTranslateY);
        getCustomTransformMatrix(this.mReflectionTransformer, this.mDrawChildPaint, child, position, offset);
        this.mReflectionTransformer.postTranslate(0.0f, childTotalHeight >> 1);
    }

    protected void getCustomTransformMatrix(Matrix transfromer, Paint mDrawChildPaint, Bitmap child, int position, float offset) {
    }

    private void imageOnTop(int position) {
        this.mTopImageIndex = position;
        if (Launcher.coverFlowText != null) {
            switch (this.mTopImageIndex) {
                case 0:
                    Launcher.coverFlowText.setText(R.string.car_radio);
                    break;
                case 1:
                    Launcher.coverFlowText.setText(R.string.car_bt);
                    break;
                case 2:
                    Launcher.coverFlowText.setText(R.string.car_navi);
                    break;
                case 3:
                    Launcher.coverFlowText.setText(R.string.car_music);
                    break;
                case 4:
                    Launcher.coverFlowText.setText(R.string.car_setting);
                    break;
                case 5:
                    Launcher.coverFlowText.setText(R.string.car_video);
                    break;
                case 6:
                    Launcher.coverFlowText.setText(R.string.car_car);
                    break;
                case 7:
                    Launcher.coverFlowText.setText(R.string.car_dvr);
                    break;
                case 8:
                    Launcher.coverFlowText.setText(R.string.car_voice);
                    break;
                case 9:
                    Launcher.coverFlowText.setText(R.string.car_easyconn);
                    break;
            }
        }
        int[] wAndh = this.mImageRecorder.get(position);
        int heightInView = (int) ((this.mChildHeight - (this.mChildHeight * this.reflectHeightFraction)) - this.reflectGap);
        float scale = heightInView / wAndh[1];
        int widthInView = (int) (wAndh[0] * scale);
        Log.e(VIEW_LOG_TAG, "height ==>" + heightInView + " width ==>" + widthInView + "scale" + scale);
        this.mTouchRect.left = (this.mWidth >> 1) - (widthInView >> 1);
        this.mTouchRect.top = this.mChildTranslateY;
        this.mTouchRect.right = this.mTouchRect.left + widthInView;
        this.mTouchRect.bottom = this.mTouchRect.top + heightInView;
        Log.e(VIEW_LOG_TAG, "rect==>" + this.mTouchRect);
        if (this.mCoverFlowListener != null) {
            this.mCoverFlowListener.imageOnTop(this, position, this.mTouchRect.left, this.mTouchRect.top, this.mTouchRect.right, this.mTouchRect.bottom);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int action = event.getAction();
        switch (action) {
            case 0:
                if (this.mScroller.computeScrollOffset()) {
                    this.mScroller.abortAnimation();
                    invalidate();
                }
                stopLongClick();
                triggleLongClick(event.getX(), event.getY());
                touchBegan(event);
                ActionState = 0;
                this.mHandler.removeCallbacks(this.mRunnableSetSelection);
                return true;
            case 1:
                touchEnded(event);
                stopLongClick();
                ActionState = 1;
                this.mHandler.postDelayed(this.mRunnableSetSelection, 0L);
                return true;
            case 2:
                touchMoved(event);
                ActionState = 2;
                return true;
            default:
                return false;
        }
    }

    private void triggleLongClick(float x, float y) {
        if (this.mTouchRect.contains(x, y) && this.mLongClickListener != null && this.topImageClickEnable && !this.mLongClickPosted) {
            int actuallyPosition = this.mTopImageIndex;
            this.mLongClickRunnable.setPosition(actuallyPosition);
            postDelayed(this.mLongClickRunnable, LONG_CLICK_DELAY);
        }
    }

    private void stopLongClick() {
        if (this.mLongClickRunnable != null) {
            removeCallbacks(this.mLongClickRunnable);
            this.mLongClickPosted = false;
            this.mLongClickTriggled = false;
        }
    }

    private void touchBegan(MotionEvent event) {
        endAnimation();
        float x = event.getX();
        this.mTouchStartX = x;
        this.mTouchStartY = event.getY();
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartOffset = this.mOffset;
        this.mTouchMoved = false;
        this.mTouchStartPos = ((x / this.mWidth) * MOVE_POS_MULTIPLE) - 5.0f;
        this.mTouchStartPos /= 2.0f;
        this.mVelocity = VelocityTracker.obtain();
        this.mVelocity.addMovement(event);
    }

    private void touchMoved(MotionEvent event) {
        float pos = ((event.getX() / this.mWidth) * MOVE_POS_MULTIPLE) - 5.0f;
        float pos2 = pos / 2.0f;
        if (!this.mTouchMoved) {
            float dx = Math.abs(event.getX() - this.mTouchStartX);
            float dy = Math.abs(event.getY() - this.mTouchStartY);
            if (dx >= 5.0f || dy >= 5.0f) {
                this.mTouchMoved = true;
                stopLongClick();
            } else {
                return;
            }
        }
        this.mOffset = (this.mStartOffset + this.mTouchStartPos) - pos2;
        invalidate();
        this.mVelocity.addMovement(event);
    }

    private void touchEnded(MotionEvent event) {
        float pos = (((event.getX() / this.mWidth) * MOVE_POS_MULTIPLE) - 5.0f) / 2.0f;
        if (!this.mTouchMoved) {
            if (pos < 3.65f && pos > 1.36f) {
                this.temp = this.mTopImageIndex;
                if (this.temp < 0) {
                    this.temp = this.mAdapter.getCount() + this.temp;
                }
                this.temps = new StringBuilder(String.valueOf(this.temp)).toString();
                this.mCoverFlowListener.topImageClicked(this, this.temp);
            } else if (pos < 5.58f && pos > 3.65f) {
                this.temp = this.mTopImageIndex + 1;
                if (this.temp < 0) {
                    this.temp = this.mAdapter.getCount() + this.temp;
                } else if (this.temp == this.mAdapter.getCount()) {
                    this.temp = 0;
                }
                this.temps = new StringBuilder(String.valueOf(this.temp)).toString();
                this.mCoverFlowListener.topImageClicked(this, this.temp);
            } else if (pos > 5.58f && pos < 7.5f) {
                this.temp = this.mTopImageIndex + 2;
                if (this.temp >= this.mAdapter.getCount()) {
                    this.temp -= this.mAdapter.getCount();
                }
                this.temps = new StringBuilder(String.valueOf(this.temp)).toString();
                this.mCoverFlowListener.topImageClicked(this, this.temp);
            } else if (pos > -0.6f && pos < 3.65f) {
                this.temp = this.mTopImageIndex - 1;
                if (this.temp < 0) {
                    this.temp = this.mAdapter.getCount() + this.temp;
                }
                this.temps = new StringBuilder(String.valueOf(this.temp)).toString();
                this.mCoverFlowListener.topImageClicked(this, this.temp);
            } else if (pos > -2.5f && pos < -0.6f) {
                this.temp = this.mTopImageIndex - 2;
                if (this.temp < 0) {
                    this.temp = this.mAdapter.getCount() + this.temp;
                }
                this.temps = new StringBuilder(String.valueOf(this.temp)).toString();
                this.mCoverFlowListener.topImageClicked(this, this.temp);
            }
        }
        if (this.mTouchMoved || ((double) this.mOffset) - Math.floor(this.mOffset) != 0.0d) {
            this.mStartOffset += this.mTouchStartPos - pos;
            this.mOffset = this.mStartOffset;
            this.mVelocity.addMovement(event);
            this.mVelocity.computeCurrentVelocity(1000);
            double speed = (((double) this.mVelocity.getXVelocity()) / ((double) this.mWidth)) * 1.0d;
            if (speed > 6.0d) {
                speed = 6.0d;
            } else if (speed < -6.0d) {
                speed = -6.0d;
            }
            startAnimation(-speed);
        } else {
            Log.e(VIEW_LOG_TAG, " touch ==>" + event.getX() + " , " + event.getY());
            if (this.mTouchRect != null && this.mTouchRect.contains(event.getX(), event.getY()) && this.mCoverFlowListener != null && this.topImageClickEnable && !this.mLongClickTriggled) {
                int actuallyPosition = this.mTopImageIndex;
                this.mCoverFlowListener.topImageClicked(this, actuallyPosition);
            }
        }
        this.mVelocity.clear();
        this.mVelocity.recycle();
    }

    private void startAnimation(double speed) {
        if (this.mAnimationRunnable == null) {
            double delta = (speed * speed) / 20.0d;
            if (speed < 0.0d) {
                delta = -delta;
            }
            double nearest = Math.floor(0.5d + ((double) this.mStartOffset) + delta);
            this.mStartSpeed = (float) Math.sqrt(Math.abs(nearest - ((double) this.mStartOffset)) * 10.0d * 2.0d);
            if (nearest < this.mStartOffset) {
                this.mStartSpeed = -this.mStartSpeed;
            }
            this.mDuration = Math.abs(this.mStartSpeed / FRICTION);
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mAnimationRunnable = new Runnable() { // from class: imagecoverflow.CoverFlowView.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverFlowView.this.driveAnimation();
                }
            };
            post(this.mAnimationRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void driveAnimation() {
        float elapsed = (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) / 1000.0f;
        if (elapsed >= this.mDuration) {
            endAnimation();
        } else {
            updateAnimationAtElapsed(elapsed);
            post(this.mAnimationRunnable);
        }
    }

    private void endAnimation() {
        if (this.mAnimationRunnable != null) {
            this.mOffset = (float) Math.floor(((double) this.mOffset) + 0.5d);
            invalidate();
            removeCallbacks(this.mAnimationRunnable);
            this.mAnimationRunnable = null;
        }
    }

    private void updateAnimationAtElapsed(float elapsed) {
        if (elapsed > this.mDuration) {
            elapsed = this.mDuration;
        }
        float delta = (Math.abs(this.mStartSpeed) * elapsed) - (((FRICTION * elapsed) * elapsed) / 2.0f);
        if (this.mStartSpeed < 0.0f) {
            delta = -delta;
        }
        this.mOffset = this.mStartOffset + delta;
        invalidate();
    }

    private int getActuallyPosition(int position) {
        if (this.mAdapter == null) {
            return -1;
        }
        int max = this.mAdapter.getCount();
        int position2 = position + this.mVisibleImages;
        while (true) {
            if (position2 >= 0 && position2 < max) {
                return position2;
            }
            if (position2 < 0) {
                position2 += max;
            } else if (position2 >= max) {
                position2 -= max;
            }
        }
    }

    private Bitmap obtainReflection(Bitmap src) {
        if (this.reflectHeightFraction <= 0.0f) {
            return null;
        }
        Bitmap reflection = this.mRecycler.getCachedReflectiuon(src);
        if (reflection == null || reflection.isRecycled()) {
            this.mRecycler.removeReflectionCache(src);
            Bitmap reflection2 = BitmapUtils.createReflectedBitmap(src, this.reflectHeightFraction);
            if (reflection2 != null) {
                this.mRecycler.buildReflectionCache(src, reflection2);
                return reflection2;
            }
            return reflection2;
        }
        return reflection;
    }

    public void setVisibleImage(int count) {
        if (count % 2 == 0) {
            throw new IllegalArgumentException("visible image must be an odd number");
        }
        if (count < 3) {
            throw new IllegalArgumentException("visible image must larger than 3");
        }
        this.mVisibleImages = count / 2;
        this.STANDARD_ALPHA = FinalCanbus.CAR_WC1_BMW_MINI / this.mVisibleImages;
    }

    public void setCoverFlowGravity(CoverFlowGravity gravity) {
        this.mGravity = gravity;
    }

    public void setCoverFlowLayoutMode(CoverFlowLayoutMode mode) {
        this.mLayoutMode = mode;
    }

    public void setReflectionHeight(int fraction) {
        if (fraction < 0) {
            fraction = 0;
        } else if (fraction > 100) {
            fraction = 100;
        }
        this.reflectHeightFraction = fraction;
    }

    public void setReflectionGap(int gap) {
        if (gap < 0) {
            gap = 0;
        }
        this.reflectGap = gap;
    }

    public void disableTopImageClick() {
        this.topImageClickEnable = false;
    }

    public void enableTopImageClick() {
        this.topImageClickEnable = true;
    }

    public void setSelection(final int position) {
        final int max = this.mAdapter.getCount();
        if (position >= 0 && position < max) {
            if (position < 0 || position >= max) {
                throw new IllegalArgumentException("Position want to select can not less than 0 or larger than max of adapter provide!");
            }
            new Handler().postDelayed(new Runnable() { // from class: imagecoverflow.CoverFlowView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (CoverFlowView.this.mTopImageIndex != position) {
                        if (CoverFlowView.this.mScroller.computeScrollOffset()) {
                            CoverFlowView.this.mScroller.abortAnimation();
                        }
                        int from = (int) (CoverFlowView.this.mOffset * 100.0f);
                        int disX = ((position - CoverFlowView.this.mVisibleImages) * 100) - from;
                        int iMin = Math.min(Math.abs((position + max) - CoverFlowView.this.mTopImageIndex), Math.abs(position - CoverFlowView.this.mTopImageIndex)) * 200;
                        if (Math.abs(disX) > 500) {
                        }
                        CoverFlowView.this.mScroller.startScroll(from, 0, disX, 0, 0);
                        CoverFlowView.this.invalidate();
                    }
                }
            }, 0L);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            this.mOffset = currX / 100.0f;
            invalidate();
        }
    }

    public void setTopImageLongClickListener(TopImageLongClickListener listener) {
        LongClickRunnable longClickRunnable = null;
        this.mLongClickListener = listener;
        if (listener == null) {
            this.mLongClickRunnable = null;
        } else if (this.mLongClickRunnable == null) {
            this.mLongClickRunnable = new LongClickRunnable(this, longClickRunnable);
        }
    }

    public int getTopImageIndex() {
        if (this.mTopImageIndex == -1) {
            return -1;
        }
        return this.mTopImageIndex;
    }

    private class LongClickRunnable implements Runnable {
        private int position;

        private LongClickRunnable() {
        }

        /* synthetic */ LongClickRunnable(CoverFlowView coverFlowView, LongClickRunnable longClickRunnable) {
            this();
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CoverFlowView.this.mLongClickListener != null) {
                CoverFlowView.this.mLongClickListener.onLongClick(this.position);
                CoverFlowView.this.mLongClickTriggled = true;
            }
        }
    }

    class RecycleBin {
        final LruCache<Integer, Bitmap> bitmapCache;

        RecycleBin() {
            this.bitmapCache = new LruCache<Integer, Bitmap>(getCacheSize(CoverFlowView.this.getContext())) { // from class: imagecoverflow.CoverFlowView.RecycleBin.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.support.v4.util.LruCache
                public int sizeOf(Integer key, Bitmap bitmap) {
                    return Build.VERSION.SDK_INT < 12 ? bitmap.getRowBytes() * bitmap.getHeight() : bitmap.getByteCount();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.support.v4.util.LruCache
                public void entryRemoved(boolean evicted, Integer key, Bitmap oldValue, Bitmap newValue) {
                    if (evicted && oldValue != null && !oldValue.isRecycled()) {
                        oldValue.recycle();
                    }
                }
            };
        }

        public Bitmap getCachedReflectiuon(Bitmap origin) {
            return this.bitmapCache.get(Integer.valueOf(origin.hashCode()));
        }

        public void buildReflectionCache(Bitmap origin, Bitmap b) {
            this.bitmapCache.put(Integer.valueOf(origin.hashCode()), b);
            Runtime.getRuntime().gc();
        }

        public Bitmap removeReflectionCache(Bitmap origin) {
            if (origin == null) {
                return null;
            }
            return this.bitmapCache.remove(Integer.valueOf(origin.hashCode()));
        }

        public void clear() {
            this.bitmapCache.evictAll();
        }

        private int getCacheSize(Context context) {
            ActivityManager am = (ActivityManager) context.getSystemService("activity");
            int memClass = am.getMemoryClass();
            int cacheSize = (1048576 * memClass) / 21;
            Log.e(CoverFlowView.VIEW_LOG_TAG, "cacheSize == " + cacheSize);
            return cacheSize;
        }
    }
}
