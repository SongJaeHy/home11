
public class Main {

	public static void main(String[] args) {
		LinkedListClass node1 = new LinkedListClass(1, null);
		LinkedListClass node2 = new LinkedListClass(2, null);
		LinkedListClass node3 = new LinkedListClass(3, null);
		LinkedListClass node4 = new LinkedListClass(4, null);
		LinkedListClass node5 = new LinkedListClass(5, null);

		node1.address = node2;
		node2.address = node3;
		node3.address = node4;
		node4.address = node5;
		System.out.println("node1의 다음주소: " + node1.address);
		System.out.println("node2의 주소 :" + node2);
		System.out.println("node2의 다음주소: " + node2.address);
		System.out.println("node3의 주소 :" + node3);
		System.out.println("node3의 다음주소: " + node3.address);
		System.out.println("node4의 주소 :" + node4);
		System.out.println("node4의 다음주소: " + node4.address);
		System.out.println("node5의 주소 :" + node5);
		System.out.println("node5의 다음주소: " + node5.address);

	}

}
