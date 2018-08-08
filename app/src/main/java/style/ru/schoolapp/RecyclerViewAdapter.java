package style.ru.schoolapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> imageNames = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images) {
        this.imageNames = imageNames;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(context)
                .asBitmap()
                .load(images.get(position))
                .into(holder.courseImage);

        holder.courseName.setText(imageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + imageNames.get(position));
                Toast.makeText(context, imageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView courseImage;
        TextView courseName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            courseImage = itemView.findViewById(R.id.courseImage);
            courseName = itemView.findViewById(R.id.courseName);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

}
