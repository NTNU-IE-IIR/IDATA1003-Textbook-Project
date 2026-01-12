package org.bluej.network;

import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application.
 *
 * <p>Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 *
 * <p>This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.2
 */
public class NewsFeed {
  private ArrayList<Post> posts;

  /**
   * Construct an empty news feed.
   */
  public NewsFeed() {
    posts = new ArrayList<>();
  }

  /**
   * Add a post to the news feed.
   *
   * @param post The post to be added.
   */
  public void addPost(Post post) {
    posts.add(post);
  }

  /**
   * Show the news feed. Currently: print the news feed details
   * to the terminal. (To do: replace this later with display
   * in web browser.)
   */
  public void show() {
    // display all posts
    for (Post post : posts) {
      post.display();
      System.out.println();   // empty line between posts
    }
  }

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
