package com.example.ormlitedatabaseapplication;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Bagwan Akib Rafiq on 5/5/2019.
 */
@DatabaseTable(tableName = "Contact")
public class ContactTable {

    public ContactTable() {
    }

    public ContactTable(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String name;
    @DatabaseField
    String mobileNumber;
}
