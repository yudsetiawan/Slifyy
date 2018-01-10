package com.bekicode.slifyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    Button btnFb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.tvSignup).setOnClickListener(this);

        btnFb = (Button)findViewById(R.id.btnFb);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinFb = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(signinFb);
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvSignup:
                startActivity(new Intent(this, RegistrationActivity.class));

                break;
        }
    }
}
