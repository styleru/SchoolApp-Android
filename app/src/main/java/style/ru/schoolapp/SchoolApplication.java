package style.ru.schoolapp;

import android.app.Application;

import style.ru.schoolapp.dagger.AppComponent;
import style.ru.schoolapp.dagger.DaggerAppComponent;

public class SchoolApplication extends Application {
    private static final String TAG = SchoolApplication.class.getSimpleName();

    public static SchoolApplication INSTANCE;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().build();
        }
        return appComponent;
    }
}
