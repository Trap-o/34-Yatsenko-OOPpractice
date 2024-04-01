/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Task1;

/**
 *
 * @author Trap
 */
public class oopTask1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] arrayOfMilitaryVehicle = new String[100000];
        final String americanUnluckyNumber = "13";
        final String chinaUnluckyNumber = "4";
        int numberOfUnluckyVehicle = 0;

        for (int i = 0; i < arrayOfMilitaryVehicle.length; i++) {
            arrayOfMilitaryVehicle[i] = String.format("%05d", i);
            if (arrayOfMilitaryVehicle[i].contains(americanUnluckyNumber)
                    || arrayOfMilitaryVehicle[i].contains(chinaUnluckyNumber)) {
                numberOfUnluckyVehicle++;
            }
        }
    
        System.out.println(numberOfUnluckyVehicle);
    }
}