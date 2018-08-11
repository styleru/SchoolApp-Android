package style.ru.schoolapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import style.ru.schoolapp.model.DialogsAdapter;
import style.ru.schoolapp.presenter.DialogsPresenter;
import style.ru.schoolapp.view.DialogsView;

/**
 * Created by romananchugov on 11.08.2018.
 */

public class DialogsFragment extends MvpAppCompatFragment implements DialogsView {

    @InjectPresenter
    DialogsPresenter presenter;

    @BindView(R.id.dialogsRecycler)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialogs, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new DialogsAdapter());

        return view;
    }
}
