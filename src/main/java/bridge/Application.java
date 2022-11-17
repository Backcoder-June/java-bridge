package bridge;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView ov = new OutputView();
        InputView iv = new InputView();
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bg = new BridgeGame();

        ov.askBridgeSize();
        int size = iv.readBridgeSize();
        List<String> bridge = bm.makeBridge(size);
        List<String> randomBridge = bm.getRandomBridge(size);

        Map<Integer, String> answerBridge = bm.makeAnswerBridge(bridge, randomBridge);

        ov.askUpDown();
        String updown = iv.readMoving();
        bg.move(answerBridge, updown);










    }
}
