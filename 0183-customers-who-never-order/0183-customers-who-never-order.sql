SELECT C.name AS Customers 
FROM Customers as C 
Left JOIN Orders O
ON C.id = O.customerId
WHERE O.customerId is null;


