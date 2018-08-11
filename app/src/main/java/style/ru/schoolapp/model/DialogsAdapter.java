package style.ru.schoolapp.model;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import style.ru.schoolapp.R;

/**
 * Created by romananchugov on 11.08.2018.
 */

public class DialogsAdapter extends RecyclerView.Adapter<DialogsAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout= (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dialogs_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(constraintLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText("Teachers Name " + position);

        TextDrawable drawable = TextDrawable.builder()
                .buildRect("A", Color.RED);
        holder.imageView.setImageDrawable(drawable);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ConstraintLayout constraintLayout;
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            //TODO: butteknife
            constraintLayout = (ConstraintLayout) itemView;
            textView = constraintLayout.findViewById(R.id.teachersNameTv);
            imageView = constraintLayout.findViewById(R.id.dialogImage);
        }
    }

}
