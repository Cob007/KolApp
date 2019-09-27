package android.michealcob.kolapp.ui.adapter;

import android.content.Context;
import android.michealcob.kolapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cRAdapter extends RecyclerView.Adapter<cRAdapter.ViewHolder> {

    Context context;
    int[] images = { R.drawable.ic_increase_raking,
            R.drawable.ic_increase_raking, R.drawable.ic_decrease_ranking, R.drawable.ic_increase_raking,
            R.drawable.ic_line, R.drawable.ic_increase_raking,
    };

    public cRAdapter(Context mCtx){
        this.context = mCtx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.current_ranking, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.mImg.setImageResource(images[position]);
        if (position==4){
            viewHolder.layout.setBackgroundColor(context.getResources().getColor(R.color.colorGray));
        }
    }

    @Override
    public int getItemCount() {
        if(null == images) return 0;
        return this.images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImg;
        public FrameLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img_incr);
            layout = itemView.findViewById(R.id.fl);
        }
    }
}
