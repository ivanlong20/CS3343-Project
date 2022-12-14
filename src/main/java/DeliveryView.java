import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryView {
    private DeliveryController controller;
    Scanner scanner = new Scanner(System.in);
    public DeliveryView(DeliveryController controller){
        this.controller = controller;
        
    }

    public void entryView(){
        System.out.println("Delivery Management Page");
        System.out.println("1. Modify Information of Delivery Items");
        System.out.println("2. Display Delivery Information by Delivery ID");
        System.out.println("3. Edit the price of Delivery");
        System.out.println("4. Delete Delivery Item");
        System.out.println("5. View All Delivery Items");
        System.out.println("6. Add Available Delivery Zone");
        System.out.println("7. Remove Existing Delivery Zone");
        System.out.println("8. Return");
        System.out.print("Please enter your choice: ");
        
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                modifyDeliveryInfoView();
                break;
            case 2:
                displayDeliveryInfoView();
                break;
            case 3:
                editDeliverySystemPriceView();
                break;
            case 4:
                deleteDeliveryView();
                break;
            case 5:
                viewAllDeliveryView();
                break;
            case 6:
                addDeliveryZoneView();
                break;
            case 7:
                removeDeliveryZoneView();
            break;
            case 8:
                break;
            default:
                System.out.print("Invalid choice!"+"\n");
        }
    }

    //1
    public void modifyDeliveryInfoView(){
        System.out.println("Please input Delivery ID: ");
        String deliveryID = scanner.next();
        System.out.println("Please input new Order ID of Delivery Item: ");
        String orderID = scanner.next();
        System.out.print("Please input new Zone of Delivery Item: \n");
        scanner.nextLine();
        String zone = scanner.nextLine();
        System.out.print("Please input new Address of Delivery Item: \n");
        String address = scanner.nextLine();
        System.out.print("Please input new Weight of Delivery Item: \n");
        double weight = Double.parseDouble(scanner.next());
        controller.editDeliveryInfo(deliveryID, orderID, zone, address, weight);
        this.entryView();
    }
    //2
    public void displayDeliveryInfoView(){
        System.out.println("Please input Delivery ID: ");
        String deliveryID = scanner.next();
        System.out.format("%10s|%10s|%20s|%50s|%6s\n", "Delivery ID", "Order ID", "Zone", "Address", "Delivery Fee");
        if(controller.findDelivery(deliveryID) != null){
            System.out.format("%10s %10s %20s %50s %f\n", controller.findDelivery(deliveryID).getDeliveryID(), controller.findDelivery(deliveryID).getOrderID(), 
            controller.findDelivery(deliveryID).getZone(), controller.findDelivery(deliveryID).getAddress(), controller.findDelivery(deliveryID).getDeliveryFee());
        }
        this.entryView();
    }
    //3
    public void editDeliverySystemPriceView(){
        System.out.println("Please input Delivery Price of First KG: ");
        double deliveryFirstKG_price = scanner.nextDouble();
        System.out.println("Please input Delivery Price after First KG: ");
        double deliveryAfterFirstKG_price = scanner.nextDouble();
        controller.editDeliverySystemPrice(deliveryFirstKG_price, deliveryAfterFirstKG_price);
        this.entryView();
    }
    //4
    public void deleteDeliveryView(){
        System.out.println("Please input Delivery ID of the item that you want to delete: ");
        String deliveryID = scanner.next();
        controller.deleteDelivery(deliveryID);
        this.entryView();
    }
    //5
    public void viewAllDeliveryView(){
        ArrayList<Delivery> dList = controller.getDeliveryList();
        System.out.format("%10s|%10s|%20s|%50s|%6s\n", "Delivery ID", "Order ID", "Zone", "Address", "Delivery Fee");
        for(Delivery d:dList){
            System.out.format("%10s %10s %20s %50s %f\n", d.getOrderID(), d.getOrderID(), d.getZone(), d.getAddress(), d.getDeliveryFee());
        }
        this.entryView();
    }
    //6
    public void addDeliveryZoneView(){
        System.out.println("Please input the new delivery zone that you want to add: ");
        String zone ="";
        zone= scanner.nextLine();
        zone+=scanner.nextLine();
        controller.addDeliveryZone(zone);
        this.entryView();
    }
    //7
    public void removeDeliveryZoneView(){
        System.out.println("Please input the new delivery zone that you want to remove: ");
        String zone ="";
        zone= scanner.nextLine();
        zone+=scanner.nextLine();
        controller.deleteDeliveryZone(zone);
        this.entryView();
    }

    public void printSuccess(){
        System.out.print("Success !"+"\n");
    }

}
