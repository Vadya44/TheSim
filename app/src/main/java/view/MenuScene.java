package view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import model.scenes.Scene;
import model.buttons.Button;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;
import model.Bitmaps;

import android.view.animation.*;

import java.sql.BatchUpdateException;

/**
 * Created by Vadya on 24.06.17.
 */

public final class MenuScene extends Scene {
    private Bitmap mbitmap;
    private Button aboutButton;
    private Button singleButton;
    private Button multiplayerButton;
    private Button leaderBoardButton;
    private Button accountButton;
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
                (float)(view.mainWidth * 0.611), (float)(view.mainHidth * 0.963), view.factor, false, view.helpScene);
        accountButton = new Button((float)(view.mainWidth * 0.056), (float)(view.mainHidth * 0.03),
                (float)(view.mainWidth * 0.35), (float)(view.mainHidth * 0.147), view.factor, false, view.accountScene);
        leaderBoardButton = new Button((float)(view.mainWidth * 0.615), (float)(view.mainHidth * 0.034),
                (float)(view.mainWidth * 0.914), (float)(view.mainHidth * 0.151), view.factor, false, view.leaderBoardScene);
        singleButton = new Button((float)(view.mainWidth * 0.240), (float)(view.mainHidth * 0.207),
                (float)(view.mainWidth * 0.753), (float)(view.mainHidth * 0.474), view.factor, false, view.singleScene);
        singleButton.setBig(true);
        multiplayerButton = new Button((float)(view.mainWidth * 0.240), (float)(view.mainHidth * 0.520),
                (float)(view.mainWidth * 0.753), (float)(view.mainHidth * 0.788), view.factor, false, view.multiplayerScene);
        multiplayerButton.setBig(true);

        Bitmaps bitmaps = new Bitmaps(mbitmap);
        drawableElements.add(bitmaps);
        drawableElements.add(aboutButton);
        drawableElements.add(multiplayerButton);
        drawableElements.add(singleButton);
        drawableElements.add(leaderBoardButton);
        drawableElements.add(accountButton);
    }
}
