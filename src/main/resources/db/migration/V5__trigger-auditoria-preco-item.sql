
DELIMITER $$

CREATE TRIGGER trg_auditoria_preco_item
AFTER UPDATE ON itens
FOR EACH ROW
BEGIN
  IF OLD.preco <> NEW.preco THEN
    INSERT INTO auditoria_preco_item (item_id, preco_antigo, preco_novo, dt_alteracao)
    VALUES (OLD.item_id, OLD.preco, NEW.preco, CURRENT_TIMESTAMP);
  END IF;
END$$

DELIMITER ;
