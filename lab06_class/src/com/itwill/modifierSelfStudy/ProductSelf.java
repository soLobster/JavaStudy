package com.itwill.modifierSelfStudy;

public class ProductSelf {
    //필드....
    //쇼핑몰.....
    private int productCode; //상품 코드...(읽기 전용)
    private String productName; //상품 이름...(읽/쓰 둘 다)
    private int productPrice; //상품 가격...(읽/쓰 둘 다)
    
    public ProductSelf(int productCode, String productName, int productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    
    
    //getter/setter
    
    public int getProductCode() {
        return this.productCode;
    }//getter.....
    
    public String getProductName() {
        return this.productName;
    }//getter.....
    
    public void setProductName(String productName) {
        this.productName = productName;
    }//setter.....
    
    public int getProductPrice() {
        return this.productPrice;
    }//getter....
    
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }//setter.....
    
    //상품 정보를 출력하는 메서드.....
    public void productInfo() {
        System.out.println("----상품안내----");
        System.out.println("상품 이름 >> "+this.productName);
        System.out.println("상품 코드 >> "+this.productCode);
        System.out.println("상품 가격 >> "+this.productPrice);
    }
}
