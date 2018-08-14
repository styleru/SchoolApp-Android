package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import style.ru.schoolapp.model.AllCoursesAdapter;
import style.ru.schoolapp.presenter.AllCoursesPresenter;
import style.ru.schoolapp.view.AllCoursesView;

/**
 * Created by romananchugov on 14.08.2018.
 */

public class AllCoursesFragment extends MvpAppCompatFragment implements AllCoursesView {

    @InjectPresenter
    AllCoursesPresenter presenter;

    @BindView(R.id.allCoursesRv)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_courses, container, false);

        ButterKnife.bind(this, view);

        //TODO: injection for adapter
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerView.setAdapter(new AllCoursesAdapter());

        return view;
    }
}
