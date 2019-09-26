package android.michealcob.kolapp.ui.common;

import android.content.Context;
import android.graphics.Typeface;

public class Fonts {

    private final static String OPEN_SANS_FONT = "fonts/OpenSans-Bold.ttf";

    public static Typeface openSansFont(Context context) {
        return Typeface.createFromAsset(context.getResources().getAssets(), OPEN_SANS_FONT);
    }

}
