package com.carlomatulessy.issuetracker.app;

import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
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

/**
 * Created by Carlo on 7-9-2017.
 */

public class UsersAdapter extends BaseAdapter {

    private ArrayList<User> data;
    private ViewHolder cardViewHolder;

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

        if(convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_adapter_item, parent, false);
        } else {
            result = convertView;
        }

        cardViewHolder = new ViewHolder();
        cardViewHolder.username = (TextView) result.findViewById(R.id.user_name_cardview);
        cardViewHolder.userBirthDate = (TextView) result.findViewById(R.id.user_birthdate_cardview);
        cardViewHolder.userIssueCount = (TextView) result.findViewById(R.id.user_issue_count_cardview);
        cardViewHolder.userProfilePicture = (ImageView) result.findViewById(R.id.user_picture_cardview);

        String userFullName = data.get(position).getFirstName() +" "+data.get(position).getSurName();

        cardViewHolder.username.setText(userFullName);
        cardViewHolder.userBirthDate.setText(data.get(position).getDateOfBirth());
        cardViewHolder.userIssueCount.setText(data.get(position).getIssueCount() + "\nissues");
        setUserAvatar(userProfilePicture, userFullName, parent);

        new AsyncTask<ViewHolder, Void, Void>() {
            ViewHolder holder;
            String currentUser;

            @Override
            protected ViewHolder doInBackground(ViewHolder... params) {
                holder = params[0];
            }

            @Override
            protected void onPostExecute(ImageView result) {
                super.onPostExecute(result);

            }
        }.execute(userFullName);


        return result;
    }

    private void setUserAvatar(ImageView userProfile, String username, ViewGroup parent) {
        switch (username.toLowerCase()) {
            case "fiona de vries" :
                userProfile.setImageDrawable(ContextCompat.getDrawable(parent.getContext(), R.drawable.fiona));
                break;
            case "petra boersma" :
                userProfile.setImageDrawable(ContextCompat.getDrawable(parent.getContext(), R.drawable.petra));
                break;
            case "theo jansen" :
                break;
            default :
                break;
        }
    }

    private static class ViewHolder {
        TextView username;
        TextView userBirthDate;
        TextView userIssueCount;
        ImageView userProfilePicture;
    }
}
