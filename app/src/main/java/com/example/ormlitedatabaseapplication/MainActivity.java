package com.example.ormlitedatabaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lv_contact;
    Button bt_save;
    EditText edt_name, edt_contactNumber;
    ContactListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setCustomView(R.layout.toolbar_custom);
        init();
        getDataFormDB();
    }

    private void getDataFormDB() {
        List<ContactTable> contactsList = new DatabaseHelper(this).getAll();
        ArrayList<ContactTable> contacts = (ArrayList<ContactTable>) contactsList;
        adapter = new ContactListAdapter(this, contacts);
        lv_contact.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void init() {
        bt_save = findViewById(R.id.bt_save);
        edt_contactNumber = findViewById(R.id.edt_contact);
        edt_name = findViewById(R.id.edt_name);
        bt_save.setOnClickListener(this);
        lv_contact = findViewById(R.id.lv_contacts);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_save) {
            if (saveInDatabase()) {
                Toast("Contact Saved!");
                getDataFormDB();
            } else {
                Toast("Error while saving!");
            }
        }
    }

    private boolean saveInDatabase() {
        String name = edt_name.getText().toString();
        String contact = edt_contactNumber.getText().toString();
        return new DatabaseHelper(this).saveContact(name, contact);
    }

    public void Toast(String Msg) {
        Toast.makeText(this, Msg, Toast.LENGTH_LONG).show();
    }
}
