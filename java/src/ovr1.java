public class ovr1 {

    public static void main(String[] args) {

        ovr1 a1 = new ovr1();

        ovr2 a2 = new ovr2();

        System.out.println(a1.sun(3,2) + a2.sun(3,2)); //5 + 6

    }

    int sun(int x, int y) {


        return x + y;

    }

}

class ovr2 extends ovr1 {

    int sun(int x, int y) {

        /**
         * super 키워드는 부모 클래스로부터 상속받은 필드나 메소드를
         * 자식 클래스에서 참조하는 데 사용하는 참조 변수
         */
        return x - y + super.sun(x, y); //1 + 5

    }

}