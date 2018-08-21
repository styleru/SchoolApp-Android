package style.ru.schoolapp.UI.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import style.ru.schoolapp.MainActivity;
import style.ru.schoolapp.R;
import style.ru.schoolapp.UI.Recyclers.EnrollmentRecyclerViewAdapter;

public class EnrollmentActivity extends AppCompatActivity {
    private static final String TAG = "EnrollmentActivity";
    public static final int NUM_COLUMNS = 2;
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private static Button skipSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);
        skipSubmitButton = findViewById(R.id.skipSubmitButton);
        initImageBitMaps();
    }

    private void initImageBitMaps() {
        Log.d(TAG, "initImageBitMaps: preparing bitmaps");
        mImageUrls.add("https://tehnot.com/wp-content/uploads/2016/05/android-1068x668.jpg");
        mImageUrls.add("https://www.lexcomp.ru/wa-data/public/blog/plugins/logopost/images/HymFoipsuJ.jpg");
        mImageUrls.add("http://sharelink.ru/static/info/img/pythonimg.jpg");
        mImageUrls.add("https://www.mart.ru/assets/components/phpthumbof/cache/web1.82b4e3f3c43c5859f21b4ea0b9110d09345.jpg");

        mImageUrls.add("http://www.tinydog.ru/wp-content/uploads/2016/09/Zabota-o-koshke.jpg");
        mImageUrls.add("http://wallpaperget.com/images/dog-images-22.jpg");
        mImageUrls.add("https://cdn.wallpapersafari.com/57/78/Q3tsxn.jpg");
        mImageUrls.add("https://wallbox.ru/wallpapers/main/201131/gorod-panorama-ssha-c03ed14.jpg");

        mImageUrls.add("http://www.tinydog.ru/wp-content/uploads/2016/09/Zabota-o-koshke.jpg");
        mImageUrls.add("http://wallpaperget.com/images/dog-images-22.jpg");
        mImageUrls.add("https://cdn.wallpapersafari.com/57/78/Q3tsxn.jpg");
        mImageUrls.add("https://wallbox.ru/wallpapers/main/201131/gorod-panorama-ssha-c03ed14.jpg");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recycler view");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EnrollmentRecyclerViewAdapter enrollmentRecyclerViewAdapter =
                new EnrollmentRecyclerViewAdapter(this, mImageUrls);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(enrollmentRecyclerViewAdapter);
    }

    public static void setSelectText() {
        skipSubmitButton.setText("Выбрать");
    }

    public void skipSubmitClick(View view) {
        Intent intent = new Intent(EnrollmentActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
