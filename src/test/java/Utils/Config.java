package Utils;

public class Config {
    private static Config instance;
    private final String registerUri;
    private final String loginUrl;
    private final String loginUriAfterRegister;
    private final String editAccountUri;
    private final String staticPassword;
    private final String webSiteUrl;

    private Config() {
        this.webSiteUrl = "https://jpetstore.aspectran.com";
        this.registerUri = "/account/newAccountForm";
        this.loginUriAfterRegister = "/account/signonForm?created=true";
        this.loginUrl = "/account/signonForm";
        this.editAccountUri = "/account/editAccountForm";
        this.staticPassword = "test123456";
    }

    public String getRegisterUri() {
        return this.registerUri;
    }

    public String getStaticPassword() {
        return this.staticPassword;
    }

    public String getLoginUriAfterRegister() {
        return this.loginUriAfterRegister;
    }

    public String getWebSiteUrl() {
        return this.webSiteUrl;
    }

    public String getLoginUrl() {
        return this.loginUrl;
    }

    public String getEditAccountUri() {
        return this.editAccountUri;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

}
