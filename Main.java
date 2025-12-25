
import deals.*;
import taxes.*;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("ООО Рога и Копыта", new TaxEarningsMinusSpendings());
        company.shiftMoney(100);
        company.shiftMoney(-50);
        company.shiftMoney(0);
        company.shiftMoney(3400);
        System.out.println("Налог: " + company.getTax());
        System.out.println(company.toString());
        company.setTaxSystem(new TaxEarnings());
        company.payTaxes();
        System.out.println(company.toString());

        Deal[] deals = {
                new Sale("Макароны", 100),
                new Sale("гречка", 1500),
                new Expenditure("Хлеб", 500),
                new Expenditure("Молоко", 1000)
        };

        System.out.println("Разница доходов и расходов, которая была на момент старта уплаты налогов:  "+ company.applyDeals(deals));

    }

}