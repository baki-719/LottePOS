package com.example.dev.lottepos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DEV on 2017-12-06.
 */

public class SaleActivity extends AppCompatActivity {
    @BindView(R.id.sale_result)
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        ButterKnife.bind(this);

        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if(result.getContents() == null)
                Toast.makeText(SaleActivity.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(SaleActivity.this, "스캔완료", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject object = new JSONObject(result.getContents());
                    resultText.setText(object.get("name").toString());
                    Intent intent = new Intent(getApplicationContext(), PurchaseActivity.class);
                    intent.putExtra("product", object.get("name").toString());
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } else
            super.onActivityResult(requestCode, resultCode, data);
    }
}
