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
        RollDisplay = (TextView) findViewById(R.id.RollDisplay);
        Result = (TextView) findViewById(R.id.Result);
        CorrectGuesses = (TextView) findViewById(R.id.CorrectGuesses);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = Integer.valueOf(numberInput.getText().toString());

                int random = rng.nextInt(6) + 1;


                    RollDisplay.setText(new StringBuilder().append(random));

                    if (number == random) {
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

    }


}
