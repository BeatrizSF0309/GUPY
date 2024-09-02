import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();

        // Chamada do método para inverter a string
        String inverted = inverterString(input);

        // Exibição do resultado
        System.out.println("String invertida: " + inverted);
    }

    public static String inverterString(String str) {
        // Inicializa uma StringBuilder para armazenar a string invertida
        StringBuilder inverted = new StringBuilder();
        
        // Loop para inverter a string
        for (int i = str.length() - 1; i >= 0; i--) {
            inverted.append(str.charAt(i));
        }
        
        return inverted.toString();
    }
}