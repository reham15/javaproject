/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author elkrnk 1
 */
public class Utils {

    
    public static String transform(String st,StringFunction f)
    {
        return(f.applyFunction(st));
    }
    public static void byebye(String st, StringConsumer f)
    {
        f.consumeFunction(st);
    }
    public static String makeExciting(String s)
    {
        return(s + " ** !!");
    }
    private Utils() {}   
}

    
