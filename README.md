# Getting Started

## How To Run Me
### Step1 - Using Maven
There are two options

* Using the Maven wrapper  <b><i>./mvnw</b></i> or <b><i>mvnw install</b></i> 
* Using the Maven client: <b><i>mvn</b></i> 

### Step2 - Install
At the top of the project run an install to download the relevant dependencies and compile the code  

<b><i>./mvnw install</b></i>

### Step3 - Insert Data File
Place your data file <b><i>ng_music_data.txt</b></i> into the <b><i>data</b></i> directory.

### Step4 - Setup SQL database
Ensure an SQL database is up and running with the following conditions:

* The database should be named <b><i>db_music_management</b></i> 
* There should be a user with:
  * Username <b><i>user0</b></i> 
  * Password <b><i>user0Password</b></i>
  * Granted all privileges
* Running on port <b><i>3306</b></i> 

### Step5 - Run
At the top of the project start spring boot which will run your jar, and any REST endpoints should be available at http://localhost:8080/{METHOD_NAME}

<b><i>./mvnw spring-boot:run</b></i>
