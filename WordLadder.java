import java.util.*;
public class WordLadder{

	


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	HashSet<String> hs = new HashSet<String>();
		    	

    	for(String s: wordList){
    		hs.add(s);
    	}

    	String word = beginWord;
        Queue <Stack> queue = new LinkedList<>();
        Stack<String> start = new Stack<String>();

        

        start.push(word);
        
        queue.add(start);
        

        int level = 0;
        int wordLength = word.length();


        if(!hs.contains(endWord)) return -1;
		
        
        while(queue.size()>0){
        	
        	

        	level++;

        	int qSize = queue.size();

        	


        	Stack copy = queue.remove();

        	ArrayList<String> stackContents = new ArrayList<String>();

        	String w = (String)(copy.pop());

        	while(!copy.isEmpty()){
        		String x = (String)(copy.pop());
        		stackContents.add(x);
        	}
        		

        	

        	//System.out.println(w);

        	if(w.equals(endWord)){
        		stackContents.add(w);
        		System.out.println(stackContents);
        		return level+1;
        	}

        	char[] arr = w.toCharArray();



        	for(int y = 0; y < arr.length; y ++){

        			char origChar = arr[y];

        			for(char x = 'a'; x<='z'; x++){

        				arr[y]=x;


        				String newWord = String.valueOf(arr);

        				
        				Stack<String> stack2 = new Stack<String>();


        				if(hs.contains(newWord)&&!newWord.equals(w)){

        					
        					hs.remove(newWord);
        					
        					
        					

        					for(int k = stackContents.size()-1; k>=0; k--){
        						stack2.push(stackContents.get(k));
        					}

        					stack2.push(w);
        					stack2.push(newWord);

        					queue.add(stack2);


        					
        					

        					


        				} arr[y]=origChar;

        			}

        	}


        	
        	


        		



        		

        	
        }
        return level;

    }



    public static void main(String[] args){
    	/*ArrayList <String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")); 

    	System.out.println(ladderLength("hit","cog",wordList));*/

/*
    	HashSet <String> hs = new HashSet<String>();
    	Queue <Stack> queue = new LinkedList<>();
    	String word = "bye";

    	hs.add("fly");
    	hs.add("bye");
    	hs.add("lie");

    	for(String x: hs){
    		Stack<String> stack = new Stack<String>();
    		stack.push(x);
    		stack.push(word);
    		queue.add(stack);
    	}

    	System.out.println(queue);
*/
    	List <String> wordList = new ArrayList<String>();

    	String fileName = "dictionary3.txt";
		EasyReader inFile = new EasyReader(fileName);	
   	
   		if (inFile.bad())
   		{
     		System.err.println("Can't open " + fileName);	
     		System.exit(1);
   		}
   		String word;
		while (!inFile.eof())
   		{
   			word = inFile.readWord();
   			
   			if (word != null)
   			{
   				wordList.add(word);
   			}
   		}
   		Scanner sc = new Scanner(System.in);
   		System.out.print("Enter start word: ");
   		String startWord = sc.next();
   		System.out.print("Enter end word: ");
   		String targetWord = sc.next();
   		//System.out.println("Start = "+startWord+ " end = "+targetWord); 


    	//List <String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"); 
    	System.out.println(ladderLength(startWord,targetWord,wordList));
    }

}