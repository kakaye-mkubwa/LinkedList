import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class FA2019_RestrictedStructureDemo_Bhattarai {
    public static void main(String[] args){
//        displayMainMenu();
        int num;
        boolean[] output = new boolean[8];
//        System.out.println("Enter number");
//        Scanner mScanner = new Scanner(System.in);
//        if(output[mScanner.nextInt()]){
//
//        }
        for (int i = 0; i < 9; i++) {
            System.out.println("Output for i " + output[i]);
        }
    }

    public static void displayMainMenu(){
        System.out.println("MAIN MENU LINKED LIST STRUCTURE - JAMES SMITH");
        System.out.println("1. LQHashed Structure");
        System.out.println("2. Java Hashtable");
        System.out.println("0. Exit");

        Scanner mainMenuScanner = new Scanner(System.in);
        switch (mainMenuScanner.nextInt()){
            case 1:
//                LQHashed Structure
                displayLQHashedMenu();
                break;
            case 2:
////                Java Hashtable
                displayHashTableMenu();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void displayLQHashedMenu(){
        /***
         * HASHED DATA STRUCTURE – JAMES SMITH
         * 1. Insert Customer
         * 2. Fetch
         * 3. Verify Encapsulation
         * 4. Update
         * 5. Delete
         * 6. Show all
         * 0. Exit
         */
        System.out.println("HASHED DATA STRUCTURE -JAMES SMITH");
        System.out.println("1. Insert Customer");
        System.out.println("2. Fetch");
        System.out.println("3. Verify Encapsulation");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Show All");
        System.out.println("0. Exit");

        LQHashed_Bhattarai lqHashed_bhattarai = new LQHashed_Bhattarai(7);

        Scanner hashedDataScanner = new Scanner(System.in);
        switch (hashedDataScanner.nextInt()){
            case 1:
                //insert
                insertStudent(lqHashed_bhattarai);
                break;
            case 2:
//                fetch
                fetch(lqHashed_bhattarai);
                break;
            case 3:
//                verify encapsulation
                encapsulation(lqHashed_bhattarai);
                break;
            case 4:
//                update
                update(lqHashed_bhattarai);
                break;
            case 5:
//                delete
                delete(lqHashed_bhattarai);
                break;
            case 6:
//                showall
                showAll(lqHashed_bhattarai);
                break;
            case 0:
//                exit
                exit(lqHashed_bhattarai);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void insertStudent(LQHashed_Bhattarai lqHashed_bhattarai){
        System.out.println("Please provide student details: ");
        Scanner studentDetailsScanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = studentDetailsScanner.nextLine();
        System.out.println("First name");
        String firstName = studentDetailsScanner.nextLine();
        System.out.println("Class name");
        String className = studentDetailsScanner.nextLine();

        Class aClass = new Class(className);
        Student_Bhattarai student_bhattarai = new Student_Bhattarai(lastName,firstName,aClass);
        lqHashed_bhattarai.insert(student_bhattarai);
    }

    public static void fetch(LQHashed_Bhattarai lqHashed_bhattarai){
        System.out.print("Enter student ID: ");
        Scanner fetchScanner = new Scanner(System.in);
        String studentID = fetchScanner.nextLine();
        if (lqHashed_bhattarai.fetch(studentID) == null){
            System.out.println("Student not found");
        }else{
            System.out.println(lqHashed_bhattarai.fetch(studentID).toString());
        }
    }

    public static void encapsulation(LQHashed_Bhattarai lqHashed_bhattarai){
        System.out.println("Enter student ID");
        Scanner encapsulationScanner = new Scanner(System.in);
        String studentID = encapsulationScanner.nextLine();

        if (lqHashed_bhattarai.fetch(studentID) == null){
            System.out.println("Student not found");
        }else{
            Student_Bhattarai temp = lqHashed_bhattarai.fetch(studentID);

            System.out.println("Enter new last name: ");
            String lastNameTemp = encapsulationScanner.nextLine();
            temp.setLastName(lastNameTemp);

            Student_Bhattarai fetchedStudent = lqHashed_bhattarai.fetch(studentID);

            if (fetchedStudent.getLastName().equals(temp.getLastName())){
                System.out.println("LQHashed is not encapsulated");
            }else{
                System.out.println("LQHashed is encapsulated");
            }
        }
    }

    public static void update(LQHashed_Bhattarai lqHashed_bhattarai){
        System.out.println("Enter student ID");
        Scanner updateScanner = new Scanner(System.in);
        String studentID = updateScanner.nextLine();

        if (lqHashed_bhattarai.fetch(studentID) == null){
            System.out.println("Student not found");
        }else{
            Student_Bhattarai temp3 = lqHashed_bhattarai.fetch(studentID);

            System.out.println("Enter new last name: ");
            String lastNameTemp = updateScanner.nextLine();
            temp3.setLastName(lastNameTemp);

            if(lqHashed_bhattarai.update(studentID, temp3))
            {
                System.out.println("Update successfull");
            }else{
                System.out.println("Update failed");
            }
        }
    }

    public static void delete(LQHashed_Bhattarai lqHashed_bhattarai){
        System.out.println("Enter student ID");
        Scanner updateScanner = new Scanner(System.in);
        String studentID = updateScanner.nextLine();

        if (lqHashed_bhattarai.delete(studentID)){
            System.out.println("Student deleted successfully");
        }else{
            System.out.println("Student deletion failed");
        }
    }

    public static void showAll(LQHashed_Bhattarai lqHashed_bhattarai){
        lqHashed_bhattarai.showAll();
    }

    public static void exit(LQHashed_Bhattarai lqHashed_bhattarai){
        lqHashed_bhattarai.writeToFile();
    }

    public static void displayHashTableMenu(){
        System.out.println("JAVA HASHTABLE DATA STRUCTURE -JAMES SMITH");
        System.out.println("1. Insert Customer");
        System.out.println("2. Fetch");
        System.out.println("3. Verify Encapsulation");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Show All");
        System.out.println("0. Exit");

        Hashtable<Integer,Student_Bhattarai> mJavaHashTable = new Hashtable<Integer,Student_Bhattarai>();

        Scanner javaHashtableScanner = new Scanner(System.in);
        switch (javaHashtableScanner.nextInt()){
            case 1:
//                Insert customer
                addStudentJavaHashtable(mJavaHashTable);
                break;
            case 2:
//                fetch
                fetchStudentJavaHashTable(mJavaHashTable);
                break;
            case 3:
//                verify encapsulation
                encapsulationJavaHashTable(mJavaHashTable);
                break;
            case 4:
//                update
                updateJavaHashTable(mJavaHashTable);
                break;
            case 5:
//                delete
                deleteJavaHashTable(mJavaHashTable);
                break;
            case 6:
//                show all
                showAllJavaHashTable(mJavaHashTable);
                break;
            case 0:
//                exit
                exitJavaHashTable(mJavaHashTable);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void addStudentJavaHashtable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        System.out.println("Please provide student details: ");
        Scanner studentDetailsScanner = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = studentDetailsScanner.nextLine();
        System.out.println("First name");
        String firstName = studentDetailsScanner.nextLine();
        System.out.println("Class name");
        String className = studentDetailsScanner.nextLine();

        Class aClass = new Class(className);
        Student_Bhattarai student_bhattarai = new Student_Bhattarai(lastName,firstName,aClass);
        mJavaHashTable.put(1,student_bhattarai);
    }

    public static void fetchStudentJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        System.out.print("Enter student ID: ");
        Scanner fetchScanner = new Scanner(System.in);
        String studentID = fetchScanner.nextLine();
        int foundFlag = 0;

        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            if (mJavaHashTable.get(mKeys).getStudentID().equals(studentID)){
                System.out.println(mJavaHashTable.get(mKeys).toString());
                foundFlag = 1;
                break;
            }
        }
        if (foundFlag == 0){
            System.out.println("Student not found");
        }

    }

    public static void encapsulationJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        System.out.println("Enter student ID");
        Scanner encapsulationScanner = new Scanner(System.in);
        String studentID = encapsulationScanner.nextLine();

        Student_Bhattarai temp = null;
        Student_Bhattarai fetchedStudent;
        int foundFlag = 0;
        int locationKey = 0;

        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            if (mJavaHashTable.get(mKeys).getStudentID().equals(studentID)){
                temp = mJavaHashTable.get(mKeys);
                foundFlag =1;
                locationKey = mKeys;
            }
        }
        if (foundFlag == 0){
            System.out.println("Student not found");
        }else{
            System.out.println("Enter new last name: ");
            String lastNameTemp = encapsulationScanner.nextLine();
            temp.setLastName(lastNameTemp);

            fetchedStudent = mJavaHashTable.get(locationKey);

            if (fetchedStudent.getLastName().equals(temp.getLastName())){
                System.out.println("LQHashed is not encapsulated");
            }else{
                System.out.println("LQHashed is encapsulated");
            }
        }
    }

    public static void updateJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        System.out.println("Enter student ID");
        Scanner updateScanner = new Scanner(System.in);
        String studentID = updateScanner.nextLine();


        Student_Bhattarai temp = null;
        Student_Bhattarai fetchedStudent;
        int foundFlag = 0;
        int locationKey = 0;

        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            if (mJavaHashTable.get(mKeys).getStudentID().equals(studentID)){
                temp = mJavaHashTable.get(mKeys);
                foundFlag =1;
                locationKey = mKeys;
            }
        }

        if (foundFlag == 0){
            System.out.println("Student not found");
        }else{
            Student_Bhattarai temp3 = mJavaHashTable.get(locationKey);

            System.out.println("Enter new last name: ");
            String lastNameTemp = updateScanner.nextLine();
            temp3.setLastName(lastNameTemp);

            mJavaHashTable.put(locationKey,temp3);
            System.out.println("Update sucessfull");
        }
    }

    public static void deleteJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        System.out.println("Enter student ID");
        Scanner updateScanner = new Scanner(System.in);
        String studentID = updateScanner.nextLine();

        int deleteFlag = 0;

        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            if (mJavaHashTable.get(mKeys).getStudentID().equals(studentID)){
                mJavaHashTable.remove(mKeys);
                deleteFlag = 1;
            }
        }

        if (deleteFlag == 1){
            System.out.println("Student deleted successfully");
        }else{
            System.out.println("Student deletion failed");
        }
    }

    public static void showAllJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            System.out.println(mJavaHashTable.get(mKeys).toString());
        }
    }

    public static void exitJavaHashTable(Hashtable<Integer,Student_Bhattarai> mJavaHashTable){
        Set<Integer> keys = mJavaHashTable.keySet();
        for (Integer mKeys: keys){
            mJavaHashTable.get(mKeys).toFile();
        }
    }
}
