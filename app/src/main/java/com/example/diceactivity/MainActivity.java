package com.example.diceactivity;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rng = new Random();

    int number;
    int guess;
    EditText numberInput;
    TextView Result;
    TextView RollDisplay;
    TextView CorrectGuesses;

    public static final String EXTRA_MESSAGE = "extra_message";

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = (EditText) findViewById(R.id.numberInput);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        RollDisplay = (TextView) findViewById(R.id.RollDisplay);
        Result = (TextView) findViewById(R.id.Result);
        CorrectGuesses = (TextView) findViewById(R.id.CorrectGuesses);


            //  Block of code to try



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    number = Integer.parseInt(numberInput.getText().toString());

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
                catch(Exception e)
                {
                    Result.setText("PLEASE INPUT ONLY NUMBERS");
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }

        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int number;

                number = roll_the_dice();




                ArrayList<String> DiceBreaker = new ArrayList<String>();
                DiceBreaker.add("If you could go anywhere in the world, where would you go?\n");
                DiceBreaker.add("If you were stranded on a desert island, what three things would you want to take with you?\n");
                DiceBreaker.add("If you could eat only one food for the rest of your life, what would that be?\n");
                DiceBreaker.add("If you won a million dollars, what is the first thing you would buy?\n");
                DiceBreaker.add("If you could spend the day with one fictional character, who would it be?\n");
                DiceBreaker.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?\n");

                Result.setText(DiceBreaker.get(number));


            }

        });



    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity2();
        }

    });
}

    public Integer roll_the_dice(){
        int random = rng.nextInt(6) + 1;
        return random;
    }


    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }




}