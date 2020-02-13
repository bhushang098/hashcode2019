import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class Reader 
{

    public ArrayList<Photo> read() throws Exception
    {

        BufferedReader br = null;

        ArrayList<Photo> photoes = new ArrayList<>();

        try{

            br = new BufferedReader(new FileReader("D:\\PhotoProblem\\d_pet_pictures.txt"));
      
            while(br.ready())
            {


                int no = Integer.parseInt(br.readLine());
        
                for(int i = 0; i<no;i++)
                {
                    String[] line = br.readLine().split(" ");

                    String orientation = line[0];
                    ArrayList<String> tags = new ArrayList<>();
                    ArrayList<Integer> id = new ArrayList<>();
                    id.add(i);

                    int m = Integer.parseInt(line[1]);

                    for(int j = 2;j<line.length;j++)
                    {
                        tags.add(line[j]);
                    }

                    Photo p = new Photo(id, orientation, m, tags);
                    photoes.add(p);

                }
      
      
            }

        }catch(Exception e){

            System.out.println(e.toString());
        }finally{

            if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
        }

       return photoes;
    }


     public Returner seprateHandV(ArrayList<Photo> photo)
    {

        ArrayList<Photo> horPhotoes = new ArrayList<>();
        ArrayList<Photo> verPhotoes = new ArrayList<>();

        for (Photo p : photo) {
          if(p.orientation.equals("H"))
          {
              horPhotoes.add(p);
          }else{
              verPhotoes.add(p);
          }
            
        }


        Returner retval = new Returner();

        retval.horphotoes=horPhotoes;
        retval.vewphotoes=verPhotoes;

        return retval;
    }
}

class Returner
{
   public  ArrayList<Photo> horphotoes = new ArrayList<>();
   public  ArrayList<Photo> vewphotoes = new ArrayList<>();

}

class Merger
{

    public ArrayList<Photo> mergVerticals(ArrayList<Photo> photo)
    {
        ArrayList<Photo> mergedPhotoes = new ArrayList<>();
        int i;
        //System.out.println(photo.size());



       while(photo.size()>8)
       {

        if(photo.size()>0){

          iLoop: for( i = 0; i<photo.size();i++)
           {
                for(int j = i+1;j<photo.size();j++)
               {
                   ArrayList<String> tags1= photo.get(i).getTags();
                   ArrayList<String> tags2= photo.get(j).getTags();

                   for (String string : tags1) {

                    for(int l = 0;l<tags2.size();l++)
                    {
                        if(string.equalsIgnoreCase(tags2.get(l)))
                        {
                            Set<String> tagset = new TreeSet<String>();

                            tagset.addAll(tags1);
                            tagset.addAll(tags2);

                           // System.out.println(tagset);
                            ArrayList<String> mergedtags = new ArrayList<>();
                            mergedtags.addAll(tagset);

                            ArrayList<Integer> id = new ArrayList<>();
                            id.addAll(photo.get(i).getId());
                            id.addAll(photo.get(j).getId());

                            int noOftag = mergedtags.size();
                            String orientation ="H";

                            Photo p = new Photo(id, orientation, noOftag, mergedtags);
                            mergedPhotoes.add(p);

                            photo.remove(i);
                            photo.remove(j);
                            //System.out.println(photo.size());
                            break iLoop;
                                
                        }else{

                        }
                         
                    }// end of L loop
         
                }

                
               }// end of j loop

           }// end of i loop

        }//end of if statement

        if(photo.size()==1|| photo.size()==2)
        {
            photo.clear();
        }


       }// end of while loop

       //System.out.println("merged =="+mergedPhotoes.size());

        return mergedPhotoes;
    }
}