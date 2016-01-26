package co.celloscope.receiptclient;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int PRINT_RECEIPT = 1;
    private static final String RECEIPT_SERVICE_CLASS_NAME = "co.celloscope.printingdemo.MainActivity";
    private static final String RECEIPT_SERVICE_PACKAGE_NAME = "co.celloscope.printingdemo";
    private static final String RECEIPT_TYPE = "ReceiptType";
    private static final String JSON_DATA = "JsonData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startPrinting("1", "{ \"accountName\": \"MD Arif Gazi\", \"accountNumber\": \"2001158500126\", \"agentName\": \"BADRUL ALOM\", \"balanceAmount\": \"BDT 80,550.00\", \"balanceAmountInWords\": \"EIGHTY THOUSAND FIVE HUNDRED FIFTY ONLY\", \"boothAddress\": \"VAIRAB BAZAR, CHOWDHURYR HAT, SONAGAZI\", \"charge\": \"BDT 7.50\", \"customerAddress\": \"GREEN GADEN BUILDING, FLAT- D4, HOUSE- 12, ROAD- 10, BLOCK- C, MIRPUR, PS- MIRPUR, DHAKA\", \"customerId\": \"CB1158500\", \"customerName\": \"Md. Arif Gazi\", \"depositAmountInWords\": \"THREE THOUSAND ONLY\", \"depositAmount\": \"BDT 3,000.00\", \"dpsAccountType\": \"DPS\", \"linkAccountNumber\": \"2005246987526\", \"maturityAmount\": \"BDT 2,26,047.00\", \"maturityDate\": \"19-JAN-2021\", \"mobileNo\": \"01617877595\", \"principalAmount\": \"BDT 1,00,000.00\", \"printDate\": \"19-JAN-2016 13:13:15 PM\", \"productTenor\": \"5 Years\", \"profitRate\": \"8.85% (Yearly)\", \"receiverAccountName\": \"SUJON PATWARY\", \"termDepositAccountType\": \"TERM DEPOSIT\", \"transactionDate\": \"19-JAN-2016\", \"savingsAccountType\": \"Savings\", \"transactionCode\": \"TR222369\", \"userId\": \"615001001 (NAIM ISLAM)\", \"withdrawAmount\": \"BDT 3,000.00 + 7.5 (Charge)\", \"withdrawsAmountInWords\": \"THREE THOUSAND SEVEN TAKA FIFTY PAISA ONLY\" }");
                startPrinting("3", "{\"agentName\":\"Badrul Alam\",\"accountName\":\"MD.ARIF ZIGA\",\"boothAddress\":\"Malibag\",\"accountNumber\":\"2001158500126\",\"savingsAccountType\":\"Savings\",\"customerName\":\"MD.ARIF GAZI\",\"customerId\":\"CB1158500\",\"withdrawAmount\":\"BDT 3,000.00 + 7.5 (Charge)\",\"withdrawsAmountInWords\":\"THREE THOUSAND SEVEN TAKA FIFTY PAISA ONLY\",\"charge\":\"7.5%\",\"transactionDate\":\"15-DEC-2016\",\"transactionCode\":\"TR222369\",\"userId\":\"676666011(NAIM ISLAM)\",\"printDate\":\"15-DEC-2016 7:09 PM\",\"customerAddress\":\"KALLAYANPUR\",\"mobileNo\": \"01617877595\"}");
            }
        });
    }

    private void startPrinting(String receiptType, String jsonData) {
        Intent intent = new Intent();
        intent.putExtra(RECEIPT_TYPE, receiptType);
        intent.putExtra(JSON_DATA, jsonData);
        intent.setComponent(new ComponentName(RECEIPT_SERVICE_PACKAGE_NAME, RECEIPT_SERVICE_CLASS_NAME));
        startActivityForResult(intent, PRINT_RECEIPT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PRINT_RECEIPT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "Printed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Not Printed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
