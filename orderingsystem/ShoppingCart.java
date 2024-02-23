/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderingsystem;


public class ShoppingCart {
    private static final int MAX_ITEMS = 10;
    private Item[] orderItems;
    private int itemCount;

  
    public ShoppingCart() {
        this.orderItems = new Item[MAX_ITEMS];
        this.itemCount = 0;
    }

    
    public void add(Item item) {
        if (itemCount < MAX_ITEMS) {
            orderItems[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("The shopping cart is full. Cannot add more items.");
        }
    }

    
    public void remove(Item item) {
        for (int i = 0; i < itemCount; i++) {
            if (orderItems[i].equals(item)) {
                
                for (int j = i; j < itemCount - 1; j++) {
                    orderItems[j] = orderItems[j + 1];
                }
                orderItems[itemCount - 1] = null; 
                itemCount--;
                return; 
            }
        }
        System.out.println("Item not found in the shopping cart.");
    }

    
    public double getTotalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += orderItems[i].getQuantity() * orderItems[i].getPrice();
        }
        return totalAmount;
    }

    
    public String checkout(PaymentMethod paymentMethod) {
        double totalAmount = getTotalAmount();
        return paymentMethod.pay((int) totalAmount);
    
    }
}

