package DAO;

import Model.Product;

import java.util.List;

public interface IProductDAO {
    public List<Product>findAllProducts();
    public Product findProductById(int id);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public void insertProduct(Product product);
}
