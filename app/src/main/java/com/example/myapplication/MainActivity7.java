package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity7 extends AppCompatActivity {

    //Declaration
    EditText et_decrypt_input,et_key_input;
    Button btn_decrypted;
    TextView tv_decrypted;

    String message,d_message;
    int key;

    //Class Instance
    MainActivity6 decrypt =new MainActivity6();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        on_menu(); //Whats on Menu
        on_click();//Their Click Func.
    }
    private void on_menu() {

        et_decrypt_input = findViewById(R.id.et_decrypt_input);
        et_key_input = findViewById(R.id.et_key_input_d);
        btn_decrypted = findViewById(R.id.btn_to_decrypt);
        tv_decrypted =findViewById(R.id.tv_decrypted);

        et_key_input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    private void on_click() {

        btn_decrypted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message = et_decrypt_input.getText().toString();
                key = Integer.parseInt(et_key_input.getText().toString());


                d_message = decrypt.decrypt(message,key);

                tv_decrypted.setText(d_message);

            }
        });
    }
}