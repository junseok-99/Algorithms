WITH MAX_COL_TABLE AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS DIFF_YEAR, MAX(SIZE_OF_COLONY) AS MAX_COLONY
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
)

SELECT M.DIFF_YEAR AS YEAR, (M.MAX_COLONY - E.SIZE_OF_COLONY) AS YEAR_DEV, E.ID
FROM ECOLI_DATA E JOIN MAX_COL_TABLE M
ON YEAR(E.DIFFERENTIATION_DATE)=M.DIFF_YEAR
ORDER BY M.DIFF_YEAR, YEAR_DEV;