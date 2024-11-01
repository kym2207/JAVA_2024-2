/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395008 김유민
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListtest2 {

	public static void main(String[] args) {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		long start, stop;
		
		start = System.currentTimeMillis();
		for( int i = 0; i <= 1000000; i++) {
			alist.add(i);
		}
		stop=System.currentTimeMillis();
		System.out.println("ArrayList - 순차적 삽입 : "+ (stop - start));
		
		start = System.currentTimeMillis();
		for( int i = 0; i <= 1000000; i++) {
			llist.add(i);
		}
		stop=System.currentTimeMillis();
		System.out.println("LinkedList - 순차적 삽입 : "+ (stop - start));
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		
		
		start = System.currentTimeMillis();
		for( int i = 0; i <= 10000; i++) {
			alist.add(500, i);
		}
		stop=System.currentTimeMillis();
		System.out.println("ArrayList - 중간 삽입 : "+ (stop - start));
		
		start = System.currentTimeMillis();
		for( int i = 0; i <= 10000; i++) {
			llist.add(500, i);
		}
		stop=System.currentTimeMillis();
		System.out.println("LinkedList - 중간 삽입 : "+ (stop - start));
	}

}
