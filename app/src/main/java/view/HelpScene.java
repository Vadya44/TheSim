package view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;

import model.DrawableElement;
import model.scenes.Scene;
import vadyaproduction.sim.GameView;
import model.Bitmaps;
import model.buttons.Button;
import vadyaproduction.sim.R;

/**
 * Created by Vadya on 29.06.17.
 */

public final class HelpScene extends Scene {
    private Bitmap bitmap;
    public static HelpScene instance;
    private Button backButton;
    public HelpScene(GameView view) {
        this.view = view;
        initFields();
    }
    public void initFields(){
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.rules), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
        Bitmaps bitmaps = new Bitmaps(bitmap);
        drawableElements.add(bitmaps);
        backButton = new Button((float)(view.mainWidth * 0.292), (float)(view.mainHidth * 0.887),
                (float)(view.mainWidth * 0.693), (float)(view.mainHidth * 0.967), view.factor, false);
        drawableElements.add(backButton);
    }
    @Override
    public void justTap(float x, float y) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button)
                if (((Button) btn).isThisButtonTap(x, y) && btn == backButton) {
                    this.hide(MenuScene.instance);
                    view.getActiveScene().show();
                }
    }
    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button)
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == backButton) {
                    this.hide(MenuScene.instance);
                    view.getActiveScene().show();
                }
    }
}
