package dao.interfaces;

import dao.entity.Product;
import dao.entity.ProductCategory;

import java.util.List;

public interface ProductDAO extends ItemDAO<Product> {
List<Product> getByCategory(String category);
}
