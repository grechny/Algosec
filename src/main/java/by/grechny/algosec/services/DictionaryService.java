package by.grechny.algosec.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DictionaryService {

  private Set<String> dictionary = new HashSet<>();
  private int maxLenght = 0;

  /**
   * Fill the dictionary set by sorted words from file
   */
  public DictionaryService() {
    try {
      InputStream is = new ClassPathResource("dictionary").getInputStream();
      InputStreamReader isr = new InputStreamReader(is, Charset.forName("UTF-8"));
      BufferedReader br = new BufferedReader(isr);

      String word;
      while ((word = br.readLine()) != null) {
        dictionary.add(sortString(word));
        if (maxLenght < word.length()) {
          maxLenght = word.length();
        }
      }
      br.close();
    } catch (IOException e) {
      log.error("Can't fill dictionary: {}", e.getMessage());
    }
  }

  public boolean existsInDictionary(String word) {
    return dictionary.contains(sortString(word));
  }

  public int getTheLongestWordSize() {
    return maxLenght;
  }

  private String sortString(String string) {
    char[] charArray = string.toCharArray();
    Arrays.sort(charArray);
    return String.valueOf(charArray);
  }
}