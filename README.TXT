------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

Part 3
Write the void method processGenes that has one parameter sr, which is a StorageResource of strings. 
This method processes all the strings in sr to find out information about them. Specifically, it should:

-print all the Strings in sr that are longer than 9 characters
-print the number of Strings in sr that are longer than 9 characters
-print the Strings in sr whose C-G-ratio is higher than 0.35
-print the number of strings in sr whose C-G-ratio is higher than 0.35
-print the length of the longest gene in sr
Write a method testProcessGenes. This method will call your processGenes method on different test cases. 
Think of five DNA strings to use as test cases. These should include: one DNA string that has some genes longer than 9 characters, 
one DNA string that has no genes longer than 9 characters, one DNA string that has some genes whose C-G-ratio is higher than 0.35, 
and one DNA string that has some genes whose C-G-ratio is lower than 0.35. Write code in testProcessGenes to call processGenes five times with StorageResources made from each of 
your five DNA string test cases.

We have some real DNA for you to test your code on. Download the file brca1line.fa from the DukeLearnToProgram Project Resources page. 
Make sure you save it in your BlueJ project so that your code can access it. 
You can use a FileResource to open the file and the FileResource method asString to convert the contents of the file to a single string so that you can use it like the other DNA 
strings you have been using. Here is an example:

FileResource fr = new FileResource("brca1line.fa");
String dna = fr.asString();
Modify your processGenes method so that it prints all the Strings that are longer than 60 characters and prints the number of Strings that are longer than 60 characters 
(you do not need to make changes to the rest of the method).

Modify the method testProcessGenes to call processGenes with a StorageResource of the genes found in the file brca1line.fa.

