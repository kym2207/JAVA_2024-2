/*
 * 작성일 : 2024년 09월 13일
 * 작성자 : 2023950008 김유민
 */
public class StringTest2 {

	public static void main(String[] args) {
		String s1 = "Javer Korea"; // 단축 초기화
		String s2 = new String("Javer Korea");
		String s3 = s2.intern();
				// 객체가 가진 문자열을 단축 초기화 문자열로 만들어 반환하는 메소드.
		String s4 = "Java Korea";
		String s5 = new String("Javer Korea");
		
		System.out.println(s1 == s2);       // false
		System.out.println(s1.equals(s2));	// true
		System.out.println(s1 == s3);		// true
		System.out.println(s2 == s5);		// false
		System.out.println(s2.equals(s5));	// true
	}

}
