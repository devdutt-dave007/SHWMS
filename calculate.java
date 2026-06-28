import java.util.Scanner;

class calculate extends PROJECT_LOGIN_MENU
{
    double[] dailyWeight =new double[7],dailySleep =new double[7];
    double[] dailyWaterintake =new double[7];
    int[] dailySteps =new int[7];
    static calculate[] ob=new calculate[10];
    static int userCount=3;

    calculate data_base()
    {
        Scanner sc=Input.sc;
        for(int i=0;i<10;i++)
        {
            ob[i]=new calculate();
        }
        //user 1
        ob[0].name="ABC";
        ob[0].age=18;
        ob[0].gender="1";
        ob[0].bp="3";
        ob[0].phone_number="9999999999";
        ob[0].password=ob[0].name+ob[0].phone_number.substring(7,10);
        ob[0].act_level=2;
        ob[0].height=1.75;
        ob[0].weight=80;
        ob[0].diabetes="no";
        ob[0].cardiac="no";

        //user 2
        ob[1].name="DEF";
        ob[1].age=20;
        ob[1].gender="2";
        ob[1].bp="1";
        ob[1].phone_number="7777777777";
        ob[1].password=ob[1].name+ob[1].phone_number.substring(7,10);
        ob[1].act_level=3;
        ob[1].height=1.65;
        ob[1].weight=60;
        ob[1].diabetes="no";
        ob[1].cardiac="yes";

        //user 2
        ob[2].name="XYZ";
        ob[2].age=60;
        ob[2].gender="1";
        ob[2].bp="2";
        ob[2].phone_number="8888888888";
        ob[2].password=ob[2].name+ob[2].phone_number.substring(7,10);
        ob[2].act_level=1;
        ob[2].height=1.8;
        ob[2].weight=70;
        ob[2].diabetes="yes";
        ob[2].cardiac="yes";

        System.out.println(cyan+"Enter your phone number for verification \uD83D\uDCF1: ");
        String verify=sc.nextLine();
        calculate obx=null;
        boolean checkPhone=false;
        String pass_check=null;
        for(int i=0;i<userCount;i++)
        {
            if(verify.equals(ob[i].phone_number))
            {
                checkPhone=true;
                pass_check=ob[i].password;
                System.out.println(lavender+"Welcome "+ob[i].name+" 😊"+"\nYou have 5 attempts for entering correct password"+reset);
                obx=ob[i];
                break;
            }
        }
        if(checkPhone)
        {
            boolean attempts=true;
            for(int i=0;i<5&&attempts;i++)
            {
                System.out.println(cyan+"\uD83D\uDD11Enter your password attempt "+(i+1)    +" : "+reset);
                String pass_verify=sc.nextLine();
                if(pass_verify.equals(pass_check))
                {
                    attempts=false;
                    break;
                }
                else
                    System.out.println(red+"Wrong password ❌"+reset);

            }
        }
        if(obx==null)
        {
            System.out.println(coral+"\uD83D\uDC64\nCannot find user ❌ \nLogin as a new user\uD83C\uDD95 ✍️"+reset);
            login();
            obx=this;
        }
        return obx;
    }
    void update(calculate x)
    {

        boolean a=true;
        while(a)
        {
            System.out.println(green+"\nHere you can change the following data 🛠️🔁" );
            System.out.println("1. Age ("+x.age+" yrs)");
            System.out.println("2. Weight ("+x.weight+" kgs)");
            System.out.println("3. Height ("+x.height+" m)");
            System.out.println("4. Diabetes ("+x.diabetes+")");
            System.out.println("5. Cardiac issue ("+x.cardiac+")");
            if(x.act_level==1)
                System.out.println("6. Activity level (no activity)");
            else if (act_level==2)
                System.out.println("6. Activity level (mild activity)");
            else
                System.out.println("6. Activity level (Athlete)");
            if(x.bp.equals("1"))
                System.out.println("7. BP (Low BP)");
            else if (x.bp.equals("2"))
                System.out.println("7. BP (High BP)");
            else
                System.out.println("7. Bp (No BP issue)");
            System.out.println("8. Confirm this data and continue");
            System.out.println(peach+"Enter your choice (1-8)\uD83D\uDC49 "+reset);
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    boolean checkAge=true;int oldAge=x.age;
                    while(checkAge)
                    {
                        System.out.println(peach+"Enter your current age : "+reset);
                        x.age=sc.nextInt();
                        if (x.age<0||x.age<oldAge) System.out.println(red+"Enter correct age ⚠️"+reset);
                        else checkAge=false;
                    }
                    break;

                case 2:
                    boolean checkWeight=true;
                    while(checkWeight)
                    {
                        System.out.println(peach+"Enter your current weight(in kg) ⚖️: "+reset);
                        x.weight = sc.nextDouble();
                        if(x.weight<20||x.weight>200) System.out.println(red+"Enter correct weight ⚠️"+reset);
                        else checkWeight=false;
                    }
                    break;

                case 3:
                    boolean checkHeight=true;double oldHeight=x.height;
                    while(checkHeight)
                    {
                        System.out.println(peach+"Enter your current height (in m): "+reset);
                        x.height=sc.nextDouble();
                        if(x.height<0||x.height<oldHeight||x.height>2)System.out.println(red+"Enter correct height⚠️"+reset);
                        else checkHeight=false;
                    }
                    break;
                case 4:
                    boolean checkDiabetes=true;
                    while (checkDiabetes)
                    {  sc.nextLine();
                        System.out.println(peach+"Currently you have diabetes or not?(yes/no) : "+reset);
                        x.diabetes=sc.nextLine();

                        if(x.diabetes.equalsIgnoreCase("yes")||x.diabetes.equalsIgnoreCase("no"))checkDiabetes=false;
                        else System.out.println(red+"Enter correct data yes or no only⚠️ "+reset);
                    }
                    break;

                case 5:
                    boolean checkcardiac=true;
                    while (checkcardiac)
                    {sc.nextLine();
                        System.out.println(peach+"Currently you have cardiac issue or not?(yes/no)\uD83E\uDEC0 : "+reset);
                        x.cardiac=sc.nextLine();

                        if(x.cardiac.equalsIgnoreCase("yes")||x.cardiac.equalsIgnoreCase("no"))checkcardiac=false;
                        else System.out.println(red+"Enter correct data yes or no only⚠️ "+reset);
                    }
                    break;

                case 6:
                    boolean checkActLevel=true;
                    while(checkActLevel)
                    {
                        System.out.println(peach+"Enter your current activity level \n1.No activity\n2.Mild activity\n3.Athelte: "+reset);
                        x.act_level=sc.nextInt();
                        if(x.act_level==1||x.act_level==2||x.act_level==3) checkActLevel=false;
                        else System.out.println(red+"Enter correct data between 1 and 3 ⚠️"+bold);
                    }
                    break;

                case 7:
                    sc.nextLine();
                    boolean checkBp=true;
                    while (checkBp)
                    {
                        System.out.println(peach+"Enter you current bp\nEnter 1 for low bp\nEnter 2 for high bp\nEnter 3 for no : "+reset);
                        x.bp = sc.nextLine();
                        sc.nextLine();
                        if (x.bp.equals("1") || x.bp.equals("2") || x.bp.equals("3")) checkBp = false;
                        else System.out.println(red+"Enter correct data between 1 and 3⚠️ "+reset);

                    }
                    break;
                case 8:
                {
                    a=false;break;
                }
                default:
                {
                    System.out.println(red+bold+"Enter correct choice ⚠️"+reset);
                    break;
                }
            }
        }
    }
    void login()
    {
        boolean checkname=true;
        while(checkname)
        {
            System.out.println(skyblue+"Enter your name"+peach+"\n(It must not consist numbers): "+reset);
            name=sc.nextLine();
            int x=0;
            for(int i=0;i<name.length();i++)
            {
                if(((int)(name.charAt(i))>=65&&(int)(name.charAt(i))<=90)||((int)(name.charAt(i))>=97&&(int)(name.charAt(i))<=122)||(int)(name.charAt(i))==32)
                    name= name.toUpperCase();
                else
                {
                    System.out.println(red+"Enter valid name consisting of alphabets only ⚠️"+reset);
                    x=1;
                    break;
                }
            }
            if(x==0) checkname=false;
        }
        boolean checkNumber=true;
        while(checkNumber) {
            System.out.println(skyblue+"Enter your phone number "+peach+" \n(Number must be 10 digit and start from 9,8,7or6): "+reset);
            phone_number=sc.nextLine();
            if(phone_number.length()!=10||(phone_number.charAt(0)!='9'&&phone_number.charAt(0)!='8'&&phone_number.charAt(0)!='7'&&phone_number.charAt(0)!='6'))
                System.out.println(red + "Enter correct phone number ⚠️" + reset);
            else
                checkNumber=false;
        }
        boolean checkAge=true;
        while(checkAge)
        {
            System.out.println(skyblue+"Enter your current age "+peach+"\n (Range between 12-120 yrs): "+reset);
            age=sc.nextInt();
            if (age<12||age>120)
                System.out.println(red+"Enter correct age ⚠️"+reset);
            else
                checkAge=false;
        }
        sc.nextLine();//Flushing
        boolean checkGender=true;
        while(checkGender)
        {
            System.out.println(skyblue+"Enter gender"+peach+"\n(1 for male,2 for female): "+reset);
            gender=sc.nextLine();
            if(gender.equals("1")||gender.equals("2"))
                checkGender=false;
            else
                System.out.println(red+"Enter correct choice of gender  ⚠️"+reset);
        }
        boolean checkWeight=true;
        while(checkWeight){
            System.out.println(skyblue+"Enter your current weight"+peach+"\n⚖️(Range between 20-200 kgs): "+reset);
            weight=sc.nextDouble();
            if(weight<20||weight>200)
                System.out.println(red+"Enter correct weight data  ⚠️"+reset);
            else
                checkWeight=false;
        }
        boolean checkHeight=true;
        while(checkHeight)
        {
            System.out.println(skyblue+"Enter your current height"+peach+"\n📏(in m): "+reset);
            height=sc.nextDouble();
            if(height<0||height>2)
                System.out.println(red + "Enter correct height⚠️It should range from 0-2 m" + reset);
            else
                checkHeight = false;
        }

        sc.nextLine(); //Flushing
        boolean checkDiabetes=true;
        while(checkDiabetes)
        {
            System.out.println(skyblue+"Do you have diabetes?" +peach+ "\n(yes/no)"+reset);
            diabetes = sc.nextLine();
            if(diabetes.equalsIgnoreCase("yes")||diabetes.equalsIgnoreCase("no"))
                checkDiabetes=false;
            else
                System.out.println(red+"Enter yes or no only⚠️"+reset);
        }
        boolean checkBp=true;
        while (checkBp)
        {
            System.out.println(skyblue+"Do you have blood pressure problems?"+peach+"\nEnter 1 for low bp\nEnter 2 for high bp\nEnter 3 for no"+reset);
            bp = sc.nextLine();
            if(bp.equals("1")||bp.equals("2")||bp.equals("3"))
                checkBp=false;
            else
                System.out.println(red+"Enter correct data between 1 and 3 ⚠️"+reset);
        }

        boolean checkCardiac=true;
        while(checkCardiac)
        {
            System.out.println(skyblue+"Do you have any existing cardiac issues?" +peach+" (yes/no)"+reset);
            cardiac = sc.nextLine();
            if(cardiac.equalsIgnoreCase("yes")||cardiac.equalsIgnoreCase("no"))
                checkCardiac=false;
            else
                System.out.println(red+"Enter yes or no only⚠️"+reset);
        }

        boolean checkActLevel=true;
        while(checkActLevel)
        {
            System.out.println(skyblue+"Enter your activity level :-"+peach+ " \n1.No activity🙅‍♂️\n2.Mild activity🤏\n3.Athelte🏃‍➡️"+reset);
            act_level=sc.nextInt();
            if(act_level==1||act_level==2||act_level==3)
                checkActLevel=false;
            else
                System.out.println(red+"Enter correct data between 1 and 3 ⚠️"+reset);
        }
    }
    void calculator()
    {
        System.out.println(italic+bold+mint+"Okay "+name+" here is some calculated data according to your profile 👉"+reset);
        bmi=weight/(height*height);
        System.out.print(cyan+"BMI\uD83D\uDCCA : "+bmi);
        if(bmi<18.5)
            System.out.println(" Underweight");
        else if(bmi<24.9)
            System.out.println(" Fit");
        else if(bmi<29.9)
            System.out.println(" Overweight");
        else
            System.out.println(" Obese");

        water_level=(weight*35)+(act_level-1)*500+Math.max(0,(height*100 -150)*5);
        System.out.println("Daily avg recommended water intake \uD83D\uDCA7: "+water_level/1000+" L/day");
        if(age<12)
            base_a =9.5;
        else if(age<18)
            base_a=8.5;
        else if(age<55)
            base_a=8;
        else
            base_a=7.5;

        if(act_level==1)act_fact=0;
        else if(act_level==2)act_fact=0.5;
        else act_fact=1;

        if(bmi<18.5)bmi_a=0.25;
        else if(bmi<25)bmi_a=0;
        else if(bmi<30)bmi_a=0.25;
        else bmi_a=0.5;

        sleep_hours=base_a+bmi_a+act_fact;
        System.out.println("Daily avg recommended sleep hours \uD83D\uDE34: "+sleep_hours+" hrs/day"+reset);
        if(cardiac.equalsIgnoreCase("yes")||diabetes.equalsIgnoreCase("yes")||bp.equals("1")||bp.equals("2"))
            System.out.println(coral+bold+"Consult a doctor⚠️ \uD83C\uDFE5\n Due to your medical conditions we cannot calculate your heartbeat range !!!"+reset);
        else
        {
            if(act_level==1)
                act_fact=0.5;
            else if(act_level==2)
                act_fact=0.7;
            else
                act_fact=0.85;
            heart_rate=(220-age)*act_fact;
            System.out.println(cyan+"Max heartbeat per min ❤️\u200D\uD83D\uDD25: "+heart_rate+reset);
        }
    }

}