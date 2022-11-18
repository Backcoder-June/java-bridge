package bridge;

import java.util.List;
import java.util.Map;

public class Application {
    public static int tryCount = 1;
    public static int updownCount = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            OutputView outputView = new OutputView();
            InputView inputView = new InputView();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame();

            outputView.askBridgeSize();
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridgeForm(size);
            List<String> randomBridge = bridgeMaker.makeBridge(size);
            for (String ra:randomBridge
                 ) {
                System.out.println("랜덤 : " + ra);

            }

            Map<Integer, String> answerBridge = bridgeMaker.makeAnswerBridge(bridge, randomBridge);


            while (true) {
                outputView.askUpDown();
                String updown = inputView.readMoving();
                Map<Integer, String> moveResult = bridgeGame.move(answerBridge, updown, updownCount);
                Map<Integer, String> moveFinalResult = bridgeGame.failChecker(moveResult, updown, updownCount);
                List<String> bridgeList = outputView.printMap(moveFinalResult, updownCount);
                if (bridgeGame.breaker(bridgeList, updownCount, size) == 1) {
                    outputView.askRetry();
                    String readRetry = inputView.readGameCommand();
                    if (readRetry.equals("R")) {
                        answerBridge = bridgeGame.retry(readRetry, bridge, randomBridge);
                        continue;
                    }
                    if (readRetry.equals("Q")) {
                        outputView.printResult(0, bridgeList);
                        break;
                    }
                }
                if (bridgeGame.breaker(bridgeList, updownCount, size) == 2) {
                    outputView.printResult(1, bridgeList);
                    break;
                }
                updownCount++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
