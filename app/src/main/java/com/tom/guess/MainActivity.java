package com.tom.guess;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    int secret;
    int counter;
    private EditText edNumber;
    private TextView edCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edNumber = findViewById(R.id.number);
        edCounter = findViewById(R.id.counter);
        FloatingActionButton fab = findViewById(R.id.fab);
        Button button = findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        reset();
        Log.d(TAG, "secret : " + secret);
    }

    public void reset() {
        secret = new Random().nextInt(10)+1;
        counter = 0;
        edCounter.setText(counter+"");
    }

    public void guess(View view) {
        int num = Integer.parseInt(edNumber.getText().toString());
        counter++;
        edCounter.setText(counter+"");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
        String message = "jo li hi";
        if (num < secret) {
            message = "Bigger";
            listener = null;
        } else if (num > secret) {
            message = "Smaller";
            listener = null;
        }
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Hahah")
                .setMessage("Jo li hi")
                .setPositiveButton("OK", listener)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
