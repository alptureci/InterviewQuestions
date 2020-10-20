package LunarLander.src.edu.itu.swe680.lander_95583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetBurnRate{
    public static void main(String[] args){
        //Send welcome message
        System.out.println("#Welcome to Lunar Lander");

        try{
            // Begin reading from System input
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

            //Set initial burn rate to 0
            int burnRate = 0;

            do {
                //promt user
                System.out.println("#Enter burn rate or <0 to quit:");

                //Read user input
                try {
                    String burnRateString = inputReader.readLine();
                    burnRate = Integer.parseInt(burnRateString);

                    //Send user-supplied burn rate to next filter
                    System.out.println("%" + burnRate);

                } catch (NumberFormatException nfe){
                    System.out.println("#Invalid burn rate.");
                }
            } while (burnRate >= 0);
            inputReader.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
