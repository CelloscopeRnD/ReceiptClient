package co.celloscope.receiptclient;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.print.PrintJobInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    static final int PRINT_RECEIPT = 1;
//    private static final String RECEIPT_SERVICE_CLASS_NAME = "net.celloscope.common.android.printing.esc.MainActivity";
//    private static final String RECEIPT_SERVICE_PACKAGE_NAME = "net.celloscope.common.android.printing.esc";

    private static final String RECEIPT_SERVICE_CLASS_NAME = "net.celloscope.common.android.printing.esc.printing.PrinterActivity";
    private static final String RECEIPT_SERVICE_PACKAGE_NAME = "net.celloscope.common.android.printing.esc.printing";
    private static final String RECEIPT_TYPE = "ReceiptType";
    private static final String JSON_DATA = "JsonData";
    private static final String PRINTER_BLUETOOTH_MAC_ADDRESS = "PrinterBluetoothMacAddress";

    private static final String CHINESE_PRINTER_ADDRESS = "0F:03:E0:C2:3E:0F";
    private static final String REGO_PRINTER_ADDRESS = "00:0E:0E:02:0B:13";
    private static final String DATECS_PRINTER_ADDRESS = "00:01:90:C1:FC:DB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPrinting(Receipts.ACCOUNT_OPENING_FIXED_DEPOSIT.getReceiptCode(),
                        "{ \"accountName\": \"MD Arif Gazi\", \"accountNumber\": \"2001158500126\", \"agentName\": \"BADRUL ALOM\", \"balanceAmount\": \"BDT 80,550.00\", \"balanceAmountInWords\": \"EIGHTY THOUSAND FIVE HUNDRED FIFTY ONLY\", \"boothAddress\": \"VAIRAB BAZAR, CHOWDHURYR HAT, SONAGAZI\", \"charge\": \"BDT 7.50\", \"customerAddress\": \"GREEN GADEN BUILDING, FLAT- D4, HOUSE- 12, ROAD- 10, BLOCK- C, MIRPUR, PS- MIRPUR, DHAKA\", \"customerId\": \"CB1158500\", \"customerName\": \"Md. Arif Gazi\", \"depositAmountInWords\": \"THREE THOUSAND ONLY\", \"depositAmount\": \"BDT 3,000.00\", \"dpsAccountType\": \"DPS\", \"linkAccountNumber\": \"2005246987526\", \"maturityAmount\": \"BDT 2,26,047.00\", \"maturityDate\": \"19-JAN-2021\", \"mobileNo\": \"01617877595\", \"principalAmount\": \"BDT 1,00,000.00\", \"printDate\": \"19-JAN-2016 13:13:15 PM\", \"productTenor\": \"5 Years\", \"profitRate\": \"8.85% (Yearly)\", \"receiverAccountName\": \"SUJON PATWARY\", \"termDepositAccountType\": \"TERM DEPOSIT\", \"transactionDate\": \"19-JAN-2016\", \"savingsAccountType\": \"Savings\", \"transactionCode\": \"TR222369\", \"userId\": \"615001001 (NAIM ISLAM)\", \"withdrawAmount\": \"BDT 3,000.00 + 7.5 (Charge)\", \"withdrawsAmountInWords\": \"THREE THOUSAND SEVEN TAKA FIFTY PAISA ONLY\", \"photo\": \"123\" , \"requestId\": \"7E:B6:46:65:82:26/7E:B6:46:65:82:26###20160116153100\"}",
                        CHINESE_PRINTER_ADDRESS);
            }
        });
    }

    private void startPrinting(Integer receiptType, String jsonData, String printerBluetoothMacAddress) {
        Intent intent = new Intent();
        intent.putExtra(RECEIPT_TYPE, receiptType);
        intent.putExtra(JSON_DATA, jsonData);
        intent.putExtra(PRINTER_BLUETOOTH_MAC_ADDRESS, printerBluetoothMacAddress);
        intent.setComponent(new ComponentName(RECEIPT_SERVICE_PACKAGE_NAME, RECEIPT_SERVICE_CLASS_NAME));
        startActivityForResult(intent, PRINT_RECEIPT);

//        startActivity(intent);
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
