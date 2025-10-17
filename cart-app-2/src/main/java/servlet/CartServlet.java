package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;
import model.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        if (idParam == null) {
            response.sendRedirect("cart");
            return;
        }

        int id = Integer.parseInt(idParam);

        HttpSession session = request.getSession();
        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(id);
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
}