package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<String> bridgeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String randomBridge = String.valueOf(new BridgeMaker(bridgeNumberGenerator).bridgeNumberGenerator.generate());
            if (randomBridge.equals("1")) {
                bridgeList.add("U");
            }
            if (randomBridge.equals("0")) {
                bridgeList.add("D");
            }
        }
        return bridgeList;
    }

    public List<String> makeBridgeForm(int size) {
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


    public static Map<Integer, String> makeAnswerBridge(List<String> bridge, List<String> randomBridge) {
        Map<Integer, String> bridgeMap = convertListToMap(bridge);
        for (int i = 0; i < randomBridge.size(); i++) {
            if (randomBridge.get(i).equals("U")) {
                bridgeMap.put(1, indexBlankChanger(bridgeMap.get(1), i));
            }
            if (randomBridge.get(i).equals("D")) {
                bridgeMap.put(0, indexBlankChanger(bridgeMap.get(0), i));
            }
        }
        return bridgeMap;
    }

    public static String indexBlankChanger(String eachLine, int index) {
        char[] chars = eachLine.toCharArray();
        chars[index * 4 + 2] = ' ';
        return String.valueOf(chars);
    }

    public static String indexOXChanger(String eachLine, int index, String checker) {
        char[] chars = eachLine.toCharArray();
        if (checker.equals("O")) {
            chars[index * 4 + 2] = 'O';
        }
        if (checker.equals("X")) {
            chars[index * 4 + 2] = 'X';
        }
        return String.valueOf(chars);
    }

    public static Map<Integer, String> convertListToMap(List<String> bridge) {
        Map<Integer, String> bridgeMap = new HashMap<>();
        for (int i = 0; i < bridge.size(); i++) {
            bridgeMap.put(i, bridge.get(i));
        }
        return bridgeMap;
    }

}
