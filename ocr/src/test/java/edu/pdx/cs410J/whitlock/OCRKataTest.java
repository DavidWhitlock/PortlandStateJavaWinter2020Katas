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

}
