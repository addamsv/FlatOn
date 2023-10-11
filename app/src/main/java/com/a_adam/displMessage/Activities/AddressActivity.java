package com.a_adam.displMessage.Activities;

import static com.a_adam.displMessage.API.Constants.BRAND_ROUTE;
import static com.a_adam.displMessage.API.Constants.HOST_NAME;

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

public class AddressActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> houseList;
    private ArrayAdapter<String> arrayAdapter;
    private Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);
        initializerUserList();
    }

    public void onBackButtonClick(View view) { startActivityWith(MainActivity.class); }

    public void onOkButtonClick(View view) {
        houseList.clear();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> stringData = service.submit(new FetchData(HOST_NAME + BRAND_ROUTE));
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
                    houseList.add(line);
                }
            } catch (JSONException e) {}
        } catch (ExecutionException e) {
        } catch (InterruptedException e) {
        }

        service.shutdown();

        mainHandler.post(() -> arrayAdapter.notifyDataSetChanged());
    }

    private void initializerUserList() {
        listView = findViewById(R.id.houseList);

        houseList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, houseList);
        listView.setAdapter(arrayAdapter);
    }

    private void startActivityWith(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }
}