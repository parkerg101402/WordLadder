import java.util.*;
public class RPNCalc {
	
	



	public Boolean isInteger(String x){
		try {
        Integer.parseInt( x );
        return true;
    }


    catch( Exception e ) {
        return false;
    }
	}

	public Boolean isOperator(String x){
    	switch(x){
    		case"+":
    		case"-":
    		case"*":
    		case"/":
    			return true;


    	}
    	return false;


    }

    public Boolean isSpecOperator(String x){
    	switch(x){
    		case"*":
    		case"/":
    			return true;
    	}
    	return false;
    }
	public double calculate(String x){
		MyStack result;

		String [] problem = x.split(" ");

		

		result = new MyStack(problem.length);
		double numRes=0;
		double first;
		double second;
		double third;


		if(problem.length<=2){
			System.out.println("Not enough integers or operations");
			return -1;
		}

		
		for(int i =0; i<problem.length; i ++){
			
			
			try{
				
				
				Double.parseDouble(problem[i]);
				result.push(problem[i]);

				
								

			}

			catch(Exception e){
				//System.out.println(result.toString());
				first = Double.parseDouble(result.pop());
				second = Double.parseDouble(result.pop());

				switch(problem[i]){
					case "*":
						numRes = first*second;
						break;
					case "+":
						numRes = first+second;
						break;
					case "-":
						numRes = second-first;
						break;
					case "/":
						numRes = second/first;
						break;

				}result.push(Double.toString(numRes));





			}
			
		}




		return numRes;

	}

	public String convert(String data){


		String [] problem = data.split(" ");
		

		String first= "";
		String second= "";
		MyStack result = new MyStack(problem.length);
		

		for(int i=0; i<problem.length-1; i++){
			
			

			try{
				
				Integer.parseInt(problem[i]);
				result.push(problem[i]);
				

			}

			catch(Exception e ){
			if(this.isOperator(problem[i])){	
				if(this.isInteger(problem[i+1])){
					result.push(problem[i+1]);
					result.push(problem[i]);
					i++;
				}else{
					
					int x = i+2;
					String operator = "";
					while(first==""){
						if(this.isInteger(problem[x]))first = problem[x];
						if(this.isOperator(problem[x]))operator = problem[x];
						x++;
					}
					while(second==""){
						if(this.isInteger(problem[x]))second = problem[x];
						if(this.isOperator(problem[x]))operator = problem[x]; 
						x++;
					}
					result.push(first);
					result.push(second);
					result.push(operator);
					result.push(problem[i]);
					i=x-1;

					first = "";
					second = "";
				}
			}else{
				 if(!this.isOperator(problem[i+1]))continue;
				 else{
				 	String firstOperator = problem[i+1];
				 	if(i+2 == problem.length-1){

				 		result.push(problem[i+2]);
				 		result.push(firstOperator);
				 		break;

				 	}
				 	String secondOperator = "";
				 	//System.out.println(this.isSpecOperator(problem[i+1]));

				 	if(i+2<problem.length){

				 	for(int f = i+2; f<problem.length; f++){

				 		if(this.isInteger(problem[f]))
				 			result.push(problem[f]);
				 			
				 		
				 		//(8+5) + (8+5)
				 		else{
				 			result.push(problem[f+1]);
				 			result.push(problem[f+3]);
				 			result.push(problem[f+2]);
				 			result.push(firstOperator);
				 			i = f + 3;
				 			break;

				 		}
				 		if(f+1<problem.length){
				 		if(this.isOperator(problem[f+1])){
				 			//(8+3)-3+2 
				 			if(this.isInteger(problem[f+2])){



				 				if(this.isSpecOperator(firstOperator)){

				 					result.push(firstOperator);
				 					result.push(problem[f+2]);
				 					result.push(problem[f+1]);
				 					i = f + 2;
				 					break;

				 				}

				 				else if(this.isSpecOperator(problem[f+1])){

				 					result.push(problem[f+2]);
				 					result.push(problem[f+1]);
				 					result.push(firstOperator);
				 					i = f + 2;
				 					break;

				 				}else{

				 					result.push(firstOperator);
				 					result.push(problem[f+2]);
				 					result.push(problem[f+1]);
				 					i = f + 2;
				 					break;

				 				}


				 			}
				 			// (8+3)+3*(8-5)
				 			else{


				 				result.push(problem[f+3]);
				 				result.push(problem[f+5]);
				 				result.push(problem[f+4]);
				 				result.push(problem[f+1]);
				 				result.push(firstOperator);
				 				i = f + 5;
				 				break;

				 			}
				 		}
				 	}

				 		//if(this.isInt)


				 	}
				 	

				 }





				 }


			
			}
			continue;

	}

}
return result.toString();
}
	public static void main(String[] args){

		RPNCalc myCalc = new RPNCalc();

		//System.out.println(myCalc.calculate("4 5 + 5 * 5 4 + +"));
		//" ( ( 5 / ( 8 + 2 ) - 3 * ( 7 + 12 ) ) / 10"
		//System.out.println(myCalc.convert(" ( ( 5 / ( 8 + 2 ) - 3 * ( 7 + 12 ) ) ) / 10"));

		// must put spaces between each character
		Scanner input = new Scanner(System.in);
		System.out.println("type 'RPN' if you want to type an expression using RPN/postfix notation and have it solved");
		System.out.println("if not type no");
		String choice1 = input.nextLine();
		if(choice1.equals("RPN")){
			 System.out.println("type your expression in RPN notation with a space between each number, operator and parenthsis");
			 String equation = input.nextLine();
			 System.out.println("the answer is: " + myCalc.calculate(equation));
		}
		else if(choice1.equals("no")){
			System.out.println("type 'convert' if you want to convert a normal/infix expression to RPN/postfix.");
			System.out.println("type 'regular' to type an expression in regular/infix notation");
			String choice2 = input.nextLine();
			if(choice2.equals("convert")){
			System.out.println("what is the regular/infix expresion that you want to convert to RPN.");
			System.out.println("type the expression with a space between each number, operator and parenthsis");
			String regeq = input.nextLine();
			System.out.println("your conversion came out to be " + myCalc.convert(regeq));
			}
			if(choice2.equals("regular")){
				System.out.println("type your expression in regular/infix notation ");
				System.out.println("type your expression with a space between each number, operator, and parenthesis");
				String regeq2 = input.nextLine();
				System.out.println("the answer is: " + myCalc.calculate(myCalc.convert(regeq2)));
			}
		}

		//System.out.println(myCalc.calculate(myCalc.convert("( ( 5 / ( 8 + 2 ) - 3 * ( 7 + 12 ) ) ) / 10")));

		
	}
}

