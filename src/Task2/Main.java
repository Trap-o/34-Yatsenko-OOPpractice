package Task2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Trap
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private Calc calc = new Calc();
    Scanner scan = new Scanner(System.in);
    private void menu(){
            String s = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            do{
                do{
                    System.out.println("\nEnter command");
                    System.out.print("'i'nput, 'v'iew, 's'ave, 'r'estore, 'q'uit: ");
                    try{
                        s = in.readLine();
                    } catch(IOException e){
                        System.out.println("Error " + e);
                        System.exit(0);
                    }
                }while (s.length() != 1);
                switch (s.charAt(0)){
                    case 'v' -> {
                        System.out.println("\nView current.");
                        calc.show();
                    }
                    case 'i' -> {
                        System.out.println("\nInput values.");
                        System.out.println("Number of primary cells: ");
                        int pc = scan.nextInt();
                        System.out.println("Number of cycles: ");
                        int cyc = scan.nextInt();
                        calc.init(pc, cyc);
                        calc.show();
                    }
                    case 's' -> {
                        System.out.println("\nSave current.");
                        try{
                            calc.save();
                        } catch(IOException e){
                            System.out.println("Serialization error " + e);
                        }
                        calc.show();
                    }
                    case 'r' -> {
                        System.out.println("\nRestore last saved.");
                        try{
                            calc.restore();
                        } catch(Exception e){
                            System.out.println("Serialization error " + e);
                        }
                        calc.show();
                    }
                    case 'q' -> System.out.println("\nExit...");
                    default -> System.out.println("Wrong command.");
                }
            }while(s.charAt(0) != 'q');
    }

    
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}