package style.ru.schoolapp;

import android.content.Intent;
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
import android.view.View;
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
                getSupportActionBar().setTitle("Все курсы");
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
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
