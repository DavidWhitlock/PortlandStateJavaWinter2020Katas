package edu.pdx.cs410J.whitlock;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class OCRKata {

  private OCRKata() {

  }

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  int getAccountNumber() {
    return 0;
  }

  static class Builder {
    private OCRKata ocr = new OCRKata();

    void line(String line) {


    }

    OCRKata build() {
      return this.ocr;
    }
  }
}