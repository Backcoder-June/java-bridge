package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        String eachLine = "[ ";
        for (int i = 0; i < size-1; i++) {
            eachLine += "U | ";
        }
        eachLine += "U ]";
        List<String> bridge = new ArrayList<>();
        bridge.add(eachLine);
        bridge.add(eachLine.replace("U", "D"));
        return bridge;
    }

    public List<String> getRandomBridge(int size) {
        List<String> randomBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomBridge.add(String.valueOf(new BridgeMaker(bridgeNumberGenerator).bridgeNumberGenerator.generate()));
        }
        return randomBridge;
    }

    public Map<Integer, String> makeAnswerBridge(List<String> bridge, List<String> randomBridge) {
        Map<Integer, String> bridgeMap = convertListToMap(bridge);
        for (int i = 0; i < randomBridge.size(); i++) {
            if (randomBridge.get(i).equals("1")) {
                bridgeMap.put(1, indexChanger(bridgeMap.get(1), i));
            }
            if (randomBridge.get(i).equals("0")) {
                bridgeMap.put(0, indexChanger(bridgeMap.get(0), i));
            }
        }
        return bridgeMap;
    }

    public String indexChanger(String eachLine, int index) {
        char[] chars = eachLine.toCharArray();
        chars[index * 4 + 2] = ' ';
        return String.valueOf(chars);
    }

    public Map<Integer, String> convertListToMap(List<String> bridge) {
        Map<Integer, String> bridgeMap = new HashMap<>();
        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap.put(i, bridge.get(i));
        }
        return bridgeMap;
    }


//
}
