package sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.scene.SceneHelper;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField previewFild;

    @FXML
    private Button fullButton;

    @FXML
    private CheckBox checkMob;

    @FXML
    private Button leftButton;

    @FXML
    private Button nativeButton;

    @FXML
    private CheckBox checkDesk;

    @FXML
    private Button billButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button oplyaButton;

    @FXML
    private Button InterButton;

    @FXML
    private TextArea outText;

    @FXML
    private Button brandButton;

    @FXML
    private CheckBox checkPlansh;

    @FXML
    void initialize() {
        //String bannerType;
        //System.out.println("хелп!");
        //System.out.println("В инициализаторе проверил чекбоксы");
        /*boolean chD = checkDesk.isSelected();
        boolean chP = checkPlansh.isSelected();
        boolean chM = checkMob.isSelected();*/

        billButton.setOnAction( event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Биллборд:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Billboard") + '\n');
        });

        leftButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Баннер 240х400 (слева/в Ленте новостей):\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"240x400_left") + '\n');
        });

        nativeButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Нейтив ролл:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Native") + '\n');
        });

        InterButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Интерскроллер:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"InterScroll") + '\n');
        });

        brandButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Брендирование:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Branding") + '\n');
        });

        fullButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Фуллскрин:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Fullscreen") + '\n');
        });

        rightButton.setOnAction(event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("240x400 (300х600) справа:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Right") + '\n');
        });
    }
}


/*
// Preview_creater.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
        #include <iostream>
#include <fstream>
#include <string>
using namespace std;
        const int len = 16;
        const string urls[] =  {"https://www.autonews.ru/", "https://www.autonews.ru/news/5b8d1b449a79477e7db5e43a/",
        "https://www.rbc.ru/","https://www.rbc.ru/economics/03/09/2018/5b86dbeb9a7947a42c448ca5/",
        "https://quote.rbc.ru/", "https://quote.rbc.ru/news/article/5b8d420e9a79478a8ce28e28/",
        "https://sportrbc.ru/", "https://sportrbc.ru/news/5b8d39e79a7947881a6090cd/",
        "https://style.rbc.ru/", "https://style.rbc.ru/life/5b8929359a79473211c2cde9/",
        "http://tv.rbc.ru/", "http://tv.rbc.ru/archive/ekskluziv/5b8d05ce2ae5964d74b55104/",
        "http://zoom.cnews.ru/", "http://zoom.cnews.ru/publication/item/60892/",
        "https://pink.rbc.ru/", "https://pink.rbc.ru/lifestyle/5b8998bb9a7947526bd5b704/"};

        string create_urls(string str)
        {
        string buff;
        for (int i=0; i < len; i++)
        if (i != 0)
        buff += "\n\n" + (urls)[i] + str;
        else
        buff += (urls)[i] + str;
        return buff;
        }

//обращение к строке - string::(<строка>)[<номер строки>]!!

        int main()
        {
        string line;
        ifstream myfile;
        myfile.open("./Previews.txt");
        myfile >> line;
        myfile.close();
//test
	/*string urls2, preview;
	int j = 0;
	for (int i = 1; i < line.length(); i++)
	{
		if (line[i] = 'h') {
			while (line[i] != '\0' && i < line.length()) {
				urls2[j] = 5;
			}
			*/