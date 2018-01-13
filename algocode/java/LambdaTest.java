import java.util.stream.*;
import java.util.*;

interface InvoicePredicate{
	boolean test(Invoice inv);

}

class Invoice{
	private int id;
	private int amount;
	private String customer;

	public int getAmount(){
		return amount;
	}

	public String getCustomer(){
		return customer;
	}

	public int getId(){
		return id;
	}

	public Invoice(int amount, String cust){
		this.amount=amount;
		this.customer=cust;
	}

	public Invoice(int id, int amount, String cust){
		this(amount, cust);
		this.id = id;
	}

	public String  toString(){
		return id+"::"+amount+"::"+customer;
	}

}

public class LambdaTest{

	static List<Invoice> findInvoice(List<Invoice> invoices, InvoicePredicate p){

		List<Invoice> result = new ArrayList<>();
		for(Invoice inv : invoices){
			if(p.test(inv)){
				result.add(inv);
			}
		}
		return result;
	}
	
	static void print(List<Invoice> l){
		System.out.println("List size:" + l.size());
	}

	static void printAll(List<? extends Object> l){
		System.out.println("-------");
		for(Object i: l){
				System.out.println(i);
			}
		System.out.println("-------");
	}

	public static void main(String s[]) throws Exception{
		List<Invoice> allInvoices = new ArrayList<Invoice>();

		allInvoices.add(new Invoice(100, "IBM"));			
		allInvoices.add(new Invoice(200, "Amazon"));
		allInvoices.add(new Invoice(300, "Microsoft"));
		allInvoices.add(new Invoice(59, "Oracle"));
		allInvoices.add(new Invoice(30, "Softbank"));

		
		List<Invoice> oracleInvoices = findInvoice(allInvoices, new InvoicePredicate(){
										public boolean test(Invoice inv){
											return inv.getCustomer().equalsIgnoreCase("Oracle");
										}
									});
		
		print(oracleInvoices);
		List<Invoice> highPriceInvoices = findInvoice(allInvoices, new InvoicePredicate(){

											public boolean test(Invoice inv){
												return inv.getAmount() > 100;
											}
									});

		print(highPriceInvoices);
		
		// ** Using lambda **
		List lowPriceInvoices = findInvoice(allInvoices, inv -> inv.getAmount()<100);
		print(lowPriceInvoices);
		
		//** sort **
		Collections.sort(allInvoices, (Invoice i1, Invoice i2)-> Integer.compare(i1.getAmount(), i2.getAmount()));
		printAll(allInvoices);

		// ** sort using internal sort **	
		allInvoices.sort((Invoice i1, Invoice i2)-> Integer.compare(i2.getAmount(), i1.getAmount()));
		printAll(allInvoices);

		// ** sort using new comparing object **
		Comparator<Invoice> byAmount = Comparator.comparing((Invoice inv) -> inv.getAmount());
		Comparator<Invoice> byAmountDesc = Comparator.comparing((Invoice inv) -> (-1)*inv.getAmount());
		
		allInvoices.sort(byAmount);
		printAll(allInvoices);

		// ** desc sort using comparing object **
		allInvoices.sort(byAmountDesc);
		printAll(allInvoices);

	
		allInvoices.sort(Comparator.comparingDouble(Invoice::getAmount));	
		printAll(allInvoices);
		allInvoices.sort(Comparator.comparing(Invoice::getCustomer));
		printAll(allInvoices);
	

		////////////////////////////////////////
		// S T R E A M S ///////////////////////
		////////////////////////////////////////

		List<Invoice> invWithIds = new ArrayList<>();			
		invWithIds.add(new Invoice(1,200,"Softel"));
		invWithIds.add(new Invoice(3,123,"Oracle"));
		invWithIds.add(new Invoice(4,245,"Avaya"));
		invWithIds.add(new Invoice(2,12,"Amdocs"));
		invWithIds.add(new Invoice(5,222,"MnM"));
		invWithIds.add(new Invoice(6,21,"ˆTectro"));
		invWithIds.add(new Invoice(13,112,"IBM"));
		

		List<Integer> idList = invWithIds.stream()
							.filter(inv -> inv.getAmount() > 50)
							.sorted(Comparator.comparingDouble(Invoice::getId))
							.map(Invoice::getId)
							.collect(Collectors.toList());

		printAll(idList);
		Double[] num = new Double[]{0.01, 1.03, 4.45, 5.0005, 12.3};	
		List<Double> nums = Arrays.asList(num);
		double sum = nums.stream().reduce(0.0, (a,b) -> a+b);
		
		System.out.println("Sum: "+sum);

	
		// ** make a custom stream **

		Stream<Invoice> gt100ACustInvs = invWithIds.stream().filter(inv -> inv.getAmount() > 100).filter(inv -> inv.getCustomer().startsWith("A"));

		// ** sort it **
		Stream sortedGt100ACust = gt100ACustInvs.sorted(Comparator.comparingDouble(Invoice::getAmount));
		
		// ** map it **
		//Stream<Integer> ids = sortedGt100ACust.map(Invoice::getId);

		// ** get first five **

		List<Integer> firstFiveInvs = invWithIds.stream().filter(inv -> inv.getAmount() > 100).sorted(Comparator.comparingDouble(Invoice::getAmount)).map(Invoice::getId).limit(3).collect(Collectors.toList());
		printAll(firstFiveInvs);
		
	
		List<Integer> firstFiveInvP = invWithIds.parallelStream().filter(inv -> inv.getAmount() >= 200).sorted(Comparator.comparingDouble(Invoice::getAmount)).map(Invoice::getId).limit(3).collect(Collectors.toList());
		printAll(firstFiveInvP);
		

}





}
