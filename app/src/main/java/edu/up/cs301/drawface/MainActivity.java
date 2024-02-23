package edu.up.cs301.drawface;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    RadioGroup rad = findViewById(R.id.group);
    SeekBar re = findViewById(R.id.red);
    SeekBar gre = findViewById(R.id.green);
    SeekBar blu = findViewById(R.id.blue);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.rand);
        Face fa = findViewById(R.id.face);
        button.setOnClickListener(fa);

        //adjust the seekbars based off of user input

        re.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean scroll) {

                //adjust red seekbar only
                if (rad.getCheckedRadioButtonId() == R.id.hair) {
                    fa.setHairColor(Color.rgb(progress, gre.getProgress(), blu.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.eyes) {
                    fa.setEyeColor(Color.rgb(progress, gre.getProgress(), blu.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.skin) {
                    fa.setSkinColor(Color.rgb(progress, gre.getProgress(), blu.getProgress()));
                }
                fa.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        gre.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean scroll) {

                //adjust green seekbar only
                if (rad.getCheckedRadioButtonId() == R.id.hair) {
                    fa.setHairColor(Color.rgb(re.getProgress(), progress, blu.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.eyes) {
                    fa.setEyeColor(Color.rgb(re.getProgress(), progress, blu.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.skin) {
                    fa.setSkinColor(Color.rgb(re.getProgress(), progress, blu.getProgress()));
                }
                fa.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        blu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean scroll) {

                //adjust blue seekbar only
                if (rad.getCheckedRadioButtonId() == R.id.hair) {
                    fa.setHairColor(Color.rgb(re.getProgress(), progress, gre.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.eyes) {
                    fa.setEyeColor(Color.rgb(re.getProgress(), progress, gre.getProgress()));
                }
                else if (rad.getCheckedRadioButtonId() == R.id.skin) {
                    fa.setSkinColor(Color.rgb(re.getProgress(), progress, gre.getProgress()));
                }
                fa.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Update the values based off the drawing of the face
        private void UpdateValues() {
            rad = findViewById(R.id.group);

            if (rad.getCheckedRadioButtonId() == R.id.hair) {
                updateSeekBars(fa.getHairColor());
            }
            else if (rad.getCheckedRadioButtonId() == R.id.eyes) {
                updateSeekBars(fa.getEyeColor());
            }
            else if (rad.getCheckedRadioButtonId() == R.id.skin) {
                updateSeekBars(fa.getSkinColor());
            }
        }
    }
    // Update the seekbars
    private void updateSeekBars(int color) {
        re.setProgress(Color.red(color));
        gre.setProgress(Color.green(color));
        blu.setProgress(Color.blue(color));
    }

}
