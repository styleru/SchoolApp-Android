package style.ru.schoolapp.mvp.UI.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import style.ru.schoolapp.HomeworkFragment;
import style.ru.schoolapp.R;
import style.ru.schoolapp.SchoolApplication;
import style.ru.schoolapp.mvp.UI.BottomNavigationFragments.AccountFragment;
import style.ru.schoolapp.mvp.UI.BottomNavigationFragments.NotificationsFragment;
import style.ru.schoolapp.mvp.UI.BottomNavigationViewHelper;
import style.ru.schoolapp.mvp.main.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SchoolApplication.INSTANCE.getAppComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavigation);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.navHomework:
                            selectedFragment = new HomeworkFragment();
                            break;
                        case R.id.navTimetable:
                            selectedFragment = new NotificationsFragment();
                            break;
                        case R.id.navNotifications:
                            selectedFragment = new NotificationsFragment();
                            break;
                        case R.id.navAccount:
                            selectedFragment = new AccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
}


//if(getSupportFragmentManager().getBackStackEntryCount() == 0){
//        presenter.onCreateActivity();
//        }

//    //TODO: remade all router calls with view state in presenters
//
//    @InjectPresenter
//    MainPresenter presenter;
//
//    @Inject
//    Router router;
//
//    @Inject
//    NavigatorHolder navigatorHolder;
//
//    @ProvidePresenter
//    MainPresenter provideMainPresenter() {
//        return new MainPresenter(router);
//    }
//
//
//    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fragmentContainer) {
//        @Override
//        protected Fragment createFragment(String screenKey, Object data) {
//            switch (screenKey) {
//                case Screens.ALL_COURSES_SCREEN:
//                    return new AllCoursesFragment();
//                case Screens.SPECIFIC_COURSE_SCREEN:
//                    return new SpecificCourseFragment();
//                case Screens.HOMEWORK_SCREEN:
//                    return new HomeworkFragment();
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        protected void showSystemMessage(String message) {
//
//        }
//
//        @Override
//        protected void exit() {
//            finish();
//        }
//    };
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        navigatorHolder.setNavigator(navigator);
//    }
//
//    @Override
//    protected void onPause() {
//        navigatorHolder.removeNavigator();
//        super.onPause();
//    }
//
//    @Override
//    public void onBackPressed() {
//        //TODO: case with clear activity
//        presenter.onBackPressed();
//    }