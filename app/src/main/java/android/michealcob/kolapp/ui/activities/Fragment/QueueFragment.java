package android.michealcob.kolapp.ui.activities.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.michealcob.kolapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueueFragment extends Fragment {


    public QueueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =
                inflater.inflate(R.layout.fragment_queue,
                        container, false);

        return view;
    }

}
