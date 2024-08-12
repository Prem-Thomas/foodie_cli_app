package com.hosanna.foodiecliapp.util;

import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.model.Dish;
import com.hosanna.foodiecliapp.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
    private List<Dish> dishesList;

    public List<Customer> readCustomersFromCSV(){
        String CUSTOMERS_CSV_PATH ="C:\\Users\\erapo\\StephenThomas\\Food_App\\data\\customers.csv";
        String line;
        List<Customer> customersList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(CUSTOMERS_CSV_PATH))){
            String cvsSplitBy =",";
            br.readLine();
            while((line = br. readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Customer customer = new Customer();
                customer.setId(data[0])
                        .setName(data[1])
                        .setEmail(data[2])
                        .setPassword(data[3]);
                customersList.add(customer);
            }

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in Reading csv file from the Path :" + CUSTOMERS_CSV_PATH);
            System.exit(0);
        }
        return customersList;
    }



    public List<Dish> readDishesFromCSV(){
        String DISHES_CSV_PATH ="C:\\Users\\erapo\\StephenThomas\\Food_App\\data\\dishes.csv";
        String line;
        List<Dish> dishesList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))){
            String cvsSplitBy =",";
            br.readLine();
            while((line = br. readLine()) != null) {
                 String[] data = line.split(cvsSplitBy);
                 Dish dish = new Dish();
                 dish.setId(data[0])
                         .setName(data[1])
                         .setPrice(Double.parseDouble(data[3]))
                         .setDescription(data[2]);
                 dishesList.add(dish);
            }
            this.dishesList = dishesList;
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in Reading csv file from the Path :" + DISHES_CSV_PATH);
            System.exit(0);
        }
        return dishesList;
    }

    public List<Restaurant> readRestaurantsFromCSV(){
        String RESTAURANTS_CSV_PATH ="C:\\Users\\erapo\\StephenThomas\\Food_App\\data\\restaurants.csv";
        String line;
        List<Restaurant> restaurantsList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(RESTAURANTS_CSV_PATH))){
            String cvsSplitBy =",";
            br.readLine();
            while((line = br. readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0])
                        .setName(data[1])
                        .setAddress(data[2])
                        .setMenu(Arrays.asList(data[3].split(":")));
                restaurantsList.add(restaurant);
            }

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Issues in Reading csv file from the Path :" + RESTAURANTS_CSV_PATH);
            System.exit(0);
        }
        return restaurantsList;
    }
}
