package erp.max.inventoryManagement.model;

import jakarta.persistence.*;
@Table
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, name = "product_name")
    private String productName;
    @Column(nullable = false, name = "product_barcode", unique = true)
    private String productBarcode;

    public Product() {
    }

    public Product(String id, String productName, String productBarcode) {
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
