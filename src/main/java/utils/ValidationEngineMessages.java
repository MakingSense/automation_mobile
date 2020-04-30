package utils;

public class ValidationEngineMessages {

    public static String biometricMessageNotCorrect() {
        return "Message is not correct";
    }

    public static String biometricLabelIsNotPresent() {
        return "Biometric label is not present";
    }

    public static String biometricSwitchStatusNotCorrect(String status) {
        return "Biometric switch status is not " + status;
    }
}
