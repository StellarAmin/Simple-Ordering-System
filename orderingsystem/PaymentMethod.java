/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package orderingsystem;

/**
 *
 * @author pc
 */
public interface PaymentMethod {
    boolean isEmailValid();    
    boolean isPasswordValid();
    boolean isDateValid();
    String pay(int amount);
}
