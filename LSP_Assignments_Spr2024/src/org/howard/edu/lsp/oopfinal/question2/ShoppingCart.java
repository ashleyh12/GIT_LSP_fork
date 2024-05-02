package org.howard.edu.lsp.oopfinal.question2;

//ShoppingCart.java
public class ShoppingCart {
private PaymentStrategy paymentStrategy;

public ShoppingCart(PaymentStrategy paymentStrategy) {
   this.paymentStrategy = paymentStrategy;
}

public void checkout(double amount) {
   paymentStrategy.pay(amount);
}
}