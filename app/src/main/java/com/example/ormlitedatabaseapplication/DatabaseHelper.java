package com.example.ormlitedatabaseapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bagwan Akib Rafiq on 5/5/2019.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static String DB_NAME = "CONTACT_APP";
    private Dao<ContactTable,?> contactTableDao;
    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,ContactTable.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.createTable(connectionSource,ContactTable.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Dao<ContactTable, ?> getContactTableDao() throws SQLException {
        if(contactTableDao==null)
            contactTableDao = getDao(ContactTable.class);
        return contactTableDao;
    }
    boolean saveContact(String name, String number){
        try {
            Dao<ContactTable,?> contactTables = getContactTableDao();
            contactTables.create(new ContactTable(name,number));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    List<ContactTable> getAll(){
        try {
            Dao<ContactTable,?> contactTables = getContactTableDao();
            return  contactTables.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
