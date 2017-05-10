# FileStorageSysSpringBoot

Author: Yin Huang
Date: May 5, 2017

# This project implements a file storage system using Spring Boot + Thymeleaf

To enable the email function, you need speicfy your gmail account and password in application.properties file. 
Run the project, and go to localhost:8080 you will see the web app.


1. Upload A File: allows the user to upload multiple files to the server.
  (metadata will be saved in an in-memory DB while the files saved on the local system )

2. Files: returns the list of all files and their metadata
(Download link will enable the user to download the file)

3. Search: allows the user to search the files based on the meta data fileds
For example: 1.User Email 2. Poll scheduler to specify last integer hours

4. After searching retunrs results, there is a email button to send the result to your email

Warning: to enable email function, we use gmail stmp to set up the server, you need to change application.properties file 
username and password according to your account.

Classes:
1. File, with metadata as fields  (entity)
2. files  (repository)
3. controller (defines the logic of upload, get file, and download files)
4. fileservice (allows controller to access the functions of the repository)


Note:
1. metadata will be saved in an in-memory DB (H2 Database for development) and I am considering using a unique file ID as the key (the seraching functionn will be supported by the database)
2. getAllFilesInfo will read all entries in the database and show to the user

Credits:
1. Spring Boot Application:
    http://www.baeldung.com/spring-file-upload
    http://javasampleapproach.com/java-integration/upload-multipartfile-spring-boot
2. H2 database with Spring Boot: https://springframework.guru/spring-boot-web-application-part-3-spring-data-jpa/

3. Email support: http://dolszewski.com/spring/sending-html-mail-with-spring-boot-and-thymeleaf/


Warning: right now the create a new entry method doesn't check if the input form is empty or not, this needs validation

