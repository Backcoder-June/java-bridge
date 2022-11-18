package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeString = Console.readLine();
        if (!bridgeSizeString.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        int bridgeSize = Integer.parseInt(bridgeSizeString);
        if (bridgeSizeString.matches("\\d+") && (bridgeSize < 3 || 20 < bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        if (!moving.matches("(U|D){1}")) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D 만 입력 가능합니다. ( U : 위, D : 아래 ) ");
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        if (!gameCommand.matches("(R|Q){1}")) {
            throw new IllegalArgumentException("[ERROR] R 혹은 Q 만 입력 가능합니다. ( 재시작 : R, 종료 : Q ) ");
        }
        return gameCommand;
    }
}
