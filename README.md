Purpose:
This java program produces a comma-delimited list of numbers and it groups numbers into a range when they are sequential.

Testing:
To conduct unit testing, I have used Maven, an automation tool that contains information about this java project. 
Maven creates a POM.xml file where I added JUnit as a dependency to test if my program's functionality and correctness.

Time complexity:
This algorithm runs in O(n) because you need to examine each number to determine whether it is sequential or not.
Therefore, examining all input data is necessary.

Space complextiy:
The space complexity is also O(n) since you need to store input numbers and number ranges in an array.
