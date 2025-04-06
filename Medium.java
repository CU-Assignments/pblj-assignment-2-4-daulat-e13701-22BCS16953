 package Project1;
 java.sql.*;
 import
 import
 java.util.Scanner; public class
 Medium7JDBC {
 public static void main(String[] args) {
 String url = "jdbc:mysql://localhost:3306/shivanidb";
 String user = "root";
 String password = "Shivani@1234";
 Scanner(System.in);
 Scanner sc = new
 try (Connection conn =
 DriverManager.getConnection(url, user, password)) {
 (true) {
 while
 System.out.println("\n1. Add Product 2. View Products
 3. Update Price 4. Delete Product 5. Exit");
 int choice = sc.nextInt();
 if (choice == 1)
 addProduct(conn, sc);
 viewProducts(conn);
 updateProduct(conn, sc);
 deleteProduct(conn, sc);
 break;
 else if (choice == 2)
 else if (choice == 3)
 else if (choice == 4)
 else if (choice == 5)
 else System.out.println("Invalid choice.");
 }
 } catch (SQLException e)
 {
 e.printStackTrace();}}
 static void
 addProduct(Connection conn, Scanner sc) throws
 SQLException {
 System.out.print("Enter Product Name: ");
 sc.nextLine();
String name = sc.nextLine();
 System.out.print("Enter Price: ");
 price = sc.nextDouble();
 System.out.print("Enter Quantity: ");
 quantity = sc.nextInt();
 double
 int
 PreparedStatement stmt = conn.prepareStatement("INSERT INTO
 Product (ProductName, Price, Quantity) VALUES (?, ?, ?)");
 stmt.setString(1, name);
 stmt.setDouble(2, price);
 stmt.setInt(3, quantity);
 stmt.executeUpdate();
 System.out.println("Product added.");
 }
 static void viewProducts(Connection conn) throws SQLException {
 ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM
 Product");
 System.out.println("\nProductID | Product Name | Price |
 Quantity");
 while (rs.next()) {
 System.out.printf("%d | %s | %.2f | %d\n", rs.getInt(1),
 rs.getString(2), rs.getDouble(3), rs.getInt(4));
 }
 }
 static void updateProduct(Connection conn, Scanner sc) throws
 SQLException {
 System.out.print("Enter ProductID to update: ");
 int id = sc.nextInt();
 System.out.print("Enter new Price: ");
 double price = sc.nextDouble();
 PreparedStatement stmt = conn.prepareStatement("UPDATE Product
 SET Price=? WHERE ProductID=?");
 stmt.setDouble(1, price);
 stmt.setInt(2, id);
 stmt.executeUpdate();
 System.out.println("Product updated.");
 }
 static void deleteProduct(Connection conn, Scanner sc) throws
 SQLException {
 System.out.print("Enter ProductID to delete: ");
 int id = sc.nextInt();
 PreparedStatement stmt = conn.prepareStatement("DELETE FROM
 Product WHERE ProductID=?");
 stmt.setInt(1, id);
 stmt.executeUpdate();
 System.out.println("Product deleted.");
 }}
