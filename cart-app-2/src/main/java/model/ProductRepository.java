package model;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Футболка", 25.0));
        products.add(new Product(2, "Джинсы", 40.0));
        products.add(new Product(3, "Куртка", 60.0));
    }

    public static Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Product> getAll() {
        return products;
    }

    public static void add(Product product) {
        products.add(product);
    }

    public static void update(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == updatedProduct.getId()) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    public static void deleteById(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}

