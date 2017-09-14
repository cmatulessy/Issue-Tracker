package com.carlomatulessy.issuetracker.app;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.data.UserManager;

/**
 * Created by Carlo on 5-9-2017.
 * This is the class for creating a new issue screen.
 */
public class NewIssuesActivity extends AppCompatActivity {
    private EditText issueDescription;
    private View.OnClickListener gotIssuesClickListener;
    private String selectedUserFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_issues);
        selectedUserFullName = getIntent().getStringExtra("username");

        TextView username = (TextView) findViewById(R.id.newissue_username);
        issueDescription = (EditText) findViewById(R.id.newissue_description) ;
        Button submitIssueButton = (Button) findViewById(R.id.newissue_submit_button);

        username.setText(selectedUserFullName);
        submitIssueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitIssue(issueDescription.getText().toString());
            }
        });

        gotIssuesClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueDescription.setText(getResources().getText(R.string.newissue_mr_t_issue));
            }
        };
    }

    private void submitIssue(String issueDescription) {
        if(issueDescription.length() <= 0) {
            Snackbar.make(findViewById(android.R.id.content), getResources().getText(R.string.newissue_snackbar_question), Snackbar.LENGTH_LONG)
                    .setAction(getResources().getText(R.string.newissue_snackbar_button), gotIssuesClickListener)
                    .setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                    .show();
        } else {
            UserManager.getInstance().getUserWithName(selectedUserFullName).addOneIssueToCount();
            UserManager.getInstance().setRefreshUserList(true);
            finish();
        }
    }
}
