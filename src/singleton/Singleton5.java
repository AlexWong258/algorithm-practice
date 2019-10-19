package singleton;

public class Singleton5 {
    private Singleton5(){}

    private static class SingleTonHoler {
        private static Singleton5 singleton = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SingleTonHoler.singleton;
    }
}
