package com.example.yono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText userName, amount, account;
    PrefManager prf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        prf = new PrefManager(this);
        userName = findViewById(R.id.et_username);
        amount = findViewById(R.id.et_amount);
        account = findViewById(R.id.et_account);

        findViewById(R.id.btn_submit).setOnClickListener(view -> validateInput());
    }

    private void validateInput() {
        if (TextUtils.isEmpty(userName.getText())){
             userName.setError("No Data");
        } else if (TextUtils.isEmpty(amount.getText())){
            amount.setError("No Data");
        } else if (TextUtils.isEmpty(account.getText())){
            account.setError("No Data");
        } else {
            prf.setString(Global.name,"Hi, " + userName.getText().toString());
            prf.setString(Global.amount, "₹"+ amount.getText().toString());
            prf.setString(Global.account, "A/c No. XXXXXXX"+ account.getText().toString());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
        }
    }
}