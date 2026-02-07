import java.util.*;


public class MyLinkedStack{

	private LinkedList <String> stackArray;

	private int topOfStack;

	private int stackSize = 0;

	public MyLinkedStack(){

		stackArray = new LinkedList <String> ();


	}



	public void push(String input){
		

		stackArray.add(input);
		topOfStack = stackArray.indexOf(stackArray.getLast());
		stackSize++;
		
	}



	public String pop(){

		if(stackSize==0){
			System.out.println("no items in stack");
			return "-1";
		}

		String res = " ";
		res = stackArray.get(topOfStack);
		stackArray.remove(topOfStack);
		stackSize--;



		return res;

	}


	public Boolean isEmpty(){

		return stackSize == 0;

	}


	

	public String toString(){

 	if(stackSize==0){
			System.out.println("no items in stack");
			return "-1";
		}

		String result = "";

		for(String g: stackArray){
			result+= g + " ";
		}
		return result;

	}



		


	
	public int length(){
		
		
		return stackSize;
	}




	public static void main(String[] args){
		/*

		MyStack stack = new MyStack(5);

		String [] myArray ={"1", "2", "3", "4", "5"};

		int size = myArray.length;

		for(int i = size-1; i>=0; i--){
			stack.push(myArray[i]);
		}

		System.out.print("Original array: ");

		for(int x = 0; x<myArray.length; x++){

			System.out.print(myArray[x]+ " ");

		}

		System.out.println();



		System.out.println("Stack elements: "+stack.toString());

		System.out.println(stack.length());

		*/

		MyLinkedStack stack = new MyLinkedStack ();
		stack.push("a");
		stack.push("c");
		stack.push("d");
		stack.push("e");

		System.out.println(stack.toString());
		System.out.println(stack.pop());
		System.out.println(stack.toString());


	}
}






