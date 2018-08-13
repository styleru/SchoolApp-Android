package style.ru.schoolapp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import style.ru.schoolapp.view.DialogsView;

/**
 * Created by romananchugov on 11.08.2018.
 */

@InjectViewState
public class DialogsPresenter extends MvpPresenter<DialogsView> {
    public static final String TAG = DialogsPresenter.class.getSimpleName();
    
    
    public DialogsPresenter(){

    }

    public void dialogClicked() {
        getViewState().openSpecificDialog();
    }

    public void backPressed(){
        getViewState().backToDialogs();
    }
}
