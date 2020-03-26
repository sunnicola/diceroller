package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.sum;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    Button rollDice;
    TextView rollSum;
    TextView fig1;
    TextView fig2;
    ImageView iv_dice1;
    ImageView iv_dice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDice = findViewById(R.id.rollDice);
        final TextView rollSum = (TextView) findViewById(R.id.rollSum);
       final TextView fig1 = (TextView) findViewById(R.id.fig1);
        final TextView fig2 = (TextView) findViewById(R.id.fig2);
        iv_dice1 = findViewById(R.id.iv_dice1);
        iv_dice2 = findViewById(R.id.iv_dice2);

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.diceroller");
                int res2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.diceroller");

                int sum = value1 + value2;

                iv_dice1.setImageResource(res1);
                iv_dice2.setImageResource(res2);

                rollSum.setText("The sum of your rolls is " + sum);
                fig1.setText(String.valueOf(value1));
                fig2.setText(String.valueOf(value2));

            }
        });

        }


    public int randomDiceValue(){
        //random goes from 0 to 5, so have to add 1
        return RANDOM.nextInt(6) + 1;
    }



    }

