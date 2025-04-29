package erp.max.inventoryManagement.dto;

import jakarta.persistence.Column;

public class ProductDTO {
    private String id;
    private String productName;
    private String productBarcode;

    public ProductDTO() {
    }

    public ProductDTO(String id, String productName, String productBarcode) {
        this.id = id;
        this.productName = productName;
        this.productBarcode = productBarcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }
}
