package calculator.domain.util;

import calculator.domain.view.error.ErrorException;
import calculator.domain.view.error.InputErrorType;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputParser {
    private final String COMMA = "\\s*,\\s*";


    // 쉼표 기준으로 나누기, 나눈 게 n 개인지 검사
    private String[] extractValidInput(String input) throws ErrorException {
        checkIsEmpty(input);
        String[] splitInput = input.split(COMMA);
        if (splitInput.length != 2) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
        return splitInput;
    }

    // 공백 검사
    private void checkIsEmpty(String input) throws ErrorException {
        if (input.isEmpty()) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
    }


    public static <T> T get(Supplier<String> inputSupplier, Function<String, T> converter) {
        while (true) {
            String input = inputSupplier.get();
            try {
                return converter.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
