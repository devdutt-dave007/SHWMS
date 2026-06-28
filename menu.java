import java.util.Scanner;

class menu {
    static String red,green,cyan,magenta,yellow,peach,lavender,mint,skyblue,coral,reset,bold,underline,italic;
    static   {
        red = colour.red;
        green = colour.green;
        cyan = colour.cyan;
        magenta = colour.magenta;
        yellow = colour.yellow;
        reset =colour.reset;
        bold = colour.bold;
        underline = colour.underline;
        peach = colour.peach;
        lavender = colour.lavender;
        mint =colour.mint;
        skyblue = colour.skyblue;
        coral = colour.coral;
        italic = colour.italic;
    }
    void menu_build(calculate obj) {
        boolean x = true;
        Scanner sc = Input.sc;
        while (x) {
            System.out.println(magenta+ bold + underline + "\n\uD83D\uDCCB-----MENU-----" + reset);
            System.out.println(lavender + "1.➕Add daily health data");
            System.out.println("2.🏋️‍♂️ Gym plan");
            System.out.println("3.\uD83E\uDD57💪 diet plan suggestions");
            System.out.println("4.🗃️View health report");
            System.out.println("5.🆕Start a new analysis");
            System.out.println("6.Health Score and status");
            System.out.println("7.🎬 Demo Mode (Full Walkthrough)");
            System.out.println("8.\uD83D\uDEAA Exit" + reset);
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    add_daily_health_data(obj);
                    break;
                case 2:
                    Gym_plan(obj);
                    break;
                case 3:
                    diet_plan(obj);
                    break;
                case 4:
                    View_health_report(obj);
                    break;
                case 5:
                    storeUser(obj);
                    System.out.println(mint + "🆕Starting new analysis...\n" + reset);
                    sc.nextLine();
                    // reset login choice so program asks again
                    PROJECT_LOGIN_MENU.x = 0;

                    // restart flow
                    PROJECT_LOGIN_MENU.main();

                    x = false;
                    break;

                case 6:
                    healthscore(obj);break;
                case 7:
                    demoModeFull(obj);
                    break;

                case 8:
                    x = false;
                    System.out.println(bold + mint + "🙏Thank you for using the Health Tracker.\nStay healthy 💪 and see you next time!👋" + reset);
                    break;

                default:
                    System.out.println(red + "Enter correct choice" + reset);
            }
        }
    }

    void storeUser(calculate obj) {
        calculate.ob[calculate.userCount] = obj;
        calculate.userCount++;
        if (calculate.userCount >= 10) System.out.println(red + bold + "Reached user entry limit ⚠️" + reset);
    }

    void add_daily_health_data(calculate obj) {
        if (obj.dayCount >= 7) {
            System.out.println(green + bold + "You have already entered 7 days of data." + reset);
            return;
        }
        Scanner sc = Input.sc;
        System.out.println(skyblue + "Day " + (obj.dayCount + 1) + " data entry:"+reset);
        boolean checkweight = true;
        while (checkweight) {
            System.out.print(magenta+"Enter today's weight (kg)⚖️: "+reset);
            obj.dailyWeight[obj.dayCount] = sc.nextDouble();
            if (obj.dailyWeight[obj.dayCount] < 20 || obj.dailyWeight[obj.dayCount] > 200)
                System.out.println(coral+"Enter correct weight data ⚠️"+reset);
            else checkweight = false;
        }
        boolean checksleep = true;
        while (checksleep) {
            System.out.print(magenta+"Enter hours of sleep: "+reset);
            obj.dailySleep[obj.dayCount] = sc.nextDouble();
            if (obj.dailySleep[obj.dayCount] < 0 || obj.dailySleep[obj.dayCount] > 24)
                System.out.println(coral+"Enter correct data ⚠️"+reset);
            else checksleep = false;
        }
        boolean checkwater = true;
        while (checkwater) {
            System.out.print(magenta+"Enter today's water intake (in l): "+reset);
            obj.dailyWaterintake[obj.dayCount] = sc.nextDouble();
            if (obj.dailyWaterintake[obj.dayCount] < 0 || obj.dailyWaterintake[obj.dayCount] > 15)
                System.out.println(coral+"Enter correct data ⚠️"+reset);
            else checkwater = false;
        }
        boolean checksteps = true;
        while (checksteps) {
            System.out.print(magenta+"Enter steps walked today: "+reset);
            obj.dailySteps[obj.dayCount] = sc.nextInt();
            if (obj.dailySteps[obj.dayCount] < 0 || obj.dailySteps[obj.dayCount] > 20000)
                System.out.println(coral+"Enter correct data ⚠️"+reset);
            else checksteps = false;
        }
        obj.dayCount++;
        System.out.println(mint+"Data saved for Day " + obj.dayCount + reset);

        // If not yet 7 days, inform user how many remain
        if (obj.dayCount < 7)
            System.out.println(peach + (7 - obj.dayCount) + " days of data still to be entered.");
        else
            System.out.println(mint+"✅ All 7 days of data collected!" + reset);
    }

    void Gym_plan(calculate obj) {
        System.out.println(bold + underline + peach+ "----- Personalized Gym Plan -----" + reset);

        // Calculate weekly averages if data exists
        double avgWeight = 0, avgwater = 0, avgSleep = 0;
        int avgSteps = 0;

        if (obj.dayCount > 0) {
            for (int i = 0; i < obj.dayCount; i++) {
                avgwater += obj.dailyWaterintake[i];
                avgWeight += obj.dailyWeight[i];
                avgSleep += obj.dailySleep[i];
                avgSteps += obj.dailySteps[i];
            }
            avgwater /= obj.dayCount;
            avgWeight /= obj.dayCount;
            avgSleep /= obj.dayCount;
            avgSteps /= obj.dayCount;
        } else {
            avgwater = obj.water_level;
            avgWeight = obj.weight; // fallback to base profile
            avgSleep = obj.sleep_hours;
        }

        // Plan based on activity level
        if (obj.act_level == 1) {
            System.out.println(lavender + "• Start with 30 min brisk walk daily");
            System.out.println("• Add light stretching or yoga");
        } else if (obj.act_level == 2) {
            System.out.println("• 45 min cardio (cycling/jogging)");
            System.out.println("• Strength training 3 times a week");
        } else {
            System.out.println("• 60 min intensive training (HIIT, weights)");
            System.out.println("• Professional athlete-level routine" + reset);
        }

        // Adjust plan based on BMI and weekly data
        if (obj.bmi > 25 || avgWeight > obj.weight)
            System.out.println(coral + bold + "⚠️ Focus on fat-burning exercises (HIIT, running, swimming).");
        else if (obj.bmi < 18.5)
            System.out.println("⚠️Focus on strength and muscle gain (weights, resistance training)." + reset);
        else
            System.out.println(mint + "✅ Maintain balanced routine." + reset);

        if (avgSteps < 5000)
            System.out.println(coral + bold + "⚠️ Increase daily walking or cardio to improve activity levels."+reset);

        if (avgSleep < obj.sleep_hours)
            System.out.println(coral+bold+"⚠️ Improve sleep routine for better recovery." + reset);

        if (avgwater < obj.water_level)
            System.out.println(coral+bold+"⚠️ Improve Daily water intake and stay hydrated."+reset);
        System.out.println();
        //GYM plan
        System.out.println(italic+bold+"This is just suggested plan if you have any physical issues consult a trainer"+reset);
        System.out.println(skyblue + bold + underline + "🏋️‍♂️ ===== 7-Day Workout Split Plan =====\n" + reset);
        System.out.println( "📅 Day 1 – Chest + Triceps");
        System.out.println("• Chest: Bench press, push-ups, chest fly, incline press");
        System.out.println("• Triceps: Dips, triceps pushdown, overhead extension\n" );

        System.out.println( "📅 Day 2 – Back + Biceps");
        System.out.println("• Back: Pull-ups, lat pull-down, rows, deadlift");
        System.out.println("• Biceps: Barbell curls, dumbbell curls, hammer curls\n");

        System.out.println( "📅 Day 3 – Shoulders + Abs");
        System.out.println("• Shoulders: Overhead press, lateral raise, front raise, rear delts fly");
        System.out.println("• Abs: Plank, crunches, leg raises, Russian twists\n");

        System.out.println( "📅 Day 4 – Legs + Glutes");
        System.out.println("• Legs: Squats, leg press, lunges, leg curls, calf raises");
        System.out.println("• Glutes: Hip thrusts, glute bridges, step-ups\n" );

        System.out.println( "📅 Day 5 – Upper Chest + Upper Back");
        System.out.println("• Upper Chest: Incline press, cable fly");
        System.out.println("• Upper Back: Face pulls, seated rows, pull-overs\n");

        System.out.println("📅 Day 6 – Arms + Core");
        System.out.println("• Biceps: Preacher curls, concentration curls");
        System.out.println("• Triceps: Skull crushers, close-grip press");
        System.out.println("• Core: Hanging leg raises, bicycle crunch, plank variations\n");

        System.out.println("📅 Day 7 – Rest / Active Recovery");
        System.out.println("• Light walking, stretching, yoga\n");
        if (obj.act_level == 1)
            System.out.println(mint+"✅ Tip: As a beginner have 2-3 sets of each exercise");
        else if (obj.act_level == 2)
            System.out.println("✅ Tip: As a Intermediate have 3-4 sets of each exercise");
        else
            System.out.println("✅ Tip: As a Athlete have 4-5 sets of each exercise" + reset);

        System.out.println(mint + bold + "📈 Progress gradually. Warm up before and stretch after workouts.");
        System.out.println("Remember: consistency is key. Adjust intensity gradually\n" + reset);
    }

    void diet_plan(calculate obj) {
        double BMR, Calories;
        Scanner sc = Input.sc;
        if (obj.bmi < 18.5) {
            System.out.println(bold + skyblue + "You are under weight " + reset);
            System.out.println(peach +italic+ "Suggestion for a weight gain diet are :- ");
            System.out.print("1. Suggested protein intake (Based on body weight and activity level):");
            if (obj.act_level == 1)
                System.out.println(1.2 * obj.weight + " grms/day\n");
            if (obj.act_level == 2)
                System.out.println(1.5 * obj.weight + " grms/day\n");
            if (obj.act_level == 3)
                System.out.println(2 * obj.weight + " grms/day\n" + reset);

            boolean dietCheck = true;
            String diet = null;
            while (dietCheck) {
                System.out.println(cyan+ "Enter \n  1 for vegetarian diet\n  2 for non vegetarian diet " + reset);
                sc.nextLine();
                diet = sc.nextLine();
                if (diet.equals("1") || diet.equals("2")) dietCheck = false;
                else System.out.println(coral + bold + "Enter 1/2 only⚠️ " + reset);
            }
            if (diet.equals("1")) {
                System.out.println(mint + "🥬 Here is your Weight Loss Vegetarian Diet: ");
                System.out.println("• Breakfast: Oats / sprouts + milk");
                System.out.println("• Lunch: Brown rice + dal + vegetables");
                System.out.println("• Snacks: Nuts + green tea");
                System.out.println("• Dinner: Soup + salad");
                System.out.println("• ⚠️ Avoid sugar, sweets & junk food\n " + reset);
            }
            if (diet.equals("2")) {
                System.out.println(magenta + "\n🍗Here is your Non-Vegetarian diet:");
                System.out.println("• Breakfast: Boiled eggs (2–3) + milk + banana");
                System.out.println("• Lunch: Rice + chicken curry / egg curry + vegetables");
                System.out.println("• Snacks: Egg sandwich / peanut butter sandwich");
                System.out.println("• Dinner: Roti + grilled chicken / fish + curd");
                System.out.println("• Add healthy fats: ghee, nuts, seeds\n " + reset);

            }
            if (obj.gender.equals("1"))
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) + 5;
            else
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) - 161;
            if (obj.act_level == 1)
                Calories = BMR * 1.2;
            else if (obj.act_level == 2)
                Calories = BMR * 1.55;
            else
                Calories = BMR * 1.9;
            System.out.print( italic + peach + "2. calorie intake :" + Calories + " kcal/day");
            System.out.println("suggestion : for weight gain have 200~300 kcal/day surplus" + reset);

        } else if (obj.bmi < 25) {
            System.out.println(mint + "You are having a normal BMI" + reset);
            System.out.println(peach + "Suggestion for a weight maintenance diet are :- ");
            System.out.print("1. Suggested protein intake (Based on body weight and activity level) :");
            if (obj.act_level == 1)
                System.out.println(1.2 * obj.weight + " grms/day\n");
            if (obj.act_level == 2)
                System.out.println(1.5 * obj.weight + " grms/day\n");
            if (obj.act_level == 3)
                System.out.println(2 * obj.weight + " grms/day\n" + reset);

            boolean dietCheck = true;
            String diet = null;
            while (dietCheck) {
                sc.nextLine();
                System.out.println(cyan + "Enter \n  1 for vegetarian diet\n  2 for non vegetarian diet " + reset);
                diet = sc.nextLine();
                if (diet.equals("1") || diet.equals("2")) dietCheck = false;
                else System.out.println(cyan + "Enter 1/2 only⚠️ " + reset);
            }
            if (diet.equals("1")) {
                System.out.println(mint + "🥬 Here is your Weight Loss Vegetarian Diet: ");
                System.out.println("• Breakfast: Fruits + milk");
                System.out.println("• Lunch: Roti + vegetables + dal");
                System.out.println("• Snacks: Roasted chana / fruits");
                System.out.println("• Dinner: Light home-cooked meal\n" + reset);
            } else {
                System.out.println(magenta + "\n🍗Here is your Non-Vegetarian diet:");
                System.out.println("• Breakfast: Boiled eggs (1–2) + whole wheat toast");
                System.out.println("• Lunch: Roti / rice + grilled chicken / fish + vegetables");
                System.out.println("• Snacks: Egg whites / nuts");
                System.out.println("• Dinner: Light chicken soup / omelette + salad\n" + reset);
            }
            if (obj.gender.equals("1"))
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) + 5;
            else
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) - 161;
            if (obj.act_level == 1)
                Calories = BMR * 1.2;
            else if (obj.act_level == 2)
                Calories = BMR * 1.55;
            else
                Calories = BMR * 1.9;
            System.out.println(italic +peach+ "2. Maintenance calorie intake :" + Calories + " kcal/day" );
            System.out.println( " Suggestion : you are fit maintain your calorie intake\n" + reset);

        } else if (obj.bmi > 25) {
            System.out.println(mint + bold + "You are overweight " + obj.name + reset);
            System.out.println(peach + "Suggestion for a weight loss diet are :- ");
            System.out.print("1. Suggested protein intake (Based on body weight and activity level):");
            if (obj.act_level == 1)
                System.out.println(1.2 * obj.weight + " grms/day\n");
            if (obj.act_level == 2)
                System.out.println(1.5 * obj.weight + " grms/day\n");
            if (obj.act_level == 3)
                System.out.println(2 * obj.weight + " grms/day\n" + reset);

            boolean dietCheck = true;
            String diet = null;
            while (dietCheck) {
                sc.nextLine();
                System.out.println(peach + "Enter \n  1 for vegetarian diet\n  2 for non vegetarian diet " + reset);
                diet = sc.nextLine();
                if (diet.equals("1") || diet.equals("2")) dietCheck = false;
                else System.out.println(red + "Enter 1/2 only⚠️ " + reset);
            }
            if (diet.equals("1")) {
                System.out.println(mint + "🥬 Here is your Weight Loss Vegetarian Diet:  ");
                System.out.println("• Breakfast: Fruits + green tea");
                System.out.println("• Lunch: Mixed vegetable salad + dal / soup");
                System.out.println("• Snacks: Roasted chana / fruits");
                System.out.println("• Dinner: Light soup + salad");
                System.out.println("• Avoid fried, sugary & junk food\n" + reset);
            } else {
                System.out.println(magenta + "\n🍗Here is your Non-Vegetarian diet:");
                System.out.println("• Breakfast: Boiled eggs (1–2) + green tea");
                System.out.println("• Lunch: Grilled chicken / fish + salad");
                System.out.println("• Snacks: Egg whites / nuts");
                System.out.println("• Dinner: Light chicken soup + vegetables");
                System.out.println("• Avoid red meat, oily & processed food\n" + reset);

            }
            if (obj.gender.equals("1"))
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) + 5;
            else
                BMR = (obj.weight * 10) + (625 * obj.height) - (5 * obj.age) - 161;
            if (obj.act_level == 1)
                Calories = BMR * 1.2;
            else if (obj.act_level == 2)
                Calories = BMR * 1.55;
            else
                Calories = BMR * 1.9;
            System.out.println(peach+italic+ "2. maintenance calorie intake :" + Calories + " kcal/day");
            System.out.println("Suggestion : for weight loss have 300~500 kcal/day deficit." + reset);
        }
        // Diabetic patient – only tips
        if (obj.diabetes.equalsIgnoreCase("yes")) {
            System.out.println(underline + bold + "🩺 Diabetic diet Tips (General Guidance)" + reset);
            System.out.println(skyblue + "• Avoid sugar, sweets, soft drinks and bakery items");
            System.out.println("• Eat at regular time intervals");
            System.out.println("• Prefer whole grains, vegetables and fiber-rich food");
            System.out.println("• Limit carbohydrate intake");
            System.out.println("• Monitor blood sugar levels regularly");
            System.out.println("• Stay hydrated" + reset);
            System.out.println(coral+ bold + "⚠️ Note: This system does not provide a detailed diet for diabetic patients.");
            System.out.println("Please consult a doctor or certified dietitian.\n" + reset);
        }
        // Blood Pressure patient – only tips
        if (obj.bp.equals("1") || obj.bp.equals("2")) {
            System.out.println(underline + bold + "🩺 Blood Pressure diet Tips" + reset);
            System.out.println(skyblue + "• Reduce salt intake in daily food");
            System.out.println("• Avoid pickles, papad, chips and processed food");
            System.out.println("• Eat fruits, vegetables and whole grains");
            System.out.println(coral+"⚠️ Note: Detailed diet is not provided for BP patients.");
            System.out.println("Please consult a doctor for personalized diet advice.\n" + reset);

        }
        // Cardiac patient – only tips
        if (obj.cardiac.equalsIgnoreCase("yes")) {
            System.out.println(underline + bold + "❤️ Cardiac diet tips" + reset);
            System.out.println(skyblue + "• Avoid oily, fried and junk food");
            System.out.println("• Limit salt and saturated fats");
            System.out.println("• Eat fruits, vegetables and fiber-rich food");
            System.out.println("• Prefer steaming, boiling or grilling methods");
            System.out.println("• Avoid smoking and alcohol");
            System.out.println(coral+"⚠️ Note: Detailed diet is not provided for cardiac patients.");
            System.out.println("Please consult a cardiologist or dietitian.\n" + reset);
        }
    }

    void showWeeklyAnalysis(calculate obj) {
        double avgWeight = 0, avgSleep = 0, avgwater = 0;
        int avgSteps = 0;
        for (int i = 0; i < obj.dayCount; i++) {
            avgWeight += obj.dailyWeight[i];
            avgwater += obj.dailyWaterintake[i];
            avgSleep += obj.dailySleep[i];
            avgSteps += obj.dailySteps[i];
        }
        avgWeight /= obj.dayCount;
        avgwater /= obj.dayCount;
        avgSleep /= obj.dayCount;
        avgSteps /= obj.dayCount;

        System.out.println(italic + underline + bold + mint + "\n----- Weekly Analysis -----" + reset);
        System.out.println(yellow + "Average Weight⚖️: " + avgWeight + " kg");
        System.out.println("Average Sleep: " + avgSleep + " hours");
        System.out.println(("Average water intake : " + avgwater + " l"));
        System.out.println("Average Steps: " + avgSteps + reset);

        if (avgSleep < obj.sleep_hours)
            System.out.println(red + "⚠️ You are sleeping less than recommended." + reset);
        else
            System.out.println(mint + "✅ Sleep hours are on track." + reset);

        if (avgSteps < 5000 && obj.act_level >= 2)
            System.out.println(red + "⚠️ Low activity detected. Try to walk more." + reset);
        else
            System.out.println(mint + "✅ Good activity levels." + reset);

        if (avgWeight > obj.weight && obj.bmi > 25)
            System.out.println(red + "⚠️ Weight trend is increasing. Consider adjusting diet/exercise." + reset);
        else if (avgWeight > obj.weight && obj.bmi < 19)
            System.out.println(red + "⚠️ Weight trend is decreasing. Consider adjusting diet/exercise." + reset);
        else
            System.out.println(mint + "✅ Weight trend is stable or decreasing." + reset);
        if (avgwater < obj.water_level)
            System.out.println(red + "⚠️ Water intake is Low. Drink more water." + reset);
    }

    void View_health_report(calculate obj) {
        Scanner sc = Input.sc;
        System.out.println(lavender + bold + underline + "\uD83E\uDDEEHere is your full health report so far :" + reset);
        System.out.println(magenta + "Name : " + obj.name);
        System.out.println("Age : " + obj.age);
        System.out.println("Gender : " + (obj.gender.equals("1") ? "♂️Male" : "♀️Female"));
        System.out.println("Height 📏: " + obj.height + "m");
        System.out.println("weight ⚖️: " + obj.weight + "kg");
        System.out.println("BMI : " + obj.bmi);
        System.out.println("Daily (suggested) water intake💧 : " + obj.water_level / 1000 + "L");
        System.out.println("Recommended sleep hours😴 : " + obj.sleep_hours);
        System.out.println("Medical conditions🩺 :\n" + (obj.diabetes.equalsIgnoreCase("yes") ? "Diabetes " : "no Diabetes \n"));
        System.out.println((obj.cardiac.equalsIgnoreCase("yes") ? "Cardiac issues " : "no cardiac issues \n"));
        System.out.println((obj.bp.equals("1") ? "low bp" : obj.bp.equals("2") ? "High bp" : "normal bp") + reset);
        // Check if 7 days of data have been entered
        if (obj.dayCount < 7) {
            sc.nextLine();
            System.out.println(mint + "\nYou have not entered the 7 days data.");
            System.out.print("Would you like to? (yes/no): " + reset);
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                while (obj.dayCount < 7)
                    add_daily_health_data(obj);
                // After collecting, show weekly analysis
                showWeeklyAnalysis(obj);
            } else {
                // Simply return to menu loop
                System.out.println(magenta+ bold + "Returning to menu...................." + reset);
            }
        } else {
            // Already have 7 days → show weekly analysis
            showWeeklyAnalysis(obj);
        }}
    void healthscore(calculate obj) {

        int sleepScore, waterScore, activityScore, bmiScore, medicalScore;
        double avgWater = 0;

        // ---------- Sleep (20) ----------
        if (obj.sleep_hours >= 7) sleepScore = 20;
        else if (obj.sleep_hours >= 6) sleepScore = 15;
        else sleepScore = 8;

        // ---------- Water (20) ----------
        if (obj.dayCount > 0) {
            for (int i = 0; i < obj.dayCount; i++)
                avgWater += obj.dailyWaterintake[i];
            avgWater /= obj.dayCount;
        } else {
            avgWater = obj.water_level / 1000;
        }

        if (avgWater >= obj.water_level / 1000) waterScore = 20;
        else if (avgWater >= (obj.water_level / 1000) * 0.75) waterScore = 15;
        else waterScore = 8;

        // ---------- Activity (20) ----------
        if (obj.act_level == 3) activityScore = 20;
        else if (obj.act_level == 2) activityScore = 15;
        else activityScore = 8;

        // ---------- BMI (20) ----------
        if (obj.bmi >= 18.5 && obj.bmi <= 24.9) bmiScore = 20;
        else if (obj.bmi <= 29.9) bmiScore = 12;
        else bmiScore = 6;

        // ---------- Medical Risk (20) ----------
        if (obj.diabetes.equalsIgnoreCase("no")
                && obj.cardiac.equalsIgnoreCase("no")
                && obj.bp.equals("3"))
            medicalScore = 20;
        else
            medicalScore = 10;

        int totalScore = sleepScore + waterScore + activityScore + bmiScore + medicalScore;

        // ---------- OUTPUT ----------
        System.out.println(bold + underline + mint +
                "\n🧠 HEALTH SCORE & STATUS" + reset);

        System.out.println("Sleep Score        : " + sleepScore + " / 20");
        System.out.println("Water Intake Score : " + waterScore + " / 20");
        System.out.println("Activity Score     : " + activityScore + " / 20");
        System.out.println("BMI Score          : " + bmiScore + " / 20");
        System.out.println("Medical Risk Score : " + medicalScore + " / 20");

        System.out.println("--------------------------------");
        System.out.println("TOTAL HEALTH SCORE : " + totalScore + " / 100");

        if (totalScore >= 90)
            System.out.println(green + "Status : 🟢 EXCELLENT" + reset);
        else if (totalScore >= 70)
            System.out.println(mint + "Status : 🟢 GOOD" + reset);
        else if (totalScore >= 50)
            System.out.println(yellow + "Status : 🟡 NEEDS IMPROVEMENT" + reset);
        else
            System.out.println(red + "Status : 🔴 CRITICAL" + reset);
        System.out.println("\n⚠️ HEALTH ALERTS SUMMARY");

        if (sleepScore < 15)
            System.out.println("• Low sleep detected");

        if (waterScore < 15)
            System.out.println("• Low water intake");

        if (activityScore < 15)
            System.out.println("• Low physical activity");

        if (medicalScore < 20)
            System.out.println("• Medical risk present");

    }
    // ... existing code ...
    void demoModeFull(calculate obj) {

        System.out.println(bold + underline + mint +
                "\n🎬 DEMO MODE – FULL SYSTEM WALKTHROUGH" + reset);

        // Use the current active user if available.
        // Do not depend on calculate.ob[0], because it may be null.
        calculate demoUser = obj;

        if (demoUser == null) {
            demoUser = new calculate();
        }

        // Ensure demo profile has valid data for all features
        demoUser.name = "Demo User";
        demoUser.age = 25;
        demoUser.gender = "1";
        demoUser.height = 1.75;
        demoUser.weight = 72;
        demoUser.act_level = 2;
        demoUser.diabetes = "no";
        demoUser.cardiac = "no";
        demoUser.bp = "3";

        // Recalculate derived health values after setting profile data
        demoUser.calculator();

        System.out.println(cyan +
                "\n👤 Demo User Loaded: " + demoUser.name +
                " (Age: " + demoUser.age + ")" + reset);

        // Reset old data
        demoUser.dayCount = 0;

        // Demo 7-day data
        double[] demoWeight = {72, 71.8, 71.6, 71.5, 71.4, 71.3, 71.2};
        double[] demoSleep  = {7.2, 7.0, 7.5, 7.1, 7.3, 7.4, 7.6};
        double[] demoWater  = {2.5, 2.7, 2.6, 2.8, 3.0, 2.9, 3.1};
        int[] demoSteps     = {4500, 5200, 6100, 7000, 7800, 8200, 9000};

        for (int i = 0; i < 7; i++) {
            demoUser.dailyWeight[i] = demoWeight[i];
            demoUser.dailySleep[i] = demoSleep[i];
            demoUser.dailyWaterintake[i] = demoWater[i];
            demoUser.dailySteps[i] = demoSteps[i];
            demoUser.dayCount++;
        }

        System.out.println(green + "✔ 7 days of sample health data loaded\n" + reset);

        // ---------- FEATURE SHOWCASE ----------
        System.out.println(bold + coral + "\n▶ Feature 1: Health Score" + reset);
        healthscore(demoUser);

        System.out.println(bold + coral + "\n▶ Feature 2: Weekly Progress Analysis" + reset);
        showWeeklyAnalysis(demoUser);

        System.out.println(bold + coral + "\n▶ Feature 3: Personalized Gym Plan" + reset);
        Gym_plan(demoUser);

        System.out.println(bold + coral + "\n▶ Feature 4: Diet Plan Suggestions" + reset);
        diet_plan(demoUser);

        System.out.println(bold + coral + "\n▶ Feature 5: Full Health Report" + reset);
        View_health_report(demoUser);

        System.out.println(mint + bold +
                "\n🎯 Demo Completed Successfully" + reset);
    }
}