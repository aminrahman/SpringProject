DROP TABLE IF EXISTS T_PRINT_REQUEST;

CREATE TABLE T_PRINT_REQUEST
(
    C_IP_ADDRESS     VARCHAR(15) NOT NULL,
    C_BRANCH_CODE    VARCHAR(20) NOT NULL,
    C_PERSONNEL_CODE VARCHAR(20) NOT NULL,
    C_CARD_PAN       VARCHAR(16)
);