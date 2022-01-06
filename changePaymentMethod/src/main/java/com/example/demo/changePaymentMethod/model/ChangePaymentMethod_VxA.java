package com.example.demo.changePaymentMethod.model;

import com.example.demo.dataBaseConfig.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangePaymentMethod_VxA {

    public ChangePaymentMethodOutput process(ChangePaymentMethodInput input) throws Exception {
        ChangePaymentMethodOutput cpmo = new ChangePaymentMethodOutput();
        String c_b_name = null;
        if (input.getPaymentMethod().equalsIgnoreCase("PO")) {
            Connection conn = Database.pickConnection();
            try {
                if (conn != null) {
                    Long cid = input.getCustomerId();
                    if (cid != null) {
                        long c_id = cid.longValue();
                        c_b_name = getBusiName(conn, c_id);
                    }
                } else {
                    throw new SQLException("Cannot Establish Connection");
                }
                String poId = input.getPoId();
                if ((poId != null) && (c_b_name != null)) {
                    Pov pov = new Pov();
                    LongWrapper wrapper = pov.call(poId, c_b_name);
                    wrapper.getValue().getClass();
                }
                if (conn != null) {
                    String c_payment_method = updateCPM(conn, input);
                    if (c_payment_method != null) {
                        cpmo.setCurrPaymentMethod(c_payment_method);
                    }
                } else {
                    throw new SQLException("Cannot Establish Connection");
                }
                conn.commit();
            } catch (SQLException e) {
                throw e;
            } finally {
                Database.relaseConnection(conn);
            }
        }
        System.gc();
        return cpmo;
    }

    public ChangePaymentMethodOutput hardCodeData(ChangePaymentMethodInput input) {
        ChangePaymentMethodOutput cpmo = new ChangePaymentMethodOutput();
     /*   input.setCreditInfo("This book has credit to charge");
        input.setCustomerId(11111111L);
        input.setPoId("Po_id");
        input.setThreadId(21212L);
        input.setPaymentMethod("Cash only");*/

        cpmo.setCurrPaymentMethod(input.getPaymentMethod());
        return cpmo;
    }

    private synchronized String updateCPM(final Connection conn, final ChangePaymentMethodInput input)
            throws SQLException {
        String cpm = null;
        String sql = "update customer SET" +
                " C_PAYMENT_METHOD= '" + input.getPaymentMethod() + "'," +
                " C_CREDIT_INFO= '" + input.getCreditInfo() + "'," +
                " C_PO= " + input.getPoId() +
                " where C_ID = " + input.getCustomerId();
        Statement stat = Database.createStatement(conn);
        stat.close();
        cpm = input.getPaymentMethod();
        return (cpm);
    }

    private synchronized String getBusiName(final Connection conn, long c_id) throws SQLException {
        String cbn = null;
        String sql = "select c_business_name from customer where c_id = " + c_id;
        Statement stat = Database.createStatement(conn);
        ResultSet rs = stat.executeQuery(sql);
        if (rs.next()) {
            cbn = rs.getString(1);
        }
        if (rs != null) {
            rs.close();
        }
        stat.close();
        return (cbn);
    }
}