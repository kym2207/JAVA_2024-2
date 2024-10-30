import java.util.StringTokenizer;

public class StringTokenizerExam {
	public static void main(String[] args) {
		String s1 = "이름 김유민 성별 남자 나이 21";
		String s2 = "이름,김유민,성별,남자,나이,21";
		String s3 = "이름/김유민/성별/남자/나이/21";
		String s4 = "이름:김유민:성별:남자:나이:21";
		
		System.out.println("------------ 빈칸을 기준으로 ------------");
		StringTokenizer st1 = new StringTokenizer(s1);
		while(st1.hasMoreTokens()) {
			String first = st1.nextToken();
			String second = st1.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------------ ,를 기준으로 ------------");
		StringTokenizer st2 = new StringTokenizer(s2, ",");
		while(st2.hasMoreTokens()) {
			String first = st2.nextToken();
			String second = st2.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------------ /를 기준으로 ------------");
		StringTokenizer st3 = new StringTokenizer(s3, "/");
		while(st3.hasMoreTokens()) {
			String first = st3.nextToken();
			String second = st3.nextToken();
			System.out.println(first + "\t" + second);
		}
		
		System.out.println("------------ :을 기준으로 ------------");
		StringTokenizer st4 = new StringTokenizer(s4, ":");
		while(st4.hasMoreTokens()) {
			String first = st4.nextToken();
			String second = st4.nextToken();
			System.out.println(first + "\t" + second);
		}
	}
}
