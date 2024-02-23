/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orderingsystem;

/**
 *
 * @author pc
 */
import java.util.Date;

public class CreditCard implements PaymentMethod {
    private String cardHolderName;
    private String cardNumber;
    private int cvv;
    private Date expiryDate;
    private int balance = 0;


    public CreditCard(String cardHolderName, String cardNumber, int cvv, Date expiryDate , int balance) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.balance = balance; 
    }
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean isEmailValid() {
        // Implement PlaceHolder
        return false;
    }

    @Override
    public boolean isPasswordValid() {
        // Implement PlaceHolder
        return false;
    }

 
    @Override
    public boolean isDateValid() {
        Date currentDate = new Date();
        return expiryDate.after(currentDate);
    }


    @Override
    public String pay(int amount) {
        if(!isDateValid()) return "Checkout failed, card is expired."; 
        if (balance >= amount) {
            balance -= amount;
            return "Payment successful. Remaining balance: " + balance;
        } else {
            return "Payment failed. Invalid card or insufficient balance.";
        }
    }
}
