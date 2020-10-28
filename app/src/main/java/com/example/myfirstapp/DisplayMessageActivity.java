package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.graphics.Path;

import java.util.Vector;

public class DisplayMessageActivity extends AppCompatActivity {
    private int mActivePointerID1;
    private int mActivePointerID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        /*switch (action) {
            case MotionEvent.ACTION_DOWN: {
                //setPoints(event);
                //invalidate();
                // Capture the layout's TextView and set the string as its text
                EditText textView = findViewById(R.id.editTextTextMultiLine);
                textView.setText("Presión:" + event.getPressure() + "\nTamaño:" + event.getSize());
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                //setPoints(event);
                //invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                //initialize();
                break;
            }
            default: {
                break;
            }
        }*/

        mActivePointerID1 = event.getPointerId(0);

        String message = "";
        int i = 0;

        while (event.getPointerCount()-i>=1) {
            mActivePointerID1 = event.getPointerId(i);
            message += "Coordenadas: (" + event.getX((Integer) event.findPointerIndex(mActivePointerID1))
                    + "," + event.getY((Integer) event.findPointerIndex(mActivePointerID1)) + ")\n";
            i++;
        }

        EditText textView = findViewById(R.id.editTextTextMultiLine);
        textView.setText(message);

        return true;
    }
}