package co.celloscope.receiptclient;

/**
 * Created by assad on 4/19/2016.
 */
public class MockData {
    public static String getMockJsonString(int receipt) {
        switch (receipt) {
            case 1:
                return "{\"agentID\":\"AG000018\",\"customerID\":\"000000089\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"accountName\":\"ROCKY HABIB\",\"nationalID\":\"1234567885555\",\"passportNo\":\"Not Submitted\",\"tINNo\":\"Not Submitted\",\"birthRegistrationNo\":\"Not Submitted\",\"productType\":\"Time\",\"productCode\":\"712\",\"productName\":\"FIXED DEPOSIT\",\"term\":\"12\",\"initialDeposit\":\"Tk 10000.00\"}";
            case 2:
                return "{\"agentID\":\"AG000018\",\"customerID\":\"000000089\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"accountName\":\"ROCKY HABIB\",\"nationalID: \":\"1234567885555\",\"passportNo\":\"Not Submitted\",\"tINNo\":\"Not Submitted\",\"birthRegistrationNo\":\"Not Submitted\",\"productType\":\"Time\",\"productCode\":\"712\",\"productName\":\"Money Maker Individual\",\"term\":\"60\",\"startDate\":\"Sat Aug 22, 2015\",\"endDate\":\"Sat Aug 22, 2016\",\"initialDeposit\":\"Tk 10000.00\"}";
            case 3:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"availableBalance\":\"Tk 713209.00\"}";
            case 4:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"amount\":\"Tk 500.00\"}";
            case 5:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"availableBalance\":\"Tk 500.00\",\"transactions\":[[\"Mon May 16, 2016 05:35:34 AM\",\"68778172120160516053534\",\"Cash Deposit\",\"(+200.00)\"],[\"Mon May 16, 2016 05:35:34 AM\",\"68778172120160516053534\",\"Cash Deposit\",\"(+200.00)\"]]}";
            case 6:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"depositorName\":\"RASHED\",\"amount\":\"Tk 500.00\"}";
            case 7:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"amount\":\"Tk 500.00\"}";
            case 8:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"availableBalance\":\"Tk 500.00\"}";
            case 9:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"accountName\":\"TOFIQ AKBAR\",\"accountNumber\":\"018139100000812\",\"receiverAccountName\":\"Ahsan Habib\",\"receiverAccountNumber\":\"018139100000258\",\"amount\":\"Tk 500.00\"}";
            case 10:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"pin\":\"56890809\",\"amount\":\"Tk. 600.00\",\"recipientName\":\"ANIS\",\"senderCountry\":\"Saudi Arabia\",\"iDType\":\"NID\",\"idNumber\":\"1234567890809\"}";
            case 11:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"051607570832606220160516075708\",\"zoneName\":\"zianibazer-zone\",\"billingDate\":\"2016-05-16\",\"billPaymentMonth\":\"August\",\"bookNo\":\"6666\",\"accountNo\":\"123467890809\",\"netBillAmount\":\"Tk. 887.00\",\"vat\":\"Tk. 5.00\",\"transformerRent\":\"Tk. 1.00\",\"meterRent\":\"Tk. 10.00\",\"penalty\":\"Tk. 1.00\",\"others\":\"Tk. 0.00\",\"lateFee\":\"Tk. 0.00\",\"totalBill\":\"Tk. 904.00\",\"amount\":\"Tk 904.00\"}";
            case 12:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"agentStuffName\":\"TOFIQ AKBAR\",\"agentName\":\"White Moto\",\"bridgeName\":\"White Moto\",\"amount\":\"Tk 500.00\"}";
            case 13:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"tranID\":\"0822082813591258497865\",\"agentStuffName\":\"TOFIQ AKBAR\",\"agentName\":\"White Moto\",\"availableBalance\":\"Tk 500.00\"}";
            case 14:
                return "{\"agentID\":\"AG000018\",\"date\":\"Sat Aug 22, 2015 08:28:14 pm\",\"agentStuffName\":\"TOFIQ AKBAR\",\"agentName\":\"TOFIQ AKBAR\",\"availableBalance\":\"Tk 500.00\",\"transactions\":[[\"Mon May 16, 2016 05:35:34 AM\",\"68778172120160516053534\",\"Cash Deposit\",\"(+200.00)\"],[\"Mon May 16, 2016 05:35:34 AM\",\"68778172120160516053534\",\"Cash Deposit\",\"(+200.00)\"]]}";
            case 15:
                return "{\"agentID\":\"AG000018\",\"givenNumberOfInstallment\":\"0\",\"overdueInstallment\":\"0\",\"penaltyAmount\":\"Tk. 0.00\"}";
            case 16:
                return "{\"agentID\":\"AG000018\",\"customerID\":\"123456\",\"date\":\"Tue May 17, 2016 05:38:39 pm\",\"accountNumber\":\"012739100000053\",\"productType\":\"Savings\",\"accountName\":\"MD. AHSAN HABIB ROCKY\"}";
            default:
                return "";
        }

    }
}
