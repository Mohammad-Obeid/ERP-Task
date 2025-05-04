package erp.max.inventoryManagement.JsonResponse;

import erp.max.inventoryManagement.dto.ProductDTO;

import java.util.List;

public class ProductResponse {
    private List<ProductDTO> products;
    private int PageNum;
    public long numOfPages;

    public ProductResponse() {
    }

    public ProductResponse(List<ProductDTO> products, int pageNum, long numOfPages) {
        this.products = products;
        this.PageNum = pageNum;
        this.numOfPages=numOfPages;
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

    public long getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(long NumOfPages) {
        this.numOfPages = NumOfPages;
    }
}
