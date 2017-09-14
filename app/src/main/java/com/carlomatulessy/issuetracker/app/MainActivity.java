package com.carlomatulessy.issuetracker.app;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.data.User;
import com.carlomatulessy.issuetracker.data.UserManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Carlo on 5-9-2017.
 * This is the class with the main screen where we showcase a listview with 3 users including their
 * avatar, name, birthdate and issue counts which we retrieve from the issues.csv file
 */
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
            openUserCardDialog((User)parent.getAdapter().getItem(position));
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

    @Override
    public void onResume() {
        super.onResume();

        if(UserManager.getInstance().getRefreshUserList()) {
            usersList.setAdapter(new UsersAdapter(UserManager.getInstance().getAllUsers()));
            UserManager.getInstance().setRefreshUserList(false);
        }
    }

    private void openUserCardDialog(final User selectedUser) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.user_card_dialog);

        TextView userCardDialogTitle = (TextView) dialog.findViewById(R.id.userdialog_title);
        TextView userCardDialogIssue = (TextView) dialog.findViewById(R.id.userdialog_issue_text);
        ImageView userCardDialogAvatar = (ImageView) dialog.findViewById(R.id.userdialog_avatar);
        Button userCardDialogCancelButton = (Button) dialog.findViewById(R.id.userdialog_cancel_button);
        Button userCardDialogNewIssueButton = (Button) dialog.findViewById(R.id.userdialog_new_issue_button);

        userCardDialogTitle.setText(selectedUser.getUserFullName());

        String issues = selectedUser.getIssueCount() +" "+ getResources().getString(R.string.userdialog_issues_text);
        userCardDialogIssue.setText(issues);

        userCardDialogAvatar.setImageResource(selectedUser.getProfilePictureResourceId());

        userCardDialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        userCardDialogNewIssueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewIssuesActivity.class);
                intent.putExtra("username", selectedUser.getUserFullName());
                startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private class ReadCSVTask extends AsyncTask<String, Integer, Long> {

        @Override
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
                        users.put(user.getUserFullName(), user);
                    }
                }

                inputStream.close();
                UserManager.getInstance().setUsers(users);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return lineNumber;
        }

        @Override
        protected void onPostExecute(Long result) {
            UserManager.getInstance().setUsersAvatars();
            usersList.setAdapter(new UsersAdapter(UserManager.getInstance().getAllUsers()));
        }
    }
}
