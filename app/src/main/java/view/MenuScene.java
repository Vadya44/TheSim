package view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.*;

import model.scenes.Scene;
import model.buttons.Button;
import vadyaproduction.sim.GameView;
import vadyaproduction.sim.R;
import model.Bitmaps;

import android.view.animation.*;

/**
 * Created by Vadya on 24.06.17.
 */

public final class MenuScene extends Scene {
    private Bitmap mbitmap;
    private Button aboutButton;
    public MenuScene(GameView view) {
        this.view = view;
        //this.view.setActiveScene4Handler();
        initFields();
    }
    public void initFields()
    {
        mbitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(view.res,
                R.drawable.menu), (int) (view.factor * view.mainWidth),
                (int) (view.factor * view.mainHidth), false);
        aboutButton = new Button((float)(view.mainWidth * 0.388), (float)(view.mainHidth * 0.844),
                (float)(view.mainWidth * 0.611), (float)(view.mainHidth * 0.963), view.factor, false);
        Bitmaps bitmaps = new Bitmaps(mbitmap);
        drawableElements.add(bitmaps);
        drawableElements.add(aboutButton);
    }
}
