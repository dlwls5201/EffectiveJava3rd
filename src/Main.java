public class Main {

    public static void main(String[] args) {

        PhoneNumber x = new PhoneNumber();

        boolean test1 = x.clone() == x;
        boolean test2 = x.clone().equals(x);

        System.out.println("test1 : " + test1);
        System.out.println("test2 : " + test2);
    }
}

class PhoneNumber implements Cloneable {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
