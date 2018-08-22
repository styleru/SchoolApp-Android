package style.ru.schoolapp.UI.BottomNavigationActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import style.ru.schoolapp.BottomNavigationViewHelper;
import style.ru.schoolapp.Model.Entity.Notification;
import style.ru.schoolapp.R;
import style.ru.schoolapp.UI.Recyclers.NotificationRecyclerViewAdapter;
import style.ru.schoolapp.UI.Recyclers.RecyclerViewAdapter;

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = "AccountActivity";
    private Context context = AccountActivity.this;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();
    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        setupBottomNavigationView();
        initContent();
    }

    private void initContent() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Иван Иванов");
        toolbar.setTitleTextColor(android.graphics.Color.WHITE);

        Log.d(TAG, "initImageBitMaps: preparing bitmaps");
        names.add("Android");
        imageUrls.add("https://bk-stavki.ru/wp-content/uploads/2017/08/1470558853_kak-ustanovit-dva-prilozheniya-na-android.jpg");

        names.add("Python");
        imageUrls.add("https://cdnhtml5hive.azureedge.net/wp-content/uploads/2016/05/python-1024x576.jpg?x25428");

        names.add("IOS");
        imageUrls.add("https://pbs.twimg.com/media/DZDj-MUWkAAwB74.jpg");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recycler view");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        NotificationRecyclerViewAdapter adapter = new NotificationRecyclerViewAdapter(this, notifications);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Bottom Navigation View Setup
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(context, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
