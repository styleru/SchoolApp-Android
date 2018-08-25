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
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Router;
import style.ru.schoolapp.mvp.allCourses.AllCoursesAdapter;
import style.ru.schoolapp.mvp.allCourses.AllCoursesPresenter;
import style.ru.schoolapp.mvp.allCourses.AllCoursesView;

/**
 * Created by romananchugov on 14.08.2018.
 */

public class AllCoursesFragment extends MvpAppCompatFragment implements AllCoursesView {
    private static final String TAG = AllCoursesFragment.class.getSimpleName();

    @InjectPresenter
    AllCoursesPresenter presenter;

    @BindView(R.id.allCoursesRv)
    RecyclerView recyclerView;

    @Inject
    Router router;

    @ProvidePresenter
    AllCoursesPresenter provideAllCoursesPresenter(){
        return new AllCoursesPresenter(router);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TODO: to understand how does it works
        SchoolApplication.INSTANCE.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_courses, container, false);

        ButterKnife.bind(this, view);

        //TODO: injection for adapter
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        recyclerView.setAdapter(new AllCoursesAdapter(presenter));

        return view;
    }

    @Override
    public void openSelectedCourse() {
        router.navigateTo(Screens.SPECIFIC_COURSE_SCREEN);
    }

    @Override
    public void openListOfCourse() {
        return;
    }

    @Override
    public void openHomeworkFragment() {
        return;
    }
}
