package erp.max.inventoryManagement.JsonResponse;

public class LocationProductsResponse {
    private String moveId;
    private String productId;
    private String productName;
    private int quantity;

    public LocationProductsResponse() {
    }

    public LocationProductsResponse(String moveId,String productId, String productName, int quantity) {
        this.moveId=moveId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMoveId() {
        return moveId;
    }

    public void setMoveId(String moveId) {
        this.moveId = moveId;
    }
}
