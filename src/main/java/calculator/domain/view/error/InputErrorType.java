package calculator.domain.view.error;

public enum InputErrorType {

    ERROR_MESSAGE("[ERROR] "),
    NEED_AVAILABLE_FORMAT("올바르지 않은 형식으로 입력했습니다."),
    NEED_POSITIVE_NUMBER_AND_SEPARATOR("양수와 구분자만 입력해야 합니다."),
    NEED_AVAILABLE_INPUT("잘못된 입력입니다."),
    NEED_REENTER_INPUT(" 다시 입력해 주세요.");

    final String message;

    InputErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
