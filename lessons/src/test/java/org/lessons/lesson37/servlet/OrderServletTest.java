package org.lessons.lesson37.servlet;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lessons.lesson37.model.Order;
import org.lessons.lesson37.repository.OrderRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import static org.mockito.Mockito.*;

public class OrderServletTest {
    private OrderServlet orderServlet;
    private OrderRepository orderRepository;
    private Gson gson;

    @BeforeEach
    public void setup() {
        gson = new Gson();
        orderRepository = mock(OrderRepository.class);
        orderServlet = new OrderServlet();

        orderServlet.setOrderRepository(orderRepository);
        orderServlet.setGson(gson);
    }

    @Test
    public void testDoPost_createsOrder() throws IOException {
        Order order = new Order();
        order.setId(1);
        order.setCost(50.0);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        BufferedReader reader = new BufferedReader(new StringReader(gson.toJson(order)));
        when(req.getReader()).thenReturn(reader);

        orderServlet.doPost(req, resp);

        verify(orderRepository, times(1)).creatOrder(any(Order.class));
    }

    @Test
    public void testDoGet_returnsOrder() throws IOException {
        Order order = new Order();
        order.setId(1);
        order.setCost(100.0);

        when(orderRepository.getOrderById(1)).thenReturn(order);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(req.getParameter("id")).thenReturn("1");
        when(resp.getWriter()).thenReturn(writer);

        orderServlet.doGet(req, resp);

        verify(writer).println(gson.toJson(order));
    }


    @Test
    public void testDoPut_updatesOrder() throws IOException {
        Order order = new Order();
        order.setId(1);
        order.setCost(120);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(req.getParameter("id")).thenReturn("1");
        when(req.getReader()).thenReturn(new BufferedReader(new StringReader(gson.toJson(order))));
        when(resp.getWriter()).thenReturn(writer);

        orderServlet.doPut(req, resp);

        verify(orderRepository).updateOrder(any(Order.class));
    }

    @Test
    public void testDoDelete_deletesOrder() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = mock(PrintWriter.class);

        when(req.getParameter("id")).thenReturn("1");
        when(resp.getWriter()).thenReturn(writer);

        orderServlet.doDelete(req, resp);

        verify(orderRepository).deleteOrder(1);
        verify(resp).setStatus(204);
    }
}
