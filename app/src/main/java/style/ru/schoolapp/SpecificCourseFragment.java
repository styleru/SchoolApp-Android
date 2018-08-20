package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import style.ru.schoolapp.presenter.AllCoursesPresenter;
import style.ru.schoolapp.view.AllCoursesView;

/**
 * Created by romananchugov on 18.08.2018.
 */

public class SpecificCourseFragment extends MvpAppCompatFragment implements AllCoursesView {
    private static final String TAG = SpecificCourseFragment.class.getSimpleName();

    @InjectPresenter
    AllCoursesPresenter allCoursesPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_course, container, false);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    allCoursesPresenter.backPressed();
                    return true;
                }
                return false;
            }
        } );

        return view;
    }

    @Override
    public void openSelectedCourse() {
        return;
    }

    @Override
    public void openListOfCourse() {
        Log.i(TAG, "openListOfCourse: ");
        getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new AllCoursesFragment())
                .commitAllowingStateLoss();
    }


}
