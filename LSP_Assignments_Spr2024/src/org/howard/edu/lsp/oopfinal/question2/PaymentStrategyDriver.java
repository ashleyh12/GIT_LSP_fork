package org.howard.edu.lsp.oopfinal.question2;

//PaymentStrategy.java
interface PaymentStrategy {
 void pay(double amount);
}

//PaymentStrategyDriver.java
public class PaymentStrategyDriver {
 public static void main(String[] args) {
     ShoppingCart cart1 = new ShoppingCart(new CreditCardPayment("1234-5678-9012-3456"));
     cart1.checkout(100.0);

     ShoppingCart cart2 = new ShoppingCart(new PayPalPayment("user@example.com"));
     cart2.checkout(50.0);

     ShoppingCart cart3 = new ShoppingCart(new BitcoinPayment("1AaBbCcDdEeFfGgHh"));
     cart3.checkout(75.0);
 }
}
