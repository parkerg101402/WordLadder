import java.util.Arrays;


public class MyStack{

	private String [] stackArray;

	private int topOfStack = -1;

	private int stackSize;

	public MyStack(int size){


		stackSize = size;

		stackArray = new String[size];

		Arrays.fill(stackArray, "-1");

	}



	public void push(String input){

		if(topOfStack+1 < stackSize){

			topOfStack++;

			stackArray[topOfStack] = input;

		}else{

			System.out.println("not enough space");

		}

		

	}



	public String pop(){

		String res = " ";
		if(stackSize>=0){
			res = stackArray[topOfStack];
			stackArray[topOfStack] = "-1";
			topOfStack--;
		}
		return res;

	}


	public Boolean isEmpty(){

		return stackSize == 0;

	}


	

	public String toString(){

		String result = "";

		for(int i =0; i<stackSize; i++){ 

			if(stackArray[i]!="-1"){

			result+=stackArray[i] + " "; 

		}

	}



		return result;


	}
	public int length(){
		return stackArray.length;
	}




	public static void main(String[] args){

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

		

	}
}






