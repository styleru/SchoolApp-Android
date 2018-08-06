package style.ru.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class AllCoursesActivity extends AppCompatActivity {

    private static final String TAG = "AllCoursesActivity";

    // vars
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_courses);

        Log.d(TAG, "onCreate: started");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Все курсы");
        setSupportActionBar(toolbar);

        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: prepering bitmaps");

        names.add("Android");
        imageUrls.add("https://bk-stavki.ru/wp-content/uploads/2017/08/1470558853_kak-ustanovit-dva-prilozheniya-na-android.jpg");

        names.add("IOS");
        imageUrls.add("https://pbs.twimg.com/media/DZDj-MUWkAAwB74.jpg");

        names.add("Python");
        imageUrls.add("https://cdnhtml5hive.azureedge.net/wp-content/uploads/2016/05/python-1024x576.jpg?x25428");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
