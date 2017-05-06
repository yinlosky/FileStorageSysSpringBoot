# FileStorageSysSpringBoot

Author: Yin Huang
Date: May 5, 2017

# This project implements a file storage system using Spring Boot
1. uploadFile: allows the user to upload multiple files to the server.
  (metadata will be saved in an in-memory DB while the files saved on the local system )

2. getAllFilesInfo: returns the list of all files and their metadata

3. downloadFile: allows the user to download the file they select

4. searchFile: allows the user to search the files based on the meta data fileds
For example: 1. file name 2. owner 3. creation time

5. latestFiles: returns the list of files uploaded in the latest one hour and sends an email to the administrator

Classes:
1. File, with metadata as fields  (entity)
2. files  (repository)
3. controller (defines the logic of upload, get file, and download files)
4. fileservice (allows controller to access the functions of the repository)


Note:
1. metadata will be saved in an in-memory DB (H2 Database for development) and I am considering using a unique file ID as the key (the seraching functionn will be supported by the database)
2. downloadFile function should accept a unique ID as parameter for downloading the file
3. getAllFilesInfo will read all entries in the database and show to the user
