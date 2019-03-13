package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("task1Preferences",MODE_PRIVATE);
        editor = preferences.edit();
        TextView main_text = findViewById(R.id.user_name);
        main_text.setText("Welcome,"+preferences.getString("username",null).toString());
    }

    public void btnLogout(View view)
    {
        Intent back = new Intent(Welcome.this,MainActivity.class);
        startActivity(back);
        this.finish();
    }
}
