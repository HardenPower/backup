package com.ticket.flight.flightapp;


import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import static com.mikepenz.materialdrawer.Drawer.Result;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Result drawerResult = null;

    TextView edTAirport1;
    TextView textView3;
    TextView textView;
    TextView textViewSearch;
    Intent mIntent;

    public static final int REQUEST_LIST = 1;
    private Drawer result = null;
    private boolean opened = false;




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTAirport1 = (TextView) findViewById(R.id.edTAirport1);
        edTAirport1.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);

        textViewSearch = (TextView) findViewById(R.id.textViewSearch);
        textViewSearch.setOnClickListener(this);






        // Инициализируем Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setBackground(getResources().getDrawable(R.drawable.flight));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Инициализируем Navigation Drawer
        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.drawer_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_search).withIcon(FontAwesome.Icon.faw_search).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_history).withIcon(FontAwesome.Icon.faw_history).withBadge("3").withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_favorites).withIcon(FontAwesome.Icon.faw_heart).withBadge("6").withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_private_office).withIcon(FontAwesome.Icon.faw_send).withBadge("1").withIdentifier(4),
                        new SectionDrawerItem().withName(R.string.drawer_item_settings0),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings1).withIcon(FontAwesome.Icon.faw_cog).withIdentifier(5),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_about).withIcon(FontAwesome.Icon.faw_question).withIdentifier(6)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1) {
                                intent = new Intent(MainActivity.this, MainActivity.class);
                            } else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainActivity.this, HistoryActivity.class);
                            } else if (drawerItem.getIdentifier() == 3) {
                                intent = new Intent(MainActivity.this, FavoritesActivity.class);
                            } else if (drawerItem.getIdentifier() == 4) {
                                intent = new Intent(MainActivity.this, PersonalCabinetActivity.class);
                            } else if (drawerItem.getIdentifier() == 5) {
                                intent = new Intent(MainActivity.this, SettingsActivity.class);
                            } else if (drawerItem.getIdentifier() == 6) {
                                intent = new Intent(MainActivity.this, AboutActivity.class);
                            }
                            if (intent != null) {
                                MainActivity.this.startActivity(intent);
                            }
                        }

                    }
                })
                .build();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
            /*MenuItem splashItem = menu.findItem(R.id.action_splash);
            splashItem.setChecked(preferenceHelper.getBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE));*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
                /*item.setChecked(!item.isChecked());
                preferenceHelper.putBoolean(PreferenceHelper.SPLASH_IS_INVISIBLE, item.isChecked());*/
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
    private void setUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Airports_Choice_Button.class);
        startActivityForResult(intent, REQUEST_LIST);
        switch (v.getId()) {
            case R.id.textViewSearch:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.domodedovo.ru/ru/main/airindicator/flightnew"));
                startActivity(intent);
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_LIST:
                    if (data == null) {
                        return;
                    }
                    String name = data.getStringExtra("name");
                    edTAirport1.setText(name);
                    break;
                default:
                    break;
            }
        }
    }
}



















