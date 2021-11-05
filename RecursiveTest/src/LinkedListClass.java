
public class LinkedListClass {

	public int data;
	public LinkedListClass address;

	public LinkedListClass(int data, LinkedListClass address) {
		this.data = data;
		this.address = address;
	}

	public void getData(){
		System.out.println(this.data);
	}

	public void getAddress() {
		System.out.println(this.address);
	}
}
