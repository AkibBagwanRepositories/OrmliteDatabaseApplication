package com.example.ormlitedatabaseapplication;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Bagwan Akib Rafiq on 5/5/2019.
 */
public class OrmliteConfig extends OrmLiteConfigUtil {
    public static Class<?>[] classes = new Class[]{
            ContactTable.class
    };
    public static void main(String arg[]) throws IOException, SQLException {
        File conffile = new File("ormlite_config.properties");
        writeConfigFile(conffile, classes);
    }
}
