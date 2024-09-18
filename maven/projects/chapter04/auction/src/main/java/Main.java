/**
 * The startingpoint of the application. This class holds the
 * main()-method amking it possible to open and run the project in a professional IDE
 */
public class Main {
  public static void main(String[] args) {
   // Create an Auction
    Auction auction = new Auction();

    // Add some lots to the auction
    auction.enterLot("Picasso");
    auction.enterLot("Van Gogh");
    auction.enterLot("Rembrandt");
    auction.enterLot("Teapot");

    // List all the lots
    auction.showLots();

    // Create a bidder
    Person bidder = new Person("Hans");

    // Make some bids
    auction.makeABid(1, bidder, 100);

    // Show the auction status
    auction.showLots();

    // Get the bidder of the first lot
    System.out.println("The name of the highest bidder of lot no 1:");
    Person person = auction.getLot(1).getHighestBid().getBidder();
    System.out.println("The bidder of the first lot is: " + person.getName());

  }
}
