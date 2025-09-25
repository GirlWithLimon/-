import java.util.Scanner;
import java.util.Random;

public class findLetter {

    public static void main (String args[]){
               
        Random random = new Random();
        try (Scanner in = new Scanner (System.in, "UTF-8")) {
            String [] listWords = {"банан", "яблоко", "вишня", "груша"};
            String randomWord = listWords[random.nextInt(listWords.length)];
             
            int hearts = 8;
            char [] word = "-".repeat(randomWord.length()).toCharArray();
            boolean play = true;
            while(play && hearts>0){
                System.out.println("Загаданное слово: "+ new String(word));
                System.out.println("Оставшееся число жизней: "+ hearts);
                System.out.println("Введите букву: ");
                String letterString = in.nextLine().replace(" ", "").toLowerCase();
                char letter = letterString.charAt(0);
                Boolean find =false;
                for(int i = 0; i<randomWord.length();i++){
                    if(letter==randomWord.charAt(i)){find = true; word[i]=letter;}
                }
                if (find) {
                    System.out.println("Буква "+ letter +" есть в слове!");
                    if (new String(word).indexOf('-')<0) {
                        System.out.println("Ты полностью отгадал слово "+ randomWord +"!");
                        play=false;
                    }

                }
                else {System.out.println("Буквы "+ letter +" в слове нет."); hearts--;}
            }
            if(play && hearts<1)  System.out.println("Жизни кончились. Было загадано слово: "+ randomWord +".");


        }
    }
}


