package com.example.antoine.project_thiefandpolicemen;


import android.graphics.Bitmap;
import android.graphics.Canvas;
/**
 * Created by Antoine on 28/12/15.
 */
public class Player extends AbstractObject {

    private Bitmap spritesheet;
    private int score;
    private double dya;
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;

    public Player(Bitmap res, int w, int h, int numFrames) {

        x = 50; /*100*/
        y = 200; /*y = GamePanel.HEIGHT / 2;*/
        dy = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;

        for (int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        if(up){
            dy -=1; /*dy = (int)(dya-=1.1);*/ /*dy -=1;*/

        }
        else{
            dy +=1; /*dy = (int)(dya+=1.1);*/ /*dy +=1;*/
        }

        if(dy>14)dy = 15; /*14*/
        if(dy<-14)dy = -15; /*-14*/

        y += dy*2;
         /*dy = 0;*/
    }

    public void draw(Canvas canvas)
    {

        canvas.drawBitmap(animation.getImage(),x,y,null);
    }
    public int getScore(){
        return score;
    }
    public boolean getPlaying(){
        return playing;
    }
    public void setPlaying(boolean b){
        playing = b;
    }
    public void resetDYA(){
        dya = 0;
    } /*dya = 0;*/ /*dy = 0;*/
    public void resetScore(){
        score = 0;
    }

    public void resetDY(){
        dy = 0;
    }
}
