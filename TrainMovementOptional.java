import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainMovementOptional {
    public static int moveTrain(List<Direction> commands, int initialPosition, int lowerBound, int upperBound, boolean isBounded) {
        int currentPosition = initialPosition;

        for (Direction command : commands) {
            if (command == Direction.DIREITA && (!isBounded  currentPosition < upperBound)) {
                currentPosition = isBounded ? Math.min(currentPosition + 1, upperBound) : currentPosition + 1;
            } else if (command == Direction.ESQUERDA && (!isBounded  currentPosition > lowerBound)) {
                currentPosition = isBounded ? Math.max(currentPosition - 1, lowerBound) : currentPosition - 1;
            }
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o tipo de trilho (infinito ou finito): ");
        String railType = scanner.next();

        boolean isBounded = railType.equalsIgnoreCase("finito");

        System.out.print("Informe o limite inferior do trilho: ");
        int lowerBound = scanner.nextInt();

        System.out.print("Informe o limite superior do trilho: ");
        int upperBound = scanner.nextInt();

        System.out.print("Informe a posição inicial do trem: ");
        int initialPosition = scanner.nextInt();

        System.out.print("Informe a quantidade de comandos (máximo 30): ");
        int numCommands = Math.min(scanner.nextInt(), 30);

        List<Direction> commands = new ArrayList<>();
        for (int i = 0; i < numCommands; i++) {
            System.out.print("Comando " + (i + 1) + " (ESQUERDA ou DIREITA): ");
            Direction direction = Direction.valueOf(scanner.next().toUpperCase());
            commands.add(direction);
        }

        int finalPosition = moveTrain(commands, initialPosition, lowerBound, upperBound, isBounded);

        System.out.println("Comandos: " + commands);
        System.out.println("Posição Inicial: " + initialPosition);
        System.out.println("Posição Final: " + finalPosition);
    }
}

enum Direction {
    ESQUERDA,
    DIREITA
}