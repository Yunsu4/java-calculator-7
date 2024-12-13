package calculator.domain.controller;

import calculator.domain.model.Parser;
import calculator.domain.view.InputView;
import calculator.domain.view.OutputView;
import calculator.domain.view.error.ErrorException;
import calculator.domain.view.error.InputErrorType;

public class CalculatorController {

    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute(){
        String input = inputView.enteredInput();
        Parser parser = new Parser(input);
        String separator = parser.getSeparators();
        input = parser.getParsedInput();

        String[] splitInputs = input.split(separator,-1);

        // 구분자만 2개 연속 입력된 경우 제한
        validate(splitInputs);
        int result = calculateSum(splitInputs);

        outputView.displayResult(Integer.toString(result));

    }

    private void validate(String[] splitInputs) {
        for(String splitInput: splitInputs) {
            checkIfEmpty(splitInput);
            checkIfDigit(splitInput);
        }
    }

    private int calculateSum(String[] splitInputs) {
        int result = 0;
        for(String splitInput: splitInputs) {
            result  += Integer.parseInt(splitInput);
        }
        return result;
    }

    private void checkIfEmpty(String splitInput) {
        if(splitInput == null || splitInput.isEmpty()){
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
    }

    private void checkIfDigit(String input){
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new ErrorException(InputErrorType.NEED_POSITIVE_NUMBER_AND_SEPARATOR);
            }
        }
    }
}
