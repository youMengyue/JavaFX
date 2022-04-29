package com.example.javaexperiment2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class MangeDataBase extends Application {

    public static void main(String[] args) {
        launch(args);
    }

//    JDBC驱动加载初始化
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;



//    标签
    Label goodsIdLabel = new Label("商品号");
    Label goodsNameLabel = new Label("商品名");
    Label brandLabel = new Label("品牌");
    Label priceLabel = new Label("价格");
    Label inventoryLabel = new Label("库存量");


//        文本框
    TextField goodsIdTextField = new TextField();
    TextField goodsNameTextField = new TextField();
    TextField brandTextField = new TextField();
    TextField priceTextField = new TextField();
    TextField inventoryTextField = new TextField();



//    按钮
    Button firstButton = new Button("第一条");
    Button previousButton = new Button("前一条");
    Button nextButton = new Button("下一条");
    Button lastButton = new Button("最后一条");
    Button insertButton = new Button("插入");
    Button deleteButton = new Button("删除");
    Button updateButton = new Button("修改");


    @Override
    public void init() throws Exception {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webstore", "root", "wmz20204");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery("SELECT * FROM products");

            resultSet.first();
            goodsIdTextField.setText(resultSet.getString(1));
            goodsNameTextField.setText(resultSet.getString(2));
            brandTextField.setText(resultSet.getString(3));
            priceTextField.setText(resultSet.getString(4));
            inventoryTextField.setText(resultSet.getString(5));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {

        /*布局设计*/
//        根布局
        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.setStyle("-fx-background-color: #d4d");

//        文本框布局
        AnchorPane anchorPane1 = new AnchorPane();
//        anchorPane1.setStyle("-fx-background-color: rgba(65,32,187,0.97)");
        anchorPane1.setStyle("-fx-border-radius: 100px");
        anchorPane1.setStyle("-fx-border-color: #00FFFF");
        anchorPane1.setLayoutX(0);
        anchorPane1.setLayoutY(0);
        anchorPane1.setPrefWidth(660);
        anchorPane1.setPrefHeight(160);

//        按钮框布局
        AnchorPane anchorPane2 = new AnchorPane();
//        anchorPane2.setStyle("-fx-background-color: #d4d433");
        anchorPane2.setStyle("-fx-border-color: #00FFFF");
        anchorPane2.setLayoutX(0);
        anchorPane2.setLayoutY(160);
        anchorPane2.setPrefWidth(660);
        anchorPane2.setPrefHeight(130);

        anchorPane.getChildren().addAll(anchorPane1,anchorPane2);
        
        /*文本页面设计*/
        VBox vBox = new VBox();
//        vBox.setStyle("-fx-background-color: #a11111");
        vBox.setStyle("-fx-font-size: 15");
        vBox.setLayoutX(10);
        vBox.setLayoutY(10);
        vBox.setSpacing(30);
        vBox.getChildren().addAll(goodsIdLabel,brandLabel, inventoryLabel);


        VBox vBox1 = new VBox();
//        vBox1.setStyle("-fx-background-color: #d01093");
        vBox1.setStyle("-fx-font-size: 15");
        vBox1.setLayoutX(330);
        vBox1.setLayoutY(10);
        vBox1.setSpacing(30);
        vBox1.getChildren().addAll(goodsNameLabel, priceLabel);


        VBox vBox2 = new VBox();
//        vBox2.setStyle("-fx-font-size: 15");
        vBox2.setLayoutX(70);
        vBox2.setLayoutY(10);
        vBox2.setSpacing(25);
        vBox2.getChildren().addAll(goodsIdTextField, brandTextField, inventoryTextField);

        VBox vBox3 = new VBox();
//        vBox3.setStyle("-fx-font-size: 15");
        vBox3.setLayoutX(390);
        vBox3.setLayoutY(10);
        vBox3.setSpacing(25);
        vBox3.getChildren().addAll(goodsNameTextField, priceTextField);

        anchorPane1.getChildren().addAll(vBox, vBox1, vBox2, vBox3);

        /*Button按钮界面设计*/

        HBox hBox4 = new HBox();
        hBox4.setStyle("-fx-font-size: 15");
        hBox4.setLayoutX(10);
        hBox4.setLayoutY(40);
        hBox4.setSpacing(30);
        hBox4.getChildren().addAll(firstButton, previousButton, nextButton, lastButton, insertButton , deleteButton, updateButton);

        anchorPane2.getChildren().addAll(hBox4);

        /*按钮事件绑定处理*/
//        重设文本框内容


//        firstButton
        firstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    resultSet.first();
                    resetDetails();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

//        previousButton
        previousButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    resultSet.previous();
                    resetDetails();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

//        nextButton
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    resultSet.next();
                    resetDetails();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

//        lastButton
        lastButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    resultSet.last();
                    resetDetails();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

//        insertButton
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    resultSet.moveToInsertRow();
                    insert();
                    System.out.println("插入成功");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

//        deleteButton
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    resultSet.deleteRow();
                    System.out.println("删除成功");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

//        updateButton
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                update();
                System.out.println("修改成功");
            }
        });



        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:icons/1.png"));
        primaryStage.setTitle("Access the database");
        primaryStage.setWidth(675);
        primaryStage.setHeight(330);
        primaryStage.show();
    }

    private void resetDetails(){

        try {

            goodsIdTextField.setText(resultSet.getString(1));
            goodsNameTextField.setText(resultSet.getString(2));
            brandTextField.setText(resultSet.getString(3));
            priceTextField.setText(resultSet.getString(4));
            inventoryTextField.setText(resultSet.getString(5));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(){

        try {
            String goodsId = goodsIdTextField.getText();
            String goodsName = goodsNameTextField.getText();
            String brand = brandTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int inventory = Integer.parseInt(inventoryTextField.getText());

            resultSet.updateString(1, goodsId);
            resultSet.updateString(2, goodsName);
            resultSet.updateString(3, brand);
            resultSet.updateDouble(4, price);
            resultSet.updateInt(5, inventory);
            resultSet.insertRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(){


        try {
            String goodsId = goodsIdTextField.getText();
            String goodsName = goodsNameTextField.getText();
            String brand = brandTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int inventory = Integer.parseInt(inventoryTextField.getText());

            resultSet.updateString(1, goodsId);
            resultSet.updateString(2, goodsName);
            resultSet.updateString(3, brand);
            resultSet.updateDouble(4, price);
            resultSet.updateInt(5, inventory);
            resultSet.updateRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
