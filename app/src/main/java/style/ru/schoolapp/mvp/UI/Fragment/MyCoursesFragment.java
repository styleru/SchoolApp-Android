package style.ru.schoolapp.mvp.UI.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import style.ru.schoolapp.R;
import style.ru.schoolapp.mvp.UI.Recyclers.CoursesRecyclerViewAdapter;

public class MyCoursesFragment extends Fragment {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imageUrls = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_courses, container, false);

        for (int i = 0; i < 5; i++) {
            names.add("Android");
            imageUrls.add("https://static.svyaznoy.ru/upload/kartinki/Android%208/4.jpg");

            names.add("IOS");
            imageUrls.add("https://static.svyaznoy.ru/upload/kartinki/Android%208/4.jpg");

            names.add("Python");
            imageUrls.add("https://static.svyaznoy.ru/upload/kartinki/Android%208/4.jpg");
        }

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        CoursesRecyclerViewAdapter adapter = new CoursesRecyclerViewAdapter(getActivity(), names, imageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
