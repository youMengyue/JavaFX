package com.example.javafxhomwork;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;


public class JavaFXHomework extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*页面布局*/

//        总布局
        AnchorPane anchorPane = new AnchorPane();
//        anchorPane.setStyle("-fx-background-color:#1E90FF");

//        左上角布局1
        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setStyle("-fx-background-color:#F5FFFA");
        anchorPane1.setStyle("-fx-border-radius: 100px");
        anchorPane1.setStyle("-fx-border-color: #00FFFF");
        anchorPane1.setPrefWidth(185);
        anchorPane1.setPrefHeight(160);

//        右上角布局2
        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setStyle("-fx-background-color: #F5FFFA");
        anchorPane2.setStyle("-fx-border-color: #00FFFF");
        anchorPane2.setLayoutX(185);
        anchorPane2.setLayoutY(0);
        anchorPane2.setPrefWidth(480);
        anchorPane2.setPrefHeight(320);

//        左下角布局3
        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setStyle("-fx-background-color: #F5FFFA");
        anchorPane3.setStyle("-fx-border-color: #00FFFF");
        anchorPane3.setLayoutX(0);
        anchorPane3.setLayoutY(160);
        anchorPane3.setPrefWidth(185);
        anchorPane3.setPrefHeight(330);

//        右下角布局4
        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setStyle("-fx-background-color: #F5FFFA");
        anchorPane4.setStyle("-fx-border-color: #00FFFF");
        anchorPane4.setLayoutX(185);
        anchorPane4.setLayoutY(320);
        anchorPane4.setPrefWidth(480);
        anchorPane4.setPrefHeight(170);

//        AnchorPane anchorPane5 = new AnchorPane();
//        anchorPane5.setStyle("-fx-background-color: #D8BFD8");
//        anchorPane5.setLayoutX(185);
//        anchorPane5.setLayoutY(320);
//        anchorPane5.setPrefWidth(480);
//        anchorPane5.setPrefHeight(170);

        anchorPane.getChildren().addAll(anchorPane1,anchorPane2,anchorPane3,anchorPane4);

        /*布局1的内容设置*/

//        标签设置
        Label label1 = new Label("选择动作");
        label1.setStyle("-fx-font-size: 20");
        label1.setStyle("-fx-padding: 5");

//        按钮设置
        ToggleGroup toggleGroup =new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("查看已有名片");
        RadioButton radioButton2 =new RadioButton("添加新名片");
        radioButton2.setSelected(true);
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(radioButton1,radioButton2);
//        vBox1.setStyle("-fx-background-color: #D2691E");
        vBox1.setLayoutX(10);
        vBox1.setLayoutY(35);
        vBox1.setSpacing(30);
        vBox1.setPadding(new Insets(20));


        anchorPane1.getChildren().addAll(label1,vBox1);


        /*布局二的内容设置*/
        Label label2 = new Label("名片详细信息");
        label2.setStyle("-fx-font-size: 20");
        label2.setStyle("-fx-padding: 5");

        Label label3 = new Label("姓名");
        label3.setLayoutX(90);
        label3.setLayoutY(50);

        Label label4 = new Label("地址");
        label4.setLayoutX(90);
        label4.setLayoutY(100);

        Label label5 = new Label("联系地址");
        label5.setLayoutX(90);
        label5.setLayoutY(150);

        Label label6 = new Label("电子邮件");
        label6.setLayoutX(90);
        label6.setLayoutY(200);

        TextField textField = new TextField();
        textField.setLayoutX(185);
        textField.setLayoutY(50);

        TextField textField1 =new TextField();
        textField1.setLayoutX(185);
        textField1.setLayoutY(100);

        TextField textField2 =new TextField();
        textField2.setLayoutX(185);
        textField2.setLayoutY(150);

        TextField textField3 =new TextField();
        textField3.setLayoutX(185);
        textField3.setLayoutY(200);

        RadioButton radioButton3 = new RadioButton("爱好");
        radioButton3.setLayoutX(10);
        radioButton3.setLayoutY(265);
        radioButton3.setSelected(true);

        RadioButton radioButton4 = new RadioButton("学历");
        radioButton4.setLayoutX(100);
        radioButton4.setLayoutY(265);

        ToggleGroup toggleGroup1 =new ToggleGroup();
        radioButton3.setToggleGroup(toggleGroup1);
        radioButton4.setToggleGroup(toggleGroup1);
