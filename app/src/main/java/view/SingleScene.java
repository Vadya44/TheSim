package view;

import model.scenes.Scene;
import android.graphics.*;
import model.DrawableElement;
import model.scenes.Scene;
import model.buttons.Button;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;
import model.Bitmaps;
import android.util.*;
import android.view.animation.*;

/**
 * Created by Vadya on 29.06.17.
 */

public final class SingleScene extends Scene {
    public static SingleScene instance;
    private Button backButton;
    private Button easyButton;
    private Button mediumButton;
    public SingleScene(GameView view) {
        this.view = view;
        initFields();
    }
    private void initFields()
    {
        Bitmap bitmap =  Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.single), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
        Bitmaps bitmaps = new Bitmaps(bitmap);
        backButton = new Button((float)(view.mainWidth * 0.067), (float)(view.mainHidth * 0.037),
                (float)(view.mainWidth * 0.388), (float)(view.mainHidth * 0.111), view.factor, false);
        easyButton = new Button((float)(view.mainWidth * 0.245), (float)(view.mainHidth * 0.293),
                (float)(view.mainWidth * 0.764), (float)(view.mainHidth * 0.423), view.factor, false);
        mediumButton = new Button((float)(view.mainWidth * 0.243), (float)(view.mainHidth * 0.522),
                (float)(view.mainWidth * 0.760), (float)(view.mainHidth * 0.653), view.factor, false);
        drawableElements.add(bitmaps);
        drawableElements.add(backButton);
        drawableElements.add(easyButton);
        drawableElements.add(mediumButton);
    }
    @Override
    public void justTap(float x, float y) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button) {
                if (((Button) btn).isThisButtonTap(x, y) && btn == backButton) {
                    this.hide(MenuScene.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonTap(x, y) && btn == easyButton) {
                    GameProcess.instance = new GameProcess(view, 8);
                    this.hide(GameProcess.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonTap(x, y) && btn == mediumButton) {
                    GameProcess.instance = new GameProcess(view, 10);
                    this.hide(GameProcess.instance);
                    view.getActiveScene().show();
                }
            }
    }
    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button) {
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == backButton) {
                    this.hide(MenuScene.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == easyButton) {
                    GameProcess.instance = new GameProcess(view, 8);
                    this.hide(GameProcess.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == mediumButton) {
                    GameProcess.instance = new GameProcess(view, 10);
                    this.hide(GameProcess.instance);
                    view.getActiveScene().show();
                }
            }
    }

}
