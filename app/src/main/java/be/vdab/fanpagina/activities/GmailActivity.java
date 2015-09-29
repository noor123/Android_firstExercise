package be.vdab.fanpagina.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import be.vdab.fanpagina.R;
import be.vdab.fanpagina.utils.PreferencesHelper;

public class GmailActivity extends BaseActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.gmail.com");
    }

    public void setupToolbar() {
        toolbar.setTitle("It's MISTER cat for you");
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_nederlands) {
            PreferencesHelper.setLanguagePreference(this, LANGUAGE_NL);
            setLocale(LANGUAGE_NL);
        } else {
            PreferencesHelper.setLanguagePreference(this, LANGUAGE_EN );
            setLocale(LANGUAGE_EN);
        }

        return super.onOptionsItemSelected(item);
    }

}
