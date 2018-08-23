package style.ru.schoolapp.dagger;

import javax.inject.Singleton;

import dagger.Component;
import style.ru.schoolapp.AllCoursesFragment;
import style.ru.schoolapp.MainActivity;

@Singleton
@Component(modules = {NavigationModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(AllCoursesFragment fragment);
}
