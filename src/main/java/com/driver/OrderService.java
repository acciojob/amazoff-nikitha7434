package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    // added
    public void addOrderService(Order order){
        orderRepository.addOrderInRepository(order);
    }
    // get by indiviual
    public Order getODerByIdRepository(String id){
        return  orderRepository.getOrderByIdServices(id);
    }
    // get by order list
    public List<String> ListofOrderService(){
        return orderRepository.AllOrderServices();
    }



//partner
    //add
    public void addDeliveryDetailsService(String deliveryPartner){

        orderRepository.addDeliveryPartnerDetailsInHm(deliveryPartner);
    }
    //get
    public DeliveryPartner getDeliveryPartenerService(String id){
        return orderRepository.getDeliveryPartnerDetailsByIdResp(id);
    }


    //Get number of orders assigned to given partnerId:

    // add Pair
    public void PairOrderAndPartnerService(String orderid,String partnerId){
        orderRepository.PutOderAndpartenerHm(partnerId,partnerId);
    }
    public int OrderAssignByPatrenIdSerives(String partnerid){
        return  orderRepository.OrderAssignByPatrenIdRespo(partnerid);
    }
    public List<String> ListofordersBypartnerIdService(String id){
        return orderRepository.listOfOrdersByPartnerIdResp(id);
    }

    // Get count of orders which are not assigned to any partner:
    // GET /orders/get-count-of-unassigned-orders  No params or body
    // required  Return Integer wrapped in a ResponseEntity object 
    // Controller Name - getCountOfUnassignedOrders

public  int CountOfodresUnassingPartnerService(){
      return   orderRepository.CountOfOrderNotAssignPartnerRepo();
}

}
