package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class HelloLottoIssueServiceImpl implements LottoIssueService {
    @Override
    public IssuedLotto issueLotto(long price) {

        int lottosCnt = (int) (price/1000);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottosCnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);

        }

        IssuedLotto issuedLotto = new IssuedLotto(lottos);

        Writer.println("\n"+lottosCnt + "개를 구매했습니다.");
        Writer.println(issuedLotto);

        return issuedLotto;
    }

    @Override
    public WinLotto issueWinLotto(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto(numbers);
        return new WinLotto(lotto, bonusNumber);
    }
}
