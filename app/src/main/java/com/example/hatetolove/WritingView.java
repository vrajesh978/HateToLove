package com.example.hatetolove;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.ml.vision.common.FirebaseVisionImage;

import java.io.File;
import java.io.FileOutputStream;


public class WritingView extends View {
    private Paint mPaint;
    private Path mPath;
    private Canvas mCanvas;

    public WritingView(Context context) {
        super(context);
        init();
    }

    public WritingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);
        mPath = new Path();
        mCanvas = new Canvas();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Bitmap mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    public void clear() {
        mPath.reset();
        invalidate();
    }

    public void testNN() {
        this.setDrawingCacheEnabled(true);
        //Below block of code use for local network testing
        /*InputStream is = null;
        try {
            is = getResources().getAssets().open("n2_1.png");// internal testing with static image
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap  bitmap = BitmapFactory.decodeStream(is);
        */
        Log.d("TESTNN","WORKED");
        Bitmap b2 = Bitmap.createScaledBitmap(BitmapUtil.cropCharacterArea(getDrawingCache()), 28, 28, false);
        Bitmap newBitmap = Bitmap.createBitmap(b2.getWidth(), b2.getHeight(), b2.getConfig());
        Log.d("BITMAP"," "+newBitmap.getPixel(15,15));
        FirebaseVisionImage image = OCRDetection.getBitmapImage(newBitmap);
        OCRDetection.recognizeText(image);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(b2, 0, 0, null);
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/mathWithFriendsTmp";
        File dir = new File(dirPath);
        if (!dir.exists())
            dir.mkdirs();
        File file = new File(dirPath, "HandWriting.bmp");
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            newBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDrawingCacheEnabled(false);
        b2.recycle();
        newBitmap.recycle();

    }
}
