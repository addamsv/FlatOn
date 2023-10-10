package com.a_adam.displMessage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.a_adam.displMessage.API.FetchData;
import com.a_adam.displMessage.FlatOn.FlatOn;
import com.a_adam.displMessage.MainActivity;
import com.a_adam.displMessage.R;
import com.a_adam.displMessage.Storage.FlatOnStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EntrancesListActivity extends AppCompatActivity {
    private final FlatOn state = FlatOnStorage.getFlatOn();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_entrance);
        initializerUserList();
    }

    public void onBackButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initializerUserList() {
        listView = findViewById(R.id.entranceList);

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                state.getEntranceFlatsList(),
                R.layout.list_item1,
                new String[] { "hFlat", "dFlat", "flatStackOnFloor", "floorNum" },
                new int[] { R.id.hFlat, R.id.dFlat, R.id.flatStackOnFloor, R.id.floorNum }
        );

        listView.setAdapter(simpleAdapter);
    }
}