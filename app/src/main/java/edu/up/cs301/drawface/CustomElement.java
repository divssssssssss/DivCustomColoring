package edu.up.cs301.drawface;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

public class CustomElement extends SurfaceView   {

    private int selectedElementIndex = -1;


    private TextView elementNameTextView;
    private SeekBar redSeekBar, greenSeekBar, blueSeekBar;

    private Element[] elem;
    //private MainActivity.OnElementSelectedListener elementSelectedListener;

    //the paints to draw the house
    Paint moon = new Paint();
    Paint house = new Paint();
    Paint roof = new Paint();
    Paint door = new Paint();
    Paint window = new Paint();
    Paint chimney = new Paint();

    // Variables to hold the current colors of the elements
    private int moonColor = Color.LTGRAY;
    private int houseColor = Color.BLACK;
    private int roofColor = Color.YELLOW;
    private int doorColor = Color.GREEN;
    private int windowColor = Color.MAGENTA;
    private int chimneyColor = Color.RED;




    public CustomElement(Context context, AttributeSet attrs) {
        super(context, attrs);

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        // Initialize references to the TextView and SeekBars
        elementNameTextView = ((Activity) context).findViewById(R.id.element);
        redSeekBar = ((Activity) context).findViewById(R.id.red);
        greenSeekBar = ((Activity) context).findViewById(R.id.green);
        blueSeekBar = ((Activity) context).findViewById(R.id.blue);

        //Setup our palette
        moon.setColor(Color.LTGRAY);  //light gray
        moon.setStyle(Paint.Style.FILL);
        house.setColor(Color.BLACK);  //black
        house.setStyle(Paint.Style.FILL);
        roof.setColor(Color.YELLOW);  //yellow
        roof.setStyle(Paint.Style.FILL);
        door.setColor(Color.GREEN);  //green
        door.setStyle(Paint.Style.FILL);
        window.setColor(Color.MAGENTA);  //magenta
        window.setStyle(Paint.Style.FILL);
        chimney.setColor(Color.RED);  //red
        chimney.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.WHITE);

        // Initialize elements array
        elem = createElements();

