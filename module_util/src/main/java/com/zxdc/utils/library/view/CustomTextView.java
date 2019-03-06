package com.zxdc.utils.library.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

/**
 * 左右滚动的textview
 */
public class CustomTextView extends TextView {


    /**
     * 界面刷新时间(ms)
     */
    public static final int INVALIDATE_TIME = 15;
    /**
     * 每次移动的像素点(px)
     */
    public static final int INVALIDATE_STEP = 1;
    /**
     * 一次移动完成后等待的时间(ms)
     */
    public static final int WAIT_TIME = 1500;
    /**
     * 滚动文字前后的间隔
     */
    private String space = "       ";
    private String drawingText = "";
    private TextPaint paint;
    public boolean exitFlag;
    private float textWidth;
    private String mText;
    private int posX = 0;
    private float posY;
    private int width;
    private RectF rf;

    private Handler mHandler = new Handler();
    private Context context;

    public CustomTextView(Context context) {
        this(context,null);
        this.context=context;
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        this.context=context;
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
        initView();
    }


    private void initView() {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int mScreenWidth = dm.widthPixels;
        int mScreenHeight = dm.heightPixels;

        //以分辨率为720*1280准，计算宽高比值
        float ratioWidth = (float) mScreenWidth / 720;
        float ratioHeight = (float) mScreenHeight / 1280;
        float ratioMetrics = Math.min(ratioWidth, ratioHeight);
        int textSize = Math.round(25 * ratioMetrics);

        paint = new TextPaint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setTextSize(textSize);
        rf = new RectF(0, 0, 0, 0);

    }

    public void setText(String text) {
        this.mText = text;
        this.drawingText = mText;
        layoutView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        layoutView();
    }

    private void layoutView() {
        width = getWidth();
        rf.right = width;
        rf.bottom = getHeight();
        textWidth = paint.measureText(mText, 0, mText.length());
        posY = getTextDrawingBaseline(paint, rf);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getVisibility() != View.VISIBLE || TextUtils.isEmpty(drawingText)) {
            return;
        }
        canvas.save();
        canvas.drawText(drawingText, 0, drawingText.length(), posX, posY, paint);
        canvas.restore();
    }

    private Runnable moveRun = new Runnable() {

        @Override
        public void run() {
            if(width >= textWidth){
                return;
            }
            drawingText = mText + space + mText;
            posX -= INVALIDATE_STEP;
            if(posX >= -1 * INVALIDATE_STEP / 2 && posX <= INVALIDATE_STEP / 2){
                mHandler.postDelayed(this, WAIT_TIME);
                invalidate();
                return;
            }
            if (posX < -1 * textWidth - paint.measureText(space, 0, space.length())) {
                posX = INVALIDATE_STEP;
            }

            invalidate();
            if(!exitFlag){
                mHandler.postDelayed(this, INVALIDATE_TIME);
                return;
            }
            posX = 0;
        }
    };

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b=true;
        stopMove();
    }

    private static boolean b=true;
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        layoutView();
        if(b){
            b=false;
            startMove();
        }

    }

    private void stopMove() {
        exitFlag = true;
        mHandler.removeCallbacksAndMessages(this);
    }

    public void startMove() {
        exitFlag = false;
        mHandler.post(moveRun);
    }


    /**
     * 获取绘制文字的baseline
     *
     * @param paint
     * @param targetRect
     * @return
     */
    public static float getTextDrawingBaseline(Paint paint, RectF targetRect) {
        if (paint == null || targetRect == null) {
            return 0;
        }
        Paint.FontMetrics fontMetric = paint.getFontMetrics();
        return targetRect.top + (targetRect.height() - fontMetric.bottom + fontMetric.top) / 2.0f - fontMetric.top;
    }
}