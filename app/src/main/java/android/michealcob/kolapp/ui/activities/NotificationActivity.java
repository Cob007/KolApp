package android.michealcob.kolapp.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.michealcob.kolapp.R;
import android.michealcob.kolapp.ui.adapter.NotificationRVAdapter;
import android.os.Bundle;
import android.widget.Toast;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView mRv;
    RecyclerView.Adapter mAdapter;
    LinearLayoutManager layoutManager;


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
        setContentView(R.layout.activity_notification);

        mRv = findViewById(R.id.rv_notification);
        NotificationRVAdapter.ItemClickListener itemClickListener = new NotificationRVAdapter.ItemClickListener() {
            @Override
            public void onItemClicked() {
                Toast.makeText(NotificationActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(NotificationActivity.this, DetailActivity.class));
            }
        };
        mAdapter = new NotificationRVAdapter(itemClickListener);
        layoutManager = new LinearLayoutManager(this);


        mRv.setLayoutManager(layoutManager);
        mRv.setAdapter(mAdapter);

    }
}
