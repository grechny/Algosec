package by.grechny.algosec.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SentenceChecker {

  private final DictionaryService dictionaryService;

  public SentenceChecker(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  public boolean isValidSentence(String sentence) {
    boolean result = false;

    for (int i = 1; i <= dictionaryService.getTheLongestWordSize() && i <= sentence.length(); i++) {
      result = isValidSentence(sentence.substring(0, i), sentence.substring(i, sentence.length()));
      if (result) {
        break;
      }
    }

    return result;
  }

  private boolean isValidSentence(String word, String sentence) {
    boolean result;

    result = dictionaryService.existsInDictionary(word);
    if (result && !StringUtils.isEmpty(sentence)) {
      result = isValidSentence(sentence);
    }

    return result;
  }
}
