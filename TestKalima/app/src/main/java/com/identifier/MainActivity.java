package com.identifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView exactHeight, exactWidth,exactDensity,diagonalInchesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exactHeight = (TextView)findViewById(R.id.screenHeightCalculated);
        exactWidth = (TextView)findViewById(R.id.screenWidthCalculated);
        exactDensity = (TextView)findViewById(R.id.densityCalculated);
        diagonalInchesView = (TextView)findViewById(R.id.diagonalInches);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        exactDensity.setText(String.valueOf(metrics.density) + "");
        exactWidth.setText(metrics.widthPixels + "");
        exactHeight.setText(metrics.heightPixels+"");


        /*Density Matrix
        0.75 - ldpi
        1.0 - mdpi
        1.5 - hdpi
        2.0 - xhdpi
        3.0 - xxhdpi
        4.0 - xxxhdpi*/


        float scaleFactor = metrics.density;
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float widthDpi = metrics.xdpi;
        float heightDpi = metrics.ydpi;

        float widthInches = widthPixels / widthDpi;
        float heightInches = heightPixels / heightDpi;

        double diagonalInches = Math.sqrt(
                (widthInches * widthInches)
                        + (heightInches * heightInches));

        diagonalInchesView.setText(String.format("%.1f", diagonalInches) + " inches");
    }
}
