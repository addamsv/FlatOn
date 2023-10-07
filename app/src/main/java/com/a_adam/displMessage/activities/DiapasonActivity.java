package com.a_adam.displMessage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.a_adam.displMessage.FlatOn.FlatOn;
import com.a_adam.displMessage.MainActivity;
import com.a_adam.displMessage.R;
import com.a_adam.displMessage.Storage.FlatOnStorage;

public class DiapasonActivity extends AppCompatActivity {
    private final FlatOn state = FlatOnStorage.getFlatOn();

    private EditText lowerFlat;

    private EditText upperFlat;

    private EditText stageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diapason);
        lowerFlat = findViewById(R.id.lower_flat);
        upperFlat = findViewById(R.id.upper_flat);
        stageNum = findViewById(R.id.stage_num);
        updateActivity();
    }

    public void updateActivity() {
        lowerFlat.setText(state.getLowerFlat());
        upperFlat.setText(state.getUpperFlat());
        stageNum.setText(state.getHowManyFloors());
    }

    public void onOkButtonClick(View view) {
        state.setLowerFlat(getStr(lowerFlat));
        state.setUpperFlat(getStr(upperFlat));
        state.setFloors(getStr(stageNum));
        startActivityWith(MainActivity.class);
    }

    public void onSkipButtonClick(View view) { startActivityWith(MainActivity.class); }

    private String getStr(EditText field) { return field.getText().toString().trim(); }

    private void startActivityWith(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }
}