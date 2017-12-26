package com.app.main.odoo.console;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by bima on 26/12/17.
 */

public class learn_xmlrpc {
    public static void main(String[] Args) throws XmlRpcException, MalformedURLException {
        String url = "http://localhost:8091"; // work with odoo.com account!!
        String db = "odoo11e_demo_test";
        String username = "admin";
        String password = "1";
        System.out.println("Get database list");
        System.out.println("Login");
        System.out.println("--------------");
        int uid = 0;
        try {
            uid = login(url,db,username,password);
        } catch (XmlRpcException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (uid <= 0) {
            System.out.println("Login Failed");
        }
        XmlRpcClient models = env(url, db, username, password);
        System.out.println(String.valueOf(uid));
        List<Object> partners = asList((Object[]) models.execute("execute_kw", asList(
                db, uid, password,
                "res.partner", "search",
                asList(asList(
                        asList("company_type", "=", "company"),
                        asList("customer", "=", true))),
                new HashMap() {{
                    put("offset", 10);
                    put("limit", 5);
                }}
        )));
        System.out.println(String.valueOf(partners.size()));
        for(int i=0; i<partners.size(); i++){
            System.out.println(partners.get(i).toString());
        }

    }

    static int login(String url, String db, String login, String password) throws XmlRpcException, MalformedURLException {
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setEnabledForExtensions(true);
        config.setServerURL(new URL(url+"/xmlrpc/2/common"));
        client.setConfig(config);
        //Connect
        //Object[] empty = null; // Ok
        //Object[] params = new Object[] {db,login,password, empty}; // Ok
        Object[] params = new Object[] {db,login,password}; // Ok & simple
        Object uid = client.execute("login", params);
        if (uid instanceof Integer)
            return (int) uid;
        return -1;
    }

    static XmlRpcClient env(String url, String db, String login, String password) throws XmlRpcException, MalformedURLException {
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setEnabledForExtensions(true);
        config.setServerURL(new URL(url+"/xmlrpc/2/object"));
        client.setConfig(config);
        return client;
    }
}
