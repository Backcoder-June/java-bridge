package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    Application api = new Application();

    public void askBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n" +
                "\n" +
                "다리의 길이를 입력해주세요.");
    }

    public void askUpDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> printMap(Map<Integer, String> moveResult, int count) {
        List<String> bridgeList = new ArrayList<>();
        String upBridge = moveResult.get(0).substring(0, (count + 1) * 4);
        upBridge += "]";
        bridgeList.add(upBridge);
        String downBridge = moveResult.get(1).substring(0, (count + 1) * 4);
        downBridge += "]";
        bridgeList.add(downBridge);
        System.out.println(upBridge + "\n" + downBridge);
        return bridgeList;
    }

    public void askRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int successChecker, List<String> bridgeList) {
        if (successChecker == 0) {
            System.out.println("\n최종 게임 결과\n" + bridgeList.get(0) + "\n" + bridgeList.get(1)  +
                    "\n\n게임 성공 여부: 실패\n총 시도한 횟수: " + api.tryCount );
        }
        if (successChecker == 1) {
            System.out.println("\n최종 게임 결과\n" + bridgeList.get(0) + "\n" + bridgeList.get(1)  +
                    "\n\n게임 성공 여부: 성공\n총 시도한 횟수: " + api.tryCount );
        }
    }

}
