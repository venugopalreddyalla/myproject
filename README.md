# REQUEST NAVIGATOR

    This Project Is Used To Take The Request's From Clients, And Generate Id's For Every Request And Displays That Id's To The Clients
    Client's Use That Request Id's To Navigate Their Request.

### TO RUN THE ABOVE PROJECT WE NEED THE FOLLOWING THINGS...

#### SOFTWARES

* We Need  One Server like Tomacat,WebLogic,WebSphear etc...
* We Need  One DataBase like Oracle,MySql...
* We Need Any IDE To Develop The Above Web Application like Eclipse,MyEclipse etc...
* We Need A Spring Software Latest Version 5.0.7

#### PROCEDURE

##### Step:1
* Create A Tabels In DataBase. The Tables Iinformations Has Given In Resources Folder Project_tbl.txt file.

##### Step:2
* Create A Maven Project With group id=org.inetsolv And artifactId=requestnavigator For Developping Web Application.
* Add All Dependencies In POM.xml file.
    1.Add Spring WebMvc dependencies In POM.xml.
    2.Add Spring JDBC dependencies In POM.xml.
    3.Add ojdbc6 dependencies In POM.xml etc... 
    
    If You Have A Dought In Adding Dependencies In Pom.xml, see resources Folder Pom.xml copy it And Paste In Your Pom.xml.

##### Step:3
* Create A Packages With The Names As Shown In Below In src/main/Java Folder In Project.
    1. org.inetsolv.controller
         Add All The java files Available In Controllers Folder Into It.
    2. org.inetsolv.service
         Add All The java files Available In services Folder Into It.
    3. org.inetsolv.repository
         Add All The java files Available In repository Folder Into It.
    4. org.inetsolv.domain
         Add All The java files Available In domain Folder Into It.
    5. org.inetsolv.util
         Add All The java files Available In Util Folder Into It.
    
##### Step:4
* Create Files With The Names As Shown In Below In src/main/resources Folder In Project.
    1.db.properties
        It Contains The Information To Interact With DataBase.
    2.errors.properties
        It Contains The Errors Information.
        
        Add The Content Into Above Two Files Form Resources Folder
        
##### Step:5
* Create A One ' jsps ' Folder In ' webapp ' Folder In Project.
    The Path Will Be Like This  ' src/main/webapp/jsps ' In Project
*  Add All The jsp files Available In jsps Folder Into It.

##### Step:6
* Start The server
* Type localhost:portnumber/requestnavigator/ In Browser.
* It Display Request Login Page
* To Update Request Information Type localhost:portnumber/requestnavigator/employee In Browser.
###### Note:
* When You Are Updating Request Information It Asks You Employee Id You Have To Give Employee Id.
* To Solve Above Problem Add One Employee Id In ' EMPLOYEE_INFO_TBL ' in Database.
* It Takes Employee Id From That Table Only. After That You Can Update Request Information.
 
         
         
         
         
         
         
         
         
         
         
         
         
         
         
