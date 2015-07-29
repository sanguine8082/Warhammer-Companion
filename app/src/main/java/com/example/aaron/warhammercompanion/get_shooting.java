package com.example.aaron.warhammercompanion;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class get_shooting extends Activity {

    Button shotsButton;
    Button skillButton;
    EditText shotsEdit;
    TextView shotsText;
    EditText skillEdit;
    TextView skillText;

    int num_shots;
    int shooter_bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_shooting);

        final Random rand = new Random();
        int diceRoll = rand.nextInt(6) + 1; //uniformly distributed int from 1 to 6

        shotsButton = (Button)findViewById(R.id.set1);
        skillButton = (Button)findViewById(R.id.set2);

        shotsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                shotsEdit = (EditText)findViewById(R.id.num_shots);
                shotsText = (TextView)findViewById(R.id.setText);
                String shots = shotsEdit.getText().toString();
                num_shots = Integer.parseInt(shots);
                shotsText.setText("Set shots to "+Integer.toString(num_shots));
            }
        });
        skillButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                skillEdit = (EditText)findViewById(R.id.shooter_skill);
                skillText = (TextView)findViewById(R.id.setText);
                String skill = skillEdit.getText().toString();
                shooter_bs = Integer.parseInt(skill);
                skillText.setText("Set BS to "+Integer.toString(shooter_bs));

            }
        });

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_shooting, menu);
        return true;
    } */

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
