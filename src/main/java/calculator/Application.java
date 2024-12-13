package calculator;

import calculator.domain.controller.CalculatorController;
import calculator.domain.view.InputView;
import calculator.domain.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(inputView, outputView);
        calculatorController.execute();
    }
}
