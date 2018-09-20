package sample;

import java.lang.*;
import java.util.Random;

import static sample.ConsoleColors.RED;
import static sample.ConsoleColors.RESET;
import static sample.URLs.*;

class PreviewCreater {

    private static String[] line = new String[] {"https://www.autonews.ru/", "https://www.autonews.ru/news/5b8d1b449a79477e7db5e43a/",
            "https://www.rbc.ru/", "https://www.rbc.ru/economics/03/09/2018/5b86dbeb9a7947a42c448ca5/",
            "http://tv.rbc.ru/", "http://tv.rbc.ru/archive/chez/5b9bdcf92ae5965edf641d34/",
            "https://www.rbc.ru/newspaper/", "https://www.rbc.ru/newspaper/2018/09/13/5b990d8b9a79472dad3da224/",
            "https://www.rbc.ru/magazine/", "https://www.rbc.ru/magazine/2018/09/5b76f3579a79472aed2d8cba/",
            "https://quote.rbc.ru/", "https://quote.rbc.ru/news/article/5b8d420e9a79478a8ce28e28/",
            "https://sportrbc.ru/", "https://sportrbc.ru/news/5b8d39e79a7947881a6090cd/",
            "https://style.rbc.ru/", "https://style.rbc.ru/life/5b8929359a79473211c2cde9/",
            "https://pink.rbc.ru/", "https://pink.rbc.ru/lifestyle/5b8998bb9a7947526bd5b704/",
            "https://realty.rbc.ru/", "https://realty.rbc.ru/news/5ba0efcc9a79476817a47f23/",
            "http://zoom.cnews.ru/", "http://zoom.cnews.ru/publication/item/60892/"};

    private static int myRand (String[] mass)
    {
        return new Random().nextInt(mass.length/3);
    }

    private static int myRand(int start, int end)
    {
        return new Random().nextInt((end-1) - start +1) + start;
    }

    /*private static void contURL (String[] urls, int k) {
        String arr1[] = new String[line.length];
        for (String aLine : line) {
            for (int i = 0; i < line.length; i++)
                if (aLine.contains(urls[i])) {
                    k++;
                    arr1[k] = aLine;
                }
        }
    }*/

    private static String onlyMob(String prw, String bannerType)
    {
        String s;
        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

        //System.out.println("логика пройдена");
        switch (bannerType) {
            case "Billboard":
            case "240x400_left":
                int p = myRand(line); //рандомная площадка (-кроме Zoom)
                if (p % 2 == 1) { s = line[p - 1] + prw + "\n" + line[p] + prw + "\n"; }
                else { s = line[p] + prw + "\n" + line[p + 1] + prw + "\n"; }
                return ("МОБ:") + "\n" + s;

            case "Native":
                for (String aLine : line) {
                    if (aLine.contains(NEWS)) {
                        mass[k] = aLine;
                        k++;
                    }
                }
                break;
            case "InterScroll":
                for (String aLine : line) {
                    if (aLine.contains(NEWS) || aLine.contains(PINK)) /*+ если что-то внедрят*/
                    {
                        mass[k] = aLine;
                        k++;
                    }
                }
                break;
            case ("Branding"):
                return "На МОБ нет брендирования!";
            case "Oplya":
                return "Error 404";
        }
        //Общий вывод для 1 устройства
        for (int i = 0; i < k; i++) {
            str.append(mass[i]).append(prw).append('\n');
        }
        return ("МОБ:") + "\n" + str.toString();
    }

    private static String onlyTab(String prw, String bannerType)
    {
        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

        switch (bannerType) {
            //Биллборд
            case ("Billboard"):
                for (String aLine : line) {
                    if ((aLine.contains(NEWS) || aLine.contentEquals(STYLE) ||
                            aLine.contentEquals(PINK) || aLine.contentEquals(QUOTE)) && !(aLine.contains(MAGAZINE) || aLine.contains(NEWSPAPER))) {
                        mass[k] = aLine;
                        k++;
                    }
                }
                break;
                // Баннер 240х400 слева (или на моб в ленте новостей)
            case ("240x400_left"):
                for (String aLine2 : line) {
                    if (aLine2.contains(NEWS)) {
                        mass[k] = aLine2;
                        k++;
                    }
                }
                break;
            case "InterScroll":
            case "Native":
            case "Oplya":
                return "error 404";//"На ПЛАНШ нет интерскролла!";
            case "Branding":
                return "На ПЛАНШ нет брендирования!";
            case "Right":
                return Right(prw, bannerType);
            case "Fullscreen":
                return Full(prw, bannerType);
        }
        //Общий вывод для 1 устройства
        for (int i = 0; i < k; i++) {
            str.append(mass[i]).append(prw).append('\n');
        }
        return ("ПЛАНШ:") + "\n" + str.toString();

    }

