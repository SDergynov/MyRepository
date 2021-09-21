package alegrova;

public interface Entertainment {
    boolean funny = true;
    default String entertainment(){
        System.out.println("Развлекаться это хорошо");
        return "развлекаться";
    }

    default String getEnt(){
        return "поразвлекаться";
    }
}
