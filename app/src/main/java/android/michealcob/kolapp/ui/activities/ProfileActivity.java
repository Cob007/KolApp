package android.michealcob.kolapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.michealcob.kolapp.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.michealcob.kolapp.ui.adapter.ImageRVAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ProfileActivity extends AppCompatActivity {
    FrameLayout mToggle;
    TextView mText;
    Boolean status;
    RecyclerView mRv;
    RecyclerView.Adapter mAdapter;
    GridLayoutManager layoutManager;
        @Override
        protected void attachBaseContext(Context newBase) {
            super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/OpenSans-Regular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
        setContentView(R.layout.activity_profile);
        status = true;

        mToggle = findViewById(R.id.open_toggle);
        mText = findViewById(R.id.i_mean_you_);

        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callOpener();
            }
        });
        mRv = findViewById(R.id.rv_gallery);
        mAdapter = new ImageRVAdapter();
        layoutManager = new GridLayoutManager( this, 3);
        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mAdapter);
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

    public void openNotification(View view) {
            startActivity(new Intent(view.getContext(), NotificationActivity.class));
    }

    public void onHomeIn(View view) {
            startActivity(new Intent(view.getContext(), HomeInActivity.class));
    }

    public void onHomeTwo(View view) {
            startActivity(new Intent(view.getContext(), HomeTwoActivity.class));
    }
}
