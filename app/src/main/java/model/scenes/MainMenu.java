package model.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.*;
import model.scenes.buttons.AboutButton;
import model.scenes.buttons.IButton;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;

import android.graphics.*;
import android.view.animation.*;

/**
 * Created by Vadya on 24.06.17.
 */

public final class MainMenu extends Scene {
    private GameView view;
    private Bitmap mbitmap;
    private Paint p;
    private ArrayList<IButton> buttonList;
    IButton clickedButton = null;
    public MainMenu(GameView view) {
        this.view = view;
        this.view.setActiveScene4Handler();
        mbitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.menu), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
        p = new Paint();
        p.setAlpha(200);
        AboutButton aboutButton = new AboutButton((float)(view.mainHidth * 0.844),
                (float)(view.mainWidth * 0.388),
                (float)(view.mainHidth * 0.963), (float)(view.mainWidth * 0.611));
        buttonList = new ArrayList<IButton>();

    }
    @Override
    public void show() {
        final Animation fadeOut = new AlphaAnimation(0, 1);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setDuration(1000);
        view.startAnimation(fadeOut);
    }

    @Override
    public void hide() {
        final Animation fadeIn = new AlphaAnimation(1, 0);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1000);
        view.startAnimation(fadeIn);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(mbitmap, 0 ,0 , null);
        if (clickedButton != null) clickedButton.onDrawClicl(canvas);
    }

    @Override
    public void justTap(float x, float y) {
        if (!buttonList.isEmpty())
            for(IButton btn : buttonList)
                if (btn.isThisButtonTap(x,y)) clickedButton = btn;
    }

    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {

    }
}
