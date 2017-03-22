package com.myandroid.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnDoSug_Click(View view) {
        String gender = this.getGender();
        int age = this.getAge();
        MarriageSuggestion sug = new MarriageSuggestion();
        TextView txtSug = (TextView)findViewById(R.id.txtResult);
        txtSug.setText(sug.getSuggestion(gender, age));
    }

    private String getGender(){
        return ((Spinner)findViewById(R.id.spnGender)).getSelectedItem().toString();
    }

    private int getAge(){
        return Integer.parseInt(((EditText)findViewById(R.id.edtAge)).getText().toString());
    }
}
