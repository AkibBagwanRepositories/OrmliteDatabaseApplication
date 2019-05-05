package com.example.ormlitedatabaseapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bagwan Akib Rafiq on 5/5/2019.
 */
public class ContactListAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<ContactTable> contacts;
    private Context context;

    ContactListAdapter(Context context, ArrayList<ContactTable> contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contacts.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(context).inflate(R.layout.data_view,parent,false);
        viewHolder holder = new viewHolder(view);
        holder.name.setText(contacts.get(position).name);
        holder.contact.setText(contacts.get(position).mobileNumber);
        return view;
    }
    public class viewHolder{
        TextView name,contact;

        viewHolder(View view) {
            name = view.findViewById(R.id.txt_name);
            contact = view.findViewById(R.id.txt_contact);
        }
    }
}
