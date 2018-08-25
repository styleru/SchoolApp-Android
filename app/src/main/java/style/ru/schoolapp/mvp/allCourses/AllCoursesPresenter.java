package style.ru.schoolapp.mvp.allCourses;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.terrakok.cicerone.Router;
import style.ru.schoolapp.Screens;

/**
 * Created by romananchugov on 14.08.2018.
 */
@InjectViewState
public class AllCoursesPresenter extends MvpPresenter<AllCoursesView> {
    private Router router;

    public AllCoursesPresenter(Router router){
        this.router = router;
    }

    public void itemClicked(){
        router.navigateTo(Screens.SPECIFIC_COURSE_SCREEN);
    }
}
