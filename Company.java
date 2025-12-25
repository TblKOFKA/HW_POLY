import taxes.TaxSystem;
import deals.Deal;

public class Company {

    protected  String title;
    protected  int debit;
    protected  int credit;
    protected  TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem){
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }


    public void shiftMoney(int amount){
        if (amount > 0){
            this.debit += amount;
        } else if (amount < 0) {
            this.credit += Math.abs(amount);
        }
    }

    public int getTax(){
       return this.taxSystem.calcTaxFor(this.debit,this.credit);
    }

    @Override
    public String toString() {
        return "[" + this.title + ", доходы: " + this.debit + ", расходы: " + this.credit + ", налог: " + this.getTax() + " руб.]";
    }

    public void setTaxSystem(TaxSystem taxSystem){
        this.taxSystem = taxSystem;
    }

    public void payTaxes(){
        System.out.println("Компания " + this.title + " уплатила налог в размере: " + this.getTax() + " руб.");
        this.debit = 0;
        this.credit = 0;
    }

    public int applyDeals(Deal[] deals){

       for (int i = 0; i < deals.length; i++){
           this.credit += deals[i].creditChange;
           this.debit += deals[i].debitChange;
       }
        int diff = this.debit - this.credit;
        this.payTaxes();
        return diff;
    }
}