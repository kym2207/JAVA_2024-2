import java.util.Random;
import java.util.TreeSet;

public class TreeSetlotto {

	public static void main(String[] args) {
		Random r = new Random(); 
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		while(lotto.size()<6) {
			lotto.add(r.nextInt(45)+1);
		}
		System.out.println("이번주 로또 번호 : " +lotto);
	}

}
