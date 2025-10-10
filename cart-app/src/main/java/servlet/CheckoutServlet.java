package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            String filePath = getServletContext().getRealPath("/orders.txt");

            try (FileWriter writer = new FileWriter(filePath, true)) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                writer.write("Новый заказ: " + date + "\n");
                for (Product p : cart) {
                    writer.write(p.getName() + " — " + p.getPrice() + "€\n");
                }
                writer.write("------\n");
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("message", "Ошибка при сохранении заказа!");
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                return;
            }

            session.removeAttribute("cart");
            session.setAttribute("orderStatus", "Заказ успешно оформлен!");
        } else {
            session.setAttribute("orderStatus", "Корзина пуста.");
        }
        response.sendRedirect("cart");
    }
}
