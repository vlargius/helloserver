package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private final AccountService accountService;

    public SignUpServlet(AccountService accountService){
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {

    }

    public  void doPost(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserProfile foundProfile = accountService.getUserByLogin(login);

        if(foundProfile == null || !foundProfile.getLogin().equals(login)) {
            UserProfile profile = new UserProfile(login, password);
            accountService.addNewUser(profile);
            accountService.addSession(request.getSession().getId(), profile);
            response.getWriter().println("new user:" + profile.getLogin());
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("such user has already been signed up!");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
