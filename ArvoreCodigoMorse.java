import java.util.Scanner;

public class ArvoreCodigoMorse {
    public static void main(String[] args) {
        ArvoreMorse arvoreMorse = new ArvoreMorse();
        
        arvoreMorse.inserir(".-", 'A');
        arvoreMorse.inserir("-...", 'B');
        arvoreMorse.inserir("-.-.", 'C');
        arvoreMorse.inserir("-..", 'D');
        arvoreMorse.inserir(".", 'E');
        arvoreMorse.inserir("..-.", 'F');
        arvoreMorse.inserir("--.", 'G');
        arvoreMorse.inserir("....", 'H');
        arvoreMorse.inserir("..", 'I');
        arvoreMorse.inserir(".---", 'J');
        arvoreMorse.inserir("-.-", 'K');
        arvoreMorse.inserir(".-..", 'L');
        arvoreMorse.inserir("--", 'M');
        arvoreMorse.inserir("-.", 'N');
        arvoreMorse.inserir("---", 'O');
        arvoreMorse.inserir(".--.", 'P');
        arvoreMorse.inserir("--.-", 'Q');
        arvoreMorse.inserir(".-.", 'R');
        arvoreMorse.inserir("...", 'S');
        arvoreMorse.inserir("-", 'T');
        arvoreMorse.inserir("..-", 'U');
        arvoreMorse.inserir("...-", 'V');
        arvoreMorse.inserir(".--", 'W');
        arvoreMorse.inserir("-..-", 'X');
        arvoreMorse.inserir("-.--", 'Y');
        arvoreMorse.inserir("--..", 'Z');

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sequência Morse a ser decodificada (separada por espaços): ");
        String entradaMorse = scanner.nextLine();

        String palavraDecodificada = arvoreMorse.decodificar(entradaMorse);
        System.out.println("Palavra decodificada: " + palavraDecodificada);

        System.out.println("\nÁrvore Morse:");
        arvoreMorse.imprimirArvore();
        scanner.close();
    }
}