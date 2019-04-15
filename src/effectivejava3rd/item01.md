# 생성자 대신 정적 팩터리 메서드를 고려하라

```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.True : Boolean.False;
}
```

클라이언트가 클래스의 인스턴스를 얻는 전통적인 수단을 public 생성자다. 하지만 아래와 같이 클래스는 생성자와 별도로 적적 팩터리 메서드를 제공할 수 있다.

## 장점1 : 이름을 가질 수 있다.

생성자만으로는 반활될 객체의 특성을 제대로 알 수 없다. 정적 팩터리는 이름을 달리 지을 수 있어 특성을 쉽게 묘사할 수 있다.

하나의 시그니처로는 생서자 하나만 만들 수 있지만 정적 팩터리를 이용하여 시그니처가 같은 생성자를 이름을 달리하여 만들 수 있다.

```java
public static Foo fromName(String name) {

        Foo foo = new Foo();
        foo.name = name;

        return foo;
    }

public static Foo fromAddress(String address) {

        Foo foo = new Foo();
        foo.address = address;

        return foo;
    }
```

## 장점2 : 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.

인스턴스를 미리 만들어 놓거나 새로 생성한 인스턴스를 캐싱하여 재활용 하는 식으로 불필요한 객체 생성을 피할 수 있다.

Boolean.valueOf(boolean) 예로 들고 있다.

## 장점3 : 변환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.

API를 만들 때 이 유연성을 응용하면 구현 클래스를 공개하지 않고도 객체를 반활할 수 있어 API를 작게 유지할 수 있다.

자바 8 전에는 인터페이스에 정적 메서드를 선언할 수 없었다. 자바 8 에서는 인터페이스에 public 정적 메서드가 허용 되고 자바 9 에서는 private 정적 메서드까지 허롹되었다.

```java
private static Foo getFoo() {

       return FooInterface.getFoo();
   }
```

## 장점4 : 입력 매개변수에 따라 매번 다른 클래스의 객체를 반활 할 수 있다.

장점3의 연장선으로 반환 타입의 하위 타입이기면 하면 어떤 클래스의 객체를 반환하든 상관없다.

EnumSet()을 예로 들고 있다.

```java
public static Foo getFoo(boolean flag) {

        return flag ? new Foo() : new SubFoo();
    }
```


## 장점5 : 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

의존성 주입과 비슷한 개념으로 보면 됩니다.


### 단점 1 : 상속을 하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하여 하위 클래스를 만들 수 없다.

### 단점 2 : 정적 팩터리 메서드는 프로그래머가 찾기 어렵다. -> API 문서를 잘 써놓고 메서드 이름도 규약을 따라야 한다.


## 핵심정리

1. 정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인 장단점을 이해하고 사용하자.
2. 적적 팩터리를 사용하는게 유리한 경우가 많다.