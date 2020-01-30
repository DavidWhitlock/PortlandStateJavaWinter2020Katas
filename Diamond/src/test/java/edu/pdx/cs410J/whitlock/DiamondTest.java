package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiamondTest
{

  @Test
  public void diamondForLetterA() {
    String expected = new DiamondBuilder().
      line("A")
      .create();
    assertThat(Diamond.diamondFor('A'), equalTo(expected));
  }

  @Ignore
  @Test
  public void diamondForLetterB() {
    String expected = new DiamondBuilder().
      line(" A ").
      line("B B").
      line(" A ").
      create();

    assertThat(Diamond.diamondFor('B'), equalTo(expected));
  }

  @Test
  public void diamondForLetterC() {
    String expected = new DiamondBuilder().
      line("  A  ").
      line(" B B ").
      line("C   C").
      line(" B B ").
      line("  A  ").
      create();

    assertThat(Diamond.diamondFor('C'), equalTo(expected));
  }

  @Test
  public void lettersForLinesOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getLetterForLine(1), equalTo('A'));
    assertThat(diamond.getLetterForLine(2), equalTo('B'));
    assertThat(diamond.getLetterForLine(3), equalTo('C'));
    assertThat(diamond.getLetterForLine(4), equalTo('B'));
    assertThat(diamond.getLetterForLine(5), equalTo('A'));
  }

  @Test
  public void externalPaddingForLinesOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getExternalPaddingForLine(1), equalTo(2));
    assertThat(diamond.getExternalPaddingForLine(2), equalTo(1));
    assertThat(diamond.getExternalPaddingForLine(3), equalTo(0));
    assertThat(diamond.getExternalPaddingForLine(4), equalTo(1));
    assertThat(diamond.getExternalPaddingForLine(5), equalTo(2));
  }

  @Test
  public void internalPaddingForLineOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getInternalPaddingForLine(2), equalTo(1));
    assertThat(diamond.getInternalPaddingForLine(3), equalTo(3));
    assertThat(diamond.getInternalPaddingForLine(4), equalTo(1));
  }

  @Test
  public void firstLineOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getLine(1), equalTo("  A  "));
    assertThat(diamond.getLine(5), equalTo("  A  "));
  }

  @Test
  public void secondLineOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getLine(2), equalTo(" B B "));
    assertThat(diamond.getLine(4), equalTo(" B B "));
  }

  @Test
  public void middleLineOfCDiamond() {
    Diamond diamond = new Diamond('C');
    assertThat(diamond.getLine(3), equalTo("C   C"));
  }

  @Test
  public void widthForAIs1() {
    assertThat(Diamond.diamondSizeFor('A'), equalTo(1));
  }

  @Test
  public void widthForBIs3() {
    assertThat(Diamond.diamondSizeFor('B'), equalTo(3));
  }

  @Test
  public void widthForCIs5() {
    assertThat(Diamond.diamondSizeFor('C'), equalTo(5));
  }

  private DiamondBuilder line(String line) {
    return new DiamondBuilder();
  }

  private class DiamondBuilder {
    private final StringBuilder sb = new StringBuilder();

    DiamondBuilder line(String line) {
      sb.append(line);
      sb.append('\n');
      return this;
    }

    public String create() {
      return sb.toString();
    }
  }
}
