package erp.max.inventoryManagement.JsonResponse;

import erp.max.inventoryManagement.dto.ProductDTO;

import java.util.List;

public class ProductResponse {
    private List<ProductDTO> products;
    private int PageNum;

    public ProductResponse() {
    }

    public ProductResponse(List<ProductDTO> products, int pageNum) {
        this.products = products;
        PageNum = pageNum;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

}
