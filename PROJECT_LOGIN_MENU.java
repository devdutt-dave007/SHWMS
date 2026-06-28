import java.util.Scanner;

public class PROJECT_LOGIN_MENU
{
    Scanner sc = Input.sc;
    static String red,green,cyan,magenta,yellow,peach,lavender,mint,skyblue,coral,reset,bold,underline,italic;
    //input variables
    String name,phone_number,password,gender,bp;
    int age,act_level,dayCount;
    double height,weight;
    String diabetes,cardiac;
    //calculated variables
    double bmi,water_level,sleep_hours,heart_rate;
    double base_a,bmi_a,act_fact;
    static String choice;
    static int x = 0;
    PROJECT_LOGIN_MENU()
    {
        this.red = colour.red;
        this.green = colour.green;
        this.cyan = colour.cyan;
        this.magenta = colour.magenta;
        this.yellow = colour.yellow;
        this.reset =colour.reset;
        this.bold = colour.bold;
        this.underline = colour.underline;
        this.peach = colour.peach;
        this.lavender = colour.lavender;
        this.mint =colour.mint;
        this.skyblue = colour.skyblue;
        this.coral = colour.coral;
        this.italic = colour.italic;

        while (x == 0)
        {
            System.out.println(bold+lavender+italic+underline+"\nWelcome to the Smart Health🩺 and Wellness💪 Monitoring System");
            System.out.println(" Monitor\uD83D\uDCCA• Analyze🔍 • Improve📈 "+reset);
            System.out.println(cyan+"\nAre you already a user \uD83D\uDC64❓ ");
            System.out.println("Enter \n'Yes' for existing user  \n'No' for login as a new user"+reset);
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) x = 1;
            else if (choice.equalsIgnoreCase("no")) x = 2;
            else System.out.println(coral+"Enter only 'yes' or 'no' ⚠️");
        }
    }

    public static void main()
    {
        //PROJECT_LOGIN_MENU ob = new PROJECT_LOGIN_MENU();
        calculate m = new calculate();
        if (x == 2)
        {
            m.login();
            m.update(m);
        }
        else
        {
            m = m.data_base();
            m.update(m);
        }
        m.calculator();
        menu mn=new menu();
        mn.menu_build(m);
    }
}