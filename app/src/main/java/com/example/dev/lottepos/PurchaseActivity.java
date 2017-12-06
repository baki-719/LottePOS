package com.example.dev.lottepos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DEV on 2017-12-06.
 */

public class PurchaseActivity extends AppCompatActivity {
    private static final String TAG = "PurchasesActivity";

    @BindView(R.id.number)
    EditText numberView;
    @BindView(R.id.pwd)
    EditText pwdView;
    @BindView(R.id.period)
    EditText periodView;
    @BindView(R.id.pay_btn)
    Button btn;
    @BindView(R.id.product)
    TextView productView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        ButterKnife.bind(this);
        Intent getIntent = getIntent();
        periodView.setText(getIntent.getExtras().get("product").toString());

    }

    @OnClick(R.id.pay_btn) void click(View v) {
        String cardNumber = String.valueOf(numberView.getText());
        String pwd = String.valueOf(pwdView.getText());
        String period = String.valueOf(periodView.getText());
    }


}
