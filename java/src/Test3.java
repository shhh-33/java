public class Test3
{
    /**
     * - w는 3이지만, w는 y와 동일하므로 TRUE
     * - y가 z보다 크지 않으므로 TRUE
     * - x는 1이 아니라 FALSE, y와 z는 같지 않으므로 TRUE, 하나는 FALSE, 하나는 TRUE이므로 ^연산 결과는 TRUE
     * - 첫번째 if문은 전부 TRUE이므로 첫번째 명령문 실행
     *
     * - w=4+3=7

     * - x는 7이 아니므로 FALSE, y는w와 같지 않으므로 TRUE, ^연산 결과는 TRUE
     * - w값인 7를 출력한다.
     * @param args
     */
    public static void main(String[] args) {
        // 정수형 변수 선언
        int w=3, x=4, y=3, z=5;

        // w가 2이거나 w가 y와 같으면 TRUE,
        // y가 z보다 크지 않으면 TRUE,
        // x가 1이면 TRUE, y가 z가 아니라면 TRUE, 둘다 TRUE면 TRUE
        // 만약 셋 다 TRUE거나 FALSE면 TRUE
        if((w==2 | w==y) & !(y>z) & (1==x ^ y!=z)) {
            // w=4+3
            w=x+y;

            // 7이 x면 TRUE, y가 w와 같지 않으면 TRUE
            // 만약 둘다 TRUE면 FALSE
            if(7==x ^ y!=w) {
                System.out.println(w);
            } else{
                System.out.println(x);
            }
        } else{
            w=y+z;

            if(7==y ^ z!=w) {
                System.out.println(w);
            } else{
                System.out.println(z);
            }
        }
    }
}