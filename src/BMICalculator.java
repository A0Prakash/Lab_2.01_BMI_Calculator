import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * BMI Calculator
 * Calculates the body mass index of input given by user
 * @author 26prakash
 * @version 11.14.2022
 */

public class BMICalculator {

    /**
     *  Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data
     * @param inches user's height(in)
     * @param pounds user's weight(lbs)
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds <= 0) {
            return 0.0;
        }

        double kgs, meters;
        meters = inches * 0.0254;
        kgs = pounds* 0.454;
        return kgs/Math.pow(meters, 2);
    }

    /**
     * Main method of the BMICalculator class
     * Uses a Scanner to prompt the user for info, process the
     * feet/inches conversion, calls the computeBMI method and prints the
     * correct information.
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userin = new String();
        int inches;
        int pounds;
        DecimalFormat df = new DecimalFormat("0.00");
        while(true) {
            try{
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or 0 to quit: ");
                userin = in.nextLine();
                if(userin.equals("0"))
                   break;


                 inches = Integer.parseInt(userin.substring(0, userin.indexOf("'")))*12;
                 inches += Integer.parseInt(userin.substring(userin.indexOf("'")+1, userin.length()-1));
                System.out.print("Enter your weight in pounds: ");
                pounds = Integer.parseInt(in.nextLine());

                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, pounds)) + " kg/m^2");
            }
            catch(Exception e) {
                System.out.println("There was an error: " + e.toString());
            }



        }
    }
}
