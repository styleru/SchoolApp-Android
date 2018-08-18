package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import style.ru.schoolapp.presenter.SpecificCoursePresenter;
import style.ru.schoolapp.view.SpecificCourseView;

/**
 * Created by romananchugov on 18.08.2018.
 */

public class SpecificCourseFragment extends MvpAppCompatFragment implements SpecificCourseView {


    @InjectPresenter
    SpecificCoursePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_course, container, false);
        return view;
    }
}
