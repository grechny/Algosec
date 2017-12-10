package by.grechny.algosec.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SentenceCheckerTest {

  @Autowired
  private SentenceChecker sentenceChecker;

  @Test
  public void isValidSentenceTest() {
    String sentence = "ihaveacar";
    assertTrue(sentenceChecker.isValidSentence(sentence));

    sentence = "iahveacra";
    assertTrue(sentenceChecker.isValidSentence(sentence));

    sentence = "a";
    assertTrue(sentenceChecker.isValidSentence(sentence));

    sentence = "ihaveaca";
    assertFalse(sentenceChecker.isValidSentence(sentence));

    sentence = "iaveacar";
    assertFalse(sentenceChecker.isValidSentence(sentence));
  }
}