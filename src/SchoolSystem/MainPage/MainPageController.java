package SchoolSystem.MainPage;

import SchoolSystem.Login.LoginController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainPageController implements Initializable
{
    public static String userIP = null;

    // global
    @FXML
    private AnchorPane home;

    @FXML
    private AnchorPane login_pane;

    @FXML
    private AnchorPane profile_pane;

    @FXML
    private AnchorPane homeworks_pane;

    @FXML
    private JFXButton exit_button;

    @FXML
    private Button admin_button;

    // profile section

    @FXML
    private Label your_name;

    @FXML
    private Label your_class;

    @FXML
    private Label language_ticket;

    @FXML
    private Label math_ticket;

    @FXML
    private Label grammar_ticket;

    @FXML
    private Label lit_ticket;

    @FXML
    private Label history_ticket;

    @FXML
    private Label sports_ticket;

    @FXML
    private Label programming_ticket;

    // login section

    @FXML
    private Label succes_login_username_label;

    @FXML
    private JFXTextField student_id_field;

    @FXML
    private JFXPasswordField password_field;

    @FXML
    private Label avarage_label;

    public void GoBackToHomePage(ActionEvent actionEvent)
    {

        setVisibleMethod(home, true);
        setVisibleMethod(login_pane, false);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, false);

    }

    public void GoToHomeWorksPage(ActionEvent actionEvent)
    {

        if ( (LoginController.getAutenticateStatus(userIP)) == false)
        {
            NotLoggedIn();
            return;
        }

        setVisibleMethod(home, false);
        setVisibleMethod(login_pane, false);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, true);

    }

    public void GoToProfilePage(ActionEvent actionEvent)
    {

        if ( (LoginController.getAutenticateStatus(userIP)) == false)
        {
            NotLoggedIn();
            return;
        }

        setVisibleMethod(home, false);
        setVisibleMethod(login_pane, false);
        setVisibleMethod(profile_pane, true);
        setVisibleMethod(homeworks_pane, false);

    }

    public void GoToLoginPage(ActionEvent actionEvent)
    {

        setVisibleMethod(home, false);
        setVisibleMethod(login_pane, true);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, false);

    }

    private static void setVisibleMethod (AnchorPane pane, boolean visStatus)
    {
        pane.setVisible(visStatus);
    }

    private void NotLoggedIn()
    {
        setVisibleMethod(home, false);
        setVisibleMethod(login_pane, true);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, false);
    }

    public void close_program(ActionEvent actionEvent)
    {

        System.exit(0);

    }

    public void LogOutButton(ActionEvent actionEvent)
    {
    }

    public void StartLogin(ActionEvent actionEvent)
    {

        int StudentID = Integer.parseInt(student_id_field.getText());
        String studentPassword = password_field.getText();

        boolean status = LoginController.LoginCheck(StudentID, studentPassword, this.userIP);

        // succ login
        if ( (status == true) )
        {

            // .get(0) ==> IPAddress  || .get(1) ==> password  || .get(2) ==> CurrentClass  || .get(3) ==> current rank || .get(4) current name
            // .get(5) language_mark || .get(6) math.mark || .get(7) grammar ||
            // .get(8) literature || .get(9) history || .get(10)  sports .get(11) programming

            List<String> dataList = LoginController.ActiveStudent.get(StudentID);

            your_name.setText(dataList.get(LoginController.getCurrentName));

            your_class.setText(dataList.get(LoginController.getCurrentClassPos));

            if ( dataList.get(LoginController.getCurrentRank).equals("Admin") )
            {
                admin_button.setVisible(true);
            }

            succ_login_design();
            succes_login_username_label.setText("Welcome, "+dataList.get(LoginController.getCurrentName));

            language_ticket.setText(dataList.get(LoginController.markLanguage));
            history_ticket.setText(dataList.get(LoginController.markHistory));
            sports_ticket.setText(dataList.get(LoginController.markSports));
            programming_ticket.setText(dataList.get(LoginController.markProgramming));
            lit_ticket.setText(dataList.get(LoginController.markLiterature));
            math_ticket.setText(dataList.get(LoginController.markMath));
            grammar_ticket.setText(dataList.get(LoginController.markGrammar));

            Double avarage = ( (Double.parseDouble(language_ticket.getText()) + Double.parseDouble(history_ticket.getText())
                    +Double.parseDouble(sports_ticket.getText()) + Double.parseDouble(language_ticket.getText()) + Double.parseDouble(programming_ticket.getText())
                    + Double.parseDouble(lit_ticket.getText()) + Double.parseDouble(math_ticket.getText())
                    + Double.parseDouble(grammar_ticket.getText())) / 7 );

            avarage_label.setText("" + String.format("%.2f", avarage) );

        }

    }

    private void succ_login_design()
    {
        setVisibleMethod(home, true);
        setVisibleMethod(login_pane, false);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        setVisibleMethod(home, false);
        setVisibleMethod(login_pane, false);
        setVisibleMethod(profile_pane, false);
        setVisibleMethod(homeworks_pane, false);

        // set IP

        try
        {

            InetAddress address = InetAddress.getLocalHost();

            String ip = ""+address;

            this.userIP = ""+ip.substring(ip.indexOf('/'));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        List<String> data = new ArrayList<>();

        // .get(0) ==> IPAddress  || .get(1) ==> password  || .get(2) ==> CurrentClass  || .get(3) ==> current rank || .get(4) current name
        // .get(5) language_mark || .get(6) math.mark || .get(7) grammar ||
        // .get(8) literature || .get(9) history || .get(10)  sports .get(11) programming

        data.add(""); // please not modified if you not understand why empty.
        data.add("almafa123");
        data.add("10/C");
        data.add("Admin");
        data.add("David KukkelMajer");
        data.add("5");
        data.add("4");
        data.add("3");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("5");

        LoginController.ActiveStudent.put(3232, data);


    }



}
