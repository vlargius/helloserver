package orm_database.dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable {
    //private static final long serialVectionUID = ;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name", unique = true, updatable = false)
    private String name;

    public UsersDataSet() {
    }

}

