import java.util.List;

public class BoundedTrainMovement {
    public static int moveTrain(List<Direction> commands, int lowerBound, int upperBound) {
        int currentPosition = 0;

        for (Direction command : commands) {
            if (command == Direction.DIREITA && currentPosition < upperBound) {
                currentPosition = Math.min(currentPosition + 1, upperBound);
            } else if (command == Direction.ESQUERDA && currentPosition > lowerBound) {
                currentPosition = Math.max(currentPosition - 1, lowerBound);
            }
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        List<Direction> commands = List.of(Direction.ESQUERDA, Direction.DIREITA, Direction.DIREITA, Direction.DIREITA, Direction.DIREITA, Direction.ESQUERDA);

        int lowerBound = -2;
        int upperBound = 10;

        int initialPosition = 0;
        int finalPosition = moveTrain(commands, lowerBound, upperBound);

        System.out.println("Comandos: " + commands);
        System.out.println("Posição Inicial: " + initialPosition);
        System.out.println("Posição Final: " + finalPosition);
    }
}

enum Direction {
    ESQUERDA,
    DIREITA
}