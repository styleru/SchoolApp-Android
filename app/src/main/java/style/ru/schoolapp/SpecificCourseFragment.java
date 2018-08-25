package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Router;
import style.ru.schoolapp.mvp.specificCourse.SpecificCoursePresenter;
import style.ru.schoolapp.mvp.specificCourse.SpecificCourseView;

/**
 * Created by romananchugov on 18.08.2018.
 */

public class SpecificCourseFragment extends MvpAppCompatFragment implements SpecificCourseView {
    private static final String TAG = SpecificCourseFragment.class.getSimpleName();


    @InjectPresenter
    SpecificCoursePresenter presenter;

    @BindView(R.id.specificCourseStatusBtn)
    Button button;

    @Inject
    Router router;

    @ProvidePresenter
    SpecificCoursePresenter provideSpecificCoursePresenter(){
        return new SpecificCoursePresenter(router);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SchoolApplication.INSTANCE.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_course, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.specificCourseStatusBtn)
    void btnClicked(){
        presenter.statusButtonClicked();
    }


}
