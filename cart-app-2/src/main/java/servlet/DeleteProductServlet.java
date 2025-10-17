package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.ProductRepository;

import java.io.IOException;

@WebServlet("/admin/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ProductRepository.deleteById(id);
        response.sendRedirect("index.jsp");
    }
}