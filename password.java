import java.util.Scanner;
import java.util.Random;

public class password {

    public static void main (String args[]){
               
        Random random = new Random();
        try (Scanner in = new Scanner (System.in, "UTF-8")) {
            System.out.println("Введите число символов в пароле (от 8 до 12): ");
            Integer countSymbol;
            if (in.hasNextInt()) {countSymbol = in.nextInt();}
            else {System.out.println("Неккоректный ввод, повторите попытку."); return;}
            if(countSymbol<8){System.out.println("Неккоректный ввод, повторите попытку."); return;}
            char [] password = new char[countSymbol];
            Integer A=0, a=0, randomPosition, count=0;
            String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String abc = "abcdefghijklmnopqrstuvwxyz";
            String symbols = "!@#$%^&*()_+-={}[]|:;'<>,.?/~`\\\"";

            //генерация случайных заглавных букв и выбор случайного элемента для сохранения при последующих вставках
            Integer i = random.nextInt(countSymbol-3)+1, j;
            for (j=0;j<i;j++) {
                 password[random.nextInt(countSymbol)] = ABC.charAt(random.nextInt(ABC.length()));
            }
            while(A==0){
                A=random.nextInt(countSymbol);
                if(password[A]=='\u0000') A=0;
            }

            for (char c : password) 
                if (c == '\u0000') {
                    count++;
                }
        
           //генерация случайных строчных букв и выбор случайного элемента для сохранения при последующих вставках
            i = random.nextInt(count-2)+1;
            for (j=0;j<i;j++) {
                randomPosition = random.nextInt(countSymbol);
                if(randomPosition.equals(A)) {j--; continue;}
                password[randomPosition] = abc.charAt(random.nextInt(abc.length()));
            }
            while(a==0){
                a=random.nextInt(countSymbol);
                if(password[a]=='\u0000'||!abc.contains(String.valueOf(password[a]))) a=0;
            }

            count=0;
            for (char c : password) 
                if (c == '\u0000') {
                    count++;
                }

             //генерация случайных символов 
            i = random.nextInt(count-1)+1;
            for (j=0;j<i;j++) {
                randomPosition = random.nextInt(countSymbol);
                if(randomPosition.equals(A) || randomPosition.equals(a)) {j--; continue;}
                password[randomPosition] = symbols.charAt(random.nextInt(symbols.length()));
            }
            //генерация случайных цифр в оставшихся пустых полях
            for ( j=0;  j<countSymbol; j++) 
                if (password[j] == '\u0000') {
                    password[j] = (char)('0' + random.nextInt(10));
                }
            System.out.println("Ваш пароль: " +  new String(password));
        }
    }
}


