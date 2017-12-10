package by.grechny.algosec;

import by.grechny.algosec.services.SentenceChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgosecApplication implements CommandLineRunner {

  @Autowired
  private SentenceChecker sentenceChecker;

  public static void main(String[] args) {
    SpringApplication.run(AlgosecApplication.class, args);
  }

  @Override
  public void run(String... strings) {
    for (String string : strings) {
      String result;
      if (sentenceChecker.isValidSentence(string)) {
        result = "a valid";
      } else {
        result = "not a valid";
      }

      System.out.println(string + " is " + result + " sentence");
    }
  }
}
