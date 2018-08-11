package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import style.ru.schoolapp.presenter.LoginPresenter;
import style.ru.schoolapp.view.LoginView;

/**
 * Created by romananchugov on 11.08.2018.
 */

public class LoginFragment extends MvpAppCompatFragment implements LoginView{

    @InjectPresenter
    LoginPresenter presenter;

    @BindView(R.id.loginButton)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO: maybe made module for it
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginToast() {
        Toast.makeText(this.getContext(), "Isn't available yet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openDialogsFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new DialogsFragment())
                .commitAllowingStateLoss();
    }

    @OnClick(R.id.loginButton)
    public void loginButtonClick(View view){
        presenter.loginButtonClick();
    }
}