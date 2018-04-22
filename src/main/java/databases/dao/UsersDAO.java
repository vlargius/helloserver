package databases.dao;

import java.sql.Connection;
import databases.datasets.UserDataset;
import databases.executor.Executor;

import java.sql.SQLException;

public class UserDAO {

    private Executor executor;

    public UserDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserDataset get(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new UserDataset(result.getLong(1), result.getString(2));
        });
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("SELECT * FROM users WHERE user_name='" + name + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    public void insertUser(String name) throws SQLException {
        executor.execUpdate("insert into users (user_name) values ('" + name + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("DROP TABLE users");
    }

}
