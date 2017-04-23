package DatabaseSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by roye on 2017/4/22.
 */
public class DatabaseConnector {
    static public void main(String args[])
    {
        DatabaseConnector a=new DatabaseConnector();
    }
    DatabaseConnector()
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
