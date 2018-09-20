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

import javax.xml.ws.Action;

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

        oplyaButton.setOnAction( event -> {
            outText.clear();
            String preview = previewFild.getText();
            boolean[] chDevice = {checkDesk.isSelected(), checkPlansh.isSelected(), checkMob.isSelected()};
            //System.out.println("вошёл в ивент");
            outText.appendText("Всплывашка по доскроллу:\n");
            outText.appendText(PreviewCreater.checkBoxes(chDevice,preview,"Oplya") + '\n');
        });
    }
}