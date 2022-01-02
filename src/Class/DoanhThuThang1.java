/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.text.DecimalFormat;

/**
 *
 * @author trisu
 */
public class DoanhThuThang1 {

    private String month;
    private long money;

    public DoanhThuThang1(String month, long money) {
        this.month = month;
        this.money = money;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

   

    public Object[] toArray() {
        DecimalFormat format = new DecimalFormat("###,###,###");
        String moneyString = format.format(money);
        return new Object[]{month, moneyString};
    }
}
