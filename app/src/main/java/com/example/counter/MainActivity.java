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
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterType = findViewById(R.id.spCounterType);
        this.inputTxt = findViewById(R.id.inputTxt);
        this.txtView = findViewById(R.id.txtView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.counter_display, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.spCounterType.setAdapter(adapter);

    }
    public void btnToCount(View view) {
        Toast.makeText(this, this.spCounterType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String spCounterType = this.spCounterType.getSelectedItem().toString();
        String charString = getString(R.string.display_chars);

        if(spCounterType.equalsIgnoreCase(charString)){
            this.txtView.setText(String.valueOf(this.inputTxt.getText().toString().length()));
        }
        else{
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT);
        }
    }

}