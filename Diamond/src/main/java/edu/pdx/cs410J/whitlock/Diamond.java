package edu.pdx.cs410J.whitlock;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Diamond {
                                                                                    

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  public static String diamondFor(char letter) {
    return "A\n";
  }

  public static int widthFor(char letter) {
    int distanceFromA = letter - 'A';
    return 2*distanceFromA + 1;
  }
}