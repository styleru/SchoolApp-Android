package style.ru.schoolapp.view;

import com.arellomobile.mvp.MvpView;

/**
 * Created by romananchugov on 11.08.2018.
 */

public interface DialogsView extends MvpView {
    void openSpecificDialog();
    void backToDialogs();
}
