package android.michealcob.kolapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.michealcob.kolapp.R;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class RegisterActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_register);
    }

    public void onLogin(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    public void onBack(View view) {
        onBackPressed();
    }
}
