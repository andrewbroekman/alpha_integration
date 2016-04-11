package com.codinginfinity.research.validation.beanvalidation.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.Response;
import com.codinginfinity.research.validation.Validation;
import org.springframework.stereotype.Service;

@Stateless
@Service
public class ServiceValidationUtilities
{
    @Inject
    private Validation.ValidationLocal validation;

    public <T extends Request> void validateRequest(Class<T> requestType, T request) throws RequestNotValidException
    {
        Validation.ValidateObjectResponse validateObjectResponse = validation.validateObject(new Validation
            .ValidateObjectRequest<>(requestType, request));

        if (!validateObjectResponse.getValid())
        {
            throw new RequestNotValidException(validateObjectResponse.getMessage());
        }
    }

    public <T extends Response> void validateResponse(Class<T> responseType, T response) throws RequestNotValidException
    {
        Validation.ValidateObjectResponse validateObjectResponse = validation.validateObject(new Validation
            .ValidateObjectRequest<>(responseType, response));

        if (!validateObjectResponse.getValid())
        {
            throw new RequestNotValidException(validateObjectResponse.getMessage());
        }
    }
}