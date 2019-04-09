package chapter02.item03;

public enum SingleTon2 {

    INSTANCE;

    //enum 또한 프로퍼티 및 메서드를 가질 수 있다.
    public String getName() {
        return "BlackJin";
    }
}
