package model;

import android.graphics.Bitmap;
import java.util.Timer;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.app.Application;
import android.content.res.Resources;

/**
 * Created by Vadya on 23.06.17.
 */

public final class IntroScene{
    private static Bitmap _bitmap;
    private static Timer _timer = new Timer();
    public static void OnDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(_bitmap, 0,
                (int)(GameView.mainHidth * 0.2 * GameView.Factor), null);
    }
    public static void Show()
    {
        GameView.activeScene = "Intro";
        _bitmap = BitmapFactory.decodeResource(Resources.getSystem(), Resource.Drawable.FKNV);
        _bb = Bitmap.CreateScaledBitmap(_b, (int)(GameView.mainWidth * GameView.Factor),
                (int)(0.6 * GameView.mainHidth * GameView.Factor), false);
        GameView.DrawEvent += OnDraw;
        aTimer.Elapsed += new ElapsedEventHandler(OnTimedEvent);
        aTimer.Interval = 1000;
        aTimer.Enabled = true;
    }
    private static void OnTimedEvent(object source, ElapsedEventArgs e)
    {
        aTimer.Enabled = false;
        Hide();
        MainMenu.Show();
    }
    public static void Hide()
    {
        GameView.DrawEvent -= OnDraw;
        _bb = null;
        _b = null;
        aTimer.Close();
    }
}
