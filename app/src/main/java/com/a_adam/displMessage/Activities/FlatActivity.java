package com.a_adam.displMessage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.a_adam.displMessage.FlatOn.FlatOn;
import com.a_adam.displMessage.MainActivity;
import com.a_adam.displMessage.R;
import com.a_adam.displMessage.Storage.FlatOnStorage;

public class FlatActivity extends AppCompatActivity {
    private final FlatOn state = FlatOnStorage.getFlatOn();

    private EditText flatNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flat);
        flatNum = findViewById(R.id.number_flat);
        updateActivity();
    }

    public void updateActivity() {
        flatNum.setText(state.getFlatNum());
    }

    public void onCancelButtonClick(View view) { startActivityWith(MainActivity.class); }

    public void onOkButtonClick(View view) {
        state.setFlatNum(getStr(flatNum));
        startActivityWith(MainActivity.class);
    }

    private String getStr(EditText field) { return field.getText().toString().trim(); }

    private void startActivityWith(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }
}