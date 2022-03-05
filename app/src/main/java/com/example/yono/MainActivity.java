package com.example.yono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout llViewBal;
    RelativeLayout rlViewBal;
    ImageView imgMenu, imgClose;
    TextView txtUserName, txtBal, txtAct, txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llViewBal = findViewById(R.id.ll_view_bal);
        rlViewBal = findViewById(R.id.rl_viewbalance);
        imgMenu = findViewById(R.id.img_menu);
        imgClose = findViewById(R.id.img_close);
        txtUserName = findViewById(R.id.txt_username);
        txtBal = findViewById(R.id.txt_amt);
        txtAct = findViewById(R.id.txt_account);
        txtDesc = findViewById(R.id.txt_desc);

        imgMenu.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), EditActivity.class)));
        imgClose.setOnClickListener(view -> {
            txtDesc.setVisibility(View.VISIBLE);
            llViewBal.setVisibility(View.GONE);
        });
        rlViewBal.setOnClickListener(view -> {
            llViewBal.setVisibility(View.VISIBLE);
            txtDesc.setVisibility(View.GONE);
        });
    }
}