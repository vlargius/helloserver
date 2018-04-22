package accounts;

import jdbc_database.DBException;
import jdbc_database.DBService;
import jdbc_database.datasets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    //private final Map<String, UserProfile> loginProfile;
    private final Map<String, UserProfile> sessionIdProfile;
    private final DBService dbService;

//    public AccountService() {
//        sessionIdProfile = new HashMap<>();
//        loginProfile = new HashMap<>();
//    }

    public AccountService(DBService dbService) {
        sessionIdProfile = new HashMap<>();
        this.dbService = dbService;
    }

    public void addNewUser(UserProfile userProfile){
        dbService.addUser(userProfile);
    }

    public UserProfile getUserByLogin(String login) {
       UserProfile user = null;
        try{
            user = dbService.getUser(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return  user;
    }

    public void addSession (String sessionId, UserProfile profile){
        sessionIdProfile.put(sessionId, profile);
    }

    public UserProfile getUSerBySessionId(String sessionId) {
        return sessionIdProfile.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionIdProfile.remove(sessionId);
    }
}
