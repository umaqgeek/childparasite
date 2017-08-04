/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.DBConn;
import bean.NetConfig;
import bean.Session;
import helper.J;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Timestamp;
import java.util.ArrayList;
import oms.rmi.server.Message;

/**
 *
 * @author End User
 */
public class RMIConnector {
    
    public RMIConnector(String host, int port) {
        DBConn.setHost(host);
        DBConn.setPort_rmi(port);
    }
    
    public ArrayList<String> dgt_getDataForReceipt(int tr_id) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            data = impl.dgt_getDataForReceipt(tr_id);
            impl.sendHello("RMIConnector.dgt_getDataForReceipt ..");
        } catch (Exception e) {
            data.removeAll(data);
            data = new ArrayList<String>();
        }
        return data;
    }
    
    public String[] tr_isSend_Payment_Dpgdps(String card_id, String pin_code, int me_id_from, int me_id_to, 
            double tr_amount, int at_id, int pt_id, String tr_notes) {
        boolean status = false;
        String[] str_out = new String[2];
        str_out[0] = "-1";
        str_out[1] = "";
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            str_out = impl.tr_isSend_Payment_Dpgdps(card_id, pin_code, me_id_from, me_id_to, tr_amount, at_id, pt_id, tr_notes);
            impl.sendHello("RMIConnector.tr_isSend_Payment_Dpgdps ..");
        } catch (Exception e) {
            status = false;
            str_out[0] = "1";
            str_out[1] = "Error! "+e.getMessage();
        }
        return str_out;
    }
    
    public boolean dn_addData(ArrayList<String> bean_dinarpal_nfc) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.dn_addData(bean_dinarpal_nfc);
            impl.sendHello("RMIConnector.dn_addData ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public boolean dn_isDelete_meId(int me_id) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.dn_isDelete_meId(me_id);
            impl.sendHello("RMIConnector.dn_isDelete_meId ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public boolean dn_isDelete_nfcCode(String nfccode) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.dn_isDelete_nfcCode(nfccode);
            impl.sendHello("RMIConnector.dn_isDelete_nfcCode ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public ArrayList<String> me_getData(String me_username) {
        ArrayList<String> d = new ArrayList<String>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            d = impl.me_getData(me_username);
            impl.sendHello("RMIConnector.me_getData ..");
        } catch (Exception e) {
            d.removeAll(d);
            d = new ArrayList<String>();
        }
        return d;
    }
    
    public ArrayList<String> dn_getData_basedMeId(int me_id) {
        ArrayList<String> d = new ArrayList<String>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            d = impl.dn_getData_basedMeId(me_id);
            impl.sendHello("RMIConnector.dn_getData_basedMeId ..");
        } catch (Exception e) {
            d.removeAll(d);
            d = new ArrayList<String>();
        }
        return d;
    }
    
    public ArrayList<String> dn_getData_basedNfcCode(String dn_nfccode) {
        ArrayList<String> d = new ArrayList<String>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            d = impl.dn_getData_basedNfcCode(dn_nfccode);
            impl.sendHello("RMIConnector.dn_getData_basedNfcCode ..");
        } catch (Exception e) {
            d.removeAll(d);
            d = new ArrayList<String>();
        }
        return d;
    }
    
    public ArrayList<String> dn_getData(String dn_id) {
        ArrayList<String> d = new ArrayList<String>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            d = impl.dn_getData(dn_id);
            impl.sendHello("RMIConnector.dn_getData ..");
        } catch (Exception e) {
            d.removeAll(d);
            d = new ArrayList<String>();
        }
        return d;
    }
    
    public boolean isLogin(String user, String pass) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.getLogin(user, pass);
            impl.sendHello("RMIConnector.isLogin ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public boolean isLoginMerchant(String user, String pass) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.getLoginMerchant(user, pass);
            impl.sendHello("RMIConnector.isLoginMerchant ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public boolean addStaff(ArrayList<String> data) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.addStaff(data);
            impl.sendHello("RMIConnector.addStaff ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public boolean addMerchant(ArrayList<String> data) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.addMerchant(data);
            impl.sendHello("RMIConnector.addMerchant ..");
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    
    public String getNFCEncrypted(String txt) {
        String code = txt;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            code = impl.getNFCEncrypted(txt);
            impl.sendHello("RMIConnector.getNFCEncrypted ..");
        } catch (Exception e) {
            code = txt;
        }
        return code;
    }
    
    public int getPlusExample(int a, int b) {
        int c = 0;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            c = impl.getPlus(a, b);
            impl.sendHello("RMIConnector.getPlusExample ..");
        } catch (Exception e) {
            c = 0;
            J.o("Error!", "Error! Something wrong while execute the query!!\n" + e.getMessage(), 0);
            e.printStackTrace();
        }
        return c;
    }
    
    public boolean setQuery(String sql) {
        boolean status = false;
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            status = impl.setQuerySQL(sql);
            impl.sendHello("RMIConnector.setQuery ..");
        } catch (Exception e) {
            status = false;
            J.o("Error!", "Error! Something wrong while execute the query!!\n" + e.getMessage(), 0);
            e.printStackTrace();
        }
        return status;
    }
    
    public ArrayList<ArrayList<String>> getQuery(String sql) {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        try {
            Registry myRegistry = LocateRegistry.getRegistry(DBConn.getHost(), DBConn.getPort_rmi());
            Message impl = (Message) myRegistry.lookup("myMessage");
            data = impl.getQuerySQL(sql);
            impl.sendHello("RMIConnector.getQuery ..");
        } catch (Exception e) {
            data.removeAll(data);
            data = new ArrayList<ArrayList<String>>();
        }
        return data;
    }
    
//    public static void main(String[] args) {
//        try {
//            
//            RMIConnector rmic = new RMIConnector();
//            int a = 5;
//            int b = 12;
//            int c = rmic.getPlusExample(a, b);
//            System.out.println("c = "+c);
//            
//            String sql = "SELECT * FROM transaction ORDER BY tr_id DESC LIMIT 1";
//            ArrayList<ArrayList<String>> d = rmic.getQuery(sql);
//            System.out.println(d);
//            
//        } catch (Exception e) {
//        }
//    }
}
