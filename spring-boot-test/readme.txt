1.Created Spring boot application
2.created TestController for Spring Boot Rest API
3.created cityConnected() method to read origin and destination values
4. URI:http://localhost:8080/connected?origin=Trenton&destination=Albany
5. Read the value and pass to other method to validate origin and destination
6. checkConnection method is read the city.txt file using ResourceLoader and get the files data
7. check the data in the city filw with Origin and destination and retrun YES  or NO
8. if both origin and destination combitnation is there then retrun YES else NO
9. Test case created to veriy with help of ResourceLoader. 