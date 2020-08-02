package SchoolSystem.Login;

import SchoolSystem.MainPage.MainPageController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginController
{


    // .get(0) ==> IPAddress  || .get(1) ==> password  || .get(2) ==> CurrentClass  || .get(3) ==> current rank || .get(4) current name
    // .get(5) language_mark || .get(6) math.mark || .get(7) grammar ||
    // .get(8) literature || .get(9) history || .get(10)  sports .get(11) programming

    // ActiveStudent registered students
    public static HashMap<Integer, List<String>> ActiveStudent = new HashMap<>();

    public static int getIPpos = 0;
    public static int getPassPos = 1;
    public static int getCurrentClassPos = 2;
    public static int getCurrentRank = 3;
    public static int getCurrentName = 4;

    public static int markLanguage = 5;
    public static int markMath= 6;
    public static int markGrammar = 7;
    public static int markLiterature = 8;
    public static int markHistory = 9;
    public static int markSports = 10;
    public static int markProgramming = 11;

    public static boolean getAutenticateStatus (String IPAdress)
    {

        for (Integer StudentID : ActiveStudent.keySet())
        {

            List<String> getIPAdress = ActiveStudent.get(StudentID);

            if ((getIPAdress.get(0).compareTo(IPAdress)) == 0)
                return true;

        }

        return false;
    }

    public static boolean LoginCheck(Integer studentID, String passWord, String IPAdress)
    {

        if (!ActiveStudent.containsKey(studentID))
            return false;

        for (Integer StudentID : ActiveStudent.keySet())
        {

            List<String> data = ActiveStudent.get(StudentID);

            if (data.get(getPassPos).equals(passWord))
            {
                data.set(getIPpos, MainPageController.userIP);
                return true;
            }

        }

        return false;

    }

}
