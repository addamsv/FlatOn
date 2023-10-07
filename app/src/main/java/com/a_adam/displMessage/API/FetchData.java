package com.a_adam.displMessage.API;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;

public class FetchData implements Callable<String> {
    private volatile String value;
    private String uri;
    private URL url;

    private HttpURLConnection httpURLConnection = null;
    private BufferedReader bufferedReader = null;

    public FetchData(String url) { uri = url; }

    @Override
    public String call() {
        value = "";

        try {
            url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            Log.d("call", uri);

            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();

            while ((value = bufferedReader.readLine()) != null) {
                stringBuffer.append(value).append("\n");
            }

            value = stringBuffer.toString();

            Log.d("call", value);
        } catch (MalformedURLException e) {
            Log.d("except", e.toString());
        } catch (IOException e) {
            Log.d("except", e.toString());
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {}
            }
        }
        return value;
    }
}