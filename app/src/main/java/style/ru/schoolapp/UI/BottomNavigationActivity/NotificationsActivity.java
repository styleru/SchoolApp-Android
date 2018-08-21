
package style.ru.schoolapp.UI.BottomNavigationActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

import style.ru.schoolapp.Model.Entity.Notification;
import style.ru.schoolapp.R;
import style.ru.schoolapp.UI.Recyclers.EnrollmentRecyclerViewAdapter;
import style.ru.schoolapp.UI.Recyclers.NotificationRecyclerViewAdapter;
import style.ru.schoolapp.UI.Recyclers.RecyclerViewAdapter;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = "NotificationsActivity";
    private ArrayList<Notification> notifications = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        initContent();
    }

    private void initContent() {
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
}
