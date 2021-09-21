package alegrova;

public class Boy extends Human{
    String sex = "Male";

    void boy(){
        System.out.println("Мальчик сам по себе");
    }
    @Override
    public void identify(){
        System.out.println("Не просто человек разумный, а мальчик");
    }
    @Override
    public String doIt(Entertainment entertainment, Human human){
                if(entertainment instanceof Dance){
                    return "Мальчик и танцы (Плохому танцору...)";
        }
      return "мальчик";
    }
}
