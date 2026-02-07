import java.util.*;

public class MyLinkedQueue{

	
	LinkedList<String> queueArray;

	private int size;
	private int front=0;
	private int rear=1;

	public MyLinkedQueue(){

		

		queueArray = new LinkedList<String>();

		
		

	}

	public void enqueue(String data){

		
		
		queueArray.add(data);
		rear++;
		size++;
				
	}

	public String dequeue(){

		if(size==0){
			System.out.println("no elements in queue");
			return "-1";
		}

		String result = "";

		if(queueArray.get(front)!=null){

			result = queueArray.get(front);

			queueArray.remove(front);

			

		}

		else{

			System.out.println("Queue is empty");

		}
		size--;
		return result;
		


	}



	
	public Boolean isEmpty(){

		return queueArray.isEmpty(); 

	}
	



	public String display(){
		if(size==0){
			System.out.println("no elements in queue");
			return "-1";
		}

			System.out.print("Queue elements: ");

			for(String str: queueArray){

				System.out.print(str + " ");

			}

			System.out.println();
			return "";
		}


	public static void main(String[] args){

		MyLinkedQueue queue = new MyLinkedQueue();
		/*String[] myArray = {"1", "2", "3", "4", "5"};

		for(int i = myArray.length-1; i>=0; i --){

			queue.enqueue(myArray[i]);

		}

		System.out.print("Original array:");

		for(int x = 0; x<myArray.length; x++){

			System.out.print(myArray[x]+ " ");

		}

		System.out.println();

		
		System.out.print("new array:");*/

		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		queue.enqueue("f");
		queue.display();

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		queue.display();
		



	}


}