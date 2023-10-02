package com.example.tech_services;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendSmsTask extends AsyncTask<Void, Void, String> {
    private static final String TAG = "SendSmsTask";
    private static final String API_KEY = "TXJKTVBjeUF5TXk9YmhHSE5HbHg=";
    private static final String FROM = "TechServices";
    private  String DESTINATION ;
    private static final String SMS = "<votre_message>";

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL("https://app.techsoft-web-agency.com/sms/api");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String requestBody = "action=send-sms&api_key=" + API_KEY + "&to=" + DESTINATION + "&from=" + FROM + "&sms=" + SMS;

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            Log.d(TAG, "Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return response.toString();
        } catch (Exception e) {
            Log.e(TAG, "Error sending SMS: " + e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if (response != null) {
            Log.d(TAG, "SMS sent successfully: " + response);
        } else {
            Log.e(TAG, "Failed to send SMS");
        }
    }
}
