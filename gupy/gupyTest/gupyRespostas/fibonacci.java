import java.util.Scanner;

    public class fibonacci {
        public static boolean isfibonacci(int n) {
            if (n < 0) return false;
            
            int a = 0, b = 1;
            while (a < n) {
                int temp = a;
                a = b;
                b = temp + b;
            }
            
            return a == n;
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe um número: ");
            int number = scanner.nextInt();
            
            if (isfibonacci(number)) {
                System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
            }
            
            scanner.close();
        }
    }

    

