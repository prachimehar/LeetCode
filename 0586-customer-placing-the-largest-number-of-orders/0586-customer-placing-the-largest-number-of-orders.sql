SELECT customer_number FROM Orders GROUP BY customer_number
HAVING COUNT(*) = (
    SELECT COUNT(*) FROM Orders
    GROUP BY customer_number
    ORDER BY COUNT(*) DESC
    LIMIT 1 OFFSET 0
);
