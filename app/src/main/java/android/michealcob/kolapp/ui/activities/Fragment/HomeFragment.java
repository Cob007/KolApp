package android.michealcob.kolapp.ui.activities.Fragment;


import android.michealcob.kolapp.ui.adapter.cRAdapter;
import android.michealcob.kolapp.ui.adapter.mRAdapter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.michealcob.kolapp.R;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView mRvCurrentRanking, mRvMyRanking;
    RecyclerView.Adapter mAdapterCR, mAdapterMR;
    LinearLayoutManager layoutManagerCR, layoutManagerMR;

    LinearLayout mCurrent, mRanking, mC, mM;

    TextView mTextC, mTextM;
    View vC, vM;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =
                inflater.inflate(R.layout.fragment_home,
                        container, false);
        init(view);

        mAdapterCR = new cRAdapter(getActivity());
        layoutManagerCR = new LinearLayoutManager(getActivity());

        mRvCurrentRanking.setLayoutManager(layoutManagerCR);
        mRvCurrentRanking.setAdapter(mAdapterCR);

        mAdapterMR = new mRAdapter();
        layoutManagerMR = new LinearLayoutManager(getActivity());

        mRvMyRanking.setLayoutManager(layoutManagerMR);
        mRvMyRanking.setAdapter(mAdapterMR);

        mC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callCurrent();
            }
        });

        mM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callRanking();
            }
        });

        callCurrent();



        return view;
    }

    private void callRanking() {
        mCurrent.setVisibility(View.GONE);
        mRanking.setVisibility(View.VISIBLE);

        mTextC.setTextColor(getResources().getColor(R.color.inactiveColor));
        mTextM.setTextColor(getResources().getColor(R.color.activeColor));

        vC.setVisibility(View.GONE);
        vM.setVisibility(View.VISIBLE);
    }

    private void callCurrent() {
        mCurrent.setVisibility(View.VISIBLE);
        mRanking.setVisibility(View.GONE);

        mTextC.setTextColor(getResources().getColor(R.color.activeColor));
        mTextM.setTextColor(getResources().getColor(R.color.inactiveColor));

        vC.setVisibility(View.VISIBLE);
        vM.setVisibility(View.GONE);

    }

    private void init(View view) {
        mRvCurrentRanking = view.findViewById(R.id.rv_cr);
        mRvMyRanking = view.findViewById(R.id.rv_mr);

        mCurrent = view.findViewById(R.id.ll_cr);
        mRanking = view.findViewById(R.id.ll_mr);

        mTextC = view.findViewById(R.id.tv_c);
        mTextM = view.findViewById(R.id.tv_m);

        vC = view.findViewById(R.id.v_c);
        vM = view.findViewById(R.id.v_m);

        mC = view.findViewById(R.id.ll_c);
        mM = view.findViewById(R.id.ll_m);
    }

}
