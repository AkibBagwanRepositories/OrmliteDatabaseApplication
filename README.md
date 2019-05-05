# OrmliteDatabaseApplication
ORMLite Database Application - just for learning
lets Learn!!!
# Include dependencies in app.gradle
    //ORMLite 
    implementation 'com.j256.ormlite:ormlite-android:4.48'
    implementation 'com.j256.ormlite:ormlite-core:4.48'
    
    
# Create Tables (Initial)
```import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Bagwan Akib Rafiq on 5/5/2019.
 */
@DatabaseTable(tableName = "Contact")
public class ContactTable {

    @DatabaseField(generatedId = true)
    int id;
    
    @DatabaseField
    String name;
    
    @DatabaseField
    String mobileNumber;
}

# Create Database Helper

@Override
public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
  try {
    TableUtils.createTable(connectionSource,ContactTable.class);
  } catch (SQLException e) {
    e.printStackTrace();
  }
}
```
  
  
# Last config
  run this file by right click and hurry your orm is stable now.
```
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
```
# To use the table data you can use like

>Insert
```ContactTable.create(ContactTableObj); ```

>insert if not exist
```contactTables.createIfNotExists(ContactTableObj);```

>Create if not exist and update if exist
```contactTables.createOrUpdate(ContactTableObj);```

>Update
```ContactTable.update(ContactTableObj);```

>Update Id
```ContactTable.updateId(ContactTableObj,newID); ```

>get all records in List<Class>
```contactTables.queryForAll(); ```

>get count of existing records
```contactTables.countOf()```

>get records by prepared query
```contactTables.query(PreparedQuery<ContactTable>)```

>delete
```contactTables.delete(ContactTableObj)```

>delete more then one record
```contactTables.delete(List<ContactTableObj>)```

>delete more then one record by some specific values
```contactTables.delete(PreparedQuery<ContactTable>)```
