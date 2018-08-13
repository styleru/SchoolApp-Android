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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import style.ru.schoolapp.R;
import style.ru.schoolapp.presenter.DialogsPresenter;

/**
 * Created by romananchugov on 11.08.2018.
 */

public class DialogsListAdapter extends RecyclerView.Adapter<DialogsListAdapter.ViewHolder> {

    //TODO: dagger 2 for it
    private DialogsPresenter presenter;

    public DialogsListAdapter(DialogsPresenter presenter){
        this.presenter = presenter;
    }

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

        ConstraintLayout constraintLayout;

        @BindView(R.id.teachersNameTv)
        TextView textView;
        @BindView(R.id.dialogImage)
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView;

            ButterKnife.bind(this, constraintLayout);
            textView = constraintLayout.findViewById(R.id.teachersNameTv);
            imageView = constraintLayout.findViewById(R.id.dialogImage);
        }

        @OnClick(R.id.dialogItemContainer)
        void clicked(View view){
            presenter.dialogClicked();
        }
    }

}
