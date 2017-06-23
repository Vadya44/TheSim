package vadyaproduction.sim;

import android.content.*;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.*;
import android.view.View;
import java.lang.*;
import model.*;
import model.controller.GestureHandler;
import model.scenes.IntroScene;

import android.view.MotionEvent;
;

public final class GameView extends View {

    private static final int InvalidPointerId = -1;
    private int mactivePointerId = InvalidPointerId;
    private float mlastTouchX;
    private float mlastTouchY;
    private float mposX = 0;
    private float mposY = 0;
    private byte misMoved = 0;
    private GestureHandler handler;
    public static String activeScene = "";
    public static float mainWidth = 720;
    public static float mainHidth = 1280;
    public static float centerX;
    public static float centerY;
    public static float factor = 1;

    // Classes
    private IntroScene introScene;
    private GestureHandler gestureHandler;

    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    static {
        int Width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int Heigth = Resources.getSystem().getDisplayMetrics().heightPixels;
        centerX = Width / 2;
        centerY = Heigth / 2;
        factor = Math.max((float) Width / mainWidth, (float) Heigth / mainHidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        //DrawEvent?.Invoke(canvas);
        invalidate();
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.intro), (int)mainWidth, (int)mainHidth, false );
        introScene = new IntroScene(bitmap);
        introScene.show();

    }


    public boolean OnTouchEvent(MotionEvent ev) {
        MotionEvent action = ev;
        int pointerIndex = 0;

        if (ev.getPointerCount() > 1) return false;
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mlastTouchX = ev.getY();
                mlastTouchY = ev.getY();
                mactivePointerId = ev.getPointerId(0);
                break;
            case MotionEvent.ACTION_MOVE:
                misMoved = 1;
                pointerIndex = ev.findPointerIndex(mactivePointerId);
                mposX = ev.getX(pointerIndex);
                mposY = ev.getY(pointerIndex);

                break;
            case MotionEvent.ACTION_UP:
                if (misMoved == 0) {
                    //TouchHandler.JustTouch(mlastTouchX / factor, mlastTouchY / factor);
                    //break;
                } else {
                    //TouchHandler.MovedTouch(mlastTouchX / factor, mlastTouchY / factor,
                      //      ev.getX(pointerIndex) / factor, ev.getY(pointerIndex) / factor);
                    misMoved = 0;
                    break;

                }
            case MotionEvent.ACTION_CANCEL:
                mactivePointerId = InvalidPointerId;
                break;
        }
        return true;
    }
}
