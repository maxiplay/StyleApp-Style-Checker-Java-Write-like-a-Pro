package com.org.watsonwrite.writersdiet;
import java.util.HashSet;

//TODO add a function that takes one word and returns it with a color code.
//TODO also create function to color code a sentence

public class WritersDiet {
	private int junkGrade;
	private int adjectiveGrade;
	private int prepositionGrade;
	private int verbGrade;
	private int nounGrade;
	private double junkPercent;
	private double adjectivePercent;
	private double prepositionPercent;
	private double verbPercent;
	private double nounPercent;
	
	private HashSet<String> junkList = new HashSet<String>();
	private HashSet<String> adjectiveList = new HashSet<String>();
	private HashSet<String> prepositionList = new HashSet<String>();
	private HashSet<String> verbList = new HashSet<String>();
	private HashSet<String> nounList = new HashSet<String>();
	private double junkCount = 0.0D;
	private double adjectiveCount = 0.0D;
	private double prepositionCount = 0.0D;
	private double verbCount = 0.0D;
	private double nounCount = 0.0D;
	private String[] junk = { "this", "that", "it", "there" };
	private String[] adjectives = { "able", "ac", "al", "ant", "ary", "ent",
			"ful", "ible", "ic", "ive", "less", "ly", "ous" };
	private String[] prepositions = { "in", "by", "for", "of", "to", "whether",
			"from", "before", "over", "along", "through", "until", "with",
			"on", "under", "after", "around", "up" };
	private String[] verbs = { "am", "is", "are", "was", "were", "be", "been",
			"youve", "its", "youre", "im", "ive" };
	private String[] nouns = { "ion", "ism", "ty", "ment", "ness", "ance",
			"ence", "ments", "ions", "isms", "tys", "ances", "ences" };
	private long wordCount;
	private String[] words;

	public WritersDiet(String s) {
		text2Words(s);
		wordCount();
		findBadWords();
		countPercentages();
		judgeResults();
	}

	public WritersDiet() {
	}

	public void runProgram(String s) {
		text2Words(s);
		wordCount();
		findBadWords();
		countPercentages();
		judgeResults();
	}

	public HashSet<String> getList(String s) {
		if (s == "noun") {
			return this.nounList;
		}
		if (s == "verb") {
			return this.verbList;
		}
		if (s == "preposition") {
			return this.prepositionList;
		}
		if (s == "adjective") {
			return this.adjectiveList;
		}
		return this.junkList;
	}

	public HashSet<String> getNouns() {
		return this.nounList;
	}

	public HashSet<String> getVerbs() {
		return this.verbList;
	}

	public HashSet<String> getPrepositions() {
		return this.prepositionList;
	}
	
	public HashSet<String> getAdjectives() {
		return this.adjectiveList;
	}

	public HashSet<String> getJunk() {
		return this.junkList;
	}

	public void printResults() {
		System.out.printf(
				"Nouns: \t\t%.2f \t %s \t%s\n",
				new Object[] { Double.valueOf(this.nounPercent),
						Double.valueOf(this.nounCount),
						grade2Letter(this.nounGrade) });
		System.out.printf(
				"Verbs: \t\t%.2f \t %s \t%s\n",
				new Object[] { Double.valueOf(this.verbPercent),
						Double.valueOf(this.verbCount),
						grade2Letter(this.verbGrade) });
		System.out.printf(
				"Prepositions: \t%.2f \t %s \t%s\n",
				new Object[] { Double.valueOf(this.prepositionPercent),
						Double.valueOf(this.prepositionCount),
						grade2Letter(this.prepositionGrade) });
		System.out.printf(
				"Adjectives: \t%.2f \t %s \t%s\n",
				new Object[] { Double.valueOf(this.adjectivePercent),
						Double.valueOf(this.adjectiveCount),
						grade2Letter(this.adjectiveGrade) });
		System.out.printf(
				"Junk: \t\t%.2f \t %s \t%s\n",
				new Object[] { Double.valueOf(this.junkPercent),
						Double.valueOf(this.junkCount),
						grade2Letter(this.junkGrade) });
	}

	public String getNounGrade() {
		return grade2Letter(this.nounGrade);
	}

	public double getNounCount() {
		return this.nounCount;
	}

	public double getNounPercent() {
		return this.nounPercent;
	}

	public String getVerbGrade() {
		return grade2Letter(this.verbGrade);
	}