    //end of face ctor
    }

    private Element[] createElements() {
        Element[] elem = new Element[6];

        // Initialize elements with names and colors
        elem[0] = new Element("Moon", moonColor);
        elem[1] = new Element("House", houseColor);
        elem[2] = new Element("Roof", roofColor);
        elem[3] = new Element("Door", doorColor);
        elem[4] = new Element("Window", windowColor);
        elem[5] = new Element("Chimney", chimneyColor);

        return elem;
    }
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the moon
        float centerX = 150.0f;
        float centerY = 150.0f;
        float radius = 100.0f;
        canvas.drawCircle(centerX, centerY, radius, moon);

        // Draw the house
        int width = getWidth();
        int height = getHeight();
        canvas.drawRect(width / 4, height / 4, width * 3 / 4, height * 3 / 4, house);

        // Draw the roof
        Path roofPath = new Path();
        roofPath.moveTo(width / 4, height / 4);
        roofPath.lineTo(width / 2, height / 8);
        roofPath.lineTo(width * 3 / 4, height / 4);
        roofPath.close();
        canvas.drawPath(roofPath, roof);

        // Draw the door
        canvas.drawRect(width * 5 / 12, height * 3 / 4, width * 7 / 12, height / 2, door);

        // Draw the window
        canvas.drawRect(width * 9 / 24, height / 3, width * 11 / 24, height / 2, window);

        // Draw the chimney
        canvas.drawRect(width * 2 / 3, height / 4 - height / 8, width * 3 / 4, height / 4, chimney);
        canvas.drawLine(width * 3 / 4, height / 4 - height / 8, width * 3 / 4, height / 4, chimney);
    //end of onDraw
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Handle touch down event
                handleTouch(x, y, elementNameTextView, redSeekBar, greenSeekBar, blueSeekBar);
                break;
            case MotionEvent.ACTION_MOVE:
                // Handle touch move event
                break;
            case MotionEvent.ACTION_UP:
                // Handle touch up event
                break;
        }

        return true;
    }

    /**
     External Citation
     Date: 3/15/2024
     Problem: To figure out the void handleTouch method
     Resource:
     Andrew Nuxoll
     Solution: Helped me set up and trouble shoot my code.
     */

    /**
     External Citation
     Date: 3/15/2024
     Problem: To figure out the void handleTouch method
     Resource:
     AI
     Solution: Helped me set up and trouble shoot my code.
     */

    void handleTouch(int x, int y, TextView elementNameTextView, SeekBar redSeekBar, SeekBar greenSeekBar, SeekBar blueSeekBar) {
        int width = getWidth();
        int height = getHeight();

        // Drawn coordinates of each element
        float moonCenterX = 150.0f;
        float moonCenterY = 150.0f;
        float moonRadius = 100.0f;

        float houseStartX = width / 4;
        float houseStartY = height / 4;
        float houseEndX = width * 3 / 4;
        float houseEndY = height * 3 / 4;

        float roofLeftX = width / 4;
        float roofTopY = height / 4;
        float roofRightX = width * 3 / 4;
        float roofBottomY = height / 8;

        float doorStartX = width * 5 / 12;
        float doorStartY = height * 3 / 4;
        float doorEndX = width * 7 / 12;
        float doorEndY = height / 2;

        float windowStartX = width * 9 / 24;
        float windowStartY = height / 3;
        float windowEndX = width * 11 / 24;
        float windowEndY = height / 2;

        float chimneyStartX = width * 2 / 3;
        float chimneyStartY = height / 4 - height / 8;
        float chimneyEndX = width * 3 / 4;
        float chimneyEndY = height / 4;

        // Reset selected element index
        selectedElementIndex = -1;


        // Check if the touch coordinates fall within the bounds of each element
        for (int i = 0; i < elem.length; i++) {
            if (x >= moonCenterX - moonRadius && x <= moonCenterX + moonRadius &&
                    y >= moonCenterY - moonRadius && y <= moonCenterY + moonRadius) {
                // Update UI for the moon element
                elementNameTextView.setText(elem[0].getName());
                redSeekBar.setProgress(Color.red(elem[0].getColor()));
                greenSeekBar.setProgress(Color.green(elem[0].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[0].getColor()));
                selectedElementIndex = 0;
                break;
            } else if (x >= windowStartX && x <= windowEndX && y >= windowStartY && y <= windowEndY) {
                // Update UI for the window element
                elementNameTextView.setText(elem[4].getName());
                redSeekBar.setProgress(Color.red(elem[4].getColor()));
                greenSeekBar.setProgress(Color.green(elem[4].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[4].getColor()));
                selectedElementIndex = 4;
                break;
            } else if (x >= doorStartX && x <= doorEndX && y >= doorEndY && y <= doorStartY) {
                // Update UI for the door element
                elementNameTextView.setText(elem[3].getName());
                redSeekBar.setProgress(Color.red(elem[3].getColor()));
                greenSeekBar.setProgress(Color.green(elem[3].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[3].getColor()));
                selectedElementIndex = 3;
                break;
            } else if (x >= chimneyStartX && x <= chimneyEndX && y >= chimneyStartY && y <= chimneyEndY) {
                // Update UI for the chimney element
                elementNameTextView.setText(elem[5].getName());
                redSeekBar.setProgress(Color.red(elem[5].getColor()));
                greenSeekBar.setProgress(Color.green(elem[5].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[5].getColor()));
                selectedElementIndex = 5;
                break;

            } else if (x >= roofLeftX && x <= roofRightX && y >= roofBottomY && y <= roofTopY) {
                // Update UI for the roof element
                elementNameTextView.setText(elem[2].getName());
                redSeekBar.setProgress(Color.red(elem[2].getColor()));
                greenSeekBar.setProgress(Color.green(elem[2].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[2].getColor()));
                selectedElementIndex = 2;
                break;

            } else if (x >= houseStartX && x <= houseEndX && y >= houseStartY && y <= houseEndY) {
                // Update UI for the house element
                elementNameTextView.setText(elem[1].getName());
                redSeekBar.setProgress(Color.red(elem[1].getColor()));
                greenSeekBar.setProgress(Color.green(elem[1].getColor()));
                blueSeekBar.setProgress(Color.blue(elem[1].getColor()));
                selectedElementIndex = 1;
                break;
            }
        }

        if (selectedElementIndex != -1) {
            elementNameTextView.setText(elem[selectedElementIndex].getName());
            redSeekBar.setProgress(Color.red(elem[selectedElementIndex].getColor()));
            greenSeekBar.setProgress(Color.green(elem[selectedElementIndex].getColor()));
            blueSeekBar.setProgress(Color.blue(elem[selectedElementIndex].getColor()));
        }

//        if (lastTappedElement != null) {
//            int red = redSeekBar.getProgress();
//            int green = greenSeekBar.getProgress();
//            int blue = blueSeekBar.getProgress();
//            lastTappedElement.setColor(Color.rgb(red, green, blue));
//            invalidate(); // Redraw the view
//        }
    }

    public void setColors(int moonColor, int houseColor, int roofColor, int doorColor, int windowColor, int chimneyColor) {
        // Update the paint colors for each element
        moon.setColor(moonColor);
        house.setColor(houseColor);
        roof.setColor(roofColor);
        door.setColor(doorColor);
        window.setColor(windowColor);
        chimney.setColor(chimneyColor);

        // Invalidate the view to trigger a redraw with the updated colors
        invalidate();
    }
    public void setSelectedElementColor(int color) {
        if (selectedElementIndex != -1 && selectedElementIndex < elem.length) {
            elem[selectedElementIndex].setColor(color);

            // Update the corresponding Paint object with the new color
            switch (selectedElementIndex) {
                case 0:
                    moon.setColor(color);
                    break;
                case 1:
                    house.setColor(color);
                    break;
                case 2:
                    roof.setColor(color);
                    break;
                case 3:
                    door.setColor(color);
                    break;
                case 4:
                    window.setColor(color);
                    break;
                case 5:
                    chimney.setColor(color);
                    break;
            }

            // Invalidate the view to trigger a redraw with the updated color
            invalidate();
        }
    }


    // Internal class to represent elements
    private static class Element {
        private String name;
        private int color;

        Element(String name, int color) {
            this.name = name;
            this.color = color;
        }

        String getName() {
            return name;
        }

        int getColor() {
            return color;
        }

        public void setColor(int rgb) {
            this.color = rgb;
        }
    }

//end of face
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






