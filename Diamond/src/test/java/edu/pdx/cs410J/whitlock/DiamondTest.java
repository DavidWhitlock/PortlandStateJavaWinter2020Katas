package edu.pdx.cs410J.whitlock;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiamondTest
{

  @Test
  public void canInstantiateKataClass() {
    new Diamond();
  }

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

  @Ignore
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
  public void widthForAIs1() {
    assertThat(Diamond.widthFor('A'), equalTo(1));
  }

  @Test
  public void widthForBIs3() {
    assertThat(Diamond.widthFor('B'), equalTo(3));
  }

  @Test
  public void widthForCIs5() {
    assertThat(Diamond.widthFor('C'), equalTo(5));
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
