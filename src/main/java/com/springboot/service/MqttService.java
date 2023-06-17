package com.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Random;

@Service
public class MqttService {

    private static final String broker = "tcp://broker.emqx.io:1883";
    private String topic = null;
    private static final String mysqlHost = "localhost";
    private static final int mysqlPort = 3306;
    private static final String mysqlDatabase = "agriculture";
    private static final String mysqlUsername = "root";
    private static final String mysqlPassword = "0213ljh!";
    private static int startingId=21;

    private MqttClient client;

    public void start(String topic) {
        this.topic=topic;
        client = connectMqtt();
        subscribe(client);
        startMqttLoop(client);
    }

    private MqttClient connectMqtt() {
        try {
            String clientId = "test-client_" + getRandomString(4);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);

            MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());

            client.connect(options);
            System.out.println("Connected to MQTT Broker!");
            return client;
        } catch (MqttException e) {
            System.out.println("Failed to connect to MQTT Broker: " + e.getMessage());
            return null;
        }
    }

    private void subscribe(MqttClient client) {
        try {
            client.subscribe(topic);
            System.out.println("Subscribed to topic: " + topic);
        } catch (MqttException e) {
            System.out.println("Failed to subscribe to topic: " + e.getMessage());
        }
    }

    private void startMqttLoop(MqttClient client) {
        try {
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String json = new String(message.getPayload());
                    System.out.println("Received message payload: " + json);
                    saveToDatabase(json);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });

            while (true) {
                if (!client.isConnected()) {
                    client.reconnect();
                }
                Thread.sleep(1000); // 暂停1秒钟
            }
        } catch (MqttException | InterruptedException e) {
            System.out.println("An error occurred during MQTT loop: " + e.getMessage());
        }
    }



    private void saveToDatabase(String json) {
        try {
            // Establish database connection
            String url = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDatabase + "?useUnicode=true&characterEncoding=utf8";
            Connection conn = DriverManager.getConnection(url, mysqlUsername, mysqlPassword);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);
            String value=null;
            String sql=null;
            switch (this.topic){
                case "temperature":
                    value=jsonNode.get("tem").asText();
                    sql="INSERT INTO temperature (id, tem) VALUES (?, ?)";
                    break;
                case "air_humidity":
                    value=jsonNode.get("humidity").asText();
                    sql="INSERT INTO air_humidity (id, humidity) VALUES (?, ?)";
                    break;
                case "light_intensity":
                    value=jsonNode.get("light").asText();
                    sql="INSERT INTO light_intensity (id, light) VALUES (?, ?)";
                    break;
                case "soil_moisture":
                    value=jsonNode.get("moisture").asText();
                    sql="INSERT INTO soil_moisture (id, moisture) VALUES (?, ?)";
                    break;
                case "soil_ph":
                    value=jsonNode.get("ph").asText();
                    sql="INSERT INTO soil_ph (id, ph) VALUES (?, ?)";
                    break;
                default:
                    break;
            }
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, startingId); // 设置起始ID值
            stmt.setString(2, value);
            stmt.executeUpdate();
            System.out.println("Data inserted successfully!");
            startingId++;

            // Close the database connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to save data to database: " + e.getMessage());
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
