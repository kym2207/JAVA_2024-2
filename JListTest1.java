import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

class JList1 extends JFrame {
	// 과일 배열
	private String fruitsList[] = {"apple","banana","cherry","grape","pear","persimmon"};
	
	// 과일 배열로 리스트 객체 생성
	private JList jlist = new JList();
	
	// 아이콘 이미지 객체 배열 생서ㅇ
	private ImageIcon[] fruitIcons = {
			new ImageIcon("apple.jpg"),
			new ImageIcon("banana.jpg"),
			new ImageIcon("cherry.jpg"),
			new ImageIcon("grape.jpg"),
			new ImageIcon("pear.jpg"),
			new ImageIcon("persimmon.jpg")
	};
	
	// 이미지 아이콘과 과일 이름 출력 라벨
	private JLabel[] jlicon = new JLabel[6];
	private JLabel jlname = new JLabel();
	
	public JList1() {
		// 2. 컨테이너 생성.
		Container ct = getContentPane();
		// 3. 배치 관리자 성정
		ct.setLayout(new BorderLayout());
		
		// 이미지 영역
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3,2,5,5));
		
		// 과일 이름 출력 영역
		JPanel jp2 = new JPanel();
		jp2.add(jlname);
		
		
	}
}
public class JListTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
