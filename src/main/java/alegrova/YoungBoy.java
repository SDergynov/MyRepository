package alegrova;

public class YoungBoy extends Boy {
    int age = 20;

    void youngBoy() {
        System.out.println("Мальчик молодой");
    }

    @Override
    public void identify() {
        System.out.println("Мальчик молодой");
    }

    @Override
    public String doIt(Entertainment entertainment, Human human) {
        String response = "мальчик молодой ";
        if (grade instanceof MladshiyLeitenant){
            response = "младший лейтенант " + response;
            if (entertainment instanceof Dance) {
                 entertainment.getEnt();
                response += "все хотят "+entertainment.getEnt()+"с тобой!";
            }
          }
        return response;
    }

}
