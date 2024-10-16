import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JComboBox1 extends JFrame implements ItemListener{
	JLabel fruitLabel;
	public JComboBox1() {
		// 2. 컨테이너 생성.
		Container ct = getContentPane();
		// 3. 배치 관리자 성정
		ct.setLayout(new FlowLayout());
		
		JComboBox<String> fruitCombo = new JComboBox<String>();
		
		// 콤보받그에 들어갈 내용이면서 이미지 파일명을 배열로 선언
		String fruitsList[] = {"apple","banana","cherry","grape","pear","persimmon"};
		
		for(int i=0;i<fruitsList.length;i++) {
			fruitCombo.addItem(fruitsList[i]);
		}
		fruitLabel = new JLabel();
		ct.add(fruitCombo);
		ct.add(fruitLabel);
		
		fruitCombo.addItemListener(this);
		
		setTitle("JComboBox Test1");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String fruit = (String)e.getItem();
		fruitLabel.setIcon(new ImageIcon("images/" + fruit + ".jpg"));	
		
	}
}
public class JComboBoxTest1 {

	public static void main(String[] args) {
		new JComboBox1();

	}

}
