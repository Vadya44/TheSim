package vadyaproduction.sim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.renderscript.Script;
import android.support.v4.media.VolumeProviderCompatApi21;
import android.support.v7.view.menu.MenuBuilder;
import android.util.AttributeSet;
import android.util.EventLog;
import android.view.View;
import java.lang.*;

import android.view.MotionEvent;
;

public static class GameView extends View {

    public GameView(Context context) {
        super(context);
        init(null, 0);
        Instance = this;
    }
    public static String activeScene = "";
    public static float mainWidth = 720;
    public static float mainHidth = 1280;
    public static float CenterX;
    public static float CenterY;
    public static float Factor = 1;

    public static GameView getInstance() {
        return Instance;
    }
    private static GameView Instance;

    //public VolumeProviderCompatApi21.Delegate void DrawDelegate(Canvas canvas);

    //public static EventLog.Event DrawEvent;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        Instance = this;
    }

    static {
        int Width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int Heigth = Resources.getSystem().getDisplayMetrics().heightPixels;
        CenterX = Width / 2;
        CenterY = Heigth / 2;
        Factor = Math.max((float) Width / mainWidth, (float) Heigth / mainHidth);
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
        Instance = this;
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes

    }

    private static final int InvalidPointerId = -1;
    private int _activePointerId = InvalidPointerId;
    private float mlastTouchX;
    private float mlastTouchY;
    private float mposX = 0;
    private float mposY = 0;
    private byte misMoved = 0;

    public boolean OnTouchEvent(MotionEvent ev) {
        MotionEvent action = ev;
        int pointerIndex = 0;

        if (ev.getPointerCount() > 1) return false;
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mlastTouchX = ev.getY();
                mlastTouchY = ev.getY();
                _activePointerId = ev.getPointerId(0);
                break;
            case MotionEvent.ACTION_MOVE:
                misMoved = 1;
                pointerIndex = ev.findPointerIndex(_activePointerId);
                mposX = ev.getX(pointerIndex);
                mposY = ev.getY(pointerIndex);

                break;
            case MotionEvent.ACTION_UP:
                if (misMoved == 0) {
                    TouchHandler.JustTouch(mlastTouchX / Factor, mlastTouchY / Factor);
                    break;
                } else {
                    TouchHandler.MovedTouch(mlastTouchX / Factor, mlastTouchY / Factor,
                            ev.getX(pointerIndex) / Factor, ev.getY(pointerIndex) / Factor);
                    misMoved = 0;
                    break;

                }
            case MotionEvent.ACTION_CANCEL:
                _activePointerId = InvalidPointerId;
                break;
        }
        return true;
    }
}
