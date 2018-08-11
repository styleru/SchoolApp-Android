package style.ru.schoolapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import style.ru.schoolapp.view.LoginView;

/**
 * Created by romananchugov on 11.08.2018.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    public LoginPresenter(){
        getViewState().showMessage("It works");
    }

    public void loginButtonClick(){
        getViewState().showLoginToast();
        getViewState().openDialogsFragment();
    }
}