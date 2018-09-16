package sample;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PreviewCreater {

    private static String[] line = new String[] {"https://www.autonews.ru/", "https://www.autonews.ru/news/5b8d1b449a79477e7db5e43a/",
            "https://www.rbc.ru/", "https://www.rbc.ru/economics/03/09/2018/5b86dbeb9a7947a42c448ca5/",
            "https://quote.rbc.ru/", "https://quote.rbc.ru/news/article/5b8d420e9a79478a8ce28e28/",
            "https://sportrbc.ru/", "https://sportrbc.ru/news/5b8d39e79a7947881a6090cd/",
            "https://style.rbc.ru/", "https://style.rbc.ru/life/5b8929359a79473211c2cde9/",
            "http://tv.rbc.ru/", "http://tv.rbc.ru/archive/ekskluziv/5b8d05ce2ae5964d74b55104/",
            "https://pink.rbc.ru/", "https://pink.rbc.ru/lifestyle/5b8998bb9a7947526bd5b704/",
            "http://zoom.cnews.ru/", "http://zoom.cnews.ru/publication/item/60892/"};


    private static String onlyMob(String prw, String bannerType)
    {
        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

        //System.out.println("логика пройдена");
        switch (bannerType) {
            case "Billboard":
            case "240x400_left":
                int p = new Random().nextInt((line.length - 2) / 2); //рандомная площадка (кроме Zoom)

                if (p % 2 == 1) { return line[p - 1] + prw + "\n" + line[p] + prw + "\n"; }
                else { return line[p] + prw + "\n" + line[p + 1] + prw + "\n"; }

            case "Native":
                for (String aLine : line) {
                    if (aLine.contains("://www.rbc.ru")) {
                        mass[k] = aLine;
                        k++;
                    }
                }
                break;
            case "InterScroll":
                for (String aLine : line) {
                    if (aLine.contains("//www.rbc.ru") || aLine.contains("https://pink.rbc.ru/")) /*+ если что-то внедрят*/
                    {
                        mass[k] = aLine;
                        k++;
                    }
                }
                break;
        }
        //Общий вывод для 1 устройства
        for (int i = 0; i < k; i++) {
            str.append(mass[i]).append(prw).append('\n');
        }
        return str.toString();
    }

    private static String onlyTab(String prw, String bannerType)
    {

        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

        //Биллборд
        if (bannerType.equals("Billboard")) {
            for (String aLine : line) {
                if (aLine.contains("//www.rbc.ru") || aLine.contentEquals("https://style.rbc.ru") ||
                        aLine.contentEquals("https://pink.rbc.ru/") || aLine.contentEquals("https://quote.rbc.ru/"))
                {   mass[k] = aLine; k++;}
            }
        }
        // Баннер 240х400 слева (или на моб в ленте новостей)
        else if (bannerType.equals("240x400_left"))
        {
            for (String aLine2 : line) {
                if (aLine2.contains("://www.rbc.ru"))
                {   mass[k] = aLine2; k++;}
            }
        }
        //Общий вывод для 1 устройства
        for (int i = 0; i < k; i++) {
            str.append(mass[i]).append(prw).append('\n');
        }
        return str.toString();
    }


    public static String checkBoxes(boolean[] Dvc, String prw, String bannerType) {
        //System.out.println("вошёл в функцию");

        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

        //Проверка на вшивость
        if (Dvc[2] || Dvc[1] || Dvc[0])

            /*//МОБ+ПЛАНШ или ДЕСК+ПЛАНШ
            if ((!Dvc[0] && Dvc[1] && Dvc[2]) || (Dvc[0] && Dvc[1] && !Dvc[2]))
            {
                if (!Dvc[0] && Dvc[1] && !Dvc[2])
                    return "";
            }*/


            // ТОЛЬКО МОБИЛЬНЫЙ
            if (Dvc[2] && !Dvc[1] && !Dvc[0]) {return onlyMob(prw, bannerType);}

            //ТОЛЬКО ПЛАНШЕТ
            if (Dvc[1] && !Dvc[0] && !Dvc[2]) {return onlyTab(prw, bannerType);}

/*            //ТОЛЬКО ДЕСК
            if (Dvc[0] && !Dvc[1] && !Dvc[2])*/

        else return "Пожалуйста, выберите устройство";
    }
}
