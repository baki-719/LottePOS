package com.example.dev.lottepos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.customer_btn)
    Button customerBtn;
    @BindView(R.id.staff_btn)
    Button staffBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.customer_btn, R.id.staff_btn}) void click(View v) {
        switch (v.getId()) {
            case R.id.customer_btn:
                new IntentIntegrator(this).initiateScan();
                break;
            case R.id.staff_btn:
                Intent staffIntent = new Intent(getApplicationContext(), StaffActivity.class);
                startActivity(staffIntent);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if(result.getContents() == null)
                Toast.makeText(MainActivity.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(MainActivity.this, "스캔완료", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject object = new JSONObject(result.getContents());
                    Log.d(TAG, object.getString("name"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } else
            super.onActivityResult(requestCode, resultCode, data);
    }
}
