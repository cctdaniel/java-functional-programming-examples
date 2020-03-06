package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000098000"));
        System.out.println(isPhoneNumberValid("0700009800"));
        System.out.println(isPhoneNumberValidPredicate.test("07000098000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("07000398000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3Predicate).test("07000098000"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07")
            && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3Predicate = phoneNumber -> phoneNumber.contains("3");

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
