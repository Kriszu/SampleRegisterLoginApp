package com.hellokoding.auth.validator;

import com.hellokoding.auth.model.Thread;
import com.hellokoding.auth.service.ThreadService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Kriszu on 24.10.2017.
 */
@Component
public class ThreadValidator implements Validator {

    private ThreadService threadService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Thread.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {
        Thread thread = (Thread) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        if (thread.getTitle().length() < 6 || thread.getTitle().length() > 32) {
            errors.rejectValue("title", "Size.threadForm.title");
        }
/*        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "NotEmpty");
        if (thread.getContent().length() < 8 || thread.getContent().length() > 320) {
            errors.rejectValue("content", "Size.threadForm.content");
        }

/*        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }*/
    }
}