	public double getVerbCount() {
		return this.verbCount;
	}

	public double getVerbPercent() {
		return this.verbPercent;
	}

	public String getPrepositionGrade() {
		return grade2Letter(this.prepositionGrade);
	}

	public double getPrepositionCount() {
		return this.prepositionCount;
	}

	public double getPrepositionPercent() {
		return this.prepositionPercent;
	}

	public String getAdjectiveGrade() {
		return grade2Letter(this.adjectiveGrade);
	}

	public double getAdjectiveCount() {
		return this.adjectiveCount;
	}

	public double getAdjectivePercent() {
		return this.adjectivePercent;
	}

	public String getJunkGrade() {
		return grade2Letter(this.junkGrade);
	}

	public double getJunkCount() {
		return this.junkCount;
	}

	public double getJunkPercent() {
		return this.junkPercent;
	}

	public void judgeResults() {
		if ((this.nounPercent >= 3.5D) && (this.nounPercent < 4.5D)) {
			this.nounGrade = 2;
		} else if ((this.nounPercent >= 4.5D) && (this.nounPercent < 5.5D)) {
			this.nounGrade = 3;
		} else if ((this.nounPercent >= 5.5D) && (this.nounPercent < 6.5D)) {
			this.nounGrade = 4;
		} else if (this.nounPercent >= 6.5D) {
			this.nounGrade = 5;
		} else {
			this.nounGrade = 1;
		}
		if ((this.verbPercent >= 2.5D) && (this.verbPercent < 3.5D)) {
			this.verbGrade = 2;
		} else if ((this.verbPercent >= 3.5D) && (this.verbPercent < 4.5D)) {
			this.verbGrade = 3;
		} else if ((this.verbPercent >= 4.5D) && (this.verbPercent < 5.5D)) {
			this.verbGrade = 4;
		} else if (this.verbPercent >= 5.5D) {
			this.verbGrade = 5;
		} else {
			this.verbGrade = 1;
		}
		if ((this.prepositionPercent >= 14.5D)
				&& (this.prepositionPercent < 15.5D)) {
			this.prepositionGrade = 2;
		} else if ((this.prepositionPercent >= 15.5D)
				&& (this.prepositionPercent < 16.5D)) {
			this.prepositionGrade = 3;
		} else if ((this.prepositionPercent >= 16.5D)
				&& (this.prepositionPercent < 17.5D)) {
			this.prepositionGrade = 4;
		} else if (this.prepositionPercent >= 17.5D) {
			this.prepositionGrade = 5;
		} else {
			this.prepositionGrade = 1;
		}
		if ((this.adjectivePercent >= 6.5D) && (this.adjectivePercent < 7.5D)) {
			this.adjectiveGrade = 2;
		} else if ((this.adjectivePercent >= 7.5D)
				&& (this.adjectivePercent < 8.5D)) {
			this.adjectiveGrade = 3;
		} else if ((this.adjectivePercent >= 8.5D)
				&& (this.adjectivePercent < 9.5D)) {
			this.adjectiveGrade = 4;
		} else if (this.adjectivePercent >= 9.5D) {
			this.adjectiveGrade = 5;
		} else {
			this.adjectiveGrade = 1;
		}
		if ((this.junkPercent >= 2.5D) && (this.junkPercent < 3.5D)) {
			this.junkGrade = 2;
		} else if ((this.junkPercent >= 3.5D) && (this.junkPercent < 4.5D)) {
			this.junkGrade = 3;
		} else if ((this.junkPercent >= 4.5D) && (this.junkPercent < 5.5D)) {
			this.junkGrade = 4;
		} else if (this.junkPercent >= 5.5D) {
			this.junkGrade = 5;
		} else {
			this.junkGrade = 1;
		}
	}

	public void countPercentages() {
		this.nounPercent = (this.nounCount / this.wordCount * 100.0D);
		this.verbPercent = (this.verbCount / this.wordCount * 100.0D);
		this.prepositionPercent = (this.prepositionCount / this.wordCount * 100.0D);
		this.adjectivePercent = (this.adjectiveCount / this.wordCount * 100.0D);
		this.junkPercent = (this.junkCount / this.wordCount * 100.0D);
	}

