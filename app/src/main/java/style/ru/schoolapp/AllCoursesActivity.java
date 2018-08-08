package style.ru.schoolapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllCoursesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "AllCoursesActivity";

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

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

//        drawerLayout = findViewById(R.id.drawer);
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//
//        NavigationView navigationView = findViewById(R.id.navigationView);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        initImageBitmaps();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: prepering bitmaps");

        for (int i = 0; i < 5; i++) {
            names.add("Android");
            imageUrls.add("https://bk-stavki.ru/wp-content/uploads/2017/08/1470558853_kak-ustanovit-dva-prilozheniya-na-android.jpg");

            names.add("IOS");
            imageUrls.add("https://pbs.twimg.com/media/DZDj-MUWkAAwB74.jpg");

            names.add("Python");
            imageUrls.add("https://cdnhtml5hive.azureedge.net/wp-content/uploads/2016/05/python-1024x576.jpg?x25428");
        }

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.navAccount){
            Intent i = new Intent(this, MyAccountActivity.class);
            startActivity(i);
        } else if (id == R.id.navCourses){
            Intent i = new Intent(this, AllCoursesActivity.class);
            startActivity(i);
        } else if (id == R.id.navTimeTable){
            //Intent i = new Intent(this, AllCoursesActivity.class);
            //startActivity(i);
        } else if (id == R.id.navDialogs){
            //Intent i = new Intent(this, AllCoursesActivity.class);
            //startActivity(i);
        } else if (id == R.id.navHomeWork){
            //Intent i = new Intent(this, AllCoursesActivity.class);
            //startActivity(i);
        } else if (id == R.id.navExit) {
            //Intent i = new Intent(this, AllCoursesActivity.class);
            //startActivity(i);
        }
        return false;
    }
}
