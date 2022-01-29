
//import utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elkrnk 1
 */
public class RefMethodEx2 {
    
    public static void main(String[] args) 
    {
        String s = "TestITI";
        // SomeClass::staticMethod
        String result1 = Utils.transform(s, Utils::makeExciting);
        System.out.println("\n1 Static "+result1);
        // someObject::instanceMethod
        String prefix = "Blah @@ ";
        String result2 = Utils.transform(s, prefix::concat); System.out.println("\n 2-object::instance method: " +result2);
        // SomeClass::instanceMethod
        String result3 = Utils.transform(s, String::toUpperCase);
        System.out.println("\n3-Class::instance Method:"+result3);
        // SomeClass::Constructor
        String result4 = Utils.transform("hi -> "+s, String::new);
        System.out.println("\n\n\n4-Class::constructor: "+result4);
    }
    
}
