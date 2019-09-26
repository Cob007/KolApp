package android.michealcob.kolapp.ui.adapter;

import android.michealcob.kolapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageRVAdapter extends RecyclerView.Adapter<ImageRVAdapter.ViewHolder> {

    int[] images = { R.drawable.ing1,
            R.drawable.img2, R.drawable.img3, R.drawable.ing1,
            R.drawable.img2, R.drawable.img3
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.media_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.mImg.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        if(null == images) return 0;
        return this.images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.iv_img);
        }
    }
}
