public class NoMorse {
    char caractere;
    NoMorse esquerda;
    NoMorse direita;

    NoMorse(char caractere) {
        this.caractere = caractere;
        esquerda = null;
        direita = null;
    }
}