//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    private static Scanner in = new Scanner(System.in);

    public static int selezMenu()
    {
        int c;
        do{
            System.out.println("Seleziona un opzione:");
            System.out.println("1)Ins elemento \n2)Elimina elemento \n3)Ricerca vettore \n4)Elimina duplicati \n5)Visualizza vettore \n6)Esci");
            c = Integer.parseInt(in.nextLine());
        }while(c != 1 || c != 2 || c != 3 || c != 4 || c != 5 || c != 6);
        return c;
    }

    public static void inserisciElemento(int[] v, int n) {}
    public static void eliminaElemento(int[] v, int n) {}
    public static void ricercaElemento(int[] v, int n) {}
    public static void eliminaDuplicati(int[] v, int n) {}

    public static void visualizzaVettore(int[] v, int n) {
        if (n == 0) {
            System.out.println("Il vettore è vuoto.");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(v[i] + " ");
            }
            System.out.println();
        }
    }

    // Il programma parte con una chiamata a main().
    public static void main(String args[])
    {
        int c,n;
        do
        {
            System.out.print("Ins n:");
            n = Integer.parseInt(in.nextLine());
        }while(n <= 0);
        int[] v = new int[n*100];
        do
        {
            c = selezMenu();
            switch(c)
            {
                case 1: inserisciElemento(v, n); break;
                case 2: eliminaElemento(v, n); break;
                case 3: ricercaElemento(v, n); break;
                case 4: eliminaDuplicati(v, n); break;
                case 5: visualizzaVettore(v, n); break;
                case 6: System.out.println("Uscita"); break;
            }
                
        }while(c!=6);
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md