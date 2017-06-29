package view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import model.DrawableElement;
import model.scenes.Scene;
import model.buttons.Button;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;
import model.Bitmaps;

/**
 * Created by Vadya on 24.06.17.
 */

public final class MenuScene extends Scene {
    public static MenuScene instance;
    private Bitmap mbitmap;
    private Button aboutButton;
    private Button singleButton;
    private Button multiplayerButton;
    private Button leaderBoardButton;
    private Button accountButton;
    private static final String debug = "kek";
    public MenuScene(GameView view) {
        this.view = view;
        initFields();
    }
    public void initFields()
    {
        mbitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.menu), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
        aboutButton = new Button((float)(view.mainWidth * 0.388), (float)(view.mainHidth * 0.844),
                (float)(view.mainWidth * 0.611), (float)(view.mainHidth * 0.963), view.factor, false);
        accountButton = new Button((float)(view.mainWidth * 0.056), (float)(view.mainHidth * 0.03),
                (float)(view.mainWidth * 0.35), (float)(view.mainHidth * 0.147), view.factor, false);
        leaderBoardButton = new Button((float)(view.mainWidth * 0.615), (float)(view.mainHidth * 0.034),
                (float)(view.mainWidth * 0.914), (float)(view.mainHidth * 0.151), view.factor, false);
        singleButton = new Button((float)(view.mainWidth * 0.240), (float)(view.mainHidth * 0.207),
                (float)(view.mainWidth * 0.753), (float)(view.mainHidth * 0.474), view.factor, false);
        singleButton.setBig(true);
        multiplayerButton = new Button((float)(view.mainWidth * 0.240), (float)(view.mainHidth * 0.520),
                (float)(view.mainWidth * 0.753), (float)(view.mainHidth * 0.788), view.factor, false);
        multiplayerButton.setBig(true);

        Bitmaps bitmaps = new Bitmaps(mbitmap);
        drawableElements.add(bitmaps);
        drawableElements.add(aboutButton);
        drawableElements.add(multiplayerButton);
        drawableElements.add(singleButton);
        drawableElements.add(leaderBoardButton);
        drawableElements.add(accountButton);
    }
    @Override
    public void justTap(float x, float y) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button) {
                if (((Button) btn).isThisButtonTap(x, y) && btn == aboutButton) {
                    this.hide(HelpScene.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonTap(x, y) && btn == singleButton) {
                    this.hide(SingleScene.instance);
                    view.getActiveScene().show();
                }
            }
    }
    @Override
    public void movedTouch(float x1, float y1, float x2, float y2) {
        for (DrawableElement btn : drawableElements)
            if (btn instanceof Button) {
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == aboutButton) {
                    this.hide(HelpScene.instance);
                    view.getActiveScene().show();
                }
                if (((Button) btn).isThisButtonMove(x1, y1, x2, y2) && btn == singleButton) {
                    this.hide(SingleScene.instance);
                    view.getActiveScene().show();
                }
            }
    }
}
