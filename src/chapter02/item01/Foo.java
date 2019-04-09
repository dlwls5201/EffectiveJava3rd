package chapter02.item01;

public class Foo {

    String name;

    String address;

    public Foo() {}

    public Foo(String value) {
        this.name = value;
    }

    //장점1
    public static Foo fromName(String name) {
        return new Foo(name);
    }

    public static Foo fromAddress(String address) {

        Foo foo = new Foo();
        foo.address = address;

        return foo;
    }

    //장점2
    private static final Foo MY_FOO = new Foo();

    public static Foo getMyFoo() {
        return MY_FOO;
    }

    //장점3
    private static Foo getFoo() {
        //반환 타입의 하위 타입 객체를 반환 할 수 있다.
        return FooInterface.getFoo();
    }

    //장점4
    public static Foo getFoo(boolean flag) {
        //입력 매개변수에 따라 매번 다른 클래스의 객체를 반환 할 수 있다.
        return flag ? new Foo() : new SubFoo();
    }


    public static void main(String[] args) {


    }

    public static class SubFoo extends Foo {

    }

}
