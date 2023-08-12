package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplaySolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_solution);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        int[][] sudoku = (int[][]) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);
        System.out.print(sudoku);

        String message = "";


        // Solve Sudoku
        ArrayList<Integer>[][] possibles = new ArrayList[4][4];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                possibles[x][y] = new ArrayList<>();
                if (sudoku[x][y] == 0) {
                    for (int i = 1; i <= 4; i++) {
                        possibles[x][y].add(i);
                    }

                } else {
                    possibles[x][y].add(sudoku[x][y]);
                }
            }
        }

        int[] s1 = new int[4];
        int sum = 0;
        int count = 0;
        while (sum != 40) {
            sum = 0;
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    sum = sum+sudoku[x][y];
                }
            }

            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 4; x++) {
                    if (sudoku[x][y] == 0) {
                        for (int a = 0; a < 4; a++) {
                            possibles[x][y].remove(Integer.valueOf(sudoku[a][y]));
                            //if(posibilieties =1 make sudoku = that vales)
                            if (possibles[x][y].size() == 1) {
                                sudoku[x][y] = possibles[x][y].get(0);
                            }
                            possibles[x][y].remove(Integer.valueOf(sudoku[x][a]));
                            //if
                            if (possibles[x][y].size() == 1) {
                                sudoku[x][y] = possibles[x][y].get(0);
                            }
                        }
                        int i = 0;
                        if (x < 2 && y < 2) {
                            //s1
                            int c = 0;
                            int d = 0;

                            for (int a = c; a < c + 2; a++) {
                                for (int b = d; b < d + 2; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }

                        if ((x < 4 && x > 1) && (y < 2)) {
                            //s2
                            int c = 2;
                            int d = 0;
                            for (int a = c; a < c + 2; a++) {
                                for (int b = d; b < d + 2; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }

                        if ((x < 2) && (y < 4 && y > 1)) {
                            //s3
                            int c = 0;
                            int d = 2;
                            for (int a = c; a < c + 2; a++) {
                                for (int b = d; b < d + 2; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }

                        if ((x < 4 && x > 1) && (y < 4 && y > 1)) {
                            //s4
                            int c = 2;
                            int d = 2;
                            for (int a = c; a < c + 2; a++) {
                                for (int b = d; b < d + 2; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }


                        for (int a = 0; a < 4; a++) {
                            possibles[x][y].remove(Integer.valueOf(s1[a]));
                        }

                        if (possibles[x][y].size() == 1) {
                            sudoku[x][y] = possibles[x][y].get(0);
                        }

                    }
                }
            }
            count ++;
            if (count >= 40) {
                message = "No Single Solution Exists.\n";
                break;
            }
        }

        for (int[] u: sudoku) {
            for (int elem: u) {
                // Your individual element
                message += elem + " ";

            }
            message += "\n";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }

}