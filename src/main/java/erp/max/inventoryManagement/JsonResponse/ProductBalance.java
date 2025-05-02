package erp.max.inventoryManagement.JsonResponse;

public class ProductBalance {
    private String productName;
    private String location;
    private int quantity;

    public ProductBalance() {
    }

    public ProductBalance(String productName, String location, int quantity) {
        this.productName = productName;
        this.location = location;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
