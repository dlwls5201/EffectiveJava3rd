package chapter02.item03;

import java.util.function.Supplier;

//public 이나 protected 생성자가 없으므로 SingleTon 클래스가 초기화 될 때 만들어진 인스턴스가 전체 시스템에서 하나뿐임이 보장된다.
public class SingleTon2 {

    private static final transient SingleTon2 INSTANCE = new SingleTon2();

    private SingleTon2() {

    }

    public static SingleTon2 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {

        //getInstance 에 대한 레퍼런스를 Supplier 타입으로 만들 수 있다.
        Supplier<SingleTon2> s2Supplier = SingleTon2::getInstance;
    }
}
