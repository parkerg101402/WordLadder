import java.util.*;

public class MyQueue{

	
	String [] queueArray;

	private int size;
	private int front = 0;
	private int rear = 0;

	public MyQueue(int size){

		this.size = size;

		queueArray = new String [size];

		
		Arrays.fill(queueArray,"-1");

	}

	public void enqueue(String data){

		if(rear<=size){

		queueArray[rear]=data;

		rear++;
		}

		

		else{

			System.out.println("Queue is full ");

		}
	}

	public String dequeue(){

		String result = "";

		if(queueArray[front]!="-1"){

			result = queueArray[front];

			queueArray[front]="-1";

			front++;

		}

		else{

			System.out.println("Queue is empty");

		}

		return result;


	}

	public Boolean isEmpty(){

		return size == 0;

	}

	public void display(){
			System.out.print("Queue elements: ");

			for(int i = 0; i<size; i++){

				if(queueArray[i]!="-1"){

					System.out.print(queueArray[i] + " ");

				}

			}

			System.out.println();
		}


	public static void main(String[] args){

		MyQueue queue = new MyQueue(5);
		String[] myArray = {"1", "2", "3", "4", "5"};

		for(int i = myArray.length-1; i>=0; i --){

			queue.enqueue(myArray[i]);

		}

		System.out.print("Original array:");

		for(int x = 0; x<myArray.length; x++){

			System.out.print(myArray[x]+ " ");

		}

		System.out.println();

		
		System.out.print("new array:");

		queue.display();


	}


}