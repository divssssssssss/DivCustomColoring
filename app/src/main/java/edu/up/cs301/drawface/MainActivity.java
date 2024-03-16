package edu.up.cs301.drawface;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView elementName;
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    private CustomElement customElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        elementName = findViewById(R.id.element);
        redSeekBar = findViewById(R.id.red);
        greenSeekBar = findViewById(R.id.green);
        blueSeekBar = findViewById(R.id.blue);
        customElement = findViewById(R.id.face);

        // Set up SeekBar listeners
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateElementColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateElementColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateElementColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Set up onTouchEvent listener for Face view

        customElement.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Handle touch down event
                    customElement.handleTouch((int) x, (int) y, elementName, redSeekBar, greenSeekBar, blueSeekBar);
                }

                return true;
            }
        });
    }

    private void updateElementColors() {
        int red = redSeekBar.getProgress();
        int green = greenSeekBar.getProgress();
        int blue = blueSeekBar.getProgress();

        // Pass the updated color only to the selected element
        customElement.setSelectedElementColor(Color.rgb(red, green, blue));
    }

//end of MainActivity
}
