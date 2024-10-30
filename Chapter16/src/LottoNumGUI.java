import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Lotto extends JFrame implements ActionListener {
	// 로또 번호 출력 될 라벨 생성.
	private JLabel lotto_num = new JLabel();
	public Lotto() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		JButton lotto = new JButton("로또 번호 자동생성");
		
		ct.add(lotto);
		ct.add(lotto_num);
		
		// 버튼에 리스너 추가.
		lotto.addActionListener(this);
		
		// 화면에 출력
		setTitle("Lotto Number 생성기");
		setSize(300,150);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Random r = new Random(); // Random() 클래스 객체 생성.
		int[] lnum = new int[6]; // 배열 생성.
		int temp; // 같은 번호가 생성 되었는지 확인을 위해 변수 생성.
		int i = 0;
		
		a: while( i < 6 ) {
			temp = r.nextInt(45)+1;
			for(int j = 0; j<= i; j++) {
				if(temp == lnum[j]) {
					continue a;
				}
			}
			lnum[i] = temp;
			i++;
		}
		Arrays.sort(lnum);
		lotto_num.setText("이번주 로또 번호 : " + Arrays.toString(lnum));
	}
}
public class LottoNumGUI {

	public static void main(String[] args) {
		new Lotto();

	}

}
