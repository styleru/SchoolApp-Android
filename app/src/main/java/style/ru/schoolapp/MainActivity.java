package style.ru.schoolapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import style.ru.schoolapp.mvp.main.MainPresenter;
import style.ru.schoolapp.mvp.main.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();

    //TODO: remade all router calls with view state in presenters

    @InjectPresenter
    MainPresenter presenter;

    @Inject
    Router router;

    @Inject
    NavigatorHolder navigatorHolder;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return new MainPresenter(router);
    }


    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fragmentContainer) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.ALL_COURSES_SCREEN:
                    return new AllCoursesFragment();
                case Screens.SPECIFIC_COURSE_SCREEN:
                    return new SpecificCourseFragment();
                case Screens.HOMEWORK_SCREEN:
                    return new HomewrokFragment();
                default:
                    return null;
            }
        }

        @Override
        protected void showSystemMessage(String message) {

        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SchoolApplication.INSTANCE.getAppComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportFragmentManager().getBackStackEntryCount() == 0){
            presenter.onCreateActivity();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        //TODO: case with clear activity
        presenter.onBackPressed();
    }
}
