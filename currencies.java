import java.util.Scanner;

public class currencies {

    public static void main (String args[]){
               
        try (Scanner in = new Scanner (System.in, "UTF-8")) {
             
           double [][] currenciesTable = new double[5][4];
           currenciesTable[0] = new double[]{0.010294, 0.012067, 0.086223, 1.8}; //из RUB в другие
           currenciesTable[1] = new double[]{97.14, 1.17, 8.35, 174.36}; //из EUR в другие
           currenciesTable[2] = new double[]{82.87, 0.8525, 7.12, 148.64}; //из USD в другие
           currenciesTable[3] = new double[]{11.6, 0.1198, 0.1405, 20.88}; //из CNY в другие
           currenciesTable[4] = new double[]{0.5557, 0.005736, 0.006727, 0.047892}; //из JPY в другие

            String [][] currenciesNameTable = new String[5][4];
           currenciesNameTable[0] = new String[]{"EUR","USD","CNY","JPY"}; //из RUB в другие
           currenciesNameTable[1] = new String[]{"RUB","USD","CNY","JPY"}; //из EUR в другие
           currenciesNameTable[2] = new String[]{"RUB","EUR","CNY","JPY"}; //из USD в другие
           currenciesNameTable[3] = new String[]{"RUB","EUR","USD","JPY"}; //из CNY в другие
           currenciesNameTable[4] = new String[]{"RUB","EUR","USD","CNY"}; //из JPY в другие
          
           boolean operation = true;
            while(operation){
                System.out.println("Введите номер вашей валюты: 1 - RUB, 2 - EUR, 3 - USD, 4 - CNY. Или номер 5, чтоб завершить конвертацию в другие валюты.");
                Integer typeYourCurrencies;
                 if (in.hasNextInt()) {typeYourCurrencies = in.nextInt()-1;}
                else {operation = false; continue;}
                
                if (typeYourCurrencies<4) {
                    System.out.println("Введите вашу сумму (целым числом): ");
                    Integer yourSum;
                    if (in.hasNextInt()) {yourSum = in.nextInt();}
                    else {System.out.println("Неккоректный ввод, повторите попытку."); continue;}

                    System.out.println("Ваша сумма в других валютах: "
                    +currenciesNameTable[typeYourCurrencies][0]+": "+Math.round(yourSum*currenciesTable[typeYourCurrencies][0]*100.0)/100.0+"  "
                    +currenciesNameTable[typeYourCurrencies][1]+": "+Math.round(yourSum*currenciesTable[typeYourCurrencies][1]*100.0)/100.0+"  "
                    +currenciesNameTable[typeYourCurrencies][2]+": "+Math.round(yourSum*currenciesTable[typeYourCurrencies][2]*100.0)/100.0+"  "
                    +currenciesNameTable[typeYourCurrencies][3]+": "+Math.round(yourSum*currenciesTable[typeYourCurrencies][3]*100.0)/100.0+"\n"
                    );
                }
                else operation = false;            
            }
            
        }
    }
}


