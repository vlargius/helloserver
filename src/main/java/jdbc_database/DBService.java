package jdbc_database;

import accounts.UserProfile;
import jdbc_database.dao.UsersDAO;
import jdbc_database.datasets.UsersDataSet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private final Connection connection;

    public DBService() {
        this.connection = getMysqlConnection();
    }

    public UserProfile getUser(String name) throws DBException {
        try {
            return (new UsersDAO(connection).getUserByName(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(UserProfile userProfile) {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            dao.createTable();
            if(dao.getUserByName(userProfile.getLogin()) == null)
                dao.insertUser(userProfile);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {

            }
        }
    }

//    public void cleanUp() throws SQLException {
//        UsersDAO dao = new UsersDAO(connection);
//        dao.dropTable();
//    }

    public void printConnectionInfo() {
        try {
            System.out.println("DB name:" + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=password");       //password

            System.out.println("URL: " + url + "\n");
            return DriverManager.getConnection(url.toString());
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
