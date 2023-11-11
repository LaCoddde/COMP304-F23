package com.example.honestywerinwo_comp304_001_lab03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrawingView extends View {
    private Path currentPath;
    private Paint currentPaint;
    private List<Path> paths = new ArrayList<>();
    private List<Paint> paints = new ArrayList<>();

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawing();
    }

    private void setupDrawing() {
        currentPath = new Path();
        currentPaint = new Paint();

        currentPaint.setColor(Color.BLACK); // default color
        currentPaint.setAntiAlias(true);
        currentPaint.setStrokeWidth(5f);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeJoin(Paint.Join.ROUND);
        currentPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < paths.size(); i++) {
            canvas.drawPath(paths.get(i), paints.get(i));
        }
        canvas.drawPath(currentPath, currentPaint); // draw the current path
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                paths.add(new Path(currentPath));
                paints.add(new Paint(currentPaint));
                currentPath.reset();
                break;
            default:
                return false;
        }

        invalidate(); // Redraw the view.
        return true;
    }

    public void setCurrentPaintColor(int color) {
        currentPaint.setColor(color);
    }

    public void setCurrentPaintStrokeWidth(float width) {
        currentPaint.setStrokeWidth(width);
    }

    public void clearCanvas() {
        paths.clear();
        paints.clear();
        currentPath.reset();
        invalidate();
    }

    public Paint getCurrentPaint() {
        return currentPaint;
    }

    public void translateCanvas(float dx, float dy) {
        for (Path path : paths) {
            path.offset(dx, dy);
        }
        currentPath.offset(dx, dy);
        invalidate();
    }



    public void drawLine(float startX, float startY, float stopX, float stopY) {
        currentPath.moveTo(startX, startY);
        currentPath.lineTo(stopX, stopY);
        paths.add(new Path(currentPath));
        paints.add(new Paint(currentPaint));
        currentPath.reset();
        invalidate();
    }



}



