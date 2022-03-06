package com.example.yono;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    LinearLayout llViewBal, llMain;
    RelativeLayout rlViewBal;
    ImageView imgMenu, imgClose;
    TextView txtUserName, txtBal, txtAct, desc, desc1, desc2;
    PrefManager prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prf = new PrefManager(this);

        llViewBal = findViewById(R.id.ll_view_bal);
        llMain = findViewById(R.id.ll_main);
        rlViewBal = findViewById(R.id.rl_viewbalance);
        imgMenu = findViewById(R.id.img_menu);
        imgClose = findViewById(R.id.img_close);
        txtUserName = findViewById(R.id.txt_username);
        txtBal = findViewById(R.id.txt_amt);
        txtAct = findViewById(R.id.txt_account);
        desc = findViewById(R.id.txt_desc);
        desc1 = findViewById(R.id.txt_desc1);
        desc2 = findViewById(R.id.txt_desc2);

        imgMenu.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), EditActivity.class)));
        imgClose.setOnClickListener(view -> {
            desc.setVisibility(View.VISIBLE);
            desc1.setVisibility(View.VISIBLE);
            desc2.setVisibility(View.VISIBLE);
            imgClose.setVisibility(View.GONE);
            llViewBal.setVisibility(View.GONE);
        });
        rlViewBal.setOnClickListener(view -> {
            llViewBal.setVisibility(View.VISIBLE);
            imgClose.setVisibility(View.VISIBLE);
            desc.setVisibility(View.GONE);
            desc1.setVisibility(View.GONE);
            desc2.setVisibility(View.GONE);
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float density = getResources().getDisplayMetrics().density;
        float height =  displayMetrics.heightPixels/density;
        //float width = displayMetrics.widthPixels / density;
        int size = (int) (height - 500);
        size = size/2;
        int pxSize = (int) (size*density);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0, pxSize, 0,0);
        llMain.setLayoutParams(params);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prf.getString(Global.name) != null && prf.getString(Global.amount)!= null && prf.getString(Global.account)!= null)
        txtUserName.setText(prf.getString(Global.name));
        txtBal.setText(prf.getString(Global.amount));
        txtAct.setText(prf.getString(Global.account));

    }
}