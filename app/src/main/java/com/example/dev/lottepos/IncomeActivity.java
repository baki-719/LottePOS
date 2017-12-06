package com.example.dev.lottepos;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev.lottepos.conn.GetProduct;
import com.example.dev.lottepos.conn.GetSales;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by DEV on 2017-12-06.
 */

public class IncomeActivity  extends AppCompatActivity{

    @BindView(R.id.day_month_group)
    RadioGroup dayMonthGroup;
    @BindView(R.id.type_group)
    RadioGroup typeGroup;
    @BindView(R.id.income_result)
    TextView incomResult;

    private String period;
    private String type;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        ButterKnife.bind(this);
        dayMonthGroup.setOnCheckedChangeListener(radioGOnCheckedChangeListener);
        typeGroup.setOnCheckedChangeListener(radioGOnCheckedChangeListener);
    }

    RadioGroup.OnCheckedChangeListener radioGOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.daily_radio_btn:
                    period = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    break;
                case R.id.monthly_radio_btn:
                    period = new SimpleDateFormat("yyyy-MM").format(new Date());
                    break;
                case R.id.paid_type_total_radio_btn:
                    type = "total";
                    break;
                case R.id.paid_type_cash_radio_btn:
                    type ="cash";
                    break;
                case R.id.paid_type_card_radio_btn:
                    type ="card";
                    break;
            }
        }
    };

    @OnClick(R.id.show) void click(View v) {
        if(period == null || type == null ) {}
        String[] parmas = {String.valueOf(period), type};
        new GetSales(setResultHandler).execute(parmas);
    }

    public Handler setResultHandler = new Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            incomResult.setText(msg.getData().getSerializable("result").toString());
        }
    };
}
