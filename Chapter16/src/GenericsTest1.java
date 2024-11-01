/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
class Box<T> {	// 재네릭 클래스선언
	T vol;
	void setVolume(T v) {
		vol=v;
	}
	T getVolume() {
		return vol;
	}
}
public class GenericsTest1 {

	public static void main(String[] args) {
		Box<Integer> ibox = new Box<Integer>();
		ibox.setVolume(200);
		System.out.println("<Integer>박스의 부피는 : " + ibox.getVolume());
		
		Box<Double> dbox = new Box<Double>();
		dbox.setVolume(123.456);
		System.out.println("<Double>박스의 부피는 : " + dbox.getVolume());
		

	}

}
