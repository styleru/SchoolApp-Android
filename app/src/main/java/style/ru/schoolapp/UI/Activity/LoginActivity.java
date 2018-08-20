package style.ru.schoolapp.UI.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import style.ru.schoolapp.MainActivity;
import style.ru.schoolapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_enter = (Button) findViewById(R.id.Enter);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                EditText login = (EditText) findViewById(R.id.Login);
                EditText password = (EditText) findViewById(R.id.Password);
                String lg_string = login.getText().toString();
                String pw_string = password.getText().toString();
                if (lg_string.equals("login") && pw_string.equals("password")) {
                    startActivity(intent);
                }
            }
        });
    }

    public void signUpClick(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
