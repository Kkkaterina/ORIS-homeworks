<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<html>
<head>
    <title>Магазин</title>
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
        .products-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }
        .product {
            border: 1px solid #ccc;
            padding: 15px;
            width: 200px;
            text-align: center;
            border-radius: 8px;
            box-shadow: 2px 2px 8px #ddd;
            transition: transform 0.2s;
        }
        .product:hover {
            transform: translateY(-3px);
            box-shadow: 4px 4px 12px #ccc;
        }
        .product p {
            margin: 5px 0;
        }
        .button {
            background-color: #008CBA;
            color: white;
            padding: 8px 16px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #007B9E;
        }
        .cart-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            width: 180px;
            margin-left: auto;
            margin-right: auto;
        }
        .cart-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Магазин одежды</h1>

<div class="products-container">
<%
    List<Product> products = model.ProductRepository.getAll();
    for (Product p : products) {
%>
    <div class="product">
        <form action="cart" method="post">
            <input type="hidden" name="id" value="<%= p.getId() %>">
            <p><strong><%= p.getName() %></strong></p>
            <p><%= p.getPrice() %> ₽</p>
            <button type="submit" class="button">Добавить в корзину</button>
        </form>
    </div>
<%
    }
%>
</div>

<a href="cart" class="cart-link">Перейти в корзину →</a>

</body>
</html>
