package de.zabuza.lexisearch.indexing;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link Posting}.
 * 
 * @author Zabuza {@literal <zabuza.dev@gmail.com>}
 *
 */
public final class PostingTest {

  /**
   * Test method for {@link Posting#compareTo(Posting)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testCompareTo() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final Posting posting = new Posting(recordId);
    final Posting anotherPosting = new Posting(anotherRecordId);

    Assert.assertTrue(posting.compareTo(anotherPosting) < 0);
    Assert.assertTrue(anotherPosting.compareTo(posting) > 0);
  }

  /**
   * Test method for {@link Posting#equals(Object)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testEqualsObject() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final Posting posting = new Posting(recordId);
    final Posting anotherPosting = new Posting(anotherRecordId);
    final Posting similarPosting = new Posting(recordId);

    Assert.assertEquals(posting, posting);
    Assert.assertFalse(posting.equals(anotherPosting));
    Assert.assertEquals(posting, similarPosting);
  }

  /**
   * Test method for {@link Posting#getId()}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testGetId() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final Posting posting = new Posting(recordId);
    final Posting anotherPosting = new Posting(anotherRecordId);

    Assert.assertEquals(recordId, posting.getId());
    Assert.assertEquals(anotherRecordId, anotherPosting.getId());
  }

  /**
   * Test method for {@link Posting#getScore()}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testGetScore() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final int termFrequency = 3;
    final int anotherTermFrequency = 4;
    final int score = 5;
    final int anotherScore = 6;
    final Posting posting = new Posting(recordId, termFrequency, score);
    final Posting anotherPosting =
        new Posting(anotherRecordId, anotherTermFrequency, anotherScore);

    Assert.assertEquals(score, posting.getScore(), 0);
    Assert.assertEquals(anotherScore, anotherPosting.getScore(), 0);
  }

  /**
   * Test method for {@link Posting#getTermFrequency()}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testGetTermFrequency() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final int termFrequency = 3;
    final int anotherTermFrequency = 4;
    final Posting posting = new Posting(recordId, termFrequency);
    final Posting anotherPosting =
        new Posting(anotherRecordId, anotherTermFrequency);

    Assert.assertEquals(termFrequency, posting.getTermFrequency());
    Assert.assertEquals(anotherTermFrequency,
        anotherPosting.getTermFrequency());
  }

  /**
   * Test method for {@link Posting#hashCode()}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testHashCode() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final Posting posting = new Posting(recordId);
    final Posting anotherPosting = new Posting(anotherRecordId);
    final Posting similarPosting = new Posting(recordId);

    Assert.assertEquals(posting.hashCode(), posting.hashCode());
    Assert.assertFalse(posting.hashCode() == anotherPosting.hashCode());
    Assert.assertEquals(posting.hashCode(), similarPosting.hashCode());
  }

  /**
   * Test method for {@link Posting#increaseTermFrequency()}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testIncreaseTermFrequency() {
    final int recordId = 1;
    int termFrequency = 3;
    final Posting posting = new Posting(recordId, termFrequency);

    Assert.assertEquals(termFrequency, posting.getTermFrequency());
    termFrequency += 2;
    Assert.assertFalse(termFrequency == posting.getTermFrequency());

    posting.increaseTermFrequency();
    posting.increaseTermFrequency();
    Assert.assertEquals(termFrequency, posting.getTermFrequency());
  }

  /**
   * Test method for {@link Posting#Posting(int)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testPostingInt() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final Posting posting = new Posting(recordId);
    final Posting anotherPosting = new Posting(anotherRecordId);

    Assert.assertEquals(recordId, posting.getId());
    Assert.assertEquals(anotherRecordId, anotherPosting.getId());

    Assert.assertEquals(Posting.DEFAULT_TERM_FREQUENCY,
        posting.getTermFrequency());
    Assert.assertEquals(Posting.DEFAULT_TERM_FREQUENCY,
        anotherPosting.getTermFrequency());

    Assert.assertEquals(Posting.DEFAULT_SCORE, posting.getScore(), 0);
    Assert.assertEquals(Posting.DEFAULT_SCORE, anotherPosting.getScore(), 0);
  }

  /**
   * Test method for {@link Posting#Posting(int, int)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testPostingIntInt() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final int termFrequency = 3;
    final int anotherTermFrequency = 4;
    final Posting posting = new Posting(recordId, termFrequency);
    final Posting anotherPosting =
        new Posting(anotherRecordId, anotherTermFrequency);

    Assert.assertEquals(recordId, posting.getId());
    Assert.assertEquals(anotherRecordId, anotherPosting.getId());

    Assert.assertEquals(termFrequency, posting.getTermFrequency());
    Assert.assertEquals(anotherTermFrequency,
        anotherPosting.getTermFrequency());

    Assert.assertEquals(Posting.DEFAULT_SCORE, posting.getScore(), 0);
    Assert.assertEquals(Posting.DEFAULT_SCORE, anotherPosting.getScore(), 0);
  }

  /**
   * Test method for {@link Posting#Posting(int, int, double)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testPostingIntIntDouble() {
    final int recordId = 1;
    final int anotherRecordId = 2;
    final int termFrequency = 3;
    final int anotherTermFrequency = 4;
    final int score = 5;
    final int anotherScore = 6;
    final Posting posting = new Posting(recordId, termFrequency, score);
    final Posting anotherPosting =
        new Posting(anotherRecordId, anotherTermFrequency, anotherScore);

    Assert.assertEquals(recordId, posting.getId());
    Assert.assertEquals(anotherRecordId, anotherPosting.getId());

    Assert.assertEquals(termFrequency, posting.getTermFrequency());
    Assert.assertEquals(anotherTermFrequency,
        anotherPosting.getTermFrequency());

    Assert.assertEquals(score, posting.getScore(), 0);
    Assert.assertEquals(anotherScore, anotherPosting.getScore(), 0);
  }

  /**
   * Test method for {@link Posting#setScore(double)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testSetScore() {
    final int recordId = 1;
    final int termFrequency = 3;
    double score = 5;
    final Posting posting = new Posting(recordId, termFrequency, score);

    Assert.assertEquals(score, posting.getScore(), 0);
    score += 2;
    Assert.assertFalse(score == posting.getScore());

    posting.setScore(score);
    Assert.assertEquals(score, posting.getScore(), 0);
  }

  /**
   * Test method for {@link Posting#setTermFrequency(int)}.
   */
  @SuppressWarnings("static-method")
  @Test
  public void testSetTermFrequency() {
    final int recordId = 1;
    int termFrequency = 3;
    final Posting posting = new Posting(recordId, termFrequency);

    Assert.assertEquals(termFrequency, posting.getTermFrequency());
    termFrequency += 2;
    Assert.assertFalse(termFrequency == posting.getTermFrequency());

    posting.setTermFrequency(termFrequency);
    Assert.assertEquals(termFrequency, posting.getTermFrequency());
  }

}
