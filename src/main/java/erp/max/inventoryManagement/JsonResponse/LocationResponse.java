package erp.max.inventoryManagement.JsonResponse;

import erp.max.inventoryManagement.dto.LocationDTO;

import java.util.List;

public class LocationResponse {
    private List<LocationDTO> locations;
    private int pageNum;
    int NumOfPages;

    public LocationResponse() {
    }

    public LocationResponse(List<LocationDTO> locations, int pageNum, int NumOfPages) {
        this.locations = locations;
        this.pageNum = pageNum;
        this.NumOfPages= NumOfPages;
    }

    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDTO> locations) {
        this.locations = locations;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumOfPages() {
        return NumOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        NumOfPages = numOfPages;
    }
}
