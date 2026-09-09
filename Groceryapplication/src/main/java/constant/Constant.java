package constant;

public class Constant {
	
	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\MainProjectSheet.xlsx";
	
	public static final String VALIDCREDENTIALERROR="User is unable to Login with valid credentials";
    public static final String INVALIDCREDENTIALERROR="User is able to login with invalid credentials";
    public static final String VALIDUSERNAMEANDINVALIDPASSWORDERROR="User is able to login with Valid Username And Invalid Password";
    public static final String INVALIDUSERNAMEANDVALIDPASSWORDERROR="User is able to login with invalid Username And valid Password";
    
    public static final String LOGOUTFROMHOMEPAGEERROR="User is unable to logout";
    
    public static final String ADDNEWADMINUSERSERROR="Unable to create new user";
    public static final String SEARCHNEWLYADDEDUSERERROR="user not added";
    
    public static final String ADDNEWDETAILSTODELIVERYBOYERROR="Alert is not dsipalyed";
    public static final String SEARCHNEWLYADDEDDETAILSERROR="Data is not displayed on table";

    public static final String ADDNEWSTOMANAGENEWSERROR="Alert is not displayed";
    public static final String SEARCHNEWLYADDEDNEWSERROR="Data is not displayed on the table";
}

