package erp.max.inventoryManagement.JsonResponse;

import erp.max.inventoryManagement.dto.ProductMovementDTO;

import java.util.List;

public class MovesResponse {
    private List<ProductMovementDTO> moves;
    private int pageNum;

    public MovesResponse() {
    }

    public MovesResponse(List<ProductMovementDTO> moves, int pageNum) {
        this.moves = moves;
        this.pageNum = pageNum;
    }

    public List<ProductMovementDTO> getMoves() {
        return moves;
    }

    public void setMoves(List<ProductMovementDTO> moves) {
        this.moves = moves;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
