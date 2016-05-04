#include <ESP8266WiFi.h>

const char* ssid     = "FRITZ!Box Fon WLAN 7360";
const char* password = "62884846722859294257";

const char* host = "192.168.178.34";
char* clientId = "photo1";
char* requestBody = "{ \"name\":\"%s\", \"weatherData\": { \"temperature\":\"%f\", \"humidity\":\"%f\" } }";

int delayInMillis = 10000;

void setup() {
  Serial.begin(115200);
  delay(10);

  // We start by connecting to a WiFi network

  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");  
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

int value = 0;

void loop() {
  delay(5000);
  ++value;

  Serial.print("connecting to ");
  Serial.println(host);
  
  // Use WiFiClient class to create TCP connections
  WiFiClient client;
  const int httpPort = 8080;
  if (!client.connect(host, httpPort)) {
    Serial.println("connection failed");
    return;
  }

  String url = "/devices";
  
  Serial.print("Requesting URL: ");
  Serial.println(url);

  //char* body = printf(requestBody, clientId, "90", "44");
  
  // This will send the request to the server
  client.print("POST " + url + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" + 
               "Connection: close\r\n" + 
               "Content-Type: application/json\r\n" +
               "Content-Length: 73\r\n" +
               "\r\n" +
               "{\"name\":\"node2\", \"weatherData\": { \"temperature\":\"33\", \"humidity\":\"55\" } }");
  unsigned long timeout = millis();
  while (client.available() == 0) {
    if (millis() - timeout > 8000) {
      Serial.println(">>> Client Timeout !");
      client.stop();
      return;
    }
  }
  
  // Read all the lines of the reply from server and print them to Serial
  while(client.available()){
    String line = client.readStringUntil('\r');
    Serial.print(line);
  }
  
  Serial.println();
  Serial.println("closing connection");
}