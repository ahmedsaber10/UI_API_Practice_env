package Web.Util;

public enum URLs {


    HOME("http://automationpractice.com/index.php"),
    MY_ACCOUNT("http://automationpractice.com/index.php?controller=my-account"),
    LOGIN("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
