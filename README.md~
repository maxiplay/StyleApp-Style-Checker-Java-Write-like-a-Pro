# StyleApp-Style-Checker-Java-Write-like-a-Pro
## Basic Description
A style checking library that checks whether your writing is flabby or lean. This library also can identify which parts of your writing are flabby. 
## UML Diagram
![UML diagram of StyleApp class](/writersDietUML.png?raw=true "StyleApp UML Diagram")
## How to use it
### Download the latest JAR file 
The JAR library can be located in the releases link above. There you can find the latest version of this library. 

After downloading the JAR, import it into a Java project, and then you're ready to go!
### To use the object, instantiate it first
```java
import com.org.watsonwrite.writersdiet.WritersDiet;
WritersDiet styleapp = new WritersDiet();
```
### Analyse some text
You can chuck text into the program and it will spit out some results. This program mirrors the Writer's Diet which is an online style checker. If you want to learn more about how this program works, I suggest you check out the Writer's Diet as I modelled this program on it. 

This is how you put text into the program. You can chuck words, sentences, paragraphs, and even entire books into the program. 
```java
styleapp.runProgram("here is some text");
styleapp.printResults();
```

Here are the results for the above code: 
```
Nouns: 		0.00 	 0.0 	Lean
Verbs: 		25.00 	 1.0 	Heart Attack Territory
Prepositions: 	0.00 	 0.0 	Lean
Adjectives: 	0.00 	 0.0 	Lean
Junk: 		0.00 	 0.0 	Lean
```

Here is a more complex example with very flabby style:
```java
styleapp.runProgram("This was a not so good revolution of disolution in this of was is a textualization. Here's some very long unwieldy convolution of text that will unbelievably get a really bad score that this will show up as in the results.");
styleapp.printResults();
```

And here is the output for that code: 
```
Nouns: 		9.76 	 4.0 	Heart Attack Territory
Verbs: 		9.76 	 4.0 	Heart Attack Territory
Prepositions: 	14.63 	 6.0 	Fit and Trim
Adjectives: 	4.88 	 2.0 	Lean
Junk: 		12.20 	 5.0 	Heart Attack Territory
```

The output above means you had 4 rotten words in the Nouns category, 4 in the Verbs, 6 in the Prepositions, 2 in the Adjective, and 5 in the Junk. The Preposition and Adjectives categories came up okay as 'Fit and Trim' and 'Lean'. However, every other category came up as 'Heart Attack', meaning that the writing needs to be improved. 

### How does it work?
The Style App, as with the Writer's Diet, looks for problematic words in your writing and creates a list of ratios for specific problematic categories. For example, if you overuse nominalized nouns like 'revolution', 'specification', 'repatriation', or 'dissolution', you will score highly on the Nouns category. However, if you overuse words like 'this', 'that', or 'it', you will score highly on the Junk category. 


### Can the StyleApp spit out syntax highlighting?
At the moment there is a function in this library that spits out syntax highlighting in the form of HTML code. Yet this functionality is not complete and I will improve this soon and update this library. 

If you want to highlight rotten words in a program you're making, you could just retrieve a list of rotten words in the current text and then manually highlight them in your program. 

