import java.util.Scanner;
public class Principal {

   static class  coordenades {
        int lletres;
        int numeros;
    }

public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

    boolean sortir = false;

    taulellvuit();

    int dificultat=0;

    int [][]taulellMines=crearTaulell(dificultat);

do {
    int opcio=menu();


    switch (opcio){
        case 1:
            jugarPartida(dificultat,taulellMines);
            break;
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

    public static int seleccionadificultat(){
        int dificultat=0;
        boolean dificultatcert = false;

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
            return dificultat;
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

        public static int [][] crearTaulell(int dificultat)
        {
        int mines=seleccionadificultat();
        final int MAX_NUMERO_RAND=5;
        int resultatRandom_I=0;
        int resultatRandom_J=0;
        int coordenanMines=0;

        int [][] posicioMines=new int[mines][2];
        int [][] taulellAmbMines=new int[5][5];

        boolean minesOK=false;
        int count=0;
        while (!minesOK){
            resultatRandom_I=(int) (Math.random()*MAX_NUMERO_RAND);
            resultatRandom_J=(int) (Math.random()*MAX_NUMERO_RAND);
            boolean posicio_I_OK=false;
            boolean posicio_J_OK=false;

            for (int i=0; i<posicioMines.length;i++){
                if ((resultatRandom_I ==posicioMines[i][0] && (resultatRandom_J == posicioMines [i][1]))){
                    posicio_I_OK=true;
                    posicio_J_OK=true;
                }
            }
            if (posicio_I_OK && posicio_J_OK){
                continue;

            }else {
                posicioMines[coordenanMines][0]=resultatRandom_I;
                posicioMines[coordenanMines][1]=resultatRandom_J;
                coordenanMines++;
                count++;
                taulellAmbMines[resultatRandom_I][resultatRandom_J]=-1;
                if (count ==mines){

                    minesOK=true;
                }
            }
        }
        for (int i=0;i<taulellAmbMines.length;i++){
            for (int j=0;j<taulellAmbMines.length;j++){
                if (taulellAmbMines[i][j] != -1){
                    taulellAmbMines[i][j]=-2;
                }
            }
        }
        return taulellAmbMines;
        }
    public static void mostrarTaulell(int[][] taulellAmbMines) {
        System.out.println();

        // Primer fem la capçelera.
        System.out.println();
        System.out.printf("%4s", "A");
        System.out.printf("%3s", "B");
        System.out.printf("%3s", "C");
        System.out.printf("%3s", "D");
        System.out.printf("%3s", "E");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 5; j++) {
                if (taulellAmbMines[i][j] == -2 || taulellAmbMines[i][j] == -1) {
                    System.out.printf("%3s", "-");
                } else {
                    System.out.printf("%3s", taulellAmbMines[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static coordenades demanarCoordenada() {
        Scanner lector = new Scanner(System.in);
        coordenades coord = new coordenades();
        String entrada = "";
        boolean coordenada_OK = false;
        int numero = 0;
        int lletra = 0;

        // Fem un bucle que ens permeti assegurar que la coordenada introduïda és correcte.
        while (!coordenada_OK) {
            System.out.println();
            System.out.print("Entra una coordenada: ");
            try {
                entrada = lector.next();
                numero = entrada.charAt(0) - 49;
                lletra = entrada.charAt(1) - 65;
                if (numero >= 5 || numero < 0 || lletra >= 5 || lletra < 0) {
                    System.out.println();
                    System.out.println("Error!");
                    System.out.println("Has d'entrar un rang de numero i lletra correcte.");
                    System.out.println("Exemple: 3E - (1,2,3,4,5)(A,B,C,D,E)");
                    System.out.println();
                } else {
                    coordenada_OK = true;
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Error!");
                System.out.println("Has d'entrar una coordenada correcte.");
                System.out.println("Consisteix en un número i una lletra majúscula sense espais.");
                System.out.println("Exemple: 3E - (1,2,3,4,5)(A,B,C,D,E)");
                System.out.println();
            }
        }

        coord.numeros = numero;
        coord.lletres = lletra;

        return coord;
    }
    public static int convertirDificultatPerMines(int dificultat) {
        int mines = 0;
        switch (dificultat) {
            case 1:
                mines = 3;
                break;
            case 2:
                mines = 5;
                break;
            case 3:
                mines = 7;
                break;
            default:
                System.out.println("Quantitat de mines no correcte!");
        }
        return mines;
    }
    public static int minesAlVoltant(coordenades cordenada, int[][] taulellAmbMines) {
        int numero = cordenada.numeros;
        int lletra = cordenada.lletres;
        int count = 0;
        // Mirem els vèrtex 1r:(0,0), 2n:(0,4), 3r:(4,0), 4t:(4,4)
        if (numero == 0 && lletra == 0) {
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == -1) {
                count++;
            }
            return count;
        } else if (numero == 0 && lletra == 4) {
            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == -1) {
                count++;
            }
            return count;
        } else if (numero == 4 && lletra == 0) {
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            return count;
        } else if (numero == 4 && lletra == 4) {
            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            return count;

        } else if (numero >= 1 && numero <= 3 && lletra == 0) {
            // Mirem el lateral esquerre, que no siguin els vertex
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == '*') {
                count++;
            }
            return count;
        } else if (numero >= 1 && numero <= 3 && lletra == 4) {
            // lateral dret que no sigui vertex
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == -1) {
                count++;
            }
            return count;
        } else if (lletra >= 1 && lletra <= 3 && numero == 0) {
            // Lateral superior - que no són els vèrtex:

            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            return count;
        } else if (lletra >= 1 && lletra <= 3 && numero == 4) {
            // Lateral inferior - que no siguin els vèrtex:
            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            return count;
        } else if (lletra >= 1 && lletra <= 3 && numero >= 1 && numero <= 3) {
            // Ara les posicions centrals:

            if (taulellAmbMines[numero - 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero - 1][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero][lletra + 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra - 1] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra] == -1) {
                count++;
            }
            if (taulellAmbMines[numero + 1][lletra + 1] == -1) {
                count++;
            }
            return count;
        } else {
            return count;
        }
    }
    public static void mostrarGuanyador(int[][] taulellAmbMines, int puntuacio) {

        System.out.println("Molt bé, t'has passat el joc. ");

        System.out.println();
        // Primer fem la capçelera.
        System.out.println();
        System.out.printf("%4s", "A");
        System.out.printf("%3s", "B");
        System.out.printf("%3s", "C");
        System.out.printf("%3s", "D");
        System.out.printf("%3s", "E");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 5; j++) {
                if (taulellAmbMines[i][j] != -1) {
                    System.out.printf("%3s", taulellAmbMines[i][j]);
                } else {
                    System.out.printf("%3s", "*");
                }
            }
            System.out.println();
        }
        System.out.println();

        // Mostrem la puntuació:
        System.out.println("La puntuació ha sigut de: " + puntuacio);
    }
    public static void mostrarPerdedor(int[][] taulellAmbMines, int numero, int lletra, int puntuacio) {
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
                if (taulellAmbMines[i][j] == -1) {
                    if (i == numero && j == lletra) {
                        System.out.print(" " + "*" + " ");
                    } else {
                        System.out.print(" " + "+" + " ");
                    }
                } else {
                    if (i == numero && j == lletra) {
                        System.out.print(" " + "*" + " ");
                    } else {
                        // Mostrem també el número de mines que hi havien al voltant un cop hem perdut.
                        if (taulellAmbMines[i][j] == -2) {
                            System.out.print(" " +"-" + " ");
                            // vol dir que hem tirat allà i per tant hem de mostrar el número de mines que hi ha hal voltant.
                        } else {
                            System.out.print(" " + taulellAmbMines[i][j] + " ");
                            // vol dir que no hem tirat encara en aquesta posició i per tant hem de mostrar un guionet.
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("BOOOOOM! Partida finalitzada");
        System.out.println("Punts aconseguits: " + puntuacio);
        System.out.println();
    }
    public static void jugarPartida(int dificultat, int[][] taulellAmbMines) {

        Scanner lector = new Scanner(System.in);

        int mines = convertirDificultatPerMines(dificultat);

        int puntuacio = 0;
        int jugades = 0;
        boolean jugadaAcabada = false;
        int numero = 0;
        int lletra = 0;

        while ((jugades != (25 - mines)) && (!jugadaAcabada)) {

            mostrarTaulell(taulellAmbMines);

            // Mostrem la puntuació
            System.out.println("\nPunts aconseguits: " + puntuacio);

            // Demanem a l'usuari la coordenada:
            coordenades coord = new coordenades();
            coord = demanarCoordenada();
            lletra = coord.lletres;
            numero = coord.numeros;

            if (taulellAmbMines[numero][lletra] != -2 && taulellAmbMines[numero][lletra] != -1) {

                continue;
            }
            if (taulellAmbMines[numero][lletra] == -1) {
                // Tenim una mina en aquesta posició
                jugadaAcabada = true;
            }
            if (!jugadaAcabada) {
                // Mirem quantes mines tenim al costat de la coordenada i actualitzem el -2 per el valor.
                int minesVoltant = minesAlVoltant(coord, taulellAmbMines);

                // Posem aquest valor al taulellDeMines:
                taulellAmbMines[numero][lletra] = minesVoltant;

                // Acutalitzem la puntuació i les jugades que hem fet:
                puntuacio = puntuacio + dificultat;
                jugades++;
            }
        }

        // Mirem si hem sortit del bucle perque hem guanyat o perdut.
        if (jugades == (25 - mines)) {
            System.out.println();
            mostrarGuanyador(taulellAmbMines, puntuacio);
        } else {
            mostrarPerdedor(taulellAmbMines, numero, lletra, puntuacio);
        }

    }
    }