package by.grechny.algosec.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SentenceChecker {

  private final DictionaryService dictionaryService;

  public SentenceChecker(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  /**
   * The method checks if a sentence includes only valid words
   *
   * The sentence may also include words that are scrambled –
   * a scrambled word is a word that all the original characters
   * of the words appear in it - but in a scrambled way.
   * In addition, the sentence has no spaces between the words
   *
   * @param sentence the sentence that need to check
   * @return true if the sentence is valid and false if not
   */
  public boolean isValidSentence(String sentence) {
    boolean result = false;

    for (int i = 1; i <= dictionaryService.getTheLongestWordLength() && i <= sentence.length(); i++) {
      String word = sentence.substring(0, i);
      String newSentence = sentence.substring(i, sentence.length());

      result = dictionaryService.existsInDictionary(word);
      if (result && !StringUtils.isEmpty(newSentence)) {
        result = isValidSentence(newSentence);
      }

      if (result) {
        break;
      }
    }

    return result;
  }
}
