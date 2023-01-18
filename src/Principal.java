import java.util.Scanner;
public class Principal {

public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

    boolean sortir = false;

    taulellvuit();

do {
    int menu = menu();


    switch (menu){
        case 1:
            seleccionadificultat();break;
        case 2:
            System.out.println("Gracies per haver jugat");
            sortir=true;
            break;

    }
}while (!sortir);

    }

    public static int menu() {
        int opcio = 0;
        System.out.println("1.Entrar el joc de Buscamines");
        System.out.println("2.Sortir");
        opcio = lector.nextInt();
        return opcio;
    }

    public static void seleccionadificultat(){
        boolean dificultatcert = false;
        int dificultat;
        System.out.println("Selecciona la dificultat");
        System.out.println("1.Facil");
        System.out.println("2.Mitja");
        System.out.println("3.Dificil");
        dificultat = lector.nextInt();

        if (dificultat == 1 || dificultat == 2 || dificultat == 3){
            dificultatcert = true;
            }
        else {
                System.out.println("Has introduit una dificultat incorrecta");
                }

        switch (dificultat){
            case 1:

            break;
            case 2:

            break;
            case 3:

            break;
        }
        }

        public static void taulellvuit(){
            System.out.println("=========");
            System.out.println("Buscamines");

            System.out.println();
            System.out.printf("%3s", "A");
            System.out.printf("%3s", "B");
            System.out.printf("%3s", "C");
            System.out.printf("%3s", "D");
            System.out.printf("%3s", "E");
            System.out.println();
            for (int i = 0; i < 5; i++) {
                System.out.print(i + 1);
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%3s", " - ");
                }
                System.out.println();
            }


        }







    }





