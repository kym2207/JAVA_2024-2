/*
 * 작성일 : 2024년 09월 13일
 * 작성자 : 2023950008 김유민
 */
package b_package;
import a_package.Test1; // a_package.Test1을 포함.
//import a_package.*;	// 패키지 내의 모든 클래스 포함 시킨다.
public class Test2 {

	public static void main(String[] args) {
		Test1 ss = new Test1();
		System.out.println(ss.sum(10, 20));
	}
}
