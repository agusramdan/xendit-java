import com.xendit.Xendit;
import com.xendit.exception.XenditException;
import com.xendit.model.Invoice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExampleGetInvoice {
    private static void getById() {
        try {
            Invoice invoice = Invoice.getById("5e0cb0bbf4d38b20d5421b72");
            System.out.println(invoice);
        } catch (XenditException e) {
            e.printStackTrace();
        }
    }

    private static void getAll() {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("limit", 2);
            params.put("statuses", "[\"SETTLED\",\"EXPIRED\"]");
            params.put("client_types", "[\"DASHBOARD\",\"API_GATEWAY\"]");
            params.put("last_invoice_id", "5ca186e407f3b83e34176eac");
            Invoice[] invoices = Invoice.getAll(params);
            System.out.println(Arrays.toString(invoices));
        } catch (XenditException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Xendit.apiKey = "xnd_development_...";
        getAll();
    }
}
