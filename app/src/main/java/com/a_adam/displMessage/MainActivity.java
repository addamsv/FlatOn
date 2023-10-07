package com.a_adam.displMessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.a_adam.displMessage.FlatOn.FlatOn;
import com.a_adam.displMessage.Storage.FlatOnStorage;
import com.a_adam.displMessage.activities.DiapasonActivity;
import com.a_adam.displMessage.activities.FlatActivity;

public class MainActivity extends AppCompatActivity {
    private final FlatOn state = FlatOnStorage.getFlatOn();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        state.build();
        updateActivity();
    }

    public void updateActivity() {
        ((TextView) findViewById(R.id.flatNumberLayout)).setText(state.getFlatNum());
        ((TextView) findViewById(R.id.lowerFlatLayout)).setText(state.getLowerFlat());
        ((TextView) findViewById(R.id.upperFlatLayout)).setText(state.getUpperFlat());
        ((TextView) findViewById(R.id.floorsLayout)).setText(state.getHowManyFloors());
        ((TextView) findViewById(R.id.flatsOnFloorLayOut)).setText(state.getHowManyFlatsOnFloor());
        ((TextView) findViewById(R.id.flatStackLayout)).setText(state.getFlStack());
        ((TextView) findViewById(R.id.entranceNumberLayout)).setText(state.getNumberOfEntrance());
        ((TextView) findViewById(R.id.floorLayout)).setText(state.getNumberOfFloor());
    }

    public void onEntranceButtonClick(View view) {
        Log.d("onClick","onEntranceButtonClick");
    }

    public void onBottomMenuSaveButtonClick(View view) { Log.d("onClick","onBottomMenuSaveButtonClick"); }

    public void onDiapasonButtonClick(View view) { startActivityWith(DiapasonActivity.class); }

    public void onFlatNumButtonClick(View view) { startActivityWith(FlatActivity.class); }

    private void startActivityWith(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }
}