import java.util.ArrayList;

class Photo
{
    ArrayList<Integer> id = new ArrayList<>();
    String orientation;
    int m;
    ArrayList<String> tags;


    public Photo(ArrayList<Integer> id, String orientation, int m, ArrayList<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.m = m;
        this.tags = tags;
    }



    public ArrayList<Integer> getId() {
        return this.id;
    }

    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
       System.out.println(orientation);
       System.out.print("  "+m);
       System.out.print(" "+id);

    for (String tag : tags) {
        System.out.print(" "+tag);
    }
        return super.toString();
    }

}