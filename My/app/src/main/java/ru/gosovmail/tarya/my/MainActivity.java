package ru.gosovmail.tarya.my;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.sql.Time;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    Time today = new Time(21);
    DBAdapter myDB;
    EditText editText6;
    Cursor cursor;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText6 = (EditText) findViewById(R.id.editText6);

        populateListView();
        openDB();


        myDB = new DBAdapter(this);
        myDB.open();

        //cursor = myDB.getAllRows();
        //startManagingCursor(cursor);



    }

     private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    public void onClick_AddTask(View view) {
        String timestamp = today.toString();
        if (!TextUtils.isEmpty(editText6.getText().toString())) {
            myDB.insertRow(editText6.getText().toString(),timestamp);
        }
        populateListView();
    }

    private void populateListView(){
        Cursor cursor = myDB.getAllRows();
        String[] fromFieldNames = new String[]{DBAdapter.Key_RowID,DBAdapter.Key_TASK};
        int[] toViewIDs = new int[]{R.id.txt_sp1,R.id.cbx_buy};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.custom_listview,cursor, fromFieldNames,toViewIDs,0);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myCursorAdapter);
    }

}






