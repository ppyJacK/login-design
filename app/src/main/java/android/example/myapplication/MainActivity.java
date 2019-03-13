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

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_register);
        setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("task1Preferences",Context.MODE_PRIVATE);
        Button register = findViewById(R.id.btnLinkToRegisterScreen);
        Button login = findViewById(R.id.btnLogin);
        final EditText t_email = findViewById(R.id.email);
        final EditText t_password = findViewById(R.id.password);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = t_email.getText().toString();
                String password = t_password.getText().toString();
                String p_email = preferences.getString("email",null);
                String p_password = preferences.getString("password",null);
                if(p_email.isEmpty())Toast.makeText(MainActivity.this,"This email is not registered",Toast.LENGTH_SHORT).show();
                if(p_email.equals(email) && p_password.equals(password)){
                    Toast.makeText(MainActivity.this,"login succeed",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,Welcome.class);
                    startActivity(i);
                }
                else Toast.makeText(MainActivity.this,"wrong e-mail or password",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
