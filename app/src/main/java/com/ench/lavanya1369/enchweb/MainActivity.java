package com.ench.lavanya1369.enchweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    String input1,spinner2;
    Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edt = (EditText) findViewById(R.id.editText);
        final Spinner spinner5 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);
        button10=(Button) findViewById(R.id.button);


        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                input1 = edt.getText().toString();
                String Text = spinner5.getSelectedItem().toString();


// Specify the layout to use when the list of choices appears
// Specify the layout to use when the list of choices appears



                     Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                     intent.putExtra("link", input1);
                     intent.putExtra("domain", Text);
                     startActivity(intent);

            }
        });




    }

}
