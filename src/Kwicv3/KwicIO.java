package Kwicv3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class KwicIO {

    /**
     * @param args the command line arguments
     */
    
    private static String in(){
        Scanner s = new Scanner(System.in);
        
        return s.nextLine();
        
    }
    
    private static void out(ArrayList<String> kwic){
        for( int i = 0; i < kwic.size(); i++){
            System.out.println(kwic.get(i));
        }
    }
    
    public static void main(String[] args) {
        String in_sentence = in();
        Sentence s = new Sentence(in_sentence);
        ArrayList<String> kwic = s.getSentences();
        out(kwic);
    }
}
