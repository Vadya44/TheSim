package model.scenes.buttons;

/**
 * Created by Vadya on 25.06.17.
 */

public abstract class IButton {
    float x1, y1 ,x2, y2;
    abstract boolean isThisButtonTap(float x1, float x2);
    abstract boolean isThisButtonMove(float x1, float y1, float x2, float y2);
}
