package sample;

import java.lang.*;

import java.util.ArrayList;

public class PreviewСreater {

    static String[] line = new String[] {"https://www.autonews.ru/", "https://www.autonews.ru/news/5b8d1b449a79477e7db5e43a/",
            "https://www.rbc.ru/", "https://www.rbc.ru/economics/03/09/2018/5b86dbeb9a7947a42c448ca5/",
            "https://quote.rbc.ru/", "https://quote.rbc.ru/news/article/5b8d420e9a79478a8ce28e28/",
            "https://sportrbc.ru/", "https://sportrbc.ru/news/5b8d39e79a7947881a6090cd/",
            "https://style.rbc.ru/", "https://style.rbc.ru/life/5b8929359a79473211c2cde9/",
            "http://tv.rbc.ru/", "http://tv.rbc.ru/archive/ekskluziv/5b8d05ce2ae5964d74b55104/",
            "http://zoom.cnews.ru/", "http://zoom.cnews.ru/publication/item/60892/",
            "https://pink.rbc.ru/", "https://pink.rbc.ru/lifestyle/5b8998bb9a7947526bd5b704/"};



    public static String[] checkBoxes(boolean[] Dvc, String  prw, String bannerType) {

        if ((Dvc[2] == true) && (Dvc[1] && Dvc[2] == false))
        {

        }
        if (Dvc[0] || Dvc[1] || Dvc[2]) {
            if (Dvc[0] && Dvc[1])
                for (int i = 0; i < line.length; i++) {
                    if (line[i].contains("pink.rbc.ru"))
                            System.out.println("lol");
                }
        }
        else System.out.println("Выберите устройтво");
    }
}
