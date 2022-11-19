package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String,DeliveryPartner> DeliveryPartnerhm =new HashMap<>();
    HashMap<String,Order> OrderHm =new HashMap<>();
    HashMap<String,List<String>> PairHm =new HashMap<>();

    // order
    //add
    public void addOrderInRepository(Order order){
        OrderHm.put(order.getId(),order);

    }
    // get
    public Order getOrderByIdServices(String id){

        return OrderHm.get(id);
    }
//get all order
    public List<String> AllOrderServices(){

        List<String> listOforder =new ArrayList<>();

        for(String orId : OrderHm.keySet()){
            listOforder.add(orId);
        }
        return listOforder;

    }

//DeliveryDetails
    // add DeliveryDetails in HashMap
    public void addDeliveryPartnerDetailsInHm(String id) {
        DeliveryPartner deliveryPartner = new DeliveryPartner(id);
        DeliveryPartnerhm.put(id, deliveryPartner);

    }
    //get
    public DeliveryPartner getDeliveryPartnerDetailsByIdResp(String id){

        return DeliveryPartnerhm.get(id);
    }
    //putting
    public void PutOderAndpartenerHm(String partnerId,String orderId){

        if(PairHm.containsKey(partnerId)){

            PairHm.get(partnerId).add(orderId);
        }else{
        List<String> list =new ArrayList<>();
        list.add(orderId);
        PairHm.put(partnerId,list);
        }

    }

    public int OrderAssignByPatrenIdRespo(String  id){


        return PairHm.get(id).size();

    }

    public List<String> listOfOrdersByPartnerIdResp(String id){

        return PairHm.get(id);
    }


    public int CountOfOrderNotAssignPartnerRepo(){


        int count=0;


        for(String pid :PairHm.keySet()){

            List<String> OrId =PairHm.get(pid);

               for(String id :OrId){
                   if(!OrderHm.containsKey(id)){
                       count++;
                   }
               }

        }

        return count;
    }






}
