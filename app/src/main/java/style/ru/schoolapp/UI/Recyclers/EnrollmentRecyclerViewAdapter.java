package style.ru.schoolapp.UI.Recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;
import style.ru.schoolapp.R;
import style.ru.schoolapp.UI.Activity.EnrollmentActivity;

import java.util.ArrayList;

public class EnrollmentRecyclerViewAdapter extends RecyclerView.Adapter<EnrollmentRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "StaggeredRecyclerViewAd";
    private ArrayList<String> mInageUrls = new ArrayList<>();
    private Context mContext;

    public EnrollmentRecyclerViewAdapter(Context mContext, ArrayList<String> mInageUrls) {
        this.mInageUrls = mInageUrls;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_all_courses, viewGroup, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(mInageUrls.get(i))
                .apply(requestOptions)
                .into(viewHolder.image);

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnrollmentActivity.setSelectText();
                int width = viewHolder.image.getBorderWidth();
                if (width != 30) {
                    viewHolder.image.setBorderWidth(30);
                } else {
                    viewHolder.image.setBorderWidth(3);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mInageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.courseImage);
        }
    }

}
