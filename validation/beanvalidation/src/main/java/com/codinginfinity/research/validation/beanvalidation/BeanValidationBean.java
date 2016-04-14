package com.codinginfinity.research.validation.beanvalidation;

import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Stateless
@Local(Validation.ValidationLocal.class)
//@Remote(Validation.ValidationRemote.class)
@Service
public class BeanValidationBean implements Validation.ValidationLocal, Validation.ValidationRemote
{
    private static final Logger logger = LoggerFactory.getLogger(BeanValidationBean.class);

    @Inject
    private Validator validator;

    @Override
    public ValidateObjectResponse validateObject(Validation.ValidateObjectRequest validateObjectRequest) throws RequestNotValidException {
        if (validateObjectRequest == null)
        {
            throw new RequestNotValidException("A ValidateObjectRequest must be specified.");
        }
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(validateObjectRequest);
        if (!constraintViolations.isEmpty())
        {
            throw new RequestNotValidException(buildMessage(constraintViolations));
        }
        if (validateObjectRequest.getObject() == null)
        {
            throw new RequestNotValidException("A " + validateObjectRequest.getObjectType().getSimpleName() +
                " must be specified.");
        }

        constraintViolations = validator.validate(validateObjectRequest.getObject());

        ValidateObjectResponse validateObjectResponse = new ValidateObjectResponse();

        if (!constraintViolations.isEmpty())
        {
            validateObjectResponse.setValid(false);
            validateObjectResponse.setMessage(buildMessage(constraintViolations));
        }
        else
        {
            validateObjectResponse.setValid(true);
        }

        return validateObjectResponse;
    }

    private String buildMessage(Set<ConstraintViolation<Object>> constraintViolations)
    {
        StringBuilder message = new StringBuilder();

        int count = 0;
        for (ConstraintViolation<?> constraintViolation : constraintViolations)
        {
            count++;

            if (count > 1)
            {
                message.append(" ");
            }

            message.append(constraintViolation.getMessage());
        }

        return message.toString();
    }
}