package model.scenes;

/**
 * Created by Vadya on 23.06.17.
 */

public abstract class Scene implements IScene {
    public abstract void show();
    public abstract void hide();
    public abstract void onDraw();
    public abstract void justTap(float x, float y);
    public abstract void movedTouch(float x1, float y1, float x2, float y2);
}
