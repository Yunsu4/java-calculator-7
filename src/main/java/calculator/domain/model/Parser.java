package calculator.domain.model;

import calculator.domain.view.error.ErrorException;
import calculator.domain.view.error.InputErrorType;

public class Parser {
    public static final String BASIC_SEPARATORS = ",|:";
    private String parsedInput;
    private String separators;

    public String getSeparators() {
        return separators;
    }

    public String getParsedInput() {
        return parsedInput;
    }

    public Parser(String input) {
        separators = BASIC_SEPARATORS; // 기본 구분자 설정
        parse(input);
    }

    private void parse(String input) {
        while (input.startsWith("//")) {
            input = handleCustomSeparator(input);
        }
        parsedInput = input;
    }

    private String handleCustomSeparator(String input) {
        checkInputHasSpacing(input);
        String[] separatorAndString = getSeparatorAndString(input);
        separators += "|" + separatorAndString[0];
        return separatorAndString[1];
    }

    private void checkInputHasSpacing(String input) {
        if (input.trim().length() != input.length()) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_INPUT);
        }
    }

    private String[] getSeparatorAndString(String input) {
        int endOfTheCustomSeparator = input.indexOf("\\n");
        checkCustomSeparatorFormat(endOfTheCustomSeparator);
        String customSeparator = input.substring(2, endOfTheCustomSeparator);
        String parsedInput = input.substring(endOfTheCustomSeparator + 2);
        return new String[]{customSeparator, parsedInput};
    }

    private void checkCustomSeparatorFormat(int endOfTheCustomSeparator) {
        if (endOfTheCustomSeparator == -1) {
            throw new ErrorException(InputErrorType.NEED_AVAILABLE_FORMAT);
        }
    }
}

