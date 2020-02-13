package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import java.util.Iterator;
import java.util.SortedSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class LagsTest
{

  @Test
  public void exampleFromKata() {

    Lags lags = getExampleLags();

    assertThat(lags.getBestTotalPrice(), equalTo(18));
  }

  private Lags getExampleLags() {
    Lags lags = new Lags();
    lags.addFlight("AF514", 0, 5, 10);
    lags.addFlight("CO5", 3, 7, 14);
    lags.addFlight("AF515", 5, 9, 7);
    lags.addFlight("BA01", 6, 9, 8);
    return lags;
  }

  @Test
  public void treeForExampleLagsHasTwoRoots() {
    Lags lags = getExampleLags();
    Lags.Tree tree = lags.getTree();
    SortedSet<Lags.TreeNode> roots = tree.getRoots();
    assertThat(roots, hasSize(2));
    Iterator<Lags.TreeNode> iter = roots.iterator();
    assertThat(iter.next().getFlight().getName(), equalTo("AF514"));
    assertThat(iter.next().getFlight().getName(), equalTo("CO5"));
  }

  @Test
  public void firstRootHasTwoChildren() {
    Lags lags = getExampleLags();
    Lags.Tree tree = lags.getTree();
    SortedSet<Lags.TreeNode> roots = tree.getRoots();
    Lags.TreeNode firstRoot = roots.iterator().next();
    SortedSet<Lags.TreeNode> children = firstRoot.getChildren();
    assertThat(children, hasSize(2));

    Iterator<Lags.TreeNode> iter = children.iterator();
    assertThat(iter.next().getFlight().getName(), equalTo("AF515"));
    assertThat(iter.next().getFlight().getName(), equalTo("BA01"));
  }
}
