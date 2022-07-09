import java.util.Scanner;

class Main {  
  public static void main(String args[]) { 
    Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    

    if(a==b && b==c){
      System.out.print(10000+a*1000);
    }
    else if(a==b || a==c || b==c){
       int sameNum = a==b?a : (b==c?b : c);
      System.out.print(1000+sameNum*100);
    }
    else{
      
    int max=a;
    if(b>=max){
      max=b;
    }
    if(c>=max){
      max=c;
    }
      System.out.print(max*100);
    }
    

  
}
}
