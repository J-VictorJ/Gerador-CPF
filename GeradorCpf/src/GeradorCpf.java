import java.util.Random;

public class GeradorCpf {

    public static String gerarCPF() {
        Random rand = new Random();

        // Gera os nove primeiros dígitos aleatórios
        int digito1 = rand.nextInt(10);
        int digito2 = rand.nextInt(10);
        int digito3 = rand.nextInt(10);
        int digito4 = rand.nextInt(10);
        int digito5 = rand.nextInt(10);
        int digito6 = rand.nextInt(10);
        int digito7 = rand.nextInt(10);
        int digito8 = rand.nextInt(10);
        int digito9 = rand.nextInt(10);

        // Calcula os dígitos verificadores
        int verificador1 = calcularDigitoVerificador(digito1, digito2, digito3, digito4, digito5, digito6, digito7, digito8, digito9);
        int verificador2 = calcularDigitoVerificador(digito1, digito2, digito3, digito4, digito5, digito6, digito7, digito8, digito9, verificador1);

        // Monta o CPF fictício
        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", digito1, digito2, digito3, digito4, digito5, digito6, digito7, digito8, digito9, verificador1, verificador2);
    }

    private static int calcularDigitoVerificador(int... digitos) {
        int soma = 0;
        int multiplicador = digitos.length + 1;

        for (int digito : digitos) {
            soma += digito * multiplicador;
            multiplicador--;
        }

        int resto = soma % 11;
        int digitoVerificador = 11 - resto;

        return (digitoVerificador >= 10) ? 0 : digitoVerificador;
    }


}
