import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if (getal<=0){throw new IllegalArgumentException();}
        if (getal<=2){return 1;}
        else return fibonacci(getal-1)+fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        if (getal/10==0) {return Math.abs(getal);}
        else return Math.abs(getal%10) + somVanCijfers(Math.abs(getal/10));

    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s==null)throw new IllegalArgumentException();
        if(s.length()<=1) return s;
        else return s.charAt(s.length()-1)+keerOm(s.substring(0, s.length()-1));


    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.length() == 0){return 0;}
        if(s.charAt(0) == 'x'){return 1+ countX(s.substring(1));}
        else return countX(s.substring(1));
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.length() == 0){return 0;}
        if(s.charAt(0) == 'h' && s.charAt(1) == 'i' ){return 1+ countHi(s.substring(1));}
        else return countHi(s.substring(1));    }

    // oefening 6
    public static String changeXY(String s) {

        if(s==null) throw new IllegalArgumentException();
        if(s.length() == 0){return s;}
        if(s.charAt(0) == 'x'){return 'y'+changeXY(s.substring(1));}
        else return s.charAt(0)+ changeXY(s.substring(1));    }

    // oefening 7

    public static String changePi(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.length() <= 2){return s;}
        if(s.substring(0,2).equals("pi")){return"3.14"+changePi(s.substring(2));}
        else return s.charAt(0)+ changePi(s.substring(1));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal <=0) throw new IllegalArgumentException();
        if (getal ==1) return 0;
        return 1+ tweelog(getal/2);

    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst ==null ||lijst.size()==0){throw new IllegalArgumentException();}
        else if (lijst.size() == 1)
            return lijst.get(0);
        else {
            double g = findMaximum(lijst.subList(1, lijst.size()));
            if (lijst.get(0) > g)
                return lijst.get(0);
            else
                return g;
        }
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static void main(String[] args) {
        int tien = 1024;
        tweelog(1024);
        ;


    }

}
