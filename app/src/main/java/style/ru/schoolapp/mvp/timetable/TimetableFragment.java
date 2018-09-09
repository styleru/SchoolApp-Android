package style.ru.schoolapp.mvp.timetable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.greasemonk.timetable.TimeTable;

import butterknife.BindView;
import butterknife.ButterKnife;
import style.ru.schoolapp.R;

public class TimetableFragment extends MvpAppCompatFragment {

    @BindView(R.id.timetable)
    TimeTable timeTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        ButterKnife.bind(this, view);

        //timeTable.setItems(); TODO: data

        return view;
    }


}
