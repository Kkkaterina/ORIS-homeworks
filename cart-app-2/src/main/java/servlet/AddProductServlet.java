package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;
import model.ProductRepository;

import java.io.IOException;

@WebServlet("/admin/addProduct")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String priceStr = request.getParameter("price");

        if (name != null && priceStr != null && !name.isEmpty()) {
            double price = Double.parseDouble(priceStr);
            int newId = ProductRepository.getAll().size() + 1;
            ProductRepository.add(new Product(newId, name, price));
        }

        response.sendRedirect("index.jsp");
    }
}