package com.ticket.flight.flightprojectwithnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

/*
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

*/
public class MainActivity extends AppCompatActivity {
    private Drawer.Result drawerResult = null;
/*

    FragmentAbout fabout;
    FragmentFavorites ffavorites;
    FragmentHistory fhistory;
    FragmentPrivateOffice fprivate;
    FragmentSearch fsearch;
    FragmentSettings fsettings;
*/








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.menu.activity_main_drawer)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.search_item).withIcon(FontAwesome.Icon.faw_search).withBadge("99").withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.history_item).withIcon(FontAwesome.Icon.faw_history),
                        new PrimaryDrawerItem().withName(R.string.favorites_item).withIcon(FontAwesome.Icon.faw_star).withBadge("6").withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.private_office_item).withIcon(FontAwesome.Icon.faw_send).withBadge("1").withIdentifier(3),
                        new SectionDrawerItem().withName(R.string.settings_item2),
                        new SecondaryDrawerItem().withName(R.string.settings_item).withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName(R.string.about_item).withIcon(FontAwesome.Icon.faw_question),
                        new DividerDrawerItem()
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);


                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof Nameable) {
                            Toast.makeText(MainActivity.this, MainActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
                        if (drawerItem instanceof Badgeable) {
                            Badgeable badgeable = (Badgeable) drawerItem;
                            if (badgeable.getBadge() != null) {
                                // учтите, не делайте так, если ваш бейдж содержит символ "+"
                                try {
                                    int badge = Integer.valueOf(badgeable.getBadge());
                                    if (badge > 0) {
                                        drawerResult.updateBadge(String.valueOf(badge - 1), position);
                                    }
                                } catch (Exception e) {
                                    Log.d("test", "Не нажимайте на бейдж, содержащий плюс! :)");
                                }
                            }
                        }
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof SecondaryDrawerItem) {
                            Toast.makeText(MainActivity.this, MainActivity.this.getString(((SecondaryDrawerItem) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                })
                .build();
    }








       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fabout = new FragmentAbout();
        ffavorites = new FragmentFavorites();
        fhistory = new FragmentHistory();
        fprivate = new FragmentPrivateOffice();
        fsearch = new FragmentSearch();
        fsettings = new FragmentSettings();*/


       /* setContentView(R.layout.app_bar_main);*/
        /*ListView listView = (ListView) findViewById(R.id.listView);
        final EditText editText = (EditText) findViewById(R.id.choicePlainText);
        final ArrayList<String> airports = new ArrayList<String>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2, airports);
        listView.setAdapter(adapter);



        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    airports.add(0,editText.getText().toString());
                    adapter.notifyDataSetChanged();

                    return true;
                }

                return false;
            }
        });*/





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
          */
   /* public boolean onNavigationItemSelected(MenuItem item) {*/
        // Handle navigation view item clicks here.
        /*int id = item.getItemId();

        FragmentTransaction ftrans = getFragmentManager().beginTransaction();


        if (id == R.id.nav_camara) {
            // Handle the camera action
            ftrans.replace(R.id.container, fsearch);
        } else if (id == R.id.nav_gallery) {
            ftrans.replace(R.id.container, fhistory);

        } else if (id == R.id.nav_slideshow) {
            ftrans.replace(R.id.container, ffavorites);

        } else if (id == R.id.nav_manage) {
            ftrans.replace(R.id.container, fprivate);

        } else if (id == R.id.nav_share) {
            ftrans.replace(R.id.container, fsettings);

        } else if (id == R.id.nav_send) {
            ftrans.replace(R.id.container, fabout);

        } ftrans.commit();*/

       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;*/

    public void Click(View view) {
        Intent intent = new Intent(MainActivity.this, AirportsChoiceButton.class);
        startActivity(intent);
    }





}