    private static String onlyPC(String prw, String bannerType)
    {
        String mass[] = new String[line.length];
        StringBuilder str = new StringBuilder();
        int k = 0;

            //Биллборд
        switch (bannerType) {
            case "Billboard":
                for (String aLine : line) {
                    if (aLine.contains(NEWS) || aLine.contains(TV) || aLine.contains(MAGAZINE) || aLine.contains(NEWSPAPER)) {
                        mass[k] = aLine;
                        ++k;
                    }
                }
                int p = myRand(mass);
                if (p % 2 == 1) {
                    mass[0] = mass[p - 1];
                    mass[1] = mass[p];
                    k = 2;
                }   //Значения 2 и т.д. будут перезаписываться
                else {
                    mass[0] = mass[p];
                    mass[1] = mass[p + 1];
                    k = 2;
                }    //Значения 2 и т.д. будут перезаписываться

                for (String aLine : line) {
                    if (aLine.contains(AUTO)) {
                        mass[k] = aLine;
                        k++;
                    }
                }

                for (String aLine : line) {
                    if (aLine.contains(STYLE) || aLine.contains(PINK)) {
                        mass[k] = aLine;
                        k++;
                    }
                }
                p = myRand(4, k);
                if (p % 2 == 1) {
                    mass[4] = mass[p - 1];
                    mass[5] = mass[p];
                    k = 6;
                }   //Значения 6 и т.д. будут перезаписываться
                else {
                    mass[4] = mass[p];
                    mass[5] = mass[p + 1];
                    k = 6;
                }    //Значения 6 и т.д. будут перезаписываться

                for (String aLine : line) {
                    if (aLine.contains(SPORT) || aLine.contains(REALTY)) {
                        mass[k] = aLine;
                        k++;
                    }
                }
                p = myRand(6, k);
                if (p % 2 == 1) {
                    mass[6] = mass[p - 1];
                    mass[7] = mass[p];
                } else {
                    mass[6] = mass[p];
                    mass[7] = mass[p + 1];
                }
                k -= 2;
                break;

            //Фуллскрин
            case "Fullscreen":
            case "240x400_left":
            case "Branding":
                String s;
                p = myRand(line); //рандомная площадка (-кроме Zoom)
                if (p % 2 == 1) {
                    s =  line[p - 1] + prw + "\n" + line[p] + prw + "\n"; }
                else { s = line[p] + prw + "\n" + line[p + 1] + prw + "\n"; }
                s += line[line.length - 2] + prw + '\n' + line[line.length-1] + prw + "\n";
                return ("ДЕСК:") + "\n" +  s;
            case "Native":
                return "ДЕСК" + '\n' + "Error 404" + '\n';
            case "Right":
                return Right(prw, bannerType);
            case ("InterScroll"):
                return "На ДЕСК нет интерскролла!";

        }

        //Общий вывод для 1 устройства
        for (int i = 0; i < k; i++) {
            str.append(mass[i]).append(prw).append('\n');
        }
        return ("ДЕСК:") + "\n" + str.toString();

    }

    //Для всех гаджетов объединенный вывод 240х400 или 300х600 справа
    private static String Right(String prw, String bannerType)
    {
        String mass[] = new String[31];
        StringBuilder str = new StringBuilder();
        int k = 0;
        if (bannerType.equals("Right")) {
            //Будет выводится без рандома!! (NEW!)
            for (String aLine : line) {
                if (aLine.contains(NEWS) && !aLine.contains(MAGAZINE) && !aLine.contains(NEWSPAPER)) {
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(QUOTE)) {
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(TV) || aLine.contains(MAGAZINE) || aLine.contains(NEWSPAPER) ||
                        aLine.contains(SPORT) || aLine.contains(REALTY)) {
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(AUTO)) {
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(STYLE) || aLine.contains(PINK)) {
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(ZOOM)) {
                    mass[k] = aLine;
                    k++;
                }
            }

            //Общий вывод для 1 устройства
            for (int i = 0; i < k; i++) {
                if (mass[i] != null)
                    str.append(mass[i]).append(prw).append('\n');
                else
                    str.append('\n');
            }
            return ("ДЕСК, ПЛАНШ, МОБ:") + "\n" + str.toString();
        }
        return prw;
    }

