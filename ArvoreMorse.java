public class ArvoreMorse {
    private NoMorse raiz;

    public ArvoreMorse() {
        raiz = null;
    }

    // Método para inserir um caractere na árvore
    public void inserir(String codigoMorse, char caractere) {
        raiz = inserirRec(raiz, codigoMorse, caractere);
    }

    private NoMorse inserirRec(NoMorse raiz, String codigoMorse, char caractere) {
        if (raiz == null) {
            raiz = new NoMorse(caractere);
        }
        if (codigoMorse.length() == 0) {
            return raiz;
        }
        char codigoChar = codigoMorse.charAt(0);
        if (codigoChar == '.') {
            raiz.esquerda = inserirRec(raiz.esquerda, codigoMorse.substring(1), caractere);
        } else if (codigoChar == '-') {
            raiz.direita = inserirRec(raiz.direita, codigoMorse.substring(1), caractere);
        }
        return raiz;
    }

    // Método para decodificar a sequência Morse
    public String decodificar(String codigoMorse) {
        StringBuilder palavraDecodificada = new StringBuilder();
        String[] codigos = codigoMorse.split(" ");
        for (String codigo : codigos) {
            palavraDecodificada.append(decodificarRec(raiz, codigo));
        }
        return palavraDecodificada.toString();
    }

    private char decodificarRec(NoMorse raiz, String codigoMorse) {
        if (raiz == null) {
            return '?'; // Caractere desconhecido
        }
        if (codigoMorse.length() == 0) {
            return raiz.caractere;
        }
        char codigoChar = codigoMorse.charAt(0);
        if (codigoChar == '.') {
            return decodificarRec(raiz.esquerda, codigoMorse.substring(1));
        } else {
            return decodificarRec(raiz.direita, codigoMorse.substring(1));
        }
    }

    public void imprimirArvore() {
        imprimirArvoreRec(raiz, "", true);
    }

    private void imprimirArvoreRec(NoMorse no, String indent, boolean ultimo) {
        if (no != null) {
            System.out.print(indent);
            if (ultimo) {
                System.out.print("R---- ");
                indent += "   ";
            } else {
                System.out.print("L---- ");
                indent += "|  ";
            }
            System.out.println(no.caractere);
            imprimirArvoreRec(no.esquerda, indent, false);
            imprimirArvoreRec(no.direita, indent, true);
        }
    }
}
