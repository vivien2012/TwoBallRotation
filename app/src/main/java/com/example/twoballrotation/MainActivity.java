package com.example.twoballrotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.twoballrotation.dialog.TwoBallRotationDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TwoBallRotationDialog dialog = new TwoBallRotationDialog(this, "加载中");
        dialog.show();


    }
}
