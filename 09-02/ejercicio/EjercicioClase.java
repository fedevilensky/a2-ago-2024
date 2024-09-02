import java.util.Scanner;

public class EjercicioClase {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for (int i = 0; i < N; i++) {
      int idPlato = sc.nextInt();
      int costo = sc.nextInt();

      System.out.println(
          "ID del plato es " + idPlato + " con un costo de " + costo);
    }

    sc.close();
  }
}
