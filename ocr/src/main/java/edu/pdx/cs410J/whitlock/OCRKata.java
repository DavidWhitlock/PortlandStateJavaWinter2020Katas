package edu.pdx.cs410J.whitlock;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class OCRKata {

  private List<char[]> charArrays = new ArrayList<>();

  private OCRKata() {

  }

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  int getAccountNumber() {
    return 0;
  }

  public char[][] getCell(int cellNumber) {
    char[][] cell = new char[3][3];

    for (int row = 0 ; row <= 2; row++) {
      for (int column = 0; column <= 2; column++) {
        setValueOfCell(cell, cellNumber, row, column);
      }
    }

    return cell;
  }

  private void setValueOfCell(char[][] cell, int cellNumber, int row, int column) {
    int arrayColumn = (3 * cellNumber) + column;
    cell[row][column] = charArrays.get(row)[arrayColumn];
  }

  static class Builder {
    private OCRKata ocr = new OCRKata();

    void line(String line) {
      this.ocr.addLine(line);

    }

    OCRKata build() {
      return this.ocr;
    }
  }

  private void addLine(String line) {
    this.charArrays.add(line.toCharArray());
  }
}