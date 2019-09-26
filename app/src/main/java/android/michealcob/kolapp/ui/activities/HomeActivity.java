package android.michealcob.kolapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.michealcob.kolapp.R;
import android.michealcob.kolapp.ui.common.Fonts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeActivity extends AppCompatActivity {

    private static final String URL = "http://kolpreview1.thenerdinc.com/producekol.html";

    private WebView webView;

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
        setContentView(R.layout.activity_home);
        initViews();
    }

    private void initViews() {
        webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webView.loadUrl(URL);
    }

    public void onProfile(View view) {
        startActivity(new Intent(view.getContext(), ProfileActivity.class));
    }

    public void onReg(View view) {
        startActivity(new Intent(view.getContext(), RegisterActivity.class));
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
