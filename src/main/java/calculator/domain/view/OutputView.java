package calculator.domain.view;

public class OutputView {

    private static final String newline = System.getProperty("line.separator");

    public void displayResult(String result) {
        System.out.println("결과 : "+ result);
    }


}
