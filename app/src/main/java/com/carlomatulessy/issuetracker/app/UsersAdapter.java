package com.carlomatulessy.issuetracker.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.data.User;

import java.util.ArrayList;
import java.util.HashMap;

import static com.carlomatulessy.issuetracker.R.string.issue_tracker_cardview_issue_title;

/**
 * Created by Carlo on 7-9-2017.
 */

class UsersAdapter extends BaseAdapter {

    private final ArrayList<User> data;

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
        String issue = data.get(position).getIssueCount() + parent.getResources().getString(issue_tracker_cardview_issue_title);
        userIssueCountTextView.setText(issue);

        userProfilePicture.setImageResource(data.get(position).getProfilePictureResourceId());

        return result;
    }
}
