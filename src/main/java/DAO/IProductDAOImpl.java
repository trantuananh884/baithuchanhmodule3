package DAO;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProductDAOImpl implements IProductDAO {
    private String url = "jdbc:mysql://localhost:3306/demo";
    private String user ="root";
    private String pass ="Tony211119";
    private String FIND_CATEGORYID = "Select categoryid from category where categoryname =?;";
    private String FIND_ALL_PRODUCTS = "Select * from product join category on product.categoryid = category.categoryid;";
    private String FIND_PRODUCT_BY_ID ="Select * from product join category on product.categoryid = category.categoryid where id = ?:";
    private String UPDATE_PRODUCT = "update product set id =?, name =?, price = ?, quant =?, color = ?, description = ?, categoryid = ? where id = ?;";
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public int findCategoryId(String category){
        Connection connection = getConnection();
        int categoryid = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CATEGORYID);
            preparedStatement.setString(1,category);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                categoryid = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  categoryid;
    }
    @Override
    public List<Product> findAllProducts() {
        List<Product>productList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_PRODUCTS);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int price = rs.getInt(3);
            int quant = rs.getInt(4);
            String color = rs.getString(5);
            String desc = rs.getString(6);
            String category = rs.getString(8);
            productList.add(new Product(id,name,price,quant,color,desc,category));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findProductById(int id) {
        Connection connection = getConnection();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int quant = rs.getInt(4);
                String color = rs.getString(5);
                String desc = rs.getString(6);
                String category = rs.getString(8);
                product = new Product(id,name,price,quant,color,desc,category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
        }

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public void insertProduct(Product product) {

    }
}
