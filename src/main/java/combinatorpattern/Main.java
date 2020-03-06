package combinatorpattern;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;
import static combinatorpattern.CustomerRegistrationValidator.isAdult;
import static combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alicegmail.com",
                "+09312831283",
                LocalDate.of(2000, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // using combinator pattern
        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
