package view;

import android.graphics.Canvas;
import android.graphics.Color;

import model.DrawableElement;
import model.scenes.Scene;
import model.scenes.IScene;
import vadyaproduction.sim.GameView;

/**
 * Created by Vadya on 29.06.17.
 */

public final class HelpScene extends Scene implements IScene {

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
