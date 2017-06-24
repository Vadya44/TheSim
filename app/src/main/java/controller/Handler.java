package controller;

import model.scenes.*;

/**
 * Created by Vadya on 23.06.17.
 * this class is switcher for choosing active scene
 * and sending touch events for manipulation
 */

public abstract class Handler implements IHandler {
    Scene mactiveScene;
    public abstract void justTap(float x, float y);
    public abstract void movedTouch(float x1, float y1, float x2, float y2);
}
