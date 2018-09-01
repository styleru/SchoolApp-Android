package style.ru.schoolapp.mvp.UI.BottomNavigationFragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import style.ru.schoolapp.R;
import style.ru.schoolapp.mvp.Model.Notification;
import style.ru.schoolapp.mvp.UI.Recyclers.NotificationRecyclerViewAdapter;

public class NotificationsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        initNotificationsContent(view);

        return view;
    }

    public void initNotificationsContent(View view) {
        ArrayList<Notification> notifications = new ArrayList<>();
        int ACTIVITY_NUM = 2;

        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));
        notifications.add(new Notification("Изменение аудитории!", "22.09.2018", "Андроид пройдёт в 534 аудитории"));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        NotificationRecyclerViewAdapter adapter = new NotificationRecyclerViewAdapter(getActivity(), notifications);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}

