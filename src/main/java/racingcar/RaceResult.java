package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceResult {
    private Map<String, List<Boolean>> record;

    public RaceResult(Map<String, List<Boolean>> record) {
        this.record = record;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, List<Boolean>> r : record.entrySet()) {
            String carName = r.getKey();
            int forwardCnt = (int) r.getValue().stream().filter(val -> val).count();

            if (forwardCnt > max) {
                winners.clear();
                winners.add(carName);
                max = forwardCnt;
            } else if (forwardCnt == max) {
                winners.add(carName);
            }
        }
        return winners;
    }
}
