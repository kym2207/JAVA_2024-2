/*
 * 작성일 : 2024년 09월 13일
 * 작성자 : 2023950008 김유민
 */
public class integerTest1 {

	public static void main(String[] args) {
		Integer num1 = Integer.valueOf(13);
		Integer num2 = 25;	// Autobox 를 이용한 방법.

		System.out.println("num1이 포장하고 있는 값(정수) : "+num1.intValue());
		System.out.println("num2이 포장하고 있는 값(정수) : "+num2);

		
		num2 = num1 + num2; // 객체 변수도 연산이 가능하다.
		
		System.out.println("num1 + num2 = " + num2);
		
		System.out.println("num2의 2진수 " + Integer.toBinaryString(num2));
		System.out.println("num1 == num2 = " + num1.equals(num2));
	}

}
