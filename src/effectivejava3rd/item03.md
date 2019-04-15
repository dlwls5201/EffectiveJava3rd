# private 생성자나 열거 타입으로 싱글텀임을 보증하라

싱글턴이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.

***클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다.***
타입을 인터페이스로 정의한 다음 그 인터페이스를 구현해서 만든 실글턴이 아니라면 Mock 구현으로 대체할 수 없기 때문이다.

싱글턴을 만드는 방식은 생성자는 private으로 감춰두고, 유일한 인스턴스에 접근할 수 있는 수단으로 public static 멤버를 하나 마련하는 것이다.

## final 필드 방식의 실글턴

```java
public static final SingleTon INSTANCE = new SingleTon();

private SingleTon() { }
```
private 생성자는 public static final 필드인 SingleTon1.INSTANCE를 초기화할 때 딱 한 번만 호출된다.

초기화할 때 만들어진 인스턴스가 전체 시스템에서 하나뿐임이 보장되지만 에외 단 한가지가 있다. 리플렉션을 사용해 private 생성자를 호출할 수 있다.
이러한 공격을 방어하려면 생성자를 수정하여 두 번째 객체가 생성되려 할 때 예외를 던지게 하면 된다.

```java
private SingleTon1() {
        //리플렉션 방어 코드
        count++;
        if(count != 1) {
            throw new IllegalStateException("this object should be singletone");
        }
    }
```

***장점***
1. 싱글톤임이 API에 명백히 드러난다.

***리플렉션***
객체를 통해 클래스의 정보를 분석해내는 프로그래밍 기법으로 실행중인 자바프로그램 내부를 검사하고 내부의 속성을 수정할 수 있도록 한다


## 정적 팩토리 방식의 싱글턴

```java
private static final SingleTon INSTANCE = new SingleTon();

private SingleTon() { }

public static SingleTon getInstance() { return INSTANCE; }
```
SingleTon.getInstance 는 항상 같은 객체의 참조를 반환하므로 제2의 인스턴스랑 결코 만들어 지지 않는다.(리플랙션을 통한 예외는 똑같이 적용)

***장점***
1. API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
2. 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
3. 정적 팩터리의 메서드 참조를 공급자로 사용할 수 있다.


***Supplier***<br>
자바8 부터 생성된 메서드를 1개만 가지고 있는 인터페이스이다.

```java
//getInstance 에 대한 레퍼런스를 Supplier 타입으로 만들 수 있다.
Supplier<SingleTon2> s2Supplier = SingleTon2::getInstance;
```

***직렬화***<br>
위에서 사용한 두 방법 모드 직렬화를 사용한다면 역직렬화를 할 때 같은 타입의 인스턴스가 여러개 생성될 수 있다.<br>
이를 해결하려면 모든 인스터스 필드를 일시적(transient)이라고 선언하고 readResolve 메서드를 제공해야 한다.

```java
//transient를 선언해 줍니다.
private static final transient SingleTon2 INSTANCE = new SingleTon2();

//역직렬화 할 때 부르는 메소드
private Object readResolve() {
    return INSTANCE;
}

```

```java
implements Serializable
```
java 에서는 Serializable 을 사용해 직렬화 할 수 있다.

직렬화는 이사짐 옮기는 것과 비슷하다. 특히 네트워크 통신, 메모리, 캐싱 등등 객체를 전달할 때 사용된다.
(객체를 옮길 수 있는 상태로 만드는 것)

## 열거 타입 방식의 실글턴

```java
public enum SingleTon3 {

    INSTANCE;

    //enum 또한 프로퍼티 및 메서드를 가질 수 있다.
    //인터페이스도 구현 가능 하다.
    public String getName() {
        return "BlackJin";
    }
}
```
직렬화 상황이나 리플렉션 공격에서도 제2의 인스턴스가 생기는 일을 완벽히 막아준다.<br>
원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다. 하지만 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법은 사용할 수 없다.<br>
하지만 이건 이상적인 것이고 ***실재 업무에서는 각 프레임워크의 스코프에 따라 싱글턴을 쓰는 차이가 있다.***(Spring 에서는 빈으로 등록, Android 에서는 Dagger, koin 사용)

