//package application.Examples;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Stripess {
//    public static void main(String arg[]) throws StripeException {
//        Stripe.apiKey = "sk_test_l2L2SUuWj3PNrSVVm7OsT0kP00k6zPSEpX";
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("limit", 3);
//        params.put("customer","cus_GSEqR02nOWPxDP");
//
//        SubscriptionCollection subscriptions =
//                Subscription.list(params);
//
//        System.out.println(subscriptions);
//
//    }
//}
