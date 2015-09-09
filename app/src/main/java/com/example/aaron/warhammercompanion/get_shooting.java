package com.example.aaron.warhammercompanion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class get_shooting extends Activity {

    Button shotsButton;
    Button skillButton;
    Button fireButton;
    EditText shotsEdit;
    TextView shotsText;
    EditText skillEdit;
    TextView skillText;

    static int num_shots = 0;
    static int shooter_bs = 0;
    static int hits = 0;
    List<Integer> dice_rolls = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_shooting);

        //final Random rand = new Random();
        //final Random generator = new Random(System.currentTimeMillis());
        //int diceRoll = rand.nextInt(6) + 1; //uniformly distributed int from 1 to 6

        shotsButton = (Button)findViewById(R.id.set1);
        skillButton = (Button)findViewById(R.id.set2);
        fireButton = (Button)findViewById(R.id.fire);

        shotsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                shotsEdit = (EditText)findViewById(R.id.num_shots);
                //shotsText = (TextView)findViewById(R.id.setText);
                String shots = shotsEdit.getText().toString();
                num_shots = Integer.parseInt(shots);
                //shotsText.setText("Set shots to "+Integer.toString(num_shots));
                Toast.makeText(getApplicationContext(),"Set shots to "+Integer.toString(num_shots), Toast.LENGTH_SHORT).show();
            }
        });
        skillButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                skillEdit = (EditText)findViewById(R.id.shooter_skill);
                //skillText = (TextView)findViewById(R.id.setText);
                String skill = skillEdit.getText().toString();
                shooter_bs = Integer.parseInt(skill);
                //skillText.setText("Set BS to "+Integer.toString(shooter_bs));
                Toast.makeText(getApplicationContext(),"Set BS to "+Integer.toString(shooter_bs), Toast.LENGTH_SHORT).show();
            }
        });
        fireButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                List<Integer> dice_rolls = new ArrayList<Integer>();
                final Random generator = new Random(System.currentTimeMillis());
                TextView finalText = (TextView)findViewById(R.id.shotshit);
                TextView showShots = (TextView)findViewById(R.id.shotvals);

                int hits = 0;
                int i = 0;
                for (i = 0; i<num_shots; i++)
                {
                    dice_rolls.add(generator.nextInt(6)+1);
                    if(dice_rolls.get(i)>=(6-shooter_bs+1))
                    {
                        hits++;
                    }
                }
                finalText.setText("Hit with "+Integer.toString(hits)+" shots!");
                showShots.setText(Arrays.toString(dice_rolls.toArray()));

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
