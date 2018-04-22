package orm_database;

import jdbc_database.datasets.UsersDataSet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DBService {
    private static final String hibernate_show_sql = "true";
    private static final String hibernalte_hbm2ddl_auto = "create";

//    private final SessionFactory sessionFactory;

//    public DBService() {
//        Configuration configuration = getMySqlConfiguration();
//        sessionFactory = createSessionFactory();
//    }
//
//    private Configuration getMySqlConfiguration() {
//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(UsersDataSet.class);
//
//
//    }
//
//    private static SessionFactory createSessionFactory() {
//
//    }
}
