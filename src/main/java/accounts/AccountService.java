package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> loginProfile;
    private final Map<String, UserProfile> sessionIdProfile;

    public AccountService() {
        loginProfile = new HashMap<>();
        sessionIdProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile){
        loginProfile.put(userProfile.getLogin(), userProfile);
    }

    public void addSession (String sessionId, UserProfile profile){
        sessionIdProfile.put(sessionId, profile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginProfile.get(login);
    }

    public UserProfile getUSerBySessionId(String sessionId) {
        return sessionIdProfile.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionIdProfile.remove(sessionId);
    }
}
