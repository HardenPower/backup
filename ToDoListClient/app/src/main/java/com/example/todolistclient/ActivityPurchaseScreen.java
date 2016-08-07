package com.example.todolistclient;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todolistclient.DB.DBHelper;
import com.example.todolistclient.dialog.AddingTaskDialogFragment;
import com.example.todolistclient.adapter.TabAdapter;
import com.example.todolistclient.fragment.CurrentTaskFragment;
import com.example.todolistclient.fragment.DoneTaskFragment;
import com.example.todolistclient.fragment.TaskFragment;
import com.example.todolistclient.model.ModelTask;


public class ActivityPurchaseScreen extends ActionBarActivity implements AddingTaskDialogFragment.AddingTaskListener, CurrentTaskFragment.OnTaskDoneListener, DoneTaskFragment.OnTaskRestoreListener {

    FragmentManager fragmentManager;
    TabAdapter tabAdapter;

    TaskFragment currentTaskFragment;
    TaskFragment doneTaskFragment;

    public DBHelper dbHelper;




    final String Tag = "lifecycle";

    /*ImageButton imageB1;
    ImageButton imageB2;*/
   /* LinearLayout Lilo;
    TextView editText6;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_screen);
        
        fragmentManager = getFragmentManager();



       /* editText6 = (TextView) findViewById(R.id.editText6);
        imageB2 = (ImageButton) findViewById(R.id.imageB2);

        Lilo = (LinearLayout) findViewById(R.id.Lilo);
        sp1 = (TextView) findViewById(R.id.sp1);*/

       /* Intent intent3 = getIntent();*/

        /*String name = intent3.getStringExtra("name");

        sp1.setText(name);*/

        Log.d(Tag, "ActivityPurchaseScreen создано");


        dbHelper = new DBHelper(getApplicationContext());
        /*FragmentManager fragmentManager;*/

        setUI();




    }

    private void setUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.current_task));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.done_task));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabAdapter tabAdapter = new TabAdapter(fragmentManager, 2);

        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        currentTaskFragment = (CurrentTaskFragment) tabAdapter.getItem(TabAdapter.CURRENT_TASK_FRAGMENT_POSITION);
        doneTaskFragment = (DoneTaskFragment) tabAdapter.getItem(TabAdapter.DONE_TASK_FRAGMENT_POSITION);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addingTaskDialog = new AddingTaskDialogFragment();
                addingTaskDialog.show(fragmentManager, "AddingTaskDialog");
            }
        });
    }








    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "ActivityPurchaseScreen onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "ActivityPurchaseScreen onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "ActivityPurchaseScreen onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "ActivityPurchaseScreen onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "ActivityPurchaseScreen onDestroy");
    }



    @Override
    public void onTaskAdded(ModelTask newTask) {
        currentTaskFragment.addTask(newTask, true);
        Toast.makeText(this, "Buy added.", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onTaskAddingCancel() {
        Toast.makeText(this, "Buy adding cancel", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onTaskDone(ModelTask task) {
        doneTaskFragment.addTask(task, false);
    }

    @Override
    public void onTaskRestore(ModelTask task) {
        currentTaskFragment.addTask(task, false);
    }

}
