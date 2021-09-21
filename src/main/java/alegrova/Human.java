package alegrova;

public class Human {
    int age;
    protected Leitenant grade;

    public void identify(){
        System.out.println("Просто человек разумный.");
    }

    public String doIt(Entertainment entertainment, Human human){
        if(entertainment instanceof Dance){
            System.out.println("Человек и танцы");
        }
        return "человек";
    }
}
