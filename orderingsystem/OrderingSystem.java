package orderingsystem;

import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderingSystem {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        boolean checkout = false;
        int itemNumber, itemQuantity;
        String itemName;
        Double itemPrice;

        while (!checkout) {
            
            String input = JOptionPane.showInputDialog(null, "Please, select a product:\n" +
                    "1- IPhone X, $600\n" +
                    "2- Galaxy S23, $1000\n" +
                    "3- IPhone 14 Pro, $1500\n" +
                    "4- ASUS ROG, $1200\n");

            
            itemNumber = Integer.parseInt(input);
            itemQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity:"));
            
            switch(itemNumber) {
                case 1:
                    itemName = "IPhone X";
                    itemPrice = 600.0;
                    break;
                case 2:
                    itemName = "Galaxy S23";
                    itemPrice = 1000.0;
                    break;
                case 3:
                    itemName = "IPhone 14 Pro";
                    itemPrice = 1500.0;
                    break;
                case 4:
                    itemName = "ASUS ROG";
                    itemPrice = 1200.0;
                    break;
                default:
                    itemName = "No Item Selected";
                    itemPrice = 0.0;      
                    break;
            }

            Item newItem = new Item(itemName, itemQuantity, itemPrice);
            shoppingCart.add(newItem);

            
            int proceedChoice = JOptionPane.showConfirmDialog(null, "Proceed to checkout? (Y/N)");
            if (proceedChoice == JOptionPane.NO_OPTION) {
                continue;
            } 
            else if (proceedChoice == JOptionPane.YES_OPTION) {
                checkout = true;
            }
        }

        
        String paymentMethodChoice = JOptionPane.showInputDialog("Choose payment method:\n1. PayPal\n2. Credit Card");

        if (paymentMethodChoice != null) {
            PaymentMethod paymentMethod;

            
            if (paymentMethodChoice.equals("1")) {
                String email = JOptionPane.showInputDialog("Enter PayPal email:");
                String password = JOptionPane.showInputDialog("Enter PayPal password:");
                int balance = Integer.parseInt(JOptionPane.showInputDialog("Enter balance"));
                paymentMethod = new PayPal(email, password, balance);
            } else if (paymentMethodChoice.equals("2")) {
                String cardHolderName = JOptionPane.showInputDialog("Enter cardholder name:");
                String cardNumber = JOptionPane.showInputDialog("Enter card number:");
                int cvv = Integer.parseInt(JOptionPane.showInputDialog("Enter CVV:"));
                String expiryDateStr = JOptionPane.showInputDialog("Enter expiry date (MM/yyyy):");
                int balance = Integer.parseInt(JOptionPane.showInputDialog("Enter balance"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
                Date expiryDate = null;
                try {
                    expiryDate = dateFormat.parse(expiryDateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                paymentMethod = new CreditCard(cardHolderName, cardNumber, cvv, expiryDate , balance);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Exiting.");
                return;
            }

            
            String checkoutResult = shoppingCart.checkout(paymentMethod);
            JOptionPane.showMessageDialog(null, checkoutResult);
        }
    }
    
}

