package com.example.antoine.project_thiefandpolicemen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void launch(View view){

        /*String message = "Welcome to my app";
        textview.setText(message);*/

        String button_text;
        button_text = ((Button)view).getText().toString();
        if(button_text.equals("Start the game")){

            Intent intent = new Intent(this,MyService.class);
            startActivity(intent);

        }
        else if(button_text.equals("Stop the game")){

            Intent intent = new Intent(this,MyService.class);
            startActivity(intent);

        }
        else if(button_text.equals("Use the Sensor")){

            Intent intent = new Intent(this,MySensor.class);
            startActivity(intent);

        }


    }

    public void createMethod(View v){

        Intent i = new Intent(this,MyService.class);
        startService(i);


    }

    public void startMethod(View v){

        Intent intent = new Intent(this,GameService.class);
        startActivity(intent);


    }

    public void stopMethod(View v){

        Intent i = new Intent(this,MyService.class);
        stopService(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
