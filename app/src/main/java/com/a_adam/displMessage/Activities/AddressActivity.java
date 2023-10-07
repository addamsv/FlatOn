package com.a_adam.displMessage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.a_adam.displMessage.MainActivity;
import com.a_adam.displMessage.R;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);
    }

    public void onBackButtonClick(View view) { startActivityWith(MainActivity.class); }

    public void onOkButtonClick(View view) { startActivityWith(MainActivity.class); }

    private void startActivityWith(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }
}