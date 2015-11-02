package servlet.validator;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by User on 31.10.2015.
 */
public class UserValidator extends ActionSupport {

    public void validate(String login,String pas){
       if(StringUtils.isEmpty(login)){
           addFieldError("login","label.validate.loginEmpty");
       }
    }
}
