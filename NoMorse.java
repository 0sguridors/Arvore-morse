class NoMorse {
    char caractere;     
    NoMorse esquerda;   
    NoMorse direita;    

    public NoMorse(char caractere) {
        this.caractere = caractere;
        esquerda = direita = null;
    }
}