package com.example.diceactivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rng = new Random();

    int number;
    int guess;
    boolean working = true;
    EditText numberInput;
    TextView Result;
    TextView RollDisplay;
    TextView CorrectGuesses;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numberInput = (EditText) findViewById(R.id.numberInput);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        RollDisplay = (TextView) findViewById(R.id.RollDisplay);
        Result = (TextView) findViewById(R.id.Result);
        CorrectGuesses = (TextView) findViewById(R.id.CorrectGuesses);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = Integer.valueOf(numberInput.getText().toString());

                roll_the_dice();

                RollDisplay.setText(new StringBuilder().append(roll_the_dice()));

                if (number == roll_the_dice()) {
                    Result.setText("Congratulations");
                    guess = guess + 1;
                    CorrectGuesses.setText("Correct Guesses: " + guess);
                } else if ((number < 1) && (number > 6)) {
                    Result.setText("Please enter between 1-6 ");
                } else {
                    Result.setText("");

                }

            }

        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rng.nextInt(6)+1) {
                    case 1:
                        Result.setText("If you could go anywhere in the world, where would you go?\n");
                        break;
                    case 2:
                        Result.setText("If you were stranded on a desert island, what three things would you want to take with you?\n");
                        break;
                    case 3:
                        Result.setText("If you could eat only one food for the rest of your life, what would that be?\n");
                        break;
                    case 4:
                        Result.setText("If you won a million dollars, what is the first thing you would buy?\n");
                        break;
                    case 5:
                        Result.setText("If you could spend the day with one fictional character, who would it be?\n");
                        break;
                    case 6:
                        Result.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?\n");
                        break;
                    default:
                }
            }

        });
    }



    public Integer roll_the_dice(){
        int random = rng.nextInt(6) + 1;
        return random;
    }




}