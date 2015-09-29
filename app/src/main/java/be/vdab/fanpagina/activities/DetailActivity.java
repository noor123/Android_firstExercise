package be.vdab.fanpagina.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import be.vdab.fanpagina.R;
import be.vdab.fanpagina.utils.PreferencesHelper;

public class DetailActivity extends BaseActivity implements View.OnClickListener{

    Toolbar toolbar;
    Button goToFirstPage;
    Button openGoogleUrl;
    Button openGmailActivity;
    Button goToPageWithList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        goToFirstPage = (Button) findViewById(R.id.go_back);
        goToFirstPage.setOnClickListener(this);
        openGoogleUrl = (Button) findViewById(R.id.open_urlGoogle);
        openGoogleUrl.setOnClickListener(this);
        openGmailActivity = (Button) findViewById(R.id.open_Gmail);
        openGmailActivity.setOnClickListener(this);
        goToPageWithList = (Button) findViewById(R.id.go_to_page_with_list);
        goToPageWithList.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v == goToFirstPage) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v == openGoogleUrl) {
            String url = "http://www.google.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (v == openGmailActivity) {
            Intent intent = new Intent(this, GmailActivity.class);
            startActivity(intent);
        } else if (v == goToPageWithList) {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }

    }

}
