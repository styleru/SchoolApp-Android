package style.ru.schoolapp.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by romananchugov on 14.08.2018.
 */

public interface AllCoursesView extends MvpView {
    public void openSelectedCourse();
    public void openListOfCourse();
    void openHomeworkFragment();
}
