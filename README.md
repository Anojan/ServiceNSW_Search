# ServiceNSW_Search
service NSW branch locations search

Steps to consider for execution of this project:

1. Clone this repo to your local. (git clone <url>)
2. run "mvn clean install"
3. Download the latest Selenium Standalone Server file from http://docs.seleniumhq.org/download/. 
4. Set up Selenium hub machine: Open the Selenium grid hub by this command in terminal: "java -jar selenium-server-standalone-3.141.159.jar -role hub"
5. Set up Selenium node machine: Open the Selenium grid node by this command in terminal: "java -jar selenium-server-standalone-3.3.1.jar -role node -hub http://<your computer IP address>/grid/register -port 5555"  
4. Run the testng.xml file by right clicking there and run as testng or run from terminal as "mvn clean test".

