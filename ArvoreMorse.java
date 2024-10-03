public class ArvoreMorse {
    private NoMorse raiz;

    // Construtor que constrói a árvore
    public ArvoreMorse() {
        raiz = null;
    }

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
            return '?';
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

    private void imprimirArvoreRec(NoMorse no, String prefixo, boolean ehUltimo) {
        if (no != null) {
       
            System.out.print(prefixo);

            if (ehUltimo) {
                System.out.print("└── ");
                prefixo += "    ";
            } else {
                System.out.print("├── ");
                prefixo += "|   ";
            }

            System.out.println(no.caractere);

            imprimirArvoreRec(no.esquerda, prefixo, false);
            imprimirArvoreRec(no.direita, prefixo, true);   
        }
    }
}
