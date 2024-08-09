package AlignTogetherTest;

public class AlignTogetherMainClass {

	public static void main(String[] args) throws Exception{
		AlignTogether ag =new AlignTogether();
		ag.invokeBrowser();
		ag.sessionBookingPage();
		ag.booking();
		ag.loginPageRedirect();
		ag.login();
		ag.loginCredInput();
		ag.confirmUserName();
		ag.confirmationDone();
		ag.closeBrowser();
		}

}
