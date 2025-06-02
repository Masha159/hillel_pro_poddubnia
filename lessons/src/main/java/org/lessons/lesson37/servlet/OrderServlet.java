package org.lessons.lesson37.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lessons.lesson35.model.Account;
import org.lessons.lesson35.service.AccountService;
import org.lessons.lesson37.model.Order;
import org.lessons.lesson37.repository.OrderRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "orderTest", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {

    private Gson gson = new Gson();
    private OrderRepository orderRepository = new OrderRepository();

    protected void setGson(Gson gson) {
        this.gson = gson;
    }

    protected void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("POST");
        final Order order = gson.fromJson(req.getReader(), Order.class);
        orderRepository.creatOrder(order);
        System.out.println(order);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final String id = req.getParameter("id");
            if (id != null) {
                Order r = orderRepository.getOrderById(Integer.parseInt(id));
                writer.println(gson.toJson(r));
            } else {
                resp.setStatus(404);
                writer.println("Account not found!");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()) {
            final String id = req.getParameter("id");
            if (id != null) {
                orderRepository.deleteOrder(Integer.parseInt(id));
                resp.setStatus(204);
            } else {
                resp.setStatus(404);
                writer.println("Account not found!");
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter writer = resp.getWriter()){
            final String id = req.getParameter("id");
            if (id != null){
                final Order order = gson.fromJson(req.getReader(), Order.class);
                orderRepository.updateOrder(order);
            }
            else {
                resp.setStatus(404);
                writer.println("Account not found!");
            }


        }
    }
}