package chapter02.item03;

public class SingleTon1 {

    private static final SingleTon1 INSTANCE = new SingleTon1();

    //public 이나 protected 생성자가 없으므로 SingleTon1 클래스가 초기화 될 때
    //만들어진 인스턴스가 전체 시스템에서 하나뿐임이 보장된다.
    private SingleTon1() {

    }

    public static SingleTon1 getInstance() { return INSTANCE; }

    public void leaveTheBuilding() {}
}
