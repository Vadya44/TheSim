package model.controller;

/**
 * Created by Vadya on 23.06.17.
 * Standart interface for Touch/Gesture Handler class
 * Catch Taps and Scrolls
 */

public interface IHandler {
    public void justTap(float x, float y);
    public void movedTouch(float x1, float y1, float x2, float y2);
}
