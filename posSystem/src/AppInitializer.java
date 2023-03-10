import java.util.Scanner;

public class AppInitializer {
    //    database area
//    static String[][] users = new String[3][2];
    static String[][] users = {{"ccmrhe@gmail.com", "hashan"}, {null, null}, {null, null}};
    //    database area
    public static void main(String[] args) {

        boolean exitState = false;
        String[] initialMessage = {
                "1. Sign Up",
                "2. Sign In",
                "3. Exit"
        };
        while(!exitState){
            for(String msg : initialMessage)
                System.out.println(msg);

            Scanner sc = new Scanner(System.in);
            int initialInput = sc.nextInt();

            switch (initialInput){
                case 1:
                    if(SignUp()) openDashboard();
                    break;

                case 2:
                    if(SignIn()) openDashboard();
                    break;

                case 3:
                    System.out.println("Exit is selected");
                    exitState = true;
                    break;

                default:
                    System.out.println("Invalid input is given");
            }
        }
    }

    public static boolean SignUp(){
        // check last element is null in users
        if(users[2][0] != null){
            System.out.println("Users limit exceeded");
            return false;
        }

        // get details
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email : ");
        String email = sc.next();

        System.out.print("Enter your password : ");
        String password = sc.next();

        // check email is already there if not add one after
        for(String[] user : users){
            if(user[0] != null && user[0].equalsIgnoreCase(email) ){
                System.out.println("User Already Exist");
                return false;
            }
            else{
                user[0] = email;
                user[1] = password;
                System.out.println("User Added");
                break;
            }
        }

        return true;
    }
    public static boolean SignIn(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email : ");
        String email = sc.next();

        System.out.print("Enter your password : ");
        String password = sc.next();

        for(String[] user : users){
            if(user[0] != null && user[0].equalsIgnoreCase(email) && user[1].equals(password)) {
                System.out.println("User Authorized");
                return true;
            }
        }
        System.out.println("No user found");
        return false;
    }

    public static void openDashboard(){
        System.out.println("Welcome to dashboard!");
    }
}
