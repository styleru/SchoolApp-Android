
package style.ru.schoolapp.UI.BottomNavigationActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import style.ru.schoolapp.BottomNavigationViewHelper;
import style.ru.schoolapp.Model.Entity.Notification;
import style.ru.schoolapp.R;
import style.ru.schoolapp.UI.Recyclers.EnrollmentRecyclerViewAdapter;
import style.ru.schoolapp.UI.Recyclers.NotificationRecyclerViewAdapter;
import style.ru.schoolapp.UI.Recyclers.RecyclerViewAdapter;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = "NotificationsActivity";
    private Context context = NotificationsActivity.this;
    private ArrayList<Notification> notifications = new ArrayList<>();
    private static final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        setupBottomNavigationView();
        initContent();
    }

    private void initContent() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Уведомления");
        toolbar.setTitleTextColor(android.graphics.Color.WHITE);

        Log.d(TAG, "initImageBitMaps: preparing bitmaps");
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recycler view");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        NotificationRecyclerViewAdapter adapter = new NotificationRecyclerViewAdapter(this, notifications);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
