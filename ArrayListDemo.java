import java.util.ArrayList;


public class ArrayListDemo {
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>();

        names.add("Prajwal");
        names.add("Tushar");
        names.add("Nivrutti");
        names.add("Vitthal");

        System.out.println("After adding 4 names: "+names);
        System.out.println("Size: "+names.size());

        names.add(1, "Tushar patil");
        System.out.println("After adding at index 1:" +names);
        System.out.println("Element at index 0: " +names.get(0));

        names.set(0,"Prajwal Dattu Butte");
        System.out.println("Updated value of index 0: "+names);

        names.remove(2);
        System.out.println("After removing element at index 2:" +names);

        names.remove("Vitthal");
        System.out.println("After removing Vitthal"+names);

        System.out.println("Getting First Element: "+names.getFirst());
        System.out.println("Reverse Elements "+names.reversed());


        System.out.println("For each Loop:");
        for(String name : names){
            System.out.println(" "+name);
        }

        System.out.println("Contains Nivrutti? " +names.contains("Nivrutti"));

        System.out.println("Traditinal For Loop");
        for(int i=0;i<names.size();i++){
            System.out.println(" Index "+i+" : "+names.get(i));
        }
    }
    
    
    
}
