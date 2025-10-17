package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;
import model.ProductRepository;

import java.io.IOException;

@WebServlet("/admin/editProduct")
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        ProductRepository.update(new Product(id, name, price));
        response.sendRedirect("index.jsp");
    }
}