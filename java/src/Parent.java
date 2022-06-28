public class Parent{
    public String nation;

    // 부모 생성자1
    public Parent(){
        this("대한민국"); // 자신의 생성자 호출 (부모 생성자 2 호출)
        System.out.println("Parent() call");
    }
    // 부모 생성자2
    public Parent(String nation){
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}

