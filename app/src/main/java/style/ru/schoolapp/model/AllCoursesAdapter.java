package style.ru.schoolapp.model;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import style.ru.schoolapp.R;

/**
 * Created by romananchugov on 14.08.2018.
 */

public class AllCoursesAdapter extends RecyclerView.Adapter<AllCoursesAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_courses, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout constraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView;
        }
    }
}
