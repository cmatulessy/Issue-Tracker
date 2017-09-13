package com.carlomatulessy.issuetracker.app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.data.User;
import com.carlomatulessy.issuetracker.data.UserManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usersList = (ListView) findViewById(R.id.users_listview);

        new ReadCSVTask().execute("issues.csv");

        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Snackbar.make(view, "Open dialog screen with info", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
           }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ReadCSVTask extends AsyncTask<String, Integer, Long> {
        protected Long doInBackground(String... fileName) {
            long lineNumber = 0;
            InputStreamReader inputStreamReader;

            try {
                inputStreamReader = new InputStreamReader(getAssets().open(fileName[0]));
                Scanner inputStream = new Scanner(inputStreamReader);
                inputStream.nextLine();
                HashMap<String, User> users = new HashMap<>();

                while (inputStream.hasNext()) {
                    lineNumber++;
                    String data = inputStream.nextLine();
                    String[] userData = data.replace("\"", "").split(",");

                    if (userData.length > 1) {
                        User user = new User(userData);
                        users.put(user.getFirstName(), user);
                    }
                }

                inputStream.close();
                UserManager.getInstance().setUsers(users);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return lineNumber;
        }

        protected void onPostExecute(Long result) {
            UserManager.getInstance().setUsersAvatars();
            usersList.setAdapter(new UsersAdapter(UserManager.getInstance().getAllUsers()));
        }
    }
}
