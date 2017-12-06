package com.example.dev.lottepos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dev.lottepos.conn.GetProduct;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DEV on 2017-12-06.
 */

public class StockActivity extends AppCompatActivity {
    private static final String TAG = "StockActivity";


    @BindView(R.id.category_group)
    RadioGroup categoryGroup;
    @BindView(R.id.stock_result)
    TextView resultText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        ButterKnife.bind(this);
        categoryGroup.setOnCheckedChangeListener(radioGOnCheckedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener radioGOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.stock_total:
                    new GetProduct(setResultHandler).execute("1");
                    break;
                case R.id.stock_cloth:
                    new GetProduct(setResultHandler).execute("2");
                    break;
                case R.id.stock_food:
                    new GetProduct(setResultHandler).execute("3");
                    break;
                case R.id.stock_elec_product:
                    new GetProduct(setResultHandler).execute("4");
                    break;
                case R.id.stock_life_product:
                    new GetProduct(setResultHandler).execute("5");
                    break;

            }
        }
    };

    public Handler setResultHandler = new Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            resultText.setText(msg.getData().getSerializable("result").toString());
        }
    };
}