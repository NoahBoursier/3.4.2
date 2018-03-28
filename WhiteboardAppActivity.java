package com.example.ckinnard.whiteboardapp;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class WhiteboardAppActivity extends ActionBarActivity {

    private static final String TAG = "WhiteboardAppActivity";

    TextView mTextOut;

    /*
     * set up the whiteboard
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mTextOut.append replaces System.out.print
        mTextOut = (TextView) findViewById(R.id.textView);
        mTextOut.setMovementMethod(new ScrollingMovementMethod());

        // load the portrait or landscape image according to device orientation
        Drawable portrait = getResources().getDrawable(R.drawable.whiteboard_portrait);
        Drawable landscape = getResources().getDrawable(R.drawable.whiteboard_landscape);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.whiteboard);
        Configuration config = getResources().getConfiguration();
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            relativeLayout.setBackground(landscape);
            Log.d(TAG, "Landscape view.");
        } else {
            relativeLayout.setBackground(portrait);
            Log.d(TAG, "Portrait view.");
        }

        // ----- work area:
        mTextOut.append("Welcome to the Whiteboard App");
        ArrayList<Integer> myList = new ArrayList<>();
        int numElements = 100;
        TextView textOut = (TextView)findViewById(R.id.textView);

        int prevNum = 0;
        for (int i = 0; i < numElements; i++) {
            int nextNum = (int)(Math.random() * 3 + 1);
            myList.add(prevNum + nextNum);
            prevNum = prevNum + nextNum;
            textOut.append(prevNum + ":");
        }
        if(LinearSearch.search(myList, 45) != -1){
            textOut.append(" 45 was found at index " + LinearSearch.search(myList, 45));
        }

    }
}
