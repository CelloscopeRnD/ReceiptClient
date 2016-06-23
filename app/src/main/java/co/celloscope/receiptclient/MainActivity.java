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
                Integer code = Receipts.INWARD_FOREIGN_REMITTANCE.getReceiptCode();
                startPrinting(code,
                        MockData.getMockJsonString(code),
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
