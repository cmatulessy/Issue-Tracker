package com.carlomatulessy.issuetracker.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

        TextView username = (TextView) result.findViewById(R.id.user_name_listitem);
        username.setText(data.get(position).getFirstName() +" "+data.get(position).getSurName());

        return result;
    }
}
