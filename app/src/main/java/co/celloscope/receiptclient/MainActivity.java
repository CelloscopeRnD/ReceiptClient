package co.celloscope.receiptclient;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String BARCODE_READER_CLASS_NAME = "co.celloscope.barcodereader.CameraActivity";
    private static final String BARCODE_READER_PACKAGE_NAME = "co.celloscope.barcodereader";
    private static final int REQUEST_CODE_READ_BARCODE = 1;
    private static final String NAME = "NAME";
    private static final String PIN = "PIN";
    private static final String DOB = "DOB";
    private static final String BARCODE_TYPE = "BarcodeType";
    private static final String BARCODE_CONTENT = "BarcodeContent";
    private static final String PDF417 = "PDF417";
    private static final String NID = "NID";
    private boolean isPDF417RequestSend = false;

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
                startBarcodeReader(PDF417, NID);
                isPDF417RequestSend = true;
            }
        });
    }

    private void startBarcodeReader(String barcodeType, String barcodeContent) {
        Intent intent = new Intent();
        intent.putExtra(BARCODE_TYPE, barcodeType);
        intent.putExtra(BARCODE_CONTENT, barcodeContent);
        intent.setComponent(new ComponentName(BARCODE_READER_PACKAGE_NAME, BARCODE_READER_CLASS_NAME));
        startActivityForResult(intent, REQUEST_CODE_READ_BARCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_READ_BARCODE) {
            if (resultCode == RESULT_OK) {
                String message;
                if (isPDF417RequestSend) {
                    message = "Name: " + data.getStringExtra(NAME) + "\nPin: " + data.getStringExtra(PIN) + "\nDOB: " + data.getStringExtra(DOB);
                } else {
                    message = "Pin: " + data.getStringExtra(PIN);
                }
                new AlertDialog.Builder(this)
                        .setMessage(message)
                        .setCancelable(false)
                        .setNeutralButton("OK", null).show();
            } else {
                Toast.makeText(MainActivity.this, R.string.noResultFound, Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
