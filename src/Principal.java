import java.util.Scanner;
public class Principal {

public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
    int menu = menu();
    boolean sortir = false;

    switch (menu){
        case 1:
        seleccionadificultat();

        case 2:

    }
    }

    public static int menu() {
        int opcio = 0;
        System.out.println("1.Entrar el joc de Buscamines");
        System.out.println("2.Sortir");
        opcio = lector.nextInt();
        return opcio;
    }

    public static void seleccionadificultat(){
        int dificultat;
        System.out.println("Selecciona la dificultat");
        System.out.println("1.Facil");
        System.out.println("2.Mitja");
        System.out.println("3.Dificil");
        dificultat = lector.nextInt();

        switch (dificultat){
            case 1:
                taulerfacil();
            break;
            case 2:
                taulermitja();
            break;
            case 3:

            break;
        }
        }

        public static void taulerfacil(){
            int[][] taulerfacil = new int[4][4];
            for (int i = 0; i < taulerfacil.length; i++) {
                for (int j = 0; j < taulerfacil[i].length; j++) {
                    System.out.print(" * ");
                }
                System.out.println();

            }
        }

        public static void taulermitja(){
            int[][] taulermitja = new int[8][8];
            for (int i = 0; i < taulermitja.length; i++) {
                for (int j = 0; j < taulermitja[i].length; j++) {
                    taulermitja[i][j] = (int) (Math.random() * 2);
                }
                for (int j = 0; j < taulermitja[i].length; j++) {
                    System.out.print(taulermitja[i][j] + " ");
                }
                System.out.println();
            }
        }





    }





