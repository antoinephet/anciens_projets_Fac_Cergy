package com.example.antoine.project_thiefandpolicemen;

import android.graphics.Rect;
/**
 * Created by Antoine on 28/12/15.
 */
public abstract class AbstractObject {

    protected int x;
    protected int y;
    protected int dy;
    protected int dx;
    protected int width;
    protected int height;

    public void setX(int x)
    {

        this.x = x;
    }
    public void setY(int y)
    {

        this.y = y;
    }
    public int getX()
    {

        return x;
    }
    public int getY()
    {

        return y;
    }
    public int getHeight()
    {

        return height;
    }
    public int getWidth()
    {

        return width;
    }
    public Rect getRectangle()
    {

        return new Rect(x, y, x+width, y+height);
    }
}
