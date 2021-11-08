import java.util.Arrays;

public class BubbleClass {

	// 버블소트 처리용 메서드를 만들어주세요.
	public static void bubbleSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] items = {5, 6, 1, 4, 3, 7, 2};

		System.out.println(Arrays.toString(items));

		bubbleSort(items);

		System.out.println(Arrays.toString(items));
	}
}
