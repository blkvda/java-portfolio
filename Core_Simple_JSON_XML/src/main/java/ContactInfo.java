public class ContactInfo {
    private String operator;
    private String number;

    public ContactInfo() {}

    public ContactInfo(String operator, String number) {
        this.operator = operator;
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "operator='" + operator + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
