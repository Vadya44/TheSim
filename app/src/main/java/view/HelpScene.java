package view;

import android.graphics.Canvas;
import android.graphics.Color;

import model.scenes.Scene;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 29.06.17.
 */

public final class HelpScene extends Scene {

    public static HelpScene instance;
    public HelpScene(GameView view) {
        this.view = view;
        initFields();
    }
    public void initFields(){

    }
    @Override
    public void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.RED);
    }
}
