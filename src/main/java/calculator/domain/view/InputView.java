package calculator.domain.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView{

    public String enteredInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return getInput();
    }


    private String getInput() {
        return Console.readLine();
    }
}
