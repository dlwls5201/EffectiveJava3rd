package chapter02.item03;

//public 이나 protected 생성자가 없으므로 SingleTon 클래스가 초기화 될 때 만들어진 인스턴스가 전체 시스템에서 하나뿐임이 보장된다.
public class SingleTon1 {

    public static final SingleTon1 INSTANCE = new SingleTon1();

    private int count = 0;

    private SingleTon1() {
        //리플렉션 방어 코드
        count++;
        if(count != 1) {
            throw new IllegalStateException("this object should be singletone");
        }
    }
}
