package edu.pdx.cs410J.whitlock;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Diamond {


  private final int size;
  private final char letter;

  public Diamond(char letter) {
    this.size = diamondSizeFor(letter);
    this.letter = letter;
  }

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  public static String diamondFor(char letter) {
    return new Diamond(letter).createDiamond();
  }

  private String createDiamond() {
    StringBuilder sb = new StringBuilder();
    for (int line = 1; line <= this.size; line++) {
      appendLine(line, sb);
      sb.append("\n");
    }

    return sb.toString();
  }

  public static int diamondSizeFor(char letter) {
    int distanceFromA = letter - 'A';
    return 2 * distanceFromA + 1;
  }

  public String getLine(int lineNumber) {
    return appendLine(lineNumber, new StringBuilder());
  }

  public String appendLine(int lineNumber, StringBuilder sb) {
    pad(sb, getExternalPaddingForLine(lineNumber));

    if (isFirstOrLastLine(lineNumber)) {
      sb.append(getLetterForLine(lineNumber));

    } else {
      sb.append(getLetterForLine(lineNumber));
      pad(sb, getInternalPaddingForLine(lineNumber));
      sb.append(getLetterForLine(lineNumber));
    }

    pad(sb, getExternalPaddingForLine(lineNumber));
    return sb.toString();
  }

  int getInternalPaddingForLine(int lineNumber) {
    int middleLine = (this.size / 2) + 1;
    int distanceFromMiddle = Math.abs(middleLine - lineNumber);
    return middleLine - (2 * distanceFromMiddle);
  }

  private boolean isFirstOrLastLine(int lineNumber) {
    return lineNumber == 1 || lineNumber == this.size;
  }

  private void pad(StringBuilder sb, int padding) {
    for (int i = 0; i < padding; i++) {
      sb.append(" ");
    }
  }

  public char getLetterForLine(int lineNumber) {
    int middleLine = this.letter - 'A' + 1;

    int distanceFromMiddle = Math.abs(middleLine - lineNumber);
    return (char) (this.letter - distanceFromMiddle);
  }

  public int getExternalPaddingForLine(int lineNumber) {
    return Math.abs(((this.size / 2) + 1) - lineNumber);
  }
}