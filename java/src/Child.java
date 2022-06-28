public class Child extends Parent{
    private String name;

    //자식 생성자 1
    public Child(){
        // super();  // 컴파일 시 자동 생성 (부모 생성자 1 호출)
        this("홍길동"); // 자신의 생성자 호출 (자식 생성자 2)
        System.out.println("Child() call");
    }
    //자식 생성자 2
    public Child(String name){
        this.name = name;
        System.out.println("Child(String name) call");
    }
}

/**
 * Child객체를 생성했는데 Child클래스가 Parent클래스를 상속받고 있으므로 Parent 생성자로 먼저 초기화를 진행한다
 * 그래서 기본 생성자를 수행하는 도중 this()를 만나서 Parent(String nation)을 먼저 수행한다.
 * 다음에 Parent()를 수행한다.
 * 그리고 Child 생성자를 수행하는데 여기서도 기본 생성자인 Child() 에서 this("홍길동") 를 부르기 때문에
 * Child(String name) 호출 후 Child()를 수행한다.
 *
 *
 * Parent(String nation) call
 * Parent() call
 * Child(String name) call
 * Child() call
 */