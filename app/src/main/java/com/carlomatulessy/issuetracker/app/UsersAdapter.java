package com.carlomatulessy.issuetracker.app;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.data.User;
import com.carlomatulessy.issuetracker.data.UserManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carlo on 7-9-2017.
 */

public class UsersAdapter extends BaseAdapter {

    private ArrayList<User> data;

    public UsersAdapter(HashMap<String, User> users) {
        data = new ArrayList<>();
        data.addAll(users.values());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public User getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_adapter_item, parent, false);
        } else {
            result = convertView;
        }

        TextView usernameTextView = (TextView) result.findViewById(R.id.user_name_cardview);
        TextView userBirthDateTextView = (TextView) result.findViewById(R.id.user_birthdate_cardview);
        TextView userIssueCountTextView = (TextView) result.findViewById(R.id.user_issue_count_cardview);
        ImageView userProfilePicture = (ImageView) result.findViewById(R.id.user_picture_cardview);

        usernameTextView.setText(data.get(position).getUserFullName());
        userBirthDateTextView.setText(data.get(position).getDateOfBirth());
        userIssueCountTextView.setText(data.get(position).getIssueCount() + "\nissues");

        Picasso.with(parent.getContext())
                .load(data.get(position).getProfilePictureResourceId())
                .error(R.drawable.image_not_found)
                .into(userProfilePicture);

        return result;
    }
}
