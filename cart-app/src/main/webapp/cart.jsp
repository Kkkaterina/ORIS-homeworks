<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<html>
<head>
    <title>Ваша Корзина</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        table {
            border-collapse: collapse;
            width: 60%;
            margin: 0 auto 20px auto;
            box-shadow: 2px 2px 8px #ddd;
        }
        th, td {
            border: 1px solid #999;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
            margin-top: 10px;
        }
        .button:hover {
            background-color: #45a049;
        }
        .status {
            text-align: center;
            margin: 15px 0;
            color: green;
            font-weight: bold;
            font-size: 16px;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            background-color: #008CBA;
            color: white;
            padding: 8px 16px;
            border-radius: 5px;
            width: 150px;
            margin-left: auto;
            margin-right: auto;
        }
        .back-link:hover {
            background-color: #007B9E;
        }
    </style>
</head>
<body>

<h1>Ваша Корзина</h1>

<%
    String status = (String) session.getAttribute("orderStatus");
    if (status != null) {
%>
    <div class="status"><%= status %></div>
<%
        session.removeAttribute("orderStatus");
    }

    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
%>
    <p style="text-align: center;">Корзина пуста.</p>
<%
    } else {
%>
    <table>
        <tr>
            <th>Товар</th>
            <th>Цена (₽)</th>
        </tr>
    <%
        for (Product p : cart) {
    %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
        </tr>
    <%
        }
    %>
    </table>

    <form action="checkout" method="post" style="text-align: center;">
        <button type="submit" class="button">Сделать заказ</button>
    </form>
<%
    }
%>

<a href="index.jsp" class="back-link">← Вернуться в магазин</a>

</body>
</html>
