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
    @Override
    public  void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
    }

}