//        切换卡片事件绑定在后面

        Button button = new Button("添加");
        button.setLayoutX(205);
        button.setLayoutY(265);


        Button button1 = new Button("清空");
        button1.setLayoutX(355);
        button1.setLayoutY(265);
//        添加个监听

        anchorPane2.getChildren().addAll(label2,label3,label4,label5,label6);
        anchorPane2.getChildren().addAll(textField,textField1,textField2,textField3);
        anchorPane2.getChildren().addAll(radioButton3, radioButton4, button, button1);


        /*布局四的内容设置*/
        Label label7 = new Label("名片附加信息");
        label7.setStyle("-fx-font-size: 20");
        label7.setStyle("-fx-padding: 5");

        CheckBox checkBox = new CheckBox("唱歌");
        CheckBox checkBox1 = new CheckBox("跳舞");
        CheckBox checkBox2 = new CheckBox("上网");
        HBox hBox = new HBox(checkBox ,checkBox1, checkBox2);
//        hBox.setStyle("-fx-background-color: #0000FF");
        hBox.setLayoutX(25);
        hBox.setLayoutY(30);
        hBox.setSpacing(130);
        hBox.setPadding(new Insets(10));

        CheckBox checkBox3 = new CheckBox("足球");
        CheckBox checkBox4 = new CheckBox("篮球");
        CheckBox checkBox5 = new CheckBox("排球");
        HBox hBox1 = new HBox(checkBox3,checkBox4,checkBox5);
//        hBox1.setStyle("-fx-background-color: #0000FF");
        hBox1.setLayoutX(25);
        hBox1.setLayoutY(90);
        hBox1.setSpacing(130);
        hBox1.setPadding(new Insets(10));

        RadioButton radioButton5 = new RadioButton("学士");
        RadioButton radioButton6 = new RadioButton("硕士");
        RadioButton radioButton7 = new RadioButton("博士");
        RadioButton radioButton8 = new RadioButton("其他");

        ToggleGroup toggleGroup2 = new ToggleGroup();
        radioButton5.setToggleGroup(toggleGroup2);
        radioButton6.setToggleGroup(toggleGroup2);
        radioButton7.setToggleGroup(toggleGroup2);
        radioButton8.setToggleGroup(toggleGroup2);


        HBox hBox2 = new HBox(radioButton5, radioButton6, radioButton7, radioButton8);
//        hBox2.setStyle("-fx-background-color: #0000FF");
        hBox2.setLayoutX(25);
        hBox2.setLayoutY(60);
        hBox2.setSpacing(70);
        hBox2.setPadding(new Insets(10));

        anchorPane4.getChildren().addAll(label7,hBox,hBox1);

//        切换爱好和学历的事件绑定
        radioButton3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup1.getSelectedToggle() != null){
                    anchorPane4.getChildren().clear();
                    anchorPane4.getChildren().addAll(label7,hBox,hBox1);
                }
            }
        });

        radioButton4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup1.getSelectedToggle() != null) {
                    anchorPane4.getChildren().clear();
                    anchorPane4.getChildren().addAll(label7,hBox2);
                }
            }
        });



        /*布局三的内容设置*/
        Label label8 = new Label("名片列表");
        label8.setStyle("-fx-font-size: 20");
        label8.setStyle("-fx-padding: 5");

        ObservableList<String> observableList = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(observableList);
        listView.setItems(observableList);
        listView.setLayoutX(30);
        listView.setLayoutY(40);
        listView.setPrefWidth(125);
        listView.setPrefHeight(240);