    //Для МОБ и ПЛАНШ Fullscreen
    private static String Full(String prw, String bannerType)
    {
        String mass[] = new String[31];
        StringBuilder str = new StringBuilder();
        int k = 0;
        if (bannerType.equals("Fullscreen")) {
            for (String aLine : line) {
                if (aLine.contains(STYLE) || aLine.contains(PINK)){
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;
            for (String aLine : line) {
                if (aLine.contains(QUOTE)){
                    mass[k] = aLine;
                    k++;
                }
            }
            k++;

            int p = myRand(line); //рандомная площадка (-кроме Zoom)
            if (p % 2 == 1) { mass[k] = line[p - 1]; mass[k+1] = line[p]; k+=2; }
            else { mass[k] = line[p]; mass[k+1] = line[p + 1]; k+=2; }

            //Общий вывод для 1 устройства
            for (int i = 0; i < k; i++) {
                if (mass[i] != null)
                    str.append(mass[i]).append(prw).append('\n');
                else
                    str.append('\n');
            }
            return ("ПЛАНШ, МОБ:") + "\n" + str.toString();
        }
        return prw;
    }

    static String checkBoxes(boolean[] Dvc, String prw, String bannerType) {
        //System.out.println("вошёл в функцию");

        String mass[] = new String[31];
        StringBuilder str = new StringBuilder();
        int k = 0;

        //Проверка на вшивость
        if (Dvc[2] || Dvc[1] || Dvc[0])

            //Все 3 гаджета
            if (Dvc[0] && Dvc[1] && Dvc[2]) {
                switch (bannerType){
                    case ("Right"):
                        return Right(prw, bannerType);
                    case ("Billboard"):
                    case ("240x400_left"):
                        return onlyPC(prw, bannerType) + '\n' + onlyTab(prw, bannerType) + '\n' + onlyMob(prw, bannerType);
                    case ("Branding"):
                        return onlyPC(prw, bannerType) + '\n' + "На ПЛАНШ и МОБ нет брендирования!";
                    case ("InterScroll"):
                        return "На ДЕСК и ПЛАНШ нет интерскролла!" + "\n" + onlyMob(prw, bannerType);
                    case ("Fullscreen"):
                        return onlyPC(prw, bannerType) + '\n' + Full(prw,bannerType);
                    case "Native":
                    case "Oplya":
                        return "Error 404";
                }
            }

            //МОБ+ПЛАНШ или ДЕСК+ПЛАНШ
            if ((!Dvc[0] && Dvc[1] && Dvc[2]) || (Dvc[0] && Dvc[1] && !Dvc[2])) {
                //МОБ+ПЛАНШ
                if (!Dvc[0] && Dvc[1] && Dvc[2]) {
                    switch (bannerType) {
                        case ("Fullscreen"):
                            return Full(prw, bannerType);
                        case ("Billboard"):
                            return onlyTab(prw, bannerType) + '\n' + onlyMob(prw, bannerType);
                        case ("Native"):
                            return onlyMob(prw, bannerType);
                        case ("240x400_left"):
                            return onlyTab(prw, bannerType) + '\n' + onlyMob(prw, bannerType);
                        case ("Right"):
                            return Right(prw, bannerType);
                        case ("InterScroll"):
                            return "На ПЛАНШ нет интерскролла!" + "\n" + onlyMob(prw, bannerType);
                        case ("Branding"):
                            return "На ПЛАНШ и МОБ нет брендирования!";
                        case "Oplya":
                            return "Error 404";
                    }
                }

                //ДЕСК+ПЛАНШ
                if (Dvc[0] && Dvc[1] && !Dvc[2]) {
                    switch (bannerType) {
                        case ("Fullscreen"):
                            return onlyPC(prw, bannerType) + '\n' + Full(prw, bannerType);
                        case ("Billboard"):
                            return onlyPC(prw, bannerType) + '\n' + onlyTab(prw, bannerType);
                        //case ("Native"):
                        //return onlyPC(prw, bannerType) + '\n' + onlyTab(prw, bannerType);
                        case ("240x400_left"):
                            return onlyPC(prw, bannerType) + '\n' + onlyTab(prw, bannerType);
                        case ("Right"):
                            return Right(prw, bannerType);
                        case ("InterScroll"):
                            return "На ДЕСК и ПЛАНШ нет интерскролла!";
                        case ("Branding"):
                            return onlyPC(prw, bannerType) + '\n' + "На ПЛАНШ нет брендирования!";
                        case "Native":
                        case "Oplya":
                            return "Error 404";
                    }

                }
            }

            //ДЕСК+МОБ
            else if (Dvc[0] && !Dvc[1] && Dvc[2]) {
                switch (bannerType) {
                    case ("Fullscreen"):
                        return onlyPC(prw, bannerType) + '\n' + Full(prw, bannerType);
                    case ("Billboard"):
                    case ("240x400_left"):
                    case "Native":
                    case "Oplya":
                        return onlyPC(prw, bannerType) + '\n' + onlyMob(prw, bannerType);
                    //case ("Native"):
                    //return onlyPC(prw, bannerType) + '\n' + onlyTab(prw, bannerType);
                    case ("Right"):
                        return Right(prw, bannerType);
                    case ("InterScroll"):
                        return "На ДЕСК нет интерскролла!" + '\n' + onlyMob(prw, bannerType);
                    case ("Branding"):
                        return onlyPC(prw, bannerType) + '\n' + "На МОБ нет брендирования!";
                }
            }

            // ТОЛЬКО МОБИЛЬНЫЙ
            if (Dvc[2] && !Dvc[1] && !Dvc[0]) {return onlyMob(prw, bannerType);}

            //ТОЛЬКО ПЛАНШЕТ
            if (Dvc[1] && !Dvc[0] && !Dvc[2]) {return onlyTab(prw, bannerType);}

            //ТОЛЬКО ДЕСК
            if (Dvc[0] && !Dvc[1] && !Dvc[2]) {return onlyPC(prw, bannerType);}

        else return  "Пожалуйста, выберите хотя бы одно устройство";
    }
}