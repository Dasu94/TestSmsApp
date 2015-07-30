package hms.smsApp.smsConnector;

import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.sms.MoSmsListener;
import hms.kite.samples.api.sms.SmsRequestSender;
import hms.kite.samples.api.sms.messages.MoSmsReq;
import hms.kite.samples.api.sms.messages.MtSmsReq;
import hms.smsApp.domain.Book;
import hms.smsApp.repository.BookRepositoryMysqlDBlmpl;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dasuni on 7/27/15.
 */
public class SimpleClient implements MoSmsListener {

    private String message;
    BookRepositoryMysqlDBlmpl bookRepositoryMysqlDBlmpl = new BookRepositoryMysqlDBlmpl();

    @Override
    public void init() {

    }

    /**
     *
     * @param moSmsReq
     */
    @Override
    public void onReceivedSms(MoSmsReq moSmsReq) {

        //assigning the recieved message to the String message
        message = moSmsReq.getMessage();

        try {
            //
            sendResponse(moSmsReq);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SdpException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param moSmsReq
     * @throws MalformedURLException
     * @throws SdpException
     */
    private void sendResponse(MoSmsReq moSmsReq) throws MalformedURLException, SdpException {

        SmsRequestSender smsMtSender = new SmsRequestSender(new URL("http://localhost:7000/sms/send"));

        MtSmsReq mtSmsReq;

        mtSmsReq = createSimpleMtSms(moSmsReq);

        mtSmsReq.setApplicationId(moSmsReq.getApplicationId());
        mtSmsReq.setPassword("");
        mtSmsReq.setSourceAddress("");
        mtSmsReq.setVersion(moSmsReq.getVersion());

        smsMtSender.sendSmsRequest(mtSmsReq);

    }

    /**
     * creates MTSmsReq object which holds the reply message
     * @param moSmsReq
     * @return
     */
    private MtSmsReq createSimpleMtSms(MoSmsReq moSmsReq) {
        MtSmsReq mtSmsReq = new MtSmsReq();

        //covert string type message to int
        int bookid = Integer.parseInt(message);

        //
        Book book = bookRepositoryMysqlDBlmpl.checkBook(bookid);
        String name = book.getName();

        //sets the message want to display
        mtSmsReq.setMessage("Name :" + name + " Availability : " + book.isAvailable());
        List<String> addressList = new ArrayList<String>();
        addressList.add(moSmsReq.getSourceAddress());
        mtSmsReq.setDestinationAddresses(addressList);

        return mtSmsReq;
    }

}
