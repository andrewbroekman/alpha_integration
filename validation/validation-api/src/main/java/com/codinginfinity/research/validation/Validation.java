package com.codinginfinity.research.validation;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

public interface Validation
{
    ValidateObjectResponse validateObject(ValidateObjectRequest validateObjectRequest) throws
            RequestNotValidException, RequestNotValidException;

    class ValidateObjectRequest<T> implements Request
    {
        public ValidateObjectRequest(){}

        public ValidateObjectRequest(Class<T> objectType, T object)
        {
            this.objectType = objectType;
            this.object = object;
        }

        public Class<T> getObjectType()
        {
            return objectType;
        }

        public void setObjectType(Class<T> objectType)
        {
            this.objectType = objectType;
        }

        public T getObject()
        {
            return object;
        }

        public void setObject(T object)
        {
            this.object = object;
        }

        @NotNull(message= "An object type must be specified.")
        private Class<T> objectType;
        private T object;

    }

    class ValidateObjectResponse implements Response
    {

        public ValidateObjectResponse(){}

        public ValidateObjectResponse(Boolean valid)
        {
            this.valid = valid;
        }

        public ValidateObjectResponse(Boolean valid, String message)
        {
            this.valid = valid;
            this.message = message;
        }

        public Boolean getValid()
        {
            return valid;
        }

        public void setValid(Boolean valid)
        {
            this.valid = valid;
        }

        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }

        @NotNull
        private Boolean valid;
        private String message;

    }

    interface ValidationLocal extends Validation{}

    interface ValidationRemote extends Validation{}

}