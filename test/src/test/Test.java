/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

interface StringFunction
{
    String applyFunction(String s);
}

@FunctionalInterface
interface StringConsumer
{
    void consumeFunction(String s);
}

class test
{
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
    private test() {}   
}

class RefMethodEx2
{
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