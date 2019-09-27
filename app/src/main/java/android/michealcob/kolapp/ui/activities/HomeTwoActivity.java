package android.michealcob.kolapp.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.michealcob.kolapp.R;
import android.michealcob.kolapp.ui.activities.Fragment.GalleryFragment;
import android.michealcob.kolapp.ui.activities.Fragment.HomeFragment;
import android.michealcob.kolapp.ui.activities.Fragment.LiveFragment;
import android.michealcob.kolapp.ui.activities.Fragment.NotificationFragment;
import android.michealcob.kolapp.ui.activities.Fragment.ProfileFragment;
import android.michealcob.kolapp.ui.activities.Fragment.QueueFragment;
import android.michealcob.kolapp.ui.adapter.BottomBarAdapter;
import android.michealcob.kolapp.ui.common.NoSwipePager;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeTwoActivity extends AppCompatActivity {
    private NoSwipePager viewPager;
    private BottomBarAdapter pagerAdapter;
    BottomNavigationView navigation;

    HomeFragment homeFragment = new HomeFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    LiveFragment liveFragment = new LiveFragment();
    GalleryFragment galleryFragment = new GalleryFragment();
    ProfileFragment profileFragment = new ProfileFragment();

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
        setContentView(R.layout.activity_home_two);

        navigation = findViewById(R.id.navigation);
        viewPager = findViewById(R.id.vp_two);

        viewPager.setOffscreenPageLimit(5);
        viewPager.setPagingEnabled(false);

        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        pagerAdapter.addFragments(homeFragment);
        pagerAdapter.addFragments(notificationFragment);
        pagerAdapter.addFragments(liveFragment);
        pagerAdapter.addFragments(galleryFragment);
        pagerAdapter.addFragments(profileFragment);

        viewPager.setAdapter(pagerAdapter);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.tab2:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.tab3:
                        viewPager.setCurrentItem(2);
                        return true;
                    case R.id.tab4:
                        viewPager.setCurrentItem(3);
                        return true;
                    case R.id.tab5:
                        viewPager.setCurrentItem(4);
                        return true;
                }
                return false;
            }
        });

    }
}
