package style.ru.schoolapp.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by romananchugov on 11.08.2018.
 */

public interface LoginView extends MvpView {
    public void showMessage(String message);
    public void showLoginToast();
    public void openDialogsFragment();
}