package vadyaproduction.sim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import view.IntroScene;
import view.MenuScene;
import model.scenes.Scene;

public final class GameView extends View{
    private static final int InvalidPointerId = -1;
    private int mactivePointerId = InvalidPointerId;
    private float mlastTouchX;
    private float mlastTouchY;
    private float mposX = 0;
    private float mposY = 0;
    private byte misMoved = 0;
    public static float mainWidth = 720;
    public static float mainHidth = 1280;
    public static float centerX;
    public static float centerY;
    public static float factor = 1;
    private static boolean checked = false;
    public Scene activeScene;
    public Resources res = getResources();
    // Classes
    private IntroScene introScene;
    //private GestureHandler gestureHandler;

    //public void setActiveScene4Handler()
    //{
    //    gestureHandler = new GestureHandler(activeScene);
    //}
    public GameView(Context context) {
        super(context);
        init(null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public void onDraw(Canvas canvas) {
        activeScene.onDraw(canvas);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        int change = getNavigationSize();
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int heigth = Resources.getSystem().getDisplayMetrics().heightPixels - change;
        centerX = width / 2;
        centerY = heigth / 2;
        mainHidth = mainHidth - (mainHidth * change /
                Resources.getSystem().getDisplayMetrics().heightPixels - factor * 10);
        factor = Math.max((float) width / mainWidth, (float) heigth / mainHidth);
        Bitmap bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.intro), (int) (factor * mainWidth), (int) (factor * mainHidth), false);
        MenuScene mMenu = new MenuScene(this);
        introScene = new IntroScene(bitmap, this, mMenu);

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        MotionEvent action = ev;
        int pointerIndex = 0;
        if (ev.getPointerCount() > 1) return false;
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mlastTouchX = ev.getX();
                mlastTouchY = ev.getY();
                activeScene.actionDOWN(mlastTouchX / factor,mlastTouchY / factor);
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
                    activeScene.justTap(mlastTouchX / factor, mlastTouchY / factor);
                    break;
                } else {
                    activeScene.movedTouch(mlastTouchX / factor, mlastTouchY / factor,
                            ev.getX(pointerIndex) / factor, ev.getY(pointerIndex) / factor);
                    activeScene.actionCancel();
                    misMoved = 0;
                    break;

                }
            case MotionEvent.ACTION_CANCEL:
                mactivePointerId = InvalidPointerId;
                activeScene.actionCancel();
                break;
        }
        return true;
    }
    public void initScenes()
    {

    }
    private int getNavigationSize() {
        if (!checked) {
            checked = true;
            Resources resources = getContext().getResources();
            int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                return resources.getDimensionPixelSize(resourceId);
            }
            return 0;
        } else return 0;
    }
}
