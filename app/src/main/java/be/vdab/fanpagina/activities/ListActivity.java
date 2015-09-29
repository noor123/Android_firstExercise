package be.vdab.fanpagina.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import be.vdab.fanpagina.R;
import be.vdab.fanpagina.utils.PreferencesHelper;

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.v(TAG, "The function onCreate() was called");
        setContentView(R.layout.page_with_list);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        List<ContactInfo> contactList = new ArrayList<>();
        contactList.add(new ContactInfo("Dirk", "De Vos", "dirk.devos@gmail.com"));
        contactList.add(new ContactInfo("Rita", "Verhelst", "rita.verhelst@hotmail.com"));
        contactList.add(new ContactInfo("Evelien", "Jansens", "jansens.evelien@hotmail.com"));
        contactList.add(new ContactInfo("Paula", "Buyens", "buyenspaula@gmail.com"));
        contactList.add(new ContactInfo("Jos", "Petermans", "jos.petermans@gmail.com"));
        contactList.add(new ContactInfo("Peter", "Verhulst", "peter.verhulst@hotmail.com"));

        ContactAdapter ca = new ContactAdapter(contactList, this);
        recList.setAdapter(ca);

        recList.setLayoutManager(llm);
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
