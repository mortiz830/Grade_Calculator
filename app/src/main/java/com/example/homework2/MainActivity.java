package com.example.homework2;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int uGrd1, uGrd2, uGrd3, uGrd4, uGrd5;
    private double clicks;
    private double sumGrades;
    private double avgGPA;
    Button calcGPA;
    TextView text;
    EditText grd1 , grd2, grd3, grd4, grd5;
    TextView GPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcGPA = (Button) findViewById(R.id.calculate);
        text = (TextView) findViewById(R.id.text);
        grd1 = (EditText) findViewById(R.id.editText1);
        grd2 = (EditText) findViewById(R.id.editText2);
        grd3 = (EditText) findViewById(R.id.editText3);
        grd4 = (EditText) findViewById(R.id.editText4);
        grd5 = (EditText) findViewById(R.id.editText5);
        GPA = (TextView) findViewById(R.id.GPA);

        calcGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Checks to see if the user entered in a grade value and displays an error notification letting
                // them know that each field cannot be empty.
                while(TextUtils.isEmpty(grd1.getText()) == true || TextUtils.isEmpty(grd2.getText()) == true ||
                        TextUtils.isEmpty(grd3.getText()) == true || TextUtils.isEmpty(grd4.getText()) == true ||
                        TextUtils.isEmpty(grd5.getText()) == true) {
                    if (TextUtils.isEmpty(grd1.getText())) {
                        grd1.setError("This field cannot be empty");
                    }
                    if (TextUtils.isEmpty(grd2.getText())) {
                        grd2.setError("This field cannot be empty");
                    }
                    if (TextUtils.isEmpty(grd3.getText())) {
                        grd3.setError("This field cannot be empty");
                    }
                    if (TextUtils.isEmpty(grd4.getText())) {
                        grd4.setError("This field cannot be empty");
                    }
                    if (TextUtils.isEmpty(grd5.getText())) {
                        grd5.setError("This field cannot be empty");
                    }
                    return;
                }

                uGrd1 = Integer.parseInt(grd1.getText().toString());
                uGrd2 = Integer.parseInt(grd2.getText().toString());
                uGrd3 = Integer.parseInt(grd3.getText().toString());
                uGrd4 = Integer.parseInt(grd4.getText().toString());
                uGrd5 = Integer.parseInt(grd5.getText().toString());

                // Checks to see if the user entered a valid grade between 0 - 100. Displays an error
                // notification prompting the user to reenter a value between 0 - 100
                while (uGrd1 < 0 || uGrd1 > 100 || uGrd2 < 0 || uGrd2 > 100 ||uGrd3 < 0 || uGrd3 > 100 ||
                    uGrd4 < 0 || uGrd4 > 100 || uGrd5 < 0 || uGrd5 > 100){
                    if (uGrd1 < 0 || uGrd1 > 100 ){
                        grd1.setError("Please enter a valid grade from 0 - 100");
                    }
                    if (uGrd2 < 0 || uGrd2 > 100 ){
                        grd2.setError("Please enter a valid grade from 0 - 100");
                    }
                    if (uGrd3 < 0 || uGrd3 > 100 ){
                        grd3.setError("Please enter a valid grade from 0 - 100");
                    }
                    if (uGrd4 < 0 || uGrd4 > 100 ){
                        grd4.setError("Please enter a valid grade from 0 - 100");
                    }
                    if (uGrd5 < 0 || uGrd5 > 100 ){
                        grd5.setError("Please enter a valid grade from 0 - 100");
                    }
                    return;
                }

                clicks++; // Increments clicks to determine what the button will do
                if (clicks % 2 != 0.0) { // Calculate GPA
                    sumGrades =  uGrd1 + uGrd2 + uGrd3 + uGrd4 + uGrd5;
                    calcGPA.setText("Clear");
                    avgGPA = sumGrades / 5;
                    GPA.setText(Double.toString(avgGPA));

                    if (avgGPA <= 60.0) { // Red range < 60
                        GPA.setBackgroundColor(Color.RED);
                        GPA.setTextColor(Color.WHITE);
                    } else if (avgGPA > 60.0 && avgGPA < 80.0) { // Yellow range 60 - 80
                        GPA.setBackgroundColor(Color.YELLOW);
                        GPA.setTextColor(Color.BLACK);
                    } else { // Green range 80 - 100
                        GPA.setBackgroundColor(Color.GREEN);
                        GPA.setTextColor(Color.WHITE);
                    }
                } else { // Resets all fields and button back to Calculate GPA to start over
                    grd1.setText("");
                    grd2.setText("");
                    grd3.setText("");
                    grd4.setText("");
                    grd5.setText("");
                    GPA.setText("");
                    GPA.setBackgroundColor(Color.WHITE);
                    calcGPA.setText("Calculate GPA");
                }


            }
        });
}}
