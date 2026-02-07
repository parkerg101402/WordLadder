# Word Ladder Solver

A Java implementation of a Word Ladder problem solver using Breadth-First Search (BFS) algorithm. This project demonstrates the use of stacks and queues data structures to find the shortest transformation path between two words by changing one letter at a time.

## 📋 Overview

The Word Ladder problem is a classic computer science problem where you need to transform one word into another by changing one letter at a time, with each intermediate word being a valid word from a dictionary. This implementation uses BFS to find the shortest path between the start and target words.

**Example:** Transform "hit" → "cog" through valid words:
- hit → hot → dot → dog → cog

## 🎯 Features

- **BFS Algorithm**: Uses Breadth-First Search to find the shortest path
- **Queue of Stacks**: Maintains transformation paths using a queue containing stacks
- **Dictionary Support**: Reads words from a dictionary file (`dictionary3.txt`)
- **Interactive Input**: Prompts user for start and end words
- **Path Tracking**: Displays the complete transformation path
- **Custom Data Structures**: Includes implementations of Stack and Queue

## 🏗️ Project Structure

```
StacksAndQueues/
├── WordLadder.java          # Main word ladder solver
├── EasyReader.java          # File reading utility class
├── MyStack.java             # Array-based stack implementation
├── MyQueue.java             # Array-based queue implementation
├── MyLinkedStack.java       # LinkedList-based stack implementation
├── MyLinkedQueue.java       # LinkedList-based queue implementation
├── RPNCalc.java             # Reverse Polish Notation calculator
├── dictionary3.txt          # Dictionary file with valid words
└── README.md                 # This file
```

## 🚀 How It Works

1. **Initialization**: Reads all words from the dictionary file into a HashSet for O(1) lookup
2. **BFS Traversal**: 
   - Starts with the begin word in a stack
   - Uses a queue to store stacks representing different paths
   - At each level, generates all possible one-letter variations
   - Checks if variations are valid dictionary words
   - Adds valid words to new stacks and enqueues them
3. **Path Finding**: Returns the shortest path length and prints the transformation sequence

## 💻 Usage

### Compilation

```bash
javac WordLadder.java EasyReader.java
```

### Execution

```bash
java WordLadder
```

### Example Session

```
Enter start word: hit
Enter end word: cog
[hit, hot, dot, dog, cog]
5
```

The output shows:
- The transformation path in brackets
- The length of the path (number of steps)

## 📚 Data Structures

### Stack Implementations

- **MyStack**: Array-based stack with fixed size
- **MyLinkedStack**: Dynamic stack using LinkedList

### Queue Implementations

- **MyQueue**: Array-based queue with fixed size
- **MyLinkedQueue**: Dynamic queue using LinkedList

## 🔍 Algorithm Details

The algorithm uses a **BFS (Breadth-First Search)** approach:

1. **Queue Structure**: Each element in the queue is a Stack containing a path from start word to current word
2. **Level-by-Level**: Processes all words at the same transformation distance before moving to the next level
3. **Word Generation**: For each word, generates all possible one-letter variations (a-z for each position)
4. **Validation**: Checks if generated words exist in the dictionary and haven't been used before
5. **Path Tracking**: Maintains the complete transformation path in each stack

## 📝 Key Methods

### `ladderLength(String beginWord, String endWord, List<String> wordList)`
- Main algorithm implementation
- Returns the length of the shortest transformation path
- Returns -1 if no path exists
- Prints the transformation path when found

## 🛠️ Requirements

- Java JDK 8 or higher
- Dictionary file (`dictionary3.txt`) in the same directory

## 📖 Educational Value

This project demonstrates:
- **BFS Algorithm**: Understanding breadth-first search traversal
- **Data Structures**: Practical use of stacks and queues
- **Graph Theory**: Word ladder as a graph problem
- **String Manipulation**: Character-level word transformations
- **File I/O**: Reading from dictionary files

## 🎓 Course Context

This project was developed as part of an independent computer science course focusing on:
- Stack and Queue data structures
- Algorithm implementation
- Problem-solving techniques

## 📄 License

This is an educational project. Feel free to use and modify for learning purposes.

## 👤 Author

Grant Parker

---

**Note**: Make sure `dictionary3.txt` is in the same directory as the compiled classes when running the program.

