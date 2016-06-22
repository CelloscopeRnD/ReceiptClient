package co.celloscope.receiptclient;

/**
 * Created by assad on 4/19/2016.
 */
public enum Receipts {
    ACCOUNT_OPENING_FIXED_DEPOSIT(1),
    ACCOUNT_OPENING_MONEY_MAKER(2),
    AGENT_BALANCE_INQUIRY(3),
    CASH_DEPOSIT_SELF(4),
    MINI_STATEMENT(5),
    CASH_DEPOSIT_BEARER(6),
    CASH_WITHDRAWAL(7),
    BALANCE_INQUIRY(8),
    FUND_TRANSFER(9),
    INWARD_FOREIGN_REMITTANCE(10),
    BILL_COLLECTION_REQUEST(11),
    TOLL_DEPOSIT(12),
    TOLL_BALANCE_INQUIRY(13),
    TOLL_MINI_STATEMENT(14),
    SCHEME_ACCOUNT_SUMMARY(15),
    ACCOUNT_ACTIVATED(16);

    private final int receiptCode;

    private Receipts(int receiptCode) {
        this.receiptCode = receiptCode;
    }

    public int getReceiptCode() {
        return this.receiptCode;
    }
};