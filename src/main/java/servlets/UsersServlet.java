package servlets;

import accounts.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet {

    private final AccountService accountService;

    public UsersServlet(AccountService accountService){
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response){

    }

    public  void doPost(HttpServletRequest request,
                        HttpServletResponse response){

    }

    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) {

    }
}
