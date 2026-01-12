package org.bluej.network;

public class NetworkApp {

  /**
   * Main method to demonstrate the NewsFeed class.
   *
   * @param args Command line arguments, not used.
   */
  public static void main(String[] args) {
    NewsFeed feed = new NewsFeed();
    feed.addMessagePost(new MessagePost("Arne", "Hello, world!"));
    feed.addMessagePost(new MessagePost("Leif", "Fun day out today!"));
    feed.addPhotoPost(new PhotoPost("Jon", "bilde.jpg", "Sunset"));
    feed.addPhotoPost(new PhotoPost("Lise", "mountain.jpg", "Hike"));

    feed.show();
  }
}
