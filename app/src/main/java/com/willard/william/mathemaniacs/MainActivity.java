package com.willard.william.mathemaniacs;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        backToTitle();
    }

    public void backButtonPressed(View v) {
        backToTitle();
    }

    public void settingsButtonPressed(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    public void basicMultiplyButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 0);
        startActivity(intent);
        finish();
    }

    public void advancedMultiplyButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 1);
        startActivity(intent);
        finish();
    }

    public void expertMultiplyButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 2);
        startActivity(intent);
        finish();
    }

    public void squaresButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 3);
        startActivity(intent);
        finish();
    }

    public void moduloButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 4);
        startActivity(intent);
        finish();
    }

    public void factorialButtonPressed(View v) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("streak", 0);
        intent.putExtra("mode", 5);
        startActivity(intent);
        finish();
    }
    //TODO add more buttons for other modes/operations

    public void backToTitle() {
        Intent intent = new Intent(this, TitleActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            backToTitle();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
