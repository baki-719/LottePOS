package com.example.dev.lottepos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DEV on 2017-12-06.
 */


public class StaffActivity extends AppCompatActivity {

    @BindView(R.id.sale_btn)
    Button saleBtn;
    @BindView(R.id.register_btn)
    Button registerBtn;
    @BindView(R.id.check_btn)
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.sale_btn, R.id.register_btn, R.id.check_btn}) void click(View v) {
        switch (v.getId()) {
            case R.id.sale_btn:
                Intent saleIntent = new Intent(getApplicationContext(), SaleActivity.class);
                startActivity(saleIntent);
                break;
            case R.id.register_btn:
                Intent registerIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.check_btn:
                Intent checkIntent = new Intent(getApplicationContext(), CheckActivity.class);
                startActivity(checkIntent);
                break;
        }
    }
}
