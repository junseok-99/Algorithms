SELECT ID, (SELECT IF(PARENT_ID IS NULL, 0, COUNT(PARENT_ID)) FROM ECOLI_DATA WHERE PARENT_ID = A.ID) AS CHILD_COUNT
FROM ECOLI_DATA A
ORDER BY ID