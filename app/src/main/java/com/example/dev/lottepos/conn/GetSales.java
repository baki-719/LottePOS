package com.example.dev.lottepos.conn;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DEV on 2017-12-06.
 */

public class GetSales extends AsyncTask<String, Void, Void> {
        private final static String TAG = "GetProductThread";

        private Handler handler;

        public GetSales(Handler handler) {
            this.handler = handler;
        }


    @Override
        public Void doInBackground(String... params) {
            try {
                String url = BasicValue.getInstance().getUrlHead()+"/getSales.php?period="+params[0]+"&type="+params[1];
                URL obj = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/json");

                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                br.close();

                String res = response.toString();
                Message msg = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putSerializable("result", res);
                msg.setData(bundle);
                handler.sendMessage(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }


}
