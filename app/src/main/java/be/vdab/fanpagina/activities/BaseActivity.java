package be.vdab.fanpagina.activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RadioButton;

import java.util.Locale;

import be.vdab.fanpagina.R;
import be.vdab.fanpagina.utils.PreferencesHelper;

/**
 * Created by RWIL on 01/09/2015.
 */
public class BaseActivity extends AppCompatActivity {

    public final static String LANGUAGE_NL = "nl";
    public final static String LANGUAGE_EN = "en";

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio_nl:
//                if (checked)
//                    PreferencesHelper.setLanguagePreference(this, LANGUAGE_NL);
//                setLocale(LANGUAGE_NL);
//                break;
//            case R.id.radio_en:
//                if (checked)
//                    PreferencesHelper.setLanguagePreference(this, LANGUAGE_EN );
//                setLocale(LANGUAGE_EN);
//                break;
//        }
//    }


    public void setLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        recreate();
    }
}
