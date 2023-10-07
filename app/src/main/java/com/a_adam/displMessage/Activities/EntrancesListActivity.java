package com.a_adam.displMessage.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.a_adam.displMessage.API.FetchData;
import com.a_adam.displMessage.MainActivity;
import com.a_adam.displMessage.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// https://abhiandroid.com/ui/listview
// https://www.youtube.com/watch?v=5lNQLR53UtY
// post request: https://stackoverflow.com/questions/3324717/sending-http-post-request-in-java


public class EntrancesListActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> entranceList;
    private ArrayAdapter<String> arrayAdapter;
    private Handler mainHandler = new Handler();
    private static final String HOST = "http://10.0.2.2:5500/api/"; // 127.0.0.1 -> 10.0.0.2

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

    public void onUpdateButtonClick(View view) {
        entranceList.clear();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> stringData = service.submit(new FetchData(HOST + "brand"));
        try {
            JSONObject jsonObject;
            JSONArray jsonArray = null;
            try {
                jsonObject = new JSONObject(stringData.get());
                jsonArray = jsonObject.getJSONArray("rows");
            } catch (JSONException e) {}
            try {
                if (jsonArray == null) {
                    jsonArray = new JSONArray(stringData.get());
                }
                String line = "";
                for (int i = 0; i < jsonArray.length(); i++) {
                    line = new JSONObject(jsonArray.get(i).toString()).getString("name");
                    entranceList.add(line);
                }
            } catch (JSONException e) {}
        } catch (ExecutionException e) {
        } catch (InterruptedException e) {
        }

        service.shutdown();

        mainHandler.post(() -> arrayAdapter.notifyDataSetChanged());
    }

    private void initializerUserList() {
        listView = findViewById(R.id.entranceList);

        entranceList = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entranceList);
        listView.setAdapter(arrayAdapter);
    }
}