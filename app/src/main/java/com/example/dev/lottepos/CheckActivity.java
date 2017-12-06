package com.example.dev.lottepos;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DEV on 2017-12-06.
 */

public class CheckActivity extends AppCompatActivity {
    private static final String TAG = "CheckActivity";

    @BindView(R.id.income_btn)
    Button incomeBtn;
    @BindView(R.id.stock_btn)
    Button stockBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.income_btn, R.id.stock_btn}) void click(View v) {
        switch (v.getId()) {
            case R.id.income_btn :
                Intent incomeIntent = new Intent(getApplicationContext(), IncomeActivity.class);
                startActivity(incomeIntent);
                break;
            case R.id.stock_btn :
                Intent stockIntent = new Intent(getApplicationContext(), StockActivity.class);
                startActivity(stockIntent);
                break;
        }
    }
}
