package chapter02.item01;

import java.util.EnumSet;

public class Foo {

    String name;

    String address;

    public Foo() {}

    public Foo(String value) {
        this.name = value;
    }

    //장점1 : 이름을 가질 수 있다.
    /*public static Foo fromName(String name) {
        return new Foo(name);
    }*/

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

    //장점2 : 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    private static final Foo MY_FOO = new Foo();

    public static Foo getMyFoo() {
        return MY_FOO;
    }

    //장점3 : 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
    private static Foo getFoo() {

        return FooInterface.getFoo();
    }

    //장점4 : 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
    public static Foo getFoo(boolean flag) {

        return flag ? new Foo() : new SubFoo();
    }

    public static class SubFoo extends Foo {

    }

    public static void main(String[] args) {

    }

}
