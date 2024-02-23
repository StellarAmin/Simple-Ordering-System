
package orderingsystem;



public class PayPal implements PaymentMethod {
    private String email;
    private String password;
    private int balance = 0;


    public PayPal(String email, String password , int balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;  
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

   
    @Override
    public boolean isEmailValid() {
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        boolean validity = email.matches(emailRegex);

        return validity;
    }

        @Override
    public boolean isPasswordValid() {
                    
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        boolean validity = password.matches(passwordRegex);

        return validity;
    }

    @Override
    public boolean isDateValid() {
        // Implement PlaceHolder
        return false;
    }
    
    @Override
    public String pay(int amount) {
        if(!isEmailValid()) return "Checkout failed, email format is incorrect."; 
        if(!isPasswordValid()) return "Checkout failed, password format is incorrect."; 

        if (balance >= amount) {
            balance -= amount;
            return "Payment successful. Remaining balance: " + balance;
        } else {
            return "Payment failed. Invalid account or insufficient balance.";
        }
    }
}
