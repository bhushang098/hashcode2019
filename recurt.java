import java.util.ArrayList;
import java.util.Collections;

class Recrndemo
{

    public static void main(String[] args) {
        ArrayList<Integer> intlist = new ArrayList<>();

        intlist.add(12);
        intlist.add(9);
        intlist.add(22);
        intlist.add(6);
        intlist.add(17);

        for(int i = 0;i<intlist.size();i++)
        {
            System.out.println(Collections.max(intlist));

            System.out.println(intlist.indexOf(Collections.max(intlist)));

            intlist.remove(i);
    
        }
        
       
    }

    
}