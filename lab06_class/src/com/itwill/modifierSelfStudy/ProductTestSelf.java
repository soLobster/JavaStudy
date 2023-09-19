package com.itwill.modifierSelfStudy;

import java.util.Scanner;

public class ProductTestSelf {
    public static void main(String[] args) {
        // TODO Product 타입 객체를 생성하고, getter/setter 메서드 테스트...
        // info 테스트....
        
        Scanner sc = new Scanner(System.in);
        
        ProductSelf product1 = new ProductSelf(1111, "키보드", 20_000);
        ProductSelf product2 = new ProductSelf(1112, "마우스", 10_000);
        ProductSelf product3 = new ProductSelf(1113, "모니터", 100_000);
        ProductSelf product4 = new ProductSelf(1114, null, 0);
        
        System.out.println("product1의 상품명 >> "+product1.getProductName());
        System.out.println("product1의 가격 >> "+product1.getProductPrice());
        System.out.println("product1의 상품코드 >> "+product1.getProductCode());
        System.out.println("============================");
        
        product1.setProductName("리퍼 키보드");
        System.out.println("변경된 product1의 상품명 >> "+product1.getProductName());
        
        product1.setProductPrice(15_000);
        System.out.println("변경된 product1의 가격 >> "+product1.getProductPrice());     
        
        System.out.println("============================");
        
        System.out.print("product4의 상품명을 입력해주세요 >> ");
        String productName = sc.nextLine();
        product4.setProductName(productName);
        System.out.println("product4의 상품명 >> "+product4.getProductName());
        
        System.out.print("product4의 상품 가격을 입력해주세요 >> ");
        int productPrice = Integer.parseInt(sc.nextLine());
        product4.setProductPrice(productPrice);
        System.out.println("product4의 상품 가격 >> "+product4.getProductPrice());
        
        product1.productInfo();
        product2.productInfo();
        product3.productInfo();
        product4.productInfo();
        
        sc.close();
    }

}
