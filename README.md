
# Sort Manager

Sort Manager is a project that takes user input to create a randomised array, sort it using one of four algorithms and return it.


## Usage/Examples

```
Select how many algorithms you want to compare: 
2
Enter array length: 
5
Randomised array: 
[176, 687, 266, 991, 915]
1. Bubblesort
2. Merge Sort
3. Binary Tree Sort
4. Insertion Sort

Choose an algorithm: 
3
1. Bubblesort
2. Merge Sort
3. Binary Tree Sort
4. Insertion Sort

Choose an algorithm: 
4
BINARYTREE Sort: 
[176, 266, 687, 915, 991]
Time taken: 1922000
INSERTION Sort: 
[176, 266, 687, 915, 991]
Time taken: 2013800

Process finished with exit code 0

```


## Features

- User Input: Algorithm amount, Algorithm choice, Array size
- Bubble Sort
- Merge Sort
- Binary Tree Sort
- Insertion Sort
- Timing information to compare sort performance

## Running Tests

To run the tests, JUnit 5.9.0 is required. If using Maven, it can be imported in the pom.xml file:

```xml
  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.9.0</version>
    </dependency>
  </dependencies>
```


## Lessons Learned

1. OOP concepts
2. SOLID principles
3. Interfaces
4. JUnit testing
5. Implemented multiple Design Patterns:
- Factory Pattern
- Singleton Pattern
- MVC (Model View Controller)
