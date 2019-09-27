package android.michealcob.kolapp.ui.adapter;

import android.michealcob.kolapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class mRAdapter extends RecyclerView.Adapter<mRAdapter.ViewHolder> {

    String[] images = { "4","2","4"
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.my_ranking, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.mImg.setText(images[position]);
    }

    @Override
    public int getItemCount() {
        if(null == images) return 0;
        return this.images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.tv_number);
        }
    }
}