	public static boolean stringInArrayContains(String inputString,
			String[] items) {
		for (int i = 0; i < items.length; i++) {
			if (inputString.contains(items[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean stringInArrayEnds(String inputString, String[] items) {
		for (int i = 0; i < items.length; i++) {
			if (inputString.endsWith(items[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean stringInArrayEquals(String inputString, String[] items) {
		for (int i = 0; i < items.length; i++) {
			if (inputString.equals(items[i])) {
				return true;
			}
		}
		return false;
	}

	public String text2Html() {
		/**
		 * Thu Dec 17 02:34:14 AEDT 2015
		 * Could change this from HTML to a list of Java color codes.
		 */
		String totalString = "";
		String[] arrayOfString;
		int j = (arrayOfString = this.words).length;
		for (int i = 0; i < j; i++) {
			String word = arrayOfString[i];
			if (stringInArrayEnds(word, this.nouns)) {
				totalString =

				totalString + "<span style='background-color:#6db1ff'>" + word
						+ "</span>";
			} else if (stringInArrayEquals(word, this.verbs)) {
				totalString = totalString
						+ "<span style='background-color:#ff8b44'>" + word
						+ "</span>";
			} else if (stringInArrayEquals(word, this.prepositions)) {
				totalString = totalString
						+ "<span style='background-color:#6be201'>" + word
						+ "</span>";
			} else if (stringInArrayEnds(word, this.adjectives)) {
				totalString = totalString
						+ "<span style='background-color:#fdde4b'>" + word
						+ "</span>";
			} else if (stringInArrayEquals(word, this.junk)) {
				totalString = totalString
						+ "<span style='background-color:#966dff'>" + word
						+ "</span>";
			} else {
				totalString = totalString + word;
			}
			totalString = totalString + " ";
		}

		return totalString;
	}

	public void text2Words(String s) {
		this.words = s.split("\\s+");
		int singleCount = 0;
		String[] arrayOfString;
		int j = (arrayOfString = this.words).length;
		for (int i = 0; i < j; i++) {
			String x = arrayOfString[i];
			x = x.replaceAll("[^\\p{L}\\p{Nd}]+", "");
			this.words[singleCount] = x.toLowerCase();
			singleCount++;
		}

		
	}

	public void wordCount() {
		this.wordCount = this.words.length;
	}

	public void findBadWords() {
		/**
		 * speed up this section:
		 * instead of analysing the entire of array list of words,
		 * analyse only the new words added.
		 */
		String[] arrayOfString1;
		int j = (arrayOfString1 = this.words).length;
		for (int i = 0; i < j; i++) {
			String word = arrayOfString1[i];
			String[] arrayOfString2;
			int m = (arrayOfString2 = this.nouns).length;
			for (int k = 0; k < m; k++) {
				String nounWord = arrayOfString2[k];
				if (word.endsWith(nounWord)) {
					this.nounCount += 1.0D;
					this.nounList.add(nounWord);
				}
			}
			m = (arrayOfString2 = this.verbs).length;
			for (int k = 0; k < m; k++) {
				String verbWord = arrayOfString2[k];
				if (word.equals(verbWord)) {
					this.verbCount += 1.0D;
					this.verbList.add(verbWord);
				}
			}
			m = (arrayOfString2 = this.prepositions).length;
			for (int k = 0; k < m; k++) {
				String prepositionWord = arrayOfString2[k];
				if (word.equals(prepositionWord)) {
					this.prepositionCount += 1.0D;
					this.prepositionList.add(prepositionWord);
				}
			}
			m = (arrayOfString2 = this.adjectives).length;
			for (int k = 0; k < m; k++) {
				String adjectiveWord = arrayOfString2[k];
				if (word.endsWith(adjectiveWord)) {
					this.adjectiveCount += 1.0D;
					this.adjectiveList.add(adjectiveWord);
				}
			}
			m = (arrayOfString2 = this.junk).length;
			for (int k = 0; k < m; k++) {
				String junkWord = arrayOfString2[k];
				if (word.equals(junkWord)) {
					this.junkCount += 1.0D;
					this.junkList.add(junkWord);
				}
			}
		}
	}

	public String grade2Letter(double grade) {
		if (grade == 1.0D) {
			return "Lean";
		}
		if (grade == 2.0D) {
			return "Fit and Trim";
		}
		if (grade == 3.0D) {
			return "Needs Toning";
		}
		if (grade == 4.0D) {
			return "Flabby";
		}
		if (grade == 5.0D) {
			return "Heart Attack Territory";
		}
		return "Error";
	}
}
