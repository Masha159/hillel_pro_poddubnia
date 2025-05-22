package org.lessons.lesson35.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import org.lessons.lesson35.model.Account;
import org.lessons.lesson35.service.AccountService;

import java.io.IOException;
@WebServlet("/servlet-jsp")
public class AccountViewServlet extends HttpServlet {

    private final AccountService accountService = new AccountService();


    @Override
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    private void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        final Account accountById = accountService.getAccountById(id);
        request.setAttribute("accountRecord", accountById);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/WEB-INF/jsp/account-record.jsp");
        dispatcher.forward(request, response);
    }
}
