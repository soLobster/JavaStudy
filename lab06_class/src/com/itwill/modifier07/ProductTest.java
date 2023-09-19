package com.itwill.modifier07;


public class ProductTest {

    public static void main(String[] args) {
        // TODO Product 타입 객체를 생성하고, getter/setter 메서드 테스트...
        // info 테스트....
                
        Product product1 = new Product(1111, "키보드", 20_000);
        Product product2 = new Product(1112, "마우스", 10_000);
        Product product3 = new Product(1113, "모니터", 100_000);
        
        System.out.println("product1의 상품명 >> "+product1.getProductName());
        System.out.println("product1의 가격 >> "+product1.getProductPrice());
        System.out.println("product1의 상품코드 >> "+product1.getProductCode());
        System.out.println("============================");
        
        product1.setProductName("리퍼 키보드");
        System.out.println("변경된 product1의 상품명 >> "+product1.getProductName());
        
        product1.setProductPrice(15_000);
        System.out.println("변경된 product1의 가격 >> "+product1.getProductPrice());     
        
        System.out.println("============================");
        
        product1.productInfo();
        product2.productInfo();
        product3.productInfo();
        
    }

}
