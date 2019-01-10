                 ---------------------------------------------------README FILE FOR PHASE2------------------------------------------------------------
The starting steps will remain same as PHASE1 README FILE. After Step 4 follow new steps for PHASE2
				 
1. Get Google Map API Key

Steps to get google map api key are:
a. Go to Google Developer Maps URL to follow https://cloud.google.com/maps-platform/ 
   Click on Get Started button and in the dialog box select all three types of products. Then Press Continue.
b. In the next window, choose a project name and enter it in box. Click on Next Button.
c. Create a name for you billing project and press Continue. Fill in the appeared form with your contact data and payment information and click Next.
d. In this step you will get your API Key. In the present window, enable your APIs. Click on Next.
e. A new pop up window with API key will appear. Save the key to be able to use it and then press on Done.
f. Choosing GoogleMaps Services:
   Enable Direction API google map service.

USE THIS API KEY IN PLACES WHERE IT IS TYPED "YOUR API KEY" IN THE CODE FOR PHASE1

2. Get Weather API Key

Steps to get Weather API Key:
a. Go to OpenWeatherMap API
   URL to follow : https://openweathermap.org/appid#use
b. Now follow the instructions on website. First create a account by using Sing UP option.Follow the windows on the website.
c. API key will appear here : https://home.openweathermap.org/users/sign_in
   Need to Sign In after Sing UP to get Weather API key
   API KEY used here is to get current weather data.
   Current weather data – Access current weather data for any location.

3. Steps to Setup MAMP for localhost server.
a. Download MAMP application i.e exe file from this URL : https://www.mamp.info/en/downloads/
b. After this click on the exe file and start following window pop up to install MAMP on your system. I have used installed MAMP on Windows 10.
c. Now start MAMP and start the Apcahe and MySQL servers using Start Servers. These will appear on front screen when MAMP application will run.
d. Now the php server is required for PHASE1. The MYSQL server is used in PHASE2.
e. When clicked on Apache server it will start running.

4. Steps to run the CODE present in PHASE1 folder:
a. Place the file Phase1.php in the htdoc folder. This htdocs folder is present where you have installed MAMP. Mostly applications are in installed in C drive
Therefore Go to C Drive click on MAMP folder. Then this folder click on htdoc folder. Copy paste Phase1 folder in it.
b. To run the file "code_phase1.php" follow these steps:
   - Go to Google Chrome. Open New tab. 
   - In url area write: localhost/Phase1/Start_page.html
   - Enter the start and end location and click on submit button
   - This will direct user to code_pase1.php page where the waypoints and temperature is displayed.

5. Steps to connect Database and MYSQL to PHASE2:
a. Open MAMP application.Click on Open WebStart page. 
b. This will direct you to front page localhost server. The url will appear like this : localhost/MAMP/
c. Go to TOOLS → PHPMYADMIN
d. Step 1 – For creating a database, go to Databases
e. Step 2– provide database name databasename,select utf8_unicode_ci and click on Create
f. This will create the database and then you will get the following screen indicating empty tables.
g. Step 3 – Add a user account. For that Go to Server: Localhost:3306 → User accounts
h. Click on Add user account and ﬁll the information like below and click Go:
i. After following above steps your account will be step up.

6. Steps to run PHASE2 code:
   Copy the folder Phase2 and Paste it in htdocs folder of MAMP.
a. Open a dbConnection.php file.
b. Provide your servername,username,password and databasename.
c. Run this file in google chrome: localhost/Phase2/dbConnection.php
d. The database table is defined in this dbConnection.php file. On running this file an empty table will be created in your database.
e. To populate  this table run localhost/Phase2/Start_page.html and enter start and end location.
f. The values given by user and fetched from api calls will be stored in the table in respective columns.
g. Once populated with data. Next time any query is made by user the database will be checked.
    

   














						  