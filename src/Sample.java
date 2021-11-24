class A {
    private static A obj;

    private A() {}

    public static A getA() {
        if(obj == null) {
            obj = new A();
        }
        return obj;
    }
}

class Sample {
    public static void main(String[] args) {
        A a = A.getA();
        A a2 = A.getA();
        System.out.println(a);
        System.out.println(a2);
    }
}
