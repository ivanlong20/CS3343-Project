import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeView {
    private ProductController productController;
    private HomeController controller;

    private OrderController orderController;
    private CartController cartController;
    private User currentUser;

    public HomeView(HomeController controller) {
        this.productController = new ProductController();
        this.orderController = new OrderController();
        this.cartController = new CartController();
        this.controller = controller;
    }

    public void currentUser(User user){
        this.currentUser = user;
    }

    public void customerHome(){
        System.out.println("Welcome to the customer home page");
        System.out.println("1. View products");
        System.out.println("2. View cart");
        System.out.println("3. View orders");
        System.out.println("4. Logout");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                this.productController.customerFilterView();
                customerHome();
                break;
            case 2:
                cartController.entryCartView();
                break;
            case 3:
                this.orderController.customerOrderView(currentUser);
                this.customerHome();
                break;
            case 4:
                return;
            case 9:
                this.customerHome();
                break;
            default:
                System.out.println("Invalid choice!");
                this.customerHome();
        }
    }


    public void adminHome() {
        System.out.println("Welcome to Admin page");
		System.out.println("1. Coupon Management");
		System.out.println("2. Product Management");
		System.out.println("3. Order Management");
		System.out.println("4. Delivery Management");
		System.out.println("5. Report");
		System.out.println("6. Exit");
		System.out.print("Please enter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int choice = -1;
		try{
			choice = scanner.nextInt();
		} catch(InputMismatchException e){
			invalidInput();
		}

        switch (choice) {
            case 1 -> {//coupon
                controller.showCouponView();
                adminHome();
            }
            case 2 ->{
                controller.showProductView();
                adminHome();
            }
            case 3 ->{//order
                controller.showOrderView();
                adminHome();
            } //order
            case 4 -> { //delivery
                controller.showDeliveryView();
                adminHome();
            }
            case 5 -> {//report
                controller.showReportView();
                adminHome();
            }
            case 6 ->{
                return;
            } //exit

            default -> {
                System.out.println("Invalid choice!");
                finishLine();
                adminHome();
            }
        }
		//scanner.close();

    }

    public void resultLine(){
		String line = new String(new char[48]).replace('\0', '-');
		System.out.println(line);
		System.out.println("Result:");
	}

	public void finishLine(){
		String line = new String(new char[48]).replace('\0', '-');
		System.out.println(line);
	}


    public void invalidInput() {
		resultLine();
		System.out.println("Please input a valid input");
		finishLine();
        backToEntry();
	}

    public void backToEntry(){
        if (currentUser.getRole().getRoleName() == "Customer"){
            customerHome();
        } else {
            adminHome();
        }
    }
}
