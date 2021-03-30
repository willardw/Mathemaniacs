package com.willard.william.mathemaniacs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        setDifficulties();
    }

    private void setDifficulties() {
        int basicDifficulty = sharedPref.getInt(getString(R.string.basicDifficulty), 1);
        int advancedDifficulty = sharedPref.getInt(getString(R.string.advancedDifficulty), 1);
        int expertDifficulty = sharedPref.getInt(getString(R.string.expertDifficulty), 1);
        int squaresDifficulty = sharedPref.getInt(getString(R.string.squaresDifficulty), 1);
        int moduloDifficulty = sharedPref.getInt(getString(R.string.moduloDifficulty), 1);
        int factorialDifficulty = sharedPref.getInt(getString(R.string.factorialDifficulty), 1);
        RadioButton basic;
        RadioButton advanced;
        RadioButton expert;
        RadioButton squares;
        RadioButton modulo;
        RadioButton factorial;
        switch (basicDifficulty) {
            case 0:
                basic = (RadioButton) findViewById(R.id.basicEasyRadioButton);
                if (basic != null) {
                    basic.setChecked(true);
                }
                break;
            case 1:
                basic = (RadioButton) findViewById(R.id.basicNormalRadioButton);
                if (basic != null) {
                    basic.setChecked(true);
                }
                break;
            case 2:
                basic = (RadioButton) findViewById(R.id.basicHardRadioButton);
                if (basic != null) {
                    basic.setChecked(true);
                }
        }
        switch (advancedDifficulty) {
            case 0:
                advanced = (RadioButton) findViewById(R.id.advancedEasyRadioButton);
                if (advanced != null) {
                    advanced.setChecked(true);
                }
                break;
            case 1:
                advanced = (RadioButton) findViewById(R.id.advancedNormalRadioButton);
                if (advanced != null) {
                    advanced.setChecked(true);
                }
                break;
            case 2:
                advanced = (RadioButton) findViewById(R.id.advancedHardRadioButton);
                if (advanced != null) {
                    advanced.setChecked(true);
                }
        }
        switch (expertDifficulty) {
            case 0:
                expert = (RadioButton) findViewById(R.id.expertEasyRadioButton);
                if (expert != null) {
                    expert.setChecked(true);
                }
                break;
            case 1:
                expert = (RadioButton) findViewById(R.id.expertNormalRadioButton);
                if (expert != null) {
                    expert.setChecked(true);
                }
                break;
            case 2:
                expert = (RadioButton) findViewById(R.id.expertHardRadioButton);
                if (expert != null) {
                    expert.setChecked(true);
                }
        }
        switch (squaresDifficulty) {
            case 0:
                squares = (RadioButton) findViewById(R.id.squaresEasyRadioButton);
                if (squares != null) {
                    squares.setChecked(true);
                }
                break;
            case 1:
                squares = (RadioButton) findViewById(R.id.squaresNormalRadioButton);
                if (squares != null) {
                    squares.setChecked(true);
                }
                break;
            case 2:
                squares = (RadioButton) findViewById(R.id.squaresHardRadioButton);
                if (squares != null) {
                    squares.setChecked(true);
                }
        }
        switch (moduloDifficulty) {
            case 0:
                modulo = (RadioButton) findViewById(R.id.moduloEasyRadioButton);
                if (modulo != null) {
                    modulo.setChecked(true);
                }
                break;
            case 1:
                modulo = (RadioButton) findViewById(R.id.moduloNormalRadioButton);
                if (modulo != null) {
                    modulo.setChecked(true);
                }
                break;
            case 2:
                modulo = (RadioButton) findViewById(R.id.moduloHardRadioButton);
                if (modulo != null) {
                    modulo.setChecked(true);
                }
        }
        switch (factorialDifficulty) {
            case 0:
                factorial = (RadioButton) findViewById(R.id.factorialEasyRadioButton);
                if (factorial != null) {
                    factorial.setChecked(true);
                }
                break;
            case 1:
                factorial = (RadioButton) findViewById(R.id.factorialNormalRadioButton);
                if (factorial != null) {
                    factorial.setChecked(true);
                }
                break;
            case 2:
                factorial = (RadioButton) findViewById(R.id.factorialHardRadioButton);
                if (factorial != null) {
                    factorial.setChecked(true);
                }
        }
    }

    public void basicDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.basicEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.basicDifficulty), 0);
                }
                break;
            case R.id.basicNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.basicDifficulty), 1);
                }
                break;
            case R.id.basicHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.basicDifficulty), 2);
                }
        }
        editor.apply();
    }

    public void advancedDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.advancedEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.advancedDifficulty), 0);
                }
                break;
            case R.id.advancedNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.advancedDifficulty), 1);
                }
                break;
            case R.id.advancedHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.advancedDifficulty), 2);
                }
        }
        editor.apply();
    }

    public void expertDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.expertEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.expertDifficulty), 0);
                }
                break;
            case R.id.expertNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.expertDifficulty), 1);
                }
                break;
            case R.id.expertHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.expertDifficulty), 2);
                }
        }
        editor.apply();
    }

    public void squaresDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.squaresEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.squaresDifficulty), 0);
                }
                break;
            case R.id.squaresNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.squaresDifficulty), 1);
                }
                break;
            case R.id.squaresHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.squaresDifficulty), 2);
                }
        }
        editor.apply();
    }

    public void moduloDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.moduloEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.moduloDifficulty), 0);
                }
                break;
            case R.id.moduloNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.moduloDifficulty), 1);
                }
                break;
            case R.id.moduloHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.moduloDifficulty), 2);
                }
        }
        editor.apply();
    }

    public void factorialDifficultySet(View v) {
        SharedPreferences.Editor editor = sharedPref.edit();
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.factorialEasyRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.factorialDifficulty), 0);
                }
                break;
            case R.id.factorialNormalRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.factorialDifficulty), 1);
                }
                break;
            case R.id.factorialHardRadioButton:
                if (checked) {
                    editor.putInt(getString(R.string.factorialDifficulty), 2);
                }
        }
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        backToMenu();
    }

    public void backButtonPressed(View v) {
        backToMenu();
    }

    public void backToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            backToMenu();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
