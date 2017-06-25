package model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Vadya on 25.06.17.
 */

public class Bitmaps extends DrawableElement {
    Bitmap bitmap;
    public Bitmaps(){
    }
    public Bitmaps(Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, null);
    }
}
