package erp.max.inventoryManagement.JsonResponse;

import erp.max.inventoryManagement.dto.ProductMovementDTO;
import java.util.List;

public class MoveResponse2 {
    private List<ProductBalance> balances;
    private int pageNum;
    private long NumOfPages;

    public MoveResponse2() {
    }

    public MoveResponse2(List<ProductBalance> balances, int pageNum, long NumOfPages) {
        this.balances = balances;
        this.pageNum = pageNum;
        this.NumOfPages = NumOfPages;
    }



    public List<ProductBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<ProductBalance> balances) {
        this.balances = balances;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getNumOfPages() {
        return NumOfPages;
    }

    public void setNumOfPages(long numOfPages) {
        NumOfPages = numOfPages;
    }
}
