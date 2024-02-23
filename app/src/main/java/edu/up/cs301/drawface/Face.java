package edu.up.cs301.drawface;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

public class Face extends SurfaceView implements View.OnClickListener {
    //initialize variables for the face class
    public int skinColor = 0;
    public int eyeColor = 0;
    public int hairColor = 0;
    public int hairStyle = 0;

    //the paints to draw the face
    Paint skin = new Paint();
    Paint eyes = new Paint();
    Paint hair = new Paint();
    Paint mouth = new Paint();

    //the dimensions of the face
    public static final float faceWidth = 500.0f;
    public static final float faceHeight = 500.0f;


    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        skin.setColor(0xFFFFFACD);  //pale yellow
        skin.setStyle(Paint.Style.FILL);
        eyes.setColor(Color.BLACK);  //black
        eyes.setStyle(Paint.Style.FILL);
        hair.setColor(Color.BLACK);  //black
        hair.setStyle(Paint.Style.FILL);
        mouth.setColor(Color.BLACK);  //black
        mouth.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.WHITE);

        this.randomize();

    }

    //helper method to generate the random numbers for the RGB values
    private int getRandomColor() {
        return Color.rgb(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
    }

    //helper method to generate a random hairstyle
    private int getRandomHairstyle() {
        return (int) (Math.random() * 3);
    }

    //set the variables by using the getter methods
    public void randomize() {
        // Generate random colors
        skinColor = getRandomColor();
        eyeColor = getRandomColor();
        hairColor = getRandomColor();
        // Randomly select a hairstyle
        hairStyle = getRandomHairstyle();
    }
    public int getSkinColor() {
        return this.skinColor;
    }
    public int getHairColor() {
        return this.hairColor;
    }
    public int getEyeColor() {
        return this.eyeColor;
    }
    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }
    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }
    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }
    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public int getHairStyle() {
        return this.hairStyle;
    }

    //draw the face
    public void onDraw(Canvas g) {
        //face circle
        float centerX = faceWidth;
        float centerY = faceHeight;
        float radius = 300.0f;
        g.drawCircle(centerX, centerY, radius, skin);

        // Draw eyes (smaller circles)
        float eyeRadius = 20f;
        float leftEyeX = centerX - 40f;
        float rightEyeX = centerX + 40f;
        float eyeY = centerY - 30f;

        g.drawCircle(leftEyeX, eyeY, eyeRadius, eyes);
        g.drawCircle(rightEyeX, eyeY, eyeRadius, eyes);

        // Draw mouth (arc)
        RectF mouthRect = new RectF(centerX - 40f, centerY + 20f, centerX + 40f, centerY + 60f);
        g.drawArc(mouthRect, 0f, 180f, false, mouth);

        //Draw hair
        float hairwidth = 10f;
        float hairlength = 700f;
        if (hairStyle == 1) {
            g.drawLine(350, 250, 350, 650, hair);
            g.drawLine(300, 250, 350, 650, hair);
            g.drawLine(750, 250, 750, 650, hair);
            g.drawLine(700, 250, 750, 650, hair);
        } else if (hairStyle == 2) {
            g.drawLine(350, 250, 350, 650, hair);
            g.drawLine(300, 250, 350, 650, hair);
        } else if (hairStyle == 3) {
            g.drawLine(500,250,500,150, hair);
        }
    }

    @Override
    public void onClick(View v) {
        this.randomize();
        this.invalidate();

    }

}

/**
 External Citation
 Date: 2/22/2024
 Problem: To set up my face class
 Resource:
 CS 301 birthday cake
 Solution: I used the example code from this app.
 */

/**
 External Citation
 Date: 2/22/2024
 Problem: To figure out the seekbars
 Resource:
 CO-Pilot
 Solution: I used the example code from this AI to form up my code.
 */

/**
 External Citation
 Date: 2/22/2024
 Problem: To figure out the random button
 Resource:
 Andrew Nuxoll
 Solution: Helped me set up and trouble shoot my code.
 */





