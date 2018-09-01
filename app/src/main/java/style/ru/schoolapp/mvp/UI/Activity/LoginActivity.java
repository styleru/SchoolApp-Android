package style.ru.schoolapp.mvp.UI.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import style.ru.schoolapp.R;

public class LoginActivity extends AppCompatActivity {

    Button button_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        button_enter = (Button) findViewById(R.id.Enter);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EnrollmentActivity.class);
                EditText login = (EditText) findViewById(R.id.Login);
                EditText password = (EditText) findViewById(R.id.Password);
                String lg_string = login.getText().toString();
                String pw_string = password.getText().toString();
                if (lg_string.equals("login") && pw_string.equals("password")) {
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Такого пользователя не существует", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUpClick(View view) {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}
