SELECT email 
FROM Person
Group BY email
HAVING COUNT(email) > 1;