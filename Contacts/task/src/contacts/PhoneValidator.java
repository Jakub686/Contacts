package contacts;

public class PhoneValidator {


    public String numberValidator(String num) {
        String result = "";
        boolean numberCheck = (
                num.matches("^(\\+\\d{1}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{3}[- .]?\\d{5}$")|
                num.matches("^(\\+\\d{1}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{3}[- .]?\\w{4}$") |
                num.matches("^\\(\\d{3}\\) ([0-9]{3}) ([0-9]{3})-([0-9]{3})$")|
                num.matches("([0-9]{3}) ([0-9]{3}) ([0-9]{3})$") |
                num.matches("(.\\([a-zA-Z]{7}\\))") |
                num.matches("(.\\([a-zA-Z]{7}\\))") |
                num.matches("(.\\([a-zA-Z]{5}\\))") |
                num.matches("^([0-9]{3}) ([0-9]{2})-([a-zA-Z]{4})-([0-9]{2})") |
                num.matches("^([0-9]{3}) \\(\\d{2}\\)-([0-9]{2})-([0-9]{2})") |
                num.matches("^([0-9]{3}) ([0-9]{2})-([a-zA-Z]{2})-([0-9]{2})") |
                num.matches("^\\+\\d{1} \\d{2}$") |
                num.matches("^\\d{1}$") |
                num.matches("^\\d{3}$") |
                num.matches("\\(\\d{3}\\)") |
                num.matches("^([0-9]{3}) ([a-zA-Z]{3})$") |
                num.matches("^([0-9]{3})-\\(\\d{3}\\)$") |
                num.matches("^\\(\\d{3}\\) ([0-9]{3})$") |
                num.matches("^\\(\\d{3}\\) ([0-9]{3})-([0-9]{3})$") |
                num.matches("^\\(\\d{3}\\)-([0-9]{3}) ([0-9]{3})$") |
                num.matches("^([0-9]{3})-\\(\\d{3}\\)$") |
                num.matches("^([0-9]{3}) \\(\\d{3}\\) ([0-9]{3})$") |
                num.matches("^([0-9]{3})-\\(\\d{3}\\)-([0-9]{3})$") |
                num.matches("^([0-9]{3})-([a-zA-Z]{3})$") |
                num.matches("^([0-9]{3}) ([0-9]{3}) ([a-zA-Z]{3})$") |
                num.matches("^([0-9]{3}) ([0-9]{3})-([0-9]{3})$") |
                num.matches("^([0-9]{3})-([0-9]{3})-([a-zA-Z]{3})$") |
                num.matches("^([0-9]{3})-([0-9]{3}) ([0-9]{3})$"));
        if (numberCheck == true) {
            result = num;
        } else {
            new View().showWrongNumberFormat();
            result = "[no number]";
        }
        return result;
    }
}
