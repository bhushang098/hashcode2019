import java.util.ArrayList;

class CommmenFinder
{

    public int findComontags(ArrayList<String> tag1 ,ArrayList<String> tag2)
    {
        int comnotag=0;

        for (String string : tag1) {


         loop1:for(int i = 0;i<tag2.size();i++)
            {
                if(string.equals(tag2.get(i)))
                {
                    comnotag++;
                    break loop1;
                }
               
            }
            
        }
        return comnotag;
    }


}

class Solver{

    public int findfactor(ArrayList<String> tag1, ArrayList<String> tag2)
    {
        int ifact=0;

        int comnotag=0;

        comnotag=new CommmenFinder().findComontags(tag1, tag2);

        int intag1,intag2;
        intag1 = tag1.size()-comnotag;
        intag2 = tag2.size()-comnotag;

        ifact = minimumof(intag1,intag2,comnotag);

        return ifact;
    }

    public int minimumof(int a,int b,int c)
    {

        int min=0;

       if(a<=b&&a<=c)
       {
           min=a;
       }else if(b<=c&& b<=a)
       {
           min = b;
       } else{
           min=c;
       }

        return min;
    }
}