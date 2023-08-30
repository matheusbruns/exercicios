import java.util.List;

public class TrainMovement {
    public static int moveTrain(List<Direction> commands) {
        int currentPosition = 0;

        for (Direction command : commands) {
            if (command == Direction.DIREITA) {
                currentPosition++;
            } else if (command == Direction.ESQUERDA) {
                currentPosition--;
            }
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        List<Direction> commands = List.of(Direction.ESQUERDA, Direction.DIREITA, Direction.DIREITA, Direction.DIREITA, Direction.DIREITA, Direction.ESQUERDA);

        int initialPosition = 0;
        int finalPosition = moveTrain(commands);

        System.out.println("Comandos: " + commands);
        System.out.println("Posição Inicial: " + initialPosition);
        System.out.println("Posição Final: " + finalPosition);
    }
}

enum Direction {
    ESQUERDA,
    DIREITA
}