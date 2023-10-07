package com.a_adam.displMessage.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;

public class FetchData implements Callable<String> {
    private final String uri;

    private HttpURLConnection httpURLConnection = null;

    private BufferedReader bufferedReader = null;

    public FetchData(String url) { uri = url; }

    @Override
    public String call() {
        String value = "";
        try {
            URL url = new URL(uri);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuffer = new StringBuilder();

            while ((value = bufferedReader.readLine()) != null) {
                stringBuffer.append(value).append("\n");
            }

            value = stringBuffer.toString();

        }
        catch (MalformedURLException ignored) {}
        catch (IOException ignored) {}
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException ignored) {}
            }
        }
        return value;
    }
}