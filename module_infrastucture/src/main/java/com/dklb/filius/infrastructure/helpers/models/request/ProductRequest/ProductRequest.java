package com.dklb.filius.infrastructure.helpers.models.request.ProductRequest;


public class ProductRequest {
    private String businessId;
    private String name;
    private Long price;
    private String category;
    private Long stock;
    private Long stockMin;
    private Boolean compound;
    private String extent;
    private String userMaker;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStockMin() {
        return stockMin;
    }

    public void setStockMin(Long stockMin) {
        this.stockMin = stockMin;
    }

    public Boolean getCompound() {
        return compound;
    }

    public void setCompound(Boolean compound) {
        this.compound = compound;
    }

    public String getExtent() {
        return extent;
    }

    public void setExtent(String extent) {
        this.extent = extent;
    }

    public String getUserMaker() {
        return userMaker;
    }

    public void setUserMaker(String userMaker) {
        this.userMaker = userMaker;
    }
}
