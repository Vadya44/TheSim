package controller;

import java.util.List;

import model.scenes.*;

/**
 * Created by Vadya on 23.06.17.
 * Realise for Handler
 * Initialize class by active Scene, or set scene
 * then send for one of two methods for manipulate
 */

public final class GestureHandler extends Handler {
    public void justTap(float x, float y){
     mactiveScene.justTap(x, y);
    }
    public void movedTouch(float x1, float y1, float x2, float y2){
        mactiveScene.movedTouch(x1,y1,x2,y2);
    }
    private Scene mactiveScene = null;
    public void setScene(Scene sc){
        mactiveScene = sc;
    }
    public GestureHandler(Scene activite){
        this.mactiveScene = activite;
    }
}
