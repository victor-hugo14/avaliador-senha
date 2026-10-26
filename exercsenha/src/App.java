import java.util.Scanner;

public class App {

    public static String avaliarSenha(String senha) {

        String[] senhasObvias = {"12345678", "senha123", "admin123"};

        for (int i = 0; i < senhasObvias.length; i++) {
            if (senha.equals(senhasObvias[i])) {
                return "Dica: Essa senha e muito óbvia!";
            }
        }

        if (senha.length() < 8) {
            return "Dica: Senha deve ter, no mínimo 8 caracteres";
        }

        boolean temNumero = false;
        boolean temMaiuscula = false;

        for (int i = 0; i < senha.length(); i++) {
            if (Character.isDigit(senha.charAt(i))) {
                temNumero = true;
            }
            if (Character.isUpperCase(senha.charAt(i))) {
                temMaiuscula = true;
            }
            if (temNumero && temMaiuscula) {
                break;
            }
        }

        if (!temNumero) {
            return "Dica: Senha deve conter pelo menos um número";
        }
        if(!temMaiuscula) {
            return "Dica: Senha deve conter pelo menos uma letra maiúscula";
        }

        return "Senha válida!";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String senha;
        String resultado;

        do {
            System.out.println("Digite sua senha:");
            senha = scanner.nextLine();

            resultado = avaliarSenha(senha);
            System.out.println(resultado);

        } while (!resultado.equals("Senha válida!"));

        scanner.close();
    }
}