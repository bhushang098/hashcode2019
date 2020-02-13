import java.util.ArrayList;
import java.util.Collections;

class Runner
{

    public static void main(String[] args)throws Exception {
        
        int sum =0;
        Reader r = new Reader();
       ArrayList<Photo> photoes =  r.read();

       Returner ret = r.seprateHandV(photoes);

       ArrayList<Photo> horpoto = ret.horphotoes;
       ArrayList<Photo> verPhoto = ret.vewphotoes;

     

      ArrayList<Photo> allHphotoes = new ArrayList<>();

      Merger merg = new Merger();
      allHphotoes = merg.mergVerticals(verPhoto);

      for(int i = 0;i<horpoto.size();i++)
      {
          allHphotoes.add(i+1, horpoto.get(i));       
      }


      ArrayList<Photo> finalList = new ArrayList<>();
      int indexofMAx =0;

      

      //System.out.println(allHphotoes.size());

     // System.out.println(finalList.size());
      


    while(allHphotoes.size()>0)
    {

        ArrayList<Integer> maxele = new ArrayList<>();

        Photo p = new Photo(allHphotoes.get(indexofMAx).getId(),allHphotoes.get(indexofMAx).getOrientation(),allHphotoes.get(indexofMAx).getM(),
                            allHphotoes.get(indexofMAx).getTags());

                            allHphotoes.remove(indexofMAx);

                            finalList.add(p);

            for(int j = 0;j<allHphotoes.size();j++)
            {
                int factor;
                Solver s = new Solver();
               factor =  s.findfactor(p.getTags(), allHphotoes.get(j).getTags());
               maxele.add(factor);

            }
           

            int maxno=0;

            if(maxele.size()>0){

                System.out.println("Max element "+maxele.size());

                //System.out.println("max list size ="+maxele.size());
                maxno  = Collections.max(maxele);
                indexofMAx = maxele.indexOf(maxno);
            
                finalList.add(allHphotoes.get(indexofMAx));
                sum = sum + Collections.max(maxele);


            }
                   
           //System.out.println(indexofMAx);
        
    }

    System.out.println("Score  ="+sum);

    }
}