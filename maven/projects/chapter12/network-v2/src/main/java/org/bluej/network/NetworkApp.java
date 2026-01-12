package org.bluej.network;

public class NetworkApp {

  /**
   * Main method to demonstrate the NewsFeed class.
   *
   * @param args Command line arguments, not used.
   */
  public static void main(String[] args) {
    NewsFeed feed = new NewsFeed();
    feed.addPost(new MessagePost("Arne", "Hello, world!"));
    feed.addPost(new MessagePost("Leif", "Fun day out today!"));
    feed.addPost(new PhotoPost("Jon", "bilde.jpg", "Sunset"));
    feed.addPost(new PhotoPost("Lise", "mountain.jpg", "Hike"));

    feed.show();
  }
}
