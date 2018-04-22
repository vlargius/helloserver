package jdbc_database.dao;

import java.sql.Connection;

import accounts.UserProfile;
import jdbc_database.datasets.UsersDataSet;
import jdbc_database.executor.Executor;

import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserProfile getUserByName(String name) throws SQLException {
        return executor.execQuery("SELECT user_login, user_password FROM users WHERE user_login='" + name + "'", result -> {
            UserProfile profile = null;
            if(result.next()) {
                profile = new UserProfile(result.getString(1), result.getString(2));
            }
            return profile;
        });
    }

    public void insertUser(UserProfile profile) throws SQLException {
        executor.execUpdate("insert into users (user_login, user_password) values ('"
                + profile.getLogin()
                + "', '"
                + profile.getPassword()
                + "')");

    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users " +
                "(id bigint auto_increment, " +
                "user_login varchar(256), " +
                "user_password varchar(256), " +

                "primary key (id))"
        );
    }

//    public void dropTable() throws SQLException {
//        executor.execUpdate("DROP TABLE users");
//    }

}
