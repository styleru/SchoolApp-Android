package style.ru.schoolapp;

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

import style.ru.schoolapp.UI.Recyclers.RecyclerViewAdapter;

public class MyAccountActivity extends Fragment {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_account, container, false);

        names.add("Android");
        imageUrls.add("https://bk-stavki.ru/wp-content/uploads/2017/08/1470558853_kak-ustanovit-dva-prilozheniya-na-android.jpg");

        names.add("Python");
        imageUrls.add("https://cdnhtml5hive.azureedge.net/wp-content/uploads/2016/05/python-1024x576.jpg?x25428");

        names.add("IOS");
        imageUrls.add("https://pbs.twimg.com/media/DZDj-MUWkAAwB74.jpg");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
