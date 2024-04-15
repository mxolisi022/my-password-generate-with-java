
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("password generator ");
        int[] num = input();
        int leng = num[0];
        int capital = num[1];
        int special = num[2];

        password(leng, capital, special);
    }

    public static int[] input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select the length of password you want : ");
        int leng = sc.nextInt();

        while (leng < 6) {
            leng = sc.nextInt();
        }

        System.out.print("How many capital letters you want : ");
        int capital = sc.nextInt();
        while (capital > leng) {
            capital = sc.nextInt();
        }

        System.out.print("How many special character you want : ");
        int special = sc.nextInt();
        while (special > leng - capital) {
            special = sc.nextInt();
        }
        return new int[]{leng, capital, special};

    }

    public static void password(int leng, int capital, int special) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] spe_char = {'!', '`', '@', '#', '$', '^', '&', '*', '_', '+', '-', '='};

        Random rand = new Random();
        String pass = "";
        for (int x = 0; leng > x; x++) {
            int i = rand.nextInt(26);
            char lett = alphabet[i];
            if (pass.indexOf(lett) >= 0) {
                i = rand.nextInt(26);
                lett = alphabet[i];
            }
            pass = pass + lett;
        }
        for (int a = 0; special > a; a++) {
            int l = rand.nextInt(pass.length());
            int i = rand.nextInt(spe_char.length);
            char boom = spe_char[i];
            pass = pass.replace(pass.charAt(l), boom);
        }


        for (int q = 0; capital > q; q++) {
            boolean loo = true;
            int i = rand.nextInt(pass.length());
            char lala = pass.charAt(i);
            while (!Character.isLetter(lala)) {
                i = rand.nextInt(pass.length());
                lala = pass.charAt(i);
            }
            char uplala = Character.toUpperCase(lala);
            pass = pass.replace(lala, uplala);
        }



        System.out.println(pass);

    }

}