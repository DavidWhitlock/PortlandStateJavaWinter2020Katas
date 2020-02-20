package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OCRKataTest
{

  @Test
  @Ignore
  public void exampleFromKata() {
    OCRKata.Builder builder = new OCRKata.Builder();
    builder.line("    _  _     _  _  _  _  _ ");
    builder.line("  | _| _||_||_ |_   ||_||_|");
    builder.line("  ||_  _|  | _||_|  ||_| _|");

    OCRKata ocr = builder.build();
    assertThat(ocr.getAccountNumber(), equalTo(123456789));
  }

  @Test
  public void ocrFirstCellOf1() {
    OCRKata.Builder builder = new OCRKata.Builder();
    builder.line("   ");
    builder.line("  |");
    builder.line("  |");

    OCRKata ocr = builder.build();
    char[][] cell = ocr.getCell(0);
    assertThat(cell[0], equalTo(new char[] {' ', ' ', ' '}));
    assertThat(cell[1], equalTo(new char[] {' ', ' ', '|'}));
    assertThat(cell[2], equalTo(new char[] {' ', ' ', '|'}));
  }

  @Test
  public void ocrFirstCellOf2() {
    OCRKata.Builder builder = new OCRKata.Builder();
    builder.line("    _ ");
    builder.line("  | _|");
    builder.line("  ||_ ");

    OCRKata ocr = builder.build();
    char[][] cell = ocr.getCell(1);
    assertThat(cell[0], equalTo(new char[] {' ', '_', ' '}));
    assertThat(cell[1], equalTo(new char[] {' ', '_', '|'}));
    assertThat(cell[2], equalTo(new char[] {'|', '_', ' '}));
  }

  @Test
  public void canRecognizeTheNumber1() {
    char[][] cellForNumber1 = new char[][] {
      new char[] {' ', ' ', ' '},
      new char[] {' ', ' ', '|'},
      new char[] {' ', ' ', '|'}
    };

    assertThat(OCRKata.Number.getNumberForCell(cellForNumber1), equalTo(OCRKata.Number.NUMBER_1));
  }

  @Test
  public void canRecognizeTheNumber2() {
    char[][] cellForNumber2 = new char[][] {
      new char[] {' ', '_', ' '},
      new char[] {' ', '_', '|'},
      new char[] {'|', '_', ' '}
    };

    assertThat(OCRKata.Number.getNumberForCell(cellForNumber2), equalTo(OCRKata.Number.NUMBER_2));
  }

  @Test
  public void accountNumber1() {
    OCRKata.Builder builder = new OCRKata.Builder();
    builder.line("   ");
    builder.line("  |");
    builder.line("  |");

    OCRKata ocr = builder.build();
    assertThat(ocr.getAccountNumber(), equalTo(1));

  }

}
