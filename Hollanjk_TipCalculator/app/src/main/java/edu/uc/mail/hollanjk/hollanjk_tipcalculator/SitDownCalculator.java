package edu.uc.mail.hollanjk.hollanjk_tipcalculator;

/**
 * Created by Jake on 2/29/2016.
 */
public class SitDownCalculator {
    private double preTaxTotal=0;
    private double grandTotal=0;
    private double tipRate = .18;
    private double tipAmount=0;
    private double totalBill=0;
    private boolean roundUp = false;

    public double excellentTipRate = .2;
    public double normalTipRate = .18;
    public double poorTipRate = .15;
    public double veryBadTipRate = 0;

    public void updateCalculator(){
        this.tipAmount = roundUpToPenny(this.tipRate * this.preTaxTotal);
        this.grandTotal = calcGrandTotal();
        if (this.roundUp){
            this.tipAmount += Math.ceil(this.grandTotal) - this.grandTotal;
            this.grandTotal = calcGrandTotal();
        }

    }

    private double calcGrandTotal(){
         return this.totalBill+this.tipAmount;
    }

    private double roundUpToPenny(double d){
        d = Math.ceil(d);
        d = d/100;
        return d;
    }

    public double getPreTaxTotal() {
        return preTaxTotal;
    }

    public void setPreTaxTotal(double preTaxTotal) {
        this.preTaxTotal = roundUpToPenny(preTaxTotal);
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = roundUpToPenny(grandTotal);

        calculateTipRate();
        updateCalculator();
    }

    private void calculateTipRate() {
        double taxes = this.totalBill - this.preTaxTotal;
        tipAmount = this.grandTotal - taxes - this.preTaxTotal;
        tipRate = this.preTaxTotal / this.tipAmount;
    }

    public double getTipRate() {
        return tipRate;
    }

    public void setTipRate(double tipRate) {
        this.tipRate = tipRate;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = roundUpToPenny(tipAmount);
        calculateTipRate();
        updateCalculator();
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = roundUpToPenny(totalBill);
    }

    public boolean isRoundUp() {
        return roundUp;
    }

    public void setRoundUp(boolean roundUp) {
        this.roundUp = roundUp;
    }


}
