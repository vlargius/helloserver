package jdbc_database.datasets;

@SuppressWarnings("UnusedDeclaration")
public class UsersDataSet {
    private long id;
    private String name;

    public UsersDataSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }

    public long getId() { return id; }

    @Override
    public String toString(){
      return "UserDataset{" +
        "id=" + id +
        ", name='" + name + "\'" +
              "}";
    }
}
