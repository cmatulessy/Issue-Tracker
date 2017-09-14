package com.carlomatulessy.issuetracker.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.carlomatulessy.issuetracker.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button githubButton = (Button) findViewById(R.id.about_github_button);
        Button carloButton = (Button) findViewById(R.id.about_carlo_button);

        githubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsiteWithURL("https://github.com/cmatulessy/Issue-Tracker");
            }
        });

        carloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsiteWithURL("http://www.carlomatulessy.com/");
            }
        });
    }

    private void openWebsiteWithURL(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
