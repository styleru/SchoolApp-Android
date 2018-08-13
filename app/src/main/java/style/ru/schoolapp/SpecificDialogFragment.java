package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import style.ru.schoolapp.presenter.DialogsPresenter;
import style.ru.schoolapp.view.DialogsView;

/**
 * Created by romananchugov on 13.08.2018.
 */

public class SpecificDialogFragment extends MvpAppCompatFragment implements DialogsView{

    @InjectPresenter
    DialogsPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_specific_dialog, container, false);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    presenter.backPressed();
                    return true;
                }
                return false;
            }
        } );

        return view;
    }


    @Override
    public void openSpecificDialog() {
        return;
    }

    @Override
    public void backToDialogs() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new DialogsFragment())
                .commitAllowingStateLoss();
    }
}
