package com.myandroid.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setNumberPicker();
    }

    // NumberPicker只能用setListener的方式插方法進去
    private void setNumberPicker(){
        NumberPicker numAge = (NumberPicker)findViewById(R.id.numAge);
        numAge.setMinValue(0);
        numAge.setMaxValue(100);
        numAge.setOnValueChangedListener(numPickerAgeOnValueChange);
        numAge.setValue(20);
    }

    public void btnDoSug_Click(View view) {
        NumberPicker numAge = (NumberPicker)findViewById(R.id.numAge);
        numAge.scrollBy(0, -1 * 500);
        numAge.scrollBy(0, 500);
        // this.doSug();
    }

    private NumberPicker.OnValueChangeListener numPickerAgeOnValueChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            doSug();
        }
    };

    private void doSug(){
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
        return ((NumberPicker)findViewById(R.id.numAge)).getValue();
        // return Integer.parseInt(((EditText)findViewById(R.id.edtAge)).getText().toString());
    }
}
