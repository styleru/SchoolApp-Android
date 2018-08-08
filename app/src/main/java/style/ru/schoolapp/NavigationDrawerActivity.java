package style.ru.schoolapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmet_container, new MyAccountActivity()).commit();
            navigationView.setCheckedItem(R.id.navAccount);
            getSupportActionBar().setTitle("Личный кабинет");
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navAccount:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmet_container,
                        new MyAccountActivity()).commit();
                getSupportActionBar().setTitle("Личный кабинет");
                break;
            case R.id.navCourses:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmet_container,
                        new AllCoursesActivity()).commit();
                getSupportActionBar().setTitle("Мои курсы");
                initImageBitmaps();
                break;
            case R.id.navTimeTable:
                Toast.makeText(this, "Timetable screen", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("Расписание");
                break;
            case R.id.navDialogs:
                Toast.makeText(this, "Dialogs screen", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("Диалоги");
                break;
            case R.id.navHomeWork:
                Toast.makeText(this, "Homework screen", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle("Домашнее задание");
                break;
            case R.id.navExit:
                Toast.makeText(this, "Exit action", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();

    private void initImageBitmaps() {
        for (int i = 0; i < 5; i++) {
            names.add("Android");
            imageUrls.add("https://bk-stavki.ru/wp-content/uploads/2017/08/1470558853_kak-ustanovit-dva-prilozheniya-na-android.jpg");

            names.add("IOS");
            imageUrls.add("https://pbs.twimg.com/media/DZDj-MUWkAAwB74.jpg");

            names.add("Python");
            imageUrls.add("https://cdnhtml5hive.azureedge.net/wp-content/uploads/2016/05/python-1024x576.jpg?x25428");
        }
        //initRecyclerView()
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
