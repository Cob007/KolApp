package android.michealcob.kolapp.ui.activities.Fragment;


import android.content.Intent;
import android.michealcob.kolapp.ui.activities.DetailActivity;
import android.michealcob.kolapp.ui.adapter.NotificationRVAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.michealcob.kolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    RecyclerView mRv;
    RecyclerView.Adapter mAdapter;
    LinearLayoutManager layoutManager;


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification,
                container, false);
        NotificationRVAdapter.ItemClickListener itemClickListener = new
                NotificationRVAdapter.ItemClickListener() {
                    @Override
                    public void onItemClicked() {
                        startActivity(new Intent(getActivity(), DetailActivity.class));
                    }
                };

        mRv = view.findViewById(R.id.rv_notification_fragment);
        mAdapter = new NotificationRVAdapter(itemClickListener);
        layoutManager = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mAdapter);
        return view;
    }

}