//        添加按钮事件绑定
        ArrayList<Msg> arrayList = new ArrayList<>();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean sing = false;
                boolean dance = false;
                boolean web = false;
                boolean football = false;
                boolean basketball = false;
                boolean volleyball = false;
                boolean bachelor = false;
                boolean master = false;
                boolean doctor = false;
                boolean other = false;
                if (checkBox.isSelected()){
                    sing = checkBox.isSelected();
                }
                if (checkBox1.isSelected()){
                    dance = checkBox1.isSelected();
                }
                if (checkBox2.isSelected()){
                    web = checkBox2.isSelected();
                }
                if (checkBox3.isSelected()){
                    football = checkBox3.isSelected();
                }
                if (checkBox4.isSelected()){
                    basketball = checkBox4.isSelected();
                }
                if (checkBox5.isSelected()){
                    volleyball = checkBox5.isSelected();
                }
                if (radioButton5.isSelected()){
                    bachelor = radioButton5.isSelected();
                }
                if (radioButton6.isSelected()){
                    master = radioButton6.isSelected();
                }
                if (radioButton7.isSelected()){
                    doctor = radioButton7.isSelected();
                }
                if (radioButton8.isSelected()){
                    other = radioButton8.isSelected();
                }

                Msg msg = new Msg(textField.getText(), textField1.getText(), textField2.getText(),
                        textField3.getText(), sing, dance, web, football, basketball, volleyball,
                        bachelor, master, doctor, other);
                arrayList.add(msg);
                observableList.addAll(msg.getName());

                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                checkBox.setSelected(false);
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                checkBox4.setSelected(false);
                checkBox5.setSelected(false);
                radioButton5.setSelected(false);
                radioButton6.setSelected(false);
                radioButton7.setSelected(false);
                radioButton8.setSelected(false);

                radioButton3.setSelected(true);
                anchorPane4.getChildren().clear();
                anchorPane4.getChildren().addAll(label7,hBox,hBox1);
            }
        });

//        清空按钮的事件设置
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                checkBox.setSelected(false);
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                checkBox4.setSelected(false);
                checkBox5.setSelected(false);
                radioButton5.setSelected(false);
                radioButton6.setSelected(false);
                radioButton7.setSelected(false);
                radioButton8.setSelected(false);
            }
        });

//        布局1中按钮的编辑与不可编辑状态
        radioButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() != null){
                    textField.setDisable(true);
                    textField1.setDisable(true);
                    textField2.setDisable(true);
                    textField3.setDisable(true);
                    button.setDisable(true);
                    button1.setDisable(true);
                    checkBox.setDisable(true);
                    checkBox1.setDisable(true);
                    checkBox2.setDisable(true);
                    checkBox3.setDisable(true);
                    checkBox4.setDisable(true);
                    checkBox5.setDisable(true);
                    radioButton5.setDisable(true);
                    radioButton6.setDisable(true);
                    radioButton7.setDisable(true);
                    radioButton8.setDisable(true);
                }
            }
        });

        radioButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleGroup.getSelectedToggle() != null){
                    textField.setDisable(false);
                    textField1.setDisable(false);
                    textField2.setDisable(false);
                    textField3.setDisable(false);
                    button.setDisable(false);
                    button1.setDisable(false);
                    checkBox.setDisable(false);
                    checkBox1.setDisable(false);
                    checkBox2.setDisable(false);
                    checkBox3.setDisable(false);
                    checkBox4.setDisable(false);
                    checkBox5.setDisable(false);
                    radioButton5.setDisable(false);
                    radioButton6.setDisable(false);
                    radioButton7.setDisable(false);
                    radioButton8.setDisable(false);
                }
            }
        });

//        列表中点击返回信息
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                int i = (int)t1;
                Msg selectMsg = arrayList.get(i);
                textField.setText(selectMsg.getName());
                textField1.setText(selectMsg.getAddress1());
                textField2.setText(selectMsg.getAddress2());
                textField3.setText(selectMsg.getEmail());
                checkBox.setSelected(false);
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                checkBox4.setSelected(false);
                checkBox5.setSelected(false);
                if (selectMsg.getSing()){
                    checkBox.setSelected(true);
                }
                if (selectMsg.getDance()){
                    checkBox1.setSelected(true);
                }
                if (selectMsg.getWeb()){
                    checkBox2.setSelected(true);
                }
                if (selectMsg.getFootball()){
                    checkBox3.setSelected(true);
                }
                if (selectMsg.getBasketball()){
                    checkBox4.setSelected(true);
                }
                if (selectMsg.getVolleyball()){
                    checkBox5.setSelected(true);
                }
                if (selectMsg.getBachelor()){
                    radioButton5.setSelected(true);
                }
                if (selectMsg.getMaster()){
                    radioButton6.setSelected(true);
                }
                if (selectMsg.getDoctor()){
                    radioButton7.setSelected(true);
                }
                if (selectMsg.getOther()){
                    radioButton8.setSelected(true);
                }
            }
        });


        anchorPane3.getChildren().addAll(label8,listView);

        /*窗口基本设计*/
        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:icons/1.jpg"));
        primaryStage.setTitle("卡片信息管理");
        primaryStage.setWidth(680);
        primaryStage.setHeight(530);
        primaryStage.show();
    }
}
