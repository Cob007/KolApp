package android.michealcob.kolapp.ui.adapter;

import android.michealcob.kolapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationRVAdapter extends RecyclerView.Adapter<NotificationRVAdapter.ViewHolder> {

    String[] images = { "8 Aug",
            "8 Aug", "8 Aug", "8 Aug",
            "8 Aug", "8 Aug"
    };

    ItemClickListener itemClickListener;

    public NotificationRVAdapter(ItemClickListener _item){
        this.itemClickListener = _item;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.notification, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;
        viewHolder.mImg.setText(images[position]);
        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(null == images) return 0;
        return this.images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mImg;
        public LinearLayout mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.tv_date);
            mView = itemView.findViewById(R.id.view_more);
        }
    }

    public interface ItemClickListener{
        void onItemClicked();
    }
}
