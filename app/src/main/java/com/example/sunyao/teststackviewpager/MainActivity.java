package com.example.sunyao.teststackviewpager;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunyao.teststackviewpager.vp.CardTransformer;
import com.example.sunyao.teststackviewpager.vp.StackPagerAdapter;
import com.example.sunyao.teststackviewpager.vp.StackTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();

        vp = findViewById(R.id.vp);
//        vp.setOffscreenPageLimit(2);

        vp.setPageTransformer(false, new CardTransformer());

        List<TextView> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TextView tv = new TextView(this);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
            tv.setText("" + (i + 1));

            float[] hsvColors = new float[] {
                    random.nextInt(360), random.nextFloat(), random.nextFloat()
            };

            tv.setBackgroundColor(Color.HSVToColor(hsvColors));
            list.add(tv);

        }

        vp.setAdapter(new StackPagerAdapter(list));
    }

}
