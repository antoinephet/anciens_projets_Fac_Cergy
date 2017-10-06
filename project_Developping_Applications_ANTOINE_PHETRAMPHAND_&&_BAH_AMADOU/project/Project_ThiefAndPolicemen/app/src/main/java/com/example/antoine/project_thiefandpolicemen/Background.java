package com.example.antoine.project_thiefandpolicemen;


import android.graphics.Bitmap;
import android.graphics.Canvas;
/**
 * Created by Antoine on 28/12/15.
 */
public class Background {

    private Bitmap image;
    private int x, y, dx;

    public Background(Bitmap res)
    {

        image = res;
        dx=GamePanel.MOVESPEED;
    }

    public void update()
    {
        x+=dx;
        if(x<-GamePanel.WIDTH){
            x=0;
        }
    }

    // method to draw the game
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image, x+GamePanel.WIDTH, y, null);
        }
    }

    public void setVector(int dx)
    {

        this.dx = dx;
    }


}
