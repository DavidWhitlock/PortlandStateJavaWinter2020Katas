package edu.pdx.cs410J.whitlock;

import java.util.ArrayList;
import java.util.Arrays;
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
    char[][] cell = getCell(0);
    Number number = Number.getNumberForCell(cell);
    return number.getNumberValue();
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

  enum Number {
    NUMBER_1(1, new char[][] {
      new char[] {' ', ' ', ' '},
      new char[] {' ', ' ', '|'},
      new char[] {' ', ' ', '|'}
    }),

    NUMBER_2(2, new char[][] {
      new char[] {' ', '_', ' '},
      new char[] {' ', '_', '|'},
      new char[] {'|', '_', ' '}
    })

    ;

    private final int numberValue;
    private final char[][] cells;

    Number(int numberValue, char[][] cells) {
      this.numberValue = numberValue;
      this.cells = cells;
    }

    public static Number getNumberForCell(char[][] cell) {
      for (Number number : values()) {
        if (equals(number.cells, cell)) {
          return number;
        }
      }

      return null;
    }

    private static boolean equals(char[][] array1, char[][] array2) {
      if (array1.length != array2.length) {
        return false;
      }

      for (int i = 0; i < array1.length; i++) {
        if (!Arrays.equals(array1[i], array2[i])) {
          return false;
        }
      }
      return true;
    }

    public int getNumberValue() {
      return numberValue;
    }
  }

}