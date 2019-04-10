package com.wkq.demo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wkq.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private DemoBean demoBean;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        demoBean = new DemoBean();
        demoBean.setContent("ceshi2");
        demoBean.setShow(false);
        binding.setData(demoBean);

        binding.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demoBean.setShow(!demoBean.isShow());
                demoBean.setContent("ceshi2");
            }
        });

    }
}
