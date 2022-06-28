/**
 * 추상 클래스에는 메소드의 시그니처만 정의해 놓고
 * 그 메소드의 실제 동작 방법은 추상 클래스를 상속받는 실체 클래스의 책임으로 위임한다.
 *
 */

abstract class Vehicle{ //추상클래스 Vehicle
    String name;

    abstract public String getName(String val); //추상메소드 getName 생성

    public String getName(){ //함수 getName 생성, 오버로딩
        return "Vehicle name :" + name;
    }
}



class Car extends Vehicle{ //추상클래스 Vehicle을 상속받는 클래스 Car
    public Car(String val){
        name = super.name = val; //인자로 받은 문자열을 부모 클래스의 변수 name에 대입후 본인클래스의 name에 대입
    }
    public String getName(String val){ //함수 getName 생성, 오버로딩(매개변수형 다름)
        return "Car name :" + val;
    }
    public String getName(byte val[]){
        return "Car name :" + val;
    }
}


public class Test{
    public static void main(String[] args){
        Vehicle obj = new Car("Spark"); //클래스 Car의 객체 obj 생성, 자료형은 추상클래스로 지정
        System.out.printf(obj.getName()); //매개변수 없음 -> 없는 getName 호출해야함
        /**
         * 만약! 클래스 Car 에 함수 getName()이 있다면, 우선순위는 하위(자식) 클래스이므로,
         * 클래스 Car 의 함수 getName() 이 호출된다.
         *
         */
    }
}
