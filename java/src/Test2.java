class SuperObject {
    public void paint() { //여기로갔다가
        draw(); // 오버라이딩 된 메소드이므로 하위 클래스의 draw() 수행 -> Sub Object 출력
    }

    public void draw() {
        draw();
        System.out.println("Super Object"); //2.출력
    }
}

class SubObject extends SuperObject {
    public void paint() {
        super.draw(); //상위 클래스의 draw() 수행
    }

    public void draw() {
        System.out.println("Sub Object"); //1.출력
    }
}

public class Test2 {
    public static void main(String[] args) {
        //하위 클래스의 생성자로 객체 변수 선언하고, 자료형은 상위 클래스로 지정 -> 오버라이딩 하기 위함
        SuperObject a = new SubObject();

        a.paint(); //오버라이딩 되었으므로 하위클래스의 paint() 수행
    }
}
/**
 * *static은 클래스 이름으로 메소드에 접근하기 위해 사용하는 예약어이다.
 * 메소드를 사용하기 위해서는 메소드가 포함된 클래스의 객체 변수를 선언한 후 [객체 변수].[메소드] 방식으로 접근해야 하지만,
 * static을 이용하면 객체 변수 없이 [클래스 이름].[메소드]의 방식으로 접근하는 것이 가능해진다.
 */