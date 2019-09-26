package android.michealcob.kolapp.ui.activities.Fragment;


import android.michealcob.kolapp.ui.adapter.ImageRVAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.michealcob.kolapp.R;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    LinearLayout mLL, mllImage;
    ImageView mAdd;
    RecyclerView mRv;
    RecyclerView.Adapter mAdapter;
    GridLayoutManager layoutManager;
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        init(view);

        mAdapter = new ImageRVAdapter();
        layoutManager = new GridLayoutManager(getActivity(), 3);
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mAdapter);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openView();
            }
        });

        return view;
    }

    private void openView() {
        mllImage.setVisibility(View.VISIBLE);
        mLL.setVisibility(View.GONE);
    }

    private void init(View view) {
        mLL = view.findViewById(R.id.ll_no);
        mllImage = view.findViewById(R.id.ll_rv);
        mAdd = view.findViewById(R.id.iv_add);
        mRv = view.findViewById(R.id.rv_gallery_frag);
    }

}
