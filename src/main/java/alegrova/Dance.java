package alegrova;

public class Dance implements Entertainment {
    boolean active = true;

    public String entertiment() {
        System.out.println("Танцы, у клубе будут танци!!!");
        return "потанцевать";
    }

    public String getEnt(){
        return "потанцевать ";
    }
}
