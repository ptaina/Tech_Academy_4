DELIMITER $$
CREATE PROCEDURE inserir_usuarios(IN qtd INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  WHILE i <= qtd DO
    INSERT INTO usuarios (nome, email, senha)
    VALUES (CONCAT('Usuario', i), CONCAT('usuario', i, '@example.com'), 'senha123');
    SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;

CALL inserir_usuarios(10);
