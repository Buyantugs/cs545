package mvc;

public class CalculationError {
    private String errorMessage;

    public CalculationError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CalculationError() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
