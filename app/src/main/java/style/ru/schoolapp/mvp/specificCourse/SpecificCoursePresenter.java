package style.ru.schoolapp.mvp.specificCourse;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.terrakok.cicerone.Router;
import style.ru.schoolapp.Screens;

/**
 * Created by romananchugov on 18.08.2018.
 */

@InjectViewState
public class SpecificCoursePresenter extends MvpPresenter<SpecificCourseView> {
    private Router router;

    public SpecificCoursePresenter(Router router){
        this.router = router;
    }

    public void statusButtonClicked(){
        router.navigateTo(Screens.HOMEWORK_SCREEN);
    }
}
