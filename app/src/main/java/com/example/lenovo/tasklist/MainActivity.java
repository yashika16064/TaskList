package com.example.lenovo.tasklist;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   static ArrayList<Lists> tasks;
    RecyclerView Tasks;
    ListsAdapter adapter;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tasks = (RecyclerView) findViewById(R.id.Tasks);

        tasks = Lists.createList();

        adapter = new ListsAdapter(this, tasks);
        adapter.notifyItemInserted(tasks.size() - 1);
        Tasks.scrollToPosition(adapter.getItemCount() - 1);


        Tasks.setAdapter(adapter);

        Tasks.setLayoutManager(new LinearLayoutManager(this));




        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        //
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.task:
                final EditText taskEditText = new EditText(this);
                taskEditText.setHint("Enter Title");
                final EditText descEditText = new EditText(this);
                descEditText.setHint("Enter Description");
                AlertDialog.Builder dialog = new AlertDialog.Builder(this,R.style.MyAlertDialogStyle);
                dialog.setTitle("Add Task");
                LinearLayout layout = new LinearLayout(getApplicationContext());
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.addView(taskEditText);
                layout.addView(descEditText);
                dialog.setView(layout);
                dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        String desc = String.valueOf(descEditText.getText());
                        Lists.createContactsList(task,desc);
                        tasks = Lists.createList();
                        adapter.notifyItemInserted(tasks.size() - 1);
                        Tasks.scrollToPosition(adapter.getItemCount() - 1);


                    }
                });
                //dialog.setNavigateButton("Cancel", null);
                dialog.create();
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }


}
