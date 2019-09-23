package com.paulniu.loginsecret;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPhone = phone.getText().toString();
                String strPassword = password.getText().toString();
                PhoneLoginModel model = new PhoneLoginModel();
                model.phone = strPhone;
                model.password = strPassword;
                EncryptionInfoMode encryptionInfoMode = BaseUtility.getEncryptionInfoMode(model);
                // 可以直接将encryptionInfoMode对象传递给后台，让后台解密，执行登录操作
            }
        });

    }
}
