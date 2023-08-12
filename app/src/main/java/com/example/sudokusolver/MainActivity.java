package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.sudokusolver.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the solve button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplaySolutionActivity.class);

        EditText editText1 = (EditText) findViewById(R.id.box1);
        EditText editText2 = (EditText) findViewById(R.id.box2);
        EditText editText3 = (EditText) findViewById(R.id.box3);
        EditText editText4 = (EditText) findViewById(R.id.box4);
        EditText editText5 = (EditText) findViewById(R.id.box5);
        EditText editText6 = (EditText) findViewById(R.id.box6);
        EditText editText7 = (EditText) findViewById(R.id.box7);
        EditText editText8 = (EditText) findViewById(R.id.box8);
        EditText editText9 = (EditText) findViewById(R.id.box9);
        EditText editText10 = (EditText) findViewById(R.id.box10);
        EditText editText11 = (EditText) findViewById(R.id.box11);
        EditText editText12 = (EditText) findViewById(R.id.box12);
        EditText editText13 = (EditText) findViewById(R.id.box13);
        EditText editText14 = (EditText) findViewById(R.id.box14);
        EditText editText15 = (EditText) findViewById(R.id.box15);
        EditText editText16 = (EditText) findViewById(R.id.box16);

        EditText[][] editTexts = {{editText1, editText2, editText3, editText4}, {editText5, editText6,
                editText7, editText8}, {editText9, editText10, editText11, editText12}, {editText13,
                editText14, editText15, editText16}};
        int[][] sudoku = new int[4][4];
        int row = 0;
        int col = 0;
        // Populate sudoku with user entered values
        for (EditText[] u: editTexts) {
            for (EditText elem: u) {
                String holder = elem.getText().toString();
                if (!holder.equals("")) {
                    sudoku[row][col] = Integer.parseInt(holder);
                }
                col+=1;
            }
            row += 1;
            col = 0;

        }

        //send sudoku as intent
        intent.putExtra(EXTRA_MESSAGE,sudoku);
        startActivity(intent);
    }
}