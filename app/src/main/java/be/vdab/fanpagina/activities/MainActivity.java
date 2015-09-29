package be.vdab.fanpagina.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import be.vdab.fanpagina.BuildConfig;
import be.vdab.fanpagina.R;
import be.vdab.fanpagina.utils.PreferencesHelper;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    Toolbar toolbar;
    Button goToNextPage;
    Button openPopup;
    Button downloadImage;
    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.v(TAG, "The function onCreate() was called");
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupToolbar();

        goToNextPage = (Button) findViewById(R.id.go_to_next_page);
        goToNextPage.setOnClickListener(this);
        openPopup = (Button) findViewById(R.id.open_popup);
        openPopup.setOnClickListener(this);
        downloadImage = (Button) findViewById(R.id.download_image);
        downloadImage.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.v("The function onStart() was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.v(TAG, "The function onResume() was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.v(TAG, "The function onPause() was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.v(TAG, "The function onStop() was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.v(TAG, "The function onDestroy() was called");
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
        if (v == goToNextPage) {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        } else if (v == openPopup) {
            toastMessage("This is a pop-up");
        } else if (v == downloadImage) {
            ImageView x = (ImageView) findViewById(R.id.image1);
            Picasso.with(this).load("http://exmoorpet.com/wp-content/uploads/2012/08/cat.png").into(x);
//            finish();
//            startActivity(getIntent());
        }
    }

    private void toastMessage (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
