package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spCounterType;
    private EditText inputTxt;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterType = findViewById(R.id.spCounterType);
        this.inputTxt = findViewById(R.id.inputTxt);
        this.txtResult = findViewById(R.id.txtResult);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.counter_display, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spCounterType.setAdapter(adapter);
    }
    public void onBtnCount (View view) {
        Toast.makeText(this, this.spCounterType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String spSelectedOption = this.spCounterType.getSelectedItem().toString();
        String charString = getString(R.string.selection_chars);
        String wordsString = getString(R.string.selection_words);

        if(spSelectedOption.equalsIgnoreCase(charString)){
            String enteredUserText = this.inputTxt.getText().toString();
            if(enteredUserText.length() != 0) {
                int charsCount = TextCounter.getCharsCount(enteredUserText);
                this.txtResult.setText(String.valueOf(charsCount));
            }
            else if (enteredUserText.length() == 0){
                int charsCount = TextCounter.getCharsCount(enteredUserText);
                this.txtResult.setText(String.valueOf(charsCount));
                Toast.makeText(this, "Nothing to count", Toast.LENGTH_SHORT).show();
            }

        }
        if(spSelectedOption.equalsIgnoreCase(wordsString)){
                String enteredUserText = this.inputTxt.getText().toString();
            if(enteredUserText.length() != 0){
                int wordsCount = TextCounter.getWordsCount(enteredUserText);

                this.txtResult.setText(String.valueOf(wordsCount));
            }
            else if (enteredUserText.length() == 0){
                int wordsCount = TextCounter.getWordsCount(enteredUserText);
                this.txtResult.setText(String.valueOf(wordsCount));
                Toast.makeText(this, "Nothing to count", Toast.LENGTH_SHORT).show();
            }
        }

    }

}