//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

class Esercizio {

    private static Scanner in = new Scanner(System.in);

    public static int selezMenu() {
        int c;
        do {
            System.out.println("Seleziona un opzione:");
            System.out.println(
                    "1)Ins elemento \n2)Elimina elemento \n3)Ricerca vettore \n4)Elimina duplicati \n5)Visualizza vettore \n6)Esci");
            c = Integer.parseInt(in.nextLine());
        } while (c < 1 || c > 6);
        return c;
    }

    public static int inserisciElemento(int[] v, int n, int elemento, int pos) {
        int[] temp = new int[n + 1];
        for (int i = 0; i < pos; i++) {
            temp[i] = v[i];
        }
        temp[pos] = elemento;
        for (int i = pos; i < n; i++) {
            temp[i + 1] = v[i];
        }
        for (int i = 0; i < n + 1; i++) {
            v[i] = temp[i];
        }
        return n + 1;
    }

    public static int inserisciElementoOtt(int[] v, int n, int elemento, int pos) {
        int i = n;
        while (i > pos) {
            v[i] = v[i - 1];
            i--;
        }
        v[pos] = elemento;
        return n + 1;
    }

    public static int eliminaElemento(int[] v, int n, int pos) {
        int[] temp = new int[n - 1];
        for (int i = 0; i < pos; i++) {
            temp[i] = v[i];
        }
        for (int i = pos + 1; i < n; i++) {
            temp[i - 1] = v[i];
        }
        for (int i = 0; i < n - 1; i++) {
            v[i] = temp[i];
        }
        return n - 1;
    }

    public static int eliminaElementoOtt(int[] v, int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            v[i] = v[i + 1];
        }
        return n - 1;
    }

    public static int ricercaElemento(int[] v, int n, int e) {
        int i = 0;
        while (i < n) {
            if (v[i] == e) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int eliminaDuplicatiCopia(int[] v, int n) {
        int[] temp = new int[n];
        int m = 0;
        int i = 0;
        while (i < n) {
            boolean dup = false;
            int j = 0;
            while (j < m && !dup) {
                if (v[i] == temp[j]) {
                    dup = true;
                } else {
                    j++;
                }
            }
            if (!dup) {
                temp[m] = v[i];
                m++;
            }
            i++;
        }
        int k = 0;
        while (k < m) {
            v[k] = temp[k];
            k++;
        }
        return m;
    }

    public static int eliminaDuplicatiOtt(int[] v, int n) {
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (v[i] == v[j]) {
                    n = eliminaElementoOtt(v, n, j);
                } else {
                    j++;
                }
            }
            i++;
        }
        return n;
    }

    public static void visualizzaVettore(int[] v, int n) {
        if (n == 0) {
            System.out.println("Il vettore è vuoto.");
        } else {
            int i = 0;
            while (i < n) {
                System.out.print(v[i] + " ");
                i++;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int c, n;
        int e, pos;
        do {
            System.out.print("Ins n:");
            n = Integer.parseInt(in.nextLine());
        } while (n <= 0);
        int[] v = new int[n * 100];
        do {
            c = selezMenu();
            switch (c) {
                case 1:
                    System.out.println("Inserisci elemento e posizione");
                    e = Integer.parseInt(in.nextLine());
                    pos = Integer.parseInt(in.nextLine());
                    n = inserisciElemento(v, n, e, pos);
                    break;
                case 2:
                    System.out.println("Inserisci posizione");
                    pos = Integer.parseInt(in.nextLine());
                    n = eliminaElemento(v, n, pos);
                    break;
                case 3:
                    System.out.println("ins elemento");
                    e = Integer.parseInt(in.nextLine());
                    e = ricercaElemento(v, n, e);
                    System.out.println(e);
                    break;
                case 4:
                    System.out.println("1)Metodo copia 2)Metodo ottimizzato");
                    int scelta = Integer.parseInt(in.nextLine());
                    if (scelta == 1) {
                        n = eliminaDuplicatiCopia(v, n);
                    } else {
                        n = eliminaDuplicatiOtt(v, n);
                    }
                    break;
                case 5:
                    visualizzaVettore(v, n);
                    break;
                case 6:
                    System.out.println("Uscita");
                    break;
            }
        } while (c != 6);
    }
}
