import java.util.Scanner;

public class ScannerTest1 {

	public static void main(String[] args) {
		String day = "happy day, smile day, nice day, joyful day, ";
		
		Scanner stdIn = new Scanner(day);
		stdIn.useDelimiter("day, "); // 분리자 지정.
		
		// 다음 토근이 있을 떄까지 읽어서 출력
		while(stdIn.hasNext()) {
			System.out.println(stdIn.next());
		}

	}

}
