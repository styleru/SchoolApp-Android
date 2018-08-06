package style.ru.schoolapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import butterknife.BindView;

public class MyAccountActivity extends AppCompatActivity {

    //@BindView(R.id.userImage) ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        ImageView userImage = findViewById(R.id.userImage);
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("Личный кабинет");
        setSupportActionBar(toolbar);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.defaultuserimage);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        userImage.setImageDrawable(roundedBitmapDrawable);


    }
}
