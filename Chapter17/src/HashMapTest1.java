import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest1 {

	public static void main(String[] args) {
		// Hashmap 객체 생성. key와 value 사우로 이루어 져야 한다
		HashMap<String, String> dict = new HashMap<String, String>();
		
		// 3개의 (k, v) 쌍을 이루는 dict 만들기
		dict.put("사과", "apple");
		dict.put("딸기", "strawberry");
		dict.put("포도", "grape");
		
		// 사용자로부터 한글 단어를 입력 받아 영어 단어 검색
		Scanner stdIn = new Scanner(System.in);
		
		while(true) {
			System.out.print("알고싶은 과일 이름을 입력하세요(0은 종료) : ");
			String kor = stdIn.next();
			if(kor.equals("0")) {
				System.out.println("종료");
				break;
			}
			
			// HashMap에서 key(kor) 의 value(eng) 검색
			String eng = dict.get(kor);
			if(eng == null) {
				System.out.println(kor + "은(는) 없는 단어입니다.");
			}
			
			else {
				System.out.println(eng);
			}
			
		}
		

	}

}
