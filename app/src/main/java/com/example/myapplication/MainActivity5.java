package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    //Declaration
    EditText et_encrypt_input,et_key_input;
    Button btn_encrypted;
    TextView tv_encrypted;

    String message,e_message;
    int key;

    //Instance of Class
    MainActivity6 encrypt =new MainActivity6();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        on_menu(); //What's on Menu
        on_click();//Their on Click Func.

    }
    private void on_menu() {

        et_encrypt_input = findViewById(R.id.et_encrypt_input);
        et_key_input = findViewById(R.id.et_key_input_e);
        btn_encrypted = findViewById(R.id.btn_to_encrypt);
        tv_encrypted =findViewById(R.id.tv_encrypted);

        et_key_input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    private void on_click() {

        btn_encrypted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message = et_encrypt_input.getText().toString();
                key = Integer.parseInt(et_key_input.getText().toString());

                e_message = encrypt.encrypt(message, key);

                tv_encrypted.setText(e_message);
            }
        });
    }
}