package com.org.watsonwrite.writersdiet.test;

import com.org.watsonwrite.writersdiet.WritersDiet;

public class testWritersDiet {
	public static void main(String[] args) {
		WritersDiet writediet = new WritersDiet();
		writediet.runProgram("here is some text");
		writediet.printResults();

		writediet.runProgram(
				"This was a not so good revolution of disolution in this of was is a textualization. Here's some very long unwieldy convolution of text that will unbelievably get a really bad score that this will show up as in the results.");
		writediet.printResults();
	}
}
