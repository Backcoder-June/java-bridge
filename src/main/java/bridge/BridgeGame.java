package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Application api = new Application();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<Integer,String> move(Map<Integer, String> answerBridge, String updown, int count) {
        if (updown.equals(String.valueOf(answerBridge.get(0).charAt(count*4+2)))) {
            answerBridge.put(0, BridgeMaker.indexOXChanger(answerBridge.get(0), count, "O"));
        }
        if (updown.equals(String.valueOf(answerBridge.get(1).charAt(count*4+2)))) {
            answerBridge.put(1, BridgeMaker.indexOXChanger(answerBridge.get(1), count, "O"));
        }
        return answerBridge;
    }

    public Map<Integer, String> failChecker(Map<Integer, String> moveResult, String updown, int count) {
        if (moveResult.get(0).charAt(count * 4 + 2) != 'O' && moveResult.get(1).charAt(count * 4 + 2) != 'O') {
            moveResult = failBridgeMaker(moveResult, updown, count);
        }
        return moveResult;
    }

    public Map<Integer, String> failBridgeMaker(Map<Integer, String> moveResult, String updown, int count) {
        if (updown.equals("U")) {
            moveResult.put(0, BridgeMaker.indexOXChanger(moveResult.get(0), count, "X"));
            moveResult.put(1, BridgeMaker.indexBlankChanger(moveResult.get(1), count));
        }
        if (updown.equals("D")) {
            moveResult.put(1, BridgeMaker.indexOXChanger(moveResult.get(1), count, "X"));
            moveResult.put(0, BridgeMaker.indexBlankChanger(moveResult.get(0), count));
        }
        return moveResult;
    }

    public int breaker(List<String> bridgeList, int count, int size) {
        int breakChecker= 0;
        if (bridgeList.get(0).contains("X") || bridgeList.get(1).contains("X")) {
            breakChecker = 1;
        }
        if (count == size - 1 && !bridgeList.get(0).contains("X") && !bridgeList.get(1).contains("X")) {
            breakChecker = 2;
        }
        return breakChecker;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Map<Integer,String> retry(String readRetry,List<String> bridge, List<String> randomBridge) {
        Map<Integer, String> answerBridge = new HashMap<>();
            api.tryCount++;
            api.updownCount = 0;
            answerBridge = BridgeMaker.makeAnswerBridge(bridge, randomBridge);
        return answerBridge;
    }


}