package android.michealcob.kolapp.ui.activities.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.michealcob.kolapp.R;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    FrameLayout mToggle;
    TextView mText;
    Boolean status;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        status = true;

        mToggle = view.findViewById(R.id.open_toggle);
        mText = view.findViewById(R.id.i_mean_you_);
        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callOpener();
            }
        });

        return view;
    }

    private void callOpener() {
        if (status){
            mText.setVisibility(View.VISIBLE);
            status = false;
        }else{
            mText.setVisibility(View.GONE);
            status=true;
        }
    }

}
