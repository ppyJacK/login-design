package android.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        preferences = getSharedPreferences("task1Preferences",Context.MODE_PRIVATE);
        editor = preferences.edit();
        final Button register = findViewById(R.id.btnRegister);
        //Button login = findViewById(R.id.btnLinkToLoginScreen);
        final EditText t_username = findViewById(R.id.name);
        final EditText t_email = findViewById(R.id.email);
        final EditText t_password = findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = t_username.getText().toString();
                String email = t_email.getText().toString();
                String password = t_password.getText().toString();
                editor.putString("username",username);
                editor.putString("email",email);
                editor.putString("password",password);
                editor.apply();
                Toast.makeText(Register.this,"Register succeed",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void login(View view){
        Intent intent = new Intent(Register.this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
