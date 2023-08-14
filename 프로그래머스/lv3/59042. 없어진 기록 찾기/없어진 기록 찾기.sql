SELECT ANIMAL_ID, NAME 
FROM ANIMAL_OUTS
MINUS
SELECT ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
JOIN ANIMAL_OUTS
USING (ANIMAL_ID)
ORDER BY ANIMAL_ID;