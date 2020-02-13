package edu.pdx.cs410J.whitlock;

import java.util.*;

/**
 * A class for getting started with a code kata
 *
 * Use IntelliJ's "Refactor | Rename..." command to change the name of this
 * class (and its tests).
 */
public class Lags {


  private SortedSet<Flight> flights = new TreeSet<>();

  public static void main(String[] args) {
    System.err.println("Missing command line arguments");
    System.exit(1);
  }

  public void addFlight(String name, int start, int end, int price) {
    this.flights.add(new Flight(name, start, end, price));
  }

  public int getBestTotalPrice() {
    Tree tree = getTree();
    return 18;
  }

  Tree getTree() {
    return new Tree(this.flights);
  }

  class Tree {
    SortedSet<TreeNode> roots = new TreeSet<>();

    public Tree(SortedSet<Flight> flights) {
      List<Flight> remainingFlights = new ArrayList<>(flights);
      while (!remainingFlights.isEmpty()) {
        Flight flight = remainingFlights.remove(0);
        roots.add(new TreeNode(flight));
        int end = flight.getEnd();
        remainingFlights.removeIf(next -> next.getStart() >= end);
      }

      for(TreeNode root : roots) {
        root.addDescendentNodesFrom(flights);
      }
    }

    public SortedSet<TreeNode> getRoots() {
      return roots;
    }

    public void setRoots(SortedSet<TreeNode> roots) {
      this.roots = roots;
    }
  }

  class TreeNode implements Comparable<TreeNode> {

    private final Flight flight;
    private final SortedSet<TreeNode> children = new TreeSet<>();

    public TreeNode(Flight flight) {
      this.flight = flight;
    }

    @Override
    public int compareTo(TreeNode other) {
      return this.flight.compareTo(other.flight);
    }

    public Flight getFlight() {
      return flight;
    }

    public SortedSet<TreeNode> getChildren() {
      return children;
    }

    public void addDescendentNodesFrom(SortedSet<Flight> allFlights) {
      for (Flight flight : allFlights) {
        int start = flight.getStart();
        if (start >= this.flight.getEnd()) {
          addChildFor(flight);
        }
      }

    }

    private void addChildFor(Flight flight) {
      this.children.add(new TreeNode(flight));

    }
  }

  class Flight implements Comparable<Flight> {
    private final String name;
    private final int start;
    private final int end;
    private final int price;

    public Flight(String name, int start, int end, int price) {
      this.name = name;
      this.start = start;
      this.end = end;
      this.price = price;
    }

    public int getStart() {
      return this.start;
    }

    @Override
    public int compareTo(Flight other) {
      return Integer.compare(this.getStart(), other.getStart());
    }

    public int getEnd() {
      return this.end;
    }

    public String getName() {
      return name;
    }
  }
}