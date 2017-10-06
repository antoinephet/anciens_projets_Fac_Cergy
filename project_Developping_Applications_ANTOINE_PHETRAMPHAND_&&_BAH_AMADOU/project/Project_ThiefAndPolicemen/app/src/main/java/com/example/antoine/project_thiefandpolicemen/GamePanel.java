package com.example.antoine.project_thiefandpolicemen;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Antoine on 28/12/15.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 856; /*400 1850 856 int float*/
    public static final int HEIGHT = 480; /*300 480 1440 int*/

    private MainThread thread;
    private Background bg;

    public static final int MOVESPEED = -5;
    private Player player;

    private long missileStartTime;
    private ArrayList<Enemy> missiles;
    private Random rand = new Random();


    private boolean newGameCreated;
    //increase to slow down difficulty progression, decrease to speed up difficulty progression
    private int progressDenom = 20;


    private long startReset;
    private boolean reset;
    private boolean dissapear;
    private boolean started;
    private int best;

    public GamePanel(Context context)
    {
        super(context);


        //add the callback to the surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamePanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        int counter = 0;
        while(retry && counter<1000)
        {
            counter++;
            try{thread.setRunning(false);
                thread.join();
                retry=false;


            }catch(InterruptedException e){e.printStackTrace();}
            /*retry = false;*/
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        /*enemy part creation*/
        missiles = new ArrayList<Enemy>();
        missileStartTime = System.nanoTime();

        /*player part creation*/
        player = new Player(BitmapFactory.decodeResource(getResources(), R.drawable.thief1), 42, 55, 1); /*helicopter 65 25 3*/ /*42 55*/

        // set up an image for the background
        bg = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.bg1));
        // kind speed deroulement du bg of game
        /*bg.setVector(-10);*/
        //we can safely start the game loop
        thread.setRunning(true);
        thread.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        /*if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(!player.getPlaying())
            {
                player.setPlaying(true);
            }
            player.setUp(true);
            return true;
        }*/

        /*to make a down move, just release mouse buttons.*/
        if(event.getAction()==MotionEvent.ACTION_DOWN){

            if(!player.getPlaying() && newGameCreated && reset) /*part 8*/
            {
                player.setPlaying(true);
                player.setUp(true);
            }
            if(player.getPlaying())
            {

                if(!started)started = true;
                reset = false;
                player.setUp(true);
            }
            return true;
            /*if(!player.getPlaying())
            {
                player.setPlaying(true);

            }
            else
            {
                player.setUp(true);
            }
            return true;*/
        }
        /*on the second click, you can press and hold.*/
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            player.setUp(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update()
    {

        if(player.getPlaying()) {
            bg.update();
            player.update();

            //add missiles on timer
            long missileElapsed = (System.nanoTime()-missileStartTime)/1000000;
            if(missileElapsed >(2000 - player.getScore()/4)){

                System.out.println("making enemy");
                //first enemy always goes down the middle
                if(missiles.size()==0)
                {
                    missiles.add(new Enemy(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1
                    ),WIDTH + 10, HEIGHT/2, 37, 55, player.getScore(), 1)); /*45 15 13*/
                }
                else
                {

                    missiles.add(new Enemy(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1),
                            WIDTH+10, (int)(rand.nextDouble()*(HEIGHT)),37,55, player.getScore(),1)); /*45 15 13*/ /*37 55*/
                }

                //reset timer
                missileStartTime = System.nanoTime();
            }
            //loop through every enemy and check collision and remove
            for(int i = 0; i<missiles.size();i++)
            {
                //update enemy
                missiles.get(i).update();

                if(collision(missiles.get(i),player))
                {
                    missiles.remove(i);
                    player.setPlaying(false);
                    break;
                }
                //remove missile if it is way off the screen
                if(missiles.get(i).getX()<-100)
                {
                    missiles.remove(i);
                    break;
                }
            }
        }
        else{

            player.resetDY();
            if(!reset)
            {
                newGameCreated = false;
                startReset = System.nanoTime();
                reset = true;
                dissapear = true;

            }


            long resetElapsed = (System.nanoTime()-startReset)/1000000;

            if(resetElapsed > 2500 && !newGameCreated)
            {
                newGame();
            }
            /*newGameCreated = false;
            if(!newGameCreated) {
                newGame();
            }*/
        }
    }
    @Override
    public void draw(Canvas canvas)
    {
        // refresh or duplicate image bg
        final float scaleFactorX = (float) getWidth()/(WIDTH*1.f); /*final float scaleFactorX = (float) getWidth() / WIDTH;*/
        final float scaleFactorY = (float) getHeight()/(HEIGHT*1.f);
        if(canvas!=null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);

            if(!dissapear) {
                player.draw(canvas);
            }
            /*player.draw(canvas);*/

            //draw enemies
            for(Enemy m: missiles)
            {
                m.draw(canvas);
            }

            drawText(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    // method for collision
    public boolean collision(AbstractObject a, AbstractObject b)
    {
        if(Rect.intersects(a.getRectangle(), b.getRectangle()))
        {
            return true;
        }
        return false;
    }

    public void newGame()
    {
        dissapear = false;
        missiles.clear();


        player.resetDY();
        player.resetScore();
        player.setY(200); /*HEIGHT/2*/

        if(player.getScore()>best)
        {
            best = player.getScore();

        }

        //create initial borders

        //initial top border

        newGameCreated = true;


    }

    public void drawText(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(30); /*10 30*/
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("DISTANCE: " + (player.getScore()*3), 0, HEIGHT - 10, paint);
        /*canvas.drawText("BEST: " + best, WIDTH - 215, HEIGHT - 10, paint);*/ /*10*/

        if(!player.getPlaying()&&newGameCreated&&reset)
        {
            Paint paint1 = new Paint();
            paint1.setColor(Color.WHITE);
            paint1.setTextSize(40); /*15 40*/
            paint1.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
            canvas.drawText("PRESS to start", 300, 100, paint1);  /*canvas.drawText("PRESS TO START", WIDTH/2-50, HEIGHT/2, paint1);*/ /*150 80*/

            paint1.setTextSize(30); /*15 20*/
            canvas.drawText("COMMANDS : ", 300, 200, paint1);
            canvas.drawText("- PRESS and HOLD to climb up", 300, 250, paint1); /*canvas.drawText("PRESS AND HOLD TO GO UP", WIDTH/2-50, HEIGHT/2 + 20, paint1);*/ /*100 200*/
            canvas.drawText("- RELEASE to go down", 300, 280, paint1); /*canvas.drawText("RELEASE TO GO DOWN", WIDTH/2-50, HEIGHT/2 + 40, paint1);*/  /*100 250*/
        }
    }

}